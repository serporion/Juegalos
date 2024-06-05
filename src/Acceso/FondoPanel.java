package Acceso;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoPanel extends JPanel{

	
		private Image imagen;
		
		public FondoPanel() {
		
				this.setSize(800,800);
				//this.set
				//this.setVisible(true);
				
		}
		
		
		@Override
		
		public void paint (Graphics g) {
			imagen = new ImageIcon(getClass().getResource("/imagenes/bg_1_1.png")).getImage();
			
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			
			//getWidth(100), getHeight(100)
			
			setOpaque(true);
			
			super.paintComponents(g);
		}
		
		
		
}

