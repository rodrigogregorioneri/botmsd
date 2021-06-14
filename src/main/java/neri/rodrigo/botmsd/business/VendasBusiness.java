package neri.rodrigo.botmsd.business;

import com.fasterxml.jackson.databind.JsonNode;
import neri.rodrigo.botmsd.model.response.FulfillmentMessage;
import neri.rodrigo.botmsd.model.response.Response;
import neri.rodrigo.botmsd.model.response.Text;
import neri.rodrigo.botmsd.model.vendas.realizadoparaoclienteenumdeterminadoperiodo.IRealizadoParaOclienteEnumDeterminadoPeriodo;
import neri.rodrigo.botmsd.model.vendas.realizadoparaoclienteenumdeterminadoperiodo.RealizadoParaOclienteEnumDeterminadoPeriodo;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotafamiliaproduto.IRealizadoXcotaFamiliaProduto;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotafamiliaproduto.RealizadoXcotaFamiliaProduto;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotaporprodutoevendedor.IRealizadoXcotaPorProdutoEvendedor;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotaporprodutoevendedor.RealizadoXcotaPorProdutoEvendedor;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotaporvendedornomes.IRealizadoXcotaPorVendedorNoMes;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotaporvendedornomes.RealizadoXcotaPorVendedorNoMes;
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




    // VENDASXCOTAS

    public Response getVendasXcota(JsonNode request){
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        Text text = new Text();

        List<String> textR = new ArrayList<>();
        for(IVendasXcota e :  vendasXcota()){
            VendasXestoqueResponse vendasXestoqueResponse = new VendasXestoqueResponse();
            vendasXestoqueResponse.iVendasXcotaToVendasXestoqueResponse(e);
            textR.add(vendasXestoqueResponse.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }


    public Page<IVendasXcota> vendasXcota(){
        Pageable firstPageWithTwoElements = PageRequest.of(-1, 10);
        Page<IVendasXcota> vendasXcota =   vendasRepository.vendasXcota(firstPageWithTwoElements);
        return vendasXcota;
    }

    // realizadoXcotaFamiliaProduto

    public Response getRealizadoXcotaFamiliaProduto(JsonNode request){
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        Text text = new Text();

        List<String> textR = new ArrayList<>();
        for(IRealizadoXcotaFamiliaProduto e :  realizadoXcotaFamiliaProduto()){
            RealizadoXcotaFamiliaProduto realizadoXcotaFamiliaProduto = new RealizadoXcotaFamiliaProduto();
            realizadoXcotaFamiliaProduto.iResponseToResponseTest(e);
            textR.add(realizadoXcotaFamiliaProduto.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }


    public Page<IRealizadoXcotaFamiliaProduto> realizadoXcotaFamiliaProduto(){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IRealizadoXcotaFamiliaProduto> realizadoXcotaFamiliaProduto =   vendasRepository.realizadoXcotaFamiliaProduto(firstPageWithTwoElements);
        return realizadoXcotaFamiliaProduto;
    }

    // realizadoXcotaPorProdutoEvendedor

    public Response getRealizadoXcotaPorProdutoEvendedor(JsonNode request){
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        Text text = new Text();

        List<String> textR = new ArrayList<>();
        for(IRealizadoXcotaPorProdutoEvendedor e :  realizadoXcotaPorProdutoEvendedor()){
            RealizadoXcotaPorProdutoEvendedor realizadoXcotaPorProdutoEvendedor = new RealizadoXcotaPorProdutoEvendedor();
            realizadoXcotaPorProdutoEvendedor.iResponseToResponseTest(e);
            textR.add(realizadoXcotaPorProdutoEvendedor.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }

    public Page<IRealizadoXcotaPorProdutoEvendedor> realizadoXcotaPorProdutoEvendedor(){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IRealizadoXcotaPorProdutoEvendedor> realizadoXcotaPorProdutoEvendedor =   vendasRepository.realizadoXcotaPorProdutoEvendedor(firstPageWithTwoElements);
        return realizadoXcotaPorProdutoEvendedor;
    }

    // realizadoXcotaPorVendedorNoMes

    public Response getRealizadoXcotaPorVendedorNoMes(JsonNode request){
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        Text text = new Text();

        List<String> textR = new ArrayList<>();
        for(IRealizadoXcotaPorVendedorNoMes e :  realizadoXcotaPorVendedorNoMes()){
            RealizadoXcotaPorVendedorNoMes realizadoXcotaPorVendedorNoMes = new RealizadoXcotaPorVendedorNoMes();
            realizadoXcotaPorVendedorNoMes.iResponseToResponseTest(e);
            textR.add(realizadoXcotaPorVendedorNoMes.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }


    public Page<IRealizadoXcotaPorVendedorNoMes> realizadoXcotaPorVendedorNoMes(){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IRealizadoXcotaPorVendedorNoMes> realizadoXcotaPorVendedorNoMes =   vendasRepository.realizadoXcotaPorVendedorNoMes(firstPageWithTwoElements);
        return realizadoXcotaPorVendedorNoMes;
    }

    // realizadoParaOclienteEmUmDeterminadoPeriodo

    public Response getRealizadoParaOclienteEnumDeterminadoPeriodo(JsonNode request){
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        Text text = new Text();

        List<String> textR = new ArrayList<>();
        for(IRealizadoParaOclienteEnumDeterminadoPeriodo e :  realizadoParaOclienteEmUmDeterminadoPeriodo()){
            RealizadoParaOclienteEnumDeterminadoPeriodo realizadoParaOclienteEnumDeterminadoPeriodo = new RealizadoParaOclienteEnumDeterminadoPeriodo();
            realizadoParaOclienteEnumDeterminadoPeriodo.iResponseToResponseTest(e);
            textR.add(realizadoParaOclienteEnumDeterminadoPeriodo.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }

    public Page<IRealizadoParaOclienteEnumDeterminadoPeriodo> realizadoParaOclienteEmUmDeterminadoPeriodo(){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IRealizadoParaOclienteEnumDeterminadoPeriodo> realizadoParaOclienteEmUmDeterminadoPeriodo =   vendasRepository.realizadoParaOclienteEmUmDeterminadoPeriodo(firstPageWithTwoElements);
        return realizadoParaOclienteEmUmDeterminadoPeriodo;
    }

    // CRIA OBJETO DE RESPOSTA

    public Response createResponse(List<FulfillmentMessage>fulfillmentMessageList,Response response,FulfillmentMessage fulfillmentMessage,Text text){
        fulfillmentMessageList.add(fulfillmentMessage);
        fulfillmentMessage.setText(text);
        return response;
    }

}
