package neri.rodrigo.botmsd.business;

import com.fasterxml.jackson.databind.JsonNode;
import neri.rodrigo.botmsd.model.estoque.buscatotalestoqueporproduto.ITotalEstoquePorProduto;
import neri.rodrigo.botmsd.model.estoque.buscatotalestoqueporproduto.TotalEstoquePorProduto;
import neri.rodrigo.botmsd.model.request.Request;
import neri.rodrigo.botmsd.model.response.FulfillmentMessage;
import neri.rodrigo.botmsd.model.response.Response;
import neri.rodrigo.botmsd.model.response.Text;
import neri.rodrigo.botmsd.model.visitas.listadzclientessemvisitastrintadias.IListaDezClientesSemVisitasTrintaDias;
import neri.rodrigo.botmsd.model.visitas.listadzclientessemvisitastrintadias.ListaDezClientesSemVisitasTrintaDias;
import neri.rodrigo.botmsd.model.visitas.visitasitentdois.IVistasItentDois;
import neri.rodrigo.botmsd.model.visitas.visitasitentdois.VistasItentDois;
import neri.rodrigo.botmsd.repository.VisitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitasBusiness {

    @Autowired
    private VisitasRepository visitasRepository;


    public Response getVistasItentDois(Request request){
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Text text = new Text();
        List<String> textR = new ArrayList<>();
        String reg = request.getQueryResult().getParameters().getRegional();

        System.out.println(request.getQueryResult().getParameters());

        for(IVistasItentDois e :  getVistasItentDois(reg)){
            VistasItentDois estoqueInfoResponse = new VistasItentDois();
            estoqueInfoResponse.convert(e);
            textR.add(estoqueInfoResponse.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }

    public Page<IVistasItentDois> getVistasItentDois(String regional){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        return visitasRepository.intent2(regional, firstPageWithTwoElements);
    }


    public Response getListaDezClientesSemVisitasTrintaDias(JsonNode request){
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Text text = new Text();
        List<String> textR = new ArrayList<>();
        for(IListaDezClientesSemVisitasTrintaDias e :  getListaDezClientesSemVisitasTrintaDias()){
            ListaDezClientesSemVisitasTrintaDias estoqueInfoResponse = new ListaDezClientesSemVisitasTrintaDias();
            estoqueInfoResponse.convert(e);
            textR.add(estoqueInfoResponse.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }

    public Page<IListaDezClientesSemVisitasTrintaDias> getListaDezClientesSemVisitasTrintaDias(){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        return visitasRepository.listaDezClientesSemVisitasTrintaDias(firstPageWithTwoElements);
    }


    public Response createResponse(List<FulfillmentMessage> fulfillmentMessageList, Response response, FulfillmentMessage fulfillmentMessage, Text text){
        fulfillmentMessage.setText(text);
        fulfillmentMessageList.add(fulfillmentMessage);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }
}
