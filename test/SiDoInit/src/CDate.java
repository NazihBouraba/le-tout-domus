

import java.util.*;

public class CDate {
	int annee;
	int mois;
	int jour;
	int heure;
	int minute;
	private int[] mois31 = { 1, 3, 5, 7, 8, 10, 12 };
	private int[] mois30 = { 4, 6, 9, 11 };

	public CDate(int a, int m, int j, int h, int min) {
		this.annee = a;
		this.mois = m;
		this.jour = j;
		this.heure = h;
		this.minute = min;
	}

	public boolean[] getRepetitionsDate() {
		boolean[] t = { false, false, false, false, false };
		t[0] = (this.annee == -1);
		t[1] = (this.mois == -1);
		t[2] = (this.jour == -1);
		t[3] = (this.heure == -1);
		t[4] = (this.minute == -1);
		return t;
	}

	public boolean estBissextile() {
		return (((this.annee % 4 == 0) && (this.annee % 100 != 0)) || (this.annee % 400 == 0));
	}

	public void updateDate(CDate d) {
		this.annee = d.annee;
		this.mois = d.mois;
		this.jour = d.jour;
		this.heure = d.heure;
		this.minute = d.minute;
	}

	public void updateDateAnnee(int v) {
		this.annee = v;
	}

	public void updateDateMois(int v) {
		this.mois = v;
	}

	public void updateDateJour(int v) {
		this.jour = v;
	}

	public void updateDateHeure(int v) {
		this.heure = v;
	}

	public void updateDateMinute(int v) {
		this.minute = v;
	}

	public void incDateAnnee() {
		this.annee++;
	}

	public void incDateMois() {
		if (this.mois < 12)
			this.mois++;
		else {
			this.mois = 1;
			this.incDateAnnee();
		}
	}

	public void incDateJour() {
		if ((this.estBissextile() && this.jour < 29) || this.jour < 28)
			this.jour++;
		else if (Arrays.binarySearch(mois31, this.mois) >= 0 && this.jour < 31)
			this.jour++;
		else if (Arrays.binarySearch(mois30, this.mois) >= 0 && this.jour < 30)
			this.jour++;
		else {
			this.jour = 1;
			this.incDateMois();
		}
	}

	public void incDateHeure() {
		if (this.heure < 23)
			this.heure++;
		else {
			this.heure = 0;
			this.incDateJour();
		}
	}

	public void incDateMinute() {
		if (this.minute < 59)
			this.minute++;
		else {
			this.minute = 0;
			this.incDateHeure();
		}
	}

	public boolean estDateRepet() {
		return (this.annee == -1 || this.mois == -1 || this.jour == -1
				|| this.heure == -1 || this.minute == -1);
	}

	public boolean equalsDate(CDate d) {
		return ((this.annee == d.annee || this.annee == -1)
				&& (this.mois == d.mois || this.mois == -1)
				&& (this.jour == d.jour || this.jour == -1)
				&& (this.heure == d.heure || this.heure == -1) && (this.minute == d.minute || this.minute == -1));
	}

	public boolean infEgDate(CDate d) {
		CDate nd = new CDate(0, 0, 0, 0, 0);
		if (this.annee == -1)
			if (d.annee > 0)
				return true;
			else {
				nd.updateDate(this);
				nd.updateDateAnnee(d.annee);
				return (nd.infEgDate(d));
			}
		;
		if (this.annee > d.annee)
			return false;
		if (this.annee < d.annee)
			return true;
		if (this.mois == -1)
			if (d.mois > 1)
				return true;
			else {
				nd.updateDate(this);
				nd.updateDateMois(d.mois);
				return (nd.infEgDate(d));
			}
		;
		if (this.mois > d.mois)
			return false;
		if (this.mois < d.mois)
			return true;
		if (this.jour == -1)
			if (d.jour > 1)
				return true;
			else {
				nd.updateDate(this);
				nd.updateDateJour(d.jour);
				return (nd.infEgDate(d));
			}
		;
		if (this.jour > d.jour)
			return false;
		if (this.jour < d.jour)
			return true;
		if (this.heure == -1)
			if (d.heure > 0)
				return true;
			else {
				nd.updateDate(this);
				nd.updateDateHeure(d.heure);
				return (nd.infEgDate(d));
			}
		;
		if (this.heure > d.heure)
			return false;
		if (this.heure < d.heure)
			return true;
		if (this.minute > d.minute)
			return false;
		return true;
	}

