

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlInterface implements ActionListener {
	private Vue laVue;
	private CMaison maMaison;
	private int index; 
	
	public ControlInterface(Vue vue, CMaison maMaison1, int indexInterface) {
		laVue = vue;
		maMaison = maMaison1;
		index = indexInterface;
	}

	public void actionPerformed(ActionEvent e) {
		
		CInterface monInterface;
		if (index < maMaison.ma_liste_interfaces.size()) {
			//recuperer l'interface � une indice de ma liste d'interfaces
			monInterface = maMaison.ma_liste_interfaces.get(index);
							
			maMaison.monHabitat.execInterface(monInterface.getNomInterface());
			
			// affichage des appareils en format de texte 
		    //maMaison.monHabitat.afficherAppareils();
			
			// affichage Graphique des appareils apr�s l'ex�cution du sc�nario associ� 
			laVue.jp5Center.revalidate();
			laVue.jp5Center.repaint();
							
		}
	}
}
