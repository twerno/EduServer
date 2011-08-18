package net.twerno.eduserver.services;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
//@Service("testService")
public class TestServiceImpl implements TestService {

	@Override
	public String helloWord() {
		return "hello world";
	}
}
