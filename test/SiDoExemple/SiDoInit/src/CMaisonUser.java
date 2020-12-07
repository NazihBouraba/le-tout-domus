public class CMaisonUser extends CMaison {
	
	public CMaisonUser() {
		super();
		
		// Declarations a generer par projet compil
		// ...
		// fin zone generee par projet compil

		monHabitat = new HabitatSpecific(ma_liste_appareils,
				ma_liste_ens_appareils, ma_liste_scenarios,
				ma_liste_interfaces, ma_liste_programmations);
	}

}
