
package io.fabric8.openshift.api.model.autoscaling.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "balanceSimilarNodeGroups",
    "balancingIgnoredLabels",
    "expanders",
    "ignoreDaemonsetsUtilization",
    "logVerbosity",
    "maxNodeProvisionTime",
    "maxPodGracePeriod",
    "podPriorityThreshold",
    "resourceLimits",
    "scaleDown",
    "skipNodesWithLocalStorage"
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
public class ClusterAutoscalerSpec implements Editable<ClusterAutoscalerSpecBuilder> , KubernetesResource
{

    @JsonProperty("balanceSimilarNodeGroups")
    private Boolean balanceSimilarNodeGroups;
    @JsonProperty("balancingIgnoredLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> balancingIgnoredLabels = new ArrayList<>();
    @JsonProperty("expanders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> expanders = new ArrayList<>();
    @JsonProperty("ignoreDaemonsetsUtilization")
    private Boolean ignoreDaemonsetsUtilization;
    @JsonProperty("logVerbosity")
    private Integer logVerbosity;
    @JsonProperty("maxNodeProvisionTime")
    private String maxNodeProvisionTime;
    @JsonProperty("maxPodGracePeriod")
    private Integer maxPodGracePeriod;
    @JsonProperty("podPriorityThreshold")
    private Integer podPriorityThreshold;
    @JsonProperty("resourceLimits")
    private ClusterAutoscalerSpecResourceLimits resourceLimits;
    @JsonProperty("scaleDown")
    private ClusterAutoscalerSpecScaleDown scaleDown;
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

    public ClusterAutoscalerSpec(Boolean balanceSimilarNodeGroups, List<String> balancingIgnoredLabels, List<String> expanders, Boolean ignoreDaemonsetsUtilization, Integer logVerbosity, String maxNodeProvisionTime, Integer maxPodGracePeriod, Integer podPriorityThreshold, ClusterAutoscalerSpecResourceLimits resourceLimits, ClusterAutoscalerSpecScaleDown scaleDown, Boolean skipNodesWithLocalStorage) {
        super();
        this.balanceSimilarNodeGroups = balanceSimilarNodeGroups;
        this.balancingIgnoredLabels = balancingIgnoredLabels;
        this.expanders = expanders;
        this.ignoreDaemonsetsUtilization = ignoreDaemonsetsUtilization;
        this.logVerbosity = logVerbosity;
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

    @JsonProperty("balancingIgnoredLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBalancingIgnoredLabels() {
        return balancingIgnoredLabels;
    }

    @JsonProperty("balancingIgnoredLabels")
    public void setBalancingIgnoredLabels(List<String> balancingIgnoredLabels) {
        this.balancingIgnoredLabels = balancingIgnoredLabels;
    }

    @JsonProperty("expanders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExpanders() {
        return expanders;
    }

    @JsonProperty("expanders")
    public void setExpanders(List<String> expanders) {
        this.expanders = expanders;
    }

    @JsonProperty("ignoreDaemonsetsUtilization")
    public Boolean getIgnoreDaemonsetsUtilization() {
        return ignoreDaemonsetsUtilization;
    }

    @JsonProperty("ignoreDaemonsetsUtilization")
    public void setIgnoreDaemonsetsUtilization(Boolean ignoreDaemonsetsUtilization) {
        this.ignoreDaemonsetsUtilization = ignoreDaemonsetsUtilization;
    }

    @JsonProperty("logVerbosity")
    public Integer getLogVerbosity() {
        return logVerbosity;
    }

    @JsonProperty("logVerbosity")
    public void setLogVerbosity(Integer logVerbosity) {
        this.logVerbosity = logVerbosity;
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
    public ClusterAutoscalerSpecResourceLimits getResourceLimits() {
        return resourceLimits;
    }

    @JsonProperty("resourceLimits")
    public void setResourceLimits(ClusterAutoscalerSpecResourceLimits resourceLimits) {
        this.resourceLimits = resourceLimits;
    }

    @JsonProperty("scaleDown")
    public ClusterAutoscalerSpecScaleDown getScaleDown() {
        return scaleDown;
    }

    @JsonProperty("scaleDown")
    public void setScaleDown(ClusterAutoscalerSpecScaleDown scaleDown) {
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

    @JsonIgnore
    public ClusterAutoscalerSpecBuilder edit() {
        return new ClusterAutoscalerSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterAutoscalerSpecBuilder toBuilder() {
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
