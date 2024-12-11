package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;


public class LogicsImpl implements Logics {

	private final int size;
	

	public LogicsImpl(int size) {
		this.size = size;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public List<Integer> values() {
		final List<Integer> value = new ArrayList<>(this.size());
		for ( int count = 0; count < this.size(); count++){
			value.set(count, count);
		}
		return value;
	}

	@Override
	public List<Boolean> enablings() {
		final List<Boolean> enable = new ArrayList<>(this.size());
		for (int count = 0; count < this.size(); count++){
			enable.set(count, true);
		}
		return enable;
	}

	@Override
	public int hit(int elem) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'hit'");
	}

	@Override
	public String result() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'result'");
	}

	@Override
	public boolean toQuit() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'toQuit'");
	}
}
