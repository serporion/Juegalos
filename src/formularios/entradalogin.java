package formularios;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Acceso.BordeRedondo;
import Acceso.FondoPanel;
import Acceso.DiseñoyValida;
import Acceso.DiseñoyValida.LimitedTextFieldContrasena;
import login.ControllerLogin;
import login.login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;

public class entradalogin extends JFrame {


	private JPanel contentPane;
	
	public static JTextField txtusuario;
	public static JPasswordField txtcontrasenaP;
	public static String usuarioactivo;
	public static String usi;
	
	MaskFormatter formatter;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					entradalogin frame = new entradalogin();
					
					//TAMAÑO Y CENTRADO DE LA APLICACIÓN
					//frame.setSize(500,500);  
					frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
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
	public entradalogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		Acceso.FondoPanel fondo = new FondoPanel();
		fondo.setBounds(0, 0, 481, 301);
		
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(230, 230, 250));
		contentPane_1.setBounds(50, 11, 431, 290);
		contentPane.add(contentPane_1);
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		//contentPane.repaint();
	
		BordeRedondo border = new BordeRedondo(20);
		DiseñoyValida instanciaDiseñoyValida = new DiseñoyValida();
		
		try {
			formatter = new MaskFormatter("########U"); // La U nos permite escribir letras pero en mayúscula.
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		JLabel lblusuario = new JLabel("Usuario");
		lblusuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblusuario.setForeground(new Color(0, 255, 255));
		lblusuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblusuario.setBounds(141, 54, 86, 14);
		contentPane_1.add(lblusuario);
		contentPane_1.repaint();
		
		txtusuario = new JTextField();
		JFormattedTextField txtusuario = new JFormattedTextField(formatter);
		txtusuario.setBounds(141, 75, 86, 20);
		contentPane_1.add(txtusuario);
		
		JLabel lblcontraseña = new JLabel("Contraseña");
		lblcontraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblcontraseña.setForeground(new Color(0, 255, 255));
		lblcontraseña.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblcontraseña.setBounds(141, 106, 86, 14);
		contentPane_1.add(lblcontraseña);
		
		txtcontrasenaP = new JPasswordField();
		LimitedTextFieldContrasena txtcontrasenaP = instanciaDiseñoyValida.new LimitedTextFieldContrasena(20);
		txtcontrasenaP.setBounds(141, 131, 86, 20);
		contentPane_1.add(txtcontrasenaP);
		
	
		
		JButton logate = new JButton("Acceder");
		getRootPane().setDefaultButton(logate);
		logate.requestFocusInWindow();
		logate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
	
				if (txtusuario.getText().length()==0 || txtcontrasenaP.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Debe introducir un usuario y una contraseña");
					txtusuario.setText("");
					txtcontrasenaP.setText("");
					getRootPane().setDefaultButton(logate);
					logate.requestFocusInWindow();
				}else {
				
				usuarioactivo = txtusuario.getText();
				
				
				login nuevologin = new login(1, txtusuario.getText(), txtcontrasenaP.getPassword());
				//login nuevologin = new login(txtusuario.getText(),txtcontrasena.getText());
				
				ControllerLogin log = new ControllerLogin(); 
				
				log.comprobar(nuevologin); 
				
				dispose();
				}
				
			}
		});
		
		logate.setBounds(130, 174, 115, 23);
		logate.setBackground(null);
		DiseñoyValida.modifyButton(logate);
		logate.setBorder(border);
		contentPane_1.add(logate);
	
		
		JButton bootexit = new JButton("Salir",new ImageIcon(getClass().getResource("/imagenes/sara-logo.png")));
		bootexit.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		bootexit.setIconTextGap(10);
		bootexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bootexit.setBackground(null);
		bootexit.setBounds(294, 199, 112, 45);
		DiseñoyValida.modifyButton(bootexit);
		bootexit.setBorder(border);
		contentPane_1.add(bootexit);
		
		
		
	}
	
	
	
}
