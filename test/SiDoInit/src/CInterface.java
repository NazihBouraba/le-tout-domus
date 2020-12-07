

import java.util.ArrayList;

public class CInterface {
	private String nomInterface;
	private TypeInterface typeInterface;
	private ArrayList<String> scenariosAssocies; 
	
	public CInterface(String nom, TypeInterface typeInt)
	{	
		this.nomInterface = nom;
		this.typeInterface = typeInt;
		this.scenariosAssocies = new ArrayList<String>();
	}

	public void addScenarioAssocie(String nomScenario)
	{
	this.scenariosAssocies.add(nomScenario);
	}
	
	public String getNomInterface()
	{return this.nomInterface;}

	public TypeInterface getTypeInterface()
	{return this.typeInterface;}
	
	public  ArrayList<String> getScenariosAssocies()
	{
		return this.scenariosAssocies;
	}
	
	public String getStringScenariosAssocies()
	{
		String liste="";
		for(String scenario : this.scenariosAssocies)
			liste = liste+scenario+", ";
		return liste;
	}
}
