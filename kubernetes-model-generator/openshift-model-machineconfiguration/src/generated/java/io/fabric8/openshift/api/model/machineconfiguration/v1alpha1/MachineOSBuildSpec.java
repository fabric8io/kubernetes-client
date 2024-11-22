
package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configGeneration",
    "desiredConfig",
    "machineOSConfig",
    "renderedImagePushspec",
    "version"
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
public class MachineOSBuildSpec implements Editable<MachineOSBuildSpecBuilder> , KubernetesResource
{

    @JsonProperty("configGeneration")
    private Long configGeneration;
    @JsonProperty("desiredConfig")
    private RenderedMachineConfigReference desiredConfig;
    @JsonProperty("machineOSConfig")
    private MachineOSConfigReference machineOSConfig;
    @JsonProperty("renderedImagePushspec")
    private String renderedImagePushspec;
    @JsonProperty("version")
    private Long version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachineOSBuildSpec() {
    }

    public MachineOSBuildSpec(Long configGeneration, RenderedMachineConfigReference desiredConfig, MachineOSConfigReference machineOSConfig, String renderedImagePushspec, Long version) {
        super();
        this.configGeneration = configGeneration;
        this.desiredConfig = desiredConfig;
        this.machineOSConfig = machineOSConfig;
        this.renderedImagePushspec = renderedImagePushspec;
        this.version = version;
    }

    @JsonProperty("configGeneration")
    public Long getConfigGeneration() {
        return configGeneration;
    }

    @JsonProperty("configGeneration")
    public void setConfigGeneration(Long configGeneration) {
        this.configGeneration = configGeneration;
    }

    @JsonProperty("desiredConfig")
    public RenderedMachineConfigReference getDesiredConfig() {
        return desiredConfig;
    }

    @JsonProperty("desiredConfig")
    public void setDesiredConfig(RenderedMachineConfigReference desiredConfig) {
        this.desiredConfig = desiredConfig;
    }

    @JsonProperty("machineOSConfig")
    public MachineOSConfigReference getMachineOSConfig() {
        return machineOSConfig;
    }

    @JsonProperty("machineOSConfig")
    public void setMachineOSConfig(MachineOSConfigReference machineOSConfig) {
        this.machineOSConfig = machineOSConfig;
    }

    @JsonProperty("renderedImagePushspec")
    public String getRenderedImagePushspec() {
        return renderedImagePushspec;
    }

    @JsonProperty("renderedImagePushspec")
    public void setRenderedImagePushspec(String renderedImagePushspec) {
        this.renderedImagePushspec = renderedImagePushspec;
    }

    @JsonProperty("version")
    public Long getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Long version) {
        this.version = version;
    }

    @JsonIgnore
    public MachineOSBuildSpecBuilder edit() {
        return new MachineOSBuildSpecBuilder(this);
    }

    @JsonIgnore
    public MachineOSBuildSpecBuilder toBuilder() {
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
