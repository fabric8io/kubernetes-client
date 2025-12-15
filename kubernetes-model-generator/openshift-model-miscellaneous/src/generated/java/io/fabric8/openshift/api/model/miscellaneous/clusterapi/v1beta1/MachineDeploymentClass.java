
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
 * MachineDeploymentClass serves as a template to define a set of worker nodes of the cluster provisioned using the `ClusterClass`.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "class",
    "failureDomain",
    "machineHealthCheck",
    "minReadySeconds",
    "namingStrategy",
    "nodeDeletionTimeout",
    "nodeDrainTimeout",
    "nodeVolumeDetachTimeout",
    "readinessGates",
    "strategy",
    "template"
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
public class MachineDeploymentClass implements Editable<MachineDeploymentClassBuilder>, KubernetesResource
{

    @JsonProperty("class")
    private String className;
    @JsonProperty("failureDomain")
    private String failureDomain;
    @JsonProperty("machineHealthCheck")
    private MachineHealthCheckClass machineHealthCheck;
    @JsonProperty("minReadySeconds")
    private Integer minReadySeconds;
    @JsonProperty("namingStrategy")
    private MachineDeploymentClassNamingStrategy namingStrategy;
    @JsonProperty("nodeDeletionTimeout")
    private String nodeDeletionTimeout;
    @JsonProperty("nodeDrainTimeout")
    private String nodeDrainTimeout;
    @JsonProperty("nodeVolumeDetachTimeout")
    private String nodeVolumeDetachTimeout;
    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineReadinessGate> readinessGates = new ArrayList<>();
    @JsonProperty("strategy")
    private MachineDeploymentStrategy strategy;
    @JsonProperty("template")
    private MachineDeploymentClassTemplate template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineDeploymentClass() {
    }

    public MachineDeploymentClass(String className, String failureDomain, MachineHealthCheckClass machineHealthCheck, Integer minReadySeconds, MachineDeploymentClassNamingStrategy namingStrategy, String nodeDeletionTimeout, String nodeDrainTimeout, String nodeVolumeDetachTimeout, List<MachineReadinessGate> readinessGates, MachineDeploymentStrategy strategy, MachineDeploymentClassTemplate template) {
        super();
        this.className = className;
        this.failureDomain = failureDomain;
        this.machineHealthCheck = machineHealthCheck;
        this.minReadySeconds = minReadySeconds;
        this.namingStrategy = namingStrategy;
        this.nodeDeletionTimeout = nodeDeletionTimeout;
        this.nodeDrainTimeout = nodeDrainTimeout;
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
        this.readinessGates = readinessGates;
        this.strategy = strategy;
        this.template = template;
    }

    /**
     * class denotes a type of worker node present in the cluster, this name MUST be unique within a ClusterClass and can be referenced in the Cluster to create a managed MachineDeployment.
     */
    @JsonProperty("class")
    public String getClassName() {
        return className;
    }

    /**
     * class denotes a type of worker node present in the cluster, this name MUST be unique within a ClusterClass and can be referenced in the Cluster to create a managed MachineDeployment.
     */
    @JsonProperty("class")
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * failureDomain is the failure domain the machines will be created in. Must match a key in the FailureDomains map stored on the cluster object. NOTE: This value can be overridden while defining a Cluster.Topology using this MachineDeploymentClass.
     */
    @JsonProperty("failureDomain")
    public String getFailureDomain() {
        return failureDomain;
    }

    /**
     * failureDomain is the failure domain the machines will be created in. Must match a key in the FailureDomains map stored on the cluster object. NOTE: This value can be overridden while defining a Cluster.Topology using this MachineDeploymentClass.
     */
    @JsonProperty("failureDomain")
    public void setFailureDomain(String failureDomain) {
        this.failureDomain = failureDomain;
    }

    /**
     * MachineDeploymentClass serves as a template to define a set of worker nodes of the cluster provisioned using the `ClusterClass`.
     */
    @JsonProperty("machineHealthCheck")
    public MachineHealthCheckClass getMachineHealthCheck() {
        return machineHealthCheck;
    }

    /**
     * MachineDeploymentClass serves as a template to define a set of worker nodes of the cluster provisioned using the `ClusterClass`.
     */
    @JsonProperty("machineHealthCheck")
    public void setMachineHealthCheck(MachineHealthCheckClass machineHealthCheck) {
        this.machineHealthCheck = machineHealthCheck;
    }

