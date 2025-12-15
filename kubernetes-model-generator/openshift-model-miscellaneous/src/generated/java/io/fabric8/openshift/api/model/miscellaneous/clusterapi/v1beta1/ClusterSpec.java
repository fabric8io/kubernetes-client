
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
 * ClusterSpec defines the desired state of Cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availabilityGates",
    "clusterNetwork",
    "controlPlaneEndpoint",
    "controlPlaneRef",
    "infrastructureRef",
    "paused",
    "topology"
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
public class ClusterSpec implements Editable<ClusterSpecBuilder>, KubernetesResource
{

    @JsonProperty("availabilityGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterAvailabilityGate> availabilityGates = new ArrayList<>();
    @JsonProperty("clusterNetwork")
    private ClusterNetwork clusterNetwork;
    @JsonProperty("controlPlaneEndpoint")
    private APIEndpoint controlPlaneEndpoint;
    @JsonProperty("controlPlaneRef")
    private ObjectReference controlPlaneRef;
    @JsonProperty("infrastructureRef")
    private ObjectReference infrastructureRef;
    @JsonProperty("paused")
    private Boolean paused;
    @JsonProperty("topology")
    private Topology topology;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterSpec() {
    }

    public ClusterSpec(List<ClusterAvailabilityGate> availabilityGates, ClusterNetwork clusterNetwork, APIEndpoint controlPlaneEndpoint, ObjectReference controlPlaneRef, ObjectReference infrastructureRef, Boolean paused, Topology topology) {
        super();
        this.availabilityGates = availabilityGates;
        this.clusterNetwork = clusterNetwork;
        this.controlPlaneEndpoint = controlPlaneEndpoint;
        this.controlPlaneRef = controlPlaneRef;
        this.infrastructureRef = infrastructureRef;
        this.paused = paused;
        this.topology = topology;
    }

    /**
     * availabilityGates specifies additional conditions to include when evaluating Cluster Available condition.<br><p> <br><p> If this field is not defined and the Cluster implements a managed topology, availabilityGates from the corresponding ClusterClass will be used, if any.<br><p> <br><p> NOTE: this field is considered only for computing v1beta2 conditions.
     */
    @JsonProperty("availabilityGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterAvailabilityGate> getAvailabilityGates() {
        return availabilityGates;
    }

    /**
     * availabilityGates specifies additional conditions to include when evaluating Cluster Available condition.<br><p> <br><p> If this field is not defined and the Cluster implements a managed topology, availabilityGates from the corresponding ClusterClass will be used, if any.<br><p> <br><p> NOTE: this field is considered only for computing v1beta2 conditions.
     */
    @JsonProperty("availabilityGates")
    public void setAvailabilityGates(List<ClusterAvailabilityGate> availabilityGates) {
        this.availabilityGates = availabilityGates;
    }

    /**
     * ClusterSpec defines the desired state of Cluster.
     */
    @JsonProperty("clusterNetwork")
    public ClusterNetwork getClusterNetwork() {
        return clusterNetwork;
    }

    /**
     * ClusterSpec defines the desired state of Cluster.
     */
    @JsonProperty("clusterNetwork")
    public void setClusterNetwork(ClusterNetwork clusterNetwork) {
        this.clusterNetwork = clusterNetwork;
    }

    /**
     * ClusterSpec defines the desired state of Cluster.
     */
    @JsonProperty("controlPlaneEndpoint")
    public APIEndpoint getControlPlaneEndpoint() {
        return controlPlaneEndpoint;
    }

    /**
     * ClusterSpec defines the desired state of Cluster.
     */
    @JsonProperty("controlPlaneEndpoint")
    public void setControlPlaneEndpoint(APIEndpoint controlPlaneEndpoint) {
        this.controlPlaneEndpoint = controlPlaneEndpoint;
    }

    /**
     * ClusterSpec defines the desired state of Cluster.
     */
    @JsonProperty("controlPlaneRef")
    public ObjectReference getControlPlaneRef() {
        return controlPlaneRef;
    }

    /**
     * ClusterSpec defines the desired state of Cluster.
     */
    @JsonProperty("controlPlaneRef")
    public void setControlPlaneRef(ObjectReference controlPlaneRef) {
        this.controlPlaneRef = controlPlaneRef;
    }

    /**
     * ClusterSpec defines the desired state of Cluster.
     */
    @JsonProperty("infrastructureRef")
    public ObjectReference getInfrastructureRef() {
        return infrastructureRef;
    }

    /**
     * ClusterSpec defines the desired state of Cluster.
     */
    @JsonProperty("infrastructureRef")
    public void setInfrastructureRef(ObjectReference infrastructureRef) {
        this.infrastructureRef = infrastructureRef;
    }

    /**
     * paused can be used to prevent controllers from processing the Cluster and all its associated objects.
     */
    @JsonProperty("paused")
    public Boolean getPaused() {
        return paused;
    }

    /**
     * paused can be used to prevent controllers from processing the Cluster and all its associated objects.
     */
    @JsonProperty("paused")
    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    /**
     * ClusterSpec defines the desired state of Cluster.
     */
    @JsonProperty("topology")
    public Topology getTopology() {
        return topology;
    }

    /**
     * ClusterSpec defines the desired state of Cluster.
     */
    @JsonProperty("topology")
    public void setTopology(Topology topology) {
        this.topology = topology;
    }

    @JsonIgnore
    public ClusterSpecBuilder edit() {
        return new ClusterSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterSpecBuilder toBuilder() {
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
