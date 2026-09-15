
package io.fabric8.kubernetes.api.model.extensions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * DaemonSetStatus represents the current status of a daemon set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class DaemonSetStatus implements Editable<DaemonSetStatusBuilder>, KubernetesResource
{

    @JsonProperty("collisionCount")
    private Integer collisionCount;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DaemonSetCondition> conditions = new ArrayList<>();
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

    /**
     * Count of hash collisions for the DaemonSet. The DaemonSet controller uses this field as a collision avoidance mechanism when it needs to create the name for the newest ControllerRevision.
     */
    @JsonProperty("collisionCount")
    public Integer getCollisionCount() {
        return collisionCount;
    }

    /**
     * Count of hash collisions for the DaemonSet. The DaemonSet controller uses this field as a collision avoidance mechanism when it needs to create the name for the newest ControllerRevision.
     */
    @JsonProperty("collisionCount")
    public void setCollisionCount(Integer collisionCount) {
        this.collisionCount = collisionCount;
    }

    /**
     * Represents the latest available observations of a DaemonSet's current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DaemonSetCondition> getConditions() {
        return conditions;
    }

    /**
     * Represents the latest available observations of a DaemonSet's current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<DaemonSetCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * The number of nodes that are running at least 1 daemon pod and are supposed to run the daemon pod. More info: https://kubernetes.io/docs/concepts/workloads/controllers/daemonset/
     */
    @JsonProperty("currentNumberScheduled")
    public Integer getCurrentNumberScheduled() {
        return currentNumberScheduled;
    }

    /**
     * The number of nodes that are running at least 1 daemon pod and are supposed to run the daemon pod. More info: https://kubernetes.io/docs/concepts/workloads/controllers/daemonset/
     */
    @JsonProperty("currentNumberScheduled")
    public void setCurrentNumberScheduled(Integer currentNumberScheduled) {
        this.currentNumberScheduled = currentNumberScheduled;
    }

    /**
     * The total number of nodes that should be running the daemon pod (including nodes correctly running the daemon pod). More info: https://kubernetes.io/docs/concepts/workloads/controllers/daemonset/
     */
    @JsonProperty("desiredNumberScheduled")
    public Integer getDesiredNumberScheduled() {
        return desiredNumberScheduled;
    }

    /**
     * The total number of nodes that should be running the daemon pod (including nodes correctly running the daemon pod). More info: https://kubernetes.io/docs/concepts/workloads/controllers/daemonset/
     */
    @JsonProperty("desiredNumberScheduled")
    public void setDesiredNumberScheduled(Integer desiredNumberScheduled) {
        this.desiredNumberScheduled = desiredNumberScheduled;
    }

    /**
     * The number of nodes that should be running the daemon pod and have one or more of the daemon pod running and available (ready for at least spec.minReadySeconds)
     */
    @JsonProperty("numberAvailable")
    public Integer getNumberAvailable() {
        return numberAvailable;
    }

    /**
     * The number of nodes that should be running the daemon pod and have one or more of the daemon pod running and available (ready for at least spec.minReadySeconds)
     */
    @JsonProperty("numberAvailable")
    public void setNumberAvailable(Integer numberAvailable) {
        this.numberAvailable = numberAvailable;
    }

    /**
     * The number of nodes that are running the daemon pod, but are not supposed to run the daemon pod. More info: https://kubernetes.io/docs/concepts/workloads/controllers/daemonset/
     */
    @JsonProperty("numberMisscheduled")
    public Integer getNumberMisscheduled() {
        return numberMisscheduled;
    }

    /**
     * The number of nodes that are running the daemon pod, but are not supposed to run the daemon pod. More info: https://kubernetes.io/docs/concepts/workloads/controllers/daemonset/
     */
    @JsonProperty("numberMisscheduled")
    public void setNumberMisscheduled(Integer numberMisscheduled) {
        this.numberMisscheduled = numberMisscheduled;
    }

    /**
     * The number of nodes that should be running the daemon pod and have one or more of the daemon pod running and ready.
     */
    @JsonProperty("numberReady")
    public Integer getNumberReady() {
        return numberReady;
    }

    /**
     * The number of nodes that should be running the daemon pod and have one or more of the daemon pod running and ready.
     */
    @JsonProperty("numberReady")
    public void setNumberReady(Integer numberReady) {
        this.numberReady = numberReady;
    }

    /**
     * The number of nodes that should be running the daemon pod and have none of the daemon pod running and available (ready for at least spec.minReadySeconds)
     */
    @JsonProperty("numberUnavailable")
    public Integer getNumberUnavailable() {
        return numberUnavailable;
    }

    /**
     * The number of nodes that should be running the daemon pod and have none of the daemon pod running and available (ready for at least spec.minReadySeconds)
     */
    @JsonProperty("numberUnavailable")
    public void setNumberUnavailable(Integer numberUnavailable) {
        this.numberUnavailable = numberUnavailable;
    }

    /**
     * The most recent generation observed by the daemon set controller.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * The most recent generation observed by the daemon set controller.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * The total number of nodes that are running updated daemon pod
     */
    @JsonProperty("updatedNumberScheduled")
    public Integer getUpdatedNumberScheduled() {
        return updatedNumberScheduled;
    }

    /**
     * The total number of nodes that are running updated daemon pod
     */
    @JsonProperty("updatedNumberScheduled")
    public void setUpdatedNumberScheduled(Integer updatedNumberScheduled) {
        this.updatedNumberScheduled = updatedNumberScheduled;
    }

    @JsonIgnore
    public DaemonSetStatusBuilder edit() {
        return new DaemonSetStatusBuilder(this);
    }

    @JsonIgnore
    public DaemonSetStatusBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DaemonSetStatus)) {
            return false;
        }
        DaemonSetStatus other = (DaemonSetStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$collisionCount = this.getCollisionCount();
        Object other$collisionCount = other.getCollisionCount();
        if (this$collisionCount == null ? other$collisionCount != null : !this$collisionCount.equals(other$collisionCount)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$currentNumberScheduled = this.getCurrentNumberScheduled();
        Object other$currentNumberScheduled = other.getCurrentNumberScheduled();
        if (this$currentNumberScheduled == null ? other$currentNumberScheduled != null : !this$currentNumberScheduled.equals(other$currentNumberScheduled)) {
            return false;
        }
        Object this$desiredNumberScheduled = this.getDesiredNumberScheduled();
        Object other$desiredNumberScheduled = other.getDesiredNumberScheduled();
        if (this$desiredNumberScheduled == null ? other$desiredNumberScheduled != null : !this$desiredNumberScheduled.equals(other$desiredNumberScheduled)) {
            return false;
        }
        Object this$numberAvailable = this.getNumberAvailable();
        Object other$numberAvailable = other.getNumberAvailable();
        if (this$numberAvailable == null ? other$numberAvailable != null : !this$numberAvailable.equals(other$numberAvailable)) {
            return false;
        }
        Object this$numberMisscheduled = this.getNumberMisscheduled();
        Object other$numberMisscheduled = other.getNumberMisscheduled();
        if (this$numberMisscheduled == null ? other$numberMisscheduled != null : !this$numberMisscheduled.equals(other$numberMisscheduled)) {
            return false;
        }
        Object this$numberReady = this.getNumberReady();
        Object other$numberReady = other.getNumberReady();
        if (this$numberReady == null ? other$numberReady != null : !this$numberReady.equals(other$numberReady)) {
            return false;
        }
        Object this$numberUnavailable = this.getNumberUnavailable();
        Object other$numberUnavailable = other.getNumberUnavailable();
        if (this$numberUnavailable == null ? other$numberUnavailable != null : !this$numberUnavailable.equals(other$numberUnavailable)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$updatedNumberScheduled = this.getUpdatedNumberScheduled();
        Object other$updatedNumberScheduled = other.getUpdatedNumberScheduled();
        if (this$updatedNumberScheduled == null ? other$updatedNumberScheduled != null : !this$updatedNumberScheduled.equals(other$updatedNumberScheduled)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof DaemonSetStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $collisionCount = this.getCollisionCount();
        result = result * prime + ($collisionCount == null ? 43 : $collisionCount.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $currentNumberScheduled = this.getCurrentNumberScheduled();
        result = result * prime + ($currentNumberScheduled == null ? 43 : $currentNumberScheduled.hashCode());
        Object $desiredNumberScheduled = this.getDesiredNumberScheduled();
        result = result * prime + ($desiredNumberScheduled == null ? 43 : $desiredNumberScheduled.hashCode());
        Object $numberAvailable = this.getNumberAvailable();
        result = result * prime + ($numberAvailable == null ? 43 : $numberAvailable.hashCode());
        Object $numberMisscheduled = this.getNumberMisscheduled();
        result = result * prime + ($numberMisscheduled == null ? 43 : $numberMisscheduled.hashCode());
        Object $numberReady = this.getNumberReady();
        result = result * prime + ($numberReady == null ? 43 : $numberReady.hashCode());
        Object $numberUnavailable = this.getNumberUnavailable();
        result = result * prime + ($numberUnavailable == null ? 43 : $numberUnavailable.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $updatedNumberScheduled = this.getUpdatedNumberScheduled();
        result = result * prime + ($updatedNumberScheduled == null ? 43 : $updatedNumberScheduled.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DaemonSetStatus(" + "collisionCount=" + this.getCollisionCount() + ", conditions=" + this.getConditions() + ", currentNumberScheduled=" + this.getCurrentNumberScheduled() + ", desiredNumberScheduled=" + this.getDesiredNumberScheduled() + ", numberAvailable=" + this.getNumberAvailable() + ", numberMisscheduled=" + this.getNumberMisscheduled() + ", numberReady=" + this.getNumberReady() + ", numberUnavailable=" + this.getNumberUnavailable() + ", observedGeneration=" + this.getObservedGeneration() + ", updatedNumberScheduled=" + this.getUpdatedNumberScheduled() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
