package facturas;

import javax.swing.JOptionPane;

public class ControllerFactura {

	public void registrar (factura factura) {
			
			facturaDao dao = new  facturaDaoImpl();
			
			
			
			if(dao.registrar(factura)) 
				JOptionPane.showMessageDialog(null, "Factura registrada");
			else
				JOptionPane.showMessageDialog(null, "Error en la facturación");
			}

	public int ContarFacturas() {
		int total=0;
		facturaDao dao = new facturaDaoImpl();
		total=dao.Conteo();
		return total;
	}
	
	
	
	
}

