package basicClassModel;

public class CVModel {
	public int id;
	public int alumno_id;
	public int nivelestudios;
	public String curso;
	public String idioma;
	public String informacion;
	public String trabajo;
	public String periodo;
	public String puesto;
	
	public CVModel(int id, int alumno_id, int nivelestudios, String curso, String idioma, String informacion, String trabajo, String periodo,
				String puesto) {
		this.id = id;
		this.alumno_id = alumno_id;
		this.nivelestudios = nivelestudios;
		this.curso = curso;
		this.idioma = idioma;
		this.informacion = informacion;
		this.trabajo = trabajo;
		this.periodo = periodo;
		this.puesto = puesto;
	}
	
	public int GetID() {
		return id;
	}
	
	public void SetID(int id) {
		this.id = id;
	}		
	
	public int GetAlumnoID() {
		return alumno_id;
	}
	
	public void SetAlumnoID(int alumno_id) {
		this.alumno_id = alumno_id;
	}
	
	public int GetNivelEstudios() {
		return nivelestudios;
	}
	
	public void SetNivelEstudios(int nivelestudios) {
		this.nivelestudios = nivelestudios;
	}
	
	public String GetCurso() {
		return curso;
	}
	
	public void SetCurso(String curso) {
		this.curso = curso;
	}
	
	public String GetIdioma() {
		return idioma;
	}
	
	public void SetIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String GetInformacion() {
		return informacion;
	}
	
	public void SetInformacion(String informacion) {
		this.informacion = informacion;
	}
	
	public String GetTrabajo() {
		return trabajo;
	}
	
	public void SetTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
	
	public String GetPeriodo() {
		return periodo;
	}
	
	public void SetPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public String GetPuesto() {
		return puesto;
	}
	
	public void SetPuesto(String puesto) {
		this.puesto = puesto;
	}
}
