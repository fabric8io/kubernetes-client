
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "hard",
    "scopeSelector",
    "scopes"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class ResourceQuotaSpec implements KubernetesResource
{

    @JsonProperty("hard")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> hard = new LinkedHashMap<String, Quantity>();
    @JsonProperty("scopeSelector")
    private ScopeSelector scopeSelector;
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> scopes = new ArrayList<java.lang.String>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResourceQuotaSpec() {
    }

    public ResourceQuotaSpec(Map<String, Quantity> hard, ScopeSelector scopeSelector, List<java.lang.String> scopes) {
        super();
        this.hard = hard;
        this.scopeSelector = scopeSelector;
        this.scopes = scopes;
    }

    @JsonProperty("hard")
    public Map<String, Quantity> getHard() {
        return hard;
    }

    @JsonProperty("hard")
    public void setHard(Map<String, Quantity> hard) {
        this.hard = hard;
    }

    @JsonProperty("scopeSelector")
    public ScopeSelector getScopeSelector() {
        return scopeSelector;
    }

    @JsonProperty("scopeSelector")
    public void setScopeSelector(ScopeSelector scopeSelector) {
        this.scopeSelector = scopeSelector;
    }

    @JsonProperty("scopes")
    public List<java.lang.String> getScopes() {
        return scopes;
    }

    @JsonProperty("scopes")
    public void setScopes(List<java.lang.String> scopes) {
        this.scopes = scopes;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
