package fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.bean;

import java.sql.Date;

public class MittausImpl implements Mittaus {
	
	private int id;
	private Double paino;
	private Date pvm;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getPaino() {
		return paino;
	}
	public void setPaino(Double paino) {
		this.paino = paino;
	}
	public Date getPvm() {
		return pvm;
	}
	public void setPvm(Date pvm) {
		this.pvm = pvm;
	}
	@Override
	public String toString() {
		return "MittausImpl [id=" + id + ", paino=" + paino + ", pvm=" + pvm
				+ "]";
	}

}	

