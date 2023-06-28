
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
    "labelSelector",
    "matchLabelKeys",
    "maxSkew",
    "minDomains",
    "nodeAffinityPolicy",
    "nodeTaintsPolicy",
    "topologyKey",
    "whenUnsatisfiable"
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
public class TopologySpreadConstraint implements KubernetesResource
{

    @JsonProperty("labelSelector")
    private LabelSelector labelSelector;
    @JsonProperty("matchLabelKeys")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> matchLabelKeys = new ArrayList<String>();
    @JsonProperty("maxSkew")
    private Integer maxSkew;
    @JsonProperty("minDomains")
    private Integer minDomains;
    @JsonProperty("nodeAffinityPolicy")
    private String nodeAffinityPolicy;
    @JsonProperty("nodeTaintsPolicy")
    private String nodeTaintsPolicy;
    @JsonProperty("topologyKey")
    private String topologyKey;
    @JsonProperty("whenUnsatisfiable")
    private String whenUnsatisfiable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TopologySpreadConstraint() {
    }

    public TopologySpreadConstraint(LabelSelector labelSelector, List<String> matchLabelKeys, Integer maxSkew, Integer minDomains, String nodeAffinityPolicy, String nodeTaintsPolicy, String topologyKey, String whenUnsatisfiable) {
        super();
        this.labelSelector = labelSelector;
        this.matchLabelKeys = matchLabelKeys;
        this.maxSkew = maxSkew;
        this.minDomains = minDomains;
        this.nodeAffinityPolicy = nodeAffinityPolicy;
        this.nodeTaintsPolicy = nodeTaintsPolicy;
        this.topologyKey = topologyKey;
        this.whenUnsatisfiable = whenUnsatisfiable;
    }

    @JsonProperty("labelSelector")
    public LabelSelector getLabelSelector() {
        return labelSelector;
    }

    @JsonProperty("labelSelector")
    public void setLabelSelector(LabelSelector labelSelector) {
        this.labelSelector = labelSelector;
    }

    @JsonProperty("matchLabelKeys")
    public List<String> getMatchLabelKeys() {
        return matchLabelKeys;
    }

    @JsonProperty("matchLabelKeys")
    public void setMatchLabelKeys(List<String> matchLabelKeys) {
        this.matchLabelKeys = matchLabelKeys;
    }

    @JsonProperty("maxSkew")
    public Integer getMaxSkew() {
        return maxSkew;
    }

    @JsonProperty("maxSkew")
    public void setMaxSkew(Integer maxSkew) {
        this.maxSkew = maxSkew;
    }

    @JsonProperty("minDomains")
    public Integer getMinDomains() {
        return minDomains;
    }

    @JsonProperty("minDomains")
    public void setMinDomains(Integer minDomains) {
        this.minDomains = minDomains;
    }

    @JsonProperty("nodeAffinityPolicy")
    public String getNodeAffinityPolicy() {
        return nodeAffinityPolicy;
    }

    @JsonProperty("nodeAffinityPolicy")
    public void setNodeAffinityPolicy(String nodeAffinityPolicy) {
        this.nodeAffinityPolicy = nodeAffinityPolicy;
    }

    @JsonProperty("nodeTaintsPolicy")
    public String getNodeTaintsPolicy() {
        return nodeTaintsPolicy;
    }

    @JsonProperty("nodeTaintsPolicy")
    public void setNodeTaintsPolicy(String nodeTaintsPolicy) {
        this.nodeTaintsPolicy = nodeTaintsPolicy;
    }

    @JsonProperty("topologyKey")
    public String getTopologyKey() {
        return topologyKey;
    }

    @JsonProperty("topologyKey")
    public void setTopologyKey(String topologyKey) {
        this.topologyKey = topologyKey;
    }

    @JsonProperty("whenUnsatisfiable")
    public String getWhenUnsatisfiable() {
        return whenUnsatisfiable;
    }

    @JsonProperty("whenUnsatisfiable")
    public void setWhenUnsatisfiable(String whenUnsatisfiable) {
        this.whenUnsatisfiable = whenUnsatisfiable;
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
