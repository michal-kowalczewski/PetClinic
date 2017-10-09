package globalVariables;

public class StaticVariables {
	public static String url = "jdbc:sqlserver://localhost;databaseName=PetClinic;user=MyUserName;password=*****;";
	public static String dialect = "com.microsoft.sqlserver.jdbc.SQLServerDriver2012";
	public static String insertLocation;
	
	public static String getInsertLocation() {
		return insertLocation;
	}
	
}
