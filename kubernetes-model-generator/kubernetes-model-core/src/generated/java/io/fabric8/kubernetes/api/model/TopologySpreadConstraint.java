
package io.fabric8.kubernetes.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "labelSelector",
    "maxSkew",
    "topologyKey",
    "whenUnsatisfiable"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class TopologySpreadConstraint implements KubernetesResource
{

    @JsonProperty("labelSelector")
    private LabelSelector labelSelector;
    @JsonProperty("maxSkew")
    private Integer maxSkew;
    @JsonProperty("topologyKey")
    private String topologyKey;
    @JsonProperty("whenUnsatisfiable")
    private String whenUnsatisfiable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TopologySpreadConstraint() {
    }

    /**
     * 
     * @param whenUnsatisfiable
     * @param maxSkew
     * @param labelSelector
     * @param topologyKey
     */
    public TopologySpreadConstraint(LabelSelector labelSelector, Integer maxSkew, String topologyKey, String whenUnsatisfiable) {
        super();
        this.labelSelector = labelSelector;
        this.maxSkew = maxSkew;
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

    @JsonProperty("maxSkew")
    public Integer getMaxSkew() {
        return maxSkew;
    }

    @JsonProperty("maxSkew")
    public void setMaxSkew(Integer maxSkew) {
        this.maxSkew = maxSkew;
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
