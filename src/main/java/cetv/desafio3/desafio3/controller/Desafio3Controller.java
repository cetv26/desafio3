package cetv.desafio3.desafio3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Desafio3Controller {
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String Test()  {

        return "hello 1";
    }

}
