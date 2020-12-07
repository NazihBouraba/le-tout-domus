

import java.util.ArrayList;

public class CScenario {
	private String nomScenario;
	private String contenuScenario;

	public CScenario(String nom, String contenu)
	{	
		this.nomScenario = nom;
		this.contenuScenario = contenu;
	}

	public String getNomScenario()
	{return this.nomScenario;}
	
	public String getStringContenuScenario()
	{return this.contenuScenario;}
	
	public void execScenario(ArrayList<CAppareil> lappareils)
	{ System.out.println( "Execution du scenario "+this.getNomScenario()+"... "); }
}
