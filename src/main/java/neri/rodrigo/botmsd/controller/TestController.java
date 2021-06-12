package neri.rodrigo.botmsd.controller;
import com.fasterxml.jackson.databind.JsonNode;
import neri.rodrigo.botmsd.model.EstoqueModel;
import neri.rodrigo.botmsd.model.FulfillmentMessage;
import neri.rodrigo.botmsd.model.Response;
import neri.rodrigo.botmsd.model.Text;
import neri.rodrigo.botmsd.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/campeonato")
public class TestController {

//    @Autowired
//    EstoqueRepository estoqueRepository;



    @PostMapping("/nome")
    public Response getName(@RequestBody JsonNode request){
        System.out.println(request);
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();

//
//        estoqueRepository.findAll().forEach(e ->{
//
//        });

        Text text = new Text();
        List<String> textR = new ArrayList<>();
//        System.out.println(e.getMarca());
        textR.add("Nina");
        text.setText(textR);
        fulfillmentMessage.setText(text);
        fulfillmentMessageList.add(fulfillmentMessage);
        response.setFulfillmentMessages(fulfillmentMessageList);



    return response;

    }
}
