package basicClassModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    Connection jdbcConnection;
    public String jdbcURL;
    public String jdbcUsername;
    public String jdbcPassword;
    
    public DBConnect() {
		this.jdbcURL = "jdbc:mysql://185.236.231.203:3306/bolsa";
		this.jdbcUsername = "root";
		this.jdbcPassword = "12345";
	}

	public void conectar() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Driver not found."); 
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
       }
    }
     
    public void desconectar() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

	public Connection getJdbcConnection() {
		return jdbcConnection;
	}  
}
