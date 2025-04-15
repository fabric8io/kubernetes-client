
package io.fabric8.openshift.api.model.hive.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Taint;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * MachinePoolSpec defines the desired state of MachinePool
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "autoscaling",
    "clusterDeploymentRef",
    "labels",
    "machineLabels",
    "name",
    "platform",
    "replicas",
    "taints"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
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
public class MachinePoolSpec implements Editable<MachinePoolSpecBuilder>, KubernetesResource
{

    @JsonProperty("autoscaling")
    private MachinePoolAutoscaling autoscaling;
    @JsonProperty("clusterDeploymentRef")
    private LocalObjectReference clusterDeploymentRef;
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
    @JsonProperty("machineLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> machineLabels = new LinkedHashMap<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("platform")
    private MachinePoolPlatform platform;
    @JsonProperty("replicas")
    private Long replicas;
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Taint> taints = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePoolSpec() {
    }

    public MachinePoolSpec(MachinePoolAutoscaling autoscaling, LocalObjectReference clusterDeploymentRef, Map<String, String> labels, Map<String, String> machineLabels, String name, MachinePoolPlatform platform, Long replicas, List<Taint> taints) {
        super();
        this.autoscaling = autoscaling;
        this.clusterDeploymentRef = clusterDeploymentRef;
        this.labels = labels;
        this.machineLabels = machineLabels;
        this.name = name;
        this.platform = platform;
        this.replicas = replicas;
        this.taints = taints;
    }

    /**
     * MachinePoolSpec defines the desired state of MachinePool
     */
    @JsonProperty("autoscaling")
    public MachinePoolAutoscaling getAutoscaling() {
        return autoscaling;
    }

    /**
     * MachinePoolSpec defines the desired state of MachinePool
     */
    @JsonProperty("autoscaling")
    public void setAutoscaling(MachinePoolAutoscaling autoscaling) {
        this.autoscaling = autoscaling;
    }

    /**
     * MachinePoolSpec defines the desired state of MachinePool
     */
    @JsonProperty("clusterDeploymentRef")
    public LocalObjectReference getClusterDeploymentRef() {
        return clusterDeploymentRef;
    }

    /**
     * MachinePoolSpec defines the desired state of MachinePool
     */
    @JsonProperty("clusterDeploymentRef")
    public void setClusterDeploymentRef(LocalObjectReference clusterDeploymentRef) {
        this.clusterDeploymentRef = clusterDeploymentRef;
    }

    /**
     * Map of label string keys and values that will be applied to the created MachineSet's MachineSpec. This affects the labels that will end up on the &#42;Nodes&#42; (in contrast with the MachineLabels field). This list will overwrite any modifications made to Node labels on an ongoing basis.
     */
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * Map of label string keys and values that will be applied to the created MachineSet's MachineSpec. This affects the labels that will end up on the &#42;Nodes&#42; (in contrast with the MachineLabels field). This list will overwrite any modifications made to Node labels on an ongoing basis.
     */
    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    /**
     * Map of label string keys and values that will be applied to the created MachineSet's MachineTemplateSpec. This affects the labels that will end up on the &#42;Machines&#42; (in contrast with the Labels field). This list will overwrite any modifications made to Machine labels on an ongoing basis. Note: We ignore entries that conflict with generated labels.
     */
    @JsonProperty("machineLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getMachineLabels() {
        return machineLabels;
    }

    /**
     * Map of label string keys and values that will be applied to the created MachineSet's MachineTemplateSpec. This affects the labels that will end up on the &#42;Machines&#42; (in contrast with the Labels field). This list will overwrite any modifications made to Machine labels on an ongoing basis. Note: We ignore entries that conflict with generated labels.
     */
    @JsonProperty("machineLabels")
    public void setMachineLabels(Map<String, String> machineLabels) {
        this.machineLabels = machineLabels;
    }

    /**
     * Name is the name of the machine pool.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the machine pool.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * MachinePoolSpec defines the desired state of MachinePool
     */
    @JsonProperty("platform")
    public MachinePoolPlatform getPlatform() {
        return platform;
    }

    /**
     * MachinePoolSpec defines the desired state of MachinePool
     */
    @JsonProperty("platform")
    public void setPlatform(MachinePoolPlatform platform) {
        this.platform = platform;
    }

    /**
     * Replicas is the count of machines for this machine pool. Replicas and autoscaling cannot be used together. Default is 1, if autoscaling is not used.
     */
    @JsonProperty("replicas")
    public Long getReplicas() {
        return replicas;
    }

    /**
     * Replicas is the count of machines for this machine pool. Replicas and autoscaling cannot be used together. Default is 1, if autoscaling is not used.
     */
    @JsonProperty("replicas")
    public void setReplicas(Long replicas) {
        this.replicas = replicas;
    }

    /**
     * List of taints that will be applied to the created MachineSet's MachineSpec. This list will overwrite any modifications made to Node taints on an ongoing basis. In case of duplicate entries, first encountered taint Value will be preserved, and the rest collapsed on the corresponding MachineSets. Note that taints are uniquely identified based on key+effect, not just key.
     */
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Taint> getTaints() {
        return taints;
    }

    /**
     * List of taints that will be applied to the created MachineSet's MachineSpec. This list will overwrite any modifications made to Node taints on an ongoing basis. In case of duplicate entries, first encountered taint Value will be preserved, and the rest collapsed on the corresponding MachineSets. Note that taints are uniquely identified based on key+effect, not just key.
     */
    @JsonProperty("taints")
    public void setTaints(List<Taint> taints) {
        this.taints = taints;
    }

    @JsonIgnore
    public MachinePoolSpecBuilder edit() {
        return new MachinePoolSpecBuilder(this);
    }

    @JsonIgnore
    public MachinePoolSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
