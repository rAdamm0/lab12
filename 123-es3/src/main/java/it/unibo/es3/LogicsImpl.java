package it.unibo.es3;

import java.util.List;

public class LogicsImpl implements Logics{

    final int size;
    boolean[][] value;    

    public LogicsImpl(int size) {
        this.size = size;
        this.value = null;
    }

    @Override
    public int size() {
        return this.size;
    }
    @Override
    public boolean[][] enabled() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enabled'");
    }
    @Override
    public <X, Y> List<Pair<X, Y>> values() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'values'");
    }
    @Override
    public void hit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hit'");
    }
    @Override
    public boolean toQuit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toQuit'");
    }

    

}
