package neri.rodrigo.botmsd.business;

import com.fasterxml.jackson.databind.JsonNode;
import neri.rodrigo.botmsd.model.assistent.*;
import neri.rodrigo.botmsd.model.estoque.estoqueinfo.EstoqueInfoResponse;
import neri.rodrigo.botmsd.model.estoque.estoqueinfo.IEstoqueInfo;
import neri.rodrigo.botmsd.model.request.Request;
import neri.rodrigo.botmsd.model.response.FulfillmentMessage;
import neri.rodrigo.botmsd.model.response.Response;
import neri.rodrigo.botmsd.model.response.Text;
import neri.rodrigo.botmsd.model.vendas.desempenhodevendasdogerenteyparaprodutox.DesempenhoDeVendasDoGerenteYparaProdutoX;
import neri.rodrigo.botmsd.model.vendas.desempenhodevendasdogerenteyparaprodutox.IDesempenhoDeVendasDoGerenteYparaProdutoX;
import neri.rodrigo.botmsd.model.vendas.itentcinco.IItent5;
import neri.rodrigo.botmsd.model.vendas.itentcinco.Itent5;
import neri.rodrigo.botmsd.model.vendas.itentdez.IItent10;
import neri.rodrigo.botmsd.model.vendas.itentdez.Itent10;
import neri.rodrigo.botmsd.model.vendas.itentnove.IItent9;
import neri.rodrigo.botmsd.model.vendas.itentnove.Itent9;
import neri.rodrigo.botmsd.model.vendas.itentquatro.IItent4;
import neri.rodrigo.botmsd.model.vendas.itentquatro.Itent4;
import neri.rodrigo.botmsd.model.vendas.itentseis.IItent6;
import neri.rodrigo.botmsd.model.vendas.itentseis.Itent6;
import neri.rodrigo.botmsd.model.vendas.quantidadedevendastotaiparacadacliente.IQuantidadeDeVendasTotalParaCadaCliente;
import neri.rodrigo.botmsd.model.vendas.quantidadedevendastotaiparacadacliente.QuantidadeDeVendasTotalParaCadaCliente;
import neri.rodrigo.botmsd.model.vendas.realizadodocolaboradorxessemes.IRealizadoDoColaboradorXesseMes;
import neri.rodrigo.botmsd.model.vendas.realizadodocolaboradorxessemes.RealizadoDoColaboradorXesseMes;
import neri.rodrigo.botmsd.model.vendas.realizadofamiliaessemes.IRealizadoFamiliaEsseMes;
import neri.rodrigo.botmsd.model.vendas.realizadofamiliaessemes.RealizadoFamiliaEsseMes;
import neri.rodrigo.botmsd.model.vendas.realizadoparaoclienteenumdeterminadoperiodo.IRealizadoParaOclienteEnumDeterminadoPeriodo;
import neri.rodrigo.botmsd.model.vendas.realizadoparaoclienteenumdeterminadoperiodo.RealizadoParaOclienteEnumDeterminadoPeriodo;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotafamiliaproduto.IRealizadoXcotaFamiliaProduto;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotafamiliaproduto.RealizadoXcotaFamiliaProduto;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotaporprodutoevendedor.IRealizadoXcotaPorProdutoEvendedor;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotaporprodutoevendedor.RealizadoXcotaPorProdutoEvendedor;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotaporvendedornomes.IRealizadoXcotaPorVendedorNoMes;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotaporvendedornomes.RealizadoXcotaPorVendedorNoMes;
import neri.rodrigo.botmsd.model.vendas.somadevendasrealizadasparacadaclienteseumamesmaregional.ISomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional;
import neri.rodrigo.botmsd.model.vendas.somadevendasrealizadasparacadaclienteseumamesmaregional.SomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional;
import neri.rodrigo.botmsd.model.vendas.vendasxcota.IVendasXcota;
import neri.rodrigo.botmsd.model.vendas.vendasxcota.VendasXestoqueResponse;
import neri.rodrigo.botmsd.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendasBusiness {

    @Autowired
    private VendasRepository vendasRepository;


    public Response getVendas(Request request){
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Text text = new Text();
        List<String> textR = new ArrayList<>();
        String vendedor = request.getQueryResult().getParameters().getVendedor();
        String cliente = request.getQueryResult().getParameters().getCliente();
        for(IItent9 e :  getVendasXCota(vendedor, cliente)){
            Itent9 estoqueInfoResponse = new Itent9();
            estoqueInfoResponse.convert(e);
            textR.add(estoqueInfoResponse.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }

    public Page<IItent9> getVendasXCota(String vendedor,  String cliente){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IItent9> estoque = vendasRepository.itent9(vendedor, cliente, firstPageWithTwoElements);
        return estoque;
    }

    public Response getItent5(Request request){
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Text text = new Text();
        List<String> textR = new ArrayList<>();

        String regional = request.getQueryResult().getParameters().getRegional();
        for(IItent5 e :  getItent5(regional)){
            Itent5 estoqueInfoResponse = new Itent5();
            estoqueInfoResponse.convert(e);
            textR.add(estoqueInfoResponse.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
}

    public Page<IItent5> getItent5(String regional){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IItent5> estoque = vendasRepository.itent5(regional, firstPageWithTwoElements);
        return estoque;
    }

    public Response getItent6(Request request){
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Text text = new Text();
        List<String> textR = new ArrayList<>();
        String produto = request.getQueryResult().getParameters().getProduto();

        for(IItent6 e :  getitent6(produto)){
            Itent6 estoqueInfoResponse = new Itent6();
            estoqueInfoResponse.convert(e);
            textR.add(estoqueInfoResponse.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }

    public Page<IItent6> getitent6(String produto){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IItent6> estoque = vendasRepository.itent6(produto, firstPageWithTwoElements);
        return estoque;
    }



    public Response getItent9(Request request){
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Text text = new Text();
        List<String> textR = new ArrayList<>();
        String vendedor = request.getQueryResult().getParameters().getVendedor();
        String cliente = request.getQueryResult().getParameters().getCliente();
        for(IItent9 e :  getitent9(vendedor, cliente)){
            Itent9 estoqueInfoResponse = new Itent9();
            estoqueInfoResponse.convert(e);
            textR.add(estoqueInfoResponse.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }

    public Page<IItent9> getitent9(String vendedor,  String cliente){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IItent9> estoque = vendasRepository.itent9(vendedor, cliente, firstPageWithTwoElements);
        return estoque;
    }



    public Response getItent10(){
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Text text = new Text();
        List<String> textR = new ArrayList<>();
        for(IItent10 e :  getitent10()){
            Itent10 estoqueInfoResponse = new Itent10();
            estoqueInfoResponse.convert(e);
            textR.add(estoqueInfoResponse.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }

    public Page<IItent10> getitent10(){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IItent10> estoque = vendasRepository.itent10(firstPageWithTwoElements);
        return estoque;
    }






    public Response getSomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional(Request request){
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        Text text = new Text();
        String regional = request.getQueryResult().getParameters().getRegional();
        List<String> textR = new ArrayList<>();
        for(ISomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional e :  somaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional("REGIONAL "+regional)){
            SomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional somaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional = new SomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional();
            somaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional.convert(e);
            textR.add(somaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }


    public Page<ISomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional> somaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional(String regional){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<ISomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional> somaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional =   vendasRepository.somaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional(regional,firstPageWithTwoElements);
        return somaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional;
    }


    public Response getQuantidadeDeVendasTotalParaCadaCliente(Request request){
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        Text text = new Text();
        String vendedor = request.getQueryResult().getParameters().getVendedor();
        String cliente = request.getQueryResult().getParameters().getCliente();
        List<String> textR = new ArrayList<>();
        for(IQuantidadeDeVendasTotalParaCadaCliente e :  quantidadeDeVendasTotalParaCadaCliente(vendedor, cliente)){
            QuantidadeDeVendasTotalParaCadaCliente realizadoDoColaboradorXesseMesResponse = new QuantidadeDeVendasTotalParaCadaCliente();
            realizadoDoColaboradorXesseMesResponse.convert(e);
            textR.add(realizadoDoColaboradorXesseMesResponse.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }


    public Page<IQuantidadeDeVendasTotalParaCadaCliente> quantidadeDeVendasTotalParaCadaCliente(String vendedor, String cliente){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IQuantidadeDeVendasTotalParaCadaCliente> vendasXcota =   vendasRepository.quantidadeDeVendasTotalParaCadaCliente(vendedor,cliente,firstPageWithTwoElements);
        return vendasXcota;
    }

    public Response getRealizadoDoColaboradorXesseMes(Request request){
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        Text text = new Text();
        String vendedor = request.getQueryResult().getParameters().getVendedor();
        List<String> textR = new ArrayList<>();
        for(IRealizadoDoColaboradorXesseMes e :  realizadoDoColaboradorXesseMes(vendedor)){
            RealizadoDoColaboradorXesseMes realizadoDoColaboradorXesseMesResponse = new RealizadoDoColaboradorXesseMes();
            realizadoDoColaboradorXesseMesResponse.convert(e);
            textR.add(realizadoDoColaboradorXesseMesResponse.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }


    public Page<IRealizadoDoColaboradorXesseMes>realizadoDoColaboradorXesseMes(String vendedor){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IRealizadoDoColaboradorXesseMes> vendasXcota =   vendasRepository.realizadoDoColaboradorXesseMes(vendedor,firstPageWithTwoElements);
        return vendasXcota;
    }






    public Response getIntent4(Request request){
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        Text text = new Text();
        String produto = request.getQueryResult().getParameters().getProduto();
        List<String> textR = new ArrayList<>();
        for(IItent4 e :  intent4(produto)){
            Itent4 realizadoFamiliaEsseMesResponse = new Itent4();
            realizadoFamiliaEsseMesResponse.convert(e);
            textR.add(realizadoFamiliaEsseMesResponse.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }


    public Page<IItent4>intent4(String produto){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IItent4> vendasXcota =   vendasRepository.itent4(produto,firstPageWithTwoElements);
        return vendasXcota;
    }












    public Response getRealizadoFamiliaEsseMes(Request request){
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        Text text = new Text();
        String familia_produto = request.getQueryResult().getParameters().getNomeFamiliaProduto();
        List<String> textR = new ArrayList<>();
        for(IRealizadoFamiliaEsseMes e :  realizadoFamiliaEsseMes(familia_produto)){
            RealizadoFamiliaEsseMes realizadoFamiliaEsseMesResponse = new RealizadoFamiliaEsseMes();
            realizadoFamiliaEsseMesResponse.convert(e);
            textR.add(realizadoFamiliaEsseMesResponse.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }


    public Page<IRealizadoFamiliaEsseMes>realizadoFamiliaEsseMes(String familiaproduto){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IRealizadoFamiliaEsseMes> vendasXcota =   vendasRepository.realizadoFamiliaEsseMes(familiaproduto,firstPageWithTwoElements);
        return vendasXcota;
    }

    public Response getDesempenhoDeVendasDoGerenteYparaProdutoX(Request request){
        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
        Response response = new Response();
        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
        Text text = new Text();
        String vendedor = request.getQueryResult().getParameters().getVendedor();
        String produto = request.getQueryResult().getParameters().getProdutos();
        List<String> textR = new ArrayList<>();
        for(IDesempenhoDeVendasDoGerenteYparaProdutoX e :  desempenhoDeVendasDoGerenteYparaProdutoX(vendedor,produto)){
            DesempenhoDeVendasDoGerenteYparaProdutoX desempenhoDeVendasDoGerenteYparaProdutoXResponse = new DesempenhoDeVendasDoGerenteYparaProdutoX();
            desempenhoDeVendasDoGerenteYparaProdutoXResponse.convert(e);
            textR.add(desempenhoDeVendasDoGerenteYparaProdutoXResponse.toString());
            text.setText(textR);
        }
        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
        response.setFulfillmentMessages(fulfillmentMessageList);
        return response;
    }


    public Page<IDesempenhoDeVendasDoGerenteYparaProdutoX>desempenhoDeVendasDoGerenteYparaProdutoX(String vendedor,String produto){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        Page<IDesempenhoDeVendasDoGerenteYparaProdutoX> vendasXcota =   vendasRepository.desempenhoDeVendasDoGerenteYparaProdutoX(vendedor,produto,firstPageWithTwoElements);
        return vendasXcota;
    }






//    // VENDASXCOTAS
//
//    public Response getVendasXcota(JsonNode request){
//        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
//        Response response = new Response();
//        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
//        Text text = new Text();
//
//        List<String> textR = new ArrayList<>();
//        for(IVendasXcota e :  vendasXcota()){
//            VendasXestoqueResponse vendasXestoqueResponse = new VendasXestoqueResponse();
//            vendasXestoqueResponse.iVendasXcotaToVendasXestoqueResponse(e);
//            textR.add(vendasXestoqueResponse.toString());
//            text.setText(textR);
//        }
//        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
//        response.setFulfillmentMessages(fulfillmentMessageList);
//        return response;
//    }
//
//
//    public Page<IVendasXcota> vendasXcota(){
//        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
//        Page<IVendasXcota> vendasXcota =   vendasRepository.vendasXcota(firstPageWithTwoElements);
//        return vendasXcota;
//    }
//
//    // realizadoXcotaFamiliaProduto
//
//    public Response getRealizadoXcotaFamiliaProduto(JsonNode request){
//        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
//        Response response = new Response();
//        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
//        Text text = new Text();
//
//        List<String> textR = new ArrayList<>();
//        for(IRealizadoXcotaFamiliaProduto e :  realizadoXcotaFamiliaProduto()){
//            RealizadoXcotaFamiliaProduto realizadoXcotaFamiliaProduto = new RealizadoXcotaFamiliaProduto();
//            realizadoXcotaFamiliaProduto.iResponseToResponseTest(e);
//            textR.add(realizadoXcotaFamiliaProduto.toString());
//            text.setText(textR);
//        }
//        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
//        response.setFulfillmentMessages(fulfillmentMessageList);
//        return response;
//    }
//
//
//    public Page<IRealizadoXcotaFamiliaProduto> realizadoXcotaFamiliaProduto(){
//        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
//        Page<IRealizadoXcotaFamiliaProduto> realizadoXcotaFamiliaProduto =   vendasRepository.realizadoXcotaFamiliaProduto(firstPageWithTwoElements);
//        return realizadoXcotaFamiliaProduto;
//    }
//
//    // realizadoXcotaPorProdutoEvendedor
//
//    public Response getRealizadoXcotaPorProdutoEvendedor(JsonNode request){
//        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
//        Response response = new Response();
//        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
//        Text text = new Text();
//
//        List<String> textR = new ArrayList<>();
//        for(IRealizadoXcotaPorProdutoEvendedor e :  realizadoXcotaPorProdutoEvendedor()){
//            RealizadoXcotaPorProdutoEvendedor realizadoXcotaPorProdutoEvendedor = new RealizadoXcotaPorProdutoEvendedor();
//            realizadoXcotaPorProdutoEvendedor.iResponseToResponseTest(e);
//            textR.add(realizadoXcotaPorProdutoEvendedor.toString());
//            text.setText(textR);
//        }
//        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
//        response.setFulfillmentMessages(fulfillmentMessageList);
//        return response;
//    }
//
//    public Page<IRealizadoXcotaPorProdutoEvendedor> realizadoXcotaPorProdutoEvendedor(){
//        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
//        Page<IRealizadoXcotaPorProdutoEvendedor> realizadoXcotaPorProdutoEvendedor =   vendasRepository.realizadoXcotaPorProdutoEvendedor(firstPageWithTwoElements);
//        return realizadoXcotaPorProdutoEvendedor;
//    }
//
//    // realizadoXcotaPorVendedorNoMes
//
//    public Response getRealizadoXcotaPorVendedorNoMes(JsonNode request){
//        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
//        Response response = new Response();
//        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
//        Text text = new Text();
//
//        List<String> textR = new ArrayList<>();
//        for(IRealizadoXcotaPorVendedorNoMes e :  realizadoXcotaPorVendedorNoMes()){
//            RealizadoXcotaPorVendedorNoMes realizadoXcotaPorVendedorNoMes = new RealizadoXcotaPorVendedorNoMes();
//            realizadoXcotaPorVendedorNoMes.iResponseToResponseTest(e);
//            textR.add(realizadoXcotaPorVendedorNoMes.toString());
//            text.setText(textR);
//        }
//        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
//        response.setFulfillmentMessages(fulfillmentMessageList);
//        return response;
//    }
//
//
//    public Page<IRealizadoXcotaPorVendedorNoMes> realizadoXcotaPorVendedorNoMes(){
//        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
//        Page<IRealizadoXcotaPorVendedorNoMes> realizadoXcotaPorVendedorNoMes =   vendasRepository.realizadoXcotaPorVendedorNoMes(firstPageWithTwoElements);
//        return realizadoXcotaPorVendedorNoMes;
//    }
//
//    // realizadoParaOclienteEmUmDeterminadoPeriodo
//
//    public Response getRealizadoParaOclienteEnumDeterminadoPeriodo(JsonNode request){
//        List<FulfillmentMessage> fulfillmentMessageList = new ArrayList<FulfillmentMessage>();
//        Response response = new Response();
//        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();
//        Text text = new Text();
//
//        List<String> textR = new ArrayList<>();
//        for(IRealizadoParaOclienteEnumDeterminadoPeriodo e :  realizadoParaOclienteEmUmDeterminadoPeriodo()){
//            RealizadoParaOclienteEnumDeterminadoPeriodo realizadoParaOclienteEnumDeterminadoPeriodo = new RealizadoParaOclienteEnumDeterminadoPeriodo();
//            realizadoParaOclienteEnumDeterminadoPeriodo.iResponseToResponseTest(e);
//            textR.add(realizadoParaOclienteEnumDeterminadoPeriodo.toString());
//            text.setText(textR);
//        }
//        createResponse(fulfillmentMessageList, response,fulfillmentMessage, text);
//        response.setFulfillmentMessages(fulfillmentMessageList);
//        return response;
//    }
//
//    public Page<IRealizadoParaOclienteEnumDeterminadoPeriodo> realizadoParaOclienteEmUmDeterminadoPeriodo(){
//        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
//        Page<IRealizadoParaOclienteEnumDeterminadoPeriodo> realizadoParaOclienteEmUmDeterminadoPeriodo =   vendasRepository.realizadoParaOclienteEmUmDeterminadoPeriodo(firstPageWithTwoElements);
//        return realizadoParaOclienteEmUmDeterminadoPeriodo;
//    }
//
//    // CRIA OBJETO DE RESPOSTA
//
public Response createResponse(List<FulfillmentMessage> fulfillmentMessageList, Response response, FulfillmentMessage fulfillmentMessage, Text text){
    fulfillmentMessage.setText(text);
    fulfillmentMessageList.add(fulfillmentMessage);
    response.setFulfillmentMessages(fulfillmentMessageList);
    List<ExpectedInput> expectedInputList = new ArrayList<ExpectedInput>();
    ExpectedInput expectedInput = new ExpectedInput();
    List<PossibleIntent> possibleIntentsList = new ArrayList<PossibleIntent>();
    PossibleIntent possibleIntent = new PossibleIntent();
//    possibleIntent.setIntent("actions.intent.TEXT");
//    possibleIntentsList.add(possibleIntent);
    expectedInput.setPossibleIntents(possibleIntentsList);
    InputPrompt inputPrompt = new InputPrompt();
    RichInitialPrompt richInitialPrompt = new RichInitialPrompt();

    SimpleResponse simpleResponse = new SimpleResponse();
    List<String> tex = text.getText();
    if(tex != null){
        simpleResponse.setTextToSpeech(tex.get(0));
    }

    Item item = new Item();
    item.setSimpleResponse(simpleResponse);
    List<Item> items = new ArrayList<Item>();
    items.add(item);
    richInitialPrompt.setItems(items);
    inputPrompt.setRichInitialPrompt(richInitialPrompt);
    expectedInput.setInputPrompt(inputPrompt);
    expectedInputList.add(expectedInput);
    response.setExpectUserResponse(true);
    response.setExpectedInputs(expectedInputList);



    return response;
}

}
