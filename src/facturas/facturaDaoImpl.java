package facturas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.conexion;
import login.loginDaoImpl;


public class facturaDaoImpl implements facturaDao {

	@Override
	public boolean registrar(factura factura) {
		
		boolean registrar = false;
		
		conexion con = new conexion();
		
		Statement stm= null;
		
		
		
		String sql = "INSERT INTO factura (`idfact`,`fecha`,`cliente`,`descripcion`,`importealquiler`,`importeservicio`,`iva`,`importetotal`,`idalquiler`,`abono`) VALUES (NULL, '"+factura.getFecha()+"','"+factura.getCliente()+"','"+factura.getDescripcion()+"', '"+factura.getImportealquiler()+"', '"+factura.getImporteservicio()+"', '"+factura.getIva()+"', '"+factura.getImportetotal()+"', '"+factura.getIdalquiler()+"', '"+factura.getAbono()+"')";
		
		System.out.println(sql);
	
		try {	
			
			
			stm = con.MySQLConnect().createStatement();
			stm.execute(sql);
			registrar=true;
			System.out.println("Nueva factura registrada");
			stm.close();
	
		} catch (SQLException e) {
			System.out.println("Error: Clase facturaDaoImpl, método registrar");
			e.printStackTrace();
		}
		return registrar;
	}

public int Conteo() {
		
		int total=0;
		
		
		try {
			conexion con =new conexion();
			Statement st = con.MySQLConnect().createStatement();
			
			
			ResultSet rs = st.executeQuery("SELECT COUNT(idfact) AS total FROM factura where cliente = "+loginDaoImpl.id+"");
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
