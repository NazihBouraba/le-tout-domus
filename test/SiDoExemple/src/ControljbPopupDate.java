

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
			
			// on cr�e l'objet DatePicker avec en param le nom du composant de la vue,
			// on appele la m�thode setPickedDate() sur l'objet cr��
			sDate = new DatePicker(laVue.jp2South1).setPickedDate();
			
			//transf�rer la chaine de date vers un tableau d'entier
			t = laVue.stringDateToTableauInt(sDate);
			
			// on �crit la date choisie par l'utilisateur sur les champs (ann�e, mois, jour)
			laVue.textAnneeField.setText(""+t[0]);
			laVue.textMoisField.setText(""+t[1]);
			laVue.textJourField.setText(""+t[2]);		
	}	
}
