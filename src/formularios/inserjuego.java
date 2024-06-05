package formularios;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Acceso.BordeRedondo;
import Acceso.DiseñoyValida;
import Acceso.DiseñoyValida.LimitedTextField;
import Acceso.FondoPanel;
import juegos.ControllerJuego;
import juegos.juego;
import login.loginDaoImpl;
import usuario_juego.ControllerUsuario_juego;
import usuario_juego.usuario_juego;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Dimension;


public class inserjuego extends JFrame {

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtedicion;
	private JTextArea txtdescripcion;
	public int usuarioe;
	public static Date fechita;
	public static int contador;
	//public static int ses = loginDaoImpl.id;
	
	MaskFormatter formattered;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inserjuego frame = new inserjuego();
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
	public inserjuego() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		Acceso.FondoPanel fondo = new FondoPanel();
		fondo.setBounds(0, 0, 627, 328);
		
		setTitle("ALTA DE JUEGO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(230, 230, 250));
		contentPane_1.setBounds(10, 11, 607, 317);
		contentPane.add(contentPane_1);
		//setContentPane(fondo);
		
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		//contentPane_1.repaint();
		
		BordeRedondo border = new BordeRedondo(20);
		DiseñoyValida instanciaDiseñoyValida = new DiseñoyValida(); 
											
		
		JLabel lblNewLabel = new JLabel("Nombre");
		DiseñoyValida.modifyLabel(lblNewLabel);
		lblNewLabel.setBounds(42, 62, 67, 14);
		contentPane_1.add(lblNewLabel);
		
		txtnombre = new JTextField();
		LimitedTextField txtnombre = instanciaDiseñoyValida.new LimitedTextField(50);
		txtnombre.setBounds(136, 59, 175, 20);
		contentPane_1.add(txtnombre);
		
		try {
			formattered = new MaskFormatter("####"); // La U nos permite picar letras pero en mayúscula.
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		txtedicion = new JTextField();
		JFormattedTextField txtedicion = new JFormattedTextField(formattered);
		DiseñoyValida.validanumero(txtedicion);
		
		txtedicion.setBounds(136, 104, 53, 20);
		contentPane_1.add(txtedicion);
		
		JLabel lblNewLabel_1 = new JLabel("Precio");
		DiseñoyValida.modifyLabel(lblNewLabel_1);
		lblNewLabel_1.setBounds(42, 150, 53, 14);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_9 = new JLabel("Descripcion");
		DiseñoyValida.modifyLabel(lblNewLabel_9);
		lblNewLabel_9.setBounds(328, 150, 86, 14);
		contentPane_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de Alta");
		DiseñoyValida.modifyLabel(lblNewLabel_2);
		lblNewLabel_2.setBounds(328, 72, 97, 22);
		contentPane_1.add(lblNewLabel_2);
		
		Calendar c2 = new GregorianCalendar();
		
		JDateChooser jdcfecha = new JDateChooser();
		jdcfecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		jdcfecha.getCalendarButton().setVisible(false);
		jdcfecha.setEnabled(false);
		jdcfecha.setBounds(425, 72, 97, 20);
		jdcfecha.setCalendar(c2);
		contentPane_1.add(jdcfecha);
		
		
		JLabel lblNewLabel_3 = new JLabel("Insertar Juego");
		DiseñoyValida.modifyLabel(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(244, 23, 132, 20);
		contentPane_1.add(lblNewLabel_3);
		
		JComboBox cbcategoria = new JComboBox();
		cbcategoria.setModel(new DefaultComboBoxModel(new String[] {"Accion", "Aventura Grafica", "Roll", "Terror"}));
		cbcategoria.setBounds(135, 190, 115, 22);
		contentPane_1.add(cbcategoria);
		
		JComboBox cbplataforma = new JComboBox();
		cbplataforma.setModel(new DefaultComboBoxModel(new String[] {"PC", "Switch", "Wii", "Wii U", "Play 1", "Play 2", "Play 3", "Play 4", "Play 5", "Otros"}));
		cbplataforma.setBounds(136, 236, 67, 21);
		contentPane_1.add(cbplataforma);
		
		JLabel lblNewLabel_6 = new JLabel("Edición");
		DiseñoyValida.modifyLabel(lblNewLabel_6);
		lblNewLabel_6.setBounds(42, 107, 92, 14);
		contentPane_1.add(lblNewLabel_6);
		
		
		JSpinner txtprecio = new JSpinner();
		txtprecio.setBounds(136, 147, 53, 20);
		contentPane_1.add(txtprecio);
		
		JLabel lblNewLabel_7 = new JLabel("Categoria");
		DiseñoyValida.modifyLabel(lblNewLabel_7);
		lblNewLabel_7.setBounds(42, 194, 67, 14);
		contentPane_1.add(lblNewLabel_7);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(485, 252, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		
		//contentPane_1.add(txtdescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(120, 81);
		scrollPane.setLocation(416, 150);
		contentPane_1.add(scrollPane);
		
				
		txtdescripcion = new JTextArea();
		txtdescripcion.setPreferredSize(new Dimension(130, 5));
		scrollPane.setViewportView(txtdescripcion);
		
		
		JButton btnInsert = new JButton("Insertar Juego");
		btnInsert.setBorder(border);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtnombre.getText().length() == 0 || txtedicion.getText().length() == 0  || txtdescripcion.getText().length() == 0 ){
					JOptionPane.showMessageDialog(null, "Rellene todos los campos por favor");
				}else {
				
				
				Date date = jdcfecha.getDate(); 
				long d = date.getTime(); 
				java.sql.Date fecha = new java.sql.Date(d);
				
				
				String cat = (String) cbcategoria.getSelectedItem();
				String pla = (String) cbplataforma.getSelectedItem();
				
				fechita = fecha;
				
				juego nuevojuego = new juego(txtnombre.getText(), fechita, cat, pla, txtdescripcion.getText(), txtedicion.getText(), (int) txtprecio.getValue(), contador);
				
				ControllerJuego jueg = new ControllerJuego(); //Creación del objeto
				
				
				jueg.registrar(nuevojuego); //llama al procedimiento con la variable del Modelo 
				
				
				
				int a=0;
				
				
				usuario_juego usujue = new usuario_juego(loginDaoImpl.id, a );
				
				System.out.println(usujue);
				
				ControllerUsuario_juego uj = new ControllerUsuario_juego();
				
				uj.registrar(usujue);
				
				
				//contador = 0;
				
				System.out.println(loginDaoImpl.id);
				
				contador = contador + loginDaoImpl.id;
				System.out.println(contador);
				
				contador++;
				
				System.out.println(contador);
				
				//dispose();
				
				}
			}
		});
		btnInsert.setBounds(302, 266, 137, 31);
		btnInsert.setBackground(null);
		DiseñoyValida.modifyButton(btnInsert);
		btnInsert.setBorder(border);
		contentPane_1.add(btnInsert);
		
		JLabel lblPlataforma = new JLabel("Categoria");
		lblPlataforma.setBounds(42, 239, 67, 14);
		DiseñoyValida.modifyLabel(lblPlataforma);
		contentPane_1.add(lblPlataforma);
		
	
		
		
		
		
	}
}
