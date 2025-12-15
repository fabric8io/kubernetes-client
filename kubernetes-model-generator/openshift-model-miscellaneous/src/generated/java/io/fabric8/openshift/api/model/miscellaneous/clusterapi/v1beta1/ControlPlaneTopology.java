
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
 * ControlPlaneTopology specifies the parameters for the control plane nodes in the cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "machineHealthCheck",
    "nodeDeletionTimeout",
    "nodeDrainTimeout",
    "nodeVolumeDetachTimeout",
    "readinessGates",
    "replicas",
    "variables"
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
public class ControlPlaneTopology implements Editable<ControlPlaneTopologyBuilder>, KubernetesResource
{

    @JsonProperty("machineHealthCheck")
    private MachineHealthCheckTopology machineHealthCheck;
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("nodeDeletionTimeout")
    private String nodeDeletionTimeout;
    @JsonProperty("nodeDrainTimeout")
    private String nodeDrainTimeout;
    @JsonProperty("nodeVolumeDetachTimeout")
    private String nodeVolumeDetachTimeout;
    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineReadinessGate> readinessGates = new ArrayList<>();
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("variables")
    private ControlPlaneVariables variables;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ControlPlaneTopology() {
    }

    public ControlPlaneTopology(MachineHealthCheckTopology machineHealthCheck, ObjectMeta metadata, String nodeDeletionTimeout, String nodeDrainTimeout, String nodeVolumeDetachTimeout, List<MachineReadinessGate> readinessGates, Integer replicas, ControlPlaneVariables variables) {
        super();
        this.machineHealthCheck = machineHealthCheck;
        this.metadata = metadata;
        this.nodeDeletionTimeout = nodeDeletionTimeout;
        this.nodeDrainTimeout = nodeDrainTimeout;
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
        this.readinessGates = readinessGates;
        this.replicas = replicas;
        this.variables = variables;
    }

    /**
     * ControlPlaneTopology specifies the parameters for the control plane nodes in the cluster.
     */
    @JsonProperty("machineHealthCheck")
    public MachineHealthCheckTopology getMachineHealthCheck() {
        return machineHealthCheck;
    }

    /**
     * ControlPlaneTopology specifies the parameters for the control plane nodes in the cluster.
     */
    @JsonProperty("machineHealthCheck")
    public void setMachineHealthCheck(MachineHealthCheckTopology machineHealthCheck) {
        this.machineHealthCheck = machineHealthCheck;
    }

    /**
     * ControlPlaneTopology specifies the parameters for the control plane nodes in the cluster.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * ControlPlaneTopology specifies the parameters for the control plane nodes in the cluster.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * ControlPlaneTopology specifies the parameters for the control plane nodes in the cluster.
     */
    @JsonProperty("nodeDeletionTimeout")
    public String getNodeDeletionTimeout() {
        return nodeDeletionTimeout;
    }

    /**
     * ControlPlaneTopology specifies the parameters for the control plane nodes in the cluster.
     */
    @JsonProperty("nodeDeletionTimeout")
    public void setNodeDeletionTimeout(String nodeDeletionTimeout) {
        this.nodeDeletionTimeout = nodeDeletionTimeout;
    }

    /**
     * ControlPlaneTopology specifies the parameters for the control plane nodes in the cluster.
     */
    @JsonProperty("nodeDrainTimeout")
    public String getNodeDrainTimeout() {
        return nodeDrainTimeout;
    }

    /**
     * ControlPlaneTopology specifies the parameters for the control plane nodes in the cluster.
     */
    @JsonProperty("nodeDrainTimeout")
    public void setNodeDrainTimeout(String nodeDrainTimeout) {
        this.nodeDrainTimeout = nodeDrainTimeout;
    }

    /**
     * ControlPlaneTopology specifies the parameters for the control plane nodes in the cluster.
     */
    @JsonProperty("nodeVolumeDetachTimeout")
    public String getNodeVolumeDetachTimeout() {
        return nodeVolumeDetachTimeout;
    }

    /**
     * ControlPlaneTopology specifies the parameters for the control plane nodes in the cluster.
     */
    @JsonProperty("nodeVolumeDetachTimeout")
    public void setNodeVolumeDetachTimeout(String nodeVolumeDetachTimeout) {
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
    }

    /**
     * readinessGates specifies additional conditions to include when evaluating Machine Ready condition.<br><p> <br><p> This field can be used e.g. to instruct the machine controller to include in the computation for Machine's ready computation a condition, managed by an external controllers, reporting the status of special software/hardware installed on the Machine.<br><p> <br><p> If this field is not defined, readinessGates from the corresponding ControlPlaneClass will be used, if any.<br><p> <br><p> NOTE: This field is considered only for computing v1beta2 conditions. NOTE: Specific control plane provider implementations might automatically extend the list of readinessGates; e.g. the kubeadm control provider adds ReadinessGates for the APIServerPodHealthy, SchedulerPodHealthy conditions, etc.
     */
    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineReadinessGate> getReadinessGates() {
        return readinessGates;
    }

    /**
     * readinessGates specifies additional conditions to include when evaluating Machine Ready condition.<br><p> <br><p> This field can be used e.g. to instruct the machine controller to include in the computation for Machine's ready computation a condition, managed by an external controllers, reporting the status of special software/hardware installed on the Machine.<br><p> <br><p> If this field is not defined, readinessGates from the corresponding ControlPlaneClass will be used, if any.<br><p> <br><p> NOTE: This field is considered only for computing v1beta2 conditions. NOTE: Specific control plane provider implementations might automatically extend the list of readinessGates; e.g. the kubeadm control provider adds ReadinessGates for the APIServerPodHealthy, SchedulerPodHealthy conditions, etc.
     */
    @JsonProperty("readinessGates")
    public void setReadinessGates(List<MachineReadinessGate> readinessGates) {
        this.readinessGates = readinessGates;
    }

    /**
     * replicas is the number of control plane nodes. If the value is nil, the ControlPlane object is created without the number of Replicas and it's assumed that the control plane controller does not implement support for this field. When specified against a control plane provider that lacks support for this field, this value will be ignored.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas is the number of control plane nodes. If the value is nil, the ControlPlane object is created without the number of Replicas and it's assumed that the control plane controller does not implement support for this field. When specified against a control plane provider that lacks support for this field, this value will be ignored.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * ControlPlaneTopology specifies the parameters for the control plane nodes in the cluster.
     */
    @JsonProperty("variables")
    public ControlPlaneVariables getVariables() {
        return variables;
    }

    /**
     * ControlPlaneTopology specifies the parameters for the control plane nodes in the cluster.
     */
    @JsonProperty("variables")
    public void setVariables(ControlPlaneVariables variables) {
        this.variables = variables;
    }

    @JsonIgnore
    public ControlPlaneTopologyBuilder edit() {
        return new ControlPlaneTopologyBuilder(this);
    }

    @JsonIgnore
    public ControlPlaneTopologyBuilder toBuilder() {
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
