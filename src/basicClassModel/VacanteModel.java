package basicClassModel;

public class VacanteModel {
	public int id;
	public String nombrevacante;
	public String requisitos;
	public String descripcion;
	public int Sueldo;
	public int horario;
	public int tipocontratacion;
	public int idEmpresa;
	public String status;
	public String nombre_contacto;
	public String apellido_p_contacto;
	public String apellido_m_contacto;
	public String nombre_empresa;
	
	public VacanteModel(int id, String nombrevacante, String requisitos, String descripcion, int Sueldo, int horario, int tipocontratacion,
			int idEmpresa, String status, String nombre_contacto, String apellido_p_contacto, String apellido_m_contacto, String nombre_empresa) {
		this.id = id;
		this.nombrevacante = nombrevacante;
		this.requisitos = requisitos;
		this.descripcion = descripcion;
		this.Sueldo = Sueldo;
		this.horario = horario;
		this.tipocontratacion = tipocontratacion;
		this.idEmpresa = idEmpresa;
		this.status = status;
		this.nombre_contacto = nombre_contacto;
		this.apellido_p_contacto = apellido_p_contacto;
		this.apellido_m_contacto = apellido_m_contacto;
		this.nombre_empresa = nombre_empresa;
	}
	
	public int Getid() {
		return id;
	}
	
	public void Setid(int id) {
		this.id = id;
	}
	
	public String Getnombrevacante() {
		return nombrevacante;
	}
	
	public void Setnombrevacante(String nombrevacante) {
		this.nombrevacante = nombrevacante;
	}
	
	public String Getrequisitos() {
		return requisitos;
	}
	
	public void Setrequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	
	public String Getdescripcion() {
		return descripcion;
	}
	
	public void Setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int GetSueldo() {
		return Sueldo;
	}
	
	public void SetSueldo(int Sueldo) {
		this.Sueldo = Sueldo;
	}
	
	public int Gethorario() {
		return horario;
	}
	
	public void Sethorario(int horario) {
		this.horario = horario;
	}
	
	public int Gettipocontratacion() {
		return tipocontratacion;
	}
	
	public void Settipocontratation(int tipocontratacion) {
		this.tipocontratacion = tipocontratacion;
	}
	
	public int GetidEmpresa() {
		return idEmpresa;
	}
	
	public void SetidEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	public String Getstatus() {
		return status;
	}
	
	public void Setstatus(String status) {
		this.status = status;
	}
	
	public String Getnombre_contacto() {
		return nombre_contacto;
	}
	
	public void Setnombre_contacto(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}
	
	public String Getapellido_p_contacto() {
		return apellido_p_contacto;
	}
	
	public void Setapellido_p_contacto(String apellido_p_contacto) {
		this.apellido_p_contacto = apellido_p_contacto;
	}
	
	public String Getapellido_m_contacto() {
		return apellido_m_contacto;
	}
	
	public void Setapellido_m_contacto(String apellido_m_contacto) {
		this.apellido_m_contacto = apellido_m_contacto;
	}

	public String Getnombre_empresa() {
		return nombre_empresa;
	}
	
	public void Setnombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}
}
