package it.unibo.es3;

import java.util.List;

public interface Logics {
	
	/**
	 * @return the number of buttons (except Print)
	 */
	int size();

    /**
	 * @return if a value has been clicked or not 
	 */
    boolean [][] enabled();
	
	/**
	 * @return a List of the last Pairs turned to true 
	 */
	List<Pair<Integer,Integer>> values();
	
	/**
	 * @return the new value a button should show after being pressed
	 */
	void hit();
	
	/**
	 * @return whether it is time to quit
	 */
	boolean toQuit();
}


