package neri.rodrigo.botmsd.controller;

import com.fasterxml.jackson.databind.JsonNode;
import neri.rodrigo.botmsd.business.EstoqueBusiness;
import neri.rodrigo.botmsd.model.request.Request;
import neri.rodrigo.botmsd.model.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueBusiness estoqueBusiness;

    @PostMapping("/estoque")
    public Response getName(@RequestBody JsonNode request){
        return estoqueBusiness.getVendas(request);
    }

    @PostMapping("/totalestoqueporproduto")
    public Response getName(@RequestBody Request request){
        return estoqueBusiness.getTotalEstoquePorProduto(request);
    }



}
