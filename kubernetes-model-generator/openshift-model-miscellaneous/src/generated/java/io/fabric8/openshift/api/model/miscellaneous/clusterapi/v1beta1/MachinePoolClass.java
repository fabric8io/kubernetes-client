
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
 * MachinePoolClass serves as a template to define a pool of worker nodes of the cluster provisioned using `ClusterClass`.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "class",
    "failureDomains",
    "minReadySeconds",
    "namingStrategy",
    "nodeDeletionTimeout",
    "nodeDrainTimeout",
    "nodeVolumeDetachTimeout",
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
public class MachinePoolClass implements Editable<MachinePoolClassBuilder>, KubernetesResource
{

    @JsonProperty("class")
    private String className;
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> failureDomains = new ArrayList<>();
    @JsonProperty("minReadySeconds")
    private Integer minReadySeconds;
    @JsonProperty("namingStrategy")
    private MachinePoolClassNamingStrategy namingStrategy;
    @JsonProperty("nodeDeletionTimeout")
    private String nodeDeletionTimeout;
    @JsonProperty("nodeDrainTimeout")
    private String nodeDrainTimeout;
    @JsonProperty("nodeVolumeDetachTimeout")
    private String nodeVolumeDetachTimeout;
    @JsonProperty("template")
    private MachinePoolClassTemplate template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePoolClass() {
    }

    public MachinePoolClass(String className, List<String> failureDomains, Integer minReadySeconds, MachinePoolClassNamingStrategy namingStrategy, String nodeDeletionTimeout, String nodeDrainTimeout, String nodeVolumeDetachTimeout, MachinePoolClassTemplate template) {
        super();
        this.className = className;
        this.failureDomains = failureDomains;
        this.minReadySeconds = minReadySeconds;
        this.namingStrategy = namingStrategy;
        this.nodeDeletionTimeout = nodeDeletionTimeout;
        this.nodeDrainTimeout = nodeDrainTimeout;
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
        this.template = template;
    }

    /**
     * class denotes a type of machine pool present in the cluster, this name MUST be unique within a ClusterClass and can be referenced in the Cluster to create a managed MachinePool.
     */
    @JsonProperty("class")
    public String getClassName() {
        return className;
    }

    /**
     * class denotes a type of machine pool present in the cluster, this name MUST be unique within a ClusterClass and can be referenced in the Cluster to create a managed MachinePool.
     */
    @JsonProperty("class")
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * failureDomains is the list of failure domains the MachinePool should be attached to. Must match a key in the FailureDomains map stored on the cluster object. NOTE: This value can be overridden while defining a Cluster.Topology using this MachinePoolClass.
     */
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFailureDomains() {
        return failureDomains;
    }

    /**
     * failureDomains is the list of failure domains the MachinePool should be attached to. Must match a key in the FailureDomains map stored on the cluster object. NOTE: This value can be overridden while defining a Cluster.Topology using this MachinePoolClass.
     */
    @JsonProperty("failureDomains")
    public void setFailureDomains(List<String> failureDomains) {
        this.failureDomains = failureDomains;
    }

    /**
     * minReadySeconds is the minimum number of seconds for which a newly created machine pool should be ready. Defaults to 0 (machine will be considered available as soon as it is ready) NOTE: This value can be overridden while defining a Cluster.Topology using this MachinePoolClass.
     */
    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    /**
     * minReadySeconds is the minimum number of seconds for which a newly created machine pool should be ready. Defaults to 0 (machine will be considered available as soon as it is ready) NOTE: This value can be overridden while defining a Cluster.Topology using this MachinePoolClass.
     */
    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Integer minReadySeconds) {
        this.minReadySeconds = minReadySeconds;
    }

    /**
     * MachinePoolClass serves as a template to define a pool of worker nodes of the cluster provisioned using `ClusterClass`.
     */
    @JsonProperty("namingStrategy")
    public MachinePoolClassNamingStrategy getNamingStrategy() {
        return namingStrategy;
    }

    /**
     * MachinePoolClass serves as a template to define a pool of worker nodes of the cluster provisioned using `ClusterClass`.
     */
    @JsonProperty("namingStrategy")
    public void setNamingStrategy(MachinePoolClassNamingStrategy namingStrategy) {
        this.namingStrategy = namingStrategy;
    }

    /**
     * MachinePoolClass serves as a template to define a pool of worker nodes of the cluster provisioned using `ClusterClass`.
     */
    @JsonProperty("nodeDeletionTimeout")
    public String getNodeDeletionTimeout() {
        return nodeDeletionTimeout;
    }

    /**
     * MachinePoolClass serves as a template to define a pool of worker nodes of the cluster provisioned using `ClusterClass`.
     */
    @JsonProperty("nodeDeletionTimeout")
    public void setNodeDeletionTimeout(String nodeDeletionTimeout) {
        this.nodeDeletionTimeout = nodeDeletionTimeout;
    }

    /**
     * MachinePoolClass serves as a template to define a pool of worker nodes of the cluster provisioned using `ClusterClass`.
     */
    @JsonProperty("nodeDrainTimeout")
    public String getNodeDrainTimeout() {
        return nodeDrainTimeout;
    }

    /**
     * MachinePoolClass serves as a template to define a pool of worker nodes of the cluster provisioned using `ClusterClass`.
     */
    @JsonProperty("nodeDrainTimeout")
    public void setNodeDrainTimeout(String nodeDrainTimeout) {
        this.nodeDrainTimeout = nodeDrainTimeout;
    }

    /**
     * MachinePoolClass serves as a template to define a pool of worker nodes of the cluster provisioned using `ClusterClass`.
     */
    @JsonProperty("nodeVolumeDetachTimeout")
    public String getNodeVolumeDetachTimeout() {
        return nodeVolumeDetachTimeout;
    }

    /**
     * MachinePoolClass serves as a template to define a pool of worker nodes of the cluster provisioned using `ClusterClass`.
     */
    @JsonProperty("nodeVolumeDetachTimeout")
    public void setNodeVolumeDetachTimeout(String nodeVolumeDetachTimeout) {
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
    }

    /**
     * MachinePoolClass serves as a template to define a pool of worker nodes of the cluster provisioned using `ClusterClass`.
     */
    @JsonProperty("template")
    public MachinePoolClassTemplate getTemplate() {
        return template;
    }

    /**
     * MachinePoolClass serves as a template to define a pool of worker nodes of the cluster provisioned using `ClusterClass`.
     */
    @JsonProperty("template")
    public void setTemplate(MachinePoolClassTemplate template) {
        this.template = template;
    }

    @JsonIgnore
    public MachinePoolClassBuilder edit() {
        return new MachinePoolClassBuilder(this);
    }

    @JsonIgnore
    public MachinePoolClassBuilder toBuilder() {
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
