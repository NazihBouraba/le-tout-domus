

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControljbjbLancerEvenement implements ActionListener {
	private Vue laVue;
	private CMaison maMaison;

	public ControljbjbLancerEvenement(Vue vue, CMaison M) {
		laVue = vue;
		maMaison = M;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		CDate date;
		
		date = laVue.transferAMJHMToCDate(laVue.textAnneeField,
				laVue.textMoisField, laVue.textJourField, laVue.textHeureField,
				laVue.textMinuteField);

		maMaison.monHabitat.date_courante = date;
		
		// execution de scénarios programmés (s'il existe)
		maMaison.monHabitat.execProgrammationADateCourante();

		// mettre à jour le composant modifié
		laVue.jp5Center.revalidate();
		laVue.jp5Center.repaint();
	}
}