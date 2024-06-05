package login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import formularios.entradalogin;
import formularios.menuacceso;
import formularios.menuaccesousu;
import conexion.conexion;


public class loginDaoImpl implements loginDao {

	public static int id;
	public static String us;
	public static String saa;
	

	@Override
	public boolean comprobar (login login) {
		
		boolean comprobar = false;

		
		char[] contrasenachars = login.getContrasena();
		
		System.out.println(contrasenachars);
		
		byte[] contrasenaBytes = new String(contrasenachars).getBytes();
		
		System.out.println(contrasenaBytes);
		
		try {
			conexion con = new conexion();
			Statement st = con.MySQLConnect().createStatement();
			ResultSet rs = st.executeQuery("SELECT idusuario, login.usuario, usuario.nombre, contrasena FROM login,usuario where login.idusuario = usuario.idcli");
			
			
			while (rs.next()){
	
			//Arrays.equals(passwordBytes, enteredPasswordBytes))
				
				
			//	if ((rs.getString("login.usuario").equals(login.getUsuario())) && (rs.getString("contrasena").equals(login.getContrasena())))
			//	if ((rs.getString("login.usuario").equals(login.getUsuario())) && (rs.getBytes("contrasena1").equals(contrasenachars)))

				if ((rs.getString("login.usuario").equals(login.getUsuario())) && (Arrays.equals(rs.getBytes("contrasena"), contrasenaBytes)))
					
					{
					if (rs.getString("login.usuario").equals("00000000A")){
						
						menuacceso pata = new formularios.menuacceso();
						pata.setLocationRelativeTo(null);
						pata.setVisible(true);
						us = rs.getString("usuario.nombre");
						id= rs.getInt("idusuario");
					
					System.out.println("parece que lo hace ok");
					System.out.println(us);
					System.out.println(entradalogin.usuarioactivo);
		
					
					}else {
						
						menuaccesousu patas = new menuaccesousu();
						patas.setLocationRelativeTo(null);
						System.out.println("esto es el usuario recogido");
						us = rs.getString("usuario.nombre");
						patas.setVisible(true);
						System.out.println(us);
						String pru = us;
						System.out.println(saa);
						id= rs.getInt("idusuario");
						System.out.println(login.getUsuario());
						System.out.println(entradalogin.usuarioactivo);
						//System.out.println(login.getIdusuario());
						
						
					}
					
					return true;
				
			}	else {
					System.out.println("CACA ES");
					
				
					// ESTO DE AQUÍ ABAJO SOLO SIRVE PARA HACER LA COMPARACIÓN ENTRE CONTRESEÑAS, VER QUE ES LO QUE SE COTEJA
					boolean passwordsMatch = true;
					if ((rs.getBytes("contrasena").length != contrasenaBytes.length)) {
					    passwordsMatch = false;
					} else {
					    for (int i = 0; i < rs.getBytes("contrasena").length; i++) {
					        if (rs.getBytes("contrasena")[i] != contrasenaBytes[i]) {
					        	System.out.println("u" + rs.getBytes("contrasena")[i]);
					        	System.out.println("x" + contrasenaBytes[i]);
					            passwordsMatch = false;
					            //break;
					        }
					    }
					}

					if (passwordsMatch) {
					    // Las contraseñas coinciden
					} else {
					    // Las contraseñas no coinciden
					}
					
				}
					
				
			}
		
			
			return comprobar;// CREO QUE ESTA LINEA SOBRA.

	    
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
		
		return comprobar;
	
		}



	public int Conteo() {
		
		int total=0;
		
		try {
			conexion con =new conexion();
			Statement st = con.MySQLConnect().createStatement();
			
			
			ResultSet rs = st.executeQuery("SELECT COUNT(idusuario) AS total FROM login");
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
	
	@Override
	public boolean eliminar(int idcli) {
		
		boolean eliminar=false;
		
		conexion con = new conexion();
		
		Statement stm= null;		
		
				
		String sql="DELETE FROM login WHERE idusuario ='"+idcli+"'";
		//String sql="DELETE FROM usuario WHERE idcli ='"+idcli+"'";
		try {
			
			stm=con.MySQLConnect().createStatement();
			stm.execute(sql);
			eliminar=true;
			System.out.println("RECUERDE: Cliente ID ["+idcli+"] eliminado del acceso al programa, no de la tabla de Usuarios");
		} catch (SQLException e) {
			System.out.println("Error: Clase usuarioDaoImpl, m�todo eliminar");
			e.printStackTrace();
		}		
		return eliminar;
		
	
	
	}


	
	@Override
	public boolean registrar(login login) {
		
		boolean registrar = false;
		
		conexion con = new conexion();
		
		Statement stm= null;
		
		String sql = "INSERT INTO login (`idusuario`,`usuario`,`contrasena`) VALUES ('"+login.getIdusuario()+"','"+login.getUsuario()+"','"+login.getContrasena()+"')"; 
		try {	
			
			
			stm = con.MySQLConnect().createStatement();
			stm.execute(sql);
			registrar=true;
			System.out.println("Nuevo login registrado");
			stm.close();
	
		} catch (SQLException e) {
			System.out.println("Error: Clase loginDaoImpl, método registrar");
			e.printStackTrace();
		}
		return registrar;
	}
	

	
public int BuscaId(String idusunuevo) {
		
		int total=0;
		
		try {
			conexion con =new conexion();
			Statement st = con.MySQLConnect().createStatement();
			
			
			ResultSet rs = st.executeQuery("SELECT idcli AS total FROM usuario where dni = '"+idusunuevo+"'");
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