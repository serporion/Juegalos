package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import Acceso.BordeRedondo;
import Acceso.DiseñoyValida;
import Acceso.FondoPanel;
import conexion.conexion;
import facturas.ControllerFactura;
import login.loginDaoImpl;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class consultarfacturausu extends JFrame {

	private static final int is = 0;

	private JPanel contentPane;
	
	final JTable table=new JTable();
	public static int comienzo=0;
	public static int num=5;
	public static int total=0;
	public static int modificar_id;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultarfacturausu frame = new consultarfacturausu();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void RefreshTable(JTable table) {
		
		try {	  
				//ADD SCROLLPANE
			    JScrollPane scroll=new JScrollPane();
			    scroll.setBounds(48,43,688,103);
			    getContentPane().add(scroll);
			
			    //THE ROW
			    
			    ((DefaultTableModel) table.getModel()).setRowCount(0);
				conexion con = new conexion();
				Statement st = con.MySQLConnect().createStatement();
				
				
				ResultSet rs = st.executeQuery("SELECT fecha, descripcion, importealquiler, importeservicio,iva,importetotal FROM factura where cliente = "+loginDaoImpl.id+" LIMIT "+comienzo+","+num+"");
				
				
				while (rs.next()){
					Object [] filas = new Object[6];

			    for(int i=0;i<6;i++) {    	 
			    	filas[i] = rs.getObject(i+1);
			   
			    	}
			    
			    	
			    	((DefaultTableModel) table.getModel()).addRow(filas);
			    	((DefaultTableModel) table.getModel()).fireTableRowsUpdated(0,6);
			    	
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
}
	
		
	
	/**
	 * Create the frame.
	 */
	
	
	
	public consultarfacturausu() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		FondoPanel fondo = new FondoPanel();
		fondo.setBounds(0, 0, 784, 356);
		
		BordeRedondo border = new BordeRedondo(20);
		
		setTitle("TUS FACTURAS " +loginDaoImpl.us);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(230, 230, 250));
		contentPane_1.setBounds(0, 33, 784, 323);
		contentPane.add(contentPane_1);
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(40, 54, 688, 103);
		contentPane_1.add(scroll);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comienzo>0) {
					comienzo=comienzo-5;
					RefreshTable(table);
				}
				else
					JOptionPane.showMessageDialog(null, "No existen más datos");
			}
		});
		btnAnterior.setBounds(40, 202, 95, 23);
		btnAnterior.setBackground(null);
		DiseñoyValida.modifyButton(btnAnterior);
		btnAnterior.setBorder(border);
		contentPane_1.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comienzo+num<total) {

					comienzo=comienzo+5;
					RefreshTable(table);
					}
				else
					JOptionPane.showMessageDialog(null, "No existen más datos");
			}
		});
		btnSiguiente.setBounds(191, 202, 100, 23);
		btnSiguiente.setBackground(null);
		DiseñoyValida.modifyButton(btnSiguiente);
		btnSiguiente.setBorder(border);
		contentPane_1.add(btnSiguiente);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(629, 191, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		
		JLabel lblConsultaCliente = new JLabel("CONSULTA DE FACTURAS");
		DiseñoyValida.modifyLabel(lblConsultaCliente);
		lblConsultaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultaCliente.setBounds(40, 0, 688, 33);
		contentPane_1.add(lblConsultaCliente);
		
		
		ControllerFactura cont = new ControllerFactura();
		total=cont.ContarFacturas();
		comienzo=0;

		 try {

			
				conexion con =new conexion();
				Statement st = con.MySQLConnect().createStatement();
				ResultSet rs = st.executeQuery("SELECT fecha, descripcion, importealquiler, importeservicio,iva,importetotal FROM factura where cliente = "+loginDaoImpl.id+" LIMIT "+comienzo+","+num+"");
				

	    //THE TABLE
	    scroll.setViewportView(table);
	   
	    //THE MODEL OF OUR TABLE
	    DefaultTableModel model=new DefaultTableModel()
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

				default:
					return Boolean.class;
			}
	      }
	    };

	    
	    //ASSIGN THE MODEL TO TABLE
	    table.setModel(model);
	    
	    DiseñoyValida.ColorTabla(table);
	    
	    model.addColumn("Fecha ");
	    model.addColumn("Descripción");
	    model.addColumn("Importe");
	    model.addColumn("Servicio");
	    model.addColumn("Iva ");
	    model.addColumn("Total");
	    
	    
	    //PREDEFINE EL ANCHO DE LA COLUMNA AL ANCHO DE SU ETIQUETA
	    
	    TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        TableColumn tableColumn = columnModel.getColumn(column);
	        int preferredWidth = tableColumn.getHeaderValue().toString().length()*8;// EL 5 ES PARA EL AJUSTE ENTRE COLUMNA Y DATO
	        tableColumn.setPreferredWidth(preferredWidth);
	    }

	    //THE ROW
		while (rs.next()){
			Object [] filas = new Object[6];

	    for(int i=0;i<6;i++) {    	 
	    	filas[i] = rs.getObject(i+1);
	    	}
	    
	    	((DefaultTableModel) table.getModel()).addRow(filas);     
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
		
		
	}
}
