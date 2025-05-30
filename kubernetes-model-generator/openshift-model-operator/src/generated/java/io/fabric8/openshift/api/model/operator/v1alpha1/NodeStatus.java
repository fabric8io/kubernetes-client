
package io.fabric8.openshift.api.model.operator.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * NodeStatus provides information about the current state of a particular node managed by this operator. Deprecated: Use v1.NodeStatus instead
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currentDeploymentGeneration",
    "lastFailedDeploymentErrors",
    "lastFailedDeploymentGeneration",
    "nodeName",
    "targetDeploymentGeneration"
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
public class NodeStatus implements Editable<NodeStatusBuilder>, KubernetesResource
{

    @JsonProperty("currentDeploymentGeneration")
    private Integer currentDeploymentGeneration;
    @JsonProperty("lastFailedDeploymentErrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> lastFailedDeploymentErrors = new ArrayList<>();
    @JsonProperty("lastFailedDeploymentGeneration")
    private Integer lastFailedDeploymentGeneration;
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("targetDeploymentGeneration")
    private Integer targetDeploymentGeneration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeStatus() {
    }

    public NodeStatus(Integer currentDeploymentGeneration, List<String> lastFailedDeploymentErrors, Integer lastFailedDeploymentGeneration, String nodeName, Integer targetDeploymentGeneration) {
        super();
        this.currentDeploymentGeneration = currentDeploymentGeneration;
        this.lastFailedDeploymentErrors = lastFailedDeploymentErrors;
        this.lastFailedDeploymentGeneration = lastFailedDeploymentGeneration;
        this.nodeName = nodeName;
        this.targetDeploymentGeneration = targetDeploymentGeneration;
    }

    /**
     * currentDeploymentGeneration is the generation of the most recently successful deployment
     */
    @JsonProperty("currentDeploymentGeneration")
    public Integer getCurrentDeploymentGeneration() {
        return currentDeploymentGeneration;
    }

    /**
     * currentDeploymentGeneration is the generation of the most recently successful deployment
     */
    @JsonProperty("currentDeploymentGeneration")
    public void setCurrentDeploymentGeneration(Integer currentDeploymentGeneration) {
        this.currentDeploymentGeneration = currentDeploymentGeneration;
    }

    /**
     * lastFailedDeploymentGenerationErrors is a list of the errors during the failed deployment referenced in lastFailedDeploymentGeneration
     */
    @JsonProperty("lastFailedDeploymentErrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getLastFailedDeploymentErrors() {
        return lastFailedDeploymentErrors;
    }

    /**
     * lastFailedDeploymentGenerationErrors is a list of the errors during the failed deployment referenced in lastFailedDeploymentGeneration
     */
    @JsonProperty("lastFailedDeploymentErrors")
    public void setLastFailedDeploymentErrors(List<String> lastFailedDeploymentErrors) {
        this.lastFailedDeploymentErrors = lastFailedDeploymentErrors;
    }

    /**
     * lastFailedDeploymentGeneration is the generation of the deployment we tried and failed to deploy.
     */
    @JsonProperty("lastFailedDeploymentGeneration")
    public Integer getLastFailedDeploymentGeneration() {
        return lastFailedDeploymentGeneration;
    }

    /**
     * lastFailedDeploymentGeneration is the generation of the deployment we tried and failed to deploy.
     */
    @JsonProperty("lastFailedDeploymentGeneration")
    public void setLastFailedDeploymentGeneration(Integer lastFailedDeploymentGeneration) {
        this.lastFailedDeploymentGeneration = lastFailedDeploymentGeneration;
    }

    /**
     * nodeName is the name of the node
     */
    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    /**
     * nodeName is the name of the node
     */
    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * targetDeploymentGeneration is the generation of the deployment we're trying to apply
     */
    @JsonProperty("targetDeploymentGeneration")
    public Integer getTargetDeploymentGeneration() {
        return targetDeploymentGeneration;
    }

    /**
     * targetDeploymentGeneration is the generation of the deployment we're trying to apply
     */
    @JsonProperty("targetDeploymentGeneration")
    public void setTargetDeploymentGeneration(Integer targetDeploymentGeneration) {
        this.targetDeploymentGeneration = targetDeploymentGeneration;
    }

    @JsonIgnore
    public NodeStatusBuilder edit() {
        return new NodeStatusBuilder(this);
    }

    @JsonIgnore
    public NodeStatusBuilder toBuilder() {
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
