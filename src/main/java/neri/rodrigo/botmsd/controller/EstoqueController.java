package neri.rodrigo.botmsd.controller;

import com.fasterxml.jackson.databind.JsonNode;
import neri.rodrigo.botmsd.business.EstoqueBusiness;
import neri.rodrigo.botmsd.model.estoque.estoqueinfo.EstoqueInfoResponse;
import neri.rodrigo.botmsd.model.estoque.estoqueinfo.IEstoqueInfo;
import neri.rodrigo.botmsd.model.response.FulfillmentMessage;
import neri.rodrigo.botmsd.model.response.Response;
import neri.rodrigo.botmsd.model.response.Text;
import neri.rodrigo.botmsd.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


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

}
