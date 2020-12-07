

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControljbSimulPeriode  implements ActionListener{
	private Vue laVue;
	
	public ControljbSimulPeriode(Vue vue) {
		laVue = vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		// mettre le panel jp2South3 visible
		laVue.jp2South3.setVisible(true);
		
		laVue.jbSimulPeriode.setFocusable(true);
		
		// rend le label lblDateDebut visible
		laVue.lblDateDebut.setVisible(true);
		
		//ajouter le bouton jbEvenEntre2Dates dans le panel jpSimul
		laVue.jpSimul.add(laVue.jbEvenEntre2Dates);
		
		// rend le bouton jbLancerEvenement invisible
		laVue.jbLancerEvenement.setVisible(false);
		
		// rend le bouton jbEvenEntre2Dates visible
		laVue.jbEvenEntre2Dates.setVisible(true);
	
		
	}

}
