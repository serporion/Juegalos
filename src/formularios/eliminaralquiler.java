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
import alquileres.ControllerAlquiler;
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

public class eliminaralquiler extends JFrame {

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
					eliminaralquiler frame = new eliminaralquiler();
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
	public eliminaralquiler() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		Acceso.FondoPanel fondo = new FondoPanel();
		fondo.setBounds(10, 0, 741, 343);
		
		setTitle("BAJA DE ALQUILER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(230, 230, 250));
		contentPane_1.setBounds(10, 11, 741, 321);
		contentPane.add(contentPane_1);
		
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		//contentPane_1.repaint();
		
		BordeRedondo border = new BordeRedondo(20);
		
		
		Color azul= new Color(10,255,230);
	    table.setBackground(Color.lightGray);
	    table.setSelectionBackground(azul);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(52, 66, 665, 105);
		contentPane_1.add(scroll);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(618, 218, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		
		JLabel lblElimAlquiler = new JLabel("ELIMINAR ALQUILER");
		lblElimAlquiler.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimAlquiler.setFont(new Font("Tahoma", Font.PLAIN, 18));
		DiseñoyValida.modifyLabel(lblElimAlquiler);
		lblElimAlquiler.setBounds(0, 22, 774, 23);
		contentPane_1.add(lblElimAlquiler);
		
		
		
		try {
		 	conexion con = new conexion();
			Statement st = con.MySQLConnect().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM alquiler order by fechaalquiler");


  
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
						return Boolean.class;
					
        }
      }
    };
		
    table.setModel(model);

    DiseñoyValida.ColorTabla(table);
    
    model.addColumn("Id");
    model.addColumn("  Fecha  ");
    model.addColumn("Fecha Inicio");
    model.addColumn("Fecha Fin");
    model.addColumn("Precio");
    model.addColumn("Prestador");
    model.addColumn("Prestatario");
    model.addColumn("Total");
    model.addColumn("Id Juego");
    model.addColumn("Borrar");
    
    
    
    //PREDEFINE EL ANCHO DE LA COLUMNA AL ANCHO DE SU ETIQUETA
    
    TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
        TableColumn tableColumn = columnModel.getColumn(column);
        int preferredWidth = tableColumn.getHeaderValue().toString().length()*4;// EL 4 ES PARA EL AJUSTE ENTRE COLUMNA Y DATO
        tableColumn.setPreferredWidth(preferredWidth);
        
    }
    
    
    
    
    //THE ROW
	while (rs.next()){
		Object [] filas = new Object[9];

    for(int i=0;i<9;i++) {    	 
    	filas[i] = rs.getObject(i+1);
    	}
    
    	((DefaultTableModel) table.getModel()).addRow(filas);     
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
			
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Va a eliminar");
				
				for(int i=0;i<table.getRowCount();i++)
		        {
		          Boolean checked=Boolean.valueOf(table.getValueAt(i, 9).toString());
		          col=table.getValueAt(i, 0).toString();
		      
		          System.out.println(col);
		          
		          if(checked)
		          {
		        	  
		        	  System.out.println(col);
		        	  
		        	  int confirmado = JOptionPane.showConfirmDialog(
		        			  null, "Va a eliminar el alquiler con ID: "+col+". ¿Está seguro?", 
		        			  "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		        			if (JOptionPane.OK_OPTION == confirmado) {
		        				
		        				ControllerAlquiler elimAlquiler = new ControllerAlquiler();
		        				elimAlquiler.eliminar(Integer.valueOf(col));
		        				
		        				model.removeRow(i); 
		        				i=i-1;
		        	           }
		        			else 
		        				JOptionPane.showMessageDialog(null, "Eliminación cancelada"); 
		            
		          }
		        }
				
				
			}
		});
		btnEliminar.setBounds(52, 229, 117, 23);
		btnEliminar.setBackground(null);
		DiseñoyValida.modifyButton(btnEliminar);
		btnEliminar.setBorder(border);
		contentPane_1.add(btnEliminar);
	

	}
}
