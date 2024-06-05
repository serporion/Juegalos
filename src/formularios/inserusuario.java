package formularios;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import usuarios.ControllerUsuario;
import usuarios.usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import Acceso.DiseñoyValida;
import Acceso.BordeRedondo;
import Acceso.FondoPanel;
import Acceso.DiseñoyValida.LimitedTextField;
import login.ControllerLogin;
import login.login;


public class inserusuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtdni;
	private JTextField txttelefono;
	private JTextField txtapellidos;
	private JTextField txtdireccion;
	private JTextField txtpoblacion;
	private JTextField txtprovincia;
	private JTextField txtCp;
	private String forma;
	public static Date fechita;
	
	MaskFormatter formatter;
	MaskFormatter formattercp;
	MaskFormatter formattertelefono;
	MaskFormatter formattertarjeta;
	
	private JTextField txttarjeta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inserusuario frame = new inserusuario();
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
	public inserusuario() {
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(entradalogin.class.getResource("/imagenes/sara-logo.png")));
		
		Acceso.FondoPanel fondo = new FondoPanel();
		fondo.setBounds(10, 11, 621, 337);
		
		
		
		setTitle("ALTA DE USUARIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(230, 230, 250));
		contentPane_1.setBounds(10, 11, 608, 337);
		contentPane.add(contentPane_1);
		//setContentPane(fondo);
		
		contentPane_1.setOpaque(false);
		contentPane.add(fondo);
		
		BordeRedondo border = new BordeRedondo(20);
		DiseñoyValida instanciaDiseñoyValida = new DiseñoyValida();
		
		Calendar c2 = new GregorianCalendar();
		
		JDateChooser jdcfecha = new JDateChooser();
		jdcfecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		jdcfecha.getCalendarButton().setVisible(false);
		jdcfecha.setEnabled(false);
		jdcfecha.setBounds(476, 24, 97, 20);
		jdcfecha.setCalendar(c2);
		contentPane_1.add(jdcfecha);
		
		JLabel lblNewLabel_6 = new JLabel("Insertar Usuario");
		DiseñoyValida.modifyLabel(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(245, 11, 154, 22);
		contentPane_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		DiseñoyValida.modifyLabel(lblNewLabel);
		lblNewLabel.setBounds(34, 67, 67, 14);
		contentPane_1.add(lblNewLabel);
		
		txtnombre = new JTextField();
		LimitedTextField txtnombre = instanciaDiseñoyValida.new LimitedTextField(50);
		txtnombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();
				if (!(Character.isAlphabetic(car) || (car == KeyEvent.VK_SPACE) || car == KeyEvent.VK_DELETE)) {
			        evt.consume();
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		txtnombre.setBounds(138, 64, 131, 20);
		contentPane_1.add(txtnombre);
		
		JLabel lblNewLabel_2 = new JLabel("DNI");
		DiseñoyValida.modifyLabel(lblNewLabel_2);
		lblNewLabel_2.setBounds(380, 67, 42, 14);
		contentPane_1.add(lblNewLabel_2);
		
		
		try {
			formatter = new MaskFormatter("##.###.###U"); // La U nos permite picar letras pero en mayúscula.
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		txtdni = new JTextField();
		JFormattedTextField txtdni = new JFormattedTextField(formatter);
		txtdni.setBounds(476, 64, 86, 20);
		contentPane_1.add(txtdni);
		
		JLabel lblNewLabel_5 = new JLabel("Teléfono");
		DiseñoyValida.modifyLabel(lblNewLabel_5);
		lblNewLabel_5.setBounds(34, 244, 60, 14);
		contentPane_1.add(lblNewLabel_5);
		
		try {
			formattertelefono = new MaskFormatter("#########"); // La U nos permite picar letras pero en mayúscula.
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		txttelefono = new JTextField();
		JFormattedTextField txttelefono = new JFormattedTextField(formattertelefono);
		txttelefono.setBounds(138, 241, 86, 20);
		contentPane_1.add(txttelefono);
		
			
		JLabel lblNewLabel_3 = new JLabel("Apellidos");
		DiseñoyValida.modifyLabel(lblNewLabel_3);
		lblNewLabel_3.setBounds(34, 109, 60, 14);
		contentPane_1.add(lblNewLabel_3);
		
		
		txtapellidos = new JTextField();
		LimitedTextField txtapellidos = instanciaDiseñoyValida.new LimitedTextField(50);
		txtapellidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();
				if (!(Character.isAlphabetic(car) || (car == KeyEvent.VK_SPACE) || car == KeyEvent.VK_DELETE)) {
			        evt.consume();
				}
			}
		});
		txtapellidos.setBounds(138, 106, 217, 20);
		contentPane_1.add(txtapellidos);
		
		JLabel lblNewLabel_1 = new JLabel("Dirección");
		DiseñoyValida.modifyLabel(lblNewLabel_1);
		lblNewLabel_1.setBounds(34, 151, 67, 14);
		contentPane_1.add(lblNewLabel_1);
		
		txtdireccion = new JTextField();
		LimitedTextField txtdireccion = instanciaDiseñoyValida.new LimitedTextField(50);
		txtdireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();
				if (!(Character.isAlphabetic(car) || (car == KeyEvent.VK_SPACE) || car == KeyEvent.VK_DELETE)) {
			        evt.consume();
				}
			}
		});
		txtdireccion.setBounds(138, 148, 217, 20);
		contentPane_1.add(txtdireccion);
		
		JLabel lblNewLabel_4 = new JLabel("Provincia");
		DiseñoyValida.modifyLabel(lblNewLabel_4);
		lblNewLabel_4.setBounds(377, 151, 60, 14);
		contentPane_1.add(lblNewLabel_4);
		
		txtpoblacion = new JTextField();
		LimitedTextField txtpoblacion = instanciaDiseñoyValida.new LimitedTextField(50);
		txtpoblacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();
				if (!(Character.isAlphabetic(car) || (car == KeyEvent.VK_SPACE) || car == KeyEvent.VK_DELETE)) {
			        evt.consume();
				}
			}
		});
		txtpoblacion.setBounds(138, 194, 131, 20);
		contentPane_1.add(txtpoblacion);
		
		JLabel lblNewLabel_7 = new JLabel("Poblacion");
		DiseñoyValida.modifyLabel(lblNewLabel_7);
		lblNewLabel_7.setBounds(34, 197, 67, 14);
		contentPane_1.add(lblNewLabel_7);
		
		//txtprovincia = new JTextField();
		LimitedTextField txtprovincia = instanciaDiseñoyValida.new LimitedTextField(50);
		txtprovincia.setBounds(476, 148, 86, 20);
		contentPane_1.add(txtprovincia);
		
		JComboBox cbformapago = new JComboBox();
		cbformapago.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Tarjeta", "Bizum", "Transferencia"}));
		cbformapago.setBounds(476, 105, 117, 22);
		contentPane_1.add(cbformapago);
		
		JLabel lblNewLabel_8 = new JLabel("Forma de Pago");
		DiseñoyValida.modifyLabel(lblNewLabel_8);
		lblNewLabel_8.setBounds(378, 109, 88, 14);
		contentPane_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("CP");
		DiseñoyValida.modifyLabel(lblNewLabel_9);
		lblNewLabel_9.setBounds(283, 197, 28, 14);
		contentPane_1.add(lblNewLabel_9);
		
		
		try {
			formattercp = new MaskFormatter("#####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		txtCp = new JTextField();
		JFormattedTextField txtCp = new JFormattedTextField(formattercp);
		txtCp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();
		        if((car<'0' || car>'9')) evt.consume();
			}
		});
		txtCp.setBounds(321, 195, 50, 20);
		contentPane_1.add(txtCp);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(496, 256, 99, 45);
		btnSalir.setBackground(null);
		DiseñoyValida.modifyButton(btnSalir);
		btnSalir.setBorder(border);
		contentPane_1.add(btnSalir);
		
		
		try {
			formattertarjeta = new MaskFormatter("################");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		txttarjeta = new JTextField();
		JFormattedTextField txttarjeta = new JFormattedTextField(formattertarjeta);
		txttarjeta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();
		        if((car<'0' || car>'9')) evt.consume();
			}
		});
		txttarjeta.setBounds(477, 195, 116, 19);
		contentPane_1.add(txttarjeta);
		
		
		
		JButton btnNewButton_1 = new JButton("Insertar Cliente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(txtdni.getText());
				
				String cadenadni = txtdni.getText().replaceAll("[+!=+^.]", "");
				System.out.println(cadenadni);
				
				Date date = jdcfecha.getDate(); 
				//jdcfecha.setDateFormatString("yyyy/MM/dd","#####/##/##"," ");
				//jdcfecha.set
				long d = date.getTime(); 
				java.sql.Date fecha = new java.sql.Date(d);
				
				fechita = fecha;
				
				if (txtnombre.getText().length() == 0 || txtapellidos.getText().length() == 0  || txtdireccion.getText().length() == 0 || txttelefono.getText().length() == 0 || txtpoblacion.getText().length() == 0 || txtprovincia.getText().length() == 0 || txtCp.getText().length() == 0 || txtdni.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Rellene todos los campos por favor");
					if (txtCp.getText().length() != 5) {
		        		JOptionPane.showMessageDialog(null, "Debe introducir correctamente el CP");
		        	}
				}else {
				
				forma = cbformapago.getSelectedItem().toString();
				
				usuario nuevousu = new usuario(fechita, cadenadni,txtnombre.getText(), txtapellidos.getText(), txtdireccion.getText(), txtCp.getText(), txttelefono.getText(), txtpoblacion.getText(),txtprovincia.getText(),forma,txttarjeta.getText());
				
				ControllerUsuario usu = new ControllerUsuario(); 
				
				usu.registrar(nuevousu); 
				
				//dispose();
				
				
				ControllerLogin logo = new ControllerLogin();
				int total= logo.IdInsertado(cadenadni);
				
				
				char[] contr = {'h','o','l','a'};
			
				System.out.println(total);
				
	
				login nuevolog = new login(total,cadenadni,contr);
				logo.registrar(nuevolog);
				
				
			
				}
			}
		});
		btnNewButton_1.setBounds(303, 273, 141, 30);
		btnNewButton_1.setBackground(null);
		DiseñoyValida.modifyButton(btnNewButton_1);
		btnNewButton_1.setBorder(border);
		
		contentPane_1.add(btnNewButton_1);
		
	
		JLabel lblNewLabel_10 = new JLabel("Tarjeta");
		DiseñoyValida.modifyLabel(lblNewLabel_10);
		lblNewLabel_10.setBounds(380, 198, 45, 13);
		contentPane_1.add(lblNewLabel_10);
		
	
	}
}
