package neri.rodrigo.botmsd.controller;


import com.fasterxml.jackson.databind.JsonNode;
import neri.rodrigo.botmsd.business.VendasBusiness;
import neri.rodrigo.botmsd.model.response.Response;
import neri.rodrigo.botmsd.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/vendas")
public class VendasController {


    @Autowired
    private VendasRepository vendasRepository;

    @Autowired
    private VendasBusiness vendasBusiness;

    @PostMapping("/vendasxcota")
    public Response getVendasXcota(@RequestBody JsonNode request){
        return vendasBusiness.getVendasXcota(request);
    }

    @PostMapping("/realizadoxcotaporvendedornomes")
    public Response getRealizadoXcotaPorVendedorNoMes(@RequestBody JsonNode request){
        return vendasBusiness.getRealizadoXcotaPorVendedorNoMes(request);
    }

    @PostMapping("/realizadoxcotafamiliaproduto")
    public Response getRealizadoXcotaFamiliaProduto(@RequestBody JsonNode request){
        return vendasBusiness.getRealizadoXcotaFamiliaProduto(request);
    }

    @PostMapping("/realizadoxcotaporprodutoevendedor")
    public Response getRealizadoXcotaPorProdutoEvendedor(@RequestBody JsonNode request){
        return vendasBusiness.getRealizadoXcotaPorProdutoEvendedor(request);
    }

    @PostMapping("/realizadoparaoclienteenumdeterminadoperiodo")
    public Response getRealizadoParaOclienteEnumDeterminadoPeriodo(@RequestBody JsonNode request){
        return vendasBusiness.getRealizadoParaOclienteEnumDeterminadoPeriodo(request);
    }



}
