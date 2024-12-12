package it.unibo.es3;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;;

public class LogicsImpl implements Logics{

    final int size;
    boolean[][] enable;    
    List<Pair<Integer,Integer>> value = new ArrayList<>();

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
        if(this.enable == null){
            enableSetter();
        }
        return this.enable;
    }

    private void valueSetter(List<Pair<Integer,Integer>> temp){
        this.value = temp;
    }

    @Override
    public List<Pair<Integer, Integer>> values() {
        return this.value;
    }
    @Override
    public void hit() {
    final List<Pair<Integer,Integer>> tempValue = new ArrayList<>();
        int i, j;
        if (this.values().isEmpty()){
            /*
            * Generates randomly 3 stars  
            */
            for (int count = 3; count > 0; count --){
                Random ran = new Random();
                i=ran.nextInt(this.size());
                j=ran.nextInt(this.size());
                if (this.enabled()[i][j]){
                    count++;
                } 
                this.enabled()[i][j] = true;
                this.values().add(new Pair<Integer,Integer>(i,j));
            }
        } else {
            for (Pair<Integer,Integer> q : this.values()){
                /*
                 * Set the 3x3 around the Pair as true and add them to tempValues if they were false 
                 */
                for (int k = (int)q.getX()-1; k< (int)q.getX()+2; k++ ){
                    for (int l = (int)q.getY()-1; k< (int)q.getY()+2; l++){
                        if (k>0 && k < this.size() && l >0 && l<this.size()){
                            if(!enabled()[k][l]){
                                enabled()[k][l] = true;
                                tempValue.add(new Pair<Integer,Integer>(k, l));
                            }
                        }
                    }
                }
            }
        }
        
        valueSetter(tempValue);   
    }
    @Override
    public boolean toQuit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toQuit'");
    }

    

}
