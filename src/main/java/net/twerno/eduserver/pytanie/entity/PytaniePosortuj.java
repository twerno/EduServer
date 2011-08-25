package net.twerno.eduserver.pytanie.entity;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findPytaniePosortujsByZbiorPytan", 
		               "findPytaniePosortujsByZbiorPytanAndUsuniety"})
public class PytaniePosortuj {

    @NotNull
    private String stElement;

    @NotNull
    private String stKategoria;

    @NotNull
    @ManyToOne
    private ZbiorPytan zbiorPytan;
    
	@NotNull
	private boolean usuniety;
    
    @Override
    public boolean equals(Object obj) {
    	if (obj instanceof PytaniePosortuj)
    		return ((PytaniePosortuj)obj).getId() == this.getId();
    	return super.equals(obj);
    }
}
