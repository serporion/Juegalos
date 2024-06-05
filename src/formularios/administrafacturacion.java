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

import Acceso.BordeRedondo;
import Acceso.DiseñoyValida;
import Acceso.FondoPanel;
import conexion.conexion;

import java.awt.Color;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class administrafacturacion extends JFrame {

	private JPanel contentPane;
	
	
	public static double total=0;
	private JTextField textbusqueda;
	private JTextField textCliente;
	private JTextField textAno;
	private JTextField textTotCli;
	private JTextField textTotAno;
	private double totCli =0;
	private double totAno =0;
	
	final JTable table=new JTable();
	DefaultTableModel model;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administrafacturacion frame = new administrafacturacion();
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
	public administrafacturacion() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		FondoPanel fondo = new FondoPanel();
		fondo.setBounds(10, 10, 763, 332);
		
		BordeRedondo border = new BordeRedondo(20);
		
		setTitle("ADMINISTRACION - FACTURACION");
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
		scroll.setBounds(32, 69, 140, 200);
		contentPane_1.add(scroll);
		
		try {
		
					
					conexion con1 =new conexion();
					Statement st1 = con1.MySQLConnect().createStatement();
					ResultSet rs1 = st1.executeQuery("SELECT idcli,nombre FROM usuario");
					
		
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
					//case 2:
						//return Object.class;
					
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
		  
		   
		
		    //PREDEFINE EL ANCHO DE LA COLUMNA AL ANCHO DE SU ETIQUETA
		    
		    TableColumnModel columnModel = table.getColumnModel();
		    for (int column = 0; column < table.getColumnCount(); column++) {
		        TableColumn tableColumn = columnModel.getColumn(column);
		        int preferredWidth = tableColumn.getHeaderValue().toString().length()*15;// EL NUMERO ES PARA EL AJUSTE ENTRE COLUMNA Y DATO
		        tableColumn.setPreferredWidth(preferredWidth);
		    }
		
		    //THE ROW
			while (rs1.next()){
				Object [] filas = new Object[2];
		
		    for(int i=0;i<2;i++) {    	 
		    	filas[i] = rs1.getObject(i+1);
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
				
		
		
		JButton btnFactC = new JButton("Facturación");
		btnFactC.setHorizontalAlignment(SwingConstants.LEFT);
		btnFactC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					System.out.println(textCliente.getText());
				 	conexion con = new conexion();
					Statement st = con.MySQLConnect().createStatement();
					
					String sql = "SELECT sum(importetotal) as total FROM factura where cliente = "+textCliente.getText()+"";
					
					
					if (textCliente.getText().length() == 0 ) {
						JOptionPane.showMessageDialog(null, "Debe introducir un Id de Cliente");
					}else {
						
					
					
					System.out.println(sql);
					ResultSet rs = st.executeQuery(sql);
								
					
						if(rs.next()) {
							totCli = rs.getDouble("total");
							System.out.println(total);
						}
					
						textTotCli.setText("" + totCli + " €" );
						textCliente.setText("");
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
		btnFactC.setBounds(488, 98, 114, 23);
		
		btnFactC.setBackground(null);
		DiseñoyValida.modifyButton(btnFactC);
		btnFactC.setBorder(border);
		contentPane_1.add(btnFactC);
		
		textTotCli = new JTextField();
		textTotCli.setHorizontalAlignment(SwingConstants.RIGHT);
		textTotCli.setFont(new Font("Tahoma", Font.BOLD, 12));
		textTotCli.setBounds(628, 100, 86, 23);
		
		contentPane_1.add(textTotCli);
		textTotCli.setColumns(10);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(615, 239, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		
		JLabel lblConsultaCliente = new JLabel("Facturación Total");
		DiseñoyValida.modifyLabel(lblConsultaCliente);
		lblConsultaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaCliente.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lblConsultaCliente.setBounds(199, 229, 120, 32);
		contentPane_1.add(lblConsultaCliente);
		
		
		 try {

				conexion con =new conexion();
				Statement st = con.MySQLConnect().createStatement();
				ResultSet rs = st.executeQuery("SELECT sum(importetotal) as total FROM factura;");		

				if(rs.next()) {
					total = rs.getDouble("total");
					System.out.println(total);
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
		
		 	textbusqueda = new JTextField();
		 	textbusqueda.setHorizontalAlignment(SwingConstants.RIGHT);
		 	textbusqueda.setFont(new Font("Tahoma", Font.BOLD, 12));
			textbusqueda.setBounds(199, 272, 86, 32);
			textbusqueda.setText("" + total + " €");
			contentPane_1.add(textbusqueda);
			textbusqueda.setColumns(10);
			
			JLabel lblFacturacinPorCliente = new JLabel("Facturación por Id de Cliente");
			lblFacturacinPorCliente.setHorizontalAlignment(SwingConstants.CENTER);
			DiseñoyValida.modifyLabel(lblFacturacinPorCliente);
			lblFacturacinPorCliente.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
			lblFacturacinPorCliente.setBounds(189, 90, 198, 34);
			contentPane_1.add(lblFacturacinPorCliente);
			
			textCliente = new JTextField();
			textCliente.setHorizontalAlignment(SwingConstants.RIGHT);
			textCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
			textCliente.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent evt) {
					char car = evt.getKeyChar();
			        if((car<'0' || car>'9') && (car<',' || car>'.')) evt.consume();
				}
			});
			textCliente.setBounds(397, 100, 60, 23);
			contentPane_1.add(textCliente);
			textCliente.setColumns(10);
			
			JLabel lblFacturacinPorAo = new JLabel("Facturación por año");
			lblFacturacinPorAo.setHorizontalAlignment(SwingConstants.CENTER);
			DiseñoyValida.modifyLabel(lblFacturacinPorAo);
			lblFacturacinPorAo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
			lblFacturacinPorAo.setBounds(189, 158, 150, 32);
			contentPane_1.add(lblFacturacinPorAo);
			
			textAno = new JTextField();
			textAno.setHorizontalAlignment(SwingConstants.RIGHT);
			textAno.setFont(new Font("Tahoma", Font.BOLD, 12));
			textAno.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent evt) {
					char car = evt.getKeyChar();
			        if((car<'0' || car>'9') && (car<',' || car>'.')) evt.consume();
				}
			});
			textAno.setBounds(397, 164, 60, 23);
			contentPane_1.add(textAno);
			textAno.setColumns(10);
			
			JButton btnFactA = new JButton("Facturación");
			btnFactA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					try {
						
						System.out.println(textAno.getText());
					 	conexion con = new conexion();
						Statement st = con.MySQLConnect().createStatement();
						
						String sql = "SELECT sum(importetotal) as total FROM factura where year(fecha) = "+textAno.getText()+"";
						
						
						if (textAno.getText().length() == 0 || textAno.getText().length() < 4) {
							JOptionPane.showMessageDialog(null, "Debe introducir el año completo para la consulta");
						}else {
							
						
						
						System.out.println(sql);
						ResultSet rs = st.executeQuery(sql);
									
						
							if(rs.next()) {
								totAno = rs.getDouble("total");
								System.out.println(total);
							}
						
							textTotAno.setText("" + totAno + " €" );
							textAno.setText("");
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
			
			btnFactA.setBounds(488, 161, 114, 23);
			contentPane_1.add(btnFactA);
			
			JLabel lblFacturacinPorCliente_1 = new JLabel("Facturación de Juégalos");
			lblFacturacinPorCliente_1.setHorizontalAlignment(SwingConstants.CENTER);
			DiseñoyValida.modifyLabel(lblFacturacinPorCliente_1);
			lblFacturacinPorCliente_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblFacturacinPorCliente_1.setBounds(228, 20, 291, 32);
			contentPane_1.add(lblFacturacinPorCliente_1);
			
			
			textTotAno = new JTextField();
			textTotAno.setBounds(628, 163, 86, 23);
			contentPane_1.add(textTotAno);
			textTotAno.setColumns(10);
		
	}
}
