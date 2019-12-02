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
	void test1Testa() {
		assertEquals("test1",testService.test1().getMensaje());
	}

	@Test
	void test1Testb() {
		assertEquals("1",testService.test1().getCodigo());
	}

	@Test
	void test2Testa() {
		assertEquals("test2",testService.test2().getMensaje());
	}

	@Test
	void test2Testb() {
		assertEquals("2",testService.test2().getCodigo());
	}

}
