package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PalabraSecreta extends JPanel {

	private JLabel lblNewLabel;
	private Sincronizador sincro;
	private String palabraOculta = "";
	private String palabraAleatoria;
	private int vidas;
	private int intentos;
	private int posicionXVidas = 15;

	private final int INTENTOSDEFECTO = 10;

	public PalabraSecreta(String palabraSecreta, int vidas) {

		this.palabraAleatoria = palabraSecreta;
		this.vidas = vidas;
		this.intentos = this.INTENTOSDEFECTO;

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

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	private void crearVidas() {
		String ruta_imagen = "img/bombilla.png";
		for (int i = 0; i < this.vidas; i++) {
			JButton btnNewButton = new JButton("");
			btnNewButton.setEnabled(false);
			btnNewButton.setBackground(new Color(255, 0, 0));
			btnNewButton.setIcon(new ImageIcon(ruta_imagen));
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
		this.palabraOculta = "";
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

			sincro.getImagen().QuitarVida();
			restarVida();
			this.intentos -= 1;

		} else {
			buscarPosicion(letra, palabra);
		}

		compararPalabras();

		if (this.intentos == 0) {

			sincro.getVistaAhorcado().finJuego(false);
			modificarLabel(this.palabraAleatoria);

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

	private void compararPalabras() {
		if (this.palabraAleatoria.equals(this.palabraOculta.replaceAll(" ", ""))) {
			sincro.getVistaAhorcado().finJuego(true);
		}
	}

	private void restarVida() {
		vidas--;
		if (vidas <= 1) {
			sincro.getVistaAhorcado().finJuego(false);
			modificarLabel(this.palabraAleatoria);
		}
	}

	public void mostrarLetra() {
		int pos = this.palabraOculta.replaceAll(" ", "").indexOf("_");
		String letra = String.valueOf(this.palabraAleatoria.charAt(pos));
		modificarString(pos, letra, this.palabraOculta);
	}

	public void resolver() {
		modificarLabel(this.palabraAleatoria);
		sincro.getVistaAhorcado().finJuego(false);
	}

	public int getVidas() {
		return vidas;
	}
	
}
