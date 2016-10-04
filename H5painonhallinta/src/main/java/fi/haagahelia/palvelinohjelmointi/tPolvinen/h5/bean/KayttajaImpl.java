package fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.bean;

import javax.validation.constraints.Size;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")

public class KayttajaImpl implements Kayttaja {
	
	@Size(min = 1, max = 255)
	private String nimi;
	
	@Size(min = 1, max = 255)
	private String salasana;
	
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getSalasana() {
		return salasana;
	}
	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

}
