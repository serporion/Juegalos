package formularios;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Acceso.BordeRedondo;
import Acceso.DiseñoyValida;
import Acceso.FondoPanel;
import facturas.ControllerFactura;
import facturas.factura;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.util.List;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


public class inserfactura extends JFrame {

	private JPanel contentPane;
	private JTextField txtservicio;
	private JTextField txtFactura;
	private JTextField txtdescripcion;
	public static List<Integer> listaIdU; 
	public static List<Integer> listaIdQ;
	public static List<String> listaIdnif;
	public static List<Integer> listaprecio;
	public static List<Date> listafecha;
	public static List<Date> listafechas;
	public static List<String> listajuegos;
	
	final double servicio = 1.5;
	final double iv = 21;
	double iva;
	public int precio;
	double imptot;
	
	
	
	public int usuarioe;
	public static Date fechita;
	public String nif;
	
	private JTextField txtiva;
	public int indiceC;
	public int indiceCC;
	public int indiceF;
	public int indiceG;
	public int indiceH;
	public int usufact;
	public Date usufactpre;
	public Date usufactprea;
	public int aaa;
	public int usup;
	public double importetotal;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inserfactura frame = new inserfactura();
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
	public inserfactura() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		Acceso.FondoPanel fondo = new FondoPanel();
		fondo.setBounds(0, 0, 649, 417);
		
