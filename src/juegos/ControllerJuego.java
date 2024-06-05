package juegos;

import javax.swing.JOptionPane;


public class ControllerJuego {

	public void registrar (juego juego) {
		
		juegoDao dao = new  juegoDaoImpl(); //el bueno  
		
		//usuarioDaoImpl dao = new  usuarioDaoImpl(); // sería usado para saltarnos a usuarioDao  
		
		if(dao.registrar(juego)) 
			JOptionPane.showMessageDialog(null, "Juego Registrado");
		else
			JOptionPane.showMessageDialog(null, "Error al registrar Juego");
		}

	
	
	public void eliminar(int cod_juego) {
		juegoDao dao= new juegoDaoImpl();
		if(dao.eliminar(cod_juego))
			JOptionPane.showMessageDialog(null, "Juego con ID ["+cod_juego+"]Eliminado");
		else
			JOptionPane.showMessageDialog(null, "Error al eliminar Juego");
	}
	
	

	
	public int ContarJuegos() {
		int total=0;
		juegoDao dao = new juegoDaoImpl();
		total=dao.Conteo();
		return total;
	}

}
