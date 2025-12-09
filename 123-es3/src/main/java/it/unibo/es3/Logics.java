package it.unibo.es3;

public interface Logics {
  /**
   * Manages the behaviour of the data on hit
   */
  void hit();
  /**
   * 
   * @return a matrix with true for each button that needs to display "*", false otherwise
   */
  boolean[][] values();

  /**
   * 
   * @return true if all the values are true
   */
  boolean toQuit();
}
