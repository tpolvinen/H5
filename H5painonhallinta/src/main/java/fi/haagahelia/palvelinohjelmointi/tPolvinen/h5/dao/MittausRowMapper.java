package fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.bean.Mittaus;
import fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.bean.MittausImpl;


public class MittausRowMapper implements RowMapper<Mittaus> {

	public Mittaus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Mittaus m = new MittausImpl();
		m.setId(rs.getInt("id"));
		m.setPaino(rs.getDouble("paino"));
		m.setPvm(rs.getDate("pvm"));
		
		return m;
	}

}
