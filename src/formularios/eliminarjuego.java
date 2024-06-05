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
import usuario_juego.ControllerUsuario_juego;
import conexion.conexion;

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

public class eliminarjuego extends JFrame {

	private JPanel contentPane;
	
	
	final JTable table=new JTable();
	DefaultTableModel model;
	public static String col;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eliminarjuego frame = new eliminarjuego();
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
	public eliminarjuego() {
		setTitle("BAJA DE JUEGOS");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		FondoPanel fondo = new FondoPanel();
		fondo.setBounds(0, 0, 761, 379);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(230, 230, 250));
		contentPane_1.setBounds(0, 0, 761, 379);
		contentPane.add(contentPane_1);
		
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		
		
		BordeRedondo border = new BordeRedondo(20);
		
		Color azul= new Color(10,255,230);
	    table.setBackground(Color.lightGray);
	    table.setSelectionBackground(azul);
		
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(52, 82, 665, 131);
		contentPane_1.add(scroll);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(618, 241, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		
		
		JLabel lblElimCliente = new JLabel("ELIMINAR JUEGO");
		lblElimCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		DiseñoyValida.modifyLabel(lblElimCliente);
		lblElimCliente.setBounds(10, 37, 774, 14);
		contentPane_1.add(lblElimCliente);
		
		
		
		try {
		 	conexion con = new conexion();
			Statement st = con.MySQLConnect().createStatement();
			ResultSet rs = st.executeQuery("SELECT idpro, nombre, fechaalta,categoria,plataforma,edicion FROM juego order by nombre");


  
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
    model.addColumn(" Nombre del Título ");
    model.addColumn("Fecha Alta");
    model.addColumn("Categoría");
    model.addColumn(" Plataforma ");
    model.addColumn("Edición");
    model.addColumn("Borrar");

    
    
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
			
		
		
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("Va a eliminar");
				
				for(int i=0;i<table.getRowCount();i++)
		        {
		          Boolean checked=Boolean.valueOf(table.getValueAt(i, 6).toString());
		          col=table.getValueAt(i, 0).toString();
		      
		          System.out.println(col);
		          
		          if(checked)
		          {
		        	  
		        	  System.out.println(col);
		        	  
		        	  int confirmado = JOptionPane.showConfirmDialog(
		        			  null, "Va a eliminar el juego con ID: "+col+". ¿Está seguro?. Para eliminar el juego definitivamente consulte con el administrador", 
		        			  "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		        			if (JOptionPane.OK_OPTION == confirmado) {
		        				
		        				//PRIMERO ELIMINAMOS JUEGO EN TABLA INTERMEDIA
		        				
		        				//usuario_juego usujue = new usuario_juego(loginDaoImpl.id, a );
		        				
		        				ControllerUsuario_juego uj = new ControllerUsuario_juego();
		        				
		        				uj.eliminar(Integer.valueOf(col));
		        				
		        				
		        				
		        				//ControllerJuego elimJuego = new ControllerJuego();
		        				//elimJuego.eliminar(Integer.valueOf(col));
		        				
		        				model.removeRow(i); 
		        				i=i-1;
		        	           }
		        			else 
		        				JOptionPane.showMessageDialog(null, "Eliminación cancelada"); 
		            
		          }
		        }
				
				
			}
		});
		btnEliminar.setBounds(52, 263, 117, 23);
		btnEliminar.setBackground(null);
		DiseñoyValida.modifyButton(btnEliminar);
		btnEliminar.setBorder(border);
		contentPane_1.add(btnEliminar);
		
		
		
		

	}
}
