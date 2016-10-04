package fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.bean.Kayttaja;
import fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.bean.KayttajaImpl;
import fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.bean.Mittaus;
import fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.bean.MittausImpl;
import fi.haagahelia.palvelinohjelmointi.tPolvinen.h5.dao.MittausDAO;


@Controller
@RequestMapping (value="/mittaukset")
public class MittausController {

	@Inject
	private MittausDAO dao;
	
	public MittausDAO getDao() {
		return dao;
	}
	
	public void setDao(MittausDAO dao) {
		this.dao = dao;
	}
	
	//KÄYTTÄJÄN KIRJAUTUMISEN FORMIN LUONTI
		@RequestMapping(value="uusikirjautuminen", method=RequestMethod.GET)
		public String getKirjautuminen(Model model) {
			KayttajaImpl tyhjaKayttaja = new KayttajaImpl();
			model.addAttribute("kayttaja", tyhjaKayttaja);
			return "mitta/kirjautuminen";
		}
		
		//KÄYTTÄJÄN KIRJAUTUMISEN FORMIN TIETOJEN VASTAANOTTO
		@RequestMapping(value="uusikirjautuminen", method=RequestMethod.POST)
		public String createKayttaja( @ModelAttribute(value="kayttaja") @Valid KayttajaImpl kayttaja,  BindingResult result) {
			
			final String nimi = "Otto";
			final String salaisuus = "opettaja";
			
			if (result.hasErrors()) {
				return "mitta/kirjautuminen";
			} else if (kayttaja.getNimi().equals(nimi) && kayttaja.getSalasana().equals(salaisuus)) {
				return "redirect:/mittaukset/lista";
			} else {
				return "mitta/kirjautuminen";
			}
		}
		
		//KAIKKIEN TIETOJEN NÄYTTÄMINEN
		@RequestMapping(value="/lista", method=RequestMethod.GET)
		public String naytaKaikki(@ModelAttribute(value="uusimittaus") MittausImpl mittaus, Model model) {
			List <Mittaus> mittauslista = dao.haeKaikki();
			model.addAttribute("mittauslista", mittauslista);
			return "mitta/lista";
		}
		
		//MITTAUSFORMIN TEKEMINEN
		@RequestMapping(value="uusimittaus", method=RequestMethod.GET)
		public String getMittaus(Model model) { 
			Mittaus tyhjamittaus = new MittausImpl();
			model.addAttribute("mittaus", tyhjamittaus);
			return "mitta/mittaus";
		}
		
		//MITTAUSFORMIN TIETOJEN VASTAANOTTO
		@RequestMapping(value="uusimittaus", method=RequestMethod.POST)
		public String createMittaus(@ModelAttribute(value="mittaus") MittausImpl mittaus, Model model) {
					dao.talleta(mittaus);
					return "redirect:/mittaukset/lista";
			}
}
