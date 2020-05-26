package basicClassDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import basicClassModel.DBConnect;
import basicClassModel.AccountModel;

public class LoginDAO {
	private DBConnect con;
	private Connection connection;

	
	public LoginDAO() throws SQLException {
		con = new DBConnect();
	}
	
	//Confirm Login
	public int Verify(AccountModel Account) throws SQLException {
		String sql = "SELECT id,clave,password FROM account WHERE clave= ? and password = ? and status='OK'";
		con.conectar();
		connection = con.getJdbcConnection();
		try {
			PreparedStatement statementSelectLogin = connection.prepareStatement(sql);
			statementSelectLogin.setString(1, Account.GetClave());
			statementSelectLogin.setString(2, Account.GetPassword());
			ResultSet result = statementSelectLogin.executeQuery();
			if (result.next())
			{
				int id = result.getInt("id");
				statementSelectLogin.close();
				return id;
			}
			return 0;
		} catch(Exception e) {
			con.desconectar();
			return -1;			
		}
	}
	
	public int IsAdmin(int id) throws SQLException {
		String GetAdmin = "SELECT web_admin FROM account WHERE id = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		try {
			PreparedStatement statementSelectType = connection.prepareStatement(GetAdmin);
			statementSelectType.setInt(1, id);
			ResultSet result = statementSelectType.executeQuery();
			if (result.next()) {
				int iAdmin = result.getInt("web_admin");
				statementSelectType.close();
				return iAdmin;
			}
			return 0;
		} catch(Exception e) {
			con.desconectar();
			return -1;				
		}		
	}
	
	public int UpdateAccountType(int iType, int id) throws SQLException {
		String sql;
		sql = "UPDATE account SET type="+iType+" WHERE id ="+id+"";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		int resulSet = statement.executeUpdate(sql);
		statement.close();
		con.desconectar();
		return resulSet;
	}
	
	public int GetAccountTypeByID(int id) throws SQLException {
		String GetTypeSQL = "SELECT type FROM account WHERE id = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		try {
			PreparedStatement statementSelectType = connection.prepareStatement(GetTypeSQL);
			statementSelectType.setInt(1, id);
			ResultSet result = statementSelectType.executeQuery();
			if (result.next()) {
				int iType = result.getInt("type");
				statementSelectType.close();
				return iType;
			}
			return 0;
		} catch(Exception e) {
			con.desconectar();
			return -1;				
		}
	}
}
