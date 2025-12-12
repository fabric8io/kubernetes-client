
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * ControlPlaneClass defines the class for the control plane.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "machineHealthCheck",
    "machineInfrastructure",
    "namingStrategy",
    "nodeDeletionTimeout",
    "nodeDrainTimeout",
    "nodeVolumeDetachTimeout",
    "readinessGates",
    "ref"
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
public class ControlPlaneClass implements Editable<ControlPlaneClassBuilder>, KubernetesResource
{

    @JsonProperty("machineHealthCheck")
    private MachineHealthCheckClass machineHealthCheck;
    @JsonProperty("machineInfrastructure")
    private LocalObjectTemplate machineInfrastructure;
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("namingStrategy")
    private ControlPlaneClassNamingStrategy namingStrategy;
    @JsonProperty("nodeDeletionTimeout")
    private String nodeDeletionTimeout;
    @JsonProperty("nodeDrainTimeout")
    private String nodeDrainTimeout;
    @JsonProperty("nodeVolumeDetachTimeout")
    private String nodeVolumeDetachTimeout;
    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineReadinessGate> readinessGates = new ArrayList<>();
    @JsonProperty("ref")
    private ObjectReference ref;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ControlPlaneClass() {
    }

    public ControlPlaneClass(MachineHealthCheckClass machineHealthCheck, LocalObjectTemplate machineInfrastructure, ObjectMeta metadata, ControlPlaneClassNamingStrategy namingStrategy, String nodeDeletionTimeout, String nodeDrainTimeout, String nodeVolumeDetachTimeout, List<MachineReadinessGate> readinessGates, ObjectReference ref) {
        super();
        this.machineHealthCheck = machineHealthCheck;
        this.machineInfrastructure = machineInfrastructure;
        this.metadata = metadata;
        this.namingStrategy = namingStrategy;
        this.nodeDeletionTimeout = nodeDeletionTimeout;
        this.nodeDrainTimeout = nodeDrainTimeout;
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
        this.readinessGates = readinessGates;
        this.ref = ref;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("machineHealthCheck")
    public MachineHealthCheckClass getMachineHealthCheck() {
        return machineHealthCheck;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("machineHealthCheck")
    public void setMachineHealthCheck(MachineHealthCheckClass machineHealthCheck) {
        this.machineHealthCheck = machineHealthCheck;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("machineInfrastructure")
    public LocalObjectTemplate getMachineInfrastructure() {
        return machineInfrastructure;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("machineInfrastructure")
    public void setMachineInfrastructure(LocalObjectTemplate machineInfrastructure) {
        this.machineInfrastructure = machineInfrastructure;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("namingStrategy")
    public ControlPlaneClassNamingStrategy getNamingStrategy() {
        return namingStrategy;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("namingStrategy")
    public void setNamingStrategy(ControlPlaneClassNamingStrategy namingStrategy) {
        this.namingStrategy = namingStrategy;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("nodeDeletionTimeout")
    public String getNodeDeletionTimeout() {
        return nodeDeletionTimeout;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("nodeDeletionTimeout")
    public void setNodeDeletionTimeout(String nodeDeletionTimeout) {
        this.nodeDeletionTimeout = nodeDeletionTimeout;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("nodeDrainTimeout")
    public String getNodeDrainTimeout() {
        return nodeDrainTimeout;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("nodeDrainTimeout")
    public void setNodeDrainTimeout(String nodeDrainTimeout) {
        this.nodeDrainTimeout = nodeDrainTimeout;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("nodeVolumeDetachTimeout")
    public String getNodeVolumeDetachTimeout() {
        return nodeVolumeDetachTimeout;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("nodeVolumeDetachTimeout")
    public void setNodeVolumeDetachTimeout(String nodeVolumeDetachTimeout) {
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
    }

    /**
     * readinessGates specifies additional conditions to include when evaluating Machine Ready condition.<br><p> <br><p> This field can be used e.g. to instruct the machine controller to include in the computation for Machine's ready computation a condition, managed by an external controllers, reporting the status of special software/hardware installed on the Machine.<br><p> <br><p> NOTE: This field is considered only for computing v1beta2 conditions. NOTE: If a Cluster defines a custom list of readinessGates for the control plane, such list overrides readinessGates defined in this field. NOTE: Specific control plane provider implementations might automatically extend the list of readinessGates; e.g. the kubeadm control provider adds ReadinessGates for the APIServerPodHealthy, SchedulerPodHealthy conditions, etc.
     */
    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineReadinessGate> getReadinessGates() {
        return readinessGates;
    }

    /**
     * readinessGates specifies additional conditions to include when evaluating Machine Ready condition.<br><p> <br><p> This field can be used e.g. to instruct the machine controller to include in the computation for Machine's ready computation a condition, managed by an external controllers, reporting the status of special software/hardware installed on the Machine.<br><p> <br><p> NOTE: This field is considered only for computing v1beta2 conditions. NOTE: If a Cluster defines a custom list of readinessGates for the control plane, such list overrides readinessGates defined in this field. NOTE: Specific control plane provider implementations might automatically extend the list of readinessGates; e.g. the kubeadm control provider adds ReadinessGates for the APIServerPodHealthy, SchedulerPodHealthy conditions, etc.
     */
    @JsonProperty("readinessGates")
    public void setReadinessGates(List<MachineReadinessGate> readinessGates) {
        this.readinessGates = readinessGates;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("ref")
    public ObjectReference getRef() {
        return ref;
    }

    /**
     * ControlPlaneClass defines the class for the control plane.
     */
    @JsonProperty("ref")
    public void setRef(ObjectReference ref) {
        this.ref = ref;
    }

    @JsonIgnore
    public ControlPlaneClassBuilder edit() {
        return new ControlPlaneClassBuilder(this);
    }

    @JsonIgnore
    public ControlPlaneClassBuilder toBuilder() {
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
