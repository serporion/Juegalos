package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import alquileres.ControllerAlquiler;
import alquileres.alquiler;
import login.loginDaoImpl;
import conexion.conexion;
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
import javax.swing.JTextField;

public class alquilarjuego extends JFrame {

	private JPanel contentPane;
	
	final JTable table=new JTable();
	DefaultTableModel model;
	public static String col;
	public static Date fechaactual;
	public static Date fechita;
	public static Date fechaza;
	public static boolean paso = true;
	public static int producto;
	private JTextField textbusqueda;
	
	Date date1;
	Date date2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alquilarjuego frame = new alquilarjuego();
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
				ResultSet rs = st.executeQuery("SELECT juego.idpro, nombre, juego.precio, categoria, descripcion, edicion from juego left join alquiler on juego.idpro = alquiler.idpro where (alquiler.idpro is null || alquiler.fechafinal < curdate()) order by nombre");
				
				
				
				while (rs.next()){
					Object [] filas = new Object[6];

			    for(int i=0;i<6;i++) {    	 
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
	public alquilarjuego() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		Acceso.FondoPanel fondo = new FondoPanel();
		BordeRedondo border = new BordeRedondo(20);
		fondo.setBounds(0, 0, 715, 390);
		
		try {
			setTitle(" ALQUILER USUARIO " +menuaccesousu.usito);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(230, 230, 250));
		contentPane_1.setBounds(0, 0, 732, 364);
		contentPane.add(contentPane_1);
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(52, 57, 605, 197);
		contentPane_1.add(scroll);
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(565, 282, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		
		JLabel lblAlquiJuego = new JLabel("ALQUILER DE JUEGO");
		DiseñoyValida.modifyLabel(lblAlquiJuego);
		lblAlquiJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlquiJuego.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAlquiJuego.setBounds(0, 22, 707, 24);
		contentPane_1.add(lblAlquiJuego);
		
		
		
		try {
		 	conexion con = new conexion();
			Statement st = con.MySQLConnect().createStatement();
			//ResultSet rs = st.executeQuery("SELECT juego.idpro, nombre, juego.precio, categoria, descripcion, edicion from juego left join alquiler on juego.idpro = alquiler.idpro where (alquiler.idpro is null || alquiler.fechafinal < curdate()) order by nombre");
			ResultSet rs = st.executeQuery("SELECT distinct juego.idpro, nombre, juego.precio, categoria, descripcion, edicion from juego left join alquiler on juego.idpro = alquiler.idpro order by nombre");

  
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
						return Boolean.class;
		
					default:
						return Object.class;
					
        }
      }
    };
		
    
   
    table.setModel(model);
  
    DiseñoyValida.ColorTabla(table);
    
    model.addColumn("Id");
    model.addColumn("Nombre            ");
    model.addColumn("Precio");
    model.addColumn("Categoría");
    model.addColumn("Descripción                ");
    model.addColumn("Edición");
    model.addColumn("Alquiler");

    
    //PREDEFINE EL ANCHO DE LA COLUMNA AL ANCHO DE SU ETIQUETA
    
    TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
        TableColumn tableColumn = columnModel.getColumn(column);
        int preferredWidth = tableColumn.getHeaderValue().toString().length()*5;// EL 5 ES PARA EL AJUSTE ENTRE COLUMNA Y DATO
        tableColumn.setPreferredWidth(preferredWidth);
    }

    
    table.getColumnModel().getColumn(0).setMinWidth(0);
    table.getColumnModel().getColumn(0).setMaxWidth(0);
    table.getColumnModel().getColumn(0).setWidth(0);
    table.getColumnModel().getColumn(0).setPreferredWidth(0);
    table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
    table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    model.fireTableDataChanged(); 
    
    
    //THE ROW
	while (rs.next()){
		Object [] filas = new Object[6];

    for(int i=0;i<6;i++) {    	 
    	filas[i] = rs.getObject(i+1);
    	}
    
    	((DefaultTableModel) table.getModel()).addRow(filas);     
    	//((DefaultTableModel) table.getModel()).fireTableRowsUpdated(0,5);
	}
	
