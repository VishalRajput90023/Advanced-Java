package crudpack;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MainApp {
	public static void main(String args[]) {
		Connection conn = null;
		Statement stmt = null;
		//Step 1:Register JDBC
	try {
      Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e) {
		System.out.println("JDBC not registered!!");
		return;
	}
	System.out.println("JDBC Registered!!");
	//Step 2:Connect to the database
	System.out.println("Connecting to the database...");
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3304/CRUD","root","");
	}catch(SQLException e) {
		System.out.println("MySql Database not connected!!");
	}
	if(conn != null) {
		System.out.println("SUCCESS!! Connected to the database");
	}
	//Step 3:Creating a table
	System.out.println("Deletion into a table...");
	try {
	stmt = conn.createStatement();
	String sql = "DELETE FROM students WHERE id=2";
	stmt.executeUpdate(sql);
	}catch(SQLException e) {
		System.out.println("Record cannot be deleted!!");
		return;
	}		
	System.out.println("Sucessfully deleted the record!!");
  }
}
