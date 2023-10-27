package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JPanel{
	
	private final int PANEL_WIDTH = 400;
	private final int PANEL_HEIGHT = 180;
	private final int BUTTON_WIDTH = 380;
	private final int BUTTON_HEIGHT = 25;

	private JButton iniciarPartidaBtn;
	private JButton resolverBtn;
	private JButton pistaBtn;
	private Sincronizador sincro;
	ActionListener iniciarPartidaListener;
	ActionListener resolverListener;
	ActionListener pistaListener;
	
	public Menu() {
		setLayout(null);
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
		setLocation(1, 10);
		//setBackground(Color.black);
		
		iniciarPartidaBtn = new JButton("Iniciar Partida");
		iniciarPartidaBtn.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		iniciarPartidaBtn.setLocation(5, 5);
		add(iniciarPartidaBtn);
		
		resolverBtn = new JButton("Resolver");
		resolverBtn.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		resolverBtn.setLocation(5, 31);
		add(resolverBtn);
		
		pistaBtn = new JButton("Pista");
		pistaBtn.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		pistaBtn.setLocation(5, 57);
		add(pistaBtn);
	}
	
	public void setSincro(Sincronizador sincro) {
		this.sincro = sincro;
		setListeners();
	}
	
	//Crear y asignar los action listeners a los 3 botones
	private void setListeners() {
		iniciarPartidaListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sincro.getVistaAhorcado().iniciarPartida();
			}
			
		};
		
		resolverListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//sincro.getPalabraSecreta().resolver();
			}
			
		};
		
		pistaListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  int input = JOptionPane.showConfirmDialog(null, "Perderas una vida si aceptas la pista. ¿Aceptas?", "Confirmacion pista",
						  												JOptionPane.YES_NO_OPTION);
				  if(input == 0) {
					  //sincro.getPalabraSecreta().mostrarLetra();
				  }
			}
			
		};

		iniciarPartidaBtn.addActionListener(iniciarPartidaListener);
		resolverBtn.addActionListener(resolverListener);
		pistaBtn.addActionListener(pistaListener);
	}
}
