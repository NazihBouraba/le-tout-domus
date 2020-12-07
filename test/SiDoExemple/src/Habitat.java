

import java.util.*;

public abstract class Habitat{
	public CDate date_courante;
	ArrayList<CAppareil> l_appareils;
	ArrayList<CEnsAppareil> l_ensembles;
	ArrayList<CScenario> l_scenarios;
	ArrayList<CInterface> l_interfaces;
	ArrayList<CProgrammation> l_programmations;

	public Habitat(ArrayList<CAppareil> lapp, ArrayList<CEnsAppareil> lens,
			ArrayList<CScenario> lscen, ArrayList<CInterface> lint,
			ArrayList<CProgrammation> lprog) {
		this.date_courante = new CDate(0, 0, 0, 0, 0);
		this.l_appareils = lapp;
		this.l_ensembles = lens;
		this.l_scenarios = lscen;
		this.l_interfaces = lint;
		this.l_programmations = lprog;
	}

	public CDate getDate() {
		return this.date_courante;
	}

	public String getStringDate() {
		return this.date_courante.toString();
	}

	public void changerDate(CDate d) {
		this.date_courante.updateDate(d);
	}

	public void changerDateAnnee(int v) {
		this.date_courante.updateDateAnnee(v);
	}

	public void changerDateMois(int v) {
		this.date_courante.updateDateMois(v);
	}

	public void changerDateJour(int v) {
		this.date_courante.updateDateJour(v);
	}

	public void changerDateHeure(int v) {
		this.date_courante.updateDateHeure(v);
	}

	public void changerDateMinute(int v) {
		this.date_courante.updateDateMinute(v);
	}

	public void incDateAnnee() {
		this.date_courante.incDateAnnee();
	}

	public void incDateMois() {
		this.date_courante.incDateMois();
	}

	public void incDateJour() {
		this.date_courante.incDateJour();
	}

	public void incDateHeure() {
		this.date_courante.incDateHeure();
	}

	public void incDateMinute() {
		this.date_courante.incDateMinute();
	}

	public ArrayList<CAppareil> getListeAppareils() {
		return this.l_appareils;
	}

	public ArrayList<CEnsAppareil> getListeEnsAppareils() {
		return this.l_ensembles;
	}

	public ArrayList<CScenario> getListeScenarios() {
		return this.l_scenarios;
	}

	public ArrayList<CInterface> getListeInterfaces() {
		return this.l_interfaces;
	}

	public ArrayList<CProgrammation> getListeProgrammations() {
		return this.l_programmations;
	}

	public void afficherAppareils() {
		System.out.println("-------------------------------------");
		System.out.println("Affichage des appareils ");
		for (CAppareil appareil : this.l_appareils) {
			System.out.println("Appareil " + appareil.nomAppareil + " de type "
					+ appareil.typeAppareil.toString() + " dans l'état "
					+ appareil.etatAppareil.toString()
					+ " et a donc la coluleur " + appareil.sColorAppareil);
		}
		System.out.println("-------------------------------------");
	}

	public void afficherEnsAppareils() {
		System.out.println("-------------------------------------");
		System.out.println("Affichage des ensembles d'appareils ");
		for (CEnsAppareil e : this.l_ensembles)
			System.out.println("Ensemble d'appareils " + e.nomEnsAppareil
					+ " : " + e.getStringLAppareils());
		System.out.println("-------------------------------------");
	}

	public void afficherScenarios() {
		System.out.println("-------------------------------------");
		System.out.println("Affichage des scenarios ");
		for (CScenario scenario : this.l_scenarios)
			System.out.println("Scenario " + scenario.getNomScenario() + " : "
					+ scenario.getStringContenuScenario());
		System.out.println("-------------------------------------");
	}

	public void afficherInterfaces() {
		System.out.println("-------------------------------------");
		System.out.println("Affichage des interfaces ");
		for (CInterface i : this.l_interfaces) {
			System.out.println("Interface " + i.getNomInterface() + " de type " + i.getTypeInterface());
			if (! i.getScenariosAssocies().isEmpty()) 
				System.out.println(" associée aux scenarios : " + i.getStringScenariosAssocies());
		}
		System.out.println("-------------------------------------");
	}

	public void afficherProgrammations() {
		System.out.println("-------------------------------------");
		System.out.println("Affichage des programmations ");
		for (CProgrammation p : this.l_programmations)
			System.out.println("Scenario " + p.getNomScenario()
					+ " programmé aux dates : " + p.getStringListeDates());
		System.out.println("-------------------------------------");
	}

	public void execScenario(String nomS) {
		int indice = -1;
		int i = 0;
		while (indice == -1 && i < this.l_scenarios.size()) {
			if (this.l_scenarios.get(i).getNomScenario().equals(nomS))
				indice = i;
			i++;
		}

		if (indice == -1)
			System.out.println("Erreur ExecScenario : Scenario " + nomS
					+ " non trouvé");
		else

			this.execScenarioNum(indice);

	}

