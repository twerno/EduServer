package net.twerno.eduserver.testService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("testService")
public class TestServiceImpl implements TestService {

	@Override
	public String helloWorld() {
		return "hello world";
	}

	@Override
	public String sayHello(String name) {
		return "Hello "+name;
	}
}
