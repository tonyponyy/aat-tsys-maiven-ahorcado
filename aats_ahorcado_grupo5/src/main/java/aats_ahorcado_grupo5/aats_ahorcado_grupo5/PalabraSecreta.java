package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PalabraSecreta extends JPanel {

	private JLabel lblNewLabel;
	private Sincronizador sincro;
	private String palabraOculta = "";
	private String palabraAleatoria;
	private int vidas;
	private int posicionXVidas = 15;

	public PalabraSecreta(String palabraSecreta, int vidas) {

		this.palabraAleatoria = palabraSecreta;
		this.vidas = vidas;

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

		crearVidas();

	}

	public void setSincro(Sincronizador sincro) {
		this.sincro = sincro;
	}
	
	public void setVidas(int vidas) {
		this.vidas = vidas;
		this.crearVidas();
	}

	private void crearVidas() {
		for (int i = 0; i < this.vidas; i++) {
			JButton btnNewButton = new JButton("");
			btnNewButton.setEnabled(false);
			btnNewButton.setBackground(new Color(255, 0, 0));
			btnNewButton.setBounds(this.posicionXVidas, 69, 50, 50);
			add(btnNewButton);

			this.posicionXVidas += 60;
		}
	}

	public void setPalabraAleatoria(String palabraAleatoria) {
		this.palabraAleatoria = palabraAleatoria;
		this.ocultarPalabra();
		this.modificarLabel(this.palabraOculta);
	}

	private void ocultarPalabra() {
		for (int i = 0; i < palabraAleatoria.length(); i++) {
			this.palabraOculta += " _";
		}
	}

	private void modificarLabel(String palabra) {
		lblNewLabel.setText(palabra);
	}

	public void comprobarLetra(String letra) {
		String palabra = this.palabraAleatoria;
		int comprobacion = palabra.indexOf(letra);

		if (comprobacion == -1) {

		} else {
			buscarPosicion(letra, palabra);
		}
	}

	private void buscarPosicion(String letra, String palabra) {
		int pos = palabra.indexOf(letra);
		boolean comprobacion = true;

		do {
			pos = palabra.indexOf(letra);

			if (pos == -1) {
				comprobacion = !comprobacion;
			} else {

				palabra = modificarString(pos, letra, palabra);
			}
		} while (comprobacion);
	}

	private String modificarString(int pos, String letra, String palabra) {
		char letraEncontrada = '_';
		char[] caracteres = palabra.toCharArray();

		caracteres[pos] = letraEncontrada;
		palabra = new String(caracteres);

		// Reemplaza el caracter en la posicion 'pos' de 'palabraOculta' con 'letra'.
		// eliminando los espacios en blanco en la cadena.
		String palabraOcultaModificadas = palabraOculta.replaceAll(" ", "").substring(0, pos) + letra
				+ palabraOculta.replaceAll(" ", "").substring(pos + 1);

		palabraOculta = palabraOcultaModificadas.replaceAll("", " ");

		modificarLabel(palabraOculta);

		return palabra;
	}
}
