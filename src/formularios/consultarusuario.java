package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import Acceso.BordeRedondo;
import Acceso.DiseñoyValida;
import Acceso.FondoPanel;
import conexion.conexion;
import usuarios.ControllerUsuario;

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

public class consultarusuario extends JFrame {

	private JPanel contentPane;
	
	final JTable table=new JTable();
	public static int comienzo=0;
	public static int num=5;
	public static int total=0;
	public static int modificar_id;
	public static int id_cliente;
	
	boolean lisUpdatingTable = true;
	
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultarusuario frame = new consultarusuario();
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
				ResultSet rs = st.executeQuery("SELECT * FROM usuario LIMIT "+comienzo+","+num+"");
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
	public consultarusuario() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		FondoPanel fondo = new FondoPanel();
		fondo.setBounds(10, 0, 806, 356);
		
		setTitle("USUARIOS DE LA APLICACIÓN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(230, 230, 250));
		contentPane_1.setBounds(0, 30, 816, 337);
		contentPane.add(contentPane_1);
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		
		BordeRedondo border = new BordeRedondo(20);
		
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(40, 79, 753, 105);
		contentPane_1.add(scroll);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(694, 218, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		
		JLabel lblConsultaCliente = new JLabel("CONSULTA DE USUARIOS");
		lblConsultaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		DiseñoyValida.modifyLabel(lblConsultaCliente);
		lblConsultaCliente.setBounds(40, 21, 753, 32);
		contentPane_1.add(lblConsultaCliente);
		
		
		ControllerUsuario cont = new ControllerUsuario();
		total=cont.ContarCliente();
		comienzo=0;
		
		
		 try {

			
				conexion con =new conexion();
				Statement st = con.MySQLConnect().createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM usuario LIMIT "+comienzo+","+num+"");		

				

	    //THE TABLE
	    scroll.setViewportView(table);
	   
	    //THE MODEL OF OUR TABLE
	    
	    //DefaultTableModel model=new DefaultTableModel() LA CONSTRUYO COMO LOCAL DE TODA LA CLASE PARA QUE MODIFICAR PUEDA VERLA

	    model = new DefaultTableModel()
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
	   
	    model.addColumn("Id");
	    model.addColumn("Fecha Alta");
	    model.addColumn("   Dni   ");
	    model.addColumn("   Nombre   ");
	    model.addColumn("   Apellidos  ");
	    model.addColumn("   Direccion   ");
	    model.addColumn("Cp");
	    model.addColumn("Telefono");
	    model.addColumn(" Poblacion ");
	    model.addColumn("Provincia");
	    

	  //PREDEFINE EL ANCHO DE LA COLUMNA AL ANCHO DE SU ETIQUETA
	    
	    TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        TableColumn tableColumn = columnModel.getColumn(column);
	        int preferredWidth = tableColumn.getHeaderValue().toString().length()*3;// EL NUMERO ES PARA EL AJUSTE ENTRE COLUMNA Y DATO
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
		
		 
		 
		
		 table.getModel().addTableModelListener(new TableModelListener() {
			   public void tableChanged(TableModelEvent eve) {
				   
				   if (lisUpdatingTable) { 
				   
				   int row = eve.getFirstRow(); // obtener la fila que se modificó
				   int column = eve.getColumn(); // obtener la columna que se modificó
				   
				   //TableModel model = (TableModel)e.getSource(); // obtener el modelo de la tabla. 
				   
				   //model = (TableModel)e.getSource();
				   
				   String columnName = model.getColumnName(column);
				   System.out.println(columnName);
				   
				   int confirmado = JOptionPane.showConfirmDialog(
		        			  null, "Va a modificar el registro del campo " +columnName+". ¿Está seguro?", 
		        			  "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				   
				   System.out.println(columnName);
				   		
				   if (JOptionPane.OK_OPTION == confirmado) {
       				
					String mod = (String) table.getValueAt(row, column);
					int indice = (int) table.getValueAt(row, 0);
					   
       				ControllerUsuario modificarusuario = new ControllerUsuario();
       				
       				modificarusuario.actualizar(columnName, mod, indice);
       				
       				
       				lisUpdatingTable = true;
       				
       	           }
       			else 
       				JOptionPane.showMessageDialog(null, "Modificación cancelada"); 
				   	lisUpdatingTable = true;
				   	

					
			      System.out.println(row);
			      
			   }
			   }
		 });
		 
		
		 JButton btnModificar = new JButton("Modificar");
		 btnModificar.setVisible(false);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					
					
					
					System.out.println("hola");
					
					RefreshTable(table);
					
				}
			});
			btnModificar.setBounds(433, 229, 117, 23);
			btnModificar.setBackground(null);
			DiseñoyValida.modifyButton(btnModificar);
			btnModificar.setBorder(border);
			contentPane_1.add(btnModificar);
		 
		 
			JButton btnAnterior = new JButton("Anterior");
			btnAnterior.addActionListener(new ActionListener() {
				
				
				
				public void actionPerformed(ActionEvent e) {
					lisUpdatingTable = false;
					
					if(comienzo>0) {
						comienzo=comienzo-5;
						RefreshTable(table);
					}
					else
						JOptionPane.showMessageDialog(null, "No existen más datos");
					lisUpdatingTable = true;
				}
				
				
			});
			btnAnterior.setBounds(40, 229, 117, 23);
			btnAnterior.setBackground(null);
			DiseñoyValida.modifyButton(btnAnterior);
			btnAnterior.setBorder(border);
			contentPane_1.add(btnAnterior);
			
			JButton btnSiguiente = new JButton("Siguiente");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					lisUpdatingTable = false;
					
					if(comienzo+num<total) {

						comienzo=comienzo+5;
						RefreshTable(table);
						}
					else
						JOptionPane.showMessageDialog(null, "No existen más datos");
					lisUpdatingTable = true;
				}
			});
			btnSiguiente.setBounds(192, 229, 117, 23);
			btnSiguiente.setBackground(null);
			DiseñoyValida.modifyButton(btnSiguiente);
			btnSiguiente.setBorder(border);
			contentPane_1.add(btnSiguiente);
		 
	}
}
