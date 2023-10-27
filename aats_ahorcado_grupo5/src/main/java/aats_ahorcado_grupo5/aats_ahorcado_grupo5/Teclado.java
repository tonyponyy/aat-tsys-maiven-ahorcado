package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Teclado extends JPanel{
	
	private final int PANEL_WIDTH = 390;
	private final int PANEL_HEIGHT = 190;
	private final int BUTTON_WIDTH = 50;
	private final int BUTTON_HEIGHT = 25;
	
	private JButton[] alfabeto = new JButton[26];
	private JLabel palabraSecretaLabel;
	private boolean tecladoActivado = true;
	private Sincronizador sincro;
	
	public Teclado() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
		setLocation(05, 370);
		setBorder(BorderFactory.createLineBorder(Color.black));

		
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
	public void setSincro(Sincronizador sincro) {
		this.sincro = sincro;
	}
	
	//Funcion que crea el action listener y se lo asigna a todos los botones
	private void setListeners() {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((JButton)e.getSource()).setEnabled(false);
				sincro.getPalabraSecreta().comprobarLetra(((JButton)e.getSource()).getText());
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
	
	//Función que activa todas las letras del teclado
	public void activar() {
		for(int i = 0; i < alfabeto.length; i++) {
			alfabeto[i].setEnabled(true);
		}
	}
	
	//Función que desactiva todas las letras del teclado
	public void desactivar() {
		for(int i = 0; i < alfabeto.length; i++) {
			alfabeto[i].setEnabled(true);
		}
	}
}
