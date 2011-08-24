package net.twerno.eduserver.pytanie.entity;

import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class PytaniePosortuj {
	
	@NotNull
	private String stElement;
	
	@NotNull
	private String stKategoria;
	
	@NotNull
	private long zbiorPytanId;
}
