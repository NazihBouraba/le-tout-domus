

import java.awt.Color;

public class CAlarme extends CAppareil {

	public CAlarme(String nom, TypeAppareil typeApp) {
		super(nom, typeApp);
		this.nomAppareil = nom;
		this.etatAppareil = TypeEtatAppareil.ETEINT;
	}

	public void appliquer(TypeActionAppareil action) {
		if (action == TypeActionAppareil.ALLUMER) {
			this.etatAppareil = TypeEtatAppareil.ALLUME;
			this.setColorAppareil(Color.green);
			this.setStringColorAppareil("green");
		}
		if (action == TypeActionAppareil.ETEINDRE) {
			this.etatAppareil = TypeEtatAppareil.ETEINT;
			this.setColorAppareil(Color.red);
			this.setStringColorAppareil("red");
		}
		if (action == TypeActionAppareil.ALLUMER_PARTIEL) {
			this.etatAppareil = TypeEtatAppareil.DEMI;
			this.setColorAppareil(Color.yellow);
			this.setStringColorAppareil("yellow");
		}
	}
}