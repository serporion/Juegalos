package Acceso;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import formularios.alquilarjuego;
import formularios.consultaralquiler;

import formularios.eliminaralquiler;
import formularios.entradalogin;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class alquileracceso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alquileracceso frame = new alquileracceso();
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
	public alquileracceso() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		FondoPanel fondo = new FondoPanel();
		fondo.setBounds(0, 0, 434, 250);
		
		
		setTitle("ADMINISTRACION DE ALQUILERES");
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
		
		
		JButton btnInsertar = new JButton("Dar de alta");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alquilarjuego alqjue = new alquilarjuego();
				alqjue.setLocationRelativeTo(null);
				alqjue.setVisible(true);				
			}
			
		});
		btnInsertar.setBounds(100, 62, 119, 23);
		btnInsertar.setBackground(null);
		DiseñoyValida.modifyButton(btnInsertar);
		btnInsertar.setBorder(border);
		contentPane_1.add(btnInsertar);
		
		
		JButton btnModificar = new JButton("Consultar");
		btnModificar.setBackground(new Color(0, 255, 255));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaralquiler conalq = new consultaralquiler();
				conalq.setLocationRelativeTo(null);
				conalq.setVisible(true);
			}
		});
		btnModificar.setBounds(100, 96, 119, 23);
		btnModificar.setBackground(null);
		DiseñoyValida.modifyButton(btnModificar);
		btnModificar.setBorder(border);
		contentPane_1.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(0, 255, 255));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminaralquiler elialq = new eliminaralquiler();
				elialq.setLocationRelativeTo(null);
				elialq.setVisible(true);
			}
		});
		btnEliminar.setBounds(100, 130, 119, 23);
		btnEliminar.setBackground(null);
		DiseñoyValida.modifyButton(btnEliminar);
		btnEliminar.setBorder(border);
		contentPane_1.add(btnEliminar);
		
		JButton btnOtros = new JButton("..");
		btnOtros.setVisible(false);
		btnOtros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOtros.setBounds(111, 164, 97, 23);
		contentPane_1.add(btnOtros);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(265, 171, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
	}
}
