

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControljbIncHeure implements ActionListener {
	private CMaison maMaison;
	private Vue laVue;
	
	public ControljbIncHeure(Vue vue, CMaison maMaison2) {
		laVue = vue;
		maMaison = maMaison2;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		CDate date;
		String[] t = new String[5];
		int i = 0;
		
		date = laVue.transferAMJHMToCDate(laVue.textAnneeField,laVue.textMoisField, 
				laVue.textJourField,laVue.textHeureField, laVue.textMinuteField); 
		
		//recupérer la date courante
		maMaison.monHabitat.date_courante = date;
		
	    //Incrémenter l'heure
		maMaison.monHabitat.incDateHeure();
		
		String sNouvelleDate = maMaison.monHabitat.date_courante.toString();
		
		// supprimer les paranthèses de la chaine de date
		String sNouvelleDate1 = sNouvelleDate.substring(1, (sNouvelleDate.length())-1);
			
		for (String str : sNouvelleDate1.split(",")) {
			t[i] = str;
			i++;
		}
		//mettre à jour l'heure	
		laVue.textHeureField.setText(t[3]);
		//mettre à jour le jour	
		laVue.textJourField.setText(t[2]);
		//mettre à jour le mois
		laVue.textMoisField.setText(t[1]);	
		//mettre à jour l'année	
		laVue.textAnneeField.setText(t[0]);		
	}
}