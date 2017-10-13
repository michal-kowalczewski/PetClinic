package com.tutki.PetClinic.Vet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VetDAO {
	String url = "jdbc:sqlserver://localhost;databaseName=PetClinic;integratedSecurity=true;";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	int updateSet;

	public List<Vet> getAll(){
		List<Vet> vetList = new ArrayList<Vet>();
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url);

			String query = "SELECT * FROM Vet";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Vet vet = new Vet(rs.getInt(1), rs.getString(2), rs.getString(3));
				vetList.add(vet);
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
		return vetList;
	}

	public void insertVet(Vet vet){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url);

			String query = "Insert into Vet(VetFirstName, VetLastName)"
					+ "VALUES ('" + vet.getVetFirstName() + "', '" + vet.getVetLastName() +"');";
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
	}
}