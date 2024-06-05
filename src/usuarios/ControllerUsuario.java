package usuarios;

import javax.swing.JOptionPane; // para ofrecer el mensaje de cuadro de diálogo hay que importar la clase 



public class ControllerUsuario {

	public void registrar (usuario usuario) {
		usuarioDao dao = new  usuarioDaoImpl(); //el bueno  
		
		//usuarioDaoImpl dao = new  usuarioDaoImpl(); // sería usado para saltarnos a usuarioDao  
		
		if(dao.registrar(usuario)) 
			JOptionPane.showMessageDialog(null, "Usuario Registrado");
		else
			JOptionPane.showMessageDialog(null, "Error al registrar Usuario");
		}
	
	public void actualizar (String a, String mod, int indice) {
		usuarioDao dao = new usuarioDaoImpl();
		
		
		if(dao.actualizar(a, mod, indice))
			JOptionPane.showMessageDialog(null, "Usuario actualizado");
		else
			JOptionPane.showMessageDialog(null, "Error al actualizar Usuario");
		
		
	}

/*
	public void eliminar (int usuario) {
		usuarioDao dao = new usuarioDaoImpl();
		
		
		if(dao.eliminar(usuario))
			JOptionPane.showMessageDialog(null, "Usuario eliminado");
		else
			JOptionPane.showMessageDialog(null, "Error al eliminar usuario");
		
	}
*/	
	public int ContarCliente() {
		int total=0;
		usuarioDao dao = new usuarioDaoImpl();
		total=dao.Conteo();
		return total;
	}
	
	
}
