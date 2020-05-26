package basicClassDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

import basicClassModel.VacanteModel;
import basicClassModel.DBConnect;

public class VacantesDAO {
	private DBConnect con;
	private Connection connection;
	
	public VacantesDAO() throws SQLException {
		con = new DBConnect();
	}

	// Return Vacante por ID
	public VacanteModel GetVacantByID(int vacant_id) throws SQLException {
		//String sql = "SELECT * FROM vacantes WHERE active='OK' and vacante_id = ?";
		String sql ="SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa and T1.vid = ?";
		VacanteModel vacante = null;
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, vacant_id);
		ResultSet resulSet = statement.executeQuery();
		if (resulSet.next()) {
			int id = resulSet.getInt("vid");
			String nombrevacante = resulSet.getString("nombrevacante");
			String requisitos = resulSet.getString("requisitos");
			String descripcion = resulSet.getString("descripcion");
			int Sueldo = resulSet.getInt("Sueldo");
			int horario = resulSet.getInt("horario");
			int tipocontratacion = resulSet.getInt("tipocontratacion");
			int idEmpresa = resulSet.getInt("idEmpresa");
			String status = resulSet.getString("status");
			String nombre_contacto = resulSet.getString("nombre_contacto");
			String apellido_p_contacto = resulSet.getString("apellido_p_contacto");
			String apellido_m_contacto = resulSet.getString("apellido_m_contacto");
			String nombre_empresa = resulSet.getString("nombre");
			vacante = new VacanteModel(id, nombrevacante, requisitos, descripcion, Sueldo, horario, tipocontratacion,
					idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto, nombre_empresa);
		}
		resulSet.close();
		con.desconectar();
		return vacante;
	}
	
	/*******************************/
	/* Listar vacantes por filtros */
	/*******************************/
	
	public List<VacanteModel> listarVacantesByNameAndContratacionAndHorario(int page, int id_, int iType, String name, int contratacion, int horario2) throws SQLException { 
		List<VacanteModel> listaVacantes = new ArrayList<VacanteModel>();
		String sql;
		String sql_check;
		String sql2;
		String sql3;
		con.conectar();
		connection = con.getJdbcConnection();
		if (iType > 0)
		{
			//sql = "SELECT * FROM vacantes WHERE active='OK' and idEmpresa = "+id_+" LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T2.nombre = '"+name+"' and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa and T1.idEmpresa = "+id_+" LIMIT " +page+","+5;
			sql2 = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.tipocontratacion = '"+contratacion+"' and T2.nombre != '"+name+"' and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa and T1.idEmpresa = "+id_+" LIMIT " +page+","+5;
			sql3 = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.horario = '"+horario2+"' and T2.nombre != '"+name+"' or  T1.tipocontratacion != '"+contratacion+" and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa and T1.idEmpresa = "+id_+" LIMIT " +page+","+5;
		}else {
			//sql = "SELECT * FROM vacantes WHERE active='OK' and status='OK' LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T2.nombre = '"+name+"' and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa LIMIT " +page+","+5;
			sql2 = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.tipocontratacion = '"+contratacion+"' and T2.nombre != '"+name+"' and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa LIMIT " +page+","+5;
			sql3 = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.horario = '"+horario2+"' and T2.nombre != '"+name+"' or  T1.tipocontratacion != '"+contratacion+" and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa LIMIT " +page+","+5;
		}
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			int id = resulSet.getInt("vid");
			String nombrevacante = resulSet.getString("nombrevacante");
			String requisitos = resulSet.getString("requisitos");
			String descripcion = resulSet.getString("descripcion");
			int Sueldo = resulSet.getInt("Sueldo");
			int horario = resulSet.getInt("horario");
			int tipocontratacion = resulSet.getInt("tipocontratacion");
			int idEmpresa = resulSet.getInt("idEmpresa");
			String status = resulSet.getString("status");
			String nombre_contacto = resulSet.getString("nombre_contacto");
			String apellido_p_contacto = resulSet.getString("apellido_p_contacto");
			String apellido_m_contacto = resulSet.getString("apellido_m_contacto");
			String nombre_empresa = resulSet.getString("nombre");
			VacanteModel vacante = new VacanteModel(id, nombrevacante, requisitos, descripcion, Sueldo, horario, tipocontratacion,
					idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto, nombre_empresa);
			if(iType < 1)
			{
				sql_check = "SELECT id FROM vacante_solicitud WHERE alumno_id="+id_+" and vacante_id="+id+"";
				Statement statementSelectVacant = connection.createStatement();
				ResultSet result = statementSelectVacant.executeQuery(sql_check);
				if (!result.next())
				{
					listaVacantes.add(vacante);
				}
				statementSelectVacant.close();
			}else {
				listaVacantes.add(vacante);
			}
		}
		resulSet.close();
		
		
		Statement statement2 = connection.createStatement();
		ResultSet resulSet2 = statement2.executeQuery(sql2);
 
		while (resulSet2.next()) {
			int id = resulSet2.getInt("vid");
			String nombrevacante = resulSet2.getString("nombrevacante");
			String requisitos = resulSet2.getString("requisitos");
			String descripcion = resulSet2.getString("descripcion");
			int Sueldo = resulSet2.getInt("Sueldo");
			int horario = resulSet2.getInt("horario");
			int tipocontratacion = resulSet2.getInt("tipocontratacion");
			int idEmpresa = resulSet2.getInt("idEmpresa");
			String status = resulSet2.getString("status");
			String nombre_contacto = resulSet2.getString("nombre_contacto");
			String apellido_p_contacto = resulSet2.getString("apellido_p_contacto");
			String apellido_m_contacto = resulSet2.getString("apellido_m_contacto");
			String nombre_empresa = resulSet2.getString("nombre");
			VacanteModel vacante = new VacanteModel(id, nombrevacante, requisitos, descripcion, Sueldo, horario, tipocontratacion,
					idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto, nombre_empresa);
			if(iType < 1)
			{
				sql_check = "SELECT id FROM vacante_solicitud WHERE alumno_id="+id_+" and vacante_id="+id+"";
				Statement statementSelectVacant = connection.createStatement();
				ResultSet result = statementSelectVacant.executeQuery(sql_check);
				if (!result.next())
				{
					listaVacantes.add(vacante);
				}
				statementSelectVacant.close();
			}else {
				listaVacantes.add(vacante);
			}
		}
		resulSet2.close();
		
		Statement statement3 = connection.createStatement();
		ResultSet resulSet3 = statement3.executeQuery(sql3);
 
		while (resulSet3.next()) {
			int id = resulSet3.getInt("vid");
			String nombrevacante = resulSet3.getString("nombrevacante");
			String requisitos = resulSet3.getString("requisitos");
			String descripcion = resulSet3.getString("descripcion");
			int Sueldo = resulSet3.getInt("Sueldo");
			int horario = resulSet3.getInt("horario");
			int tipocontratacion = resulSet3.getInt("tipocontratacion");
			int idEmpresa = resulSet3.getInt("idEmpresa");
			String status = resulSet3.getString("status");
			String nombre_contacto = resulSet3.getString("nombre_contacto");
			String apellido_p_contacto = resulSet3.getString("apellido_p_contacto");
			String apellido_m_contacto = resulSet3.getString("apellido_m_contacto");
			String nombre_empresa = resulSet3.getString("nombre");
			VacanteModel vacante = new VacanteModel(id, nombrevacante, requisitos, descripcion, Sueldo, horario, tipocontratacion,
					idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto, nombre_empresa);
			if(iType < 1)
			{
				sql_check = "SELECT id FROM vacante_solicitud WHERE alumno_id="+id_+" and vacante_id="+id+"";
				Statement statementSelectVacant = connection.createStatement();
				ResultSet result = statementSelectVacant.executeQuery(sql_check);
				if (!result.next())
				{
					listaVacantes.add(vacante);
				}
				statementSelectVacant.close();
			}else {
				listaVacantes.add(vacante);
			}
		}
		resulSet3.close();		
		
		
		con.desconectar();
		
		return listaVacantes;
	}

	public List<VacanteModel> listarVacantesByContratacionAndHorario(int page, int id_, int iType, int contratacion, int horario2) throws SQLException { 
		List<VacanteModel> listaVacantes = new ArrayList<VacanteModel>();
		String sql;
		String sql_check;
		String sql2;
		con.conectar();
		connection = con.getJdbcConnection();
		if (iType > 0)
		{
			//sql = "SELECT * FROM vacantes WHERE active='OK' and idEmpresa = "+id_+" LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.tipocontratacion = "+contratacion+" and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa and T1.idEmpresa = "+id_+" LIMIT " +page+","+5;
			sql2 = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.horario = "+horario2+" and T1.tipocontratacion != "+contratacion+" and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa and T1.idEmpresa = "+id_+" LIMIT " +page+","+5;
		}else {
			//sql = "SELECT * FROM vacantes WHERE active='OK' and status='OK' LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.tipocontratacion = '"+contratacion+"' and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa LIMIT " +page+","+5;
			sql2 = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.horario = "+horario2+" and T1.tipocontratacion != "+contratacion+" and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa LIMIT " +page+","+5;
		}
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			int id = resulSet.getInt("vid");
			String nombrevacante = resulSet.getString("nombrevacante");
			String requisitos = resulSet.getString("requisitos");
			String descripcion = resulSet.getString("descripcion");
			int Sueldo = resulSet.getInt("Sueldo");
			int horario = resulSet.getInt("horario");
			int tipocontratacion = resulSet.getInt("tipocontratacion");
			int idEmpresa = resulSet.getInt("idEmpresa");
			String status = resulSet.getString("status");
			String nombre_contacto = resulSet.getString("nombre_contacto");
			String apellido_p_contacto = resulSet.getString("apellido_p_contacto");
			String apellido_m_contacto = resulSet.getString("apellido_m_contacto");
			String nombre_empresa = resulSet.getString("nombre");
			VacanteModel vacante = new VacanteModel(id, nombrevacante, requisitos, descripcion, Sueldo, horario, tipocontratacion,
					idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto, nombre_empresa);
			if(iType < 1)
			{
				sql_check = "SELECT id FROM vacante_solicitud WHERE alumno_id="+id_+" and vacante_id="+id+"";
				Statement statementSelectVacant = connection.createStatement();
				ResultSet result = statementSelectVacant.executeQuery(sql_check);
				if (!result.next())
				{
					listaVacantes.add(vacante);
				}
				statementSelectVacant.close();
			}else {
				listaVacantes.add(vacante);
			}
		}
		resulSet.close();
		
		
		Statement statement2 = connection.createStatement();
		ResultSet resulSet2 = statement2.executeQuery(sql2);
 
		while (resulSet2.next()) {
			int id = resulSet2.getInt("vid");
			String nombrevacante = resulSet2.getString("nombrevacante");
			String requisitos = resulSet2.getString("requisitos");
			String descripcion = resulSet2.getString("descripcion");
			int Sueldo = resulSet2.getInt("Sueldo");
			int horario = resulSet2.getInt("horario");
			int tipocontratacion = resulSet2.getInt("tipocontratacion");
			int idEmpresa = resulSet2.getInt("idEmpresa");
			String status = resulSet2.getString("status");
			String nombre_contacto = resulSet2.getString("nombre_contacto");
			String apellido_p_contacto = resulSet2.getString("apellido_p_contacto");
			String apellido_m_contacto = resulSet2.getString("apellido_m_contacto");
			String nombre_empresa = resulSet2.getString("nombre");
			VacanteModel vacante = new VacanteModel(id, nombrevacante, requisitos, descripcion, Sueldo, horario, tipocontratacion,
					idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto, nombre_empresa);
			if(iType < 1)
			{
				sql_check = "SELECT id FROM vacante_solicitud WHERE alumno_id="+id_+" and vacante_id="+id+"";
				Statement statementSelectVacant = connection.createStatement();
				ResultSet result = statementSelectVacant.executeQuery(sql_check);
				if (!result.next())
				{
					listaVacantes.add(vacante);
				}
				statementSelectVacant.close();
			}else {
				listaVacantes.add(vacante);
			}
		}
		resulSet2.close();
		con.desconectar();
		
		return listaVacantes;
	}
	
	public List<VacanteModel> listarVacantesByNameAndContratacion(int page, int id_, int iType, String name, int contratacion) throws SQLException { 
		List<VacanteModel> listaVacantes = new ArrayList<VacanteModel>();
		String sql;
		String sql_check;
		String sql2;
		con.conectar();
		connection = con.getJdbcConnection();
		if (iType > 0)
		{
			//sql = "SELECT * FROM vacantes WHERE active='OK' and idEmpresa = "+id_+" LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T2.nombre = '"+name+"' and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa and T1.idEmpresa = "+id_+" LIMIT " +page+","+5;
			sql2 = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.tipocontratacion = '"+contratacion+"' and T2.nombre != '"+name+"' and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa and T1.idEmpresa = "+id_+" LIMIT " +page+","+5;
		}else {
			//sql = "SELECT * FROM vacantes WHERE active='OK' and status='OK' LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T2.nombre = '"+name+"' and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa LIMIT " +page+","+5;
			sql2 = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.tipocontratacion = '"+contratacion+"' and T2.nombre != '"+name+"' and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa LIMIT " +page+","+5;
		}
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			int id = resulSet.getInt("vid");
			String nombrevacante = resulSet.getString("nombrevacante");
			String requisitos = resulSet.getString("requisitos");
			String descripcion = resulSet.getString("descripcion");
			int Sueldo = resulSet.getInt("Sueldo");
			int horario = resulSet.getInt("horario");
			int tipocontratacion = resulSet.getInt("tipocontratacion");
			int idEmpresa = resulSet.getInt("idEmpresa");
			String status = resulSet.getString("status");
			String nombre_contacto = resulSet.getString("nombre_contacto");
			String apellido_p_contacto = resulSet.getString("apellido_p_contacto");
			String apellido_m_contacto = resulSet.getString("apellido_m_contacto");
			String nombre_empresa = resulSet.getString("nombre");
			VacanteModel vacante = new VacanteModel(id, nombrevacante, requisitos, descripcion, Sueldo, horario, tipocontratacion,
					idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto, nombre_empresa);
			if(iType < 1)
			{
				sql_check = "SELECT id FROM vacante_solicitud WHERE alumno_id="+id_+" and vacante_id="+id+"";
				Statement statementSelectVacant = connection.createStatement();
				ResultSet result = statementSelectVacant.executeQuery(sql_check);
				if (!result.next())
				{
					listaVacantes.add(vacante);
				}
				statementSelectVacant.close();
			}else {
				listaVacantes.add(vacante);
			}
		}
		resulSet.close();
		
		
		Statement statement2 = connection.createStatement();
		ResultSet resulSet2 = statement2.executeQuery(sql2);
 
		while (resulSet2.next()) {
			int id = resulSet2.getInt("vid");
			String nombrevacante = resulSet2.getString("nombrevacante");
			String requisitos = resulSet2.getString("requisitos");
			String descripcion = resulSet2.getString("descripcion");
			int Sueldo = resulSet2.getInt("Sueldo");
			int horario = resulSet2.getInt("horario");
			int tipocontratacion = resulSet2.getInt("tipocontratacion");
			int idEmpresa = resulSet2.getInt("idEmpresa");
			String status = resulSet2.getString("status");
			String nombre_contacto = resulSet2.getString("nombre_contacto");
			String apellido_p_contacto = resulSet2.getString("apellido_p_contacto");
			String apellido_m_contacto = resulSet2.getString("apellido_m_contacto");
			String nombre_empresa = resulSet2.getString("nombre");
			VacanteModel vacante = new VacanteModel(id, nombrevacante, requisitos, descripcion, Sueldo, horario, tipocontratacion,
					idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto, nombre_empresa);
			if(iType < 1)
			{
				sql_check = "SELECT id FROM vacante_solicitud WHERE alumno_id="+id_+" and vacante_id="+id+"";
				Statement statementSelectVacant = connection.createStatement();
				ResultSet result = statementSelectVacant.executeQuery(sql_check);
				if (!result.next())
				{
					listaVacantes.add(vacante);
				}
				statementSelectVacant.close();
			}else {
				listaVacantes.add(vacante);
			}
		}
		resulSet2.close();
		con.desconectar();
		
		return listaVacantes;
	}
	
	public List<VacanteModel> listarVacantesByNameAndHorario(int page, int id_, int iType, String name, int horario_) throws SQLException { 
		List<VacanteModel> listaVacantes = new ArrayList<VacanteModel>();
		String sql;
		String sql_check;
		String sql2;
		con.conectar();
		connection = con.getJdbcConnection();
		if (iType > 0)
		{
			//sql = "SELECT * FROM vacantes WHERE active='OK' and idEmpresa = "+id_+" LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T2.nombre = '"+name+"' and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa and T1.idEmpresa = "+id_+" LIMIT " +page+","+5;
			sql2 = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.horario = '"+horario_+"' and T2.nombre != '"+name+"' and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa and T1.idEmpresa = "+id_+" LIMIT " +page+","+5;
		}else {
			//sql = "SELECT * FROM vacantes WHERE active='OK' and status='OK' LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T2.nombre = '"+name+"' and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa LIMIT " +page+","+5;
			sql2 = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.horario = '"+horario_+"' and T2.nombre != '"+name+"' and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa LIMIT " +page+","+5;
		}
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			int id = resulSet.getInt("vid");
			String nombrevacante = resulSet.getString("nombrevacante");
			String requisitos = resulSet.getString("requisitos");
			String descripcion = resulSet.getString("descripcion");
			int Sueldo = resulSet.getInt("Sueldo");
			int horario = resulSet.getInt("horario");
			int tipocontratacion = resulSet.getInt("tipocontratacion");
			int idEmpresa = resulSet.getInt("idEmpresa");
			String status = resulSet.getString("status");
			String nombre_contacto = resulSet.getString("nombre_contacto");
			String apellido_p_contacto = resulSet.getString("apellido_p_contacto");
			String apellido_m_contacto = resulSet.getString("apellido_m_contacto");
			String nombre_empresa = resulSet.getString("nombre");
			VacanteModel vacante = new VacanteModel(id, nombrevacante, requisitos, descripcion, Sueldo, horario, tipocontratacion,
					idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto, nombre_empresa);
			if(iType < 1)
			{
				sql_check = "SELECT id FROM vacante_solicitud WHERE alumno_id="+id_+" and vacante_id="+id+"";
				Statement statementSelectVacant = connection.createStatement();
				ResultSet result = statementSelectVacant.executeQuery(sql_check);
				if (!result.next())
				{
					listaVacantes.add(vacante);
				}
				statementSelectVacant.close();
			}else {
				listaVacantes.add(vacante);
			}
		}
		resulSet.close();
		
		
		Statement statement2 = connection.createStatement();
		ResultSet resulSet2 = statement2.executeQuery(sql2);
 
		while (resulSet2.next()) {
			int id = resulSet2.getInt("vid");
			String nombrevacante = resulSet2.getString("nombrevacante");
			String requisitos = resulSet2.getString("requisitos");
			String descripcion = resulSet2.getString("descripcion");
			int Sueldo = resulSet2.getInt("Sueldo");
			int horario = resulSet2.getInt("horario");
			int tipocontratacion = resulSet2.getInt("tipocontratacion");
			int idEmpresa = resulSet2.getInt("idEmpresa");
			String status = resulSet2.getString("status");
			String nombre_contacto = resulSet2.getString("nombre_contacto");
			String apellido_p_contacto = resulSet2.getString("apellido_p_contacto");
			String apellido_m_contacto = resulSet2.getString("apellido_m_contacto");
			String nombre_empresa = resulSet2.getString("nombre");
			VacanteModel vacante = new VacanteModel(id, nombrevacante, requisitos, descripcion, Sueldo, horario, tipocontratacion,
					idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto, nombre_empresa);
			if(iType < 1)
			{
				sql_check = "SELECT id FROM vacante_solicitud WHERE alumno_id="+id_+" and vacante_id="+id+"";
				Statement statementSelectVacant = connection.createStatement();
				ResultSet result = statementSelectVacant.executeQuery(sql_check);
				if (!result.next())
				{
					listaVacantes.add(vacante);
				}
				statementSelectVacant.close();
			}else {
				listaVacantes.add(vacante);
			}
		}
		resulSet2.close();
		con.desconectar();
		
		return listaVacantes;
	}
	
	public List<VacanteModel> listarVacantesByHorario(int page, int id_, int iType, int horario_) throws SQLException { 
		List<VacanteModel> listaVacantes = new ArrayList<VacanteModel>();
		String sql;
		String sql_check;
		con.conectar();
		connection = con.getJdbcConnection();
		if (iType > 0)
			//sql = "SELECT * FROM vacantes WHERE active='OK' and idEmpresa = "+id_+" LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.horario = "+horario_+" and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa and T1.idEmpresa = "+id_+" LIMIT " +page+","+5;
		else
			//sql = "SELECT * FROM vacantes WHERE active='OK' and status='OK' LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.horario = "+horario_+" and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa LIMIT " +page+","+5;
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			int id = resulSet.getInt("vid");
			String nombrevacante = resulSet.getString("nombrevacante");
			String requisitos = resulSet.getString("requisitos");
			String descripcion = resulSet.getString("descripcion");
			int Sueldo = resulSet.getInt("Sueldo");
			int horario = resulSet.getInt("horario");
			int tipocontratacion = resulSet.getInt("tipocontratacion");
			int idEmpresa = resulSet.getInt("idEmpresa");
			String status = resulSet.getString("status");
			String nombre_contacto = resulSet.getString("nombre_contacto");
			String apellido_p_contacto = resulSet.getString("apellido_p_contacto");
			String apellido_m_contacto = resulSet.getString("apellido_m_contacto");
			String nombre_empresa = resulSet.getString("nombre");
			VacanteModel vacante = new VacanteModel(id, nombrevacante, requisitos, descripcion, Sueldo, horario, tipocontratacion,
					idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto, nombre_empresa);
			if(iType < 1)
			{
				sql_check = "SELECT id FROM vacante_solicitud WHERE alumno_id="+id_+" and vacante_id="+id+"";
				Statement statementSelectVacant = connection.createStatement();
				ResultSet result = statementSelectVacant.executeQuery(sql_check);
				if (!result.next())
				{
					listaVacantes.add(vacante);
				}
				statementSelectVacant.close();
			}else {
				listaVacantes.add(vacante);
			}
		}
		resulSet.close();
		con.desconectar();
		return listaVacantes;
	}
	
	public List<VacanteModel> listarVacantesByContratacion(int page, int id_, int iType, int contratacion) throws SQLException { 
		List<VacanteModel> listaVacantes = new ArrayList<VacanteModel>();
		String sql;
		String sql_check;
		con.conectar();
		connection = con.getJdbcConnection();
		if (iType > 0)
			//sql = "SELECT * FROM vacantes WHERE active='OK' and idEmpresa = "+id_+" LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.tipocontratacion = "+contratacion+" and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa and T1.idEmpresa = "+id_+" LIMIT " +page+","+5;
		else
			//sql = "SELECT * FROM vacantes WHERE active='OK' and status='OK' LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.tipocontratacion = "+contratacion+" and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa LIMIT " +page+","+5;
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			int id = resulSet.getInt("vid");
			String nombrevacante = resulSet.getString("nombrevacante");
			String requisitos = resulSet.getString("requisitos");
			String descripcion = resulSet.getString("descripcion");
			int Sueldo = resulSet.getInt("Sueldo");
			int horario = resulSet.getInt("horario");
			int tipocontratacion = resulSet.getInt("tipocontratacion");
			int idEmpresa = resulSet.getInt("idEmpresa");
			String status = resulSet.getString("status");
			String nombre_contacto = resulSet.getString("nombre_contacto");
			String apellido_p_contacto = resulSet.getString("apellido_p_contacto");
			String apellido_m_contacto = resulSet.getString("apellido_m_contacto");
			String nombre_empresa = resulSet.getString("nombre");
			VacanteModel vacante = new VacanteModel(id, nombrevacante, requisitos, descripcion, Sueldo, horario, tipocontratacion,
					idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto, nombre_empresa);
			if(iType < 1)
			{
				sql_check = "SELECT id FROM vacante_solicitud WHERE alumno_id="+id_+" and vacante_id="+id+"";
				Statement statementSelectVacant = connection.createStatement();
				ResultSet result = statementSelectVacant.executeQuery(sql_check);
				if (!result.next())
				{
					listaVacantes.add(vacante);
				}
				statementSelectVacant.close();
			}else {
				listaVacantes.add(vacante);
			}
		}
		resulSet.close();
		con.desconectar();
		return listaVacantes;
	}
	
	public List<VacanteModel> listarVacantesByName(int page, int id_, int iType, String nombre_empresa2) throws SQLException { 
		List<VacanteModel> listaVacantes = new ArrayList<VacanteModel>();
		String sql;
		String sql_check;
		con.conectar();
		connection = con.getJdbcConnection();
		if (iType > 0)
			//sql = "SELECT * FROM vacantes WHERE active='OK' and idEmpresa = "+id_+" LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T2.nombre = '"+nombre_empresa2+"' and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa and T1.idEmpresa = "+id_+" LIMIT " +page+","+5;
		else
			//sql = "SELECT * FROM vacantes WHERE active='OK' and status='OK' LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T2.nombre = '"+nombre_empresa2+"' and T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa LIMIT " +page+","+5;
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			int id = resulSet.getInt("vid");
			String nombrevacante = resulSet.getString("nombrevacante");
			String requisitos = resulSet.getString("requisitos");
			String descripcion = resulSet.getString("descripcion");
			int Sueldo = resulSet.getInt("Sueldo");
			int horario = resulSet.getInt("horario");
			int tipocontratacion = resulSet.getInt("tipocontratacion");
			int idEmpresa = resulSet.getInt("idEmpresa");
			String status = resulSet.getString("status");
			String nombre_contacto = resulSet.getString("nombre_contacto");
			String apellido_p_contacto = resulSet.getString("apellido_p_contacto");
			String apellido_m_contacto = resulSet.getString("apellido_m_contacto");
			String nombre_empresa = resulSet.getString("nombre");
			VacanteModel vacante = new VacanteModel(id, nombrevacante, requisitos, descripcion, Sueldo, horario, tipocontratacion,
					idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto, nombre_empresa);
			if(iType < 1)
			{
				sql_check = "SELECT id FROM vacante_solicitud WHERE alumno_id="+id_+" and vacante_id="+id+"";
				Statement statementSelectVacant = connection.createStatement();
				ResultSet result = statementSelectVacant.executeQuery(sql_check);
				if (!result.next())
				{
					listaVacantes.add(vacante);
				}
				statementSelectVacant.close();
			}else {
				listaVacantes.add(vacante);
			}
		}
		resulSet.close();
		con.desconectar();
		return listaVacantes;
	}
	
	/*******************/
	/*End Filter Search*/
	/*******************/
	
	// Listar todas las vacantes
	public List<VacanteModel> listarVacantes(int page, int id_, int iType) throws SQLException {
 
		List<VacanteModel> listaVacantes = new ArrayList<VacanteModel>();
		String sql;
		String sql_check;
		con.conectar();
		connection = con.getJdbcConnection();
		if (iType > 0)
			//sql = "SELECT * FROM vacantes WHERE active='OK' and idEmpresa = "+id_+" LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa and T1.idEmpresa = "+id_+" LIMIT " +page+","+5;
		else
			//sql = "SELECT * FROM vacantes WHERE active='OK' and status='OK' LIMIT " +page+","+5;
			sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.status='OK' and T1.active='OK' and T2.id = T1.idEmpresa LIMIT " +page+","+5;
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			int id = resulSet.getInt("vid");
			String nombrevacante = resulSet.getString("nombrevacante");
			String requisitos = resulSet.getString("requisitos");
			String descripcion = resulSet.getString("descripcion");
			int Sueldo = resulSet.getInt("Sueldo");
			int horario = resulSet.getInt("horario");
			int tipocontratacion = resulSet.getInt("tipocontratacion");
			int idEmpresa = resulSet.getInt("idEmpresa");
			String status = resulSet.getString("status");
			String nombre_contacto = resulSet.getString("nombre_contacto");
			String apellido_p_contacto = resulSet.getString("apellido_p_contacto");
			String apellido_m_contacto = resulSet.getString("apellido_m_contacto");
			String nombre_empresa = resulSet.getString("nombre");
			VacanteModel vacante = new VacanteModel(id, nombrevacante, requisitos, descripcion, Sueldo, horario, tipocontratacion,
					idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto, nombre_empresa);
			if(iType < 1)
			{
				sql_check = "SELECT id FROM vacante_solicitud WHERE alumno_id="+id_+" and vacante_id="+id+"";
				Statement statementSelectVacant = connection.createStatement();
				ResultSet result = statementSelectVacant.executeQuery(sql_check);
				if (!result.next())
				{
					listaVacantes.add(vacante);
				}
				statementSelectVacant.close();
			}else {
				listaVacantes.add(vacante);
			}
		}
		resulSet.close();
		con.desconectar();
		return listaVacantes;
	}
	
	public List<VacanteModel> listarVacantesAdmin(int page) throws SQLException {
		 
		List<VacanteModel> listaVacantes = new ArrayList<VacanteModel>();
		String sql;
		con.conectar();
		connection = con.getJdbcConnection();

		//sql = "SELECT * FROM vacantes WHERE status='NOT' and active='OK' LIMIT " +page+","+5;			
		sql = "SELECT T1.*, T2.id, T2.nombre FROM vacantes T1, empresa T2 WHERE T1.status='NOT' and T1.active='OK' and T2.id = T1.idEmpresa LIMIT " +page+","+5;
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			int id = resulSet.getInt("vid");
			String nombrevacante = resulSet.getString("nombrevacante");
			String requisitos = resulSet.getString("requisitos");
			String descripcion = resulSet.getString("descripcion");
			int Sueldo = resulSet.getInt("Sueldo");
			int horario = resulSet.getInt("horario");
			int tipocontratacion = resulSet.getInt("tipocontratacion");
			int idEmpresa = resulSet.getInt("idEmpresa");
			String status = resulSet.getString("status");
			String nombre_contacto = resulSet.getString("nombre_contacto");
			String apellido_p_contacto = resulSet.getString("apellido_p_contacto");
			String apellido_m_contacto = resulSet.getString("apellido_m_contacto");
			String nombre_empresa = resulSet.getString("nombre");
			VacanteModel vacante = new VacanteModel(id, nombrevacante, requisitos, descripcion, Sueldo, horario, tipocontratacion,
					idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto, nombre_empresa);
				listaVacantes.add(vacante);
		}
		resulSet.close();
		con.desconectar();
		return listaVacantes;
	}
	
	//Cantidad de valores
	public int PaginationAdminVacant() throws SQLException {	
		String sql;
		sql = "SELECT COUNT(*) FROM vacantes WHERE active='OK' and status='NOT' ";
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
	//Cantidad de valores
	public int Pagination(int id_) throws SQLException {	
		String sql;
		if (id_ > 0)
			sql = "SELECT COUNT(*) FROM vacantes WHERE active='OK' and status='OK' and idEmpresa ="+id_+"";
		else
			sql = "SELECT COUNT(*) FROM vacantes WHERE active='OK' and status='OK' ";
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
	
	public int PaginationByVacant(int id_) throws SQLException {	
		String sql;
		if (id_ == 0)
			return 0;
		sql = "SELECT COUNT(*) FROM vacante_solicitud WHERE readed = 0 and vacante_id ="+id_+"";
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
	

	public int PaginationByVacantAll(int id_) throws SQLException {	
		String sql;
		if (id_ == 0)
			return 0;
		sql = "SELECT COUNT(*) FROM vacante_solicitud WHERE vacante_id ="+id_+"";
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

	public int UpdateVacanteSolicitud(int status, int vacante_id, int alumno_id) throws SQLException {
		String sql;
		sql = "UPDATE vacante_solicitud SET readed="+status+" WHERE vacante_id ="+vacante_id+" and alumno_id="+alumno_id+"";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		int resulSet = statement.executeUpdate(sql);
		statement.close();
		con.desconectar();
		return resulSet;
	}
	
	public int UpdateVacanteActive(int vacante_id) throws SQLException {
		String sql;
		sql = "UPDATE vacantes SET active='NOT' WHERE vid ="+vacante_id+"";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		int resulSet = statement.executeUpdate(sql);
		statement.close();
		con.desconectar();
		return resulSet;
	}
	
	public int UpdateVacanteValidate(int vacante_id) throws SQLException {
		String sql;
		sql = "UPDATE vacantes SET status='OK' WHERE vid ="+vacante_id+"";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		int resulSet = statement.executeUpdate(sql);
		statement.close();
		con.desconectar();
		return resulSet;
	}
	
	public int GetStudentIDByVacantID(int vacante_id) throws SQLException {
		String GetTypeSQL = "SELECT alumno_id FROM vacante_solicitud WHERE vacante_id = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		try {
			PreparedStatement statementSelectType = connection.prepareStatement(GetTypeSQL);
			statementSelectType.setInt(1, vacante_id);
			ResultSet result = statementSelectType.executeQuery();
			if (result.next()) {
				int alumno_id = result.getInt("alumno_id");
				statementSelectType.close();
				return alumno_id;
			}
			return 0;
		} catch(Exception e) {
			con.desconectar();
			return -1;				
		}		
	}
	
	//Insert Vacante
	public int InsertVacante(VacanteModel vacante) throws SQLException {
		String sql = "INSERT INTO vacantes (nombrevacante, requisitos, descripcion, sueldo, horario, tipocontratacion"
				+ ", idEmpresa, status, nombre_contacto, apellido_p_contacto, apellido_m_contacto) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		try {
			PreparedStatement statementVacantes = connection.prepareStatement(sql);
			statementVacantes.setString(1, vacante.Getnombrevacante());
			statementVacantes.setString(2, vacante.Getrequisitos());
			statementVacantes.setString(3, vacante.Getdescripcion());
			statementVacantes.setInt(4, vacante.GetSueldo());
			statementVacantes.setInt(5, vacante.Gethorario());
			statementVacantes.setInt(6, vacante.Gettipocontratacion());
			statementVacantes.setInt(7, vacante.GetidEmpresa());
			statementVacantes.setString(8, vacante.Getstatus());
			statementVacantes.setString(9, vacante.Getnombre_contacto());
			statementVacantes.setString(10, vacante.Getapellido_p_contacto());
			statementVacantes.setString(11, vacante.Getapellido_m_contacto());
			statementVacantes.executeUpdate();
			statementVacantes.close();
			con.desconectar();
			return 1;
		} catch(Exception e) {
			con.desconectar();
			return -1;
		}
	}
	
	public int InsertSolicitudVacante(int alumno_id, int vacante_id) throws SQLException {
		String sql = "INSERT INTO vacante_solicitud (alumno_id, vacante_id) VALUES (?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		try {
			PreparedStatement statementSolicitudes = connection.prepareStatement(sql);
			statementSolicitudes.setInt(1, alumno_id);
			statementSolicitudes.setInt(2, vacante_id);
			statementSolicitudes.executeUpdate();
			con.desconectar();
			return 1;
		} catch(Exception e) {
			con.desconectar();
			return -1;
		}
	}
}
