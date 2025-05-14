
package io.fabric8.openshift.api.model;

import java.util.LinkedHashMap;
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
 * DeploymentStrategy describes how to perform a deployment.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "activeDeadlineSeconds",
    "annotations",
    "customParams",
    "labels",
    "recreateParams",
    "resources",
    "rollingParams",
    "type"
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
public class DeploymentStrategy implements Editable<DeploymentStrategyBuilder>, KubernetesResource
{

    @JsonProperty("activeDeadlineSeconds")
    private Long activeDeadlineSeconds;
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("customParams")
    private CustomDeploymentStrategyParams customParams;
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
    @JsonProperty("recreateParams")
    private RecreateDeploymentStrategyParams recreateParams;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("rollingParams")
    private RollingDeploymentStrategyParams rollingParams;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeploymentStrategy() {
    }

    public DeploymentStrategy(Long activeDeadlineSeconds, Map<String, String> annotations, CustomDeploymentStrategyParams customParams, Map<String, String> labels, RecreateDeploymentStrategyParams recreateParams, ResourceRequirements resources, RollingDeploymentStrategyParams rollingParams, String type) {
        super();
        this.activeDeadlineSeconds = activeDeadlineSeconds;
        this.annotations = annotations;
        this.customParams = customParams;
        this.labels = labels;
        this.recreateParams = recreateParams;
        this.resources = resources;
        this.rollingParams = rollingParams;
        this.type = type;
    }

    /**
     * ActiveDeadlineSeconds is the duration in seconds that the deployer pods for this deployment config may be active on a node before the system actively tries to terminate them.
     */
    @JsonProperty("activeDeadlineSeconds")
    public Long getActiveDeadlineSeconds() {
        return activeDeadlineSeconds;
    }

    /**
     * ActiveDeadlineSeconds is the duration in seconds that the deployer pods for this deployment config may be active on a node before the system actively tries to terminate them.
     */
    @JsonProperty("activeDeadlineSeconds")
    public void setActiveDeadlineSeconds(Long activeDeadlineSeconds) {
        this.activeDeadlineSeconds = activeDeadlineSeconds;
    }

    /**
     * Annotations is a set of key, value pairs added to custom deployer and lifecycle pre/post hook pods.
     */
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    /**
     * Annotations is a set of key, value pairs added to custom deployer and lifecycle pre/post hook pods.
     */
    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    /**
     * DeploymentStrategy describes how to perform a deployment.
     */
    @JsonProperty("customParams")
    public CustomDeploymentStrategyParams getCustomParams() {
        return customParams;
    }

    /**
     * DeploymentStrategy describes how to perform a deployment.
     */
    @JsonProperty("customParams")
    public void setCustomParams(CustomDeploymentStrategyParams customParams) {
        this.customParams = customParams;
    }

    /**
     * Labels is a set of key, value pairs added to custom deployer and lifecycle pre/post hook pods.
     */
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * Labels is a set of key, value pairs added to custom deployer and lifecycle pre/post hook pods.
     */
    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    /**
     * DeploymentStrategy describes how to perform a deployment.
     */
    @JsonProperty("recreateParams")
    public RecreateDeploymentStrategyParams getRecreateParams() {
        return recreateParams;
    }

    /**
     * DeploymentStrategy describes how to perform a deployment.
     */
    @JsonProperty("recreateParams")
    public void setRecreateParams(RecreateDeploymentStrategyParams recreateParams) {
        this.recreateParams = recreateParams;
    }

    /**
     * DeploymentStrategy describes how to perform a deployment.
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * DeploymentStrategy describes how to perform a deployment.
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * DeploymentStrategy describes how to perform a deployment.
     */
    @JsonProperty("rollingParams")
    public RollingDeploymentStrategyParams getRollingParams() {
        return rollingParams;
    }

    /**
     * DeploymentStrategy describes how to perform a deployment.
     */
    @JsonProperty("rollingParams")
    public void setRollingParams(RollingDeploymentStrategyParams rollingParams) {
        this.rollingParams = rollingParams;
    }

    /**
     * Type is the name of a deployment strategy.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type is the name of a deployment strategy.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public DeploymentStrategyBuilder edit() {
        return new DeploymentStrategyBuilder(this);
    }

    @JsonIgnore
    public DeploymentStrategyBuilder toBuilder() {
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
