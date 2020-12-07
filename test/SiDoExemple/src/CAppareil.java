

import java.awt.Color;
import java.util.ArrayList;

public abstract class CAppareil implements Observable {
	String nomAppareil;
	public TypeAppareil typeAppareil;
	TypeEtatAppareil etatAppareil;
	Color colorAppareil = Color.red;
	String sColorAppareil = "red";

	public Boolean estTypeAutreAppareil;

	private ArrayList<Observer> listObserver = new ArrayList<Observer>();

	public CAppareil(String nom, TypeAppareil typeApp) {
		this.nomAppareil = nom;
		this.typeAppareil = typeApp;
		this.etatAppareil = TypeEtatAppareil.ETEINT;
		this.colorAppareil = Color.red;
		this.sColorAppareil = "red";
		this.estTypeAutreAppareil = false;

	}

	public String getNomAppareil() {
		return this.nomAppareil;
	}

	public TypeAppareil getTypeAppareil() {
		return this.typeAppareil;
	}

	public Color getColorAppareil() {
		return this.colorAppareil;
	}

	public String getStringColorAppareil() {
		return this.sColorAppareil;
	}

	public Boolean estTypeAutreAppareil() {
		return this.estTypeAutreAppareil;
	}

	public TypeEtatAppareil getEtatAppareil() {
		return this.etatAppareil;
	}

	public abstract void appliquer(TypeActionAppareil action);

	public String toString() {
		return "Appareil " + this.nomAppareil + " de type "
				+ this.typeAppareil.toString() + " dans l'état "
				+ this.etatAppareil.toString() + " et a donc la couleur "
				+ this.sColorAppareil;
	}

	// Implémentation du pattern observer
	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.listObserver.add(obs);
	}

	@Override
	public void removeObserver() {
		// TODO Auto-generated method stub
		listObserver = new ArrayList<Observer>();
	}

	@Override
	public void notifyObserver(String sColor) {
		// TODO Auto-generated method stub
		for (Observer obs : listObserver)
			obs.update(sColor);
	}

	public void notifyObserver(Color color) {
		// TODO Auto-generated method stub
		for (Observer obs : listObserver)
			obs.update(color);
	}

	public void setStringColorAppareil(String sColor) {
		// TODO Auto-generated method stub
		if (!sColorAppareil.equals(sColor)) {
			sColorAppareil = sColor;
			notifyObserver(sColor);
		}
	}

	public void setColorAppareil(Color color) {
		// TODO Auto-generated method stub
		if (!colorAppareil.equals(color)) {
			colorAppareil = color;
			notifyObserver(color);
		}
	}
}
