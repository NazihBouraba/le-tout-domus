

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainMVC implements Runnable {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		// TODO Auto-generated method stub
		
		// créer une masion
		CMaisonUser maison = new CMaisonUser();
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("Interface Domus");
		//créer une vue avec le model de CMaison puis ajouter la vue dans la frames
		Vue maVue = new Vue(maison);
		jf.setContentPane(maVue);
		maison.addObserver(maVue);
		// ajuster la taille de JFrame
		jf.setSize(maVue.xDim, maVue.yDim);
		jf.setBackground(Color.red);
		// jf.pack();
		// mette le JFrame visible
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		createAndShowGUI();
	}
}
