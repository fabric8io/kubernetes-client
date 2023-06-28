
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
    "namespaceSelector",
    "namespaces",
    "topologyKey"
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
public class PodAffinityTerm implements KubernetesResource
{

    @JsonProperty("labelSelector")
    private LabelSelector labelSelector;
    @JsonProperty("namespaceSelector")
    private LabelSelector namespaceSelector;
    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> namespaces = new ArrayList<String>();
    @JsonProperty("topologyKey")
    private String topologyKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodAffinityTerm() {
    }

    public PodAffinityTerm(LabelSelector labelSelector, LabelSelector namespaceSelector, List<String> namespaces, String topologyKey) {
        super();
        this.labelSelector = labelSelector;
        this.namespaceSelector = namespaceSelector;
        this.namespaces = namespaces;
        this.topologyKey = topologyKey;
    }

    @JsonProperty("labelSelector")
    public LabelSelector getLabelSelector() {
        return labelSelector;
    }

    @JsonProperty("labelSelector")
    public void setLabelSelector(LabelSelector labelSelector) {
        this.labelSelector = labelSelector;
    }

    @JsonProperty("namespaceSelector")
    public LabelSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(LabelSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    @JsonProperty("namespaces")
    public List<String> getNamespaces() {
        return namespaces;
    }

    @JsonProperty("namespaces")
    public void setNamespaces(List<String> namespaces) {
        this.namespaces = namespaces;
    }

    @JsonProperty("topologyKey")
    public String getTopologyKey() {
        return topologyKey;
    }

    @JsonProperty("topologyKey")
    public void setTopologyKey(String topologyKey) {
        this.topologyKey = topologyKey;
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
