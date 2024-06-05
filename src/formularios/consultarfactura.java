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
import javax.swing.JTextField;

public class consultarfactura extends JFrame {

	private JPanel contentPane;
	
	final JTable table=new JTable();
	public static int comienzo=0;
	public static int num=5;
	public static int total=0;
	public static int modificar_id;
	public static int id_juegos;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultarfactura frame = new consultarfactura();
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
				ResultSet rs = st.executeQuery("SELECT idfact, fecha, cliente, descripcion, importealquiler, importeservicio,iva,importetotal,idalquiler,abono FROM factura LIMIT "+comienzo+","+num+"");

				
				while (rs.next()){
					Object [] filas = new Object[10];

			    for(int i=0;i<10;i++) {    	 
			    	filas[i] = rs.getObject(i+1);
			   
			    	}
			    
			    	
			    	((DefaultTableModel) table.getModel()).addRow(filas);
			    	((DefaultTableModel) table.getModel()).fireTableRowsUpdated(0,5);
			    	
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
	public consultarfactura() {
		

		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		FondoPanel fondo = new FondoPanel();
		fondo.setBounds(10, 0, 763, 356);
		
		BordeRedondo border = new BordeRedondo(20);
		
		
		setTitle("GESTION DE FACTURAS");
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
		contentPane_1.setBounds(10, 11, 763, 356);
		contentPane.add(contentPane_1);
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(40, 67, 688, 103);
		contentPane_1.add(scroll);
		
		txtid = new JTextField();
		DiseñoyValida.validanumero(txtid);
		txtid.setBounds(253, 274, 86, 20);
		contentPane_1.add(txtid);
		txtid.setColumns(10);
		
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
		btnAnterior.setBounds(40, 213, 127, 23);
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
		btnSiguiente.setBounds(222, 213, 117, 23);
		btnSiguiente.setBackground(null);
		DiseñoyValida.modifyButton(btnSiguiente);
		btnSiguiente.setBorder(border);
		contentPane_1.add(btnSiguiente);
		
		
		JButton btnModificar = new JButton("Buscar por ID");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			if (txtid.getText().length()==0){
				JOptionPane.showMessageDialog(null, "Debe buscar por un número"); 
				RefreshTable(table);
				
			}else
			
			try {
				conexion con = new conexion();
				Statement st = con.MySQLConnect().createStatement();
				System.out.println(txtid.getText());
				ResultSet rs = st.executeQuery("SELECT idfact, fecha, cliente, descripcion, importealquiler, importeservicio,iva,importetotal,idalquiler,abono FROM factura where cliente = "+txtid.getText()+" LIMIT "+comienzo+","+num+""); //(\"%"+textbusqueda.getText()+"%\")  order by nombre LIMIT "+comienzo+","+num+"");
				//SELECT juego.idpro, nombre, juego.precio, categoria, descripcion, edicion from juego left join alquiler on juego.idpro = alquiler.idpro where (alquiler.idpro is null || alquiler.fechafinal < curdate() and nombre like("%go%")) order by nombre;
	  
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
						case 6:
							return Object.class;
						case 7:
							return Object.class;
						case 8:
							return Object.class;
						case 9:
							return Object.class;
						default:
							return Boolean.class;
					}
			      }
			    };

			    
			    //ASSIGN THE MODEL TO TABLE
			    table.setModel(model);
			    
			    DiseñoyValida.ColorTabla(table);
			    model.addColumn("Número");
			    model.addColumn("Fecha      ");
			    model.addColumn("Cliente");
			    model.addColumn("Descripción                 ");
			    model.addColumn("Importe");
			    model.addColumn("Servicio");
			    model.addColumn("Iva");
			    model.addColumn("Total Factura");
			    model.addColumn("Alquiler");
			    model.addColumn("Abono");
			    

			    //PREDEFINE EL ANCHO DE LA COLUMNA AL ANCHO DE SU ETIQUETA
			    
			    TableColumnModel columnModel = table.getColumnModel();
			    for (int column = 0; column < table.getColumnCount(); column++) {
			        TableColumn tableColumn = columnModel.getColumn(column);
			        int preferredWidth = tableColumn.getHeaderValue().toString().length()*4;// EL 5 ES PARA EL AJUSTE ENTRE COLUMNA Y DATO
			        tableColumn.setPreferredWidth(preferredWidth);
			    }

			    //THE ROW
				while (rs.next()){
					Object [] filas = new Object[10];

			    for(int i=0;i<10;i++) {    	 
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
		});
		
		btnModificar.setBounds(40, 273, 152, 23);
		btnModificar.setBackground(null);
		DiseñoyValida.modifyButton(btnModificar);
		btnModificar.setBorder(border);
		contentPane_1.add(btnModificar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(629, 251, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		
		JLabel lblConsultaCliente = new JLabel("CONSULTA DE FACTURAS EMITIDAS");
		lblConsultaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		DiseñoyValida.modifyLabel(lblConsultaCliente);
		lblConsultaCliente.setBounds(40, 3, 688, 40);
		contentPane_1.add(lblConsultaCliente);
		
		
		ControllerFactura cont = new ControllerFactura();
		total=cont.ContarFacturas();
		comienzo=0;
		
		
		 try {

			
				conexion con =new conexion();
				Statement st = con.MySQLConnect().createStatement();
				ResultSet rs = st.executeQuery("SELECT idfact, fecha, cliente, descripcion, importealquiler, importeservicio,iva,importetotal,idalquiler,abono FROM factura LIMIT "+comienzo+","+num+"");		

				

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
				case 6:
					return Object.class;
				case 7:
					return Object.class;
				case 8:
					return Object.class;
				case 9:
					return Object.class;

				default:
					return Boolean.class;
			}
	      }
	    };

	    
	    //ASSIGN THE MODEL TO TABLE
	    table.setModel(model);
	    
	    DiseñoyValida.ColorTabla(table);
	    
	    model.addColumn("Número");
	    model.addColumn("Fecha       ");
	    model.addColumn("Cliente");
	    model.addColumn("Descripción                 ");
	    model.addColumn("Importe");
	    model.addColumn("Servicio");
	    model.addColumn("Iva");
	    model.addColumn("Total Factura");
	    model.addColumn("Alquiler");
	    model.addColumn("Abono");
	    

	  //PREDEFINE EL ANCHO DE LA COLUMNA AL ANCHO DE SU ETIQUETA
	    
	    TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        TableColumn tableColumn = columnModel.getColumn(column);
	        int preferredWidth = tableColumn.getHeaderValue().toString().length()*3;// EL 5 ES PARA EL AJUSTE ENTRE COLUMNA Y DATO
	        tableColumn.setPreferredWidth(preferredWidth);
	    }
	 

	    //THE ROW
		while (rs.next()){
			Object [] filas = new Object[10];

	    for(int i=0;i<10;i++) {    	 
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