    for(int i=0;i<table.getRowCount();i++) {    	 
    	model.setValueAt(false,i,6);
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
		jdcfecha.setBounds(52, 36, 110, 20);
		jdcfecha.setCalendar(c2);
		contentPane_1.add(jdcfecha);
		
		JDateChooser jdcinicioaquiler = new JDateChooser();
		jdcinicioaquiler.setBackground(new Color(0, 255, 255));
		jdcinicioaquiler.setFont(new Font("Tahoma", Font.BOLD, 11));
		jdcinicioaquiler.setBounds(166, 281, 100, 20);
		contentPane_1.add(jdcinicioaquiler);
		
		
		JDateChooser jdcfinalalquiler = new JDateChooser();
		jdcfinalalquiler.setBackground(new Color(0, 255, 255));
		jdcfinalalquiler.setFont(new Font("Tahoma", Font.BOLD, 11));
		jdcfinalalquiler.setBounds(166, 307, 100, 20);
		contentPane_1.add(jdcfinalalquiler);
		
		
		JButton btnAlquilar = new JButton("Alquilar");
		btnAlquilar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("Esto alquila este juego. Deben estar marcados todos los campos necesarios. ");
				
				for(int i=0;i<table.getRowCount();i++)
		        {
		          Boolean checked=Boolean.valueOf(table.getValueAt(i, 6).toString());
		          col=table.getValueAt(i, 1).toString();
		          
		          
		          if(checked)
		          {
		        	  
		        	  System.out.println(col);
		        	  
		        	  int precio = (int) table.getValueAt(i, 2);

		        	  producto = (int) table.getValueAt(i, 0);
		        	  
		        	  paso = false;
		        	  
		        	  date2 = jdcfinalalquiler.getDate(); 
		        	  date1 = jdcinicioaquiler.getDate();
		        	  
		        	  if (date1 == null || date2 == null) {
	  		        		
	  		        		JOptionPane.showMessageDialog(null, "Por favor, rellene las fechas. Operación Cancelada");
	  		      
	  		        	}else {
		        	  
		        	  	//Date date1 = jdcinicioaquiler.getDate();  //Variable visible para toda la clase
		        		//date1 = jdcinicioaquiler.getDate();
      					long d1 = date1.getTime(); 
      					java.sql.Date fechai = new java.sql.Date(d1);
      				
      					fechita = fechai;
      				
      					//Date date2 = jdcinicioaquiler.getDate();  //Variable visible para toda la clase
	      				//date2 = jdcfinalalquiler.getDate(); 
	      				long d2 = date2.getTime(); 
	      				java.sql.Date fechaf = new java.sql.Date(d2);
	      				
	      				
	      				
	      				fechaza = fechaf;
	      				
	      				int diff = (int) (fechaza.getDate() - fechita.getDate());
	      				
	      				int preciotot = precio * diff;
  		        		
  		        		System.out.println(diff);
	      				
	      				
			        	
	      				float total = (float) ((preciotot+1.5)+(1.50*0.21));
		        	  
	      				BigDecimal cargo = new BigDecimal(Float.toString(total));
	      		        cargo = cargo.setScale(2,BigDecimal.ROUND_HALF_UP);
		        	  
	      		        int confirmado = JOptionPane.showConfirmDialog(
		        			  null, "Va a alquilar el juego : "+col+". El Importe Total a cargar será de " + cargo + " ¿Está seguro?", 
		        			  "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		        			if (JOptionPane.OK_OPTION == confirmado) {
		        						        				
		        				
		        				Date date0 = jdcfecha.getDate(); 
		        				long d0 = date0.getTime(); 
		        				java.sql.Date fechahoy = new java.sql.Date(d0);
		        				
		        				fechaactual = fechahoy;
		        			
			        			/*
			        			System.out.println(fechaactual);
			        			System.out.println(fechita);
			  		        	System.out.println(fechaza);
			  		        	System.out.println("el precio es " + precio);
			  		        	System.out.println("el usuprestatatio es " + loginDaoImpl.id);
			  		        	System.out.println("el idpro es " + producto);	
			        			*/	
			  		        	
			  		        			  		        		
		  		        		System.out.println(diff);
			      				
		  		        		if (fechaza.before(fechita) || fechita.before(fechaactual)) {
		  		        		
		  		        	
		  		        			JOptionPane.showMessageDialog(null, "Por favor, revise las fechas del alquiler");
		  		        			System.out.println("Las fechas son errorenas");
		  		        		
		  		        		}else {
		        				
		  		        			System.out.println(cargo);
		  		        		
		  		        			int a=0;
		  		        		
		  		        			alquiler nuevoalquiler = new alquiler (fechaactual, fechita, fechaza , preciotot, a ,loginDaoImpl.id, cargo, producto);
		        				
		        				
		  		        			ControllerAlquiler alquiljuego = new ControllerAlquiler();
		        				
		        				
		  		        			alquiljuego.registrar(nuevoalquiler);
		  		        			
		  		        			JOptionPane.showMessageDialog(null, "Le hemos cargado a la tarjeta el importe de la fianza correspondiente según nuestras condiciones de uso");
		  		        			JOptionPane.showMessageDialog(null, "Le hemos enviado a su teléfono los datos de alquiler y forma de recoger el título");
		  		        			
		  		        			//Estas dos filas de abajo las comento ya que eliminaba la fila del DefaultTableModel del juego después de ser alquilado. Lo quito, porque me resulta más útil dejar dicha fila
		  		        			//model.removeRow(i);
		  		        			//i=i-1; 
		  		        			
		  		        			table.setValueAt(false, i, 6);
		  		        			
		  		        					        				
		  		        			}
		  		        	
		        	           }
		        				else 
		        					JOptionPane.showMessageDialog(null, "Alquiler cancelado"); 
		            
	  		        		}
		          
		          	}
				
		        } 
				
				if (paso) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un juego para alquilar");
				}
				
