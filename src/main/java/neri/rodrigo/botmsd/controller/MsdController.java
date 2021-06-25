package neri.rodrigo.botmsd.controller;


import neri.rodrigo.botmsd.business.AutenticacaoBusiness;
import neri.rodrigo.botmsd.business.EstoqueBusiness;
import neri.rodrigo.botmsd.business.VendasBusiness;
import neri.rodrigo.botmsd.business.VisitasBusiness;
import neri.rodrigo.botmsd.model.request.Request;
import neri.rodrigo.botmsd.model.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @Autowired
    private AutenticacaoBusiness autenticacaoBusiness;

    @Autowired
    private RestTemplate restTemplate;

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
        }else if(request.getQueryResult().getAction().equals("noticias")) {
            // intent 12
            return getNoticias().getBody();
        }else if(request.getQueryResult().getAction().equals("validar_relatorio")) {
            // intent 12
            return autenticacaoBusiness.autencar(request);
        } else{
            return new Response();
        }


    }







    public ResponseEntity<Response> getNoticias()
    {
        //TODO: Save employee details which will generate the employee id

        final String uri = "http://localhost:3000/noticias";
        RestTemplate restTemplate = new RestTemplate();
        Response newEmployee = new Response();
        //Build URI
        Response result = restTemplate.postForObject( uri, newEmployee, Response.class);
        return ResponseEntity.ok(result);
    }







}
