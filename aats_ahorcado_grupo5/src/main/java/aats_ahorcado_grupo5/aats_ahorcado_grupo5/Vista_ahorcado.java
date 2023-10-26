package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;

public class Vista_ahorcado extends JFrame {

	private final int FRAME_WIDTH = 800;
	private final int FRAME_HEIGHT = 600;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Imagen imagenPanel = new Imagen();
	

	private String palabraAleatoria;
	private String barras = "";


	public Vista_ahorcado() {
		setTitle("Ahorcado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        contentPane.add(imagenPanel);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		setVisible(true);

		// Creación del ListBox
		DefaultListModel<String> listModel = new DefaultListModel<>();
		listModel.addElement("Murcielago");
		listModel.addElement("Elefante");
		listModel.addElement("Computadora");
		listModel.addElement("Jirafa");
		listModel.addElement("Guitarra");
		listModel.addElement("Mariposa");
		listModel.addElement("Tractor");
		listModel.addElement("Helicóptero");
		listModel.addElement("Cocodrilo");
		listModel.addElement("Esquí");

		JList<String> list = new JList<>(listModel);
		list.setBounds(371, 54, 1, 1);
		add(list);

		palabraRandom(listModel.size(), list);

		PalabraSecreta palabraSecreta = new PalabraSecreta(barras);
		palabraSecreta.setSize(450, 180);
		palabraSecreta.setLocation(10, 180);
		contentPane.add(palabraSecreta);


	}

	private void palabraRandom(int num, JList<String> list) {
		int numRandom = new Random().nextInt(num);
		list.setSelectedIndex(numRandom);
		palabraAleatoria = list.getSelectedValue();

		for (int i = 0; i < palabraAleatoria.length(); i++) {
			barras += " _ ";
		}
	}

	private void comprobarLetra(String letra, PalabraSecreta palabraSecreta) {
		String palabra = palabraAleatoria;
		int pos = palabra.indexOf(letra);
		boolean condition = true;

		while (!condition) {

			pos = palabra.indexOf(letra);
			if (pos == -1) {
				condition = !condition;
			} else {
				modificarString(pos, letra, palabra);
			}
		}

	}

	private String modificarString(int pos, String letra, String palabra) {
		char[] caracteres = palabra.toCharArray();

		caracteres[pos] = letra.toCharArray()[0];

		palabra = new String(caracteres);

		return palabra;
	}
	

}
