
package io.fabric8.openshift.api.model.hive.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Taint;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "autoscaling",
    "clusterDeploymentRef",
    "labels",
    "name",
    "platform",
    "replicas",
    "taints"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class MachinePoolSpec implements KubernetesResource
{

    @JsonProperty("autoscaling")
    private MachinePoolAutoscaling autoscaling;
    @JsonProperty("clusterDeploymentRef")
    private io.fabric8.kubernetes.api.model.LocalObjectReference clusterDeploymentRef;
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<String, String>();
    @JsonProperty("name")
    private java.lang.String name;
    @JsonProperty("platform")
    private MachinePoolPlatform platform;
    @JsonProperty("replicas")
    private Long replicas;
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Taint> taints = new ArrayList<Taint>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachinePoolSpec() {
    }

    public MachinePoolSpec(MachinePoolAutoscaling autoscaling, io.fabric8.kubernetes.api.model.LocalObjectReference clusterDeploymentRef, Map<String, String> labels, java.lang.String name, MachinePoolPlatform platform, Long replicas, List<Taint> taints) {
        super();
        this.autoscaling = autoscaling;
        this.clusterDeploymentRef = clusterDeploymentRef;
        this.labels = labels;
        this.name = name;
        this.platform = platform;
        this.replicas = replicas;
        this.taints = taints;
    }

    @JsonProperty("autoscaling")
    public MachinePoolAutoscaling getAutoscaling() {
        return autoscaling;
    }

    @JsonProperty("autoscaling")
    public void setAutoscaling(MachinePoolAutoscaling autoscaling) {
        this.autoscaling = autoscaling;
    }

    @JsonProperty("clusterDeploymentRef")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getClusterDeploymentRef() {
        return clusterDeploymentRef;
    }

    @JsonProperty("clusterDeploymentRef")
    public void setClusterDeploymentRef(io.fabric8.kubernetes.api.model.LocalObjectReference clusterDeploymentRef) {
        this.clusterDeploymentRef = clusterDeploymentRef;
    }

    @JsonProperty("labels")
    public Map<String, String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    @JsonProperty("name")
    public java.lang.String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(java.lang.String name) {
        this.name = name;
    }

    @JsonProperty("platform")
    public MachinePoolPlatform getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    public void setPlatform(MachinePoolPlatform platform) {
        this.platform = platform;
    }

    @JsonProperty("replicas")
    public Long getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Long replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("taints")
    public List<Taint> getTaints() {
        return taints;
    }

    @JsonProperty("taints")
    public void setTaints(List<Taint> taints) {
        this.taints = taints;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
