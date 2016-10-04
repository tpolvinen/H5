package fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.dao;

import java.sql.Date;
import java.util.List;

import fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.bean.Mittaus;

public interface MittausDAO {

	public abstract void talleta(Mittaus mittaus);

	public abstract List<Mittaus> etsi(Date pvm);

	public abstract List<Mittaus> haeKaikki();

}