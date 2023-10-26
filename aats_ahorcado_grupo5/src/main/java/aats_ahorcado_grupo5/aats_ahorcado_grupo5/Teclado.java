package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Teclado extends JPanel{
	
	private final int PANEL_WIDTH = 400;
	private final int PANEL_HEIGHT = 240;
	private final int BUTTON_WIDTH = 50;
	private final int BUTTON_HEIGHT = 25;
	
	private JButton[] alfabeto = new JButton[26];
	private JLabel palabraSecretaLabel;
	private boolean tecladoActivado = true;
	
	public Teclado() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
		setLocation(10, 360);

		
		for(int i = 0; i < alfabeto.length; i++) {
			/*Crear un nuevo boton en cada posicion del array de botones
			 *asignandole una letra a cada uno haciendo uso del valor numerico ascii*/
			alfabeto[i] = new JButton(String.valueOf((char)(65+i)));
			alfabeto[i].setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
			
			add(alfabeto[i]);
		}
		setListeners();
	}
	
	
	//Función para asignar a quien devolvera la tecla pulsada
	public void setTargetLabel(JLabel palabraSecretaLabel) {
		this.palabraSecretaLabel = palabraSecretaLabel;
	}
	
	//Funcion que crea el action listener y se lo asigna a todos los botones
	private void setListeners() {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(((JButton)e.getSource()).getText());
				((JButton)e.getSource()).setEnabled(false);
			}
		};
		
		for(int i = 0; i < alfabeto.length; i++) {
			alfabeto[i].addActionListener(al);
		}
	}
	
	//Función que se le pasa una letra y desactiva el botón que tenga esa letra
	public void desactivarLetra(String letra) {
		for(int i = 0; i < alfabeto.length; i++) {
			if(alfabeto[i].getText().equals(letra)) {
				alfabeto[i].setEnabled(false);
			}
		}
	}
	
	public void switchTeclado() {
		tecladoActivado = !tecladoActivado;
		for(int i = 0; i < alfabeto.length; i++) {
			alfabeto[i].setEnabled(tecladoActivado);
		}
	}
}
