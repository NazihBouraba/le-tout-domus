



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControljbPopupDate1 implements ActionListener {
	
	private Vue laVue;
	

	public ControljbPopupDate1(Vue vue) {
		laVue = vue;
	}
	
		public void actionPerformed(ActionEvent ae) {
			// on crée l'objet DatePicker avec en param le nom du composant de la vue,
			// on appele la méthode setPickedDate() sur l'objet créé	
			String sDate = new DatePicker(laVue.jp2South3).setPickedDate();
			
			//transférer la chaine de date vers un tableau d'entier
			int[] t = laVue.stringDateToTableauInt(sDate);
			
			// on écrit la date choisie par l'utilisateur sur les champs (année, mois, jour)
			laVue.textAnneeField1.setText(""+t[0]);
			laVue.textMoisField1.setText(""+t[1]);
			laVue.textJourField1.setText(""+t[2]);
	}	
}
