package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PalabraSecreta extends JPanel {

	private JLabel lblNewLabel;
	private JPanel panel_1;
	private Sincronizador sincro;
	private String palabraOculta = "";
	private String palabraAleatoria;
	private int pistas =5;
	private int intentos;

	private final int INTENTOSDEFECTO = 10;

	public PalabraSecreta(String palabraSecreta, int vidas) {

		this.palabraAleatoria = palabraSecreta;
		this.intentos = this.INTENTOSDEFECTO;

		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(15, 130, 350, 40);
		add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel(this.palabraOculta);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 0, 350, 40);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBounds(15, 11, 350, 40);
		add(panel_1);
		panel_1.setLayout(null);
		
		crearVidas();
		
	}

	public void setSincro(Sincronizador sincro) {
		this.sincro = sincro;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	

	public int getIntentos() {
		return intentos;
	}

	private void crearVidas() {
		
		for (Component component : getComponents()) {
	        if (component instanceof JButton) {
	            remove(component);
	        }
	    }
		String ruta_imagen = "img/bombilla.png";
		for (int i = 0; i < this.pistas; i++) {
			JButton btnNewButton = new JButton("");
			btnNewButton.setEnabled(false);
			btnNewButton.setBackground(new Color(255, 0, 0));
			btnNewButton.setIcon(new ImageIcon(ruta_imagen));
			btnNewButton.setBounds(15 +i*(60), 69, 50, 50);
			add(btnNewButton);
		}
		 repaint();

	}

	public void setPalabraAleatoria(String palabraAleatoria) {
		this.palabraAleatoria = palabraAleatoria;
		this.ocultarPalabra();
	}

	private void ocultarPalabra() {
		this.palabraOculta = "";
		for (int i = 0; i < palabraAleatoria.length(); i++) {
			this.palabraOculta += " _";
		}
		this.modificarLabel(this.palabraOculta);
	}

	private void modificarLabel(String palabra) {
		lblNewLabel.setText(palabra);
	}

	public void comprobarLetra(String letra) {

		int comprobacion = this.palabraAleatoria.indexOf(letra);

		if (comprobacion == -1) {

			sincro.getImagen().QuitarVida();
			this.intentos -= 1;


		} else {
			sincro.getVistaAhorcado().puntos +=25;
			sincro.getVistaAhorcado().actualizarPuntos();
			buscarPosicion(letra, this.palabraAleatoria);
		}

		compararPalabras();

		if (this.intentos == 0) {

			sincro.getVistaAhorcado().finJuego(false);
			modificarLabel(this.palabraAleatoria);

		}

	}

	private void buscarPosicion(String letra, String palabraAleatoria) {
		String palabra = palabraAleatoria;
		int pos = 0;
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

	public void restarPista() {
		intentos--;
		pistas--;
		sincro.getImagen().QuitarVida();
		crearVidas();
		if (intentos < 1) {
			sincro.getVistaAhorcado().finJuego(false);
			modificarLabel(this.palabraAleatoria);
		}

	}

	public void mostrarLetra() {
		int pos = this.palabraOculta.replaceAll(" ", "").indexOf("_");
		String letra = String.valueOf(this.palabraAleatoria.charAt(pos));
		comprobarLetra(letra);
		compararPalabras();
	}

	public void resolver() {
		modificarLabel(this.palabraAleatoria);
		sincro.getVistaAhorcado().finJuego(false);
	}

	public void restablecerPistas() {
		pistas = 5;
		crearVidas();
	}
	
}
