

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
		
		//recup�rer la date courante
		maMaison.monHabitat.date_courante = date;
		
	    //Incr�menter l'heure
		maMaison.monHabitat.incDateHeure();
		
		String sNouvelleDate = maMaison.monHabitat.date_courante.toString();
		
		// supprimer les paranth�ses de la chaine de date
		String sNouvelleDate1 = sNouvelleDate.substring(1, (sNouvelleDate.length())-1);
			
		for (String str : sNouvelleDate1.split(",")) {
			t[i] = str;
			i++;
		}
		//mettre � jour l'heure	
		laVue.textHeureField.setText(t[3]);
		//mettre � jour le jour	
		laVue.textJourField.setText(t[2]);
		//mettre � jour le mois
		laVue.textMoisField.setText(t[1]);	
		//mettre � jour l'ann�e	
		laVue.textAnneeField.setText(t[0]);		
	}
}