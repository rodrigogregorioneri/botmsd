
package neri.rodrigo.botmsd.model.response;

import neri.rodrigo.botmsd.model.assistent.ExpectedInput;

import java.util.List;
import javax.annotation.Generated;


@Generated("jsonschema2pojo")
public class Response {


    private List<FulfillmentMessage> fulfillmentMessages;

    private Boolean expectUserResponse;

    private List<ExpectedInput> expectedInputs;

    public List<FulfillmentMessage> getFulfillmentMessages() {
        return fulfillmentMessages;
    }

    public void setFulfillmentMessages(List<FulfillmentMessage> fulfillmentMessages) {
        this.fulfillmentMessages = fulfillmentMessages;
    }

    public Boolean getExpectUserResponse() {
        return expectUserResponse;
    }

    public void setExpectUserResponse(Boolean expectUserResponse) {
        this.expectUserResponse = expectUserResponse;
    }

    public List<ExpectedInput> getExpectedInputs() {
        return expectedInputs;
    }

    public void setExpectedInputs(List<ExpectedInput> expectedInputs) {
        this.expectedInputs = expectedInputs;
    }
}
