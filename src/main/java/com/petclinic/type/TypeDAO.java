package com.petclinic.type;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="typeDAO", eager = true)
public class TypeDAO {
	String url = "jdbc:sqlserver://localhost;databaseName=PetClinic;integratedSecurity=true;";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	int updateSet;

	public List<Type> getAll(){
		List<Type> typeList = new ArrayList<Type>();
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url);

			String query = "SELECT * FROM TYPE";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Type type = new Type(rs.getInt(1), rs.getString(2));
				typeList.add(type);
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
		return typeList;
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