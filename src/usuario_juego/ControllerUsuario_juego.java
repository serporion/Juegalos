package usuario_juego;

import javax.swing.JOptionPane;


public class ControllerUsuario_juego {

	public void registrar (usuario_juego usuario_juego) {
			
			usuario_juegoDao dao = new  usuario_juegoDaoImpl();
			
			
			
			if(dao.registrar(usuario_juego)) 
				JOptionPane.showMessageDialog(null, "Usuario_Juego registrado");
			else
				JOptionPane.showMessageDialog(null, "Error en insertar Usuario Juego");
			}

	

	public void eliminar(int cod_juego) {
		usuario_juegoDao dao= new usuario_juegoDaoImpl();
		if(dao.eliminar(cod_juego))
			JOptionPane.showMessageDialog(null, "Juego con ID ["+cod_juego+"]Eliminado");
		else
			JOptionPane.showMessageDialog(null, "Error al eliminar Juego");
	}
	
}
