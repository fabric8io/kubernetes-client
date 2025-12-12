
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
 * Topology encapsulates the information of the managed resources.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "class",
    "classNamespace",
    "controlPlane",
    "rolloutAfter",
    "variables",
    "version",
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
public class Topology implements Editable<TopologyBuilder>, KubernetesResource
{

    @JsonProperty("class")
    private String className;
    @JsonProperty("classNamespace")
    private String classNamespace;
    @JsonProperty("controlPlane")
    private ControlPlaneTopology controlPlane;
    @JsonProperty("rolloutAfter")
    private String rolloutAfter;
    @JsonProperty("variables")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterVariable> variables = new ArrayList<>();
    @JsonProperty("version")
    private String version;
    @JsonProperty("workers")
    private WorkersTopology workers;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Topology() {
    }

    public Topology(String className, String classNamespace, ControlPlaneTopology controlPlane, String rolloutAfter, List<ClusterVariable> variables, String version, WorkersTopology workers) {
        super();
        this.className = className;
        this.classNamespace = classNamespace;
        this.controlPlane = controlPlane;
        this.rolloutAfter = rolloutAfter;
        this.variables = variables;
        this.version = version;
        this.workers = workers;
    }

    /**
     * class is the name of the ClusterClass object to create the topology.
     */
    @JsonProperty("class")
    public String getClassName() {
        return className;
    }

    /**
     * class is the name of the ClusterClass object to create the topology.
     */
    @JsonProperty("class")
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * classNamespace is the namespace of the ClusterClass that should be used for the topology. If classNamespace is empty or not set, it is defaulted to the namespace of the Cluster object. classNamespace must be a valid namespace name and because of that be at most 63 characters in length and it must consist only of lower case alphanumeric characters or hyphens (-), and must start and end with an alphanumeric character.
     */
    @JsonProperty("classNamespace")
    public String getClassNamespace() {
        return classNamespace;
    }

    /**
     * classNamespace is the namespace of the ClusterClass that should be used for the topology. If classNamespace is empty or not set, it is defaulted to the namespace of the Cluster object. classNamespace must be a valid namespace name and because of that be at most 63 characters in length and it must consist only of lower case alphanumeric characters or hyphens (-), and must start and end with an alphanumeric character.
     */
    @JsonProperty("classNamespace")
    public void setClassNamespace(String classNamespace) {
        this.classNamespace = classNamespace;
    }

    /**
     * Topology encapsulates the information of the managed resources.
     */
    @JsonProperty("controlPlane")
    public ControlPlaneTopology getControlPlane() {
        return controlPlane;
    }

    /**
     * Topology encapsulates the information of the managed resources.
     */
    @JsonProperty("controlPlane")
    public void setControlPlane(ControlPlaneTopology controlPlane) {
        this.controlPlane = controlPlane;
    }

    /**
     * Topology encapsulates the information of the managed resources.
     */
    @JsonProperty("rolloutAfter")
    public String getRolloutAfter() {
        return rolloutAfter;
    }

    /**
     * Topology encapsulates the information of the managed resources.
     */
    @JsonProperty("rolloutAfter")
    public void setRolloutAfter(String rolloutAfter) {
        this.rolloutAfter = rolloutAfter;
    }

    /**
     * variables can be used to customize the Cluster through patches. They must comply to the corresponding VariableClasses defined in the ClusterClass.
     */
    @JsonProperty("variables")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterVariable> getVariables() {
        return variables;
    }

    /**
     * variables can be used to customize the Cluster through patches. They must comply to the corresponding VariableClasses defined in the ClusterClass.
     */
    @JsonProperty("variables")
    public void setVariables(List<ClusterVariable> variables) {
        this.variables = variables;
    }

    /**
     * version is the Kubernetes version of the cluster.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version is the Kubernetes version of the cluster.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Topology encapsulates the information of the managed resources.
     */
    @JsonProperty("workers")
    public WorkersTopology getWorkers() {
        return workers;
    }

    /**
     * Topology encapsulates the information of the managed resources.
     */
    @JsonProperty("workers")
    public void setWorkers(WorkersTopology workers) {
        this.workers = workers;
    }

    @JsonIgnore
    public TopologyBuilder edit() {
        return new TopologyBuilder(this);
    }

    @JsonIgnore
    public TopologyBuilder toBuilder() {
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