    /**
     * minReadySeconds is the minimum number of seconds for which a newly created machine should be ready. Defaults to 0 (machine will be considered available as soon as it is ready) NOTE: This value can be overridden while defining a Cluster.Topology using this MachineDeploymentClass.
     */
    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    /**
     * minReadySeconds is the minimum number of seconds for which a newly created machine should be ready. Defaults to 0 (machine will be considered available as soon as it is ready) NOTE: This value can be overridden while defining a Cluster.Topology using this MachineDeploymentClass.
     */
    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Integer minReadySeconds) {
        this.minReadySeconds = minReadySeconds;
    }

    /**
     * MachineDeploymentClass serves as a template to define a set of worker nodes of the cluster provisioned using the `ClusterClass`.
     */
    @JsonProperty("namingStrategy")
    public MachineDeploymentClassNamingStrategy getNamingStrategy() {
        return namingStrategy;
    }

    /**
     * MachineDeploymentClass serves as a template to define a set of worker nodes of the cluster provisioned using the `ClusterClass`.
     */
    @JsonProperty("namingStrategy")
    public void setNamingStrategy(MachineDeploymentClassNamingStrategy namingStrategy) {
        this.namingStrategy = namingStrategy;
    }

    /**
     * MachineDeploymentClass serves as a template to define a set of worker nodes of the cluster provisioned using the `ClusterClass`.
     */
    @JsonProperty("nodeDeletionTimeout")
    public String getNodeDeletionTimeout() {
        return nodeDeletionTimeout;
    }

    /**
     * MachineDeploymentClass serves as a template to define a set of worker nodes of the cluster provisioned using the `ClusterClass`.
     */
    @JsonProperty("nodeDeletionTimeout")
    public void setNodeDeletionTimeout(String nodeDeletionTimeout) {
        this.nodeDeletionTimeout = nodeDeletionTimeout;
    }

    /**
     * MachineDeploymentClass serves as a template to define a set of worker nodes of the cluster provisioned using the `ClusterClass`.
     */
    @JsonProperty("nodeDrainTimeout")
    public String getNodeDrainTimeout() {
        return nodeDrainTimeout;
    }

    /**
     * MachineDeploymentClass serves as a template to define a set of worker nodes of the cluster provisioned using the `ClusterClass`.
     */
    @JsonProperty("nodeDrainTimeout")
    public void setNodeDrainTimeout(String nodeDrainTimeout) {
        this.nodeDrainTimeout = nodeDrainTimeout;
    }

    /**
     * MachineDeploymentClass serves as a template to define a set of worker nodes of the cluster provisioned using the `ClusterClass`.
     */
    @JsonProperty("nodeVolumeDetachTimeout")
    public String getNodeVolumeDetachTimeout() {
        return nodeVolumeDetachTimeout;
    }

    /**
     * MachineDeploymentClass serves as a template to define a set of worker nodes of the cluster provisioned using the `ClusterClass`.
     */
    @JsonProperty("nodeVolumeDetachTimeout")
    public void setNodeVolumeDetachTimeout(String nodeVolumeDetachTimeout) {
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
    }

    /**
     * readinessGates specifies additional conditions to include when evaluating Machine Ready condition.<br><p> <br><p> This field can be used e.g. to instruct the machine controller to include in the computation for Machine's ready computation a condition, managed by an external controllers, reporting the status of special software/hardware installed on the Machine.<br><p> <br><p> NOTE: This field is considered only for computing v1beta2 conditions. NOTE: If a Cluster defines a custom list of readinessGates for a MachineDeployment using this MachineDeploymentClass, such list overrides readinessGates defined in this field.
     */
    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineReadinessGate> getReadinessGates() {
        return readinessGates;
    }

    /**
     * readinessGates specifies additional conditions to include when evaluating Machine Ready condition.<br><p> <br><p> This field can be used e.g. to instruct the machine controller to include in the computation for Machine's ready computation a condition, managed by an external controllers, reporting the status of special software/hardware installed on the Machine.<br><p> <br><p> NOTE: This field is considered only for computing v1beta2 conditions. NOTE: If a Cluster defines a custom list of readinessGates for a MachineDeployment using this MachineDeploymentClass, such list overrides readinessGates defined in this field.
     */
    @JsonProperty("readinessGates")
    public void setReadinessGates(List<MachineReadinessGate> readinessGates) {
        this.readinessGates = readinessGates;
    }

    /**
     * MachineDeploymentClass serves as a template to define a set of worker nodes of the cluster provisioned using the `ClusterClass`.
     */
    @JsonProperty("strategy")
    public MachineDeploymentStrategy getStrategy() {
        return strategy;
    }

    /**
     * MachineDeploymentClass serves as a template to define a set of worker nodes of the cluster provisioned using the `ClusterClass`.
     */
    @JsonProperty("strategy")
    public void setStrategy(MachineDeploymentStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * MachineDeploymentClass serves as a template to define a set of worker nodes of the cluster provisioned using the `ClusterClass`.
     */
    @JsonProperty("template")
    public MachineDeploymentClassTemplate getTemplate() {
        return template;
    }

    /**
     * MachineDeploymentClass serves as a template to define a set of worker nodes of the cluster provisioned using the `ClusterClass`.
     */
    @JsonProperty("template")
    public void setTemplate(MachineDeploymentClassTemplate template) {
        this.template = template;
    }

    @JsonIgnore
    public MachineDeploymentClassBuilder edit() {
        return new MachineDeploymentClassBuilder(this);
    }

    @JsonIgnore
    public MachineDeploymentClassBuilder toBuilder() {
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
