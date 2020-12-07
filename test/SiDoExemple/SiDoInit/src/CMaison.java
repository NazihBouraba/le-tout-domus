

import java.util.ArrayList;

public abstract class CMaison {
	public ArrayList<CAppareil> ma_liste_appareils = new ArrayList<CAppareil>();
	public ArrayList<CEnsAppareil> ma_liste_ens_appareils = new ArrayList<CEnsAppareil>();
	public ArrayList<CScenario> ma_liste_scenarios = new ArrayList<CScenario>(); 
	public ArrayList<CInterface> ma_liste_interfaces = new ArrayList<CInterface>();
	public ArrayList<CProgrammation> ma_liste_programmations = new ArrayList<CProgrammation>(); 
	public HabitatSpecific monHabitat;

	public CMaison() {
		ma_liste_appareils = new ArrayList<CAppareil>();
		ma_liste_ens_appareils = new ArrayList<CEnsAppareil>();
		ma_liste_scenarios = new ArrayList<CScenario>();
		ma_liste_interfaces = new ArrayList<CInterface>();
		ma_liste_programmations = new ArrayList<CProgrammation>();
	}

	public String[] arrayListToTableauDeString(
			ArrayList<CScenario> ma_liste_scenarios) {
		String[] sList = new String[ma_liste_scenarios.size()];
		int i = 0;
		for (CScenario scenario : ma_liste_scenarios) {

			// System.out.println(scenario.getNomScenario());
			String s = scenario.getNomScenario();
			sList[i] = s;
			// System.out.println(sList[i]);
			i++;
		}
		return sList;
	}
	

	public String getStringListeDatesTexte(ArrayList<CProgrammation> ma_liste_programmations) {
		String texte = "";
		for (CProgrammation p : ma_liste_programmations) {
			String nomScenario = p.getNomScenario();
			String sListDate = p.getStringListeDates();
			texte = texte + "Scenario " + nomScenario + "\n" + sListDate + "\n";
		}
		return texte;
	}


	public void resetAffichageAppareils(ArrayList<CAppareil> ma_liste_appareils) {

		for (CAppareil appareil : ma_liste_appareils) {
			if (appareil.typeAppareil.equals(TypeAppareil.VOLET)
					|| (appareil.typeAppareil.equals(TypeAppareil.FENETRE)))
				appareil.appliquer(TypeActionAppareil.FERMER);
			else
				appareil.appliquer(TypeActionAppareil.ETEINDRE);
		}
	}

	public static int getnombreAppareils(TypeAppareil typeappareil,
			ArrayList<CAppareil> ma_liste_appareils) {
		int nombre = 0;
		for (CAppareil appareil : ma_liste_appareils) {
			if (appareil.typeAppareil.equals(typeappareil)) {
				nombre++;
			}
		}
		return nombre;
	}

	public static int getnombreAutreAppareils(ArrayList<CAppareil> ma_liste_appareils) {
		int nombreAutreAppareils = 0;	
	
		for (CAppareil appareil : ma_liste_appareils) {
			if (appareil.estTypeAutreAppareil) {
				nombreAutreAppareils++;
			}
		}
		return nombreAutreAppareils;		
	}

	public void addObserver(Vue maVue) {
		// TODO Auto-generated method stub	
		
	}
	
	

}
