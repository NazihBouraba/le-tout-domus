

import java.awt.Color;

public interface Observable {
	  public void addObserver(Observer obs);
	  public void removeObserver();
	  void notifyObserver(String sColor);	 
	  void notifyObserver(Color color);	
	}