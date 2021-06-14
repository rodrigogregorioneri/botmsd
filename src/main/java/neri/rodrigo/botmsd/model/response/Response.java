
package neri.rodrigo.botmsd.model.response;

import java.util.List;
import javax.annotation.Generated;


@Generated("jsonschema2pojo")
public class Response {


    private List<FulfillmentMessage> fulfillmentMessages;

    public List<FulfillmentMessage> getFulfillmentMessages() {
        return fulfillmentMessages;
    }

    public void setFulfillmentMessages(List<FulfillmentMessage> fulfillmentMessages) {
        this.fulfillmentMessages = fulfillmentMessages;
    }

}
