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
	private Sincronizador sincro;
	private Teclado tcl;

<<<<<<< HEAD
	private String palabraAleatoria;
	private String barras = "";
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	private JList<String> list = new JList<>(listModel);

=======
>>>>>>> dbaf7cc33dc341015636997e2889d8f36de102dc
	public Vista_ahorcado() {
		setTitle("Ahorcado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(imagenPanel);
		setContentPane(contentPane);
		contentPane.setLayout(null);

        contentPane.add(imagenPanel);

<<<<<<< HEAD
		// Creaci�n del ListBox
		
		listModel.addElement("Murcielago");
		listModel.addElement("Elefante");
		listModel.addElement("Computadora");
		listModel.addElement("Jirafa");
		listModel.addElement("Guitarra");
		listModel.addElement("Mariposa");
		listModel.addElement("Tractor");
		listModel.addElement("Helic�ptero");
		listModel.addElement("Cocodrilo");
		listModel.addElement("Esqu�");
=======
		// Creacion del ListBox

		DefaultListModel<String> listModel = new DefaultListModel<>();
		listModel.addElement("MURCIELAGO");
		listModel.addElement("ELEFANTE");
		listModel.addElement("COMPUTADORA");
		listModel.addElement("JIRAFA");
		listModel.addElement("GUITARRA");
		listModel.addElement("MARIPOSA");
		listModel.addElement("TRACTOR");
		listModel.addElement("HELICOPTERO");
		listModel.addElement("COCODRILO");
		listModel.addElement("ESQUI");
>>>>>>> dbaf7cc33dc341015636997e2889d8f36de102dc

		
		list.setBounds(371, 54, 1, 1);
		getContentPane().add(list);

		palabraRandom(listModel.size(), list);

		PalabraSecreta palabraSecreta = new PalabraSecreta(list.getSelectedValue());
		palabraSecreta.setSize(380, 180);
		palabraSecreta.setLocation(10, 180);
		contentPane.add(palabraSecreta);
		
		tcl = new Teclado();
		contentPane.add(tcl);
		
		Menu mnu = new Menu();
		contentPane.add(mnu);
		
		sincro = new Sincronizador(tcl, palabraSecreta, imagenPanel, mnu, this);
		
		setVisible(true);

	}

	private void palabraRandom(int num, JList<String> list) {
		int numRandom = new Random().nextInt(num);
		list.setSelectedIndex(numRandom);
	}
	
	private void iniciarPartida() {
		sincro.getTcl().activarTeclado();
		sincro.getImg().Revivir();
		palabraRandom(listModel.size(), list);
		sincro.getPs().Revivir();
	}
	

}
