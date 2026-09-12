
package io.fabric8.chaosmesh.v1alpha1;

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
 * GCPChaosStatus represents the status of a GCPChaos
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attachedDiskStrings",
    "conditions",
    "experiment"
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
public class GCPChaosStatus implements Editable<GCPChaosStatusBuilder>, KubernetesResource
{

    @JsonProperty("attachedDiskStrings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> attachedDiskStrings = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ChaosCondition> conditions = new ArrayList<>();
    @JsonProperty("experiment")
    private ExperimentStatus experiment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCPChaosStatus() {
    }

    public GCPChaosStatus(List<String> attachedDiskStrings, List<ChaosCondition> conditions, ExperimentStatus experiment) {
        super();
        this.attachedDiskStrings = attachedDiskStrings;
        this.conditions = conditions;
        this.experiment = experiment;
    }

    /**
     * The attached disk info strings. Needed in disk-loss.
     */
    @JsonProperty("attachedDiskStrings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAttachedDiskStrings() {
        return attachedDiskStrings;
    }

    /**
     * The attached disk info strings. Needed in disk-loss.
     */
    @JsonProperty("attachedDiskStrings")
    public void setAttachedDiskStrings(List<String> attachedDiskStrings) {
        this.attachedDiskStrings = attachedDiskStrings;
    }

    /**
     * Conditions represents the current global condition of the chaos
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ChaosCondition> getConditions() {
        return conditions;
    }

    /**
     * Conditions represents the current global condition of the chaos
     */
    @JsonProperty("conditions")
    public void setConditions(List<ChaosCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * GCPChaosStatus represents the status of a GCPChaos
     */
    @JsonProperty("experiment")
    public ExperimentStatus getExperiment() {
        return experiment;
    }

    /**
     * GCPChaosStatus represents the status of a GCPChaos
     */
    @JsonProperty("experiment")
    public void setExperiment(ExperimentStatus experiment) {
        this.experiment = experiment;
    }

    @JsonIgnore
    public GCPChaosStatusBuilder edit() {
        return new GCPChaosStatusBuilder(this);
    }

    @JsonIgnore
    public GCPChaosStatusBuilder toBuilder() {
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
        if (!(o instanceof GCPChaosStatus)) {
            return false;
        }
        GCPChaosStatus other = (GCPChaosStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$attachedDiskStrings = this.getAttachedDiskStrings();
        Object other$attachedDiskStrings = other.getAttachedDiskStrings();
        if (this$attachedDiskStrings == null ? other$attachedDiskStrings != null : !this$attachedDiskStrings.equals(other$attachedDiskStrings)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$experiment = this.getExperiment();
        Object other$experiment = other.getExperiment();
        if (this$experiment == null ? other$experiment != null : !this$experiment.equals(other$experiment)) {
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
        return other instanceof GCPChaosStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $attachedDiskStrings = this.getAttachedDiskStrings();
        result = result * prime + ($attachedDiskStrings == null ? 43 : $attachedDiskStrings.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $experiment = this.getExperiment();
        result = result * prime + ($experiment == null ? 43 : $experiment.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GCPChaosStatus(" + "attachedDiskStrings=" + this.getAttachedDiskStrings() + ", conditions=" + this.getConditions() + ", experiment=" + this.getExperiment() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
