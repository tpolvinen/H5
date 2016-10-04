package fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.dao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class MittaustaEiLoydyPoikkeus extends RuntimeException {

	public MittaustaEiLoydyPoikkeus(Exception cause) {
		super(cause);
	}
	
}