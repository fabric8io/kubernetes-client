
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
 * MachineDeploymentTopology specifies the different parameters for a set of worker nodes in the topology. This set of nodes is managed by a MachineDeployment object whose lifecycle is managed by the Cluster controller.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "class",
    "failureDomain",
    "machineHealthCheck",
    "minReadySeconds",
    "name",
    "nodeDeletionTimeout",
    "nodeDrainTimeout",
    "nodeVolumeDetachTimeout",
    "readinessGates",
    "replicas",
    "strategy",
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
public class MachineDeploymentTopology implements Editable<MachineDeploymentTopologyBuilder>, KubernetesResource
{

    @JsonProperty("class")
    private String className;
    @JsonProperty("failureDomain")
    private String failureDomain;
    @JsonProperty("machineHealthCheck")
    private MachineHealthCheckTopology machineHealthCheck;
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
    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineReadinessGate> readinessGates = new ArrayList<>();
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("strategy")
    private MachineDeploymentStrategy strategy;
    @JsonProperty("variables")
    private MachineDeploymentVariables variables;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineDeploymentTopology() {
    }

    public MachineDeploymentTopology(String className, String failureDomain, MachineHealthCheckTopology machineHealthCheck, ObjectMeta metadata, Integer minReadySeconds, String name, String nodeDeletionTimeout, String nodeDrainTimeout, String nodeVolumeDetachTimeout, List<MachineReadinessGate> readinessGates, Integer replicas, MachineDeploymentStrategy strategy, MachineDeploymentVariables variables) {
        super();
        this.className = className;
        this.failureDomain = failureDomain;
        this.machineHealthCheck = machineHealthCheck;
        this.metadata = metadata;
        this.minReadySeconds = minReadySeconds;
        this.name = name;
        this.nodeDeletionTimeout = nodeDeletionTimeout;
        this.nodeDrainTimeout = nodeDrainTimeout;
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
        this.readinessGates = readinessGates;
        this.replicas = replicas;
        this.strategy = strategy;
        this.variables = variables;
    }

    /**
     * class is the name of the MachineDeploymentClass used to create the set of worker nodes. This should match one of the deployment classes defined in the ClusterClass object mentioned in the `Cluster.Spec.Class` field.
     */
    @JsonProperty("class")
    public String getClassName() {
        return className;
    }

    /**
     * class is the name of the MachineDeploymentClass used to create the set of worker nodes. This should match one of the deployment classes defined in the ClusterClass object mentioned in the `Cluster.Spec.Class` field.
     */
    @JsonProperty("class")
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * failureDomain is the failure domain the machines will be created in. Must match a key in the FailureDomains map stored on the cluster object.
     */
    @JsonProperty("failureDomain")
    public String getFailureDomain() {
        return failureDomain;
    }

    /**
     * failureDomain is the failure domain the machines will be created in. Must match a key in the FailureDomains map stored on the cluster object.
     */
    @JsonProperty("failureDomain")
    public void setFailureDomain(String failureDomain) {
        this.failureDomain = failureDomain;
    }

