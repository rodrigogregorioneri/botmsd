
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
    "name",
    "lifespanCount",
    "parameters"
})
@Generated("jsonschema2pojo")
public class OutputContext {

    @JsonProperty("name")
    private String name;
    @JsonProperty("lifespanCount")
    private Integer lifespanCount;
    @JsonProperty("parameters")
    private Parameters__1 parameters;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("lifespanCount")
    public Integer getLifespanCount() {
        return lifespanCount;
    }

    @JsonProperty("lifespanCount")
    public void setLifespanCount(Integer lifespanCount) {
        this.lifespanCount = lifespanCount;
    }

    @JsonProperty("parameters")
    public Parameters__1 getParameters() {
        return parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(Parameters__1 parameters) {
        this.parameters = parameters;
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
