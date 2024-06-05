package alquileres;

import javax.swing.JOptionPane;


public class ControllerAlquiler {

	public void registrar (alquiler alquiler) {
			
			alquilerDao dao = new  alquilerDaoImpl(); //el bueno  
			
			//usuarioDaoImpl dao = new  usuarioDaoImpl(); // sería usado para saltarnos a usuarioDao  
			
			if(dao.registrar(alquiler)) 
				JOptionPane.showMessageDialog(null, "Juego Alquilado.");
			else
				JOptionPane.showMessageDialog(null, "Error Alquilando Juego. Posiblemente esté alquilado en esas fechas. Busque otra fecha de inicio del alquiler o de finalización	.");
			}

	

	public void eliminar(int cod_alqui) {
		alquilerDao dao= new alquilerDaoImpl();
		if(dao.eliminar(cod_alqui))
			JOptionPane.showMessageDialog(null, "Alquiler con ID ["+cod_alqui+"]Eliminado");
		else
			JOptionPane.showMessageDialog(null, "Error al eliminar Alquiler");
	}
	
	public int ContarAlquiler() {
		int total=0;
		alquilerDao dao = new alquilerDaoImpl();
		total=dao.Conteo();
		return total;
	}
	
}
