

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControljbIncDateAnnee implements ActionListener {
	private CMaison maMaison;
	private Vue laVue;

	public ControljbIncDateAnnee(Vue vue, CMaison maMaison2) {
		laVue = vue;
		maMaison = maMaison2;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int i = 0;
		CDate date;
		String[] t = new String[5];
		String sNouvelleDate, sNouvelleDate1;
		
		//méthode de transfert vers une date de type CDate
		date = laVue.transferAMJHMToCDate(laVue.textAnneeField,
				laVue.textMoisField, laVue.textJourField, laVue.textHeureField,
				laVue.textMinuteField);

		// recupérer la date courante
		maMaison.monHabitat.date_courante = date;

		// Incrémenter l'année
		maMaison.monHabitat.incDateAnnee();

		sNouvelleDate = maMaison.monHabitat.date_courante.toString();

		// supprimer les paranthèses de la chaine de date
		sNouvelleDate1 = sNouvelleDate.substring(1,
				(sNouvelleDate.length()) - 1);
	
		for (String str : sNouvelleDate1.split(",")) {
			t[i] = str;
			i++;
		}
		// mettre à jour l'année après l'incrémentation
		laVue.textAnneeField.setText(t[0]);
	}
}