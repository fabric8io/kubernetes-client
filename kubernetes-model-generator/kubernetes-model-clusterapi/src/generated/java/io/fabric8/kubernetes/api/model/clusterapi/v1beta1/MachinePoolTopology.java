
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
 * MachinePoolTopology specifies the different parameters for a pool of worker nodes in the topology. This pool of nodes is managed by a MachinePool object whose lifecycle is managed by the Cluster controller.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "class",
    "failureDomains",
    "minReadySeconds",
    "name",
    "nodeDeletionTimeout",
    "nodeDrainTimeout",
    "nodeVolumeDetachTimeout",
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
public class MachinePoolTopology implements Editable<MachinePoolTopologyBuilder>, KubernetesResource
{

    @JsonProperty("class")
    private String className;
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> failureDomains = new ArrayList<>();
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("minReadySeconds")
    private Integer minReadySeconds;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nodeDeletionTimeout")
    private String nodeDeletionTimeout;
    @JsonProperty("nodeDrainTimeout")
    private String nodeDrainTimeout;
    @JsonProperty("nodeVolumeDetachTimeout")
    private String nodeVolumeDetachTimeout;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("variables")
    private MachinePoolVariables variables;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePoolTopology() {
    }

    public MachinePoolTopology(String className, List<String> failureDomains, ObjectMeta metadata, Integer minReadySeconds, String name, String nodeDeletionTimeout, String nodeDrainTimeout, String nodeVolumeDetachTimeout, Integer replicas, MachinePoolVariables variables) {
        super();
        this.className = className;
        this.failureDomains = failureDomains;
        this.metadata = metadata;
        this.minReadySeconds = minReadySeconds;
        this.name = name;
        this.nodeDeletionTimeout = nodeDeletionTimeout;
        this.nodeDrainTimeout = nodeDrainTimeout;
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
        this.replicas = replicas;
        this.variables = variables;
    }

    /**
     * class is the name of the MachinePoolClass used to create the pool of worker nodes. This should match one of the deployment classes defined in the ClusterClass object mentioned in the `Cluster.Spec.Class` field.
     */
    @JsonProperty("class")
    public String getClassName() {
        return className;
    }

    /**
     * class is the name of the MachinePoolClass used to create the pool of worker nodes. This should match one of the deployment classes defined in the ClusterClass object mentioned in the `Cluster.Spec.Class` field.
     */
    @JsonProperty("class")
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * failureDomains is the list of failure domains the machine pool will be created in. Must match a key in the FailureDomains map stored on the cluster object.
     */
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFailureDomains() {
        return failureDomains;
    }

    /**
     * failureDomains is the list of failure domains the machine pool will be created in. Must match a key in the FailureDomains map stored on the cluster object.
     */
    @JsonProperty("failureDomains")
    public void setFailureDomains(List<String> failureDomains) {
        this.failureDomains = failureDomains;
    }

    /**
     * MachinePoolTopology specifies the different parameters for a pool of worker nodes in the topology. This pool of nodes is managed by a MachinePool object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * MachinePoolTopology specifies the different parameters for a pool of worker nodes in the topology. This pool of nodes is managed by a MachinePool object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * minReadySeconds is the minimum number of seconds for which a newly created machine pool should be ready. Defaults to 0 (machine will be considered available as soon as it is ready)
     */
    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    /**
     * minReadySeconds is the minimum number of seconds for which a newly created machine pool should be ready. Defaults to 0 (machine will be considered available as soon as it is ready)
     */
    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Integer minReadySeconds) {
        this.minReadySeconds = minReadySeconds;
    }

    /**
     * name is the unique identifier for this MachinePoolTopology. The value is used with other unique identifiers to create a MachinePool's Name (e.g. cluster's name, etc). In case the name is greater than the allowed maximum length, the values are hashed together.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the unique identifier for this MachinePoolTopology. The value is used with other unique identifiers to create a MachinePool's Name (e.g. cluster's name, etc). In case the name is greater than the allowed maximum length, the values are hashed together.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * MachinePoolTopology specifies the different parameters for a pool of worker nodes in the topology. This pool of nodes is managed by a MachinePool object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("nodeDeletionTimeout")
    public String getNodeDeletionTimeout() {
        return nodeDeletionTimeout;
    }

    /**
     * MachinePoolTopology specifies the different parameters for a pool of worker nodes in the topology. This pool of nodes is managed by a MachinePool object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("nodeDeletionTimeout")
    public void setNodeDeletionTimeout(String nodeDeletionTimeout) {
        this.nodeDeletionTimeout = nodeDeletionTimeout;
    }

    /**
     * MachinePoolTopology specifies the different parameters for a pool of worker nodes in the topology. This pool of nodes is managed by a MachinePool object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("nodeDrainTimeout")
    public String getNodeDrainTimeout() {
        return nodeDrainTimeout;
    }

    /**
     * MachinePoolTopology specifies the different parameters for a pool of worker nodes in the topology. This pool of nodes is managed by a MachinePool object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("nodeDrainTimeout")
    public void setNodeDrainTimeout(String nodeDrainTimeout) {
        this.nodeDrainTimeout = nodeDrainTimeout;
    }

    /**
     * MachinePoolTopology specifies the different parameters for a pool of worker nodes in the topology. This pool of nodes is managed by a MachinePool object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("nodeVolumeDetachTimeout")
    public String getNodeVolumeDetachTimeout() {
        return nodeVolumeDetachTimeout;
    }

    /**
     * MachinePoolTopology specifies the different parameters for a pool of worker nodes in the topology. This pool of nodes is managed by a MachinePool object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("nodeVolumeDetachTimeout")
    public void setNodeVolumeDetachTimeout(String nodeVolumeDetachTimeout) {
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
    }

    /**
     * replicas is the number of nodes belonging to this pool. If the value is nil, the MachinePool is created without the number of Replicas (defaulting to 1) and it's assumed that an external entity (like cluster autoscaler) is responsible for the management of this value.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas is the number of nodes belonging to this pool. If the value is nil, the MachinePool is created without the number of Replicas (defaulting to 1) and it's assumed that an external entity (like cluster autoscaler) is responsible for the management of this value.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * MachinePoolTopology specifies the different parameters for a pool of worker nodes in the topology. This pool of nodes is managed by a MachinePool object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("variables")
    public MachinePoolVariables getVariables() {
        return variables;
    }

    /**
     * MachinePoolTopology specifies the different parameters for a pool of worker nodes in the topology. This pool of nodes is managed by a MachinePool object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("variables")
    public void setVariables(MachinePoolVariables variables) {
        this.variables = variables;
    }

    @JsonIgnore
    public MachinePoolTopologyBuilder edit() {
        return new MachinePoolTopologyBuilder(this);
    }

    @JsonIgnore
    public MachinePoolTopologyBuilder toBuilder() {
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
