package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;


public class LogicsImpl implements Logics {

	private final int size;
	private List<Integer> value;
	private List<Boolean> enable;
	

	public LogicsImpl(int size) {
		this.size = size;
		this.value = new ArrayList<>(size);
		this.enable = new ArrayList<>(size);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public List<Integer> values() {
		 if(this.value.isEmpty()){
			for (int count = 0; count < this.size(); count++){
				value.add(count);
			}
		 }
		return value;
	}

	@Override
	public List<Boolean> enablings() {
		 if(this.enable.isEmpty()){
			for (int count = 0; count < this.size(); count++){
				enable.add(true);
			}
		 }
		return enable;
	}

	@Override
	public int hit(int elem) {
		int temp = this.values().get(elem) + 1;
		this.values().set(elem, temp < this.size ? temp : 0);
		return this.values().get(elem);
	}

	@Override
	public String result() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'result'");
	}

	@Override
	public boolean toQuit() {
		while (values().iterator().hasNext() ) {
			if(!values().get(0).equals(values().iterator())){
				return false;
			}
		}
		return true;
	}
}
