package Acceso;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import Acceso.administracion;
import formularios.consultarjuegosusu;
import formularios.eliminarjuego;
import formularios.entradalogin;
import formularios.inserjuego;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class juegoacceso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					juegoacceso frame = new juegoacceso();
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
	public juegoacceso() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		Acceso.FondoPanel fondo = new FondoPanel();
		fondo.setBounds(0, 0, 434, 250);
		
		
		inserjuego inser = new inserjuego();
		eliminarjuego elimin = new eliminarjuego(); 
		
		setTitle("ADMINISTRACION DE JUEGOS");
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
		contentPane_1.setBounds(50, 11, 374, 227);
		contentPane.add(contentPane_1);
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		//contentPane.repaint();
		
		
		BordeRedondo border = new BordeRedondo(20);
		
		
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inser.setLocationRelativeTo(null);
				inser.setVisible(true);				
			}
			
		});
		
		btnInsertar.setBackground(null);
		DiseñoyValida.modifyButton(btnInsertar);
		btnInsertar.setBorder(border);
		
		btnInsertar.setBounds(81, 50, 131, 23);
		contentPane_1.add(btnInsertar);
		
		final consultarjuegosusu consuljue = new consultarjuegosusu();
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consuljue.setLocationRelativeTo(null);
				consuljue.setVisible(true);
				
			}
		});
		btnConsultar.setBackground(null);
		DiseñoyValida.modifyButton(btnConsultar);
		btnConsultar.setBorder(border);
		
		btnConsultar.setBounds(81, 84, 131, 23);
		contentPane_1.add(btnConsultar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(0, 255, 255));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elimin.setLocationRelativeTo(null);
				elimin.setVisible(true);
			}
		});
		btnEliminar.setBackground(null);
		DiseñoyValida.modifyButton(btnEliminar);
		btnEliminar.setBorder(border);
		
		btnEliminar.setBounds(81, 118, 131, 23);
		contentPane_1.add(btnEliminar);
		
	
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(249, 175, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
	}
}
