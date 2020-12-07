

import java.awt.Color;

public class CEclairage extends CAppareil {

	public CEclairage(String nom, TypeAppareil typeApp) {
		super(nom, typeApp);
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
		if (action == TypeActionAppareil.TAMISER) {
			this.etatAppareil = TypeEtatAppareil.DEMI;
			this.setColorAppareil(Color.yellow);
			this.setStringColorAppareil("yellow");
		}		
	}

}
