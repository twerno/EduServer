package net.twerno.eduserver.zadanezadanie.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import net.twerno.eduserver.user.entities.Grupa;
import net.twerno.eduserver.zadanie.entities.Zadanie;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class ZadaneZadanie {

	@NotNull 
	private boolean obowiazkowe;

	@NotNull 
	private Date dtOd;

	@NotNull 
	private Date dtDo;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Grupa> grupy = new HashSet<Grupa>();

	private Zadanie zadanie;
}
