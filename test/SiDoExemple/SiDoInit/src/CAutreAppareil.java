

import java.awt.Color;

public class CAutreAppareil extends CAppareil{

	public CAutreAppareil(String nom,TypeAppareil typeApp)
	{	
		super(nom,typeApp);
		this.etatAppareil = TypeEtatAppareil.ETEINT;
		this.estTypeAutreAppareil = true; 
		this.colorAppareil =  Color.red;
		this.sColorAppareil = "red";
	}
	
	public void appliquer(TypeActionAppareil action)
	{
		if (action == TypeActionAppareil.ALLUMER) 
			{
			this.etatAppareil = TypeEtatAppareil.ALLUME;
			this.setColorAppareil(Color.green);
			this.setStringColorAppareil("green");
			}
		if (action == TypeActionAppareil.ETEINDRE) {
			this.etatAppareil = TypeEtatAppareil.ETEINT;
			this.setColorAppareil(Color.red);
			this.setStringColorAppareil("red");
		}
	}
	
	
}