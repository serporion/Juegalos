package Acceso;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import formularios.alquilarjuego;
import formularios.consultarjuegosusu;
import formularios.entradalogin;
import formularios.inserjuego;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

public class juegousuacceso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					juegousuacceso frame = new juegousuacceso();
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
	public juegousuacceso() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		Acceso.FondoPanel fondo = new FondoPanel();
		fondo.setBounds(0, 0, 434, 250);
		
		inserjuego inser = new inserjuego();
		alquilarjuego alnew = new alquilarjuego();
		
		
		setTitle("JUEGOS");
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
		contentPane_1.setBounds(26, 11, 398, 239);
		contentPane.add(contentPane_1);
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		//contentPane.repaint();
		
		
		BordeRedondo border = new BordeRedondo(20);
		
		
		JButton btnInsertar = new JButton("Dar de Alta");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inser.setLocationRelativeTo(null);
				inser.setVisible(true);				
			}
			
		});
		btnInsertar.setBounds(119, 60, 126, 23);
		btnInsertar.setBackground(null);
		DiseñoyValida.modifyButton(btnInsertar);
		btnInsertar.setBorder(border);
		contentPane_1.add(btnInsertar);
		
		final consultarjuegosusu consuljue = new consultarjuegosusu();
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consuljue.setLocationRelativeTo(null);
				consuljue.setVisible(true);
			}
		});
		btnConsultar.setBounds(119, 94, 123, 23);
		btnConsultar.setBackground(null);
		DiseñoyValida.modifyButton(btnConsultar);
		btnConsultar.setBorder(border);
		contentPane_1.add(btnConsultar);
		
		JButton btnAlquilar = new JButton("Alquilar");
		btnAlquilar.setBackground(new Color(0, 255, 255));
		btnAlquilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alnew.setLocationRelativeTo(null);
				alnew.setVisible(true);
			}
		});
		btnAlquilar.setBounds(119, 128, 126, 23);
		btnAlquilar.setBackground(null);
		DiseñoyValida.modifyButton(btnAlquilar);
		btnAlquilar.setBorder(border);
		contentPane_1.add(btnAlquilar);
		
		JButton btnvisita = new JButton("..");
		btnvisita.setVisible(false);
		btnvisita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnvisita.setBounds(134, 162, 97, 23);
		contentPane_1.add(btnvisita);
		
		JButton bootexit = new JButton("Salir",new ImageIcon());
		bootexit.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		bootexit.setIconTextGap(4);
		bootexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bootexit.setBackground(null);
		bootexit.setBounds(269, 174, 99, 45);
		DiseñoyValida.modifyButton(bootexit);
		bootexit.setBorder(border);
		contentPane_1.add(bootexit);
		
		JLabel lblMenDeJuegos = new JLabel("MENÚ DE JUEGOS");
		lblMenDeJuegos.setHorizontalAlignment(SwingConstants.CENTER);
		DiseñoyValida.modifyLabel(lblMenDeJuegos);
		lblMenDeJuegos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblMenDeJuegos.setBounds(-14, 11, 389, 32);
		contentPane_1.add(lblMenDeJuegos);
		
	}
}
