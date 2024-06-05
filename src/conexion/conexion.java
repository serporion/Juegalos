package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class conexion {

	public static void main(String[] args) {
        conexion db = new conexion(); // conexion es la clase, db es la variable 
        db.MySQLConnect();  // db 
	}
	
	
	//Estas tres palabras son exclusivas de SQL dentro de Java
		
	Connection conexion = null; // nos hace una conexión. Creamos conexion que es una variable de tipo Connection inicializada a nula
	Statement comando = null; // estado de la conexión
	ResultSet registro; // nos da el resultado de la acción del SQL

	public Connection MySQLConnect() { // la hemos llamado MySQLConnnect. Se puede llamar de otra manera.

	    try {

	        Class.forName("com.mysql.cj.jdbc.Driver"); //cargamos el Driver primero

	        //Se puede unir las tres variables en una.
	        
	        String servidor = "jdbc:mysql://localhost/juegalos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	        // ese chorro es una referencia al phpMyAdmin. Buscamos sentencia de conexión de Java a PhpMyAdmin
	        String usuario = "root";
	        String pass = "";
	        conexion = DriverManager.getConnection(servidor, usuario, pass);

	        
	    } catch (ClassNotFoundException ex) {
	        JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
	        conexion = null;
	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
	        conexion = null;
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
	        conexion = null;
	    } finally {
	      return conexion; // Si el try funciona, se puede hacer otra cosa, en este caso devuelve a conexion, osea si estamos conectados o no.Siempre se ejecuta.
	      					// Nos devuelve un true o false, o un 0 o un 1.
	      
	    }
	}

}
