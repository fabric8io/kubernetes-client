
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
 * NodePodPreemptionPolicy defines the node-level policies governing preemption for pods on this node.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "disableResizePreemption"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodePodPreemptionPolicy implements Editable<NodePodPreemptionPolicyBuilder>, KubernetesResource
{

    @JsonProperty("disableResizePreemption")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> disableResizePreemption = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodePodPreemptionPolicy() {
    }

    public NodePodPreemptionPolicy(List<String> disableResizePreemption) {
        super();
        this.disableResizePreemption = disableResizePreemption;
    }

    /**
     * DisableResizePreemption lists the owners (e.g., autoscalers, operators, administrators) that have requested to disable scheduler and Kubelet preemption for in-place pod resize on this node. If this list is non-empty, resize-induced preemption is disabled on this node. This is an alpha field and requires enabling the InPlacePodVerticalScalingSchedulerPreemption feature gate.
     */
    @JsonProperty("disableResizePreemption")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDisableResizePreemption() {
        return disableResizePreemption;
    }

    /**
     * DisableResizePreemption lists the owners (e.g., autoscalers, operators, administrators) that have requested to disable scheduler and Kubelet preemption for in-place pod resize on this node. If this list is non-empty, resize-induced preemption is disabled on this node. This is an alpha field and requires enabling the InPlacePodVerticalScalingSchedulerPreemption feature gate.
     */
    @JsonProperty("disableResizePreemption")
    public void setDisableResizePreemption(List<String> disableResizePreemption) {
        this.disableResizePreemption = disableResizePreemption;
    }

    @JsonIgnore
    public NodePodPreemptionPolicyBuilder edit() {
        return new NodePodPreemptionPolicyBuilder(this);
    }

    @JsonIgnore
    public NodePodPreemptionPolicyBuilder toBuilder() {
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
        if (!(o instanceof NodePodPreemptionPolicy)) {
            return false;
        }
        NodePodPreemptionPolicy other = (NodePodPreemptionPolicy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$disableResizePreemption = this.getDisableResizePreemption();
        Object other$disableResizePreemption = other.getDisableResizePreemption();
        if (this$disableResizePreemption == null ? other$disableResizePreemption != null : !this$disableResizePreemption.equals(other$disableResizePreemption)) {
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
        return other instanceof NodePodPreemptionPolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $disableResizePreemption = this.getDisableResizePreemption();
        result = result * prime + ($disableResizePreemption == null ? 43 : $disableResizePreemption.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodePodPreemptionPolicy(" + "disableResizePreemption=" + this.getDisableResizePreemption() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
