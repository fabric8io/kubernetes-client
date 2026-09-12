
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ContainerRuntimeConfigSpec defines the desired state of ContainerRuntimeConfig
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerRuntimeConfig",
    "machineConfigPoolSelector"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ContainerRuntimeConfigSpec implements Editable<ContainerRuntimeConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("containerRuntimeConfig")
    private ContainerRuntimeConfiguration containerRuntimeConfig;
    @JsonProperty("machineConfigPoolSelector")
    private LabelSelector machineConfigPoolSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ContainerRuntimeConfigSpec() {
    }

    public ContainerRuntimeConfigSpec(ContainerRuntimeConfiguration containerRuntimeConfig, LabelSelector machineConfigPoolSelector) {
        super();
        this.containerRuntimeConfig = containerRuntimeConfig;
        this.machineConfigPoolSelector = machineConfigPoolSelector;
    }

    /**
     * ContainerRuntimeConfigSpec defines the desired state of ContainerRuntimeConfig
     */
    @JsonProperty("containerRuntimeConfig")
    public ContainerRuntimeConfiguration getContainerRuntimeConfig() {
        return containerRuntimeConfig;
    }

    /**
     * ContainerRuntimeConfigSpec defines the desired state of ContainerRuntimeConfig
     */
    @JsonProperty("containerRuntimeConfig")
    public void setContainerRuntimeConfig(ContainerRuntimeConfiguration containerRuntimeConfig) {
        this.containerRuntimeConfig = containerRuntimeConfig;
    }

    /**
     * ContainerRuntimeConfigSpec defines the desired state of ContainerRuntimeConfig
     */
    @JsonProperty("machineConfigPoolSelector")
    public LabelSelector getMachineConfigPoolSelector() {
        return machineConfigPoolSelector;
    }

    /**
     * ContainerRuntimeConfigSpec defines the desired state of ContainerRuntimeConfig
     */
    @JsonProperty("machineConfigPoolSelector")
    public void setMachineConfigPoolSelector(LabelSelector machineConfigPoolSelector) {
        this.machineConfigPoolSelector = machineConfigPoolSelector;
    }

    @JsonIgnore
    public ContainerRuntimeConfigSpecBuilder edit() {
        return new ContainerRuntimeConfigSpecBuilder(this);
    }

    @JsonIgnore
    public ContainerRuntimeConfigSpecBuilder toBuilder() {
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
        if (!(o instanceof ContainerRuntimeConfigSpec)) {
            return false;
        }
        ContainerRuntimeConfigSpec other = (ContainerRuntimeConfigSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$containerRuntimeConfig = this.getContainerRuntimeConfig();
        Object other$containerRuntimeConfig = other.getContainerRuntimeConfig();
        if (this$containerRuntimeConfig == null ? other$containerRuntimeConfig != null : !this$containerRuntimeConfig.equals(other$containerRuntimeConfig)) {
            return false;
        }
        Object this$machineConfigPoolSelector = this.getMachineConfigPoolSelector();
        Object other$machineConfigPoolSelector = other.getMachineConfigPoolSelector();
        if (this$machineConfigPoolSelector == null ? other$machineConfigPoolSelector != null : !this$machineConfigPoolSelector.equals(other$machineConfigPoolSelector)) {
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
        return other instanceof ContainerRuntimeConfigSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $containerRuntimeConfig = this.getContainerRuntimeConfig();
        result = result * prime + ($containerRuntimeConfig == null ? 43 : $containerRuntimeConfig.hashCode());
        Object $machineConfigPoolSelector = this.getMachineConfigPoolSelector();
        result = result * prime + ($machineConfigPoolSelector == null ? 43 : $machineConfigPoolSelector.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ContainerRuntimeConfigSpec(" + "containerRuntimeConfig=" + this.getContainerRuntimeConfig() + ", machineConfigPoolSelector=" + this.getMachineConfigPoolSelector() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
