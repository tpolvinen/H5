package fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.bean;

import java.sql.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

public class MittausImpl implements Mittaus {
	
	private int id;
	
	@DecimalMax("300.0") @DecimalMin("10.0") 
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

