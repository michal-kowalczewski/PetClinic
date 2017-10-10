package com.tutki.PetClinic.Pet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "petDAO", eager = true)
public class PetDAO {
	String url = "jdbc:sqlserver://localhost;databaseName=PetClinic;integratedSecurity=true;";
	String sprawdzam = "sprawdzam";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	int updateSet;

	public List<Pet> getAll() {
		String query = "SELECT PetID, PetName, TypeName, Concat(OwnerFirstName,' ', OwnerLastName) as OwnerName\r\n"
				+ "From Pet\r\n" + "JOIN Type\r\n" + "On PetTypeId = TypeID\r\n" + "JOIN Owner\r\n"
				+ "On PetOwnerID = OwnerID;";
		List<Pet> petList = getFromQuery(query);
		return petList;
	}
	
	public List<Pet> getByOwner(Integer ownerId) {
		Integer key = ownerId;
		String query = "SELECT PetID, PetName, TypeName, Concat(OwnerFirstName,' ', OwnerLastName) as OwnerName\r\n" + 
				"From Pet \r\n" + 
				"JOIN Type \r\n" + 
				"On PetTypeId = TypeID\r\n" + 
				"JOIN Owner\r\n" + 
				"On PetOwnerID = OwnerID\r\n" + 
				"WHERE PetOwnerID = "+ key;
		List<Pet> petList = getFromQuery(query);
		return petList;
	}	

	public List<Pet> getFromQuery(String queryToExecute) {
		System.out.println(sprawdzam);
		List<Pet> petList = new ArrayList<Pet>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url);

			String query = queryToExecute;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Pet pet = new Pet(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				petList.add(pet);
			}
		} catch (Exception e) {
			System.out.println("dupa, nie dziala");
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return petList;
	}

	public HashMap<Integer, String> getMap() {
		List<Pet> petList = getAll();
		HashMap<Integer, String> map = (HashMap<Integer, String>) petList.stream()
				.collect(Collectors.toMap(Pet::getPetId, Pet::getPetOwner));
		return map;
	}

	public void insertPet(Pet pet) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url);

			String query = "Insert into Pet(PetName, PetTypeId, PetOwnerId) " + "VALUES ('" + pet.getPetName() + "', '"
					+ pet.getPetTypeId() + "', '" + pet.getPetOwnerId() + "');";
			stmt = con.createStatement();
			updateSet = stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}
}