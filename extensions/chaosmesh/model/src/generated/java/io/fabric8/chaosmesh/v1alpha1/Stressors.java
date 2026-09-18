
package io.fabric8.chaosmesh.v1alpha1;

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
 * Stressors defines plenty of stressors supported to stress system components out. You can use one or more of them to make up various kinds of stresses
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cpu",
    "memory"
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
public class Stressors implements Editable<StressorsBuilder>, KubernetesResource
{

    @JsonProperty("cpu")
    private CPUStressor cpu;
    @JsonProperty("memory")
    private MemoryStressor memory;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Stressors() {
    }

    public Stressors(CPUStressor cpu, MemoryStressor memory) {
        super();
        this.cpu = cpu;
        this.memory = memory;
    }

    /**
     * Stressors defines plenty of stressors supported to stress system components out. You can use one or more of them to make up various kinds of stresses
     */
    @JsonProperty("cpu")
    public CPUStressor getCpu() {
        return cpu;
    }

    /**
     * Stressors defines plenty of stressors supported to stress system components out. You can use one or more of them to make up various kinds of stresses
     */
    @JsonProperty("cpu")
    public void setCpu(CPUStressor cpu) {
        this.cpu = cpu;
    }

    /**
     * Stressors defines plenty of stressors supported to stress system components out. You can use one or more of them to make up various kinds of stresses
     */
    @JsonProperty("memory")
    public MemoryStressor getMemory() {
        return memory;
    }

    /**
     * Stressors defines plenty of stressors supported to stress system components out. You can use one or more of them to make up various kinds of stresses
     */
    @JsonProperty("memory")
    public void setMemory(MemoryStressor memory) {
        this.memory = memory;
    }

    @JsonIgnore
    public StressorsBuilder edit() {
        return new StressorsBuilder(this);
    }

    @JsonIgnore
    public StressorsBuilder toBuilder() {
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
        if (!(o instanceof Stressors)) {
            return false;
        }
        Stressors other = (Stressors) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cpu = this.getCpu();
        Object other$cpu = other.getCpu();
        if (this$cpu == null ? other$cpu != null : !this$cpu.equals(other$cpu)) {
            return false;
        }
        Object this$memory = this.getMemory();
        Object other$memory = other.getMemory();
        if (this$memory == null ? other$memory != null : !this$memory.equals(other$memory)) {
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
        return other instanceof Stressors;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cpu = this.getCpu();
        result = result * prime + ($cpu == null ? 43 : $cpu.hashCode());
        Object $memory = this.getMemory();
        result = result * prime + ($memory == null ? 43 : $memory.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Stressors(" + "cpu=" + this.getCpu() + ", memory=" + this.getMemory() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
