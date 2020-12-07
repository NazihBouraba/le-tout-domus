

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControljbIncDateMois implements ActionListener {
	private CMaison maMaison;
	private Vue laVue;

	public ControljbIncDateMois(Vue vue, CMaison maMaison2) {
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
		
		maMaison.monHabitat.date_courante = date;
		
		maMaison.monHabitat.incDateMois();
		
		String sNouvelleDate = maMaison.monHabitat.date_courante.toString();
		String sNouvelleDate1 = sNouvelleDate.substring(1,(sNouvelleDate.length()) - 1);
			
		for (String str : sNouvelleDate1.split(",")) {
			t[i] = str;
			i++;
		}	
		laVue.textMoisField.setText(t[1]);	
		laVue.textAnneeField.setText(t[0]);
		
	}
}