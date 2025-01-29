
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    "providerID",
    "taints",
    "unschedulable"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

    public NodeSpec(NodeConfigSource configSource, String externalID, String podCIDR, List<String> podCIDRs, String providerID, List<Taint> taints, Boolean unschedulable) {
        super();
        this.configSource = configSource;
        this.externalID = externalID;
        this.podCIDR = podCIDR;
        this.podCIDRs = podCIDRs;
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

}