		setTitle("ALTA DE FACTURA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(230, 230, 250));
		contentPane_1.setBounds(10, 11, 639, 390);
		contentPane.add(contentPane_1);
		//setContentPane(fondo);
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		
		BordeRedondo border = new BordeRedondo(20);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		DiseñoyValida.modifyLabel(lblNewLabel);
		lblNewLabel.setBounds(42, 104, 67, 14);
		contentPane_1.add(lblNewLabel);
		
		txtservicio = new JTextField();
		txtservicio.setEnabled(false);
		txtservicio.setText(servicio + " €");
		txtservicio.setEditable(false);
		txtservicio.setColumns(10);
		txtservicio.setBounds(326, 275, 36, 20);
		contentPane_1.add(txtservicio);
		
		txtFactura = new JTextField();
		txtFactura.setEnabled(false);
		txtFactura.setColumns(10);
		txtFactura.setBounds(467, 275, 46, 20);
		contentPane_1.add(txtFactura);
		
		JLabel lblNewLabel_9 = new JLabel("Descripcion");
		DiseñoyValida.modifyLabel(lblNewLabel_9);
		lblNewLabel_9.setBounds(42, 147, 86, 14);
		contentPane_1.add(lblNewLabel_9);
		
		txtdescripcion = new JTextField();
		txtdescripcion.setColumns(10);
		txtdescripcion.setText("Alquiler del título " );
		txtdescripcion.setBounds(119, 144, 359, 20);
		contentPane_1.add(txtdescripcion);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de Factura");
		DiseñoyValida.modifyLabel(lblNewLabel_2);
		lblNewLabel_2.setBounds(42, 52, 122, 22);
		contentPane_1.add(lblNewLabel_2);
		
		Calendar c2 = new GregorianCalendar();
		
		JDateChooser jdcfecha = new JDateChooser();
		jdcfecha.getCalendarButton().setVisible(false);
		jdcfecha.setEnabled(false);
		jdcfecha.setBounds(174, 52, 114, 20);
		jdcfecha.setCalendar(c2);
		contentPane_1.add(jdcfecha);
		
		
		JLabel lblNewLabel_3 = new JLabel("Insertar Facturas");
		DiseñoyValida.modifyLabel(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(268, 22, 176, 20);
		contentPane_1.add(lblNewLabel_3);
		
		
		JComboBox cbnombre = new JComboBox();
		cbnombre.setBounds(119, 100, 479, 22);
		contentPane_1.add(cbnombre);
		
	
		
		
				listaIdU = new ArrayList<Integer>();
				listaIdnif = new ArrayList<String>();
				//listaprecio = new ArrayList<Integer>();
				listafecha = new ArrayList<Date>();
				//listaIdQ = new ArrayList<Integer>();
				//listafechas = new ArrayList<Date>();
				
				try 
				{
					Connection conexion =DriverManager.getConnection("jdbc:mysql://localhost/juegalos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");//-> segun tu bd
					Statement st =conexion.createStatement();
					//ResultSet rs=st.executeQuery("SELECT usuario.nombre, usuario.apellidos, usuario.dni, usuario.idcli, alquiler.precio, FROM usuario join alquiler on usuario.idcli = alquiler.usuprestatario group by dni order by apellidos,nombre; ");
					ResultSet rs=st.executeQuery("SELECT nombre, apellidos, dni, idcli FROM usuario join alquiler on usuario.idcli = alquiler.usuprestatario group by dni order by apellidos,nombre; ");
					while(rs.next())
					{
						cbnombre.addItem((rs.getString("nombre")+" "+rs.getString("apellidos")+" DNI "+rs.getString("dni")));  //->un campo a mostrar en el combo
						
						
						listaIdU.add(rs.getInt("idcli"));//->añado el id a una lista auxiliar
						listaIdnif.add(rs.getString("dni"));
						//listaprecio.add(rs.getInt("precio"));
						//listafecha.add(rs.getDate("fechainicio"));
						//listafechas.add(rs.getDate("fechainicio"));
	
					}
					
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
				
				JComboBox cbfecha = new JComboBox();
				cbfecha.setBounds(149, 191, 449, 22);
				contentPane_1.add(cbfecha);
				
				
				cbnombre.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						indiceC =cbnombre.getSelectedIndex();
						usup = listaIdU.get(indiceC);
						
						System.out.println("el cliente es " + usup);
						
						
						indiceF = cbnombre.getSelectedIndex();
						usufact = listaIdU.get(indiceF);
						
						cbfecha.removeAllItems();
						
						System.out.println(usufact);
						
						listaIdQ = new ArrayList<Integer>();
						listaprecio = new ArrayList<Integer>();
						listafechas = new ArrayList<Date>();
						
						//aqui
						
						try 
						{
							Connection conexion =DriverManager.getConnection("jdbc:mysql://localhost/juegalos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");//-> segun tu bd
							Statement st1 =conexion.createStatement();
							ResultSet rs1=st1.executeQuery("SELECT alquiler.idalquiler, alquiler.usuprestatario, alquiler.fechainicio, juego.idpro, juego.nombre, alquiler.importetotal FROM alquiler LEFT join factura on factura.idalquiler = alquiler.idalquiler join juego on juego.idpro = alquiler.idpro WHERE alquiler.usuprestatario = '"+usufact+"' and (factura.idalquiler is null or factura.abono != 'NULL')"); 
							//ResultSet rs1=st1.executeQuery("SELECT alquiler.idalquiler, alquiler.usuprestatario, alquiler.fechainicio, juego.idpro, juego.nombre, alquiler.importetotal FROM alquiler LEFT join factura on factura.idalquiler = alquiler.idalquiler join juego on juego.idpro = alquiler.idpro WHERE factura.idalquiler is null and alquiler.usuprestatario = '"+usufact+"'"); // or factura.abono != 'NULL'");
							
							
							while(rs1.next())
							{
								//juego.precio
								cbfecha.addItem(("Alquiler del  " +rs1.getDate("alquiler.fechainicio")+ "  Importe " +rs1.getDouble("alquiler.importetotal") + " euros.  Juego :  " +rs1.getString("juego.nombre")));  //->un campo a mostrar en el combo
								listaIdQ.add(rs1.getInt("alquiler.idalquiler"));//->añado el id a una lista auxiliar
								listafechas.add(rs1.getDate("fechainicio"));
								listaprecio.add(rs1.getInt("importetotal"));  //precio
								
								//listajuegos.add(rs1.getString("juego.nombre"));
								
								importetotal = rs1.getDouble("alquiler.importetotal");
								System.out.println("este sería el importe TOTAL" +importetotal) ;
						}
						
												
						}
						catch (SQLException f) 
						{
							f.printStackTrace();
						}
																
					}
				});
				
				
				
