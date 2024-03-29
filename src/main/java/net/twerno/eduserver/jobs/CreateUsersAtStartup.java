package net.twerno.eduserver.jobs;
import net.twerno.eduserver.user.UserRole;
import net.twerno.eduserver.user.entity.Account;
import net.twerno.eduserver.user.entity.Grupa;
import net.twerno.eduserver.user.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class CreateUsersAtStartup implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserService userService;
	
    public void onApplicationEvent(ContextRefreshedEvent event) {
		 try {
			 userService.InternalRegisterUser("admin", "admin", UserRole.ROLE_ADMIN);
		 } catch (Exception e) {}

		 try {
			 userService.InternalRegisterUser("uczen", "uczen", UserRole.ROLE_UCZEN);
		 } catch (Exception e) {}

		 try {
			 userService.InternalRegisterUser("nauczyciel", "nauczyciel", UserRole.ROLE_NAUCZYCIEL);
		 } catch (Exception e) {}
		 
		 try {
			 Grupa grupa = new Grupa();
			 grupa.setNazwa("klasa 1a");
			 grupa.getAccounts().add(Account.findAccountsByUsernameEquals("admin").getSingleResult());
			 grupa.getAccounts().add(Account.findAccountsByUsernameEquals("uczen").getSingleResult());
			 grupa.getAccounts().add(Account.findAccountsByUsernameEquals("nauczyciel").getSingleResult());
			 grupa.merge();
		 } catch (Exception e) {}
    }   
}
