
package io.fabric8.kubernetes.api.model.batch.v1;

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
 * JobStatus represents the current state of a Job.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "active",
    "completedIndexes",
    "completionTime",
    "conditions",
    "failed",
    "failedIndexes",
    "ready",
    "startTime",
    "succeeded",
    "terminating",
    "uncountedTerminatedPods"
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
public class JobStatus implements Editable<JobStatusBuilder>, KubernetesResource
{

    @JsonProperty("active")
    private Integer active;
    @JsonProperty("completedIndexes")
    private String completedIndexes;
    @JsonProperty("completionTime")
    private String completionTime;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JobCondition> conditions = new ArrayList<>();
    @JsonProperty("failed")
    private Integer failed;
    @JsonProperty("failedIndexes")
    private String failedIndexes;
    @JsonProperty("ready")
    private Integer ready;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("succeeded")
    private Integer succeeded;
    @JsonProperty("terminating")
    private Integer terminating;
    @JsonProperty("uncountedTerminatedPods")
    private UncountedTerminatedPods uncountedTerminatedPods;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JobStatus() {
    }

    public JobStatus(Integer active, String completedIndexes, String completionTime, List<JobCondition> conditions, Integer failed, String failedIndexes, Integer ready, String startTime, Integer succeeded, Integer terminating, UncountedTerminatedPods uncountedTerminatedPods) {
        super();
        this.active = active;
        this.completedIndexes = completedIndexes;
        this.completionTime = completionTime;
        this.conditions = conditions;
        this.failed = failed;
        this.failedIndexes = failedIndexes;
        this.ready = ready;
        this.startTime = startTime;
        this.succeeded = succeeded;
        this.terminating = terminating;
        this.uncountedTerminatedPods = uncountedTerminatedPods;
    }

    /**
     * The number of pending and running pods which are not terminating (without a deletionTimestamp). The value is zero for finished jobs.
     */
    @JsonProperty("active")
    public Integer getActive() {
        return active;
    }

    /**
     * The number of pending and running pods which are not terminating (without a deletionTimestamp). The value is zero for finished jobs.
     */
    @JsonProperty("active")
    public void setActive(Integer active) {
        this.active = active;
    }

    /**
     * completedIndexes holds the completed indexes when .spec.completionMode = "Indexed" in a text format. The indexes are represented as decimal integers separated by commas. The numbers are listed in increasing order. Three or more consecutive numbers are compressed and represented by the first and last element of the series, separated by a hyphen. For example, if the completed indexes are 1, 3, 4, 5 and 7, they are represented as "1,3-5,7".
     */
    @JsonProperty("completedIndexes")
    public String getCompletedIndexes() {
        return completedIndexes;
    }

    /**
     * completedIndexes holds the completed indexes when .spec.completionMode = "Indexed" in a text format. The indexes are represented as decimal integers separated by commas. The numbers are listed in increasing order. Three or more consecutive numbers are compressed and represented by the first and last element of the series, separated by a hyphen. For example, if the completed indexes are 1, 3, 4, 5 and 7, they are represented as "1,3-5,7".
     */
    @JsonProperty("completedIndexes")
    public void setCompletedIndexes(String completedIndexes) {
        this.completedIndexes = completedIndexes;
    }

    /**
     * JobStatus represents the current state of a Job.
     */
    @JsonProperty("completionTime")
    public String getCompletionTime() {
        return completionTime;
    }

