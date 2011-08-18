package net.twerno.eduserver.testService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("testService")
public class TestServiceImpl implements TestService {

	@Override
	public String helloWord() {
		return "hello world";
	}
}
