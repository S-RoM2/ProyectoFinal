package basicClassDAO;

import java.sql.*;
import basicClassModel.DBConnect;
import basicClassModel.BusinessModel;

public class BusinessDAO {
	private DBConnect con;
	private Connection connection;
	
	public BusinessDAO() throws SQLException {
		con = new DBConnect();
	}

	// GetBusinessByID
	public BusinessModel GetBusinessByID(int id) throws SQLException {
		BusinessModel Business = null;

		String sql = "SELECT * FROM empresa WHERE account_id= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			Business = new BusinessModel(null, null,
					res.getString("nombre"), res.getString("RFC"), res.getString("telefono"),
					res.getString("FAX"), res.getString("giro"), res.getString("descripcion"), res.getString("email"),
					res.getString("paginaweb"), res.getString("calle"), res.getString("delomun"), res.getInt("numero_int"),
					res.getInt("numero_ext"), res.getInt("cp"), res.getString("ciudad"));
		}
		res.close();
		con.desconectar();

		return Business;
	}
	
	public int GetBusinessIDByAccountID(int account_id) throws SQLException {
		String sql = "SELECT id FROM empresa WHERE account_id= ? ";
		int idEmpresa = 0;
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, account_id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			idEmpresa = res.getInt("id");
			res.close();
			con.desconectar();
			return idEmpresa;
		}
		res.close();
		con.desconectar();
		return 0;
	}
	
	// Insert Business
	public int InsertBusiness(BusinessModel business) throws SQLException {
		String sql = "INSERT INTO empresa (account_id, nombre, RFC, telefono, FAX, giro"
				+ ", descripcion, email, paginaweb, calle, delomun, numero_int, numero_ext"
				+ ", cp, ciudad) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		String sql_check = "SELECT id FROM empresa WHERE account_id= ?";
		String sql_check2 = "SELECT nombre FROM empresa WHERE nombre= ?";
		String sql_check3 = "SELECT id FROM account WHERE clave= ? and password=?";
		
		con.conectar();
		connection = con.getJdbcConnection();
		try {
			PreparedStatement statementSelectNombre = connection.prepareStatement(sql_check2);
			statementSelectNombre.setString(1, business.GetNombre());
			ResultSet result2 = statementSelectNombre.executeQuery();
			if (result2.next())
				return 4;
			int account_id = 0;
			PreparedStatement statementSelectAccountID = connection.prepareStatement(sql_check3);
			statementSelectAccountID.setString(1, business.GetClave());
			statementSelectAccountID.setString(2, business.GetPassword());
			ResultSet result3 = statementSelectAccountID.executeQuery();
			if (result3.next())
				account_id = result3.getInt("id");
			else
				return 2;
			statementSelectAccountID.close();
			PreparedStatement statementSelectClave = connection.prepareStatement(sql_check);
			statementSelectClave.setInt(1, account_id);
			ResultSet result = statementSelectClave.executeQuery();
			if (result.next())
				return 3;
			statementSelectClave.close();
			
			PreparedStatement statementBusiness = connection.prepareStatement(sql);
			statementBusiness.setInt(1, account_id);
			statementBusiness.setString(2, business.GetNombre());
			statementBusiness.setString(3, business.GetRFC());
			statementBusiness.setString(4, business.GetTelefono());
			statementBusiness.setString(5, business.GetFAX());
			statementBusiness.setString(6, business.Getgiro());
			statementBusiness.setString(7, business.Getdescripcion());
			statementBusiness.setString(8, business.GetEmail());
			statementBusiness.setString(9, business.Getpaginaweb());
			statementBusiness.setString(10, business.GetCalle());
			statementBusiness.setString(11, business.GetDeloMun());
			statementBusiness.setInt(12, business.GetNumero_Int());
			statementBusiness.setInt(13, business.GetNumero_Ext());
			statementBusiness.setInt(14, business.GetCP());
			statementBusiness.setString(15, business.GetCiudad());
			statementBusiness.executeUpdate();
			statementBusiness.close();
			con.desconectar();
			
			return 1;
		} catch(Exception e) {
			con.desconectar();
			return -1;
		}
	}
}