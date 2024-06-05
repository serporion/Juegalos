package Acceso;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import formularios.administracionusuarios;
import formularios.administrafacturacion;
import formularios.entradalogin;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class administracion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administracion frame = new administracion();
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
	public administracion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		Acceso.FondoPanel fondo = new FondoPanel();
		fondo.setBounds(0, 0, 434, 250);
		
		setTitle("MENÚ DE GESTIÓN");
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
		contentPane_1.setBounds(50, 11, 373, 239);
		contentPane.add(contentPane_1);
		//setContentPane(fondo);
		
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		//contentPane_1.repaint();
		
											
		BordeRedondo border = new BordeRedondo(20);
		
		JButton btnjuegos = new JButton("Consultas Facturación");
		btnjuegos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administrafacturacion admfac = new administrafacturacion();
				admfac.setLocationRelativeTo(null);
				admfac.setVisible(true);
			}
		});
		
		btnjuegos.setBackground(null);
		DiseñoyValida.modifyButton(btnjuegos);
		btnjuegos.setBorder(border);
		
		btnjuegos.setBounds(69, 65, 175, 23);
		contentPane_1.add(btnjuegos);
		
		
		JButton btnusuarios = new JButton("Consultas de Usuarios");
		btnusuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administracionusuarios usuario = new administracionusuarios();
				usuario.setLocationRelativeTo(null);
				usuario.setVisible(true);
			}
		});
		btnusuarios.setBackground(null);
		DiseñoyValida.modifyButton(btnusuarios);
		btnusuarios.setBorder(border);
		
		btnusuarios.setBounds(69, 109, 175, 23);
		contentPane_1.add(btnusuarios);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(264, 161, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		
	}

}
