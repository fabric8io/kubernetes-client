
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
 * MachineSpec defines the desired state of Machine.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bootstrap",
    "clusterName",
    "failureDomain",
    "infrastructureRef",
    "nodeDeletionTimeout",
    "nodeDrainTimeout",
    "nodeVolumeDetachTimeout",
    "providerID",
    "readinessGates",
    "version"
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
public class MachineSpec implements Editable<MachineSpecBuilder>, KubernetesResource
{

    @JsonProperty("bootstrap")
    private Bootstrap bootstrap;
    @JsonProperty("clusterName")
    private String clusterName;
    @JsonProperty("failureDomain")
    private String failureDomain;
    @JsonProperty("infrastructureRef")
    private ObjectReference infrastructureRef;
    @JsonProperty("nodeDeletionTimeout")
    private String nodeDeletionTimeout;
    @JsonProperty("nodeDrainTimeout")
    private String nodeDrainTimeout;
    @JsonProperty("nodeVolumeDetachTimeout")
    private String nodeVolumeDetachTimeout;
    @JsonProperty("providerID")
    private String providerID;
    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineReadinessGate> readinessGates = new ArrayList<>();
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineSpec() {
    }

    public MachineSpec(Bootstrap bootstrap, String clusterName, String failureDomain, ObjectReference infrastructureRef, String nodeDeletionTimeout, String nodeDrainTimeout, String nodeVolumeDetachTimeout, String providerID, List<MachineReadinessGate> readinessGates, String version) {
        super();
        this.bootstrap = bootstrap;
        this.clusterName = clusterName;
        this.failureDomain = failureDomain;
        this.infrastructureRef = infrastructureRef;
        this.nodeDeletionTimeout = nodeDeletionTimeout;
        this.nodeDrainTimeout = nodeDrainTimeout;
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
        this.providerID = providerID;
        this.readinessGates = readinessGates;
        this.version = version;
    }

    /**
     * MachineSpec defines the desired state of Machine.
     */
    @JsonProperty("bootstrap")
    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    /**
     * MachineSpec defines the desired state of Machine.
     */
    @JsonProperty("bootstrap")
    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    /**
     * clusterName is the name of the Cluster this object belongs to.
     */
    @JsonProperty("clusterName")
    public String getClusterName() {
        return clusterName;
    }

    /**
     * clusterName is the name of the Cluster this object belongs to.
     */
    @JsonProperty("clusterName")
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /**
     * failureDomain is the failure domain the machine will be created in. Must match a key in the FailureDomains map stored on the cluster object.
     */
    @JsonProperty("failureDomain")
    public String getFailureDomain() {
        return failureDomain;
    }

    /**
     * failureDomain is the failure domain the machine will be created in. Must match a key in the FailureDomains map stored on the cluster object.
     */
    @JsonProperty("failureDomain")
    public void setFailureDomain(String failureDomain) {
        this.failureDomain = failureDomain;
    }

    /**
     * MachineSpec defines the desired state of Machine.
     */
    @JsonProperty("infrastructureRef")
    public ObjectReference getInfrastructureRef() {
        return infrastructureRef;
    }

    /**
     * MachineSpec defines the desired state of Machine.
     */
    @JsonProperty("infrastructureRef")
    public void setInfrastructureRef(ObjectReference infrastructureRef) {
        this.infrastructureRef = infrastructureRef;
    }

    /**
     * MachineSpec defines the desired state of Machine.
     */
    @JsonProperty("nodeDeletionTimeout")
    public String getNodeDeletionTimeout() {
        return nodeDeletionTimeout;
    }

    /**
     * MachineSpec defines the desired state of Machine.
     */
    @JsonProperty("nodeDeletionTimeout")
    public void setNodeDeletionTimeout(String nodeDeletionTimeout) {
        this.nodeDeletionTimeout = nodeDeletionTimeout;
    }

    /**
     * MachineSpec defines the desired state of Machine.
     */
    @JsonProperty("nodeDrainTimeout")
    public String getNodeDrainTimeout() {
        return nodeDrainTimeout;
    }

    /**
     * MachineSpec defines the desired state of Machine.
     */
    @JsonProperty("nodeDrainTimeout")
    public void setNodeDrainTimeout(String nodeDrainTimeout) {
        this.nodeDrainTimeout = nodeDrainTimeout;
    }

