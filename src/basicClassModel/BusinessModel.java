package basicClassModel;

public class BusinessModel {
	// Campos Personales
	private String clave;
	private String password;
	private String nombre;
	private String RFC;
	private String telefono;
	private String FAX;
	private String giro;
	private String descripcion;
	private String Email;
	private String paginaweb;
	// Campos de dirección
	private String Calle;
	private String DeloMun;
	private int Numero_Int;
	private int Numero_Ext;
	private int CP;
	private String Ciudad;
	
	public BusinessModel(String clave, String password, String nombre, String RFC, String telefono, String FAX, String giro,
			String descripcion, String Email, String paginaweb, String Calle, String DeloMun, int Numero_Int, int Numero_Ext, int CP,
			String Ciudad) {
		//Campos Personales
		this.clave = clave;
		this.password = password;
		this.nombre = nombre;
		this.RFC = RFC;
		this.telefono = telefono;
		this.FAX = FAX;
		this.giro = giro;
		this.descripcion = descripcion;
		this.Email = Email;
		this.paginaweb = paginaweb;
		//Campos de dirección
		this.Calle = Calle;
		this.DeloMun = DeloMun;
		this.Numero_Int = Numero_Int;
		this.Numero_Ext = Numero_Ext;
		this.CP = CP;
		this.Ciudad = Ciudad;
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
	
	public String GetRFC() {
		return RFC;
	}
	public void SetRFC(String RFC) {
		this.RFC = RFC;
	}
	
	public String GetTelefono() {
		return telefono;
	}
	public void SetTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String GetFAX() {
		return FAX;
	}
	public void SetFAX(String FAX) {
		this.FAX = FAX;
	}

	public String Getgiro() {
		return giro;
	}
	public void Setgiro(String giro) {
		this.giro = giro;
	}
	
	public String Getdescripcion() {
		return descripcion;
	}
	public void Setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String GetEmail() {
		return Email;
	}
	public void SetEmail(String Email) {
		this.Email = Email;
	}

	public String Getpaginaweb() {
		return paginaweb;
	}
	public void Setpaginaweb(String paginaweb) {
		this.paginaweb = paginaweb;
	}
	
	public String GetCalle() {
		return Calle;
	}
	public void SetCalle(String Calle) {
		this.Calle = Calle;
	}
	
	public String GetDeloMun() {
		return DeloMun;
	}
	public void SetDeloMun(String DeloMun) {
		this.DeloMun = DeloMun;
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
	
	public int GetCP() {
		return CP;
	}
	public void SetCP(int CP) {
		this.CP = CP;
	}

	public String GetCiudad() {
		return Ciudad;
	}
	public void SetCiudad(String Ciudad) {
		this.Ciudad = Ciudad;
	}
}
