
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
    "matchFields"
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
public class NodeSelectorTerm implements KubernetesResource
{

    @JsonProperty("matchExpressions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeSelectorRequirement> matchExpressions = new ArrayList<NodeSelectorRequirement>();
    @JsonProperty("matchFields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeSelectorRequirement> matchFields = new ArrayList<NodeSelectorRequirement>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NodeSelectorTerm() {
    }

    public NodeSelectorTerm(List<NodeSelectorRequirement> matchExpressions, List<NodeSelectorRequirement> matchFields) {
        super();
        this.matchExpressions = matchExpressions;
        this.matchFields = matchFields;
    }

    @JsonProperty("matchExpressions")
    public List<NodeSelectorRequirement> getMatchExpressions() {
        return matchExpressions;
    }

    @JsonProperty("matchExpressions")
    public void setMatchExpressions(List<NodeSelectorRequirement> matchExpressions) {
        this.matchExpressions = matchExpressions;
    }

    @JsonProperty("matchFields")
    public List<NodeSelectorRequirement> getMatchFields() {
        return matchFields;
    }

    @JsonProperty("matchFields")
    public void setMatchFields(List<NodeSelectorRequirement> matchFields) {
        this.matchFields = matchFields;
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
