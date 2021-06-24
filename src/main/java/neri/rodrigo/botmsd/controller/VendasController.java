package neri.rodrigo.botmsd.controller;


import com.fasterxml.jackson.databind.JsonNode;
import neri.rodrigo.botmsd.business.VendasBusiness;
import neri.rodrigo.botmsd.model.request.Request;
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

//    @PostMapping("/vendasxcota")
//    public Response getVendasXcota(@RequestBody JsonNode request){
//        return vendasBusiness.getVendasXcota(request);
//    }
//
//    @PostMapping("/realizadoxcotaporvendedornomes")
//    public Response getRealizadoXcotaPorVendedorNoMes(@RequestBody JsonNode request){
//        return vendasBusiness.getRealizadoXcotaPorVendedorNoMes(request);
//    }
//
//    @PostMapping("/realizadoxcotafamiliaproduto")
//    public Response getRealizadoXcotaFamiliaProduto(@RequestBody JsonNode request){
//        return vendasBusiness.getRealizadoXcotaFamiliaProduto(request);
//    }
//
//    @PostMapping("/realizadoxcotaporprodutoevendedor")
//    public Response getRealizadoXcotaPorProdutoEvendedor(@RequestBody JsonNode request){
//        return vendasBusiness.getRealizadoXcotaPorProdutoEvendedor(request);
//    }
//
//    @PostMapping("/realizadoparaoclienteenumdeterminadoperiodo")
//    public Response getRealizadoParaOclienteEnumDeterminadoPeriodo(@RequestBody JsonNode request){
//        return vendasBusiness.getRealizadoParaOclienteEnumDeterminadoPeriodo(request);
//    }

    @PostMapping("/realizadofamiliaessemes")
    public Response getRealizadoFamiliaEsseMes(@RequestBody Request request) {
        return vendasBusiness.getRealizadoFamiliaEsseMes(request);
    }

    @PostMapping("/desempenhodevendasdogerenteyparaprodutox")
    public Response getDesempenhoDeVendasDoGerenteYparaProdutoX(@RequestBody Request request) {
        return vendasBusiness.getDesempenhoDeVendasDoGerenteYparaProdutoX(request);
    }

    @PostMapping("/realizadodocolaboradorxessemes")
    public Response getRealizadoDoColaboradorXesseMes(@RequestBody Request request) {
        return vendasBusiness.getRealizadoDoColaboradorXesseMes(request);
    }

    @PostMapping("/quantidadedevendastotalparacadacliente")
    public Response getQuantidadeDeVendasTotalParaCadaCliente(@RequestBody Request request) {
        return vendasBusiness.getQuantidadeDeVendasTotalParaCadaCliente(request);
    }

    @PostMapping("/somadevendasrealizadasparacadaclienteseumamesmaregional")
    public Response getSomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional(@RequestBody Request request) {
        return vendasBusiness.getSomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional(request);
    }

    @PostMapping("/itentCinco")
    public Response getItent5(@RequestBody Request request) {
        return vendasBusiness.getItent5(request);
    }

    @PostMapping("/itentSeis")
    public Response getItent6(@RequestBody Request request) {
        return vendasBusiness.getItent6(request);
    }

    @PostMapping("/itentNove")
    public Response getItent9(@RequestBody Request request) {
        return vendasBusiness.getItent9(request);
    }

    @PostMapping("/itentDez")
    public Response getItent10(@RequestBody JsonNode request) {
        return vendasBusiness.getItent10();
    }

}