    /**
     * MachineDeploymentTopology specifies the different parameters for a set of worker nodes in the topology. This set of nodes is managed by a MachineDeployment object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("machineHealthCheck")
    public MachineHealthCheckTopology getMachineHealthCheck() {
        return machineHealthCheck;
    }

    /**
     * MachineDeploymentTopology specifies the different parameters for a set of worker nodes in the topology. This set of nodes is managed by a MachineDeployment object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("machineHealthCheck")
    public void setMachineHealthCheck(MachineHealthCheckTopology machineHealthCheck) {
        this.machineHealthCheck = machineHealthCheck;
    }

    /**
     * MachineDeploymentTopology specifies the different parameters for a set of worker nodes in the topology. This set of nodes is managed by a MachineDeployment object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * MachineDeploymentTopology specifies the different parameters for a set of worker nodes in the topology. This set of nodes is managed by a MachineDeployment object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * minReadySeconds is the minimum number of seconds for which a newly created machine should be ready. Defaults to 0 (machine will be considered available as soon as it is ready)
     */
    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    /**
     * minReadySeconds is the minimum number of seconds for which a newly created machine should be ready. Defaults to 0 (machine will be considered available as soon as it is ready)
     */
    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Integer minReadySeconds) {
        this.minReadySeconds = minReadySeconds;
    }

    /**
     * name is the unique identifier for this MachineDeploymentTopology. The value is used with other unique identifiers to create a MachineDeployment's Name (e.g. cluster's name, etc). In case the name is greater than the allowed maximum length, the values are hashed together.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the unique identifier for this MachineDeploymentTopology. The value is used with other unique identifiers to create a MachineDeployment's Name (e.g. cluster's name, etc). In case the name is greater than the allowed maximum length, the values are hashed together.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * MachineDeploymentTopology specifies the different parameters for a set of worker nodes in the topology. This set of nodes is managed by a MachineDeployment object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("nodeDeletionTimeout")
    public String getNodeDeletionTimeout() {
        return nodeDeletionTimeout;
    }

    /**
     * MachineDeploymentTopology specifies the different parameters for a set of worker nodes in the topology. This set of nodes is managed by a MachineDeployment object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("nodeDeletionTimeout")
    public void setNodeDeletionTimeout(String nodeDeletionTimeout) {
        this.nodeDeletionTimeout = nodeDeletionTimeout;
    }

    /**
     * MachineDeploymentTopology specifies the different parameters for a set of worker nodes in the topology. This set of nodes is managed by a MachineDeployment object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("nodeDrainTimeout")
    public String getNodeDrainTimeout() {
        return nodeDrainTimeout;
    }

    /**
     * MachineDeploymentTopology specifies the different parameters for a set of worker nodes in the topology. This set of nodes is managed by a MachineDeployment object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("nodeDrainTimeout")
    public void setNodeDrainTimeout(String nodeDrainTimeout) {
        this.nodeDrainTimeout = nodeDrainTimeout;
    }

    /**
     * MachineDeploymentTopology specifies the different parameters for a set of worker nodes in the topology. This set of nodes is managed by a MachineDeployment object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("nodeVolumeDetachTimeout")
    public String getNodeVolumeDetachTimeout() {
        return nodeVolumeDetachTimeout;
    }

    /**
     * MachineDeploymentTopology specifies the different parameters for a set of worker nodes in the topology. This set of nodes is managed by a MachineDeployment object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("nodeVolumeDetachTimeout")
    public void setNodeVolumeDetachTimeout(String nodeVolumeDetachTimeout) {
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
    }

    /**
     * readinessGates specifies additional conditions to include when evaluating Machine Ready condition.<br><p> <br><p> This field can be used e.g. to instruct the machine controller to include in the computation for Machine's ready computation a condition, managed by an external controllers, reporting the status of special software/hardware installed on the Machine.<br><p> <br><p> If this field is not defined, readinessGates from the corresponding MachineDeploymentClass will be used, if any.<br><p> <br><p> NOTE: This field is considered only for computing v1beta2 conditions.
     */
    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineReadinessGate> getReadinessGates() {
        return readinessGates;
    }

    /**
     * readinessGates specifies additional conditions to include when evaluating Machine Ready condition.<br><p> <br><p> This field can be used e.g. to instruct the machine controller to include in the computation for Machine's ready computation a condition, managed by an external controllers, reporting the status of special software/hardware installed on the Machine.<br><p> <br><p> If this field is not defined, readinessGates from the corresponding MachineDeploymentClass will be used, if any.<br><p> <br><p> NOTE: This field is considered only for computing v1beta2 conditions.
     */
    @JsonProperty("readinessGates")
    public void setReadinessGates(List<MachineReadinessGate> readinessGates) {
        this.readinessGates = readinessGates;
    }

    /**
     * replicas is the number of worker nodes belonging to this set. If the value is nil, the MachineDeployment is created without the number of Replicas (defaulting to 1) and it's assumed that an external entity (like cluster autoscaler) is responsible for the management of this value.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas is the number of worker nodes belonging to this set. If the value is nil, the MachineDeployment is created without the number of Replicas (defaulting to 1) and it's assumed that an external entity (like cluster autoscaler) is responsible for the management of this value.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * MachineDeploymentTopology specifies the different parameters for a set of worker nodes in the topology. This set of nodes is managed by a MachineDeployment object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("strategy")
    public MachineDeploymentStrategy getStrategy() {
        return strategy;
    }

    /**
     * MachineDeploymentTopology specifies the different parameters for a set of worker nodes in the topology. This set of nodes is managed by a MachineDeployment object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("strategy")
    public void setStrategy(MachineDeploymentStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * MachineDeploymentTopology specifies the different parameters for a set of worker nodes in the topology. This set of nodes is managed by a MachineDeployment object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("variables")
    public MachineDeploymentVariables getVariables() {
        return variables;
    }

    /**
     * MachineDeploymentTopology specifies the different parameters for a set of worker nodes in the topology. This set of nodes is managed by a MachineDeployment object whose lifecycle is managed by the Cluster controller.
     */
    @JsonProperty("variables")
    public void setVariables(MachineDeploymentVariables variables) {
        this.variables = variables;
    }

    @JsonIgnore
    public MachineDeploymentTopologyBuilder edit() {
        return new MachineDeploymentTopologyBuilder(this);
    }

    @JsonIgnore
    public MachineDeploymentTopologyBuilder toBuilder() {
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
