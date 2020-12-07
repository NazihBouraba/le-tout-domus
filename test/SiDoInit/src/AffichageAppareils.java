

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class AffichageAppareils extends JPanel {
	private static final long serialVersionUID = 1L;
	
	CAppareil appareil;

	JPanel jpanel, jpEclairage, jpVolet, jpFenetre, jpChauffageAlarme,
			jpAutreAppareil;

	GridLayout glo;
	int i = 0;

	public AffichageAppareils(ArrayList<CAppareil> ma_liste_appareils) {
		CAppareilGraphique appareilGraphique;
		Dimension dim = new Dimension(50, 40);
		
		// gridlayout principale de 6 lignes et 1 colonne
		this.glo = new GridLayout(6, 1, 60, 10);
		this.setLayout(glo);

		// le flux d'appareils graphiques dans un panel
		// FlowLayout(int align, int hgap, int vgap)
		FlowLayout flo = new FlowLayout(0, 30, 10);

		// créer les panels
		this.jpanel = new JPanel();
		this.jpEclairage = new JPanel();
		this.jpVolet = new JPanel();
		this.jpFenetre = new JPanel();
		this.jpChauffageAlarme = new JPanel();
		this.jpAutreAppareil = new JPanel();
		
		// set le flowLayout comme un gestionnaire de layout
		this.jpEclairage.setLayout(flo);
		this.jpVolet.setLayout(flo);
		this.jpFenetre.setLayout(flo);
		this.jpChauffageAlarme.setLayout(flo);
		this.jpAutreAppareil.setLayout(flo);

		// ajouter les jp secondaires dans ce jp

		for (CAppareil appareil : ma_liste_appareils) {
			if (appareil.typeAppareil.equals(TypeAppareil.ECLAIRAGE)) {
				appareilGraphique = new CAppareilGraphique(appareil);
				appareilGraphique.setPreferredSize(dim);
				this.jpEclairage.add(appareilGraphique);
			}
		}
		for (CAppareil appareil : ma_liste_appareils) {
			if (appareil.typeAppareil.equals(TypeAppareil.VOLET)) {
				appareilGraphique = new CAppareilGraphique(appareil);
				appareilGraphique.setPreferredSize(dim);
				this.jpVolet.add(appareilGraphique);
			}
		}

		for (CAppareil appareil : ma_liste_appareils) {
			if (appareil.typeAppareil.equals(TypeAppareil.FENETRE)) {
				 appareilGraphique = new CAppareilGraphique(
						appareil);
				 appareilGraphique.setPreferredSize(dim);
				jpFenetre.add(appareilGraphique);
			}
		}

		for (CAppareil appareil : ma_liste_appareils) {
			if (appareil.typeAppareil.equals(TypeAppareil.CHAUFFAGE)
					|| appareil.typeAppareil.equals(TypeAppareil.ALARME)) {
				appareilGraphique = new CAppareilGraphique(appareil);
				appareilGraphique.setPreferredSize(dim);
				jpChauffageAlarme.add(appareilGraphique);
			}
		}

		for (CAppareil appareil : ma_liste_appareils) {
			if (appareil.estTypeAutreAppareil) {
				appareilGraphique = new CAppareilGraphique(appareil);
				appareilGraphique.setPreferredSize(dim);
				jpAutreAppareil.add(appareilGraphique);
			}
		}
			
		// ajouter les jpanel dans ce jpanel
		this.add(jpEclairage);
		this.add(jpVolet);
		this.add(jpFenetre);
		this.add(jpChauffageAlarme);
		this.add(jpAutreAppareil);

		//////// ajuster la taille de ce panel
		// pour descendre à la ligne à partir de 10 objets
		//this.setPreferredSize(new Dimension(840, 690));
		
		// pour descendre à la ligne à partir de 8 objets
		this.setPreferredSize(new Dimension(650, 710));
	}
}
