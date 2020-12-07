
import java.util.ArrayList;

public class CProgrammation {
		private String nomScenario;
		private ArrayList<CDate> listeDates; 

		public CProgrammation(String nom)
		{	
			this.nomScenario = nom;
			this.listeDates = new ArrayList<CDate>();
		}

		public void addDate(CDate d)
		{
			this.listeDates.add(d);
		}
		
		public String getNomScenario()
		{return this.nomScenario;}
		
		public ArrayList<CDate> getListeDates()
		{return this.listeDates;}
		
		public String getStringListeDates()
		{return this.listeDates.toString();}
	}
