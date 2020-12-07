

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControljbSimulDate  implements ActionListener{
	private Vue laVue;
	
	public ControljbSimulDate(Vue vue) {
		laVue = vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		// mettre le panel jp2South3 invisible
		laVue.jp2South3.setVisible(false);
		
		laVue.jbSimulDate.setFocusable(true);
		
		//ajouter le bouton jbLancerEvenement dans le panel jpSimul
		laVue.jpSimul.add(laVue.jbLancerEvenement);
		
		// ajuster la taille de bouton		
		laVue.jbLancerEvenement.setPreferredSize(new Dimension(200, 100));
		
		// rend le label lblDateDebut invisible
		laVue.lblDateDebut.setVisible(false);
		
		// rend le bouton jbEvenEntre2Dates invisible
		laVue.jbEvenEntre2Dates.setVisible(false);
		
		// rend le bouton jbLancerEvenement visible
		laVue.jbLancerEvenement.setVisible(true);
	}
}
