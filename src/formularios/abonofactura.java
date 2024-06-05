package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import conexion.conexion;
import facturas.ControllerFactura;
import facturas.factura;
import Acceso.BordeRedondo;
import Acceso.DiseñoyValida;
import Acceso.FondoPanel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class abonofactura extends JFrame {

	private JPanel contentPane;
	
	final JTable table=new JTable();
	DefaultTableModel model;
	public static String col;
	public static Date fechaactual;
	public static Date fechita;
	public static Date fechaza;
	public static boolean paso = true;
	public static int producto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					abonofactura frame = new abonofactura();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public abonofactura() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		Acceso.FondoPanel fondo = new FondoPanel();
		fondo.setBounds(10, 0, 759, 379);
		
		setTitle("ABONO DE FACTURAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(230, 230, 250));
		contentPane_1.setBounds(10, 11, 748, 353);
		contentPane.add(contentPane_1);
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		
		BordeRedondo border = new BordeRedondo(20);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(39, 73, 699, 150);
		contentPane_1.add(scroll);
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(639, 265, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		
		JLabel lblAlquiJuego = new JLabel("ABONO DE FACTURAS");
		DiseñoyValida.modifyLabel(lblAlquiJuego);
		lblAlquiJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlquiJuego.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAlquiJuego.setBounds(0, 22, 748, 22);
		contentPane_1.add(lblAlquiJuego);
		
		
		
		try {
		 	conexion con = new conexion();
			Statement st = con.MySQLConnect().createStatement();
			//SELECT * FROM factura WHERE idalquiler NOT IN (SELECT idalquiler FROM factura GROUP BY idalquiler HAVING COUNT(*) = 2 );
			//SELECT * FROM factura WHERE idalquiler NOT IN (SELECT MIN(idalquiler) FROM factura  GROUP BY idalquiler HAVING COUNT(*) = 2 AND MIN(fecha) = (SELECT MIN(fecha) FROM factura GROUP BY idalquiler  HAVING COUNT(*) = 2 ORDER BY fecha ASC LIMIT 1));
			//SELECT MIN(idalquiler), MIN(fecha) as fecha_minima, COUNT(*) as cantidad FROM factura GROUP BY idalquiler HAVING COUNT(*) >= 2 ORDER BY fecha_minima ASC LIMIT 1;
			//SELECT * FROM factura WHERE idalquiler IN (SELECT idalquiler FROM factura GROUP BY idalquiler HAVING COUNT(*) >= 2 AND fecha = (SELECT fecha FROM factura GROUP BY idalquiler HAVING COUNT(*) >= 1 ORDER BY fecha ASC LIMIT 1));
			//SELECT * FROM factura WHERE idalquiler NOT IN (SELECT idalquiler FROM factura GROUP BY idalquiler HAVING COUNT(*) > 1 ); 
			ResultSet rs = st.executeQuery("SELECT * FROM factura WHERE idalquiler NOT IN (SELECT idalquiler FROM factura GROUP BY idalquiler HAVING COUNT(*) > 1 ); ");
  
			scroll.setViewportView(table);
			

			model=new DefaultTableModel()
			{
				
				public Class<?> getColumnClass(int column)
				{
					
					switch(column)
					{
					case 0:
						return Object.class;
					case 1:
						return Object.class;
					case 2:
						return Object.class;
					case 3:
						return Object.class;
					case 4:
						return Object.class;
					case 5:
						return Object.class;
					case 6:
						return Object.class;
					case 7:
						return Object.class;
					case 8:
						return Object.class;
					case 9:
						return Boolean.class;
		
					default:
						return Object.class;
					
        }
      }
    };
		

		    table.setModel(model);
		    
		    DiseñoyValida.ColorTabla(table);
		  
		    
		    model.addColumn("Id");
		    model.addColumn("Fecha     ");
		    //model.addColumn("Fecha Alta");
		    model.addColumn("Cliente");
		    model.addColumn("Descripcion               ");
		    model.addColumn("Importe");
		    model.addColumn("Servicio");
		    model.addColumn("Iva");
		    model.addColumn("Total");
		    model.addColumn("Idalquiler");
		    model.addColumn("Abonar");
    
    
		    //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		    
		    //PREDEFINE EL ANCHO DE LA COLUMNA AL ANCHO DE SU ETIQUETA
		    
		    TableColumnModel columnModel = table.getColumnModel();
		    for (int column = 0; column < table.getColumnCount(); column++) {
		        TableColumn tableColumn = columnModel.getColumn(column);
		        int preferredWidth = tableColumn.getHeaderValue().toString().length()*5;// EL 5 ES PARA EL AJUSTE ENTRE COLUMNA Y DATO
		        tableColumn.setPreferredWidth(preferredWidth);
		    }
		
		    //MODIFICA LOS VALORES Y LA HACE OCULTA AL OJO HUMANO
		    
		    table.getColumnModel().getColumn(0).setMinWidth(0);
		    table.getColumnModel().getColumn(0).setMaxWidth(0);
		    table.getColumnModel().getColumn(0).setWidth(0);
		    table.getColumnModel().getColumn(0).setPreferredWidth(0);
		    table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		    table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		    model.fireTableDataChanged(); 
		    

	    	//THE ROW
			while (rs.next()){
				Object [] filas = new Object[9];
	
				for(int i=0;i<9;i++) {    	 
					filas[i] = rs.getObject(i+1);
				}
	    
				((DefaultTableModel) table.getModel()).addRow(filas);     
				((DefaultTableModel) table.getModel()).fireTableRowsUpdated(0,5);
			}
		
			for(int i=0;i<table.getRowCount();i++) {    	 
				model.setValueAt(false,i,9);
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
		
		Calendar c2 = new GregorianCalendar();
			
		JDateChooser jdcfecha = new JDateChooser();
		jdcfecha.getCalendarButton().setVisible(false);
		jdcfecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		jdcfecha.setEnabled(false);
		jdcfecha.setBounds(39, 55, 110, 20);
		jdcfecha.setCalendar(c2);
		contentPane_1.add(jdcfecha);
		
		
		JButton btnAbonar = new JButton("Abonar");
		btnAbonar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("Esto abonará la factura");
				
				for(int i=0;i<table.getRowCount();i++)
		        {
		          Boolean checked=Boolean.valueOf(table.getValueAt(i, 9).toString());
		          
		          col=table.getValueAt(i, 0).toString();
		          
		          
		          if(checked)
		          {
		        	  
		        	  System.out.println(col);
		        	  
		        	  int precio = (int) table.getValueAt(i, 4);
		        	  
		        	  String des=table.getValueAt(i, 3).toString();
			          
			          int alq = (int) table.getValueAt(i,8);
			
		        	  BigDecimal cargos = (BigDecimal) table.getValueAt(i,7);
		        	  
		        	  double car = ((double) cargos.doubleValue());
		        	  
		        	  int cliente = (int) table.getValueAt(i, 2);
		        	
		        	  paso = false;
		        	  
		        	
		        	  int confirmado = JOptionPane.showConfirmDialog(
		        			  null, "Va a abonar la factura con Id : "+col+". ¿Está seguro?", 
		        			  "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		        			if (JOptionPane.OK_OPTION == confirmado) {
		        				
		        				Date date0 = jdcfecha.getDate(); 
		        				long d0 = date0.getTime(); 
		        				java.sql.Date fechahoy = new java.sql.Date(d0);
		        				
		        				fechaactual = fechahoy;
		  
		        				String abonos = "AB"+alq;
		        				
		        				System.out.println(abonos);
		  		        		
		        				
		        				factura abonofact = new factura (fechahoy, cliente, des, precio*-1, -1.5 , -0.315, car*-1, alq, abonos );
		        						        				
		        				ControllerFactura abono = new ControllerFactura();
		        				
		        				abono.registrar(abonofact);
		        				
		        				model.removeRow(i); 
		        				i=i-1;
		        				
		  		        	}
		  		        		

		        			else 
		        				JOptionPane.showMessageDialog(null, "Abono no realizado"); 
	
				
		          		} 
		        	}
				if (paso) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una factura para abonarla");
				}
			}
		});
		btnAbonar.setBounds(52, 276, 110, 23);
		btnAbonar.setBackground(null);
		DiseñoyValida.modifyButton(btnAbonar);
		btnAbonar.setBorder(border);
		contentPane_1.add(btnAbonar);
				
		

	}
	
	
}
