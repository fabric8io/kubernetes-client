
package io.fabric8.kubernetes.api.model.policy.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
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
    "maxUnavailable",
    "minAvailable",
    "selector",
    "unhealthyPodEvictionPolicy"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class PodDisruptionBudgetSpec implements KubernetesResource
{

    @JsonProperty("maxUnavailable")
    private io.fabric8.kubernetes.api.model.IntOrString maxUnavailable;
    @JsonProperty("minAvailable")
    private io.fabric8.kubernetes.api.model.IntOrString minAvailable;
    @JsonProperty("selector")
    private io.fabric8.kubernetes.api.model.LabelSelector selector;
    @JsonProperty("unhealthyPodEvictionPolicy")
    private String unhealthyPodEvictionPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodDisruptionBudgetSpec() {
    }

    public PodDisruptionBudgetSpec(io.fabric8.kubernetes.api.model.IntOrString maxUnavailable, io.fabric8.kubernetes.api.model.IntOrString minAvailable, io.fabric8.kubernetes.api.model.LabelSelector selector, String unhealthyPodEvictionPolicy) {
        super();
        this.maxUnavailable = maxUnavailable;
        this.minAvailable = minAvailable;
        this.selector = selector;
        this.unhealthyPodEvictionPolicy = unhealthyPodEvictionPolicy;
    }

    @JsonProperty("maxUnavailable")
    public io.fabric8.kubernetes.api.model.IntOrString getMaxUnavailable() {
        return maxUnavailable;
    }

    @JsonProperty("maxUnavailable")
    public void setMaxUnavailable(io.fabric8.kubernetes.api.model.IntOrString maxUnavailable) {
        this.maxUnavailable = maxUnavailable;
    }

    @JsonProperty("minAvailable")
    public io.fabric8.kubernetes.api.model.IntOrString getMinAvailable() {
        return minAvailable;
    }

    @JsonProperty("minAvailable")
    public void setMinAvailable(io.fabric8.kubernetes.api.model.IntOrString minAvailable) {
        this.minAvailable = minAvailable;
    }

    @JsonProperty("selector")
    public io.fabric8.kubernetes.api.model.LabelSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(io.fabric8.kubernetes.api.model.LabelSelector selector) {
        this.selector = selector;
    }

    @JsonProperty("unhealthyPodEvictionPolicy")
    public String getUnhealthyPodEvictionPolicy() {
        return unhealthyPodEvictionPolicy;
    }

    @JsonProperty("unhealthyPodEvictionPolicy")
    public void setUnhealthyPodEvictionPolicy(String unhealthyPodEvictionPolicy) {
        this.unhealthyPodEvictionPolicy = unhealthyPodEvictionPolicy;
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
