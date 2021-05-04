
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "matchExpressions"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class ScopeSelector implements KubernetesResource
{

    @JsonProperty("matchExpressions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ScopedResourceSelectorRequirement> matchExpressions = new ArrayList<ScopedResourceSelectorRequirement>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ScopeSelector() {
    }

    /**
     * 
     * @param matchExpressions
     */
    public ScopeSelector(List<ScopedResourceSelectorRequirement> matchExpressions) {
        super();
        this.matchExpressions = matchExpressions;
    }

    @JsonProperty("matchExpressions")
    public List<ScopedResourceSelectorRequirement> getMatchExpressions() {
        return matchExpressions;
    }

    @JsonProperty("matchExpressions")
    public void setMatchExpressions(List<ScopedResourceSelectorRequirement> matchExpressions) {
        this.matchExpressions = matchExpressions;
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
