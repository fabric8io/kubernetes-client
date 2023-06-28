
package io.fabric8.kubernetes.api.model.policy.v1beta1;

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
import io.fabric8.kubernetes.api.model.Condition;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
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
    "conditions",
    "currentHealthy",
    "desiredHealthy",
    "disruptedPods",
    "disruptionsAllowed",
    "expectedPods",
    "observedGeneration"
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
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class PodDisruptionBudgetStatus implements KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<Condition>();
    @JsonProperty("currentHealthy")
    private Integer currentHealthy;
    @JsonProperty("desiredHealthy")
    private Integer desiredHealthy;
    @JsonProperty("disruptedPods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> disruptedPods = new LinkedHashMap<String, String>();
    @JsonProperty("disruptionsAllowed")
    private Integer disruptionsAllowed;
    @JsonProperty("expectedPods")
    private Integer expectedPods;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodDisruptionBudgetStatus() {
    }

    public PodDisruptionBudgetStatus(List<Condition> conditions, Integer currentHealthy, Integer desiredHealthy, Map<String, String> disruptedPods, Integer disruptionsAllowed, Integer expectedPods, Long observedGeneration) {
        super();
        this.conditions = conditions;
        this.currentHealthy = currentHealthy;
        this.desiredHealthy = desiredHealthy;
        this.disruptedPods = disruptedPods;
        this.disruptionsAllowed = disruptionsAllowed;
        this.expectedPods = expectedPods;
        this.observedGeneration = observedGeneration;
    }

    @JsonProperty("conditions")
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("currentHealthy")
    public Integer getCurrentHealthy() {
        return currentHealthy;
    }

    @JsonProperty("currentHealthy")
    public void setCurrentHealthy(Integer currentHealthy) {
        this.currentHealthy = currentHealthy;
    }

    @JsonProperty("desiredHealthy")
    public Integer getDesiredHealthy() {
        return desiredHealthy;
    }

    @JsonProperty("desiredHealthy")
    public void setDesiredHealthy(Integer desiredHealthy) {
        this.desiredHealthy = desiredHealthy;
    }

    @JsonProperty("disruptedPods")
    public Map<String, String> getDisruptedPods() {
        return disruptedPods;
    }

    @JsonProperty("disruptedPods")
    public void setDisruptedPods(Map<String, String> disruptedPods) {
        this.disruptedPods = disruptedPods;
    }

    @JsonProperty("disruptionsAllowed")
    public Integer getDisruptionsAllowed() {
        return disruptionsAllowed;
    }

    @JsonProperty("disruptionsAllowed")
    public void setDisruptionsAllowed(Integer disruptionsAllowed) {
        this.disruptionsAllowed = disruptionsAllowed;
    }

    @JsonProperty("expectedPods")
    public Integer getExpectedPods() {
        return expectedPods;
    }

    @JsonProperty("expectedPods")
    public void setExpectedPods(Integer expectedPods) {
        this.expectedPods = expectedPods;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
