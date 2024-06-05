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
import login.ControllerLogin;
import usuarios.ControllerUsuario;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class eliminarusuario extends JFrame {

	private JPanel contentPane;
	
	
	final JTable table = new JTable();
	DefaultTableModel model;
	public static String col;
	public static int comienzo=0;
	public static int num=5;
	public static int total=0;
	//public JScrollPane scroll=new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eliminarusuario frame = new eliminarusuario();
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
	public eliminarusuario() {
		

		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		Acceso.FondoPanel fondo = new FondoPanel();
		fondo.setBounds(10, 0, 741, 329);
		
		setTitle("BAJA DE USUARIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(230, 230, 250));
		contentPane_1.setBounds(10, 11, 751, 318);
		contentPane.add(contentPane_1);
		

		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		
		BordeRedondo border = new BordeRedondo(20);

		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(52, 57, 665, 104);
		contentPane_1.add(scroll);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(618, 180, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		
		
		
		JLabel lblElimCliente = new JLabel("ELIMINAR USUARIO");
		DiseñoyValida.modifyLabel(lblElimCliente);
		lblElimCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblElimCliente.setBounds(0, 22, 741, 14);
		contentPane_1.add(lblElimCliente);
		
			
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
		btnAnterior.setBounds(52, 202, 112, 23);
		btnAnterior.setBackground(null);
		DiseñoyValida.modifyButton(btnAnterior);
		btnAnterior.setBorder(border);
		contentPane_1.add(btnAnterior);
		
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(214, 202, 117, 23);
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
		
		btnSiguiente.setBackground(null);
		DiseñoyValida.modifyButton(btnSiguiente);
		btnSiguiente.setBorder(border);
		contentPane_1.add(btnSiguiente);
		
		
		
		ControllerUsuario cont = new ControllerUsuario();
		total=cont.ContarCliente();
		comienzo=0;
		
		
		
		
			try {
				 	conexion con = new conexion();
					Statement st = con.MySQLConnect().createStatement();
					ResultSet rs = st.executeQuery("SELECT idcli, dni, nombre, apellidos, direccion, telefono, poblacion from usuario left join login on usuario.idcli = login.idusuario where (login.idusuario is not null) order by nombre LIMIT "+comienzo+","+num+"");
					//ResultSet rs = st.executeQuery("SELECT idcli, dni, nombre, apellidos, direccion, telefono, poblacion FROM usuario order by nombre LIMIT "+comienzo+", "+num+" ");
		
		
		  
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
								return Boolean.class;
		
							default:
								return Object.class;
							
				        }
				      }
				    };
						
				    table.setModel(model);
				    
				    DiseñoyValida.ColorTabla(table);
				
				    model.addColumn("Id");
				    model.addColumn("DNI      ");
				    model.addColumn("  Nombre  ");
				    model.addColumn(" Apellidos del usuario ");
				    model.addColumn("Dirección");
				    model.addColumn("Teléfono");
				    model.addColumn("Población");
				    model.addColumn("Borrar");
				    
				    
				    //PREDEFINE EL ANCHO DE LA COLUMNA AL ANCHO DE SU ETIQUETA
				    
				    TableColumnModel columnModel = table.getColumnModel();
				    for (int column = 0; column < table.getColumnCount(); column++) {
				        TableColumn tableColumn = columnModel.getColumn(column);
				        int preferredWidth = tableColumn.getHeaderValue().toString().length()*5;// EL 5 ES PARA EL AJUSTE ENTRE COLUMNA Y DATO
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
					
				    for(int i=0;i<table.getRowCount();i++) {    	 
					    	model.setValueAt(false,i,7);
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
			
				
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0;i<table.getRowCount();i++)
		        {	
		          Boolean checked=Boolean.valueOf(table.getValueAt(i, 7).toString());
		          col=table.getValueAt(i, 0).toString();
		          		      
		          System.out.println(col);
		          System.out.println(table.getRowCount());
		          
		          if(checked)
		          {
		        	  
		        	  System.out.println(col);
		        	  
		        	  int confirmado = JOptionPane.showConfirmDialog(
		        			  null, "Va a eliminar el usuario con ID: "+col+" de la tabla login. No se borrará de la aplicación por si tiene actividad en ella. ¿Está seguro de esta acción?", 
		        			  "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		        			if (JOptionPane.OK_OPTION == confirmado) {
		        				
		        	
		        				
		        				ControllerLogin elilog = new ControllerLogin();
		        				elilog.eliminar(Integer.valueOf(col));
		        				
		        				
		        				//ControllerUsuario elimusu = new ControllerUsuario();
		        				//elimusu.eliminar(Integer.valueOf(col));
		        				
		        				
		        				model.removeRow(i);
		        				i=i-1;
		        				//RefreshTable(table);
		        				
		        				
		        				
		        	           }
		        			else 
		        				JOptionPane.showMessageDialog(null, "Eliminación cancelada"); 
		            
		          }
		          	
		        }
				
			}
		});
		btnEliminar.setBounds(418, 202, 117, 23);
		btnEliminar.setBackground(null);
		DiseñoyValida.modifyButton(btnEliminar);
		btnEliminar.setBorder(border);
		contentPane_1.add(btnEliminar);
		

	}
	
public void RefreshTable(JTable table) {
		
		

		try {
			
				JScrollPane scroll=new JScrollPane();
				getContentPane().add(scroll);

			 	conexion con = new conexion();
				Statement st = con.MySQLConnect().createStatement();
				ResultSet rs = st.executeQuery("SELECT idcli, dni, nombre, apellidos, direccion, telefono, poblacion from usuario left join login on usuario.idcli = login.idusuario where (login.idusuario is not null) order by nombre LIMIT "+comienzo+","+num+"");
				//ResultSet rs = st.executeQuery("SELECT idcli, dni, nombre, apellidos, direccion, telefono, poblacion FROM usuario order by nombre LIMIT "+comienzo+", "+num+" ");
	
	
	  
				
				//scroll.setViewportView(table);
	
	
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
							return Boolean.class;
					
	
						default:
							return Object.class;
						
			        }
			      }
			    };
					
			    table.setModel(model);
				
			    model.addColumn("Id");
			    model.addColumn("DNI      ");
			    model.addColumn("  Nombre  ");
			    model.addColumn(" Apellidos del usuario ");
			    model.addColumn("Dirección");
			    model.addColumn("Teléfono");
			    model.addColumn("Población");
			    model.addColumn("  BORRAR  ");
			    
			    
			    //PREDEFINE EL ANCHO DE LA COLUMNA AL ANCHO DE SU ETIQUETA
			    
			    TableColumnModel columnModel = table.getColumnModel();
			    for (int column = 0; column < table.getColumnCount(); column++) {
			        TableColumn tableColumn = columnModel.getColumn(column);
			        int preferredWidth = tableColumn.getHeaderValue().toString().length()*5;// EL 5 ES PARA EL AJUSTE ENTRE COLUMNA Y DATO
			        tableColumn.setPreferredWidth(preferredWidth);
			    }
			    
			    
			    
			    //THE ROW
				while (rs.next()){
					Object [] filas = new Object[7];
			
					    for(int i=0;i<7;i++) {    	 
					    	filas[i] = rs.getObject(i+1);
					    	}
					    
					    	((DefaultTableModel) table.getModel()).addRow(filas);
					    	((DefaultTableModel) table.getModel()).fireTableRowsUpdated(0,5);
					    	
						}
				
			    for(int i=0;i<table.getRowCount();i++) {    	 
				    	model.setValueAt(false,i,7);
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
