package neri.rodrigo.botmsd.business;

import neri.rodrigo.botmsd.model.request.Request;
import neri.rodrigo.botmsd.model.response.FulfillmentMessage;
import neri.rodrigo.botmsd.model.response.Response;
import neri.rodrigo.botmsd.model.response.Text;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutenticacaoBusiness {
    public Response autencar(Request request) {
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Text text = new Text();
        List<String> textR = new ArrayList<>();

        text.setText(textR);
        if(request.getQueryResult().getParameters().getCodigo().equals("4198")){
                textR.add("Relatorio gerado com sucesso");
               return  createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        }else{
            textR.add("Você não possui acesso ao relatorio");
            return  createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        }

    }

    public Response createResponse(List<FulfillmentMessage> fulfillmentMessageList, Response response, FulfillmentMessage fulfillmentMessage, Text text){
        fulfillmentMessage.setText(text);
        fulfillmentMessageList.add(fulfillmentMessage);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }




}



