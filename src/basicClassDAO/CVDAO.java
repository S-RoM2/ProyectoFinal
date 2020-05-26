package basicClassDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basicClassModel.DBConnect;

import basicClassModel.CVModel;

public class CVDAO {
	private DBConnect con;
	private Connection connection;
	
	public CVDAO() throws SQLException {
		con = new DBConnect();
	}
	
	public int Verify(int alumno_id) throws SQLException {
		String sql = "SELECT id FROM cv WHERE alumno_id= ?";
		con.conectar();
		connection = con.getJdbcConnection();
		
		try {
			PreparedStatement statementSelectLogin = connection.prepareStatement(sql);
			statementSelectLogin.setInt(1, alumno_id);
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

	public int InsertCV(int alumno_id) throws SQLException {
		String sql = "INSERT INTO cv (alumno_id) VALUES (?)";
		con.conectar();
		connection = con.getJdbcConnection();
		try {	
			PreparedStatement statementCV = connection.prepareStatement(sql);
			statementCV.setInt(1, alumno_id);
			statementCV.executeUpdate();
			statementCV.close();
			con.desconectar();
			return 1;
		} catch(Exception e) {
			con.desconectar();
			return -1;
		}
	}
	
	public int getIDCV(int alumno_id) throws SQLException {
		String sql = "SELECT id FROM cv WHERE alumno_id= "+alumno_id+"";
		int idCV = 0;
		con.conectar();
		connection = con.getJdbcConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resulSet = statement.executeQuery(sql);
			if (resulSet.next())
				idCV = resulSet.getInt(1);
			statement.close();
			con.desconectar();
			return idCV;
		} catch(Exception e) {
			con.desconectar();
			return -1;
		}		
	}
	
	public List<String> listarIdiomas(int id_cv) throws SQLException { 
		List<String> listaIdiomas = new ArrayList<String>();
		String sql;
		con.conectar();
		connection = con.getJdbcConnection();
		sql = "SELECT idioma FROM cv_idiomas WHERE id_cv="+id_cv+"";
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			String idioma = resulSet.getString("idioma");
			listaIdiomas.add(idioma);
		}
		resulSet.close();
		con.desconectar();
		return listaIdiomas;
	}
	
	public List<String> listarInformacion(int id_cv) throws SQLException { 
		List<String> listaInformacion = new ArrayList<String>();
		String sql;
		con.conectar();
		connection = con.getJdbcConnection();
		sql = "SELECT informacion FROM cv_informacion WHERE id_cv="+id_cv+"";
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			String informacion = resulSet.getString("informacion");
			listaInformacion.add(informacion);
		}
		resulSet.close();
		con.desconectar();
		return listaInformacion;
	}
	
	public List<String> listarCursos(int id_cv) throws SQLException { 
		List<String> listaCurso = new ArrayList<String>();
		String sql;
		con.conectar();
		connection = con.getJdbcConnection();
		sql = "SELECT curso FROM cv_cursos WHERE id_cv="+id_cv+"";
		
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			String curso = resulSet.getString("curso");
			listaCurso.add(curso);
		}
		resulSet.close();
		con.desconectar();
		return listaCurso;
	}
	
	public List<CVModel> listarTrabajos(int id_cv) throws SQLException {
		CVModel CV = null;
		List<CVModel> listaTrabajos = new ArrayList<CVModel>();
		String sql;
		sql = "SELECT trabajo, periodo, puesto FROM cv_trabajos WHERE id_cv="+id_cv+"";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet res = statement.executeQuery(sql);
		
		while (res.next()) {
			CV = new CVModel(0,0,0,"","","",
					res.getString("trabajo"), res.getString("periodo"), res.getString("puesto"));
			listaTrabajos.add(CV);
		}
		res.close();
		con.desconectar();
		return listaTrabajos;
	}
	
	public int GetNivelEstudios(int id_cv) throws SQLException { 
		String sql;
		con.conectar();
		connection = con.getJdbcConnection();
		sql = "SELECT nivelestudios FROM cv WHERE id="+id_cv+"";
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			int nivel = resulSet.getInt("nivelestudios");
			return nivel;
		}
		resulSet.close();
		con.desconectar();
		return 0;
	}
	
	public int UpdateNivelEstudios(int alumno_id, int nivel_estudios) throws SQLException {
		String sql;
		sql = "UPDATE cv SET nivelestudios="+nivel_estudios+" WHERE alumno_id ="+alumno_id+"";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		int resulSet = statement.executeUpdate(sql);
		statement.close();
		con.desconectar();
		return resulSet;
	}
	
	public int UpdateTrabajos(int idCV, String trabajo, String periodo, String puesto) throws SQLException {
		String sql2 = "INSERT INTO cv_trabajos (id_cv, trabajo, periodo, puesto) VALUES (?, ?, ?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		try {
				PreparedStatement statementCV = connection.prepareStatement(sql2);
				statementCV.setInt(1, idCV);
				statementCV.setString(2, trabajo);
				statementCV.setString(3, periodo);
				statementCV.setString(4, puesto);
				statementCV.executeUpdate();
				statementCV.close();	
				con.desconectar();
				return 1;
		} catch(Exception e) {
			con.desconectar();
			return -1;			
		}
	}
	
	public int UpdateIdioma(int idCV, String idioma) throws SQLException {
		String sql2 = "INSERT INTO cv_idiomas (id_cv, idioma) VALUES (?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		try {
				PreparedStatement statementCV = connection.prepareStatement(sql2);
				statementCV.setInt(1, idCV);
				statementCV.setString(2, idioma);
				statementCV.executeUpdate();
				statementCV.close();	
				con.desconectar();
				return 1;
		} catch(Exception e) {
			con.desconectar();
			return -1;			
		}
	}
	
	public int UpdateInformacion(int idCV, String informacion) throws SQLException {
		String sql2 = "INSERT INTO cv_informacion (id_cv, informacion) VALUES (?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		try {
				PreparedStatement statementCV = connection.prepareStatement(sql2);
				statementCV.setInt(1, idCV);
				statementCV.setString(2, informacion);
				statementCV.executeUpdate();
				statementCV.close();	
				con.desconectar();
				return 1;
		} catch(Exception e) {
			con.desconectar();
			return -1;			
		}
	}
}
