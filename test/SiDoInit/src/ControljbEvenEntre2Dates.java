

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControljbEvenEntre2Dates implements ActionListener {
	private Vue laVue;
	private CMaison maMaison;
	int[] dateAMJHM;
	CDate d;

	public ControljbEvenEntre2Dates(Vue vue, CMaison M) {
		laVue = vue;
		maMaison = M;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		CDate dinf = laVue.transferAMJHMToCDate(laVue.textAnneeField,
				laVue.textMoisField, laVue.textJourField, laVue.textHeureField,
				laVue.textMinuteField);
		
		CDate dsup = laVue.transferAMJHMToCDate(laVue.textAnneeField1,
				laVue.textMoisField1, laVue.textJourField1, laVue.textHeureField1,
				laVue.textMinuteField1);
		
		// recupérer la date courante
		maMaison.monHabitat.date_courante = dinf;
		
		// execution de scénarios programmés (s'il existe)
		try{
			
			maMaison.monHabitat.execProgrammationDeDateCouranteJqaDate(dsup);
			
		}catch(Exception e){
			System.out.println("Exception: méthode execProgrammationDeDateCouranteJqaDate()"
							+ " de la classe Habitat");
		}
			
		// mettre à jour le composant modifié
			laVue.jp5Center.revalidate();
			laVue.jp5Center.repaint();

	}
}