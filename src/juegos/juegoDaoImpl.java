package juegos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.conexion;
import login.loginDaoImpl;




public class juegoDaoImpl implements juegoDao{

	public boolean registrar(juego juego) {
		boolean registrar = false;
		conexion con = new conexion();
		
		Statement stm= null;
		
		String sql = "INSERT INTO juego (`idpro`,`nombre`,`fechaalta`,`categoria`,`plataforma`,`descripcion`,`edicion`,`precio`,`sesion`) VALUES (NULL,'"+juego.getNombre()+"', '"+juego.getFechaalta()+"', '"+juego.getCategoria()+"','"+juego.getPlataforma()+"','"+juego.getDescripcion()+"', '"+juego.getEdicion()+"','"+juego.getPrecio()+"','"+juego.getSesion()+"')"; 
		
		
		System.out.println(juego.getIdpro());
		System.out.println("el usuprestador es " + loginDaoImpl.id);

		
		try {	
			
			
			stm = con.MySQLConnect().createStatement();
			stm.execute(sql);
			registrar=true;
			System.out.println(juego.getIdpro());
			System.out.println("Nuevo juego registrado");
			stm.close();
	
		} catch (SQLException e) {
			System.out.println("Error: Clase juegoDaoImpl, método registrar");
			e.printStackTrace();
		}
		return registrar;
	}

	
	
	
	public boolean eliminar(int cod_juego) {

		Statement stm= null;		
		boolean eliminar=false;
				
		String sql="DELETE FROM juego WHERE idpro='"+cod_juego+"'";
		try {
			conexion con = new conexion();
			stm=con.MySQLConnect().createStatement();
			stm.execute(sql);
			eliminar=true;
			System.out.println("Juego ["+cod_juego+"] eliminado");
		} catch (SQLException e) {
			System.out.println("Error: Clase JuegoDaoImpl, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
	}


	@Override
	public int Conteo() {
		
		int total=0;
		
		try {
			conexion con =new conexion();
			Statement st = con.MySQLConnect().createStatement();
			
			
			ResultSet rs = st.executeQuery("SELECT COUNT(idpro) AS total FROM juego");
			if (rs.next())
			{
				total = rs.getInt("total");
			}
		}
		catch(SQLException s)
		{
			System.out.println("Error: SQL.");
			System.out.println("SQLException: " + s.getMessage());
		}
		catch(Exception s)
		{
			System.out.println("Error: Varios.");
			System.out.println("SQLException: " + s.getMessage());

		}
		return total;
		
		
	}
	
	
}
