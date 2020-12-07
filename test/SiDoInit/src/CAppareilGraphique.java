

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class CAppareilGraphique extends JPanel {
	private static final long serialVersionUID = 1L;
	
	CAppareil appareil;
	JLabel lblAppareil;
	JPanel panel;
	
	public CAppareilGraphique(CAppareil appareil) {
		this.appareil = appareil;
		this.panel = new JPanel();
	}

	public void paintComponent(Graphics g) {
		int width =  getWidth();
		int height = getHeight();	
		g.setColor(appareil.getColorAppareil());
		g.fillRect(0, 0, width, height);
		int fontSize = 15;
		g.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
		g.setColor(Color.DARK_GRAY);
		g.drawString(appareil.getNomAppareil(), 10, 20);
	}	
}