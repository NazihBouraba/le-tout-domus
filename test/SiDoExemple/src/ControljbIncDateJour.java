

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControljbIncDateJour implements ActionListener {
	private CMaison maMaison;
	private Vue laVue;

	public ControljbIncDateJour(Vue vue, CMaison maMaison2) {
		laVue = vue;
		maMaison = maMaison2;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		CDate date;
		String sNouvelleDate, sNouvelleDate1;
		String[] t = new String[5];
		int i = 0;

		// méthode de transfert vers une date de type CDate
		date = laVue.transferAMJHMToCDate(laVue.textAnneeField,
				laVue.textMoisField, laVue.textJourField, laVue.textHeureField,
				laVue.textMinuteField);

		// recupérer la date courante
		maMaison.monHabitat.date_courante = date;
		
		//Incrémenter le jour
		maMaison.monHabitat.incDateJour();
		
		sNouvelleDate = maMaison.monHabitat.date_courante.toString();
		
		// supprimer les paranthèses
		sNouvelleDate1 = sNouvelleDate.substring(1,
				(sNouvelleDate.length()) - 1);
	
		for (String str : sNouvelleDate1.split(",")) {
			t[i] = str;
			i++;
		}
		// mettre à jour l'année
		laVue.textAnneeField.setText(t[0]);
		// mettre à jour le mois
		laVue.textMoisField.setText(t[1]);
		// mettre à jour le jour
		laVue.textJourField.setText(t[2]);

	}
}