
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
    "matchExpressions",
    "matchLabels"
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
public class LabelSelector implements KubernetesResource
{

    @JsonProperty("matchExpressions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LabelSelectorRequirement> matchExpressions = new ArrayList<LabelSelectorRequirement>();
    @JsonProperty("matchLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> matchLabels = new LinkedHashMap<String, String>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LabelSelector() {
    }

    public LabelSelector(List<LabelSelectorRequirement> matchExpressions, Map<String, String> matchLabels) {
        super();
        this.matchExpressions = matchExpressions;
        this.matchLabels = matchLabels;
    }

    @JsonProperty("matchExpressions")
    public List<LabelSelectorRequirement> getMatchExpressions() {
        return matchExpressions;
    }

    @JsonProperty("matchExpressions")
    public void setMatchExpressions(List<LabelSelectorRequirement> matchExpressions) {
        this.matchExpressions = matchExpressions;
    }

    @JsonProperty("matchLabels")
    public Map<String, String> getMatchLabels() {
        return matchLabels;
    }

    @JsonProperty("matchLabels")
    public void setMatchLabels(Map<String, String> matchLabels) {
        this.matchLabels = matchLabels;
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
