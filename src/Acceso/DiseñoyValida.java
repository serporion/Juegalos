package Acceso;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.text.AttributeSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;




public class DiseñoyValida {

	public static void modifyButton(JButton button) {
      
		button.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setOpaque(false);
        
        //ImageIcon ima = new ImageIcon();
        // Image ima = new ImageIcon("/imagenes/sara-logo.png").getImage();
        //image = iman.getClass().getResource("/imagenes/sara-logo.png");
        // button.setIcon(new ImageIcon(ima.getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        //button.setIcon(new ImageIcon(ima.getClass().getResource("/imagenes/sara-logo.png")));
        // button.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
        // button.setIcon(new ImageIcon(getIconImage().getScaledInstance(25, 40, is)));
              
       
        //Image ima = (new ImageIcon(button.getClass().getResource("/imagenes/sara-logo.png")).getImage());
        //button.setIcon(new ImageIcon(ima.getScaledInstance(25, 40, Image.SCALE_SMOOTH)));
        
        
        //System.out.println(button.getText());
    
        
      
    }

	public static void modifyLabel(JLabel label) {
	      
		label.setForeground(new Color(0, 255, 255));

        
	}
	
	public static void validatexto(JTextField txt) {
	
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();
				if (!(Character.isAlphabetic(car) || (car == KeyEvent.VK_SPACE) || car == KeyEvent.VK_DELETE || car==KeyEvent.VK_A)) {
			        evt.consume();
				}
			}
		});
	
	}
	
	
	public static void validanumero(JTextField txt) {
		
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();
		        if((car<'0' || car>'9') && (car<',' || car>'.')) evt.consume();
			}
		});
	
	}
	
	public class LimitedTextField extends JTextField {
		
	    private int maxLength;

	    public LimitedTextField(int maxLength) {
	        super();
	        this.maxLength = maxLength;
	        setDocument(new PlainDocument() {
	        	@Override
	            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	                if ((getLength() + str.length()) <= maxLength) {
	                    super.insertString(offset, str, attr);
	                }
	            }
	        });
	    }

	    public int getMaxLength() {
	        return maxLength;
	    }

	    public void setMaxLength(int maxLength) {
	        this.maxLength = maxLength;
	    }
	}
	
	
	
public class LimitedTextFieldContrasena extends JPasswordField {
		
	    private int maxLength;

	    public LimitedTextFieldContrasena(int maxLength) {
	        super();
	        this.maxLength = maxLength;
	        setDocument(new PlainDocument() {
	        	@Override
	            public void insertString(int onset, String str, AttributeSet attr) throws BadLocationException {
	                if ((getLength() + str.length()) <= maxLength) {
	                    super.insertString(onset, str, attr);
	                }
	            }
	        });
	    }

	    public int getMaxLength() {
	        return maxLength;
	    }

	    public void setMaxLength(int maxLength) {
	        this.maxLength = maxLength;
	    }
	}




	public static void ColorTabla (JTable jtabla) {
		
		Color miColor = new Color(100, 150, 200);
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();	
		render.setBackground(miColor);
		jtabla.setDefaultRenderer(Object.class, render);
		//jtabla.setDefaultRenderer(Boolean.class, render);
		
		Color columnaColor = new Color (0, 200, 200);
		Font fontEncabezado = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14);
		
		
		JTableHeader encabezadoTabla = jtabla.getTableHeader();
        //DefaultTableCellRenderer renderEncabezado = new DefaultTableCellRenderer(); 
        //renderEncabezado.setBackground(columnaColor); //APLICABA COLOR PERO NO FUENTE
        
        TableCellRenderer headerRenderer = encabezadoTabla.getDefaultRenderer();
        ((DefaultTableCellRenderer)headerRenderer).setHorizontalAlignment(JLabel.CENTER);
        ((DefaultTableCellRenderer)headerRenderer).setFont(fontEncabezado);
        encabezadoTabla.setBackground(columnaColor);
        encabezadoTabla.setFont(fontEncabezado);
        encabezadoTabla.setForeground(Color.blue);
        
        Color azul= new Color(0,200,200);
        jtabla.setBackground(Color.lightGray);
        jtabla.setSelectionBackground(azul);
        
        
	}

}

