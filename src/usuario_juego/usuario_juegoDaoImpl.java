package usuario_juego;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.conexion;
import formularios.inserjuego;
import login.loginDaoImpl;


public class usuario_juegoDaoImpl implements usuario_juegoDao {

	@Override
	public boolean registrar(usuario_juego usuario_juego) {
		
		boolean registrar = false;
		
		conexion con = new conexion();
		
		Statement stm= null;
		
		//INSERT INTO usuario_juego (idcli, idpro) VALUES ("1", "SELECT idpro from juego where juego.sesion = 0");
		
		//String a = "SELECT juego.idpro from juego where juego.sesion =  3 ";
		
		//String sql = "INSERT INTO usuario_juego (`idcli`,`idpro`) VALUES (1,"  + a + ")";
		
		
		System.out.println(inserjuego.contador);
		
		System.out.println("esto es del usuario juego");
		
		System.out.println("esto es del usuario juego");
		
		System.out.println("esto es del usuario juego");

		
		try {	
			
			
			stm = con.MySQLConnect().createStatement();
			
			
			int total=0;
			
			ResultSet rs = stm.executeQuery("SELECT juego.idpro as tot from juego where juego.sesion =" +  inserjuego.contador +  "");
			if (rs.next())
			{
				total = rs.getInt("tot");
			}
			
			
			System.out.println(total);
			
			String sql = "INSERT INTO usuario_juego (`idcli`,`idpro`) VALUES ('"+loginDaoImpl.id+"',  '"+total+"')";
			System.out.println(sql);
			stm.execute(sql);
			
			String sql1 = "UPDATE juego set sesion = 1 where sesion = " +  inserjuego.contador +  "";
			System.out.println(sql1);
			stm.execute(sql1);
			
			registrar=true;
			System.out.println("Nuevo usuario_juego registrado");
			stm.close();
	
		} catch (SQLException e) {
			System.out.println("Error: Clase usuario_juego, método registrar");
			e.printStackTrace();
		}
		return registrar;
	}

	@Override
	public boolean eliminar(int cod_juego) {
		
		Statement stm= null;		
		boolean eliminar=false;
				
		String sql="DELETE FROM usuario_juego WHERE idpro='"+cod_juego+"'";
		try {
			conexion con = new conexion();
			stm=con.MySQLConnect().createStatement();
			stm.execute(sql);
			eliminar=true;
			System.out.println("Juego ["+cod_juego+"] eliminado de la tabla intermedia");
		} catch (SQLException e) {
			System.out.println("Error: Clase usuario_juegoDaoImpl, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;

	}


	
}
