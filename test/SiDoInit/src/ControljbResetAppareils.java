

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControljbResetAppareils implements ActionListener {

	private Vue laVue;
	private CMaison maMaison;

	public ControljbResetAppareils(Vue vue, CMaison maMaison2) {
		laVue = vue;
		maMaison = maMaison2;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.print("\n");
		System.out.println("Fermer et Eteindre tous les appareils");
		
		maMaison.resetAffichageAppareils(maMaison.ma_liste_appareils);
		
		// mettre à jour le composant modifié
		laVue.jp5Center.revalidate();
		laVue.jp5Center.repaint();
	}
}
