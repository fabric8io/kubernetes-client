
package io.fabric8.openshift.api.model.hive.v1;

import java.util.LinkedHashMap;
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
 * MachinePoolAutoscaling details how the machine pool is to be auto-scaled.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxReplicas",
    "minReplicas"
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
public class MachinePoolAutoscaling implements Editable<MachinePoolAutoscalingBuilder>, KubernetesResource
{

    @JsonProperty("maxReplicas")
    private Integer maxReplicas;
    @JsonProperty("minReplicas")
    private Integer minReplicas;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePoolAutoscaling() {
    }

    public MachinePoolAutoscaling(Integer maxReplicas, Integer minReplicas) {
        super();
        this.maxReplicas = maxReplicas;
        this.minReplicas = minReplicas;
    }

    /**
     * MaxReplicas is the maximum number of replicas for the machine pool.
     */
    @JsonProperty("maxReplicas")
    public Integer getMaxReplicas() {
        return maxReplicas;
    }

    /**
     * MaxReplicas is the maximum number of replicas for the machine pool.
     */
    @JsonProperty("maxReplicas")
    public void setMaxReplicas(Integer maxReplicas) {
        this.maxReplicas = maxReplicas;
    }

    /**
     * MinReplicas is the minimum number of replicas for the machine pool.
     */
    @JsonProperty("minReplicas")
    public Integer getMinReplicas() {
        return minReplicas;
    }

    /**
     * MinReplicas is the minimum number of replicas for the machine pool.
     */
    @JsonProperty("minReplicas")
    public void setMinReplicas(Integer minReplicas) {
        this.minReplicas = minReplicas;
    }

    @JsonIgnore
    public MachinePoolAutoscalingBuilder edit() {
        return new MachinePoolAutoscalingBuilder(this);
    }

    @JsonIgnore
    public MachinePoolAutoscalingBuilder toBuilder() {
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
        if (!(o instanceof MachinePoolAutoscaling)) {
            return false;
        }
        MachinePoolAutoscaling other = (MachinePoolAutoscaling) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$maxReplicas = this.getMaxReplicas();
        Object other$maxReplicas = other.getMaxReplicas();
        if (this$maxReplicas == null ? other$maxReplicas != null : !this$maxReplicas.equals(other$maxReplicas)) {
            return false;
        }
        Object this$minReplicas = this.getMinReplicas();
        Object other$minReplicas = other.getMinReplicas();
        if (this$minReplicas == null ? other$minReplicas != null : !this$minReplicas.equals(other$minReplicas)) {
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
        return other instanceof MachinePoolAutoscaling;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $maxReplicas = this.getMaxReplicas();
        result = result * prime + ($maxReplicas == null ? 43 : $maxReplicas.hashCode());
        Object $minReplicas = this.getMinReplicas();
        result = result * prime + ($minReplicas == null ? 43 : $minReplicas.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachinePoolAutoscaling(" + "maxReplicas=" + this.getMaxReplicas() + ", minReplicas=" + this.getMinReplicas() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
