package bw.khpi.reqmit.des.model;

import java.util.LinkedList;
import java.util.List;

public class DOI {
	
	private List<DOIValue> eom = new LinkedList();
	private List<DOIValue> tom = new LinkedList();
	
	public List<DOIValue> getEom() {
		return eom;
	}
	public void setEom(List<DOIValue> eom) {
		this.eom = eom;
	}
	public List<DOIValue> getTom() {
		return tom;
	}
	public void setTom(List<DOIValue> tom) {
		this.tom = tom;
	}
	
	

}