				cbfecha.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent g) {
						
						String cat = (String) cbfecha.getSelectedItem();
						
						if (cat != null) {
						
						//String cat = (String) cbfecha.getSelectedItem();
						String juego = cat.substring(53);
						
						
						System.out.println(juego);
						
						txtdescripcion.setText("Alquiler del título " + juego );
						
					/*	
						indiceG = cbfecha.getSelectedIndex();
						aaa = listaIdQ.get(indiceG);
						precio = listaprecio.get(indiceG);
					*/
						String suma = cat.substring(34, 36);
						
						char b = suma.charAt(0);
						int bb = Character.getNumericValue(b);
						
						System.out.println(b);
						System.out.println(bb);
						
						iva = (servicio*(iv/100));
						imptot = (bb + servicio + iva);
						
						
						System.out.println(iv/100);
				
											
						//txtFactura.setText(" " + Math.floor(imptot*100)/100);
						
						System.out.println(importetotal);
						
						
						txtFactura.setText(String.valueOf(importetotal));
						
						}
					}
				});
				
			
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(467, 334, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		
		
		contentPane_1.add(btnSalir);
		
		txtiva = new JTextField(iv+"%");
		txtiva.setEnabled(false);
		txtiva.setEditable(false);
		txtiva.setHorizontalAlignment(SwingConstants.CENTER);
		txtiva.setBounds(109, 275, 46, 20);
		contentPane_1.add(txtiva);
		txtiva.setColumns(10);
		
		JLabel lblIva = new JLabel("IVA");
		DiseñoyValida.modifyLabel(lblIva);
		lblIva.setBounds(42, 278, 46, 14);
		contentPane_1.add(lblIva);
		
		
		JButton btnInsertar = new JButton("Insertar Factura");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Date date = jdcfecha.getDate(); 
				//jdcfecha.setDateFormatString("yyyy/MM/dd","#####/##/##"," ");
				//jdcfecha.set
				long d = date.getTime(); 
				java.sql.Date fecha = new java.sql.Date(d);
				
				indiceH = cbnombre.getSelectedIndex();
				
				nif = listaIdnif.get(indiceH);
				
				
				indiceG = cbfecha.getSelectedIndex();
				aaa = listaIdQ.get(indiceG);
				precio = listaprecio.get(indiceG);
				
				
				fechita = fecha;
				
				
				System.out.println("el idalquiler es " +aaa);
				
				
				System.out.println(fechita);
				System.out.println(usup);
				System.out.println(txtdescripcion.getText());
				System.out.println(precio);
				System.out.println(servicio);
				System.out.println(iva);
				System.out.println(imptot);
				System.out.println(aaa);
				
				//System.out.println(nif);
				//System.out.println(listaIdnif);
				
				double preciobas = importetotal - servicio - iva;
				
				int preciobase = (int) (preciobas);
				
				Date dd = listafechas.get(indiceG);
				
				System.out.println("LA FECHA ES " + dd);
				
				System.out.println(preciobase);
				
				String abonos = "NULL";
				
				factura nuevafactura = new factura(fechita, usup, txtdescripcion.getText(), preciobase, servicio, iva, importetotal, aaa, abonos);
				
				ControllerFactura factu = new ControllerFactura(); //Creación del objeto
				
				factu.registrar(nuevafactura); //llama al procedimiento con la variable del Modelo 
				
				txtFactura.setText("");
				
				//dispose();
				
			}
		});
		
		btnInsertar.setBounds(281, 350, 143, 30);
		btnInsertar.setBackground(null);
		DiseñoyValida.modifyButton(btnInsertar);
		btnInsertar.setBorder(border);
		contentPane_1.add(btnInsertar);
		
		JLabel lblNewLabel_4 = new JLabel("Precio del Servicio");
		DiseñoyValida.modifyLabel(lblNewLabel_4);
		lblNewLabel_4.setBounds(197, 278, 119, 14);
		contentPane_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Total FACTURA");
		DiseñoyValida.modifyLabel(lblNewLabel_5);
		lblNewLabel_5.setBounds(467, 244, 114, 20);
		contentPane_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha Alquiler");
		DiseñoyValida.modifyLabel(lblNewLabel_6);
		lblNewLabel_6.setBounds(310, 56, 72, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_2_1 = new JLabel("Datos del Alquiler");
		DiseñoyValida.modifyLabel(lblNewLabel_2_1);
		lblNewLabel_2_1.setBounds(42, 191, 113, 22);
		contentPane_1.add(lblNewLabel_2_1);
		
		
	}
}
