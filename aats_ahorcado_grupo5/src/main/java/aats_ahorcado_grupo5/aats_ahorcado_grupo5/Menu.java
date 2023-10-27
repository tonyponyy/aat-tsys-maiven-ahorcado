package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

import java.awt.Color;

import javax.swing.JPanel;

public class Menu extends JPanel{
	
	private final int PANEL_WIDTH = 400;
	private final int PANEL_HEIGHT = 180;
	private final int BUTTON_WIDTH = 50;
	private final int BUTTON_HEIGHT = 25;
	private Sincronizador sincro;
	
	public Menu() {
		setLayout(null);
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
		setLocation(10, 360);
		setBackground(Color.black);
		
	}
	
	public void setSincro(Sincronizador sincro) {
		this.sincro = sincro;
	}
}
