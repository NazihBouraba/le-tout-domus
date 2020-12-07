import java.util.ArrayList;

public class HabitatSpecific extends Habitat {

	public HabitatSpecific(ArrayList<CAppareil> lapp, ArrayList<CEnsAppareil> lens, ArrayList<CScenario> lscen, 
			ArrayList<CInterface> lint, ArrayList<CProgrammation> lprog)
	{	
		super(lapp,lens,lscen,lint,lprog);
	}
	
	public void execScenarioNum(int num)  //*********** Methode a remplir par projet compilation (switch)
	{
		System.out.println( "Execution du scenario "+this.l_scenarios.get(num).getNomScenario()+"... ");

		// code a generer par projet compil 
		
		switch(num) {
		  case 0: // Scenario 1
		      // ... 
		     break;

		  case 1: // Scenario 2
			  // ...
		    break;
		    
		    // etc...
		  default:
		}
	}
}
