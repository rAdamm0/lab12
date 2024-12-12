package it.unibo.es2;

import java.util.Arrays;

public class LogicsImpl implements Logics{

    final int size;
    boolean[][] value;

    public LogicsImpl(int size){
        this.size = size;
    }
    @Override
    public int size() {
        return this.size;
    }

    private void matrixSet(int size){
        value = new boolean[size][size];
    }

    @Override
    public boolean[][] values() {
        if (this.value.length == 0){
            matrixSet(this.size());
        }
        return this.value;
    }

    @Override
    public boolean hit(Pair<Integer,Integer> elem) {
        if(elem.getX()<this.size() && elem.getY()<this.size){
            return this.values()[elem.getX()][elem.getY()] = this.values()[elem.getX()][elem.getY()] == true ? false : true;
        } 
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public boolean toQuit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toQuit'");
    }

}
