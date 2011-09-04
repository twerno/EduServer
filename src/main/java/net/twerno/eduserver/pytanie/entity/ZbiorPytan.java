package net.twerno.eduserver.pytanie.entity;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import net.twerno.eduserver.zadanie.TypZadania;

import org.hibernate.annotations.Index;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findZbiorPytansByAutorAndUsuniety", "findZbiorPytansByIsPublicAndUsuniety" })
public class ZbiorPytan {

	@Id
//	wartoœæ trzeba podaæ rêcznie
//	@GeneratedValue(generator="uuid")
//	@GenericGenerator(name="uuid", strategy="uuid")
	private String id;

    @NotNull
    private TypZadania typZadania;

    @NotNull
    private String opis;

    @NotNull
    private String przedmiot;

    @NotNull
    @Index(name="ZbiorPytanAutorId_index")
    private String autorId;

    @NotNull
    private boolean isPublic;

    @NotNull
    private boolean usuniety;
    
    @NotNull
    private int size;
}
