package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Vista_ahorcado extends JFrame {

	private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 600;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public Vista_ahorcado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        Teclado tcl = new Teclado();
        contentPane.add(tcl);

        setVisible(true);
        //180 menu
        //180 palabra secreta
        //360 teclado
	}

}
