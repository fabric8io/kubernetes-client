
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;

/**
 * A null or empty node selector term matches no objects. The requirements of them are ANDed. The TopologySelectorTerm type implements a subset of the NodeSelectorTerm.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "matchExpressions",
    "matchFields"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeSelectorTerm implements Editable<NodeSelectorTermBuilder>, KubernetesResource
{

    @JsonProperty("matchExpressions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeSelectorRequirement> matchExpressions = new ArrayList<>();
    @JsonProperty("matchFields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeSelectorRequirement> matchFields = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeSelectorTerm() {
    }

    public NodeSelectorTerm(List<NodeSelectorRequirement> matchExpressions, List<NodeSelectorRequirement> matchFields) {
        super();
        this.matchExpressions = matchExpressions;
        this.matchFields = matchFields;
    }

    /**
     * A list of node selector requirements by node's labels.
     */
    @JsonProperty("matchExpressions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeSelectorRequirement> getMatchExpressions() {
        return matchExpressions;
    }

    /**
     * A list of node selector requirements by node's labels.
     */
    @JsonProperty("matchExpressions")
    public void setMatchExpressions(List<NodeSelectorRequirement> matchExpressions) {
        this.matchExpressions = matchExpressions;
    }

    /**
     * A list of node selector requirements by node's fields.
     */
    @JsonProperty("matchFields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeSelectorRequirement> getMatchFields() {
        return matchFields;
    }

    /**
     * A list of node selector requirements by node's fields.
     */
    @JsonProperty("matchFields")
    public void setMatchFields(List<NodeSelectorRequirement> matchFields) {
        this.matchFields = matchFields;
    }

    @JsonIgnore
    public NodeSelectorTermBuilder edit() {
        return new NodeSelectorTermBuilder(this);
    }

    @JsonIgnore
    public NodeSelectorTermBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof NodeSelectorTerm)) {
            return false;
        }
        NodeSelectorTerm other = (NodeSelectorTerm) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$matchExpressions = this.getMatchExpressions();
        Object other$matchExpressions = other.getMatchExpressions();
        if (this$matchExpressions == null ? other$matchExpressions != null : !this$matchExpressions.equals(other$matchExpressions)) {
            return false;
        }
        Object this$matchFields = this.getMatchFields();
        Object other$matchFields = other.getMatchFields();
        if (this$matchFields == null ? other$matchFields != null : !this$matchFields.equals(other$matchFields)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof NodeSelectorTerm;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $matchExpressions = this.getMatchExpressions();
        result = result * prime + ($matchExpressions == null ? 43 : $matchExpressions.hashCode());
        Object $matchFields = this.getMatchFields();
        result = result * prime + ($matchFields == null ? 43 : $matchFields.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeSelectorTerm(" + "matchExpressions=" + this.getMatchExpressions() + ", matchFields=" + this.getMatchFields() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