	public boolean supEgDate(CDate d) {
		CDate nd = new CDate(0, 0, 0, 0, 0);
		if (this.annee == -1)
			return true;
		if (this.annee < d.annee)
			return false;
		if (this.annee > d.annee)
			return true;
		if (this.mois == -1)
			if (d.mois < 12)
				return true;
			else {
				nd.updateDate(this);
				nd.updateDateMois(d.mois);
				return (nd.supEgDate(d));
			}
		;
		if (this.mois < d.mois)
			return false;
		if (this.mois > d.mois)
			return true;
		if (this.jour == -1)
			if (Arrays.binarySearch(mois30, d.mois) >= 0)
				if (d.jour < 30)
					return true;
				else {
					nd.updateDate(this);
					nd.updateDateJour(d.jour);
					return (nd.supEgDate(d));
				}
			else if (Arrays.binarySearch(mois31, d.mois) >= 0)
				if (d.jour < 31)
					return true;
				else {
					nd.updateDate(this);
					nd.updateDateJour(d.jour);
					return (nd.supEgDate(d));
				}
			else if ((this.estBissextile() && d.jour < 29) || d.jour < 28)
				return true;
			else {
				nd.updateDate(this);
				nd.updateDateJour(d.jour);
				return (nd.supEgDate(d));
			}
		;
		if (this.jour < d.jour)
			return false;
		if (this.jour > d.jour)
			return true;
		if (this.heure == -1)
			if (d.heure < 23)
				return true;
			else {
				nd.updateDate(this);
				nd.updateDateHeure(d.heure);
				return (nd.supEgDate(d));
			}
		;
		if (this.heure < d.heure)
			return false;
		if (this.heure > d.heure)
			return true;
		if (this.minute == -1)
			return true;
		if (this.minute < d.minute)
			return false;
		return true;
	}

	public String toString() {
		Integer a = new Integer(this.annee);
		Integer m = new Integer(this.mois);
		Integer j = new Integer(this.jour);
		Integer h = new Integer(this.heure);
		Integer min = new Integer(this.minute);
		String sa = new String();
		String sm = new String();
		String sj = new String();
		String sh = new String();
		String smin = new String();

		if (a == -1)
			sa = "_";
		else
			sa = a.toString();
		if (m == -1)
			sm = "_";
		else
			sm = m.toString();
		if (j == -1)
			sj = "_";
		else
			sj = j.toString();
		if (h == -1)
			sh = "_";
		else
			sh = h.toString();
		if (min == -1)
			smin = "_";
		else
			smin = min.toString();

		return "(" + sa + "," + sm + "," + sj + "," + sh + "," + smin + ")";
	}

	// J'ajouter cette méthode pour afficher la date dans un format connu
	public String afficherSDate() {
		Integer a = new Integer(this.annee);
		Integer m = new Integer(this.mois);
		Integer j = new Integer(this.jour);
		Integer h = new Integer(this.heure);
		Integer min = new Integer(this.minute);
		String sa = new String();
		String sm = new String();
		String sj = new String();
		String sh = new String();
		String smin = new String();

		if (a == -1)
			sa = "_";
		else
			sa = a.toString();
		if (m == -1)
			sm = "_";
		else
			sm = m.toString();
		if (j == -1)
			sj = "_";
		else
			sj = j.toString();
		if (h == -1)
			sh = "_";
		else
			sh = h.toString();
		if (min == -1)
			smin = "_";
		else
			smin = min.toString();

		return "(" + sj + " / " + sm + " / " + sa + " , " + sh + " : " + smin + ")";
	}
}
