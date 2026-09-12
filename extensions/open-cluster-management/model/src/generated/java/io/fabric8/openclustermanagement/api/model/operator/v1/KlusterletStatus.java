
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.model.Condition;
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
 * KlusterletStatus represents the current status of Klusterlet agent.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "generations",
    "observedGeneration",
    "relatedResources"
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
public class KlusterletStatus implements Editable<KlusterletStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("generations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GenerationStatus> generations = new ArrayList<>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("relatedResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelatedResourceMeta> relatedResources = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KlusterletStatus() {
    }

    public KlusterletStatus(List<Condition> conditions, List<GenerationStatus> generations, Long observedGeneration, List<RelatedResourceMeta> relatedResources) {
        super();
        this.conditions = conditions;
        this.generations = generations;
        this.observedGeneration = observedGeneration;
        this.relatedResources = relatedResources;
    }

    /**
     * Conditions contain the different condition statuses for this Klusterlet. Valid condition types are: Applied: Components have been applied in the managed cluster. Available: Components in the managed cluster are available and ready to serve. Progressing: Components in the managed cluster are in a transitioning state. Degraded: Components in the managed cluster do not match the desired configuration and only provide degraded service.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions contain the different condition statuses for this Klusterlet. Valid condition types are: Applied: Components have been applied in the managed cluster. Available: Components in the managed cluster are available and ready to serve. Progressing: Components in the managed cluster are in a transitioning state. Degraded: Components in the managed cluster do not match the desired configuration and only provide degraded service.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * Generations are used to determine when an item needs to be reconciled or has changed in a way that needs a reaction.
     */
    @JsonProperty("generations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GenerationStatus> getGenerations() {
        return generations;
    }

    /**
     * Generations are used to determine when an item needs to be reconciled or has changed in a way that needs a reaction.
     */
    @JsonProperty("generations")
    public void setGenerations(List<GenerationStatus> generations) {
        this.generations = generations;
    }

    /**
     * ObservedGeneration is the last generation change you've dealt with
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * ObservedGeneration is the last generation change you've dealt with
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * RelatedResources are used to track the resources that are related to this Klusterlet.
     */
    @JsonProperty("relatedResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelatedResourceMeta> getRelatedResources() {
        return relatedResources;
    }

    /**
     * RelatedResources are used to track the resources that are related to this Klusterlet.
     */
    @JsonProperty("relatedResources")
    public void setRelatedResources(List<RelatedResourceMeta> relatedResources) {
        this.relatedResources = relatedResources;
    }

    @JsonIgnore
    public KlusterletStatusBuilder edit() {
        return new KlusterletStatusBuilder(this);
    }

    @JsonIgnore
    public KlusterletStatusBuilder toBuilder() {
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
        if (!(o instanceof KlusterletStatus)) {
            return false;
        }
        KlusterletStatus other = (KlusterletStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$generations = this.getGenerations();
        Object other$generations = other.getGenerations();
        if (this$generations == null ? other$generations != null : !this$generations.equals(other$generations)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$relatedResources = this.getRelatedResources();
        Object other$relatedResources = other.getRelatedResources();
        if (this$relatedResources == null ? other$relatedResources != null : !this$relatedResources.equals(other$relatedResources)) {
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
        return other instanceof KlusterletStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $generations = this.getGenerations();
        result = result * prime + ($generations == null ? 43 : $generations.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $relatedResources = this.getRelatedResources();
        result = result * prime + ($relatedResources == null ? 43 : $relatedResources.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KlusterletStatus(" + "conditions=" + this.getConditions() + ", generations=" + this.getGenerations() + ", observedGeneration=" + this.getObservedGeneration() + ", relatedResources=" + this.getRelatedResources() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
