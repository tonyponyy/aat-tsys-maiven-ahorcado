package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
	
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	private JList<String> list = new JList<>(listModel);
	private int vida = 10;


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

		setPalabraAleatoria();

		PalabraSecreta palabraSecreta = new PalabraSecreta(this.palabraAleatoria, 5);
		palabraSecreta.setSize(380, 180);
		palabraSecreta.setLocation(10, 180);
		contentPane.add(palabraSecreta);
		
		tcl = new Teclado();
		contentPane.add(tcl);

		Menu mnu = new Menu();
		contentPane.add(mnu);
		
		sincro = new Sincronizador(tcl, palabraSecreta, imagenPanel, mnu, this);
		
		setVisible(true);

		sincro.getMenu().seleccionarDificultad();
	}

	private void palabraRandom(int num, JList<String> list) {
		int numRandom = new Random().nextInt(num);
		list.setSelectedIndex(numRandom);
	}
	
	public void iniciarPartida() {
		sincro.getTeclado().activar();
		setPalabraAleatoria();
		sincro.getImagen().DefinirVida((10-vida)+1);
		sincro.getPalabraSecreta().setPalabraAleatoria(this.palabraAleatoria);
		sincro.getPalabraSecreta().setVidas(vida);
		sincro.getMenu().enablePistaButton();

	}

	public void setPalabraAleatoria() {
		palabraRandom(listModel.size(), list);
		this.palabraAleatoria = list.getSelectedValue();
	}
	
	
	
	public void definirDificultad(int n_vidas) {
		vida = n_vidas;
	}
	
	public void finJuego(boolean ganador) {
		sincro.getTeclado().desactivar();
		if (ganador) {
			JOptionPane.showMessageDialog(null, "Has ganado la partida");
		}else {
			JOptionPane.showMessageDialog(null, "Has perdido, vuelve a intentarlo");
		}
	}

	public int getVida() {
		return vida;
	}

	

}
