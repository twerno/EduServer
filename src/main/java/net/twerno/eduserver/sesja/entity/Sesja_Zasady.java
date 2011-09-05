package net.twerno.eduserver.sesja.entity;

import java.util.UUID;

import javax.persistence.Id;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class Sesja_Zasady {
	@Id
	private String id = UUID.randomUUID().toString();
	
	private boolean czas_bronze;
	
	private boolean czas_silver;
	
	private boolean czas_gold;
	
	private boolean bezblednie;
	
	private boolean punkty_bronze;
	
	private boolean punkty_silver;
	
	private boolean punkty_gold;
	
	private boolean ukonczone;
}