    /**
     * JobStatus represents the current state of a Job.
     */
    @JsonProperty("completionTime")
    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    /**
     * The latest available observations of an object's current state. When a Job fails, one of the conditions will have type "Failed" and status true. When a Job is suspended, one of the conditions will have type "Suspended" and status true; when the Job is resumed, the status of this condition will become false. When a Job is completed, one of the conditions will have type "Complete" and status true.<br><p> <br><p> A job is considered finished when it is in a terminal condition, either "Complete" or "Failed". A Job cannot have both the "Complete" and "Failed" conditions. Additionally, it cannot be in the "Complete" and "FailureTarget" conditions. The "Complete", "Failed" and "FailureTarget" conditions cannot be disabled.<br><p> <br><p> More info: https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<JobCondition> getConditions() {
        return conditions;
    }

    /**
     * The latest available observations of an object's current state. When a Job fails, one of the conditions will have type "Failed" and status true. When a Job is suspended, one of the conditions will have type "Suspended" and status true; when the Job is resumed, the status of this condition will become false. When a Job is completed, one of the conditions will have type "Complete" and status true.<br><p> <br><p> A job is considered finished when it is in a terminal condition, either "Complete" or "Failed". A Job cannot have both the "Complete" and "Failed" conditions. Additionally, it cannot be in the "Complete" and "FailureTarget" conditions. The "Complete", "Failed" and "FailureTarget" conditions cannot be disabled.<br><p> <br><p> More info: https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/
     */
    @JsonProperty("conditions")
    public void setConditions(List<JobCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * The number of pods which reached phase Failed. The value increases monotonically.
     */
    @JsonProperty("failed")
    public Integer getFailed() {
        return failed;
    }

    /**
     * The number of pods which reached phase Failed. The value increases monotonically.
     */
    @JsonProperty("failed")
    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    /**
     * FailedIndexes holds the failed indexes when spec.backoffLimitPerIndex is set. The indexes are represented in the text format analogous as for the `completedIndexes` field, ie. they are kept as decimal integers separated by commas. The numbers are listed in increasing order. Three or more consecutive numbers are compressed and represented by the first and last element of the series, separated by a hyphen. For example, if the failed indexes are 1, 3, 4, 5 and 7, they are represented as "1,3-5,7". The set of failed indexes cannot overlap with the set of completed indexes.
     */
    @JsonProperty("failedIndexes")
    public String getFailedIndexes() {
        return failedIndexes;
    }

    /**
     * FailedIndexes holds the failed indexes when spec.backoffLimitPerIndex is set. The indexes are represented in the text format analogous as for the `completedIndexes` field, ie. they are kept as decimal integers separated by commas. The numbers are listed in increasing order. Three or more consecutive numbers are compressed and represented by the first and last element of the series, separated by a hyphen. For example, if the failed indexes are 1, 3, 4, 5 and 7, they are represented as "1,3-5,7". The set of failed indexes cannot overlap with the set of completed indexes.
     */
    @JsonProperty("failedIndexes")
    public void setFailedIndexes(String failedIndexes) {
        this.failedIndexes = failedIndexes;
    }

    /**
     * The number of active pods which have a Ready condition and are not terminating (without a deletionTimestamp).
     */
    @JsonProperty("ready")
    public Integer getReady() {
        return ready;
    }

    /**
     * The number of active pods which have a Ready condition and are not terminating (without a deletionTimestamp).
     */
    @JsonProperty("ready")
    public void setReady(Integer ready) {
        this.ready = ready;
    }

    /**
     * JobStatus represents the current state of a Job.
     */
    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    /**
     * JobStatus represents the current state of a Job.
     */
    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * The number of pods which reached phase Succeeded. The value increases monotonically for a given spec. However, it may decrease in reaction to scale down of elastic indexed jobs.
     */
    @JsonProperty("succeeded")
    public Integer getSucceeded() {
        return succeeded;
    }

    /**
     * The number of pods which reached phase Succeeded. The value increases monotonically for a given spec. However, it may decrease in reaction to scale down of elastic indexed jobs.
     */
    @JsonProperty("succeeded")
    public void setSucceeded(Integer succeeded) {
        this.succeeded = succeeded;
    }

    /**
     * The number of pods which are terminating (in phase Pending or Running and have a deletionTimestamp).<br><p> <br><p> This field is beta-level. The job controller populates the field when the feature gate JobPodReplacementPolicy is enabled (enabled by default).
     */
    @JsonProperty("terminating")
    public Integer getTerminating() {
        return terminating;
    }

    /**
     * The number of pods which are terminating (in phase Pending or Running and have a deletionTimestamp).<br><p> <br><p> This field is beta-level. The job controller populates the field when the feature gate JobPodReplacementPolicy is enabled (enabled by default).
     */
    @JsonProperty("terminating")
    public void setTerminating(Integer terminating) {
        this.terminating = terminating;
    }

    /**
     * JobStatus represents the current state of a Job.
     */
    @JsonProperty("uncountedTerminatedPods")
    public UncountedTerminatedPods getUncountedTerminatedPods() {
        return uncountedTerminatedPods;
    }

    /**
     * JobStatus represents the current state of a Job.
     */
    @JsonProperty("uncountedTerminatedPods")
    public void setUncountedTerminatedPods(UncountedTerminatedPods uncountedTerminatedPods) {
        this.uncountedTerminatedPods = uncountedTerminatedPods;
    }

    @JsonIgnore
    public JobStatusBuilder edit() {
        return new JobStatusBuilder(this);
    }

    @JsonIgnore
    public JobStatusBuilder toBuilder() {
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
