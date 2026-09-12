
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MachinePoolSpec)) {
            return false;
        }
        MachinePoolSpec other = (MachinePoolSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$autoscaling = this.getAutoscaling();
        Object other$autoscaling = other.getAutoscaling();
        if (this$autoscaling == null ? other$autoscaling != null : !this$autoscaling.equals(other$autoscaling)) {
            return false;
        }
        Object this$clusterDeploymentRef = this.getClusterDeploymentRef();
        Object other$clusterDeploymentRef = other.getClusterDeploymentRef();
        if (this$clusterDeploymentRef == null ? other$clusterDeploymentRef != null : !this$clusterDeploymentRef.equals(other$clusterDeploymentRef)) {
            return false;
        }
        Object this$labels = this.getLabels();
        Object other$labels = other.getLabels();
        if (this$labels == null ? other$labels != null : !this$labels.equals(other$labels)) {
            return false;
        }
        Object this$machineLabels = this.getMachineLabels();
        Object other$machineLabels = other.getMachineLabels();
        if (this$machineLabels == null ? other$machineLabels != null : !this$machineLabels.equals(other$machineLabels)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$platform = this.getPlatform();
        Object other$platform = other.getPlatform();
        if (this$platform == null ? other$platform != null : !this$platform.equals(other$platform)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
            return false;
        }
        Object this$taints = this.getTaints();
        Object other$taints = other.getTaints();
        if (this$taints == null ? other$taints != null : !this$taints.equals(other$taints)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof MachinePoolSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $autoscaling = this.getAutoscaling();
        result = result * prime + ($autoscaling == null ? 43 : $autoscaling.hashCode());
        Object $clusterDeploymentRef = this.getClusterDeploymentRef();
        result = result * prime + ($clusterDeploymentRef == null ? 43 : $clusterDeploymentRef.hashCode());
        Object $labels = this.getLabels();
        result = result * prime + ($labels == null ? 43 : $labels.hashCode());
        Object $machineLabels = this.getMachineLabels();
        result = result * prime + ($machineLabels == null ? 43 : $machineLabels.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $platform = this.getPlatform();
        result = result * prime + ($platform == null ? 43 : $platform.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $taints = this.getTaints();
        result = result * prime + ($taints == null ? 43 : $taints.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachinePoolSpec(" + "autoscaling=" + this.getAutoscaling() + ", clusterDeploymentRef=" + this.getClusterDeploymentRef() + ", labels=" + this.getLabels() + ", machineLabels=" + this.getMachineLabels() + ", name=" + this.getName() + ", platform=" + this.getPlatform() + ", replicas=" + this.getReplicas() + ", taints=" + this.getTaints() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
