
package io.fabric8.openshift.api.model.clusterautoscaling.v1;

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
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "balanceSimilarNodeGroups",
    "ignoreDaemonsetsUtilization",
    "maxNodeProvisionTime",
    "maxPodGracePeriod",
    "podPriorityThreshold",
    "resourceLimits",
    "scaleDown",
    "skipNodesWithLocalStorage"
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ClusterAutoscalerSpec implements KubernetesResource
{

    @JsonProperty("balanceSimilarNodeGroups")
    private Boolean balanceSimilarNodeGroups;
    @JsonProperty("ignoreDaemonsetsUtilization")
    private Boolean ignoreDaemonsetsUtilization;
    @JsonProperty("maxNodeProvisionTime")
    private String maxNodeProvisionTime;
    @JsonProperty("maxPodGracePeriod")
    private Integer maxPodGracePeriod;
    @JsonProperty("podPriorityThreshold")
    private Integer podPriorityThreshold;
    @JsonProperty("resourceLimits")
    private ResourceLimits resourceLimits;
    @JsonProperty("scaleDown")
    private ScaleDownConfig scaleDown;
    @JsonProperty("skipNodesWithLocalStorage")
    private Boolean skipNodesWithLocalStorage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterAutoscalerSpec() {
    }

    public ClusterAutoscalerSpec(Boolean balanceSimilarNodeGroups, Boolean ignoreDaemonsetsUtilization, String maxNodeProvisionTime, Integer maxPodGracePeriod, Integer podPriorityThreshold, ResourceLimits resourceLimits, ScaleDownConfig scaleDown, Boolean skipNodesWithLocalStorage) {
        super();
        this.balanceSimilarNodeGroups = balanceSimilarNodeGroups;
        this.ignoreDaemonsetsUtilization = ignoreDaemonsetsUtilization;
        this.maxNodeProvisionTime = maxNodeProvisionTime;
        this.maxPodGracePeriod = maxPodGracePeriod;
        this.podPriorityThreshold = podPriorityThreshold;
        this.resourceLimits = resourceLimits;
        this.scaleDown = scaleDown;
        this.skipNodesWithLocalStorage = skipNodesWithLocalStorage;
    }

    @JsonProperty("balanceSimilarNodeGroups")
    public Boolean getBalanceSimilarNodeGroups() {
        return balanceSimilarNodeGroups;
    }

    @JsonProperty("balanceSimilarNodeGroups")
    public void setBalanceSimilarNodeGroups(Boolean balanceSimilarNodeGroups) {
        this.balanceSimilarNodeGroups = balanceSimilarNodeGroups;
    }

    @JsonProperty("ignoreDaemonsetsUtilization")
    public Boolean getIgnoreDaemonsetsUtilization() {
        return ignoreDaemonsetsUtilization;
    }

    @JsonProperty("ignoreDaemonsetsUtilization")
    public void setIgnoreDaemonsetsUtilization(Boolean ignoreDaemonsetsUtilization) {
        this.ignoreDaemonsetsUtilization = ignoreDaemonsetsUtilization;
    }

    @JsonProperty("maxNodeProvisionTime")
    public String getMaxNodeProvisionTime() {
        return maxNodeProvisionTime;
    }

    @JsonProperty("maxNodeProvisionTime")
    public void setMaxNodeProvisionTime(String maxNodeProvisionTime) {
        this.maxNodeProvisionTime = maxNodeProvisionTime;
    }

    @JsonProperty("maxPodGracePeriod")
    public Integer getMaxPodGracePeriod() {
        return maxPodGracePeriod;
    }

    @JsonProperty("maxPodGracePeriod")
    public void setMaxPodGracePeriod(Integer maxPodGracePeriod) {
        this.maxPodGracePeriod = maxPodGracePeriod;
    }

    @JsonProperty("podPriorityThreshold")
    public Integer getPodPriorityThreshold() {
        return podPriorityThreshold;
    }

    @JsonProperty("podPriorityThreshold")
    public void setPodPriorityThreshold(Integer podPriorityThreshold) {
        this.podPriorityThreshold = podPriorityThreshold;
    }

    @JsonProperty("resourceLimits")
    public ResourceLimits getResourceLimits() {
        return resourceLimits;
    }

    @JsonProperty("resourceLimits")
    public void setResourceLimits(ResourceLimits resourceLimits) {
        this.resourceLimits = resourceLimits;
    }

    @JsonProperty("scaleDown")
    public ScaleDownConfig getScaleDown() {
        return scaleDown;
    }

    @JsonProperty("scaleDown")
    public void setScaleDown(ScaleDownConfig scaleDown) {
        this.scaleDown = scaleDown;
    }

    @JsonProperty("skipNodesWithLocalStorage")
    public Boolean getSkipNodesWithLocalStorage() {
        return skipNodesWithLocalStorage;
    }

    @JsonProperty("skipNodesWithLocalStorage")
    public void setSkipNodesWithLocalStorage(Boolean skipNodesWithLocalStorage) {
        this.skipNodesWithLocalStorage = skipNodesWithLocalStorage;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
