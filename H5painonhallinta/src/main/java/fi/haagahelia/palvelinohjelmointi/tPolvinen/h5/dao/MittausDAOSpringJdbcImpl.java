package fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

//import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
//import fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.dao.MittaustaEiLoydyPoikkeus;
import fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.bean.Mittaus;

@Repository
public class MittausDAOSpringJdbcImpl implements MittausDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	
	/**
	 * Tallettaa parametrina annetun MITTAUKSEN tietokantaan. Tietokannan
	 * generoima id asetetaan parametrina annettuun olioon.
	 */
	public void talleta(Mittaus m) {
		final String sql = "INSERT INTO mittaukset(paino, pvm) values(?, CURDATE())";

		// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		// jotta roskien keruu onnistuu tämän metodin suorituksen päättyessä.
		final Double paino = m.getPaino();
	
		// jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan päivitys "itse" määritellyllä PreparedStatementCreatorilla
		// ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setDouble(1, paino);
//				ps.setDate(2, pvm);
				
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pitäisi olla viittaus samaiseen olioon
		m.setId(idHolder.getKey().intValue());

		
	}

	/**
	 * Haetaan päivämäärän perusteella valittujen mittausten tiedot
	 */
	public List<Mittaus> etsi(Date pvm) {
		String sql = "SELECT id, paino, pvm FROM mittaukset "
				+ "WHERE pvm = '" + pvm + "'";
		RowMapper<Mittaus> mapper = new MittausRowMapper();
		List<Mittaus> mittauslista = jdbcTemplate.query(sql, mapper);
	    
		return mittauslista;
	}

	/**
	 * Haetaan lista kaikista arvosteluista
	 */
	public List<Mittaus> haeKaikki() {

		String sql = "SELECT id, paino, pvm FROM mittaukset";
		RowMapper<Mittaus> mapper = new MittausRowMapper();
		List<Mittaus> mittauslista = jdbcTemplate.query(sql, mapper);

		return mittauslista;
	}

	
	
	
}
