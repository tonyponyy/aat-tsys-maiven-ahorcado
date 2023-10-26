package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Imagen extends JPanel {
    private Image imagen;
    int estado = 1;
    JLabel lblNewLabel = new JLabel("");

    public  Imagen() {
    	setBounds(400, 0, 400, 600);
    	Paint();
        lblNewLabel.setBounds(0, 0, 400, 600);
        add(lblNewLabel);
    }
    
    public void Paint() {
    	String ruta_imagen = "img/ahorcado"+estado+".png";
    	lblNewLabel.setIcon(new ImageIcon(ruta_imagen));
    }
    
    protected void QuitarVida() {
    	if (estado < 10) {
    		estado++;
    		Paint();
    	}
    }
    
    protected void Revivir() {
    	estado = 1;
    	Paint();
    }
    
    

   
    
}
