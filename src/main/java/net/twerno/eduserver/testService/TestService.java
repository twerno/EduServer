package net.twerno.eduserver.testService;

import org.springframework.flex.remoting.RemotingDestination;

@RemotingDestination
public interface TestService {
	String helloWord();
}
