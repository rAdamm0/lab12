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

    @Override
    public boolean[][] values() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'values'");
    }

    @Override
    public int hit(int elem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hit'");
    }

    @Override
    public boolean toQuit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toQuit'");
    }

}
