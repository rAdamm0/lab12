package it.unibo.es3;

import java.util.ArrayList;
import java.util.List;

public class LogicsImpl implements Logics{

    final int size;
    boolean[][] enable;    
    final List<Pair<Integer,Integer>> value = new ArrayList<>();

    public LogicsImpl(int size) {
        this.size = size;
        this.enable = null;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void enableSetter(){
        this.enable = new boolean[this.size()][this.size()];
    }

    @Override
    public boolean[][] enabled() {
        if(this.value == null){
            enableSetter();
        }
        return this.enable;
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
