package it.unibo.es2;


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
        if (this.value == null ){
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
    public boolean toQuit(Pair<Integer,Integer> elem){
        int i = 0, j = 0;
        while (i < this.size() && j < this.size() && (this.values()[elem.getX()][j] || this.values()[i][elem.getY()])) {
            i++;
            j++;  
        }
        if(i == 4){
            return true;
        }
        return false;
    }

}
