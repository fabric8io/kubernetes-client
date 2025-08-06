
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
 * MachineOSConfigStatus describes the status this config object and relates it to the builds associated with this MachineOSConfig
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "currentImagePullSpec",
    "machineOSBuild",
    "observedGeneration"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class MachineOSConfigStatus implements Editable<MachineOSConfigStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("currentImagePullSpec")
    private String currentImagePullSpec;
    @JsonProperty("machineOSBuild")
    private ObjectReference machineOSBuild;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineOSConfigStatus() {
    }

    public MachineOSConfigStatus(List<Condition> conditions, String currentImagePullSpec, ObjectReference machineOSBuild, Long observedGeneration) {
        super();
        this.conditions = conditions;
        this.currentImagePullSpec = currentImagePullSpec;
        this.machineOSBuild = machineOSBuild;
        this.observedGeneration = observedGeneration;
    }

    /**
     * conditions are state related conditions for the object.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions are state related conditions for the object.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * currentImagePullSpec is the fully qualified image pull spec used by the MCO to pull down the new OSImage. This includes the sha256 image digest. This is generated when the Machine Config Operator's build controller successfully completes the build, and is populated from the corresponding MachineOSBuild object's FinalImagePushSpec. This may change after completion in reaction to spec changes that would cause a new image build, but will not be removed. The format of the image pull spec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;, where the digest must be 64 characters long, and consist only of lowercase hexadecimal characters, a-f and 0-9. The length of the whole spec must be between 1 to 447 characters.
     */
    @JsonProperty("currentImagePullSpec")
    public String getCurrentImagePullSpec() {
        return currentImagePullSpec;
    }

    /**
     * currentImagePullSpec is the fully qualified image pull spec used by the MCO to pull down the new OSImage. This includes the sha256 image digest. This is generated when the Machine Config Operator's build controller successfully completes the build, and is populated from the corresponding MachineOSBuild object's FinalImagePushSpec. This may change after completion in reaction to spec changes that would cause a new image build, but will not be removed. The format of the image pull spec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;, where the digest must be 64 characters long, and consist only of lowercase hexadecimal characters, a-f and 0-9. The length of the whole spec must be between 1 to 447 characters.
     */
    @JsonProperty("currentImagePullSpec")
    public void setCurrentImagePullSpec(String currentImagePullSpec) {
        this.currentImagePullSpec = currentImagePullSpec;
    }

    /**
     * MachineOSConfigStatus describes the status this config object and relates it to the builds associated with this MachineOSConfig
     */
    @JsonProperty("machineOSBuild")
    public ObjectReference getMachineOSBuild() {
        return machineOSBuild;
    }

    /**
     * MachineOSConfigStatus describes the status this config object and relates it to the builds associated with this MachineOSConfig
     */
    @JsonProperty("machineOSBuild")
    public void setMachineOSBuild(ObjectReference machineOSBuild) {
        this.machineOSBuild = machineOSBuild;
    }

    /**
     * observedGeneration represents the generation of the MachineOSConfig object observed by the Machine Config Operator's build controller.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration represents the generation of the MachineOSConfig object observed by the Machine Config Operator's build controller.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonIgnore
    public MachineOSConfigStatusBuilder edit() {
        return new MachineOSConfigStatusBuilder(this);
    }

    @JsonIgnore
    public MachineOSConfigStatusBuilder toBuilder() {
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

}
