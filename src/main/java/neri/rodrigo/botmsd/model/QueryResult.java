
package neri.rodrigo.botmsd.model;

import java.util.HashMap;
import java.util.List;
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
    "queryText",
    "parameters",
    "allRequiredParamsPresent",
    "fulfillmentText",
    "fulfillmentMessages",
    "outputContexts",
    "intent",
    "intentDetectionConfidence",
    "diagnosticInfo",
    "languageCode"
})
@Generated("jsonschema2pojo")
public class QueryResult {

    @JsonProperty("queryText")
    private String queryText;
    @JsonProperty("parameters")
    private Parameters parameters;
    @JsonProperty("allRequiredParamsPresent")
    private Boolean allRequiredParamsPresent;
    @JsonProperty("fulfillmentText")
    private String fulfillmentText;
    @JsonProperty("fulfillmentMessages")
    private List<FulfillmentMessage> fulfillmentMessages = null;
    @JsonProperty("outputContexts")
    private List<OutputContext> outputContexts = null;
    @JsonProperty("intent")
    private Intent intent;
    @JsonProperty("intentDetectionConfidence")
    private Integer intentDetectionConfidence;
    @JsonProperty("diagnosticInfo")
    private DiagnosticInfo diagnosticInfo;
    @JsonProperty("languageCode")
    private String languageCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("queryText")
    public String getQueryText() {
        return queryText;
    }

    @JsonProperty("queryText")
    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    @JsonProperty("parameters")
    public Parameters getParameters() {
        return parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @JsonProperty("allRequiredParamsPresent")
    public Boolean getAllRequiredParamsPresent() {
        return allRequiredParamsPresent;
    }

    @JsonProperty("allRequiredParamsPresent")
    public void setAllRequiredParamsPresent(Boolean allRequiredParamsPresent) {
        this.allRequiredParamsPresent = allRequiredParamsPresent;
    }

    @JsonProperty("fulfillmentText")
    public String getFulfillmentText() {
        return fulfillmentText;
    }

    @JsonProperty("fulfillmentText")
    public void setFulfillmentText(String fulfillmentText) {
        this.fulfillmentText = fulfillmentText;
    }

    @JsonProperty("fulfillmentMessages")
    public List<FulfillmentMessage> getFulfillmentMessages() {
        return fulfillmentMessages;
    }

    @JsonProperty("fulfillmentMessages")
    public void setFulfillmentMessages(List<FulfillmentMessage> fulfillmentMessages) {
        this.fulfillmentMessages = fulfillmentMessages;
    }

    @JsonProperty("outputContexts")
    public List<OutputContext> getOutputContexts() {
        return outputContexts;
    }

    @JsonProperty("outputContexts")
    public void setOutputContexts(List<OutputContext> outputContexts) {
        this.outputContexts = outputContexts;
    }

    @JsonProperty("intent")
    public Intent getIntent() {
        return intent;
    }

    @JsonProperty("intent")
    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    @JsonProperty("intentDetectionConfidence")
    public Integer getIntentDetectionConfidence() {
        return intentDetectionConfidence;
    }

    @JsonProperty("intentDetectionConfidence")
    public void setIntentDetectionConfidence(Integer intentDetectionConfidence) {
        this.intentDetectionConfidence = intentDetectionConfidence;
    }

    @JsonProperty("diagnosticInfo")
    public DiagnosticInfo getDiagnosticInfo() {
        return diagnosticInfo;
    }

    @JsonProperty("diagnosticInfo")
    public void setDiagnosticInfo(DiagnosticInfo diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    @JsonProperty("languageCode")
    public String getLanguageCode() {
        return languageCode;
    }

    @JsonProperty("languageCode")
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
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
