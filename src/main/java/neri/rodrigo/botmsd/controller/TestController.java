package neri.rodrigo.botmsd.controller;
import com.fasterxml.jackson.databind.JsonNode;
import neri.rodrigo.botmsd.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/campeonato")
public class TestController {

    @PostMapping("/nome")
    public String getName(@RequestBody JsonNode request){
        System.out.println(request);
        return "Neri";
    }
}
