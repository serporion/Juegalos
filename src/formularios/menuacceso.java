package formularios;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Acceso.BordeRedondo;
import Acceso.FondoPanel;
import Acceso.administracion;
import Acceso.alquileracceso;
import Acceso.DiseñoyValida;
import Acceso.facturaacceso;
import Acceso.juegoacceso;
import Acceso.usuarioacceso;
//import formularios.entradalogin;
//import formularios.inserjuego;
//import formularios.inserusuario;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuacceso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuacceso frame = new menuacceso();
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
	public menuacceso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		Acceso.FondoPanel fondo = new FondoPanel();
		fondo.setBounds(0, 0, 441, 250);
		
		setTitle("MENU PRINCIPAL ADMINISTRADOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(230, 230, 250));
		contentPane_1.setBounds(50, 11, 391, 239);
		contentPane.add(contentPane_1);
		//setContentPane(fondo);
		
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		//contentPane_1.repaint();
		
											
		BordeRedondo border = new BordeRedondo(20);
		
		JButton btnjuegos = new JButton("Juegos");
		btnjuegos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juegoacceso juego = new juegoacceso();
				juego.setLocationRelativeTo(null);
				juego.setVisible(true);
			}
		});
		
		btnjuegos.setBackground(null);
		DiseñoyValida.modifyButton(btnjuegos);
		btnjuegos.setBorder(border);
		
		btnjuegos.setBounds(108, 40, 98, 23);
		contentPane_1.add(btnjuegos);
		
		JButton btnusuarios = new JButton("Usuarios");
		btnusuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarioacceso usuario = new usuarioacceso();
				usuario.setLocationRelativeTo(null);
				usuario.setVisible(true);
			}
		});
		btnusuarios.setBackground(null);
		DiseñoyValida.modifyButton(btnusuarios);
		btnusuarios.setBorder(border);
		
		btnusuarios.setBounds(108, 74, 98, 23);
		contentPane_1.add(btnusuarios);
		
		JButton btnAlquiler = new JButton("Alquiler");
		btnAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alquileracceso alqacc = new alquileracceso();
				alqacc.setLocationRelativeTo(null);
				alqacc.setVisible(true);
			}
		});
		
		btnAlquiler.setBackground(null);
		DiseñoyValida.modifyButton(btnAlquiler);
		btnAlquiler.setBorder(border);
		
		btnAlquiler.setBounds(108, 108, 98, 23);
		contentPane_1.add(btnAlquiler);
		
		JButton btnFactura = new JButton("Facturas");
		btnFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facturaacceso factacc = new facturaacceso();
				factacc.setLocationRelativeTo(null);
				factacc.setVisible(true);
			}
		});
		btnFactura.setBackground(null);
		DiseñoyValida.modifyButton(btnFactura);
		btnFactura.setBorder(border);
		
		btnFactura.setBounds(108, 142, 98, 23);
		contentPane_1.add(btnFactura);
		
		JButton btnSalir = new JButton("Salir",new ImageIcon(getClass().getResource("/imagenes/sara-logo.png")));
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBackground(null);
		btnSalir.setBounds(266, 165, 99, 45);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		
		JButton btnAdministracion = new JButton("Gestión");
		btnAdministracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				administracion ad =new administracion();
				ad.setLocationRelativeTo(null);
				ad.setVisible(true);
			}
		});
		btnAdministracion.setBounds(108, 187, 98, 23);
		btnAdministracion.setBackground(null);
		DiseñoyValida.modifyButton(btnAdministracion);
		btnAdministracion.setBorder(border);
		contentPane_1.add(btnAdministracion);
		
		
	}

}
