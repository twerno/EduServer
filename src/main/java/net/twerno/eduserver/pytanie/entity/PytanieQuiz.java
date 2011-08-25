package net.twerno.eduserver.pytanie.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findPytanieQuizesByZbiorPytan", 
                       "findPytanieQuizesByZbiorPytanAndUsuniety"})
public class PytanieQuiz {
	
	@NotNull
	private String trescPytania;
	
	@NotNull
	@OneToMany(cascade = CascadeType.ALL, mappedBy="pytanieQuiz")
	private Set<PytanieQuizOdpowiedz> odpowiedzi = new HashSet<PytanieQuizOdpowiedz>(); 
	
	@NotNull
	@ManyToOne
	private ZbiorPytan zbiorPytan;
	
	@NotNull
	private boolean usuniety;
	
    @Override
    public boolean equals(Object obj) {
    	if (obj instanceof PytanieQuiz)
    		return ((PytanieQuiz)obj).getId() == this.getId();
    	return super.equals(obj);
    }
}
