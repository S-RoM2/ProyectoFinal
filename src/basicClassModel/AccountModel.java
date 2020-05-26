package basicClassModel;

public class AccountModel {
	// Campos Personales
	private String clave;
	private String password;

	public AccountModel(String clave, String password) {
		//Campos Personales
		this.clave = clave;
		this.password = password;
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
}
