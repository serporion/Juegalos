package alquileres;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import conexion.conexion;
import formularios.alquilarjuego;


public class alquilerDaoImpl implements alquilerDao {

	@Override
	public boolean registrar(alquiler alquiler) {
		
		boolean registrar = false;
		
		conexion con = new conexion();
		
		Statement stm1 = null;
	    Statement stm2 = null;
	    Statement stm3 = null;
	    ResultSet rs1 = null;
	    ResultSet rs2 = null;
	    ResultSet rs3 = null;
		
		
		
		try {	
			
			
			stm1 = con.MySQLConnect().createStatement();
			
			int total=0;
			
			rs1 = stm1.executeQuery("SELECT idcli as tot from usuario_juego where idpro =" +  alquilarjuego.producto +  "");
			
			if (rs1.next())
			{
				total = rs1.getInt("tot");
			}
			
			rs1.close();
			stm1.close();
			
			
			Date fin=null;
			Date ini=null;
			
			
			boolean paso1 = false;
			boolean esUltimaFila = false;
			
			int conta=0;
						
			stm2 = con.MySQLConnect().createStatement();
			
			rs2 = stm2.executeQuery("SELECT count(*) as contador from alquiler where idpro = '"+alquiler.getIdpro()+"'");		
			
			if (rs2.next()) {
			
				System.out.println(rs2.getInt("contador"));
				
				
				conta = rs2.getInt("contador");
			
			}
			
			System.out.println("CONTA " + conta);
			
			rs2.close();
			stm2.close();
			
			System.out.println("PASA PASA PASA " );
			
			stm3 = con.MySQLConnect().createStatement();
			
			rs3 = stm3.executeQuery("SELECT fechainicio as feini, fechafinal as fefin from alquiler where idpro = '"+alquiler.getIdpro()+"' order by fechafinal");
			
			System.out.println("sigue sigue sigue");
			
						
			
			if (conta == 0) {
				
				paso1 = true;
				
			}else {	
			
			
				while (rs3.next()) {
					
					System.out.println("ENTRA ENTRA");
					
					if (rs3.isLast()) {
						
				        esUltimaFila = true;
	
				    }
					
					System.out.println("CONTA " + conta);
						
						
						ini = alquiler.getFechainicio();
						
						System.out.println("fecha ini  " + ini + " y getDate feini " + rs3.getDate("feini") );
						
						fin = rs3.getDate("fefin");
						
						
						System.out.print("si " + alquiler.getFechafinal());
						System.out.println(" es antes que " + rs3.getDate("feini"));
						
						
						String fecha1 = new SimpleDateFormat("yyyy-MM-dd").format(alquiler.getFechafinal());
		
						String fecha2 = new SimpleDateFormat("yyyy-MM-dd").format(rs3.getDate("feini"));
						
						
						System.out.println("esto que sale " + fecha1.equals(fecha2));
						
						System.out.println(paso1);
						
						if(ini.before(rs3.getDate("feini")) && (alquiler.getFechafinal().before(rs3.getDate("feini")) || fecha1.equals(fecha2)) ) {
							
							if (fecha1.equals(fecha2)) {
								//paso1 = true;
								System.out.println("hizo el break, pero fechas iguales"); //BORRAR
								break;
							}else {
								paso1 = true;
								System.out.println("hizo el break"); //BORRAR
								break;
							}
							
							
						}else if (alquiler.getFechainicio().after(fin) && esUltimaFila) {
							paso1 = true;
							break;
						}
						
						System.out.println("fecha ini  " + ini);
						System.out.println("fecha fin  " + fin);
						
						
						if (alquiler.getFechainicio().after(fin)) {
							
							ini = alquiler.getFechainicio();
							
							//paso1 = true;
						}else {
							paso1 = false;
						}
						
						System.out.println("fecha ini  MODIFICADA " + ini);

					}
			}
			
			if (paso1) {
				
				String sql = "INSERT INTO alquiler (`idalquiler`,`fechaalquiler`,`fechainicio`,`fechafinal`,`precio`,`usuprestador`,`usuprestatario`,`importetotal`,`idpro`) VALUES (NULL, '"+alquiler.getFechaalquiler()+"','"+alquiler.getFechainicio()+"','"+alquiler.getFechafinal()+"','"+alquiler.getPrecio()+"', '"+total+"', '"+alquiler.getUsuprestatario()+"','"+alquiler.getImportetotal()+"' ,'"+alquiler.getIdpro()+"' )";
				
				Statement stmInsert = con.MySQLConnect().createStatement();
				
				stmInsert.execute(sql);
				
				registrar=true;
				
				stmInsert.close();
				
				System.out.println("Nuevo alquiler registrado");
				
			}else {
				System.out.println("Juego alquilado en esas fechas. Busque otro día de inicio del alquiler o de final del mismo.");
			}
			
			System.out.println("fecha fin  " + fin);
			
		
	
		} catch (SQLException e) {
			System.out.println("Error: Clase alquilerDaoImpl, método registrar");
			e.printStackTrace();
		}
		
		return registrar;
	}
	
	
	public boolean eliminar(int cod_alqui) {

		Statement stm= null;		
		boolean eliminar=false;
				
		String sql="DELETE FROM alquiler WHERE idalquiler='"+cod_alqui+"'";
		try {
			conexion con = new conexion();
			stm=con.MySQLConnect().createStatement();
			stm.execute(sql);
			eliminar=true;
			System.out.println("Alquiler ["+cod_alqui+"] eliminado");
		} catch (SQLException e) {
			System.out.println("Error: Clase AlquilerDaoImpl, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
	}

public int Conteo() {
		
		int total=0;
		
		
		try {
			conexion con =new conexion();
			Statement st = con.MySQLConnect().createStatement();
			
			
			ResultSet rs = st.executeQuery("SELECT COUNT(idalquiler) AS total FROM alquiler"); //a where cliente = "+loginDaoImpl.id+"");
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
