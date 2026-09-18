
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
 * Node affinity is a group of node affinity scheduling rules.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "preferredDuringSchedulingIgnoredDuringExecution",
    "requiredDuringSchedulingIgnoredDuringExecution"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeAffinity implements Editable<NodeAffinityBuilder>, KubernetesResource
{

    @JsonProperty("preferredDuringSchedulingIgnoredDuringExecution")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PreferredSchedulingTerm> preferredDuringSchedulingIgnoredDuringExecution = new ArrayList<>();
    @JsonProperty("requiredDuringSchedulingIgnoredDuringExecution")
    private NodeSelector requiredDuringSchedulingIgnoredDuringExecution;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeAffinity() {
    }

    public NodeAffinity(List<PreferredSchedulingTerm> preferredDuringSchedulingIgnoredDuringExecution, NodeSelector requiredDuringSchedulingIgnoredDuringExecution) {
        super();
        this.preferredDuringSchedulingIgnoredDuringExecution = preferredDuringSchedulingIgnoredDuringExecution;
        this.requiredDuringSchedulingIgnoredDuringExecution = requiredDuringSchedulingIgnoredDuringExecution;
    }

    /**
     * The scheduler will prefer to schedule pods to nodes that satisfy the affinity expressions specified by this field, but it may choose a node that violates one or more of the expressions. The node that is most preferred is the one with the greatest sum of weights, i.e. for each node that meets all of the scheduling requirements (resource request, requiredDuringScheduling affinity expressions, etc.), compute a sum by iterating through the elements of this field and adding "weight" to the sum if the node matches the corresponding matchExpressions; the node(s) with the highest sum are the most preferred.
     */
    @JsonProperty("preferredDuringSchedulingIgnoredDuringExecution")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PreferredSchedulingTerm> getPreferredDuringSchedulingIgnoredDuringExecution() {
        return preferredDuringSchedulingIgnoredDuringExecution;
    }

    /**
     * The scheduler will prefer to schedule pods to nodes that satisfy the affinity expressions specified by this field, but it may choose a node that violates one or more of the expressions. The node that is most preferred is the one with the greatest sum of weights, i.e. for each node that meets all of the scheduling requirements (resource request, requiredDuringScheduling affinity expressions, etc.), compute a sum by iterating through the elements of this field and adding "weight" to the sum if the node matches the corresponding matchExpressions; the node(s) with the highest sum are the most preferred.
     */
    @JsonProperty("preferredDuringSchedulingIgnoredDuringExecution")
    public void setPreferredDuringSchedulingIgnoredDuringExecution(List<PreferredSchedulingTerm> preferredDuringSchedulingIgnoredDuringExecution) {
        this.preferredDuringSchedulingIgnoredDuringExecution = preferredDuringSchedulingIgnoredDuringExecution;
    }

    /**
     * Node affinity is a group of node affinity scheduling rules.
     */
    @JsonProperty("requiredDuringSchedulingIgnoredDuringExecution")
    public NodeSelector getRequiredDuringSchedulingIgnoredDuringExecution() {
        return requiredDuringSchedulingIgnoredDuringExecution;
    }

    /**
     * Node affinity is a group of node affinity scheduling rules.
     */
    @JsonProperty("requiredDuringSchedulingIgnoredDuringExecution")
    public void setRequiredDuringSchedulingIgnoredDuringExecution(NodeSelector requiredDuringSchedulingIgnoredDuringExecution) {
        this.requiredDuringSchedulingIgnoredDuringExecution = requiredDuringSchedulingIgnoredDuringExecution;
    }

    @JsonIgnore
    public NodeAffinityBuilder edit() {
        return new NodeAffinityBuilder(this);
    }

    @JsonIgnore
    public NodeAffinityBuilder toBuilder() {
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
        if (!(o instanceof NodeAffinity)) {
            return false;
        }
        NodeAffinity other = (NodeAffinity) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$preferredDuringSchedulingIgnoredDuringExecution = this.getPreferredDuringSchedulingIgnoredDuringExecution();
        Object other$preferredDuringSchedulingIgnoredDuringExecution = other.getPreferredDuringSchedulingIgnoredDuringExecution();
        if (this$preferredDuringSchedulingIgnoredDuringExecution == null ? other$preferredDuringSchedulingIgnoredDuringExecution != null : !this$preferredDuringSchedulingIgnoredDuringExecution.equals(other$preferredDuringSchedulingIgnoredDuringExecution)) {
            return false;
        }
        Object this$requiredDuringSchedulingIgnoredDuringExecution = this.getRequiredDuringSchedulingIgnoredDuringExecution();
        Object other$requiredDuringSchedulingIgnoredDuringExecution = other.getRequiredDuringSchedulingIgnoredDuringExecution();
        if (this$requiredDuringSchedulingIgnoredDuringExecution == null ? other$requiredDuringSchedulingIgnoredDuringExecution != null : !this$requiredDuringSchedulingIgnoredDuringExecution.equals(other$requiredDuringSchedulingIgnoredDuringExecution)) {
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
        return other instanceof NodeAffinity;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $preferredDuringSchedulingIgnoredDuringExecution = this.getPreferredDuringSchedulingIgnoredDuringExecution();
        result = result * prime + ($preferredDuringSchedulingIgnoredDuringExecution == null ? 43 : $preferredDuringSchedulingIgnoredDuringExecution.hashCode());
        Object $requiredDuringSchedulingIgnoredDuringExecution = this.getRequiredDuringSchedulingIgnoredDuringExecution();
        result = result * prime + ($requiredDuringSchedulingIgnoredDuringExecution == null ? 43 : $requiredDuringSchedulingIgnoredDuringExecution.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeAffinity(" + "preferredDuringSchedulingIgnoredDuringExecution=" + this.getPreferredDuringSchedulingIgnoredDuringExecution() + ", requiredDuringSchedulingIgnoredDuringExecution=" + this.getRequiredDuringSchedulingIgnoredDuringExecution() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
