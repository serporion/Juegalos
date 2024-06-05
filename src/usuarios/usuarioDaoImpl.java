package usuarios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import conexion.conexion;

public class usuarioDaoImpl implements usuarioDao {

	public boolean registrar(usuario usuario) {
		
		boolean registrar = false;
		
		conexion con = new conexion();
		
		Statement stm= null;
		
		String sql = "INSERT INTO usuario (`idcli`,`fechaalta`,`dni`,`nombre`,`apellidos`,`direccion`,`cp`,`telefono`,`poblacion`,`provincia`,`formapago`,`tarjeta`) VALUES (NULL,'"+usuario.getFechaalta()+"' , '"+usuario.getDni()+"','"+usuario.getNombre()+"', '"+usuario.getApellidos()+"', '"+usuario.getDireccion()+"', '"+usuario.getCp()+"','"+usuario.getTelefono()+"', '"+usuario.getPoblacion()+"','"+usuario.getProvincia()+"','"+usuario.getFormapago()+"','"+usuario.getTarjeta()+"')"; 
		try {	
			
			
			stm = con.MySQLConnect().createStatement();
			stm.execute(sql);
			registrar=true;
			System.out.println("Nuevo usuario registrado");
			stm.close();
	
		} catch (SQLException e) {
			System.out.println("Error: Clase usuariolDaoImpl, método registrar");
			e.printStackTrace();
		}
		return registrar;
	}

	@Override
	public boolean actualizar( String an, String mode, int indicee) {
		
		
		boolean actualizar=false;
		
		conexion con = new conexion();
		
		Statement stm= null;
		
		//String sql="UPDATE usuario SET " +an+ "=  '"+mode+"', apellidos='"+usuario.getApellidos()+"', dni='"+usuario.getDni()+"', direccion='"+usuario.getDireccion()+"', codigopostal='"+usuario.getCp()+"' telefono='"+usuario.getTelefono()+"', poblacion='"+usuario.getPoblacion()+"', provincia='"+usuario.getProvincia()+"', formadepago='"+usuario.getFormapago()+"' WHERE idcli='"+usuario.getIdcli()+"'";
		String sql="UPDATE usuario SET " +an+ "=  '"+mode+"' WHERE idcli='"+indicee+"'";
		
		try {
			
			stm=con.MySQLConnect().createStatement();
			stm.executeUpdate(sql);
			actualizar=true;
			//System.out.println("usuario ID ["+usuario.getCod_usuario()+"] actualizado");
			System.out.println("usuario ID ["+indicee+"] actualizado");
		} catch (SQLException e) {
			System.out.println("Error: Clase usuariolDaoImple, método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
		
	}

	//ANULO ESTA CLASE QUE ELIMINA EL USUARIO EN LA TABLA USUARIOS, SOLO SE ELIMINA DE LA TABLA LOGIN
	
	/*
	 	@Override
	public boolean eliminar(int idcli) {
		
		boolean eliminar=false;
		
		conexion con = new conexion();
		
		Statement stm= null;		
		
				
		//String sql="DELETE FROM login WHERE idusuario ='"+idcli+"'";
		String sql="DELETE FROM usuario WHERE idcli ='"+idcli+"'";
		try {
			
			stm=con.MySQLConnect().createStatement();
			stm.execute(sql);
			eliminar=true;
			System.out.println("Cliente ID ["+idcli+"] eliminado del acceso al programa, no de la tabla Usuario");
		} catch (SQLException e) {
			System.out.println("Error: Clase usuarioDaoImpl, m�todo eliminar");
			e.printStackTrace();
		}		
		return eliminar;
		
		
	}
*/
	
	@Override
	public usuario obtener_usuario(int idcli) {
		
		
		usuario a = new usuario();
		
		conexion con = new conexion();
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM usuario WHERE idcli='"+idcli+"'";
		System.out.println(sql);
		
		try {
			
			
			stm=con.MySQLConnect().createStatement();
			rs=stm.executeQuery(sql);
			if (rs.next())
			{
				a.setIdcli(rs.getInt("cod_cliente"));
				a.setNombre(rs.getString("nombre"));
				a.setApellidos(rs.getString("apellidos"));
				a.setDni(rs.getString("dni"));
				a.setDireccion(rs.getString("direccion"));
				a.setTelefono(rs.getString("telefono"));
				
			}
	
			stm.close();
			rs.close();

	} catch (SQLException e) {
		System.out.println("Error: Clase UsuaruioDaoImpl, método obtener_usuario");
		e.printStackTrace();
	}
		return a;
		
	}

	@Override
	public List<usuario> obtener() {
		
		conexion con = new conexion();
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM usuario ORDER BY idcli";
		
		List<usuario> listaUsuario= new ArrayList<usuario>();
		
		try {			
			
			stm=con.MySQLConnect().createStatement();
			rs=stm.executeQuery(sql);
			
			while (rs.next()) {
				usuario a=new usuario();
				a.setIdcli(rs.getInt("idcli"));
				a.setNombre(rs.getString("nombre"));
				a.setApellidos(rs.getString("apellidos"));
				a.setDni(rs.getString("dni"));
				a.setDireccion(rs.getString("direccion"));
				a.setTelefono(rs.getString("telefono"));
				
				listaUsuario.add(a);
			}
			stm.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error: ClaseClienteloDaoImple, método obtener");
			e.printStackTrace();
		}
		
		return listaUsuario;
		
	}

	@Override
	public int Conteo() {
		
		int total=0;
		
		try {
			conexion con =new conexion();
			Statement st = con.MySQLConnect().createStatement();
			
			
			ResultSet rs = st.executeQuery("SELECT COUNT(idcli) AS total FROM usuario");
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
