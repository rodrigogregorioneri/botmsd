package neri.rodrigo.botmsd.controller;


import neri.rodrigo.botmsd.business.EstoqueBusiness;
import neri.rodrigo.botmsd.business.VendasBusiness;
import neri.rodrigo.botmsd.business.VisitasBusiness;
import neri.rodrigo.botmsd.model.request.Request;
import neri.rodrigo.botmsd.model.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/msd")
public class MsdController {

    @Autowired
    private EstoqueBusiness estoqueBusiness;

    @Autowired
    private VendasBusiness vendasBusiness;

    @Autowired
    private VisitasBusiness visitasBusiness;


    @PostMapping("/intent")
    public Response getName(@RequestBody Request request){


        if(request.getQueryResult().getAction().equals("totalestoqueporproduto")){
            //intent 1
            return estoqueBusiness.getTotalEstoquePorProduto(request);
        }else if(request.getQueryResult().getAction().equals("intent2")){
            // intent 2
            return visitasBusiness.getVistasItentDois(request);
        }else if(request.getQueryResult().getAction().equals("intent3")){
            // intent 3
            return vendasBusiness.getDesempenhoDeVendasDoGerenteYparaProdutoX(request);
        }else if(request.getQueryResult().getAction().equals("intent4")){
            //intent 4
            return vendasBusiness.getIntent4(request);
        }else if(request.getQueryResult().getAction().equals("intent5")){
            // intent 5
            return vendasBusiness.getItent5(request);
        }else if(request.getQueryResult().getAction().equals("intent6")){
            // intent 6
            return vendasBusiness.getItent6(request);
        }else if(request.getQueryResult().getAction().equals("intent7")){
            // intent 7
            return vendasBusiness.getRealizadoDoColaboradorXesseMes(request);
        }else if(request.getQueryResult().getAction().equals("intent8")){
            // intent 8
            return vendasBusiness.getRealizadoFamiliaEsseMes(request);
        }else if(request.getQueryResult().getAction().equals("intent9")){
            // intent 9
            return vendasBusiness.getItent9(request);
        }else if(request.getQueryResult().getAction().equals("intent10")){
            // intent 10
            return vendasBusiness.getItent10();
        }else if(request.getQueryResult().getAction().equals("intent11")){
            // intent 11
            return vendasBusiness.getQuantidadeDeVendasTotalParaCadaCliente(request);
        }else if(request.getQueryResult().getAction().equals("intent12")){
            // intent 12
            return vendasBusiness.getSomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional(request);
        }else{
            return new Response();
        }


    }







}
