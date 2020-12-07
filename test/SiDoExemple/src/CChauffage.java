

import java.awt.Color;

public class CChauffage extends CAppareil {

	public CChauffage(String nom, TypeAppareil typeApp) {
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
		if (action == TypeActionAppareil.ALLUMER_ECO) {
			this.etatAppareil = TypeEtatAppareil.ECO;
			this.setColorAppareil(Color.yellow);
			this.setStringColorAppareil("yellow");
		}
	}
}
