



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControljbPopupDate1 implements ActionListener {
	
	private Vue laVue;
	

	public ControljbPopupDate1(Vue vue) {
		laVue = vue;
	}
	
		public void actionPerformed(ActionEvent ae) {
			// on cr�e l'objet DatePicker avec en param le nom du composant de la vue,
			// on appele la m�thode setPickedDate() sur l'objet cr��	
			String sDate = new DatePicker(laVue.jp2South3).setPickedDate();
			
			//transf�rer la chaine de date vers un tableau d'entier
			int[] t = laVue.stringDateToTableauInt(sDate);
			
			// on �crit la date choisie par l'utilisateur sur les champs (ann�e, mois, jour)
			laVue.textAnneeField1.setText(""+t[0]);
			laVue.textMoisField1.setText(""+t[1]);
			laVue.textJourField1.setText(""+t[2]);
	}	
}
