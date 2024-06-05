package Acceso;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import formularios.abonofactura;
import formularios.consultarfactura;
import formularios.entradalogin;
import formularios.inserfactura;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class facturaacceso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					facturaacceso frame = new facturaacceso();
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
	public facturaacceso() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		FondoPanel fondo = new FondoPanel();
		fondo.setBounds(0, 0, 434, 250);
		
		BordeRedondo border = new BordeRedondo(20);
	
		
		setTitle("ADMINISTRACION FACTURAS");
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
		
		
		JButton btnInsertar = new JButton("Dar de alta");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserfactura infac = new inserfactura();
				infac.setLocationRelativeTo(null);
				infac.setVisible(true);				
			}
			
		});
		btnInsertar.setBounds(115, 49, 112, 23);
		btnInsertar.setBackground(null);
		DiseñoyValida.modifyButton(btnInsertar);
		btnInsertar.setBorder(border);
		contentPane_1.add(btnInsertar);
		
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(new Color(0, 255, 255));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarfactura confa = new consultarfactura();
				confa.setLocationRelativeTo(null);
				confa.setVisible(true);
			}
		});
		btnConsultar.setBounds(115, 83, 112, 23);
		btnConsultar.setBackground(null);
		DiseñoyValida.modifyButton(btnConsultar);
		btnConsultar.setBorder(border);
		contentPane_1.add(btnConsultar);
		
		JButton btnEliminar = new JButton("Abonar");
		btnEliminar.setBackground(new Color(0, 255, 255));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abonofactura abon = new abonofactura();
				abon.setLocationRelativeTo(null);
				abon.setVisible(true);
			}
		});
		btnEliminar.setBounds(115, 117, 112, 23);
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
		btnOtros.setBounds(115, 151, 97, 23);
		contentPane_1.add(btnOtros);
		
		JButton btnSalir = new JButton("Salir",new ImageIcon(getClass().getResource("/imagenes/sara-logo.png")));
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(266, 165, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
	}
}
