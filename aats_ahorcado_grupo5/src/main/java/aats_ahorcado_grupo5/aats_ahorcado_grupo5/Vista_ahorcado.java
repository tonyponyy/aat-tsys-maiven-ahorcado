package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Vista_ahorcado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public Vista_ahorcado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		setVisible(true);
		//180 menu
		//180 palabra secreta
		//360 teclado
	}

}
