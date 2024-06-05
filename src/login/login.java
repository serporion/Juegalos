package login;

public class login {

	
	private int idusuario;
	private String usuario;
	//private String contrasena;
	private char[] contrasena;
	
	
	
	public login(
					
				int idusuario, String usuario, char[] contrasena){  
		
		this.idusuario=idusuario;		
		this.usuario=usuario;
		this.contrasena=contrasena;
		
	}



	public int getIdusuario() {
		return idusuario;
	}



	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public char[] getContrasena() {
		return contrasena;
	}



	public void setContrasena(char[] contrasena) {
		this.contrasena = contrasena;
	}





		
		
}

