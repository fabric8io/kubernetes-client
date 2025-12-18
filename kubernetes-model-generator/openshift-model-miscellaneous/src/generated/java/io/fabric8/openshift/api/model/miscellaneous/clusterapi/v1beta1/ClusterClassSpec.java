
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1;

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
 * ClusterClassSpec describes the desired state of the ClusterClass.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availabilityGates",
    "controlPlane",
    "infrastructure",
    "infrastructureNamingStrategy",
    "patches",
    "variables",
    "workers"
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
public class ClusterClassSpec implements Editable<ClusterClassSpecBuilder>, KubernetesResource
{

    @JsonProperty("availabilityGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterAvailabilityGate> availabilityGates = new ArrayList<>();
    @JsonProperty("controlPlane")
    private ControlPlaneClass controlPlane;
    @JsonProperty("infrastructure")
    private LocalObjectTemplate infrastructure;
    @JsonProperty("infrastructureNamingStrategy")
    private InfrastructureNamingStrategy infrastructureNamingStrategy;
    @JsonProperty("patches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterClassPatch> patches = new ArrayList<>();
    @JsonProperty("variables")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterClassVariable> variables = new ArrayList<>();
    @JsonProperty("workers")
    private WorkersClass workers;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterClassSpec() {
    }

    public ClusterClassSpec(List<ClusterAvailabilityGate> availabilityGates, ControlPlaneClass controlPlane, LocalObjectTemplate infrastructure, InfrastructureNamingStrategy infrastructureNamingStrategy, List<ClusterClassPatch> patches, List<ClusterClassVariable> variables, WorkersClass workers) {
        super();
        this.availabilityGates = availabilityGates;
        this.controlPlane = controlPlane;
        this.infrastructure = infrastructure;
        this.infrastructureNamingStrategy = infrastructureNamingStrategy;
        this.patches = patches;
        this.variables = variables;
        this.workers = workers;
    }

    /**
     * availabilityGates specifies additional conditions to include when evaluating Cluster Available condition.<br><p> <br><p> NOTE: this field is considered only for computing v1beta2 conditions. NOTE: If a Cluster is using this ClusterClass, and this Cluster defines a custom list of availabilityGates, such list overrides availabilityGates defined in this field.
     */
    @JsonProperty("availabilityGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterAvailabilityGate> getAvailabilityGates() {
        return availabilityGates;
    }

    /**
     * availabilityGates specifies additional conditions to include when evaluating Cluster Available condition.<br><p> <br><p> NOTE: this field is considered only for computing v1beta2 conditions. NOTE: If a Cluster is using this ClusterClass, and this Cluster defines a custom list of availabilityGates, such list overrides availabilityGates defined in this field.
     */
    @JsonProperty("availabilityGates")
    public void setAvailabilityGates(List<ClusterAvailabilityGate> availabilityGates) {
        this.availabilityGates = availabilityGates;
    }

    /**
     * ClusterClassSpec describes the desired state of the ClusterClass.
     */
    @JsonProperty("controlPlane")
    public ControlPlaneClass getControlPlane() {
        return controlPlane;
    }

    /**
     * ClusterClassSpec describes the desired state of the ClusterClass.
     */
    @JsonProperty("controlPlane")
    public void setControlPlane(ControlPlaneClass controlPlane) {
        this.controlPlane = controlPlane;
    }

    /**
     * ClusterClassSpec describes the desired state of the ClusterClass.
     */
    @JsonProperty("infrastructure")
    public LocalObjectTemplate getInfrastructure() {
        return infrastructure;
    }

    /**
     * ClusterClassSpec describes the desired state of the ClusterClass.
     */
    @JsonProperty("infrastructure")
    public void setInfrastructure(LocalObjectTemplate infrastructure) {
        this.infrastructure = infrastructure;
    }

    /**
     * ClusterClassSpec describes the desired state of the ClusterClass.
     */
    @JsonProperty("infrastructureNamingStrategy")
    public InfrastructureNamingStrategy getInfrastructureNamingStrategy() {
        return infrastructureNamingStrategy;
    }

    /**
     * ClusterClassSpec describes the desired state of the ClusterClass.
     */
    @JsonProperty("infrastructureNamingStrategy")
    public void setInfrastructureNamingStrategy(InfrastructureNamingStrategy infrastructureNamingStrategy) {
        this.infrastructureNamingStrategy = infrastructureNamingStrategy;
    }

    /**
     * patches defines the patches which are applied to customize referenced templates of a ClusterClass. Note: Patches will be applied in the order of the array.
     */
    @JsonProperty("patches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterClassPatch> getPatches() {
        return patches;
    }

    /**
     * patches defines the patches which are applied to customize referenced templates of a ClusterClass. Note: Patches will be applied in the order of the array.
     */
    @JsonProperty("patches")
    public void setPatches(List<ClusterClassPatch> patches) {
        this.patches = patches;
    }

    /**
     * variables defines the variables which can be configured in the Cluster topology and are then used in patches.
     */
    @JsonProperty("variables")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterClassVariable> getVariables() {
        return variables;
    }

    /**
     * variables defines the variables which can be configured in the Cluster topology and are then used in patches.
     */
    @JsonProperty("variables")
    public void setVariables(List<ClusterClassVariable> variables) {
        this.variables = variables;
    }

    /**
     * ClusterClassSpec describes the desired state of the ClusterClass.
     */
    @JsonProperty("workers")
    public WorkersClass getWorkers() {
        return workers;
    }

    /**
     * ClusterClassSpec describes the desired state of the ClusterClass.
     */
    @JsonProperty("workers")
    public void setWorkers(WorkersClass workers) {
        this.workers = workers;
    }

    @JsonIgnore
    public ClusterClassSpecBuilder edit() {
        return new ClusterClassSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterClassSpecBuilder toBuilder() {
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
