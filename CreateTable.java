//Creating a table
import java.sql.*;
import java.sql.DriverManager;
public class creatingatable{

	public static void main(String args[]) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//Step 2:Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//Step 3:open a connection to our database
			System.out.println("Connecting to the selected database");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3304/javarocks","root","");
			//Step 4: Executing the query
			System.out.println("Creating the required table....");
			stmt = conn.createStatement();
			String sql = "CREATE TABLE students(id INTEGER not NULL,"
					+ "first VARCHAR(255),"
					+ "last VARCHAR(255),"
					+ "age INTEGER,"
					+ "PRIMARY KEY(id))";
			stmt.executeUpdate(sql);
			System.out.println("Record Inserted!!");
		}catch(SQLException se) {
			//Handle JDBC errors
			se.printStackTrace();
		}catch(Exception e) {
			//Handle errors for class name
			e.printStackTrace();
		}finally {
			//Close the resources
			try {
				if(stmt!=null)
				  conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
