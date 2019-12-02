package cetv.desafio3.desafio3.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cetv.desafio3.desafio3.services.TestService;
import cetv.desafio3.desafio3.model.TestRespuesta;
@RestController
public class Desafio3Controller {

    @Autowired
    TestService testService;

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String Test()  {

        return "hello 12347999 XD";
    }

    @RequestMapping(value="/test1", method = {RequestMethod.GET,RequestMethod.POST})
    public TestRespuesta Test1()  {

        return testService.test1();
    }

    @RequestMapping(value="/test2", method = {RequestMethod.GET,RequestMethod.POST})
    public TestRespuesta Test2()  {

        return testService.test2();
    }

}
