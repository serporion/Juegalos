package Acceso;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;


		public class BordeRedondo2 implements Border {

		    private int radio;  

		    public BordeRedondo2(int radius) {
		        this.radio = radius;
		    }  

		    public Insets getBorderInsets(Component c) {
		    	c.setBackground(new Color(0, 255, 255));
		    	
		        return new Insets(this.radio+1, this.radio+1, this.radio+2, this.radio);
		        
		    }  

		    public boolean isBorderOpaque() {
		    	
		        return true;
		    }  

		    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		    	
		        g.drawRoundRect(x, y, width-1, height-1, radio, radio);
		        
		    }

		  }
		
		
