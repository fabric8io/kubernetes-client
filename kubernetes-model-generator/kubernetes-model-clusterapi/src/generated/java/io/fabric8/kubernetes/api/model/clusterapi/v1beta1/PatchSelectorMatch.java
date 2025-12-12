
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * PatchSelectorMatch selects templates based on where they are referenced. Note: The selector must match at least one template. Note: The results of selection based on the individual fields are ORed.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "controlPlane",
    "infrastructureCluster",
    "machineDeploymentClass",
    "machinePoolClass"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class PatchSelectorMatch implements Editable<PatchSelectorMatchBuilder>, KubernetesResource
{

    @JsonProperty("controlPlane")
    private Boolean controlPlane;
    @JsonProperty("infrastructureCluster")
    private Boolean infrastructureCluster;
    @JsonProperty("machineDeploymentClass")
    private PatchSelectorMatchMachineDeploymentClass machineDeploymentClass;
    @JsonProperty("machinePoolClass")
    private PatchSelectorMatchMachinePoolClass machinePoolClass;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PatchSelectorMatch() {
    }

    public PatchSelectorMatch(Boolean controlPlane, Boolean infrastructureCluster, PatchSelectorMatchMachineDeploymentClass machineDeploymentClass, PatchSelectorMatchMachinePoolClass machinePoolClass) {
        super();
        this.controlPlane = controlPlane;
        this.infrastructureCluster = infrastructureCluster;
        this.machineDeploymentClass = machineDeploymentClass;
        this.machinePoolClass = machinePoolClass;
    }

    /**
     * controlPlane selects templates referenced in .spec.ControlPlane. Note: this will match the controlPlane and also the controlPlane machineInfrastructure (depending on the kind and apiVersion).
     */
    @JsonProperty("controlPlane")
    public Boolean getControlPlane() {
        return controlPlane;
    }

    /**
     * controlPlane selects templates referenced in .spec.ControlPlane. Note: this will match the controlPlane and also the controlPlane machineInfrastructure (depending on the kind and apiVersion).
     */
    @JsonProperty("controlPlane")
    public void setControlPlane(Boolean controlPlane) {
        this.controlPlane = controlPlane;
    }

    /**
     * infrastructureCluster selects templates referenced in .spec.infrastructure.
     */
    @JsonProperty("infrastructureCluster")
    public Boolean getInfrastructureCluster() {
        return infrastructureCluster;
    }

    /**
     * infrastructureCluster selects templates referenced in .spec.infrastructure.
     */
    @JsonProperty("infrastructureCluster")
    public void setInfrastructureCluster(Boolean infrastructureCluster) {
        this.infrastructureCluster = infrastructureCluster;
    }

    /**
     * PatchSelectorMatch selects templates based on where they are referenced. Note: The selector must match at least one template. Note: The results of selection based on the individual fields are ORed.
     */
    @JsonProperty("machineDeploymentClass")
    public PatchSelectorMatchMachineDeploymentClass getMachineDeploymentClass() {
        return machineDeploymentClass;
    }

    /**
     * PatchSelectorMatch selects templates based on where they are referenced. Note: The selector must match at least one template. Note: The results of selection based on the individual fields are ORed.
     */
    @JsonProperty("machineDeploymentClass")
    public void setMachineDeploymentClass(PatchSelectorMatchMachineDeploymentClass machineDeploymentClass) {
        this.machineDeploymentClass = machineDeploymentClass;
    }

    /**
     * PatchSelectorMatch selects templates based on where they are referenced. Note: The selector must match at least one template. Note: The results of selection based on the individual fields are ORed.
     */
    @JsonProperty("machinePoolClass")
    public PatchSelectorMatchMachinePoolClass getMachinePoolClass() {
        return machinePoolClass;
    }

    /**
     * PatchSelectorMatch selects templates based on where they are referenced. Note: The selector must match at least one template. Note: The results of selection based on the individual fields are ORed.
     */
    @JsonProperty("machinePoolClass")
    public void setMachinePoolClass(PatchSelectorMatchMachinePoolClass machinePoolClass) {
        this.machinePoolClass = machinePoolClass;
    }

    @JsonIgnore
    public PatchSelectorMatchBuilder edit() {
        return new PatchSelectorMatchBuilder(this);
    }

    @JsonIgnore
    public PatchSelectorMatchBuilder toBuilder() {
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
