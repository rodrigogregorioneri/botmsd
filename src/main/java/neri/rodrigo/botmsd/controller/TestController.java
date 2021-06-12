package neri.rodrigo.botmsd.controller;
import com.fasterxml.jackson.databind.JsonNode;
import neri.rodrigo.botmsd.model.*;
import neri.rodrigo.botmsd.repository.EstoqueRepository;
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
@RequestMapping("/v1/campeonato")
public class TestController {

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    VendasRepository vendasRepository;

    @Autowired
    VisitasRepository visitasRepository;

    @PostMapping("/visitas")
    public Response getVisitas(@RequestBody JsonNode request){
        System.out.println(request);
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        visitasRepository.findAll().forEach(e ->{
        });
        List<Visitas> estoque =   visitasRepository.findAll();
        Text text = new Text();
        List<String> textR = new ArrayList<>();
        for(Visitas e :   estoque){
            textR.add(e.getVendedor());
            text.setText(textR);
        }
        fulfillmentMessage.setText(text);
        fulfillmentMessageList.add(fulfillmentMessage);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }



    @PostMapping("/vendas")
    public Response getVendas(@RequestBody JsonNode request){
        System.out.println(request);
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        vendasRepository.findAll().forEach(e ->{
        });
        List<Vendas> estoque =   vendasRepository.findAll();
        Text text = new Text();
        List<String> textR = new ArrayList<>();
        for(Vendas e :   estoque){
            textR.add(e.getCliente());
            text.setText(textR);
        }
        fulfillmentMessage.setText(text);
        fulfillmentMessageList.add(fulfillmentMessage);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }

    @PostMapping("/estoque")
    public Response getName(@RequestBody JsonNode request){
        System.out.println(request);
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        estoqueRepository.findAll().forEach(e ->{
        });

        String marca = "CALMINEX";

        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        List<IResponse> estoque = estoqueRepository.buscaMarca2(firstPageWithTwoElements);
        Text text = new Text();
        List<String> textR = new ArrayList<>();
        for(IResponse e :   estoque){
            ResponseTest responseTest = new ResponseTest();
            responseTest.iResponseToResponseTest(e);
            textR.add(responseTest.toString());
            text.setText(textR);
        }
        fulfillmentMessage.setText(text);
        fulfillmentMessageList.add(fulfillmentMessage);
        response.setFulfillmentMessages(fulfillmentMessageList);
    return response;
    }
}
