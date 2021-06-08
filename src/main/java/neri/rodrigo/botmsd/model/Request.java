
package neri.rodrigo.botmsd.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "responseId",
    "session",
    "queryResult",
    "originalDetectIntentRequest"
})
@Generated("jsonschema2pojo")
public class Request {

    @JsonProperty("responseId")
    private String responseId;
    @JsonProperty("session")
    private String session;
    @JsonProperty("queryResult")
    private QueryResult queryResult;
    @JsonProperty("originalDetectIntentRequest")
    private OriginalDetectIntentRequest originalDetectIntentRequest;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("responseId")
    public String getResponseId() {
        return responseId;
    }

    @JsonProperty("responseId")
    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    @JsonProperty("session")
    public String getSession() {
        return session;
    }

    @JsonProperty("session")
    public void setSession(String session) {
        this.session = session;
    }

    @JsonProperty("queryResult")
    public QueryResult getQueryResult() {
        return queryResult;
    }

    @JsonProperty("queryResult")
    public void setQueryResult(QueryResult queryResult) {
        this.queryResult = queryResult;
    }

    @JsonProperty("originalDetectIntentRequest")
    public OriginalDetectIntentRequest getOriginalDetectIntentRequest() {
        return originalDetectIntentRequest;
    }

    @JsonProperty("originalDetectIntentRequest")
    public void setOriginalDetectIntentRequest(OriginalDetectIntentRequest originalDetectIntentRequest) {
        this.originalDetectIntentRequest = originalDetectIntentRequest;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
