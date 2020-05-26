package basicClassModel;

public class ContactoModel {
	public int id;
	public String nombre;
	public String email;
	public String asunto;
	public String mensaje;
	public String status;
	
	public ContactoModel(int id, String nombre, String email, String asunto, String mensaje, String status) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.asunto = asunto;
		this.mensaje = mensaje;
		this.status = status;
	}
	
	public String GetStatus() {
		return nombre;
	}
	
	public void SetStatus(String status) {
		this.status = status;
	}
	
	public String GetMensaje() {
		return mensaje;
	}
	
	public void SetMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
		
	public String GetAsunto() {
		return asunto;
	}
	
	public void SetAsunto(String asunto) {
		this.asunto = asunto;
	}
	
	
	public String GetEmail() {
		return email;
	}
	
	public void SetEmail(String email) {
		this.email = email;
	}
	
	
	public String GetNombre() {
		return nombre;
	}
	
	public void SetNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int GetID() {
		return id;
	}
	
	public void SetID(int id) {
		this.id = id;
	}
}
