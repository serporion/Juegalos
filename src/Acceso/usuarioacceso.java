package Acceso;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import formularios.inserusuario;
import formularios.consultarusuario;
import formularios.eliminarusuario;
import formularios.entradalogin;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class usuarioacceso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usuarioacceso frame = new usuarioacceso();
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
	public usuarioacceso() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		FondoPanel fondo = new FondoPanel();
		fondo.setBounds(0, 0, 434, 250);
		
		
		setTitle("ADMINISTRACIÓN DE USUARIOS");
		
		inserusuario usu = new inserusuario();
		
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
		contentPane_1.setBounds(26, 11, 384, 226);
		contentPane.add(contentPane_1);
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		//contentPane.repaint();
		
		BordeRedondo border = new BordeRedondo(20);
		
		JButton btnInsertar = new JButton("Dar de alta");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usu.setLocationRelativeTo(null);
				usu.setVisible(true);
			}
		});
		btnInsertar.setBounds(134, 58, 109, 23);
		btnInsertar.setBackground(null);
		DiseñoyValida.modifyButton(btnInsertar);
		btnInsertar.setBorder(border);
		contentPane_1.add(btnInsertar);
		
		final consultarusuario consulusu = new consultarusuario();
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(new Color(0, 255, 255));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usu.setLocationRelativeTo(null);
				consulusu.setVisible(true);
			}
		});
		btnConsultar.setBounds(134, 92, 109, 23);
		btnConsultar.setBackground(null);
		DiseñoyValida.modifyButton(btnConsultar);
		btnConsultar.setBorder(border);
		contentPane_1.add(btnConsultar);
		
		final eliminarusuario elimusu = new eliminarusuario();
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(0, 255, 255));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elimusu.setLocationRelativeTo(null);
				elimusu.setVisible(true);
			}
		});
		btnEliminar.setBounds(134, 126, 109, 23);
		btnEliminar.setBackground(null);
		DiseñoyValida.modifyButton(btnEliminar);
		btnEliminar.setBorder(border);
		contentPane_1.add(btnEliminar);
		
		JButton btnvisita = new JButton("..");
		btnvisita.setVisible(false);
		btnvisita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnvisita.setBounds(134, 160, 109, 23);
		btnvisita.setBackground(null);
		DiseñoyValida.modifyButton(btnvisita);
		btnvisita.setBorder(border);
		contentPane_1.add(btnvisita);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(275, 170, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
	}

}
