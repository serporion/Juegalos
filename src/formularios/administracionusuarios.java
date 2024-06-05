package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

import Acceso.BordeRedondo;
import Acceso.DiseñoyValida;
import Acceso.FondoPanel;
import conexion.conexion;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class administracionusuarios extends JFrame {

	private JPanel contentPane;
	
	
	public static double total=0;
	private JTextField textFecha;
	private JTextField textIdUsuario;
	private JTextField textTotCli;
	private JTextField textTotAno;
	private double totCli =0;
	private double totAlq =0;
	
	MaskFormatter formatterFecha;
	
	final JTable table=new JTable();
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administracionusuarios frame = new administracionusuarios();
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
	public administracionusuarios() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		FondoPanel fondo = new FondoPanel();
		fondo.setBounds(10, 10, 763, 332);
		
		BordeRedondo border = new BordeRedondo(20);
		
		setTitle("ADMINISTRACION - CONSULTAS SOBRE USUARIOS");
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
		contentPane_1.setBounds(10, 11, 763, 332);
		contentPane.add(contentPane_1);
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(10, 55, 140, 200);
		contentPane_1.add(scroll);
		
		
		textFecha = new JTextField();
		JFormattedTextField textFecha = new JFormattedTextField(formatterFecha);
		textFecha.setHorizontalAlignment(SwingConstants.LEFT);
		textFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFecha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();
		        if((car<'0' || car>'9') && (car<',' || car>'.')) evt.consume();
			}
		});
		textFecha.setBounds(360, 115, 60, 23);
		contentPane_1.add(textFecha);
				
		
		JButton btnFactC = new JButton("Usuarios por año");
		btnFactC.setHorizontalAlignment(SwingConstants.LEFT);
		btnFactC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					System.out.println(textFecha.getText());
				 	conexion con = new conexion();
					Statement st = con.MySQLConnect().createStatement();
					
					String sql = "SELECT Count(idcli) as total FROM usuario where year(fechaalta) = "+textFecha.getText()+"";
					
					
					if (textFecha.getText().length() == 0 ) {
						JOptionPane.showMessageDialog(null, "Debe introducir un año para la consulta");
					}else {
						
					
					
					System.out.println(sql);
					ResultSet rs = st.executeQuery(sql);
								
					
						if(rs.next()) {
							totCli = rs.getInt("total");
							System.out.println(totCli);
						}
					
						textTotCli.setText(""+totCli);
						textFecha.setText("");
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
		btnFactC.setBounds(448, 116, 150, 23);
		
		btnFactC.setBackground(null);
		DiseñoyValida.modifyButton(btnFactC);
		btnFactC.setBorder(border);
		contentPane_1.add(btnFactC);
		
		textTotCli = new JTextField();
		textTotCli.setHorizontalAlignment(SwingConstants.RIGHT);
		textTotCli.setFont(new Font("Tahoma", Font.BOLD, 12));
		textTotCli.setBounds(628, 115, 60, 23);
		
		contentPane_1.add(textTotCli);
		textTotCli.setColumns(10);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(589, 238, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		
		try {

			
			conexion con =new conexion();
			Statement st = con.MySQLConnect().createStatement();
			ResultSet rs = st.executeQuery("SELECT idcli,nombre FROM usuario");
			

    //THE TABLE
    scroll.setViewportView(table);
   
    //THE MODEL OF OUR TABLE
    
    
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
			
			default:
				return Boolean.class;
		}
      }
    };

    
    //ASSIGN THE MODEL TO TABLE
    table.setModel(model);
    

	Color azul= new Color(10,255,230);
    table.setBackground(Color.lightGray);
    table.setSelectionBackground(azul);
   
   
    model.addColumn("ID");
    model.addColumn("NOMBRE");
    //model.addColumn("FECHA");
   

  //PREDEFINE EL ANCHO DE LA COLUMNA AL ANCHO DE SU ETIQUETA
    
    TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
        TableColumn tableColumn = columnModel.getColumn(column);
        int preferredWidth = tableColumn.getHeaderValue().toString().length()*15;// EL NUMERO ES PARA EL AJUSTE ENTRE COLUMNA Y DATO
        tableColumn.setPreferredWidth(preferredWidth);
    }

    //THE ROW
	while (rs.next()){
		Object [] filas = new Object[2];

    for(int i=0;i<2;i++) {    	 
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
			
			JLabel lblFacturacinPorCliente = new JLabel("Alquileres por ID usuario");
			lblFacturacinPorCliente.setHorizontalAlignment(SwingConstants.CENTER);
			DiseñoyValida.modifyLabel(lblFacturacinPorCliente);
			lblFacturacinPorCliente.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
			lblFacturacinPorCliente.setBounds(164, 168, 186, 26);
			contentPane_1.add(lblFacturacinPorCliente);
			
			try {
				formatterFecha = new MaskFormatter("####"); // La U nos permite picar letras pero en mayúscula.
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			JLabel lblFacturacinPorAo = new JLabel("Usuarios por año de alta");
			lblFacturacinPorAo.setHorizontalAlignment(SwingConstants.CENTER);
			DiseñoyValida.modifyLabel(lblFacturacinPorAo);
			lblFacturacinPorAo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
			lblFacturacinPorAo.setBounds(172, 115, 163, 21);
			contentPane_1.add(lblFacturacinPorAo);
			
			textIdUsuario = new JTextField();
			textIdUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
			textIdUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
			textIdUsuario.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent evt) {
					char car = evt.getKeyChar();
			        if((car<'0' || car>'9') && (car<',' || car>'.')) evt.consume();
				}
			});
			textIdUsuario.setBounds(360, 171, 60, 23);
			contentPane_1.add(textIdUsuario);
			textIdUsuario.setColumns(10);
			
			JButton btnFactA = new JButton("Nº de alquileres");
			btnFactA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					try {
						
						System.out.println(textIdUsuario.getText());
					 	conexion con = new conexion();
						Statement st = con.MySQLConnect().createStatement();
						
						String sql = "SELECT Count(idalquiler) as total FROM alquiler where usuprestatario = "+textIdUsuario.getText()+"";
						
						
						if (textIdUsuario.getText().length() == 0 ){
							JOptionPane.showMessageDialog(null, "Debe introducir el año completo para la consulta");
						}else {
							
						
						
						System.out.println(sql);
						ResultSet rs = st.executeQuery(sql);
									
						
							if(rs.next()) {
								totAlq = rs.getInt("total");
								System.out.println(total);
							}
						
							textTotAno.setText("" + totAlq);
							textIdUsuario.setText("");
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
			btnFactA.setHorizontalAlignment(SwingConstants.LEFT);
			
			btnFactA.setBackground(null);
			DiseñoyValida.modifyButton(btnFactA);
			btnFactA.setBorder(border);
			
			btnFactA.setBounds(448, 172, 150, 23);
			contentPane_1.add(btnFactA);
			
			JLabel lblFacturacinPorCliente_1 = new JLabel("Estadísticas de Usuarios en Juégalos");
			lblFacturacinPorCliente_1.setHorizontalAlignment(SwingConstants.CENTER);
			DiseñoyValida.modifyLabel(lblFacturacinPorCliente_1);
			lblFacturacinPorCliente_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblFacturacinPorCliente_1.setBounds(228, 20, 291, 32);
			contentPane_1.add(lblFacturacinPorCliente_1);
			
			
			textTotAno = new JTextField();
			textTotAno.setHorizontalAlignment(SwingConstants.RIGHT);
			textTotAno.setFont(new Font("Tahoma", Font.BOLD, 12));
			textTotAno.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent evt) {
					char car = evt.getKeyChar();
			        if((car<'0' || car>'9') && (car<',' || car>'.')) evt.consume();
				}
			});
			textTotAno.setBounds(628, 171, 60, 23);
			contentPane_1.add(textTotAno);
			textTotAno.setColumns(10);
		
	}
}
