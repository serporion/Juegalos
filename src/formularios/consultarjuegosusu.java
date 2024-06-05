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
import juegos.ControllerJuego;

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

public class consultarjuegosusu extends JFrame {

	private JPanel contentPane;
	
	final JTable table=new JTable();
	public static int comienzo=0;
	public static int num=5;
	public static int total=0;
	public static int modificar_id;
	public static int id_juegos;
	private JTextField textbusquenombre;
	private JTextField textbusquecategoria;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultarjuegosusu frame = new consultarjuegosusu();
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
			    scroll.setBackground(Color.pink);
			    scroll.setForeground(Color.pink);
			    scroll.setBounds(48,43,688,103);
			    getContentPane().add(scroll);
			
			    //THE ROW
			    
			    ((DefaultTableModel) table.getModel()).setRowCount(0);
			    
				conexion con = new conexion();
				Statement st = con.MySQLConnect().createStatement();
				ResultSet rs = st.executeQuery("SELECT juego.nombre,juego.fechaalta,juego.categoria,juego.descripcion,juego.edicion,juego.precio,juego.plataforma FROM juego order by nombre LIMIT "+comienzo+","+num+"");

				
				while (rs.next()){
					Object [] filas = new Object[7];

			    for(int i=0;i<7;i++) {    	 
			    	filas[i] = rs.getObject(i+1);
			   
			    	}
			    
			    	
			    	((DefaultTableModel) table.getModel()).addRow(filas);
			    	((DefaultTableModel) table.getModel()).fireTableRowsUpdated(0,7);
			    	
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
	public consultarjuegosusu() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		Acceso.FondoPanel fondo = new FondoPanel();
		fondo.setBounds(0, 0, 784, 356);
		
		BordeRedondo border = new BordeRedondo(20);
		
		setTitle("JUEGOS EN LA APLICACION");
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
		contentPane_1.setBounds(0, 11, 784, 356);
		contentPane.add(contentPane_1);
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		
		
		JLabel lblConsultaCliente = new JLabel("CONSULTA DE JUEGOS DISPONIBLES");
		lblConsultaCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		DiseñoyValida.modifyLabel(lblConsultaCliente);
		lblConsultaCliente.setBounds(40, 11, 688, 32);
		contentPane_1.add(lblConsultaCliente);
		
		
		
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
		btnAnterior.setBounds(40, 181, 100, 23);
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
		btnSiguiente.setBounds(218, 181, 100, 23);
		
		btnSiguiente.setBackground(null);
		DiseñoyValida.modifyButton(btnSiguiente);
		btnSiguiente.setBorder(border);
		contentPane_1.add(btnSiguiente);
		  
	
		
		JButton btnbuscar = new JButton("Por nombre");
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 	conexion con = new conexion();
					Statement st = con.MySQLConnect().createStatement();
					ResultSet rs = st.executeQuery("SELECT juego.nombre,juego.fechaalta,juego.categoria,juego.descripcion,juego.edicion,juego.precio,juego.plataforma FROM juego where nombre like(\"%"+textbusquenombre.getText()+"%\")  order by nombre LIMIT "+comienzo+","+num+"");
					//SELECT juego.idpro, nombre, juego.precio, categoria, descripcion, edicion from juego left join alquiler on juego.idpro = alquiler.idpro where (alquiler.idpro is null || alquiler.fechafinal < curdate() and nombre like("%go%")) order by nombre;
		  
					scroll.setViewportView(table);

					
					
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

							default:
								return Boolean.class;
						}
				      }
				    };


				    //ASSIGN THE MODEL TO TABLE
				    table.setModel(model);
				    
				    DiseñoyValida.ColorTabla(table);
				    
				    //textbusqueda = new JTextField();
				    //textbusqueda.setBounds(381, 286, 96, 19);
				    //contentPane_1.add(textbusqueda);
				    //textbusqueda.setColumns(10);
				

				    model.addColumn("Nombre               ");
				    model.addColumn("Fecha Alta");
				    model.addColumn("Categoría");
				    model.addColumn("Descripción          ");
				    model.addColumn("Edición");
				    model.addColumn("Precio");
				    model.addColumn("Plataforma");
				    

				    TableColumnModel columnModel = table.getColumnModel();
				    for (int column = 0; column < table.getColumnCount(); column++) {
				        TableColumn tableColumn = columnModel.getColumn(column);
				        int preferredWidth = tableColumn.getHeaderValue().toString().length()*10;// EL NUMERO ES PARA EL AJUSTE ENTRE COLUMNA Y DATO
				        tableColumn.setPreferredWidth(preferredWidth);
				    }
	
				    //THE ROW
					while (rs.next()){
						Object [] filas = new Object[7];

				    for(int i=0;i<7;i++) {    	 
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
		btnbuscar.setBounds(40, 257, 128, 23);
		
		btnbuscar.setBackground(null);
		DiseñoyValida.modifyButton(btnbuscar);
		btnbuscar.setBorder(border);
		contentPane_1.add(btnbuscar);
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(590, 257, 112, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		

		
		ControllerJuego cont = new ControllerJuego();
		total=cont.ContarJuegos();
		comienzo=0;
		
		
		 try {

			
				conexion con =new conexion();
				Statement st = con.MySQLConnect().createStatement();
				ResultSet rs = st.executeQuery("SELECT juego.nombre,juego.fechaalta,juego.categoria,juego.descripcion,juego.edicion,juego.precio,juego.plataforma FROM juego order by nombre LIMIT "+comienzo+","+num+"");		

				

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
		
				default:
					return Boolean.class;
			}
	      }
	    };

	    
	    //ASSIGN THE MODEL TO TABLE
	    table.setModel(model);

	    
	    DiseñoyValida.ColorTabla(table);
	   
	    
	    textbusquenombre = new JTextField();
	    textbusquenombre.setBounds(190, 257, 128, 23);
	    contentPane_1.add(textbusquenombre);
	    textbusquenombre.setColumns(10);
	    
	    JLabel lblbuscar = new JLabel("Búsquedas");
	    lblbuscar.setBounds(41, 232, 75, 14);
	    DiseñoyValida.modifyLabel(lblbuscar);
	    contentPane_1.add(lblbuscar);
	    
	    textbusquecategoria = new JTextField();
	    textbusquecategoria.setColumns(10);
	    textbusquecategoria.setBounds(190, 288, 128, 23);
	    contentPane_1.add(textbusquecategoria);
	    
	    JButton btncategoria = new JButton("Por categoría");
	    btncategoria.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
				 	conexion con = new conexion();
					Statement st = con.MySQLConnect().createStatement();
					ResultSet rs = st.executeQuery("SELECT juego.nombre,juego.fechaalta,juego.categoria,juego.descripcion,juego.edicion,juego.precio,juego.plataforma FROM juego where categoria like(\"%"+textbusquecategoria.getText()+"%\")  order by nombre LIMIT "+comienzo+","+num+"");
					//SELECT juego.idpro, nombre, juego.precio, categoria, descripcion, edicion from juego left join alquiler on juego.idpro = alquiler.idpro where (alquiler.idpro is null || alquiler.fechafinal < curdate() and nombre like("%go%")) order by nombre;
		  
					scroll.setViewportView(table);

					
					
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

							default:
								return Boolean.class;
						}
				      }
				    };


				    //ASSIGN THE MODEL TO TABLE
				    table.setModel(model);
				    
				    DiseñoyValida.ColorTabla(table);
	

				    model.addColumn("Nombre               ");
				    model.addColumn("Fecha Alta");
				    model.addColumn("Categoría");
				    model.addColumn("Descripción          ");
				    model.addColumn("Edición");
				    model.addColumn("Precio");
				    model.addColumn("Plataforma");
				    

				    TableColumnModel columnModel = table.getColumnModel();
				    for (int column = 0; column < table.getColumnCount(); column++) {
				        TableColumn tableColumn = columnModel.getColumn(column);
				        int preferredWidth = tableColumn.getHeaderValue().toString().length()*10;// EL NUMERO ES PARA EL AJUSTE ENTRE COLUMNA Y DATO
				        tableColumn.setPreferredWidth(preferredWidth);
				    }
	
				    //THE ROW
					while (rs.next()){
						Object [] filas = new Object[7];

				    for(int i=0;i<7;i++) {    	 
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
	    btncategoria.setBackground(null);
		DiseñoyValida.modifyButton(btncategoria);
		btncategoria.setBorder(border);
	    btncategoria.setBounds(40, 291, 128, 23);
	    contentPane_1.add(btncategoria);
	    
	
	    
	    model.addColumn("Nombre               ");
	    model.addColumn("Fecha Alta");
	    model.addColumn("Categoría");
	    model.addColumn("Descripción          ");
	    model.addColumn("Edición");
	    model.addColumn("Precio");
	    model.addColumn("Plataforma");
	    

	    TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        TableColumn tableColumn = columnModel.getColumn(column);
	        int preferredWidth = tableColumn.getHeaderValue().toString().length()*10;// EL NUMERO ES PARA EL AJUSTE ENTRE COLUMNA Y DATO
	        tableColumn.setPreferredWidth(preferredWidth);
	    }
	    
	    //THE ROW
		while (rs.next()){
			Object [] filas = new Object[7];

	    for(int i=0;i<7;i++) {    	 
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
