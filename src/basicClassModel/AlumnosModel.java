package basicClassModel;

public class AlumnosModel {
	public int id;
	// Campos Personales
	private String clave;
	private String password;
	private String nombre;
	private String apellido_p;
	private String apellido_m;
	private String telefono;
	private String Email;
	// Campos de dirección
	private String Calle;
	private String Ciudad;
	private String DeloMun;
	private int CP;
	private int Numero_Int;
	private int Numero_Ext;
	
	public AlumnosModel(int id, String clave, String password, String nombre, String apellido_p, String apellido_m, String telefono, String Email,
			String Calle, String Ciudad, String DeloMun, int CP, int Numero_Int, int Numero_Ext) {
		this.id = id;
		//Campos Personales
		this.clave = clave;
		this.password = password;
		this.nombre = nombre;
		this.apellido_p = apellido_p;
		this.apellido_m = apellido_m;
		this.telefono = telefono;
		this.Email = Email;
		//Campos de dirección
		this.Calle = Calle;
		this.Ciudad = Ciudad;
		this.DeloMun = DeloMun;
		this.CP = CP;
		this.Numero_Int = Numero_Int;
		this.Numero_Ext = Numero_Ext;
	}

	public int GetId() {
		return id;
	}
	public void SetId(int id) {
		this.id = id;
	}
	
	public String GetClave() {
		return clave;
	}
	public void SetClave(String clave) {
		this.clave = clave;
	}
	
	public String GetPassword() {
		return password;
	}
	public void SetPassword(String password) {
		this.password = password;
	}

	public String GetNombre() {
		return nombre;
	}
	public void SetNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String GetApellidoP() {
		return apellido_p;
	}
	public void SetApellidoP(String apellido_p) {
		this.apellido_p = apellido_p;
	}
	
	public String GetApellidoM() {
		return apellido_m;
	}
	public void SetApellidoM(String apellido_m) {
		this.apellido_m = apellido_m;
	}
	
	public String GetTelefono() {
		return telefono;
	}
	public void SetTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String GetEmail() {
		return Email;
	}
	public void SetEmail(String Email) {
		this.Email = Email;
	}
	
	public String GetCalle() {
		return Calle;
	}
	public void SetCalle(String Calle) {
		this.Calle = Calle;
	}
	
	public String GetCiudad() {
		return Ciudad;
	}
	public void SetCiudad(String Ciudad) {
		this.Ciudad = Ciudad;
	}
	
	public String GetDeloMun() {
		return DeloMun;
	}
	public void SetDeloMun(String DeloMun) {
		this.DeloMun = DeloMun;
	}
	
	public int GetCP() {
		return CP;
	}
	public void SetCP(int CP) {
		this.CP = CP;
	}
	
	public int GetNumero_Int() {
		return Numero_Int;
	}
	public void SetNumero_Int(int Numero_Int) {
		this.Numero_Int = Numero_Int;
	}
	
	public int GetNumero_Ext() {
		return Numero_Ext;
	}
	public void SetNumero_Ext(int Numero_Ext) {
		this.Numero_Ext = Numero_Ext;
	}
	
}
