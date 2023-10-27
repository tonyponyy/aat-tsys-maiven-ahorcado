package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class PalabraSecreta extends JPanel {
	
	private JLabel lblNewLabel;
	private Sincronizador sincro;
	private String palabraOculta = "";
	private String palabraAleatoria;
	
	public PalabraSecreta(String palabraSecreta) {
		
		this.palabraAleatoria = palabraSecreta;
		
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(15, 130, 350, 40);
		add(panel);
		panel.setLayout(null);
		
		ocultarPalabra();
		System.out.println(this.palabraAleatoria);
		
		lblNewLabel = new JLabel(this.palabraOculta);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 0, 350, 40);
		panel.add(lblNewLabel);
		
		comprobarLetra("A");
		comprobarLetra("E");
		comprobarLetra("I");
		comprobarLetra("O");
		comprobarLetra("U");
		
	}
	
	public void setSincro(Sincronizador sincro) {
		this.sincro = sincro;
	}
	
	private void ocultarPalabra() {
		for (int i = 0; i < palabraAleatoria.length(); i++) {
			palabraOculta += " _";
		}
	}
	
	private void modificarLabel(String palabra) {
		lblNewLabel.setText(palabra);
	}
	
	public void comprobarLetra(String letra) {
		String palabra = this.palabraAleatoria;
		int pos = palabra.indexOf(letra);
		boolean condition = true;
		do {
			pos = palabra.indexOf(letra);
			
			if (pos == -1) {
				condition = !condition;
			} else {
				
				palabra = modificarString(pos, letra, palabra);
			}
		} while (condition);

	}

	private String modificarString(int pos, String letra, String palabra) {
		char letraEncontrada = '_';
		char[] caracteres = palabra.toCharArray();
		
		caracteres[pos] = letraEncontrada;
		
		// Reemplaza el caracter en la posicion 'pos' de 'palabraOculta' con 'letra'. 
		// eliminando los espacios en blanco en la cadena.
		String palabraOcultaModificadas = palabraOculta.replaceAll(" ", "").substring(0, pos) + letra + palabraOculta.replaceAll(" ", "").substring(pos + 1);

		palabra = new String(caracteres);
		
		palabraOculta = palabraOcultaModificadas.replaceAll("", " ");
		
		modificarLabel(palabraOculta);
		
		return palabra;
	}

}
