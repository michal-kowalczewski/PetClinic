package com.tutki.PetClinic.Owner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import globalVariables.GrowlView;

@ManagedBean(name="ownerDAO", eager = true)
@ApplicationScoped
public class OwnerDAO {
	String url = "jdbc:sqlserver://localhost;databaseName=PetClinic;integratedSecurity=true;";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	List<Owner> ownerList;
	int updateSet;
	
	private static Map<Integer, Owner> ownerMap;
	
	public Owner find (Integer ownerId) {
		return ownerMap.get(ownerId);
	}
	
	public List<Owner> list(){
		return new ArrayList<Owner>(ownerMap.values());
	}
	
	public Map<Integer, Owner> getMap(){
		return ownerMap;
	}
	
	public void parseToMap() {
		ownerMap = new LinkedHashMap<Integer, Owner>();
		for(int i=0; ownerList.size()<i ; i++)
		{
			ownerMap.put(ownerList.get(i).getOwnerId(), ownerList.get(i));
		}
	}

	public List<Owner> getAll(){
		ownerList = new ArrayList<Owner>();
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url);

			String query = "SELECT * from Owner";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Owner owner = new Owner(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
				ownerList.add(owner);
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
		return ownerList;
	}

	public void insertOwner(Owner owner){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url);

			String query = "Insert into Owner(OwnerFirstName, OwnerLastName, Address, City, Phone) "
					+ "VALUES ('" + owner.getOwnerFirstName() + "', '" + owner.getOwnerLastName() + "', '" + owner.getAddress() + "', '" + owner.getCity()+ "', '" + owner.getPhone()+ "');";
			stmt = con.createStatement();
			updateSet = stmt.executeUpdate(query);
			GrowlView gv = new GrowlView();
			gv.saveMessage();
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