package basicClassDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import basicClassModel.DBConnect;
import basicClassModel.AlumnosModel;

public class AlumnosDAO {
	private DBConnect con;
	private Connection connection;
	
	public AlumnosDAO() throws SQLException {
		con = new DBConnect();
	}
	
	public int GetIDStudentByID(int id) throws SQLException {
		int alumno_id = 0;

		String sql = "SELECT * FROM alumnos WHERE account_id=? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			alumno_id = res.getInt("id");
		}
		res.close();
		con.desconectar();

		return alumno_id;
	}
	
	// GetAlumnoByID
	public AlumnosModel GetStudentByID(int id) throws SQLException {
		AlumnosModel Alumnos = null;

		String sql = "SELECT * FROM alumnos WHERE account_id= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			Alumnos = new AlumnosModel(res.getInt("id"), null, null,
					res.getString("nombre"), res.getString("apellido_p"), res.getString("apellido_m"),
					res.getString("telefono"), res.getString("Email"), res.getString("calle"), res.getString("ciudad"),
					res.getString("delomun"), res.getInt("cp"), res.getInt("numero_int"),
					res.getInt("numero_ext"));
		}
		res.close();
		con.desconectar();

		return Alumnos;
	}
	
	public int GetAccountIDByAccountID(int account_id) throws SQLException {
		String sql = "SELECT id FROM alumnos WHERE account_id= ? ";
		int idAlumno = 0;
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, account_id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			idAlumno = res.getInt("id");
			res.close();
			con.desconectar();
			return idAlumno;
		}
		res.close();
		con.desconectar();
		return 0;
	}
	
	public AlumnosModel GetStudentByIDVacant(int id) throws SQLException {
		AlumnosModel Alumnos = null;

		String sql = "SELECT * FROM alumnos WHERE id= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			Alumnos = new AlumnosModel(res.getInt("id"), null, null,
					res.getString("nombre"), res.getString("apellido_p"), res.getString("apellido_m"),
					res.getString("telefono"), res.getString("Email"), res.getString("calle"), res.getString("ciudad"),
					res.getString("delomun"), res.getInt("cp"), res.getInt("numero_int"),
					res.getInt("numero_ext"));
		}
		res.close();
		con.desconectar();

		return Alumnos;
	}
	
	// Listar todas las Solicitudes
	public List<AlumnosModel> listarSolicitudAlumno(int page, int vacante_id) throws SQLException {
		AlumnosModel Alumnos = null;
		List<AlumnosModel> listaSolicitud = new ArrayList<AlumnosModel>();
		String sql;
		sql = "SELECT T1.*, T2.vacante_id FROM alumnos T1 INNER JOIN vacante_solicitud T2 ON T1.id = T2.alumno_id WHERE T2.readed = 0 and T2.vacante_id ="+vacante_id+" LIMIT " +page+","+1;
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet res = statement.executeQuery(sql);
 
		while (res.next()) {
			Alumnos = new AlumnosModel(res.getInt("id"), null, null,
					res.getString("nombre"), res.getString("apellido_p"), res.getString("apellido_m"),
					res.getString("telefono"), res.getString("Email"), res.getString("calle"), res.getString("ciudad"),
					res.getString("delomun"), res.getInt("cp"), res.getInt("numero_int"),
					res.getInt("numero_ext"));
			listaSolicitud.add(Alumnos);
		}
		res.close();
		con.desconectar();
		return listaSolicitud;
	}
	
	public List<AlumnosModel> listarAllSolicitudAlumno(int page, int vacante_id) throws SQLException {
		AlumnosModel Alumnos = null;
		List<AlumnosModel> listaSolicitud = new ArrayList<AlumnosModel>();
		String sql;
		sql = "SELECT T1.*, T2.vacante_id FROM alumnos T1 INNER JOIN vacante_solicitud T2 ON T1.id = T2.alumno_id WHERE T2.vacante_id ="+vacante_id+" LIMIT " +page+","+1;
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet res = statement.executeQuery(sql);
 
		while (res.next()) {
			Alumnos = new AlumnosModel(res.getInt("id"), null, null,
					res.getString("nombre"), res.getString("apellido_p"), res.getString("apellido_m"),
					res.getString("telefono"), res.getString("Email"), res.getString("calle"), res.getString("ciudad"),
					res.getString("delomun"), res.getInt("cp"), res.getInt("numero_int"),
					res.getInt("numero_ext"));
			listaSolicitud.add(Alumnos);
		}
		res.close();
		con.desconectar();
		return listaSolicitud;
	}
	//Cantidad de valores
	public int PaginationAlumnos(int id_) throws SQLException {	
		String sql;
		if (id_ > 0)
			sql = "SELECT COUNT(*) FROM alumnos WHERE id ="+id_+"";
		else
			sql = "SELECT COUNT(*) FROM alumnos";
		int count = 0;
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		if (resulSet.next())
			count = resulSet.getInt(1);
		resulSet.close();
		con.desconectar();
		return count;
	}
	
	// Insert Alumno
	public int InsertAlumno(AlumnosModel alumno) throws SQLException {
		String sql = "INSERT INTO alumnos (account_id, nombre, apellido_p, apellido_m, telefono, email"
				+ ", calle, delomun, numero_int, numero_ext, cp, ciudad) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		String sql_check2 = "SELECT id FROM account WHERE clave= ? and password=?";
		String sql_check = "SELECT id FROM alumnos WHERE account_id= ?";
		con.conectar();
		connection = con.getJdbcConnection();
		try {
			int account_id = 0;
			PreparedStatement statementSelectAccountID = connection.prepareStatement(sql_check2);
			statementSelectAccountID.setString(1, alumno.GetClave());
			statementSelectAccountID.setString(2, alumno.GetPassword());
			ResultSet result2 = statementSelectAccountID.executeQuery();
			if (result2.next())
				account_id = result2.getInt("id");	
			else
				return 2;
			statementSelectAccountID.close();

			PreparedStatement statementSelectClave = connection.prepareStatement(sql_check);
			statementSelectClave.setInt(1, account_id);
			ResultSet result = statementSelectClave.executeQuery();
			if (result.next())
				return 3;
			statementSelectClave.close();
			
			PreparedStatement statementAlumnos = connection.prepareStatement(sql);
			statementAlumnos.setInt(1, account_id);
			statementAlumnos.setString(2, alumno.GetNombre());
			statementAlumnos.setString(3, alumno.GetApellidoP());
			statementAlumnos.setString(4, alumno.GetApellidoM());
			statementAlumnos.setString(5, alumno.GetTelefono());
			statementAlumnos.setString(6, alumno.GetEmail());
			statementAlumnos.setString(7, alumno.GetCalle());
			statementAlumnos.setString(8, alumno.GetDeloMun());
			statementAlumnos.setInt(9, alumno.GetNumero_Int());
			statementAlumnos.setInt(10, alumno.GetNumero_Ext());
			statementAlumnos.setInt(11, alumno.GetCP());
			statementAlumnos.setString(12, alumno.GetCiudad());
			statementAlumnos.executeUpdate();
			statementAlumnos.close();
			con.desconectar();
			return 1;
		} catch(Exception e) {
			con.desconectar();
			return -1;
		}
	}
}
