
package io.fabric8.openshift.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.model.Affinity;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Toleration;
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
    "affinity",
    "failedJobsHistoryLimit",
    "ignoreInvalidImageReferences",
    "keepTagRevisions",
    "keepYoungerThan",
    "keepYoungerThanDuration",
    "logLevel",
    "nodeSelector",
    "resources",
    "schedule",
    "successfulJobsHistoryLimit",
    "suspend",
    "tolerations"
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
public class ImagePrunerSpec implements KubernetesResource
{

    @JsonProperty("affinity")
    private Affinity affinity;
    @JsonProperty("failedJobsHistoryLimit")
    private Integer failedJobsHistoryLimit;
    @JsonProperty("ignoreInvalidImageReferences")
    private Boolean ignoreInvalidImageReferences;
    @JsonProperty("keepTagRevisions")
    private Integer keepTagRevisions;
    @JsonProperty("keepYoungerThan")
    private Long keepYoungerThan;
    @JsonProperty("keepYoungerThanDuration")
    private Duration keepYoungerThanDuration;
    @JsonProperty("logLevel")
    private java.lang.String logLevel;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<String, String>();
    @JsonProperty("resources")
    private io.fabric8.kubernetes.api.model.ResourceRequirements resources;
    @JsonProperty("schedule")
    private java.lang.String schedule;
    @JsonProperty("successfulJobsHistoryLimit")
    private Integer successfulJobsHistoryLimit;
    @JsonProperty("suspend")
    private Boolean suspend;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<Toleration>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImagePrunerSpec() {
    }

    public ImagePrunerSpec(Affinity affinity, Integer failedJobsHistoryLimit, Boolean ignoreInvalidImageReferences, Integer keepTagRevisions, Long keepYoungerThan, Duration keepYoungerThanDuration, java.lang.String logLevel, Map<String, String> nodeSelector, io.fabric8.kubernetes.api.model.ResourceRequirements resources, java.lang.String schedule, Integer successfulJobsHistoryLimit, Boolean suspend, List<Toleration> tolerations) {
        super();
        this.affinity = affinity;
        this.failedJobsHistoryLimit = failedJobsHistoryLimit;
        this.ignoreInvalidImageReferences = ignoreInvalidImageReferences;
        this.keepTagRevisions = keepTagRevisions;
        this.keepYoungerThan = keepYoungerThan;
        this.keepYoungerThanDuration = keepYoungerThanDuration;
        this.logLevel = logLevel;
        this.nodeSelector = nodeSelector;
        this.resources = resources;
        this.schedule = schedule;
        this.successfulJobsHistoryLimit = successfulJobsHistoryLimit;
        this.suspend = suspend;
        this.tolerations = tolerations;
    }

    @JsonProperty("affinity")
    public Affinity getAffinity() {
        return affinity;
    }

    @JsonProperty("affinity")
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    @JsonProperty("failedJobsHistoryLimit")
    public Integer getFailedJobsHistoryLimit() {
        return failedJobsHistoryLimit;
    }

    @JsonProperty("failedJobsHistoryLimit")
    public void setFailedJobsHistoryLimit(Integer failedJobsHistoryLimit) {
        this.failedJobsHistoryLimit = failedJobsHistoryLimit;
    }

    @JsonProperty("ignoreInvalidImageReferences")
    public Boolean getIgnoreInvalidImageReferences() {
        return ignoreInvalidImageReferences;
    }

    @JsonProperty("ignoreInvalidImageReferences")
    public void setIgnoreInvalidImageReferences(Boolean ignoreInvalidImageReferences) {
        this.ignoreInvalidImageReferences = ignoreInvalidImageReferences;
    }

    @JsonProperty("keepTagRevisions")
    public Integer getKeepTagRevisions() {
        return keepTagRevisions;
    }

    @JsonProperty("keepTagRevisions")
    public void setKeepTagRevisions(Integer keepTagRevisions) {
        this.keepTagRevisions = keepTagRevisions;
    }

    @JsonProperty("keepYoungerThan")
    public Long getKeepYoungerThan() {
        return keepYoungerThan;
    }

    @JsonProperty("keepYoungerThan")
    public void setKeepYoungerThan(Long keepYoungerThan) {
        this.keepYoungerThan = keepYoungerThan;
    }

    @JsonProperty("keepYoungerThanDuration")
    public Duration getKeepYoungerThanDuration() {
        return keepYoungerThanDuration;
    }

    @JsonProperty("keepYoungerThanDuration")
    public void setKeepYoungerThanDuration(Duration keepYoungerThanDuration) {
        this.keepYoungerThanDuration = keepYoungerThanDuration;
    }

    @JsonProperty("logLevel")
    public java.lang.String getLogLevel() {
        return logLevel;
    }

    @JsonProperty("logLevel")
    public void setLogLevel(java.lang.String logLevel) {
        this.logLevel = logLevel;
    }

    @JsonProperty("nodeSelector")
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonProperty("resources")
    public io.fabric8.kubernetes.api.model.ResourceRequirements getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(io.fabric8.kubernetes.api.model.ResourceRequirements resources) {
        this.resources = resources;
    }

    @JsonProperty("schedule")
    public java.lang.String getSchedule() {
        return schedule;
    }

    @JsonProperty("schedule")
    public void setSchedule(java.lang.String schedule) {
        this.schedule = schedule;
    }

    @JsonProperty("successfulJobsHistoryLimit")
    public Integer getSuccessfulJobsHistoryLimit() {
        return successfulJobsHistoryLimit;
    }

    @JsonProperty("successfulJobsHistoryLimit")
    public void setSuccessfulJobsHistoryLimit(Integer successfulJobsHistoryLimit) {
        this.successfulJobsHistoryLimit = successfulJobsHistoryLimit;
    }

    @JsonProperty("suspend")
    public Boolean getSuspend() {
        return suspend;
    }

    @JsonProperty("suspend")
    public void setSuspend(Boolean suspend) {
        this.suspend = suspend;
    }

    @JsonProperty("tolerations")
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
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
