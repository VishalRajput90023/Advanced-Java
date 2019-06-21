import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class databaseconnectivity {

	public static void main(String args[]) {
	System.out.println("......MYSQL JDBC CONNECTION TESTING....");
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(ClassNotFoundException e) {
		System.out.println("JDBC DRIVER not registered!!");
		e.printStackTrace();
		return;
	}
	System.out.println("JDBC DRIVER registered!!");
	Connection connection = null;
	
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3304/CRUD","root","");
	}
		catch(SQLException e) {
			System.out.println("Something is wrong try again!!");
			e.printStackTrace();
			return;
		}
	if(connection != null) {
		System.out.println("Success!!Connected to the database");
	}
	else {
		System.out.println("Could not connect!!");
	}
 }
}