				//RefreshTable(table);
			}
		});
		btnAlquilar.setBounds(166, 341, 100, 23);
		btnAlquilar.setBackground(null);
		DiseñoyValida.modifyButton(btnAlquilar);
		btnAlquilar.setBorder(border);
		contentPane_1.add(btnAlquilar);
		
		
		JLabel lblFinAlquiler = new JLabel("Inicio del Alquiler");
		lblFinAlquiler.setForeground(new Color(0, 255, 255));
		lblFinAlquiler.setBounds(52, 281, 102, 20);
		contentPane_1.add(lblFinAlquiler);
		
		JLabel lblFinAlquiler_1 = new JLabel("Fin del Alquiler");
		lblFinAlquiler_1.setForeground(new Color(0, 255, 255));
		lblFinAlquiler_1.setBounds(68, 307, 86, 20);
		contentPane_1.add(lblFinAlquiler_1);
		
		JLabel lblinformacion = new JLabel("*Al precio de alquiler se le añadirá 1.5 en concepto de servicio prestado más su 21% de IVA");
		lblinformacion.setForeground(new Color(0, 255, 255));
		lblinformacion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblinformacion.setBounds(277, 350, 455, 14);
		contentPane_1.add(lblinformacion);
		
		textbusqueda = new JTextField();
		textbusqueda.setBounds(440, 283, 86, 20);
		contentPane_1.add(textbusqueda);
		textbusqueda.setColumns(10);
		
		JButton btnbuscar = new JButton("Buscar juego");
		btnbuscar.setHorizontalAlignment(SwingConstants.LEFT);
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 	conexion con = new conexion();
					Statement st = con.MySQLConnect().createStatement();
					ResultSet rs = st.executeQuery("SELECT juego.idpro, nombre, juego.precio, categoria, descripcion, edicion from juego left join alquiler on juego.idpro = alquiler.idpro where (nombre like(\"%"+textbusqueda.getText()+"%\") and (alquiler.idpro is null || alquiler.fechafinal < curdate())) order by nombre;");
					//SELECT juego.idpro, nombre, juego.precio, categoria, descripcion, edicion from juego left join alquiler on juego.idpro = alquiler.idpro where (alquiler.idpro is null || alquiler.fechafinal < curdate() and nombre like("%go%")) order by nombre;
		  
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
								return Boolean.class;
				
							default:
								return Object.class;
							
		        }
		      }
		    };
				
		    
		   
		    table.setModel(model);
		  
		    
		    model.addColumn("Id");
		    model.addColumn("Nombre");
		    model.addColumn("Precio");
		    model.addColumn("Categoría");
		    model.addColumn("Descripción                ");
		    model.addColumn("Edición");
		    model.addColumn("Aquiler");
		    

		    
		    table.getColumnModel().getColumn(0).setMinWidth(0);
		    table.getColumnModel().getColumn(0).setMaxWidth(0);
		    table.getColumnModel().getColumn(0).setWidth(0);
		    table.getColumnModel().getColumn(0).setPreferredWidth(0);
		    table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		    table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		    model.fireTableDataChanged(); 
		    
		    
		    //PREDEFINE EL ANCHO DE LA COLUMNA AL ANCHO DE SU ETIQUETA
		    
		    TableColumnModel columnModel = table.getColumnModel();
		    for (int column = 0; column < table.getColumnCount(); column++) {
		        TableColumn tableColumn = columnModel.getColumn(column);
		        int preferredWidth = tableColumn.getHeaderValue().toString().length()*5;// EL 5 ES PARA EL AJUSTE ENTRE COLUMNA Y DATO
		        tableColumn.setPreferredWidth(preferredWidth);
		    }

		    
		    //THE ROW
			while (rs.next()){
				Object [] filas = new Object[6];

		    for(int i=0;i<6;i++) {    	 
		    	filas[i] = rs.getObject(i+1);
		    	}
		    
		    	((DefaultTableModel) table.getModel()).addRow(filas);     
		    	//((DefaultTableModel) table.getModel()).fireTableRowsUpdated(0,5);
			}
			
		    for(int i=0;i<table.getRowCount();i++) {    	 
		    	model.setValueAt(false,i,6);
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
		btnbuscar.setBounds(301, 282, 129, 23);
		btnbuscar.setBackground(null);
		DiseñoyValida.modifyButton(btnbuscar);
		btnbuscar.setBorder(border);
		contentPane_1.add(btnbuscar);
				
		

	}
}
