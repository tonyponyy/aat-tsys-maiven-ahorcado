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


	private String palabraAleatoria;
	private String barras = "";
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	private JList<String> list = new JList<>(listModel);


	public Vista_ahorcado() {
		setTitle("Ahorcado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

        contentPane.add(imagenPanel);


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
	
	public void iniciarPartida() {
		sincro.getTeclado().activar();
		sincro.getImagen().Revivir();
		palabraRandom(listModel.size(), list);
		//sincro.getPalabraSecreta().Revivir();
	}
	

}
