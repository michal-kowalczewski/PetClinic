package com.tutki.PetClinic.Visit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VisitDAO {
	String url = "jdbc:sqlserver://localhost;databaseName=PetClinic;integratedSecurity=true;";
	String sprawdzam = "sprawdzam";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	int updateSet;

	public List<Visit> getAll(){
		System.out.println(sprawdzam);
		List<Visit> visitList = new ArrayList<Visit>();
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url);

			String query = "SELECT VisitID, PetName, TypeName, Concat(OwnerFirstName,' ', OwnerLastName) as OwnerName, CONCAT(VetFirstName, ' ', VetLastName) as VetName, VisitDate\r\n" + 
					"From Visit\r\n" + 
					"Join Pet\r\n" + 
					"On VisitPetID = PetID\r\n" + 
					"JOIN Type\r\n" + 
					"On PetTypeId = TypeID\r\n" + 
					"JOIN Owner\r\n" + 
					"On PetOwnerID = OwnerID\r\n" + 
					"JOIN Vet\r\n" + 
					"On VisitVetID = VetID;";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Visit visit = new Visit(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				visitList.add(visit);
			}
		}
		catch (Exception e) {  
			System.out.println("dupa, nie dziala");
			e.printStackTrace();  
		}  
		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {}  
		} 
		return visitList;
	}
/*
	public void insertUser(Pet owner){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url);

			String query = "Insert into Users(UserName, UserPassword, UserDescription) "
					+ "VALUES ('" + owner.getOwnerFirstName() + "', '" + owner.getOwnerLastName() + "', '" + owner.getAddress() + "', '" + owner.getCity()+ "', '" + owner.getPhone()+ "');";
			stmt = con.createStatement();
			updateSet = stmt.executeUpdate(query);
		}
		catch (Exception e) {  
			e.printStackTrace();  
		}
		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {}  
		} 
	}*/
}