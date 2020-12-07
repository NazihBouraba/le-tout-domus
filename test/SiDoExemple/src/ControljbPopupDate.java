

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControljbPopupDate implements ActionListener {
	
	private Vue laVue;
	
	public ControljbPopupDate(Vue vue) {
		laVue = vue;	
	}
	
		public void actionPerformed(ActionEvent ae) {			
			String sDate;
			int[] t;
			
			// on crée l'objet DatePicker avec en param le nom du composant de la vue,
			// on appele la méthode setPickedDate() sur l'objet créé
			sDate = new DatePicker(laVue.jp2South1).setPickedDate();
			
			//transférer la chaine de date vers un tableau d'entier
			t = laVue.stringDateToTableauInt(sDate);
			
			// on écrit la date choisie par l'utilisateur sur les champs (année, mois, jour)
			laVue.textAnneeField.setText(""+t[0]);
			laVue.textMoisField.setText(""+t[1]);
			laVue.textJourField.setText(""+t[2]);		
	}	
}
