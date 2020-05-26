package basicClassDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import basicClassModel.AccountModel;
import basicClassModel.DBConnect;

public class AccountDAO {
	private DBConnect con;
	private Connection connection;
	
	public AccountDAO() throws SQLException {
		con = new DBConnect();
	}
	
	public int UpdateSuspendAccount(int id) throws SQLException {
		String sql;
		sql = "UPDATE account SET status='NOT' WHERE id ="+id+"";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		int resulSet = statement.executeUpdate(sql);
		statement.close();
		con.desconectar();
		return resulSet;
	}
	
	public int UpdatePassword(int id, String password) throws SQLException {
		String sql;
		sql = "UPDATE account SET password='"+password+"' WHERE id ="+id+"";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		int resulSet = statement.executeUpdate(sql);
		statement.close();
		con.desconectar();
		return resulSet;
	}
	
	public int UpdateEmail(int id, String email, int iType) throws SQLException {
		String sql;
		if (iType > 1)
			sql = "UPDATE empresa SET email='"+email+"' WHERE account_id ="+id+"";
		else
			sql = "UPDATE alumnos SET email='"+email+"' WHERE account_id ="+id+"";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		int resulSet = statement.executeUpdate(sql);
		statement.close();
		con.desconectar();
		return resulSet;
	}
	
	public int UpdateNombre(int id, String nombre, int iType) throws SQLException {
		String sql;
		if (iType > 1)
			sql = "UPDATE empresa SET nombre='"+nombre+"' WHERE account_id ="+id+"";
		else
			sql = "UPDATE alumnos SET nombre='"+nombre+"' WHERE account_id ="+id+"";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		int resulSet = statement.executeUpdate(sql);
		statement.close();
		con.desconectar();
		return resulSet;
	}
	
	public int UpdateTelefono(int id, String telefono, int iType) throws SQLException {
		String sql;
		if (iType > 1)
			sql = "UPDATE empresa SET telefono='"+telefono+"' WHERE account_id ="+id+"";
		else
			sql = "UPDATE alumnos SET telefono='"+telefono+"' WHERE account_id ="+id+"";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		int resulSet = statement.executeUpdate(sql);
		statement.close();
		con.desconectar();
		return resulSet;
	}
	
	public int Updatedescripcion(int id, String descripcion, int iType) throws SQLException {
		String sql;
		sql = "UPDATE empresa SET descripcion='"+descripcion+"' WHERE account_id ="+id+"";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		int resulSet = statement.executeUpdate(sql);
		statement.close();
		con.desconectar();
		return resulSet;
	}
	
	public int UpdateDireccion(int id, String calle, String ciudad, String DeloMun, int CP, int numero_int, int numero_ext, int iType) throws SQLException {
		String sql;
		if (iType > 1)
			sql = "UPDATE empresa SET calle='"+calle+"', ciudad='"+ciudad+"',delomun='"+DeloMun+"',cp='"+CP+"',numero_int='"+numero_int+"',numero_ext='"+numero_ext+"' WHERE account_id ="+id+"";
		else
			sql = "UPDATE alumnos SET calle='"+calle+"', ciudad='"+ciudad+"',delomun='"+DeloMun+"',cp='"+CP+"',numero_int='"+numero_int+"',numero_ext='"+numero_ext+"' WHERE account_id ="+id+"";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		int resulSet = statement.executeUpdate(sql);
		statement.close();
		con.desconectar();
		return resulSet;
	}
	
	public int InsertAccount(AccountModel alumno, int iTipo) throws SQLException {	
		String sql_account = "INSERT INTO account (clave, password, type) VALUES (?,?, ?)";
		String sql_check = "SELECT clave FROM account WHERE clave= ?";
		con.conectar();
		connection = con.getJdbcConnection();
		try {
			PreparedStatement statementSelectClave = connection.prepareStatement(sql_check);
			statementSelectClave.setString(1, alumno.GetClave());
			ResultSet result = statementSelectClave.executeQuery();
			if (result.next())
				return 2;
			statementSelectClave.close();
			
			PreparedStatement statementAlumnosAccount = connection.prepareStatement(sql_account);
			statementAlumnosAccount.setString(1, alumno.GetClave());
			statementAlumnosAccount.setString(2, alumno.GetPassword());
			statementAlumnosAccount.setInt(3, iTipo);
			statementAlumnosAccount.executeUpdate();
			statementAlumnosAccount.close();	

			con.desconectar();
			return 1;
		} catch(Exception e) {
			con.desconectar();
			return -1;
		}
	}
}
