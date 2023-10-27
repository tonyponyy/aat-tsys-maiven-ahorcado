package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class PalabraSecreta extends JPanel {
	
	private JLabel lblNewLabel;
	
	public PalabraSecreta(String barras) {
		
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(50, 130, 350, 40);
		add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel(barras);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 0, 350, 40);
		panel.add(lblNewLabel);
		
	}
	
	
	
	public void modificarLabel(String palabra) {
		lblNewLabel.setText(palabra);
	}

}
