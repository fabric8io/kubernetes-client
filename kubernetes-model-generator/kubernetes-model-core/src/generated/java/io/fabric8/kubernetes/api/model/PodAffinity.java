
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
public class PodAffinity implements KubernetesResource
{

    @JsonProperty("preferredDuringSchedulingIgnoredDuringExecution")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WeightedPodAffinityTerm> preferredDuringSchedulingIgnoredDuringExecution = new ArrayList<WeightedPodAffinityTerm>();
    @JsonProperty("requiredDuringSchedulingIgnoredDuringExecution")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodAffinityTerm> requiredDuringSchedulingIgnoredDuringExecution = new ArrayList<PodAffinityTerm>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodAffinity() {
    }

    public PodAffinity(List<WeightedPodAffinityTerm> preferredDuringSchedulingIgnoredDuringExecution, List<PodAffinityTerm> requiredDuringSchedulingIgnoredDuringExecution) {
        super();
        this.preferredDuringSchedulingIgnoredDuringExecution = preferredDuringSchedulingIgnoredDuringExecution;
        this.requiredDuringSchedulingIgnoredDuringExecution = requiredDuringSchedulingIgnoredDuringExecution;
    }

    @JsonProperty("preferredDuringSchedulingIgnoredDuringExecution")
    public List<WeightedPodAffinityTerm> getPreferredDuringSchedulingIgnoredDuringExecution() {
        return preferredDuringSchedulingIgnoredDuringExecution;
    }

    @JsonProperty("preferredDuringSchedulingIgnoredDuringExecution")
    public void setPreferredDuringSchedulingIgnoredDuringExecution(List<WeightedPodAffinityTerm> preferredDuringSchedulingIgnoredDuringExecution) {
        this.preferredDuringSchedulingIgnoredDuringExecution = preferredDuringSchedulingIgnoredDuringExecution;
    }

    @JsonProperty("requiredDuringSchedulingIgnoredDuringExecution")
    public List<PodAffinityTerm> getRequiredDuringSchedulingIgnoredDuringExecution() {
        return requiredDuringSchedulingIgnoredDuringExecution;
    }

    @JsonProperty("requiredDuringSchedulingIgnoredDuringExecution")
    public void setRequiredDuringSchedulingIgnoredDuringExecution(List<PodAffinityTerm> requiredDuringSchedulingIgnoredDuringExecution) {
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