    /**
     * MachineSpec defines the desired state of Machine.
     */
    @JsonProperty("nodeVolumeDetachTimeout")
    public String getNodeVolumeDetachTimeout() {
        return nodeVolumeDetachTimeout;
    }

    /**
     * MachineSpec defines the desired state of Machine.
     */
    @JsonProperty("nodeVolumeDetachTimeout")
    public void setNodeVolumeDetachTimeout(String nodeVolumeDetachTimeout) {
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
    }

    /**
     * providerID is the identification ID of the machine provided by the provider. This field must match the provider ID as seen on the node object corresponding to this machine. This field is required by higher level consumers of cluster-api. Example use case is cluster autoscaler with cluster-api as provider. Clean-up logic in the autoscaler compares machines to nodes to find out machines at provider which could not get registered as Kubernetes nodes. With cluster-api as a generic out-of-tree provider for autoscaler, this field is required by autoscaler to be able to have a provider view of the list of machines. Another list of nodes is queried from the k8s apiserver and then a comparison is done to find out unregistered machines and are marked for delete. This field will be set by the actuators and consumed by higher level entities like autoscaler that will be interfacing with cluster-api as generic provider.
     */
    @JsonProperty("providerID")
    public String getProviderID() {
        return providerID;
    }

    /**
     * providerID is the identification ID of the machine provided by the provider. This field must match the provider ID as seen on the node object corresponding to this machine. This field is required by higher level consumers of cluster-api. Example use case is cluster autoscaler with cluster-api as provider. Clean-up logic in the autoscaler compares machines to nodes to find out machines at provider which could not get registered as Kubernetes nodes. With cluster-api as a generic out-of-tree provider for autoscaler, this field is required by autoscaler to be able to have a provider view of the list of machines. Another list of nodes is queried from the k8s apiserver and then a comparison is done to find out unregistered machines and are marked for delete. This field will be set by the actuators and consumed by higher level entities like autoscaler that will be interfacing with cluster-api as generic provider.
     */
    @JsonProperty("providerID")
    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    /**
     * readinessGates specifies additional conditions to include when evaluating Machine Ready condition.<br><p> <br><p> This field can be used e.g. by Cluster API control plane providers to extend the semantic of the Ready condition for the Machine they control, like the kubeadm control provider adding ReadinessGates for the APIServerPodHealthy, SchedulerPodHealthy conditions, etc.<br><p> <br><p> Another example are external controllers, e.g. responsible to install special software/hardware on the Machines; they can include the status of those components with a new condition and add this condition to ReadinessGates.<br><p> <br><p> NOTE: This field is considered only for computing v1beta2 conditions. NOTE: In case readinessGates conditions start with the APIServer, ControllerManager, Scheduler prefix, and all those readiness gates condition are reporting the same message, when computing the Machine's Ready condition those readinessGates will be replaced by a single entry reporting "Control plane components: " + message. This helps to improve readability of conditions bubbling up to the Machine's owner resource / to the Cluster).
     */
    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineReadinessGate> getReadinessGates() {
        return readinessGates;
    }

    /**
     * readinessGates specifies additional conditions to include when evaluating Machine Ready condition.<br><p> <br><p> This field can be used e.g. by Cluster API control plane providers to extend the semantic of the Ready condition for the Machine they control, like the kubeadm control provider adding ReadinessGates for the APIServerPodHealthy, SchedulerPodHealthy conditions, etc.<br><p> <br><p> Another example are external controllers, e.g. responsible to install special software/hardware on the Machines; they can include the status of those components with a new condition and add this condition to ReadinessGates.<br><p> <br><p> NOTE: This field is considered only for computing v1beta2 conditions. NOTE: In case readinessGates conditions start with the APIServer, ControllerManager, Scheduler prefix, and all those readiness gates condition are reporting the same message, when computing the Machine's Ready condition those readinessGates will be replaced by a single entry reporting "Control plane components: " + message. This helps to improve readability of conditions bubbling up to the Machine's owner resource / to the Cluster).
     */
    @JsonProperty("readinessGates")
    public void setReadinessGates(List<MachineReadinessGate> readinessGates) {
        this.readinessGates = readinessGates;
    }

    /**
     * version defines the desired Kubernetes version. This field is meant to be optionally used by bootstrap providers.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version defines the desired Kubernetes version. This field is meant to be optionally used by bootstrap providers.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public MachineSpecBuilder edit() {
        return new MachineSpecBuilder(this);
    }

    @JsonIgnore
    public MachineSpecBuilder toBuilder() {
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
