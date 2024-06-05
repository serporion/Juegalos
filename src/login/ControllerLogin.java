package login;

import javax.swing.JOptionPane;


public class ControllerLogin {

	public static String saa;
	public static String nombre = loginDaoImpl.us;
	
	
	public void comprobar (login login) {
		
			
			loginDao dao = new loginDaoImpl(); //el bueno  
			
			//usuarioDaoImpl dao = new  usuarioDaoImpl(); // sería usado para saltarnos a usuarioDao  
			
			if(dao.comprobar(login)) {
				saa = loginDaoImpl.us.toUpperCase();
				JOptionPane.showMessageDialog(null, "Bienvenido " + loginDaoImpl.us.toUpperCase());
				
				System.out.println(loginDaoImpl.id);
				System.out.println(saa);

			}else
				JOptionPane.showMessageDialog(null, "Usuario o contraseña invalidos");
			}
	
	
	
	public int ContarUsusLogin() {
		int total=0;
		loginDao dao = new loginDaoImpl();
		total=dao.Conteo();
		return total;
	}

	
	public void eliminar (int usuario) {
		loginDao dao = new loginDaoImpl();
		
		
		if(dao.eliminar(usuario))
			JOptionPane.showMessageDialog(null, "Usuario eliminado");
		else
			JOptionPane.showMessageDialog(null, "Error al eliminar usuario");
		
	}
	

	
	public void registrar (login login) {
		loginDao dao = new  loginDaoImpl(); //el bueno  
		
		//usuarioDaoImpl dao = new  usuarioDaoImpl(); // sería usado para saltarnos a usuarioDao  
		
		if(dao.registrar(login)) 
			JOptionPane.showMessageDialog(null, "Login Registrado");
		else
			JOptionPane.showMessageDialog(null, "Error al registrar Login");
		}
	

	public int IdInsertado(String a) {
		int id=0;
		loginDao dao = new loginDaoImpl();
		id=dao.BuscaId(a);
		return id;
	}

	
}
