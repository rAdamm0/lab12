package it.unibo.es3;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class LogicsImpl implements Logics {

  private final int STARTING_NUM = 3;
  boolean[][] values;
  List<Pair<Integer, Integer>> lastValues;
  int size;

  public LogicsImpl(int size) {
    this.size = size;
    this.values = new boolean[size][size];
    for (boolean[] row : this.values) {
      Arrays.fill(row, false);
    }
    this.lastValues = new ArrayList<>();
    this.lastValues.addAll(randPairs(STARTING_NUM));
  }

  @Override
  public void hit() {
    List<Pair<Integer, Integer>> toBeChecked = new ArrayList<>();
    for (Pair<Integer, Integer> pair : lastValues) {
      toBeChecked.addAll(getAroundPositions(pair));
    }
    lastValues.clear();
    for (Pair<Integer, Integer> pair : toBeChecked) {
      if (!values[pair.x()][pair.y()]) {
        lastValues.add(pair);
        values[pair.x()][pair.y()] = true;
      }
    }
  }

  @Override
  public boolean[][] values() {
    return this.values.clone();
  }

  @Override
  public boolean toQuit() {
    return Arrays.stream(values)
        .allMatch(row -> {
          for (boolean c : row) {
            if (!c)
              return false;
          }
          return true;
        });
  }

  private List<Pair<Integer, Integer>> getAroundPositions(Pair<Integer, Integer> pos) {
    List<Pair<Integer, Integer>> positions = new ArrayList<>();
    for (int i = pos.x() - 1; i < pos.x() + 2; i++) {
      for (int j = pos.y() - 1; j < pos.y() + 2; j++) {
        if (!outOfBound(i, j) && !values[i][j]) {
          positions.add(new Pair<>(i, j));
        }
      }
    }
    return positions;
  }

  private boolean outOfBound(Integer x, Integer y) {
    return x >= this.size || x < 0 || y >= this.size || y < 0;
  }

  private List<Pair<Integer, Integer>> randPairs(int n) {
    List<Pair<Integer, Integer>> temp = new ArrayList<>();
    Random rand = new Random();
    for (int i = 0; i < n; i++) {
      temp.add(new Pair<>(rand.nextInt(this.size), rand.nextInt(this.size)));
      values[temp.get(i).x()][temp.get(i).y()] = true;
    }
    return temp;
  }
}
