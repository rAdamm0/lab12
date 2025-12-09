package it.unibo.es2;


public interface Logics {
  /**
   * @pos position of the clicked button
   * @return a String to set as lable
   */
  public String hit(Pair<Integer, Integer> pos);

  /**
   * @return a true boolean if the ending position is reached, false otherwise
   */
  public boolean toQuit(Pair<Integer, Integer> pos);
  
} 