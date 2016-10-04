package fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.bean;

import java.sql.Date;

public interface Mittaus {
	
	public abstract int getId();
	public abstract void setId(int id);
	
	public abstract Double getPaino();
	public abstract void setPaino(Double paino);
	
	public abstract Date getPvm();
	public abstract void setPvm(Date pvm);

}
