
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
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class NodeSpec implements KubernetesResource
{

    @JsonProperty("configSource")
    private NodeConfigSource configSource;
    @JsonProperty("externalID")
    private String externalID;
    @JsonProperty("podCIDR")
    private String podCIDR;
    @JsonProperty("podCIDRs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> podCIDRs = new ArrayList<String>();
    @JsonProperty("providerID")
    private String providerID;
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Taint> taints = new ArrayList<Taint>();
    @JsonProperty("unschedulable")
    private Boolean unschedulable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
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

    @JsonProperty("configSource")
    public NodeConfigSource getConfigSource() {
        return configSource;
    }

    @JsonProperty("configSource")
    public void setConfigSource(NodeConfigSource configSource) {
        this.configSource = configSource;
    }

    @JsonProperty("externalID")
    public String getExternalID() {
        return externalID;
    }

    @JsonProperty("externalID")
    public void setExternalID(String externalID) {
        this.externalID = externalID;
    }

    @JsonProperty("podCIDR")
    public String getPodCIDR() {
        return podCIDR;
    }

    @JsonProperty("podCIDR")
    public void setPodCIDR(String podCIDR) {
        this.podCIDR = podCIDR;
    }

    @JsonProperty("podCIDRs")
    public List<String> getPodCIDRs() {
        return podCIDRs;
    }

    @JsonProperty("podCIDRs")
    public void setPodCIDRs(List<String> podCIDRs) {
        this.podCIDRs = podCIDRs;
    }

    @JsonProperty("providerID")
    public String getProviderID() {
        return providerID;
    }

    @JsonProperty("providerID")
    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    @JsonProperty("taints")
    public List<Taint> getTaints() {
        return taints;
    }

    @JsonProperty("taints")
    public void setTaints(List<Taint> taints) {
        this.taints = taints;
    }

    @JsonProperty("unschedulable")
    public Boolean getUnschedulable() {
        return unschedulable;
    }

    @JsonProperty("unschedulable")
    public void setUnschedulable(Boolean unschedulable) {
        this.unschedulable = unschedulable;
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
