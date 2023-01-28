package rafael.ejercicio.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TestController {


    @GetMapping("Test")
    public String testMethod(){
        return "Funcionando con normalidad";
    }



}
