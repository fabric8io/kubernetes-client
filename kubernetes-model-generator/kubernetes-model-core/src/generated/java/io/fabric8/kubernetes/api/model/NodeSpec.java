
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
 * NodeSpec describes the attributes that a node is created with.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configSource",
    "externalID",
    "podCIDR",
    "podCIDRs",
    "podPreemptionPolicy",
    "providerID",
    "taints",
    "unschedulable"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeSpec implements Editable<NodeSpecBuilder>, KubernetesResource
{

    @JsonProperty("configSource")
    private NodeConfigSource configSource;
    @JsonProperty("externalID")
    private String externalID;
    @JsonProperty("podCIDR")
    private String podCIDR;
    @JsonProperty("podCIDRs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> podCIDRs = new ArrayList<>();
    @JsonProperty("podPreemptionPolicy")
    private NodePodPreemptionPolicy podPreemptionPolicy;
    @JsonProperty("providerID")
    private String providerID;
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Taint> taints = new ArrayList<>();
    @JsonProperty("unschedulable")
    private Boolean unschedulable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeSpec() {
    }

    public NodeSpec(NodeConfigSource configSource, String externalID, String podCIDR, List<String> podCIDRs, NodePodPreemptionPolicy podPreemptionPolicy, String providerID, List<Taint> taints, Boolean unschedulable) {
        super();
        this.configSource = configSource;
        this.externalID = externalID;
        this.podCIDR = podCIDR;
        this.podCIDRs = podCIDRs;
        this.podPreemptionPolicy = podPreemptionPolicy;
        this.providerID = providerID;
        this.taints = taints;
        this.unschedulable = unschedulable;
    }

    /**
     * NodeSpec describes the attributes that a node is created with.
     */
    @JsonProperty("configSource")
    public NodeConfigSource getConfigSource() {
        return configSource;
    }

    /**
     * NodeSpec describes the attributes that a node is created with.
     */
    @JsonProperty("configSource")
    public void setConfigSource(NodeConfigSource configSource) {
        this.configSource = configSource;
    }

    /**
     * Deprecated. Not all kubelets will set this field. Remove field after 1.13. see: https://issues.k8s.io/61966
     */
    @JsonProperty("externalID")
    public String getExternalID() {
        return externalID;
    }

    /**
     * Deprecated. Not all kubelets will set this field. Remove field after 1.13. see: https://issues.k8s.io/61966
     */
    @JsonProperty("externalID")
    public void setExternalID(String externalID) {
        this.externalID = externalID;
    }

    /**
     * PodCIDR represents the pod IP range assigned to the node.
     */
    @JsonProperty("podCIDR")
    public String getPodCIDR() {
        return podCIDR;
    }

    /**
     * PodCIDR represents the pod IP range assigned to the node.
     */
    @JsonProperty("podCIDR")
    public void setPodCIDR(String podCIDR) {
        this.podCIDR = podCIDR;
    }

    /**
     * podCIDRs represents the IP ranges assigned to the node for usage by Pods on that node. If this field is specified, the 0th entry must match the podCIDR field. It may contain at most 1 value for each of IPv4 and IPv6.
     */
    @JsonProperty("podCIDRs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPodCIDRs() {
        return podCIDRs;
    }

    /**
     * podCIDRs represents the IP ranges assigned to the node for usage by Pods on that node. If this field is specified, the 0th entry must match the podCIDR field. It may contain at most 1 value for each of IPv4 and IPv6.
     */
    @JsonProperty("podCIDRs")
    public void setPodCIDRs(List<String> podCIDRs) {
        this.podCIDRs = podCIDRs;
    }

    /**
     * NodeSpec describes the attributes that a node is created with.
     */
    @JsonProperty("podPreemptionPolicy")
    public NodePodPreemptionPolicy getPodPreemptionPolicy() {
        return podPreemptionPolicy;
    }

    /**
     * NodeSpec describes the attributes that a node is created with.
     */
    @JsonProperty("podPreemptionPolicy")
    public void setPodPreemptionPolicy(NodePodPreemptionPolicy podPreemptionPolicy) {
        this.podPreemptionPolicy = podPreemptionPolicy;
    }

    /**
     * ID of the node assigned by the cloud provider in the format: &lt;ProviderName&gt;://&lt;ProviderSpecificNodeID&gt;
     */
    @JsonProperty("providerID")
    public String getProviderID() {
        return providerID;
    }

    /**
     * ID of the node assigned by the cloud provider in the format: &lt;ProviderName&gt;://&lt;ProviderSpecificNodeID&gt;
     */
    @JsonProperty("providerID")
    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    /**
     * If specified, the node's taints.
     */
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Taint> getTaints() {
        return taints;
    }

    /**
     * If specified, the node's taints.
     */
    @JsonProperty("taints")
    public void setTaints(List<Taint> taints) {
        this.taints = taints;
    }

    /**
     * Unschedulable controls node schedulability of new pods. By default, node is schedulable. More info: https://kubernetes.io/docs/concepts/nodes/node/#manual-node-administration
     */
    @JsonProperty("unschedulable")
    public Boolean getUnschedulable() {
        return unschedulable;
    }

    /**
     * Unschedulable controls node schedulability of new pods. By default, node is schedulable. More info: https://kubernetes.io/docs/concepts/nodes/node/#manual-node-administration
     */
    @JsonProperty("unschedulable")
    public void setUnschedulable(Boolean unschedulable) {
        this.unschedulable = unschedulable;
    }

    @JsonIgnore
    public NodeSpecBuilder edit() {
        return new NodeSpecBuilder(this);
    }

    @JsonIgnore
    public NodeSpecBuilder toBuilder() {
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
        if (!(o instanceof NodeSpec)) {
            return false;
        }
        NodeSpec other = (NodeSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$configSource = this.getConfigSource();
        Object other$configSource = other.getConfigSource();
        if (this$configSource == null ? other$configSource != null : !this$configSource.equals(other$configSource)) {
            return false;
        }
        Object this$externalID = this.getExternalID();
        Object other$externalID = other.getExternalID();
        if (this$externalID == null ? other$externalID != null : !this$externalID.equals(other$externalID)) {
            return false;
        }
        Object this$podCIDR = this.getPodCIDR();
        Object other$podCIDR = other.getPodCIDR();
        if (this$podCIDR == null ? other$podCIDR != null : !this$podCIDR.equals(other$podCIDR)) {
            return false;
        }
        Object this$podCIDRs = this.getPodCIDRs();
        Object other$podCIDRs = other.getPodCIDRs();
        if (this$podCIDRs == null ? other$podCIDRs != null : !this$podCIDRs.equals(other$podCIDRs)) {
            return false;
        }
        Object this$podPreemptionPolicy = this.getPodPreemptionPolicy();
        Object other$podPreemptionPolicy = other.getPodPreemptionPolicy();
        if (this$podPreemptionPolicy == null ? other$podPreemptionPolicy != null : !this$podPreemptionPolicy.equals(other$podPreemptionPolicy)) {
            return false;
        }
        Object this$providerID = this.getProviderID();
        Object other$providerID = other.getProviderID();
        if (this$providerID == null ? other$providerID != null : !this$providerID.equals(other$providerID)) {
            return false;
        }
        Object this$taints = this.getTaints();
        Object other$taints = other.getTaints();
        if (this$taints == null ? other$taints != null : !this$taints.equals(other$taints)) {
            return false;
        }
        Object this$unschedulable = this.getUnschedulable();
        Object other$unschedulable = other.getUnschedulable();
        if (this$unschedulable == null ? other$unschedulable != null : !this$unschedulable.equals(other$unschedulable)) {
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
        return other instanceof NodeSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $configSource = this.getConfigSource();
        result = result * prime + ($configSource == null ? 43 : $configSource.hashCode());
        Object $externalID = this.getExternalID();
        result = result * prime + ($externalID == null ? 43 : $externalID.hashCode());
        Object $podCIDR = this.getPodCIDR();
        result = result * prime + ($podCIDR == null ? 43 : $podCIDR.hashCode());
        Object $podCIDRs = this.getPodCIDRs();
        result = result * prime + ($podCIDRs == null ? 43 : $podCIDRs.hashCode());
        Object $podPreemptionPolicy = this.getPodPreemptionPolicy();
        result = result * prime + ($podPreemptionPolicy == null ? 43 : $podPreemptionPolicy.hashCode());
        Object $providerID = this.getProviderID();
        result = result * prime + ($providerID == null ? 43 : $providerID.hashCode());
        Object $taints = this.getTaints();
        result = result * prime + ($taints == null ? 43 : $taints.hashCode());
        Object $unschedulable = this.getUnschedulable();
        result = result * prime + ($unschedulable == null ? 43 : $unschedulable.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeSpec(" + "configSource=" + this.getConfigSource() + ", externalID=" + this.getExternalID() + ", podCIDR=" + this.getPodCIDR() + ", podCIDRs=" + this.getPodCIDRs() + ", podPreemptionPolicy=" + this.getPodPreemptionPolicy() + ", providerID=" + this.getProviderID() + ", taints=" + this.getTaints() + ", unschedulable=" + this.getUnschedulable() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
