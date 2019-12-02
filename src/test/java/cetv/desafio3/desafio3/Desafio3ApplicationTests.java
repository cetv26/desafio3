package cetv.desafio3.desafio3;

import cetv.desafio3.desafio3.services.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Desafio3ApplicationTests {

	@Autowired
	TestService testService;

	@Test
	void test1Test() {
		assertEquals("test1",testService.test1());
	}


	@Test
	void test2Test() {
		assertEquals("test2",testService.test2());
	}

}
