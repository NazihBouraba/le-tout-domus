

import java.awt.Color;

public class CVoletFenetre extends CAppareil{

	public CVoletFenetre(String nom,TypeAppareil typeApp)
	{	
		super(nom,typeApp);
		this.etatAppareil = TypeEtatAppareil.FERME;
	}
	
	public void appliquer(TypeActionAppareil action)
	{
		if (action == TypeActionAppareil.OUVRIR) {
			this.etatAppareil = TypeEtatAppareil.OUVERT;
			this.setColorAppareil(Color.green);
			this.setStringColorAppareil("green");
		}
		if (action == TypeActionAppareil.FERMER) {
			this.etatAppareil = TypeEtatAppareil.FERME;
			this.setColorAppareil(Color.red);
			this.setStringColorAppareil("red");
		}
		if (action == TypeActionAppareil.OUVRIR_PARTIEL) {
			this.etatAppareil = TypeEtatAppareil.DEMI;
			this.colorAppareil = Color.yellow;
			this.sColorAppareil= "yellow";
			
		}
		if (action == TypeActionAppareil.FERMER_PARTIEL) {
			this.etatAppareil = TypeEtatAppareil.DEMI;
			this.setColorAppareil(Color.yellow);
			this.setStringColorAppareil("yellow");		
		}
	}
}
