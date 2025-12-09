package it.unibo.es2;

import java.util.Arrays;

public class LogicsImpl implements Logics{

  private final int size;
  private final Boolean[][] matrix;

  public LogicsImpl(int size){
    this.size=size;
    this.matrix= new Boolean[size][size];
    for(Boolean[] a :matrix){
      Arrays.fill(a, false);
    }
  }

  @Override
  public String hit(Pair<Integer, Integer> pos) {
    if(pos.x()>=size || pos.y()>=size){
      throw new IllegalAccessError("Casella inesistente");
    }
    matrix[pos.x()][pos.y()] = !matrix[pos.x()][pos.y()];
    return matrix[pos.x()][pos.y()] ? "*" : "";
  }

  @Override
  public boolean toQuit(Pair<Integer, Integer> pos) {
    if(pos.x()>=size || pos.y()>=size){
      throw new IllegalAccessError("Casella inesistente");
    }
    int i = pos.x();
    int j = pos.y();
    
    boolean row = Arrays.stream(matrix[i]).allMatch(a -> a.equals(Boolean.TRUE));
    boolean column = Arrays.stream(matrix).map(x -> x[j]).allMatch(a -> a.equals(Boolean.TRUE));
    return row || column;
  }
  
}
