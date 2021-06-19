package neri.rodrigo.botmsd.controller;

import com.fasterxml.jackson.databind.JsonNode;
import neri.rodrigo.botmsd.business.VisitasBusiness;
import neri.rodrigo.botmsd.model.request.Request;
import neri.rodrigo.botmsd.model.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/visitas")
public class VisitasController {

    @Autowired
    private VisitasBusiness visitasBusiness;

    @PostMapping("/vistasitentdois")
    public Response getVistasItentDois(@RequestBody Request request){
        return visitasBusiness.getVistasItentDois(request);
    }

    @PostMapping("/listadezclientessemvisitastrintadias")
    public Response getListaDezClientesSemVisitasTrintaDias(@RequestBody JsonNode request){
        return visitasBusiness.getListaDezClientesSemVisitasTrintaDias(request);
    }

}
