package cetv.desafio3.desafio3.services;
import cetv.desafio3.desafio3.model.TestRespuesta;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public TestRespuesta test1(){
        TestRespuesta test = new TestRespuesta();
        test.setCodigo("1");
        test.setMensaje("test1");
        return test;
    }

    public TestRespuesta test2(){
        TestRespuesta test = new TestRespuesta();
        test.setCodigo("2");
        test.setMensaje("test2");
        return test;
    }

}
