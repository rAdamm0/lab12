package it.unibo.es2;

public interface Logics {
	
	/**
	 * @return the number of buttons (except Print)
	 */
	int size();
	
	/**
	 * @return if a value has been clicked or not 
	 */
	boolean [][] values();
	
	/**
	 * @return the new value a button should show after being pressed
	 */
	boolean hit(Pair<Integer,Integer> elem);
	
	/**
	 * @return whether it is time to quit
	 */
	boolean toQuit(Pair<Integer,Integer> elem);
}


