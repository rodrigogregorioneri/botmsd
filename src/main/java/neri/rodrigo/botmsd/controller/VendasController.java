package neri.rodrigo.botmsd.controller;


import com.fasterxml.jackson.databind.JsonNode;
import neri.rodrigo.botmsd.business.VendasBusiness;
import neri.rodrigo.botmsd.model.response.FulfillmentMessage;
import neri.rodrigo.botmsd.model.response.Response;
import neri.rodrigo.botmsd.model.response.Text;
import neri.rodrigo.botmsd.model.vendas.Vendas;
import neri.rodrigo.botmsd.model.vendas.vendasxcota.IVendasXcota;
import neri.rodrigo.botmsd.model.visitas.Visitas;
import neri.rodrigo.botmsd.repository.VendasRepository;
import neri.rodrigo.botmsd.repository.VisitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/vendas")
public class VendasController {


    @Autowired
    private VendasRepository vendasRepository;

    @Autowired
    private VendasBusiness vendasBusiness;


    @PostMapping("/vendas")
    public Response getVendas(@RequestBody JsonNode request){
        return vendasBusiness.getVendas(request);
    }

}
