package formularios;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Acceso.BordeRedondo;
import Acceso.FondoPanel;
import Acceso.DiseñoyValida;
import Acceso.juegousuacceso;
import conexion.conexion;
import login.ControllerLogin;
import login.loginDaoImpl;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;



public class menuaccesousu extends JFrame {

	private JPanel contentPane;
	public static int is = loginDaoImpl.id;
	public static String usito;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuaccesousu frame = new menuaccesousu();
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
	public menuaccesousu() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(menuaccesousu.class.getResource("/imagenes/sara-logo.png")));
		
		FondoPanel fondo = new FondoPanel();
		fondo.setBounds(0, 0, 434, 250);
		
		
		
		try {	  
			
			conexion con = new conexion();
			Statement st = con.MySQLConnect().createStatement();
			
			
			ResultSet rs = st.executeQuery("SELECT usuario.nombre as usito from usuario where dni = '"+entradalogin.usuarioactivo+"'");
			
			
			if (rs.next())
			{
				usito = rs.getString("usito");
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
		
		
		
		setTitle("MENU DEL USUARIO "+usito);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(230, 230, 250));
		contentPane_1.setBounds(36, 11, 387, 239);
		contentPane.add(contentPane_1);
		
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		
		
		BordeRedondo border = new BordeRedondo(20);
		
		JButton btnjuegos = new JButton("Juegos");
		btnjuegos.setBackground(new Color(255, 255, 255));
		btnjuegos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juegousuacceso juegousu = new juegousuacceso();
				juegousu.setLocationRelativeTo(null);
				juegousu.setVisible(true);
			}
			
		});
		btnjuegos.setBounds(115, 54, 112, 23);
		btnjuegos.setBackground(null);
		DiseñoyValida.modifyButton(btnjuegos);
		
		btnjuegos.setBorder(border);
		contentPane_1.add(btnjuegos);
		
		JButton btnfactura = new JButton("Mis Facturas");
		btnfactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				consultarfacturausu factuusu = new consultarfacturausu();
				factuusu.setLocationRelativeTo(null);
				factuusu.setVisible(true);
			}
		});
		btnfactura.setBounds(102, 88, 139, 23);
		
		btnfactura.setBackground(null);
		DiseñoyValida.modifyButton(btnfactura);
		btnfactura.setBorder(border);
		contentPane_1.add(btnfactura);
		
		//JButton btnSalir = new JButton("Salir");//,new ImageIcon(getClass().getResource("/imagenes/sara-logo.png")));
		JButton btnSalir = new JButton("Salir",new ImageIcon()); //ARRIBA HACE REFERENCIA A SETICON DE TOOLKIT
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(loginDaoImpl.us);
				System.out.println(ControllerLogin.saa);
				System.out.println(loginDaoImpl.id);
				System.out.println(is);
				dispose();
			}
		});
		btnSalir.setBackground(null);
		btnSalir.setBounds(275, 172, 99, 45);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		
		
		//JButton btnContacta = new JButton("Contáctanos", new ImageIcon(getClass().getResource("/imagenes/contacto.png")));
		JButton btnContacta = new JButton("Contáctanos",new ImageIcon());  //ARRIBA HACE REFERENCIA A SETICON DE TOOLKIT
	    btnContacta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "https://www.campusmvp.es/recursos/post/como-enviar-correo-electronico-con-java-a-traves-de-gmail.aspx");
				
			}
		});
		btnContacta.setBounds(10, 172, 130, 45);
		btnContacta.setBackground(null);
		DiseñoyValida.modifyButton(btnContacta);
		btnContacta.setBorder(border);
		contentPane_1.add(btnContacta);
		
		
	}
}
