
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
 * A node selector represents the union of the results of one or more label queries over a set of nodes; that is, it represents the OR of the selectors represented by the node selector terms.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nodeSelectorTerms"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeSelector implements Editable<NodeSelectorBuilder>, KubernetesResource
{

    @JsonProperty("nodeSelectorTerms")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeSelectorTerm> nodeSelectorTerms = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeSelector() {
    }

    public NodeSelector(List<NodeSelectorTerm> nodeSelectorTerms) {
        super();
        this.nodeSelectorTerms = nodeSelectorTerms;
    }

    /**
     * Required. A list of node selector terms. The terms are ORed.
     */
    @JsonProperty("nodeSelectorTerms")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeSelectorTerm> getNodeSelectorTerms() {
        return nodeSelectorTerms;
    }

    /**
     * Required. A list of node selector terms. The terms are ORed.
     */
    @JsonProperty("nodeSelectorTerms")
    public void setNodeSelectorTerms(List<NodeSelectorTerm> nodeSelectorTerms) {
        this.nodeSelectorTerms = nodeSelectorTerms;
    }

    @JsonIgnore
    public NodeSelectorBuilder edit() {
        return new NodeSelectorBuilder(this);
    }

    @JsonIgnore
    public NodeSelectorBuilder toBuilder() {
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
        if (!(o instanceof NodeSelector)) {
            return false;
        }
        NodeSelector other = (NodeSelector) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$nodeSelectorTerms = this.getNodeSelectorTerms();
        Object other$nodeSelectorTerms = other.getNodeSelectorTerms();
        if (this$nodeSelectorTerms == null ? other$nodeSelectorTerms != null : !this$nodeSelectorTerms.equals(other$nodeSelectorTerms)) {
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
        return other instanceof NodeSelector;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $nodeSelectorTerms = this.getNodeSelectorTerms();
        result = result * prime + ($nodeSelectorTerms == null ? 43 : $nodeSelectorTerms.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeSelector(" + "nodeSelectorTerms=" + this.getNodeSelectorTerms() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
