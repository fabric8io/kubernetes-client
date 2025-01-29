
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
import io.fabric8.kubernetes.api.model.Affinity;
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
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ImagePrunerSpec defines the specs for the running image pruner.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
public class ImagePrunerSpec implements Editable<ImagePrunerSpecBuilder>, KubernetesResource
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
    private String keepYoungerThanDuration;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("schedule")
    private String schedule;
    @JsonProperty("successfulJobsHistoryLimit")
    private Integer successfulJobsHistoryLimit;
    @JsonProperty("suspend")
    private Boolean suspend;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImagePrunerSpec() {
    }

    public ImagePrunerSpec(Affinity affinity, Integer failedJobsHistoryLimit, Boolean ignoreInvalidImageReferences, Integer keepTagRevisions, Long keepYoungerThan, String keepYoungerThanDuration, String logLevel, Map<String, String> nodeSelector, ResourceRequirements resources, String schedule, Integer successfulJobsHistoryLimit, Boolean suspend, List<Toleration> tolerations) {
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

    /**
     * ImagePrunerSpec defines the specs for the running image pruner.
     */
    @JsonProperty("affinity")
    public Affinity getAffinity() {
        return affinity;
    }

    /**
     * ImagePrunerSpec defines the specs for the running image pruner.
     */
    @JsonProperty("affinity")
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    /**
     * failedJobsHistoryLimit specifies how many failed image pruner jobs to retain. Defaults to 3 if not set.
     */
    @JsonProperty("failedJobsHistoryLimit")
    public Integer getFailedJobsHistoryLimit() {
        return failedJobsHistoryLimit;
    }

    /**
     * failedJobsHistoryLimit specifies how many failed image pruner jobs to retain. Defaults to 3 if not set.
     */
    @JsonProperty("failedJobsHistoryLimit")
    public void setFailedJobsHistoryLimit(Integer failedJobsHistoryLimit) {
        this.failedJobsHistoryLimit = failedJobsHistoryLimit;
    }

    /**
     * ignoreInvalidImageReferences indicates whether the pruner can ignore errors while parsing image references.
     */
    @JsonProperty("ignoreInvalidImageReferences")
    public Boolean getIgnoreInvalidImageReferences() {
        return ignoreInvalidImageReferences;
    }

    /**
     * ignoreInvalidImageReferences indicates whether the pruner can ignore errors while parsing image references.
     */
    @JsonProperty("ignoreInvalidImageReferences")
    public void setIgnoreInvalidImageReferences(Boolean ignoreInvalidImageReferences) {
        this.ignoreInvalidImageReferences = ignoreInvalidImageReferences;
    }

    /**
     * keepTagRevisions specifies the number of image revisions for a tag in an image stream that will be preserved. Defaults to 3.
     */
    @JsonProperty("keepTagRevisions")
    public Integer getKeepTagRevisions() {
        return keepTagRevisions;
    }

    /**
     * keepTagRevisions specifies the number of image revisions for a tag in an image stream that will be preserved. Defaults to 3.
     */
    @JsonProperty("keepTagRevisions")
    public void setKeepTagRevisions(Integer keepTagRevisions) {
        this.keepTagRevisions = keepTagRevisions;
    }

    /**
     * keepYoungerThan specifies the minimum age in nanoseconds of an image and its referrers for it to be considered a candidate for pruning. DEPRECATED: This field is deprecated in favor of keepYoungerThanDuration. If both are set, this field is ignored and keepYoungerThanDuration takes precedence.
     */
    @JsonProperty("keepYoungerThan")
    public Long getKeepYoungerThan() {
        return keepYoungerThan;
    }

    /**
     * keepYoungerThan specifies the minimum age in nanoseconds of an image and its referrers for it to be considered a candidate for pruning. DEPRECATED: This field is deprecated in favor of keepYoungerThanDuration. If both are set, this field is ignored and keepYoungerThanDuration takes precedence.
     */
    @JsonProperty("keepYoungerThan")
    public void setKeepYoungerThan(Long keepYoungerThan) {
        this.keepYoungerThan = keepYoungerThan;
    }

    /**
     * ImagePrunerSpec defines the specs for the running image pruner.
     */
    @JsonProperty("keepYoungerThanDuration")
    public String getKeepYoungerThanDuration() {
        return keepYoungerThanDuration;
    }

    /**
     * ImagePrunerSpec defines the specs for the running image pruner.
     */
    @JsonProperty("keepYoungerThanDuration")
    public void setKeepYoungerThanDuration(String keepYoungerThanDuration) {
        this.keepYoungerThanDuration = keepYoungerThanDuration;
    }

    /**
     * logLevel sets the level of log output for the pruner job.<br><p> <br><p> Valid values are: "Normal", "Debug", "Trace", "TraceAll". Defaults to "Normal".
     */
    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * logLevel sets the level of log output for the pruner job.<br><p> <br><p> Valid values are: "Normal", "Debug", "Trace", "TraceAll". Defaults to "Normal".
     */
    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * nodeSelector defines the node selection constraints for the image pruner pod.
     */
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    /**
     * nodeSelector defines the node selection constraints for the image pruner pod.
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * ImagePrunerSpec defines the specs for the running image pruner.
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * ImagePrunerSpec defines the specs for the running image pruner.
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * schedule specifies when to execute the job using standard cronjob syntax: https://wikipedia.org/wiki/Cron. Defaults to `0 0 &#42; &#42; &#42;`.
     */
    @JsonProperty("schedule")
    public String getSchedule() {
        return schedule;
    }

    /**
     * schedule specifies when to execute the job using standard cronjob syntax: https://wikipedia.org/wiki/Cron. Defaults to `0 0 &#42; &#42; &#42;`.
     */
    @JsonProperty("schedule")
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * successfulJobsHistoryLimit specifies how many successful image pruner jobs to retain. Defaults to 3 if not set.
     */
    @JsonProperty("successfulJobsHistoryLimit")
    public Integer getSuccessfulJobsHistoryLimit() {
        return successfulJobsHistoryLimit;
    }

    /**
     * successfulJobsHistoryLimit specifies how many successful image pruner jobs to retain. Defaults to 3 if not set.
     */
    @JsonProperty("successfulJobsHistoryLimit")
    public void setSuccessfulJobsHistoryLimit(Integer successfulJobsHistoryLimit) {
        this.successfulJobsHistoryLimit = successfulJobsHistoryLimit;
    }

    /**
     * suspend specifies whether or not to suspend subsequent executions of this cronjob. Defaults to false.
     */
    @JsonProperty("suspend")
    public Boolean getSuspend() {
        return suspend;
    }

    /**
     * suspend specifies whether or not to suspend subsequent executions of this cronjob. Defaults to false.
     */
    @JsonProperty("suspend")
    public void setSuspend(Boolean suspend) {
        this.suspend = suspend;
    }

    /**
     * tolerations defines the node tolerations for the image pruner pod.
     */
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    /**
     * tolerations defines the node tolerations for the image pruner pod.
     */
    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonIgnore
    public ImagePrunerSpecBuilder edit() {
        return new ImagePrunerSpecBuilder(this);
    }

    @JsonIgnore
    public ImagePrunerSpecBuilder toBuilder() {
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