	public abstract void execScenarioNum(int num);
	
	// j'ajouté le cas où l'interface n'est pas associé à un scénario
	public void execInterface(String nomI) {
		for (CInterface I : this.l_interfaces)
			if (I.getNomInterface().equals(nomI)) {
				if (I.getScenariosAssocies().size()==0 ){
					System.out.print("\n");
					System.out.println(I.getNomInterface() + 
							" n'est pas encore associé à un Scenario ");	
				}else{
					System.out.print("\n");
					System.out.print("Execution interface " + I.getNomInterface() + " - ");
				}
					
				for (String s : I.getScenariosAssocies())
					execScenario(s);								
			}
	}

	public void execProgrammationADateCourante() {
		System.out.print("\n");
		boolean b = false;
		for (CProgrammation p : this.l_programmations)
			for (CDate d : p.getListeDates())
				if (d.equalsDate(this.date_courante)) {
					System.out.print(this.date_courante.afficherSDate() + " - ");
					execScenario(p.getNomScenario());
					b = true;
				}
		if (!b)
			System.out.println("pas de scénario associé à la date : "
					+ this.date_courante.afficherSDate());
	}

	public void execProgrammationDeDateCouranteJqaDate(CDate dfin) {
		String[] lScenarios = new String[100];
		CDate[] lDatesScenarios = new CDate[100];
		String[] lScenariosRepet = new String[100];
		CDate[] lDatesScenariosRepet = new CDate[100];
		String[] lScenariosRepet2 = new String[200];
		CDate[] lDatesScenariosRepet2 = new CDate[200];
		String[] lScenariosRepet3 = new String[300];
		CDate[] lDatesScenariosRepet3 = new CDate[300];
		String[] lScenariosRepet4 = new String[400];
		CDate[] lDatesScenariosRepet4 = new CDate[400];
		String[] lScenariosRepet5 = new String[1000];
		CDate[] lDatesScenariosRepet5 = new CDate[1000];
		String[] lScenariosRepet6 = new String[2000];
		CDate[] lDatesScenariosRepet6 = new CDate[2000];
		String[] lScenariosGlobal = new String[2100];
		CDate[] lDatesScenariosGlobal = new CDate[2100];
		String[] lTypesScenariosGlobal = new String[2100];
		int nb = 0, nbr = 0, nbr2 = 0, nbr3 = 0, nbr4 = 0, nbr5 = 0, nbr6 = 0, nbg = 0;
		CDate temp;
		String stemp;

		// System.out.println("Evènements en ordre chronologique du "
		// + this.date_courante.toString() + " au " + dfin.toString()
		// + " : ");
		
		System.out.print("\n");
		for (CProgrammation p : this.l_programmations)
			for (CDate d : p.getListeDates())
				if (d.supEgDate(this.date_courante) && d.infEgDate(dfin))
					if (d.estDateRepet()) {
						lScenariosRepet[nbr] = p.getNomScenario();
						lDatesScenariosRepet[nbr] = d;
						nbr++;
					} else {
						lScenarios[nb] = p.getNomScenario();
						lDatesScenarios[nb] = d;
						nb++;
					}

		for (int i = 0; i < nbr; i++)
			if (lDatesScenariosRepet[i].getRepetitionsDate()[0]) {
				CDate dr = new CDate(0, 0, 0, 0, 0);
				dr.updateDate(lDatesScenariosRepet[i]);
				dr.updateDateAnnee(this.date_courante.annee);
				if (!dr.supEgDate(this.date_courante))
					dr.incDateAnnee();
				while (dr.infEgDate(dfin)) {
					CDate dr2 = new CDate(0, 0, 0, 0, 0);
					dr2.updateDate(dr);
					lScenariosRepet2[nbr2] = lScenariosRepet[i];
					lDatesScenariosRepet2[nbr2] = dr2;
					dr.incDateAnnee();
					nbr2++;
				}
			} else {
				lScenariosRepet2[nbr2] = lScenariosRepet[i];
				lDatesScenariosRepet2[nbr2] = lDatesScenariosRepet[i];
				nbr2++;
			}

		for (int i = 0; i < nbr2; i++)
			if (lDatesScenariosRepet2[i].getRepetitionsDate()[1]) {
				CDate dr = new CDate(0, 0, 0, 0, 0);
				dr.updateDate(lDatesScenariosRepet2[i]);
				dr.updateDateMois(1);
				while (!dr.supEgDate(this.date_courante))
					dr.incDateMois();
				while (dr.infEgDate(dfin)) {
					CDate dr2 = new CDate(0, 0, 0, 0, 0);
					dr2.updateDate(dr);
					lScenariosRepet3[nbr3] = lScenariosRepet2[i];
					lDatesScenariosRepet3[nbr3] = dr2;
					dr.incDateMois();
					nbr3++;
				}
			} else {
				lScenariosRepet3[nbr3] = lScenariosRepet2[i];
				lDatesScenariosRepet3[nbr3] = lDatesScenariosRepet2[i];
				nbr3++;
			}

		for (int i = 0; i < nbr3; i++)
			if (lDatesScenariosRepet3[i].getRepetitionsDate()[2]) {
				CDate dr = new CDate(0, 0, 0, 0, 0);
				dr.updateDate(lDatesScenariosRepet3[i]);
				dr.updateDateJour(1);
				while (!dr.supEgDate(this.date_courante))
					dr.incDateJour();
				while (dr.infEgDate(dfin)) {
					CDate dr2 = new CDate(0, 0, 0, 0, 0);
					dr2.updateDate(dr);
					lScenariosRepet4[nbr4] = lScenariosRepet3[i];
					lDatesScenariosRepet4[nbr4] = dr2;
					dr.incDateJour();
					nbr4++;
				}
			} else {
				lScenariosRepet4[nbr4] = lScenariosRepet3[i];
				lDatesScenariosRepet4[nbr4] = lDatesScenariosRepet3[i];
				nbr4++;
			}

		for (int i = 0; i < nbr4; i++)
			if (lDatesScenariosRepet4[i].getRepetitionsDate()[3]) {
				CDate dr = new CDate(0, 0, 0, 0, 0);
				dr.updateDate(lDatesScenariosRepet4[i]);
				dr.updateDateHeure(0);
				while (!dr.supEgDate(this.date_courante))
					dr.incDateHeure();
				while (dr.infEgDate(dfin)) {
					CDate dr2 = new CDate(0, 0, 0, 0, 0);
					dr2.updateDate(dr);
					lScenariosRepet5[nbr5] = lScenariosRepet4[i];
					lDatesScenariosRepet5[nbr5] = dr2;
					dr.incDateHeure();
					nbr5++;
				}
			} else {
				lScenariosRepet5[nbr5] = lScenariosRepet4[i];
				lDatesScenariosRepet5[nbr5] = lDatesScenariosRepet4[i];
				nbr5++;
			}

		for (int i = 0; i < nbr5; i++)
			if (lDatesScenariosRepet5[i].getRepetitionsDate()[4]) {
				CDate dr = new CDate(0, 0, 0, 0, 0);
				dr.updateDate(lDatesScenariosRepet5[i]);
				dr.updateDateMinute(0);
				while (!dr.supEgDate(this.date_courante))
					dr.incDateMinute();
				while (dr.infEgDate(dfin)) {
					CDate dr2 = new CDate(0, 0, 0, 0, 0);
					dr2.updateDate(dr);
					lScenariosRepet6[nbr6] = lScenariosRepet5[i];
					lDatesScenariosRepet6[nbr6] = dr2;
					dr.incDateMinute();
					nbr6++;
				}
			} else {
				lScenariosRepet6[nbr6] = lScenariosRepet5[i];
				lDatesScenariosRepet6[nbr6] = lDatesScenariosRepet5[i];
				nbr6++;
			}

		for (int i = 0; i < nb; i++) {
			lScenariosGlobal[nbg] = lScenarios[i];
			lDatesScenariosGlobal[nbg] = lDatesScenarios[i];
			lTypesScenariosGlobal[nbg] = "Ponctuel";
			nbg++;
		}
		for (int i = 0; i < nbr6; i++) {
			lScenariosGlobal[nbg] = lScenariosRepet6[i];
			lDatesScenariosGlobal[nbg] = lDatesScenariosRepet6[i];
			lTypesScenariosGlobal[nbg] = "Periodique";
			nbg++;
		}

		for (int i = 0; i < nbg - 1; i++)
			for (int j = i; j < nbg; j++)
				if (!(lDatesScenariosGlobal[i]
						.infEgDate(lDatesScenariosGlobal[j]))) {
					temp = lDatesScenariosGlobal[i];
					lDatesScenariosGlobal[i] = lDatesScenariosGlobal[j];
					lDatesScenariosGlobal[j] = temp;
					stemp = lScenariosGlobal[i];
					lScenariosGlobal[i] = lScenariosGlobal[j];
					lScenariosGlobal[j] = stemp;
					stemp = lTypesScenariosGlobal[i];
					lTypesScenariosGlobal[i] = lTypesScenariosGlobal[j];
					lTypesScenariosGlobal[j] = stemp;
				}

		for (int i = 0; i < nbg; i++)
			if (i == 0
					|| (i > 0 && !(lDatesScenariosGlobal[i]
							.equalsDate(lDatesScenariosGlobal[i - 1])
							&& lScenariosGlobal[i]
									.equals(lScenariosGlobal[i - 1])
							&& lTypesScenariosGlobal[i].equals("Periodique") && lTypesScenariosGlobal[i - 1]
							.equals("Periodique")))) {
				System.out.print(lDatesScenariosGlobal[i].afficherSDate()+ " - "
						+ lTypesScenariosGlobal[i] + " : ");

				execScenario(lScenariosGlobal[i]);
				
			}
	}
}
