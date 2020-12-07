

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControljbAfficherScenario implements ActionListener {
	private Vue laVue;
	private CMaison maMaison;
	

	public ControljbAfficherScenario(Vue vue, CMaison M) {
		laVue = vue;
		maMaison = M;
	}

	public void actionPerformed(ActionEvent e) {

		String texte = new String();
		String nomScenarioSelectionne;
		try{
			// recupérer le scénario choisi par l'utilisateur
			 nomScenarioSelectionne = laVue.listScenario.getSelectedValue();
			
				for (CScenario scenario : maMaison.ma_liste_scenarios) {
					if (nomScenarioSelectionne.equals(scenario.getNomScenario())) {
						texte = texte + "Scénario " + scenario.getNomScenario()
								+ scenario.getStringContenuScenario();
						
						laVue.textAreaScenario.setText(texte);
					
						laVue.textAreaScenario.setFont(new Font("TimesRoman",
								Font.PLAIN, 16));
						
						laVue.textAreaScenario.setCaretPosition(0);

						laVue.jp4West12.add(laVue.pScrollPaneTexteScenario);
						
						// rafraîchir le comopsant modifié
						laVue.jp4West12.revalidate();
						laVue.jp4West12.repaint();
					}
				}
		}catch(Exception e1){
			System.out.print("\n");
			System.out.println("Choisir un scéanrio SVP,"
					+ " puis appuyer sur le bouton Afficher Scénario");
		}
	}

}


