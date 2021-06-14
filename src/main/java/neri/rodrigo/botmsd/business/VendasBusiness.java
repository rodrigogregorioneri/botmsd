package neri.rodrigo.botmsd.business;

import com.fasterxml.jackson.databind.JsonNode;
import neri.rodrigo.botmsd.model.estoque.estoqueinfo.EstoqueInfoResponse;
import neri.rodrigo.botmsd.model.response.FulfillmentMessage;
import neri.rodrigo.botmsd.model.response.Response;
import neri.rodrigo.botmsd.model.response.Text;
import neri.rodrigo.botmsd.model.vendas.vendasxcota.IVendasXcota;
import neri.rodrigo.botmsd.model.vendas.vendasxcota.VendasXestoqueResponse;
import neri.rodrigo.botmsd.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendasBusiness {

    @Autowired
    private VendasRepository vendasRepository;

    public Response getVendas(JsonNode request){
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        Text text = new Text();

        List<String> textR = new ArrayList<>();
        for(IVendasXcota e :  getVendasXCota()){
            VendasXestoqueResponse vendasXestoqueResponse = new VendasXestoqueResponse();
            vendasXestoqueResponse.iVendasXcotaToVendasXestoqueResponse(e);
            textR.add(vendasXestoqueResponse.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }


    public Response createResponse(List<FulfillmentMessage>fulfillmentMessageList,Response response,FulfillmentMessage fulfillmentMessage,Text text){
        fulfillmentMessageList.add(fulfillmentMessage);
        fulfillmentMessage.setText(text);
        return response;
    }

    public Page<IVendasXcota> getVendasXCota(){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IVendasXcota> vendasXcota =   vendasRepository.vendasXcota(firstPageWithTwoElements);
        return vendasXcota;
    }

}
