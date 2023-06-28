
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
    "preferredDuringSchedulingIgnoredDuringExecution",
    "requiredDuringSchedulingIgnoredDuringExecution"
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
public class NodeAffinity implements KubernetesResource
{

    @JsonProperty("preferredDuringSchedulingIgnoredDuringExecution")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PreferredSchedulingTerm> preferredDuringSchedulingIgnoredDuringExecution = new ArrayList<PreferredSchedulingTerm>();
    @JsonProperty("requiredDuringSchedulingIgnoredDuringExecution")
    private NodeSelector requiredDuringSchedulingIgnoredDuringExecution;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NodeAffinity() {
    }

    public NodeAffinity(List<PreferredSchedulingTerm> preferredDuringSchedulingIgnoredDuringExecution, NodeSelector requiredDuringSchedulingIgnoredDuringExecution) {
        super();
        this.preferredDuringSchedulingIgnoredDuringExecution = preferredDuringSchedulingIgnoredDuringExecution;
        this.requiredDuringSchedulingIgnoredDuringExecution = requiredDuringSchedulingIgnoredDuringExecution;
    }

    @JsonProperty("preferredDuringSchedulingIgnoredDuringExecution")
    public List<PreferredSchedulingTerm> getPreferredDuringSchedulingIgnoredDuringExecution() {
        return preferredDuringSchedulingIgnoredDuringExecution;
    }

    @JsonProperty("preferredDuringSchedulingIgnoredDuringExecution")
    public void setPreferredDuringSchedulingIgnoredDuringExecution(List<PreferredSchedulingTerm> preferredDuringSchedulingIgnoredDuringExecution) {
        this.preferredDuringSchedulingIgnoredDuringExecution = preferredDuringSchedulingIgnoredDuringExecution;
    }

    @JsonProperty("requiredDuringSchedulingIgnoredDuringExecution")
    public NodeSelector getRequiredDuringSchedulingIgnoredDuringExecution() {
        return requiredDuringSchedulingIgnoredDuringExecution;
    }

    @JsonProperty("requiredDuringSchedulingIgnoredDuringExecution")
    public void setRequiredDuringSchedulingIgnoredDuringExecution(NodeSelector requiredDuringSchedulingIgnoredDuringExecution) {
        this.requiredDuringSchedulingIgnoredDuringExecution = requiredDuringSchedulingIgnoredDuringExecution;
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
