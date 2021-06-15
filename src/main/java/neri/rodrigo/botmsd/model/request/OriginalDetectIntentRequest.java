
package neri.rodrigo.botmsd.model.request;


public class OriginalDetectIntentRequest {


    private String source;

    private Payload payload;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

}
