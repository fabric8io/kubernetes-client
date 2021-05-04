
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
    "nodeAffinity",
    "podAffinity",
    "podAntiAffinity"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class Affinity implements KubernetesResource
{

    @JsonProperty("nodeAffinity")
    private NodeAffinity nodeAffinity;
    @JsonProperty("podAffinity")
    private PodAffinity podAffinity;
    @JsonProperty("podAntiAffinity")
    private PodAntiAffinity podAntiAffinity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Affinity() {
    }

    /**
     * 
     * @param nodeAffinity
     * @param podAffinity
     * @param podAntiAffinity
     */
    public Affinity(NodeAffinity nodeAffinity, PodAffinity podAffinity, PodAntiAffinity podAntiAffinity) {
        super();
        this.nodeAffinity = nodeAffinity;
        this.podAffinity = podAffinity;
        this.podAntiAffinity = podAntiAffinity;
    }

    @JsonProperty("nodeAffinity")
    public NodeAffinity getNodeAffinity() {
        return nodeAffinity;
    }

    @JsonProperty("nodeAffinity")
    public void setNodeAffinity(NodeAffinity nodeAffinity) {
        this.nodeAffinity = nodeAffinity;
    }

    @JsonProperty("podAffinity")
    public PodAffinity getPodAffinity() {
        return podAffinity;
    }

    @JsonProperty("podAffinity")
    public void setPodAffinity(PodAffinity podAffinity) {
        this.podAffinity = podAffinity;
    }

    @JsonProperty("podAntiAffinity")
    public PodAntiAffinity getPodAntiAffinity() {
        return podAntiAffinity;
    }

    @JsonProperty("podAntiAffinity")
    public void setPodAntiAffinity(PodAntiAffinity podAntiAffinity) {
        this.podAntiAffinity = podAntiAffinity;
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
