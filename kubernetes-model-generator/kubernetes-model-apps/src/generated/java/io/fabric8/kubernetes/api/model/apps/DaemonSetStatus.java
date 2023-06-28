
package io.fabric8.kubernetes.api.model.apps;

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
    "collisionCount",
    "conditions",
    "currentNumberScheduled",
    "desiredNumberScheduled",
    "numberAvailable",
    "numberMisscheduled",
    "numberReady",
    "numberUnavailable",
    "observedGeneration",
    "updatedNumberScheduled"
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
public class DaemonSetStatus implements KubernetesResource
{

    @JsonProperty("collisionCount")
    private Integer collisionCount;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DaemonSetCondition> conditions = new ArrayList<DaemonSetCondition>();
    @JsonProperty("currentNumberScheduled")
    private Integer currentNumberScheduled;
    @JsonProperty("desiredNumberScheduled")
    private Integer desiredNumberScheduled;
    @JsonProperty("numberAvailable")
    private Integer numberAvailable;
    @JsonProperty("numberMisscheduled")
    private Integer numberMisscheduled;
    @JsonProperty("numberReady")
    private Integer numberReady;
    @JsonProperty("numberUnavailable")
    private Integer numberUnavailable;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("updatedNumberScheduled")
    private Integer updatedNumberScheduled;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DaemonSetStatus() {
    }

    public DaemonSetStatus(Integer collisionCount, List<DaemonSetCondition> conditions, Integer currentNumberScheduled, Integer desiredNumberScheduled, Integer numberAvailable, Integer numberMisscheduled, Integer numberReady, Integer numberUnavailable, Long observedGeneration, Integer updatedNumberScheduled) {
        super();
        this.collisionCount = collisionCount;
        this.conditions = conditions;
        this.currentNumberScheduled = currentNumberScheduled;
        this.desiredNumberScheduled = desiredNumberScheduled;
        this.numberAvailable = numberAvailable;
        this.numberMisscheduled = numberMisscheduled;
        this.numberReady = numberReady;
        this.numberUnavailable = numberUnavailable;
        this.observedGeneration = observedGeneration;
        this.updatedNumberScheduled = updatedNumberScheduled;
    }

    @JsonProperty("collisionCount")
    public Integer getCollisionCount() {
        return collisionCount;
    }

    @JsonProperty("collisionCount")
    public void setCollisionCount(Integer collisionCount) {
        this.collisionCount = collisionCount;
    }

    @JsonProperty("conditions")
    public List<DaemonSetCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<DaemonSetCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("currentNumberScheduled")
    public Integer getCurrentNumberScheduled() {
        return currentNumberScheduled;
    }

    @JsonProperty("currentNumberScheduled")
    public void setCurrentNumberScheduled(Integer currentNumberScheduled) {
        this.currentNumberScheduled = currentNumberScheduled;
    }

    @JsonProperty("desiredNumberScheduled")
    public Integer getDesiredNumberScheduled() {
        return desiredNumberScheduled;
    }

    @JsonProperty("desiredNumberScheduled")
    public void setDesiredNumberScheduled(Integer desiredNumberScheduled) {
        this.desiredNumberScheduled = desiredNumberScheduled;
    }

    @JsonProperty("numberAvailable")
    public Integer getNumberAvailable() {
        return numberAvailable;
    }

    @JsonProperty("numberAvailable")
    public void setNumberAvailable(Integer numberAvailable) {
        this.numberAvailable = numberAvailable;
    }

    @JsonProperty("numberMisscheduled")
    public Integer getNumberMisscheduled() {
        return numberMisscheduled;
    }

    @JsonProperty("numberMisscheduled")
    public void setNumberMisscheduled(Integer numberMisscheduled) {
        this.numberMisscheduled = numberMisscheduled;
    }

    @JsonProperty("numberReady")
    public Integer getNumberReady() {
        return numberReady;
    }

    @JsonProperty("numberReady")
    public void setNumberReady(Integer numberReady) {
        this.numberReady = numberReady;
    }

    @JsonProperty("numberUnavailable")
    public Integer getNumberUnavailable() {
        return numberUnavailable;
    }

    @JsonProperty("numberUnavailable")
    public void setNumberUnavailable(Integer numberUnavailable) {
        this.numberUnavailable = numberUnavailable;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonProperty("updatedNumberScheduled")
    public Integer getUpdatedNumberScheduled() {
        return updatedNumberScheduled;
    }

    @JsonProperty("updatedNumberScheduled")
    public void setUpdatedNumberScheduled(Integer updatedNumberScheduled) {
        this.updatedNumberScheduled = updatedNumberScheduled;
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
