

import java.util.ArrayList;

public class CEnsAppareil {
	String nomEnsAppareil;
	ArrayList<CAppareil> lAppareils;

	public CEnsAppareil(String nom)
	{	
		this.nomEnsAppareil = nom;
		this.lAppareils = new ArrayList<CAppareil>();
	}
	
	public void addAppareil(CAppareil appareil)
	{
	this.lAppareils.add(appareil);
	}
	
	public String getNomEnsAppareil()
	{return this.nomEnsAppareil;}
	
	public ArrayList<CAppareil> getLAppareils()
	{return this.lAppareils;}
	
	public String getStringLAppareils()
	{
		String liste="";
		for(CAppareil a : this.lAppareils)
			liste = liste+a.getNomAppareil()+", ";
		return liste;
	}
	
}