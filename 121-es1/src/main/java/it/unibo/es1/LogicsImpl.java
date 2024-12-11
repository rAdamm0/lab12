package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class LogicsImpl implements Logics {

	private final int size;
	private List<Integer> value;
	private List<Boolean> enable;

	private final String IN = "<<";
	private final String END = ">>";
	private final String MID = "|";
	

	public LogicsImpl(int size) {
		this.size = size;
		this.value = null;
		this.enable = null;
	}

	@Override
	public int size() {
		return this.size;
	}

	private <T> List<T> setter(T defaultValue){
		final List<T> temp = new ArrayList<>(this.size());
		for (int count = 0; count < this.size(); count++){
			temp.add(defaultValue);
		}
		return temp;
	}

	@Override
	public List<Integer> values() {
		 if(this.value == null){
			this.value = this.setter(0);
		 }
		return value;
	}

	@Override
	public List<Boolean> enablings() {
		 if(this.enable == null){
			this.enable = this.setter(true);
		 }
		return enable;
	}

	@Override
	public int hit(int elem) {
		int temp = this.values().get(elem) + 1;
		if(temp == this.size()){
			temp = this.size();
			this.enablings().set(elem, false);
		}
		this.values().set(elem, temp);
		return this.values().get(elem);
	}

	@Override
	public String result() {
		return IN + values().stream().map(Object :: toString).collect(Collectors.joining(MID)) + END;
	}

	@Override
	public boolean toQuit() {
		if(values().stream().distinct().map(a -> 1).count() != 1){
			return false;
		}
		for(int count = 0; count < this.size(); count++){
			this.enablings().set(count, false);
		}
		return true;
	}
}
