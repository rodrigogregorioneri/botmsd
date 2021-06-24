package neri.rodrigo.botmsd.controller;


import neri.rodrigo.botmsd.model.assistent.*;
import neri.rodrigo.botmsd.model.request.Request;
import neri.rodrigo.botmsd.model.response.FulfillmentMessage;
import neri.rodrigo.botmsd.model.response.Response;
import neri.rodrigo.botmsd.model.response.Text;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/msdassisntent")
public class MsdAssistentController {

    @PostMapping("/intent")
    public ResponseAssistent getName(@RequestBody Request request){
        if(request.getQueryResult().getAction().equals("assistente")){
            ResponseAssistent responseAssistent = new ResponseAssistent();
            //intent 1

            return  createResponse();
        }else {
            return new ResponseAssistent();
        }
    }



    public ResponseAssistent createResponse(){
        ResponseAssistent response = new ResponseAssistent();
        List<ExpectedInput> expectedInputList = new ArrayList<ExpectedInput>();
        ExpectedInput expectedInput = new ExpectedInput();
        List<PossibleIntent> possibleIntentsList = new ArrayList<PossibleIntent>();
        PossibleIntent possibleIntent = new PossibleIntent();
        possibleIntent.setIntent("actions.intent.TEXT");
        possibleIntentsList.add(possibleIntent);
        expectedInput.setPossibleIntents(possibleIntentsList);
        InputPrompt inputPrompt = new InputPrompt();
        RichInitialPrompt richInitialPrompt = new RichInitialPrompt();

        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setTextToSpeech("Teste Rodrigo Neri");
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
