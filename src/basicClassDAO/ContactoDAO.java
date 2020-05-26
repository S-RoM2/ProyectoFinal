package basicClassDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import java.sql.Statement;

import java.util.ArrayList;

import basicClassModel.DBConnect;
import basicClassModel.ContactoModel;

public class ContactoDAO {
	private DBConnect con;
	private Connection connection;
	
	public ContactoDAO() throws SQLException {
		con = new DBConnect();
	}
	
	public int InsertContacto(ContactoModel ContactoModel) throws SQLException {
		String sql = "INSERT INTO contacto (name, email, subject, message) VALUES (?,?,?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		try {	
			PreparedStatement statementCV = connection.prepareStatement(sql);
			statementCV.setString(1, ContactoModel.GetNombre());
			statementCV.setString(2, ContactoModel.GetEmail());
			statementCV.setString(3, ContactoModel.GetAsunto());
			statementCV.setString(4, ContactoModel.GetMensaje());
			statementCV.executeUpdate();
			statementCV.close();
			con.desconectar();
			return 1;
		} catch(Exception e) {
			con.desconectar();
			return -1;
		}
	}
	
	public int Update(int contacto_id) throws SQLException {
		String sql;
		sql = "UPDATE contacto SET status='YES' WHERE id ="+contacto_id+"";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		int resulSet = statement.executeUpdate(sql);
		statement.close();
		con.desconectar();
		return resulSet;
	}
	
	public List<ContactoModel> listarContactos() throws SQLException {
		 
		List<ContactoModel> listaContactos = new ArrayList<ContactoModel>();
		String sql;
		con.conectar();
		connection = con.getJdbcConnection();
		
		sql = "SELECT * FROM contacto WHERE status = 'NOT'";
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String nombre = resulSet.getString("name");
			String email = resulSet.getString("email");
			String asunto =resulSet.getString("subject");
			String mensaje =resulSet.getString("message");
			ContactoModel vacante = new ContactoModel(id, nombre, email, asunto, mensaje, null);
			listaContactos.add(vacante);
		}
		resulSet.close();
		con.desconectar();
		return listaContactos;
	}
}
