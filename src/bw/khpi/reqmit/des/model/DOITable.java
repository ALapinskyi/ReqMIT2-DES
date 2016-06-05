package bw.khpi.reqmit.des.model;

public class DOITable {
	
	private String fileName;
	private String eom;
	private String tom;
	
	public DOITable(String fileName, String eom, String tom) {
		super();
		this.fileName = fileName;
		this.eom = eom;
		this.tom = tom;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getEom() {
		return eom;
	}
	public void setEom(String eom) {
		this.eom = eom;
	}
	public String getTom() {
		return tom;
	}
	public void setTom(String tom) {
		this.tom = tom;
	}
	
	

}
