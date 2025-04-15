
package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "buildInputs",
    "buildOutputs",
    "machineConfigPool"
})
@ToString
@EqualsAndHashCode
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class MachineOSConfigSpec implements Editable<MachineOSConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("buildInputs")
    private BuildInputs buildInputs;
    @JsonProperty("buildOutputs")
    private BuildOutputs buildOutputs;
    @JsonProperty("machineConfigPool")
    private MachineConfigPoolReference machineConfigPool;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineOSConfigSpec() {
    }

    public MachineOSConfigSpec(BuildInputs buildInputs, BuildOutputs buildOutputs, MachineConfigPoolReference machineConfigPool) {
        super();
        this.buildInputs = buildInputs;
        this.buildOutputs = buildOutputs;
        this.machineConfigPool = machineConfigPool;
    }

    /**
     * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
     */
    @JsonProperty("buildInputs")
    public BuildInputs getBuildInputs() {
        return buildInputs;
    }

    /**
     * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
     */
    @JsonProperty("buildInputs")
    public void setBuildInputs(BuildInputs buildInputs) {
        this.buildInputs = buildInputs;
    }

    /**
     * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
     */
    @JsonProperty("buildOutputs")
    public BuildOutputs getBuildOutputs() {
        return buildOutputs;
    }

    /**
     * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
     */
    @JsonProperty("buildOutputs")
    public void setBuildOutputs(BuildOutputs buildOutputs) {
        this.buildOutputs = buildOutputs;
    }

    /**
     * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
     */
    @JsonProperty("machineConfigPool")
    public MachineConfigPoolReference getMachineConfigPool() {
        return machineConfigPool;
    }

    /**
     * MachineOSConfigSpec describes user-configurable options as well as information about a build process.
     */
    @JsonProperty("machineConfigPool")
    public void setMachineConfigPool(MachineConfigPoolReference machineConfigPool) {
        this.machineConfigPool = machineConfigPool;
    }

    @JsonIgnore
    public MachineOSConfigSpecBuilder edit() {
        return new MachineOSConfigSpecBuilder(this);
    }

    @JsonIgnore
    public MachineOSConfigSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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

}
