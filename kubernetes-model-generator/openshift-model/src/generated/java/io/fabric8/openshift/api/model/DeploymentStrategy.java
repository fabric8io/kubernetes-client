
package io.fabric8.openshift.api.model;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class DeploymentStrategy implements KubernetesResource
{

    @JsonProperty("activeDeadlineSeconds")
    private Long activeDeadlineSeconds;
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<String, String>();
    @JsonProperty("customParams")
    private CustomDeploymentStrategyParams customParams;
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<String, String>();
    @JsonProperty("recreateParams")
    private RecreateDeploymentStrategyParams recreateParams;
    @JsonProperty("resources")
    private io.fabric8.kubernetes.api.model.ResourceRequirements resources;
    @JsonProperty("rollingParams")
    private RollingDeploymentStrategyParams rollingParams;
    @JsonProperty("type")
    private java.lang.String type;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DeploymentStrategy() {
    }

    public DeploymentStrategy(Long activeDeadlineSeconds, Map<String, String> annotations, CustomDeploymentStrategyParams customParams, Map<String, String> labels, RecreateDeploymentStrategyParams recreateParams, io.fabric8.kubernetes.api.model.ResourceRequirements resources, RollingDeploymentStrategyParams rollingParams, java.lang.String type) {
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

    @JsonProperty("activeDeadlineSeconds")
    public Long getActiveDeadlineSeconds() {
        return activeDeadlineSeconds;
    }

    @JsonProperty("activeDeadlineSeconds")
    public void setActiveDeadlineSeconds(Long activeDeadlineSeconds) {
        this.activeDeadlineSeconds = activeDeadlineSeconds;
    }

    @JsonProperty("annotations")
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("customParams")
    public CustomDeploymentStrategyParams getCustomParams() {
        return customParams;
    }

    @JsonProperty("customParams")
    public void setCustomParams(CustomDeploymentStrategyParams customParams) {
        this.customParams = customParams;
    }

    @JsonProperty("labels")
    public Map<String, String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    @JsonProperty("recreateParams")
    public RecreateDeploymentStrategyParams getRecreateParams() {
        return recreateParams;
    }

    @JsonProperty("recreateParams")
    public void setRecreateParams(RecreateDeploymentStrategyParams recreateParams) {
        this.recreateParams = recreateParams;
    }

    @JsonProperty("resources")
    public io.fabric8.kubernetes.api.model.ResourceRequirements getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(io.fabric8.kubernetes.api.model.ResourceRequirements resources) {
        this.resources = resources;
    }

    @JsonProperty("rollingParams")
    public RollingDeploymentStrategyParams getRollingParams() {
        return rollingParams;
    }

    @JsonProperty("rollingParams")
    public void setRollingParams(RollingDeploymentStrategyParams rollingParams) {
        this.rollingParams = rollingParams;
    }

    @JsonProperty("type")
    public java.lang.String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(java.lang.String type) {
        this.type = type;
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
