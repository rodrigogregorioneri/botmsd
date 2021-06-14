package neri.rodrigo.botmsd.business;

import com.fasterxml.jackson.databind.JsonNode;
import neri.rodrigo.botmsd.model.estoque.estoqueinfo.EstoqueInfoResponse;
import neri.rodrigo.botmsd.model.estoque.estoqueinfo.IEstoqueInfo;
import neri.rodrigo.botmsd.model.response.FulfillmentMessage;
import neri.rodrigo.botmsd.model.response.Response;
import neri.rodrigo.botmsd.model.response.Text;
import neri.rodrigo.botmsd.model.vendas.vendasxcota.IVendasXcota;
import neri.rodrigo.botmsd.repository.EstoqueRepository;
import neri.rodrigo.botmsd.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueBusiness {

    @Autowired
    EstoqueRepository estoqueRepository;


    public Response getVendas(JsonNode request){
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Text text = new Text();
        List<String> textR = new ArrayList<>();
        for(IEstoqueInfo e :  getVendasXCota()){
            EstoqueInfoResponse estoqueInfoResponse = new EstoqueInfoResponse();
            estoqueInfoResponse.iResponseToResponseTest(e);
            textR.add(estoqueInfoResponse.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }


    public Response createResponse(List<FulfillmentMessage>fulfillmentMessageList,Response response,FulfillmentMessage fulfillmentMessage,Text text){
        fulfillmentMessage.setText(text);
        fulfillmentMessageList.add(fulfillmentMessage);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }

    public Page<IEstoqueInfo> getVendasXCota(){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IEstoqueInfo> estoque = estoqueRepository.buscaMarca2(firstPageWithTwoElements);
        return estoque;
    }

}
