
package io.fabric8.volcano.api.model.batch.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Duration;
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
 * JobStatus represents the current status of a Job.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "controlledResources",
    "failed",
    "minAvailable",
    "pending",
    "retryCount",
    "running",
    "runningDuration",
    "state",
    "succeeded",
    "taskStatusCount",
    "terminating",
    "unknown",
    "version"
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

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JobCondition> conditions = new ArrayList<>();
    @JsonProperty("controlledResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> controlledResources = new LinkedHashMap<>();
    @JsonProperty("failed")
    private Integer failed;
    @JsonProperty("minAvailable")
    private Integer minAvailable;
    @JsonProperty("pending")
    private Integer pending;
    @JsonProperty("retryCount")
    private Integer retryCount;
    @JsonProperty("running")
    private Integer running;
    @JsonProperty("runningDuration")
    private Duration runningDuration;
    @JsonProperty("state")
    private JobState state;
    @JsonProperty("succeeded")
    private Integer succeeded;
    @JsonProperty("taskStatusCount")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, TaskState> taskStatusCount = new LinkedHashMap<>();
    @JsonProperty("terminating")
    private Integer terminating;
    @JsonProperty("unknown")
    private Integer unknown;
    @JsonProperty("version")
    private Integer version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JobStatus() {
    }

    public JobStatus(List<JobCondition> conditions, Map<String, String> controlledResources, Integer failed, Integer minAvailable, Integer pending, Integer retryCount, Integer running, Duration runningDuration, JobState state, Integer succeeded, Map<String, TaskState> taskStatusCount, Integer terminating, Integer unknown, Integer version) {
        super();
        this.conditions = conditions;
        this.controlledResources = controlledResources;
        this.failed = failed;
        this.minAvailable = minAvailable;
        this.pending = pending;
        this.retryCount = retryCount;
        this.running = running;
        this.runningDuration = runningDuration;
        this.state = state;
        this.succeeded = succeeded;
        this.taskStatusCount = taskStatusCount;
        this.terminating = terminating;
        this.unknown = unknown;
        this.version = version;
    }

    /**
     * Which conditions caused the current job state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<JobCondition> getConditions() {
        return conditions;
    }

    /**
     * Which conditions caused the current job state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<JobCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * The resources that controlled by this job, e.g. Service, ConfigMap
     */
    @JsonProperty("controlledResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getControlledResources() {
        return controlledResources;
    }

    /**
     * The resources that controlled by this job, e.g. Service, ConfigMap
     */
    @JsonProperty("controlledResources")
    public void setControlledResources(Map<String, String> controlledResources) {
        this.controlledResources = controlledResources;
    }

    /**
     * The number of pods which reached phase Failed.
     */
    @JsonProperty("failed")
    public Integer getFailed() {
        return failed;
    }

    /**
     * The number of pods which reached phase Failed.
     */
    @JsonProperty("failed")
    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    /**
     * The minimal available pods to run for this Job
     */
    @JsonProperty("minAvailable")
    public Integer getMinAvailable() {
        return minAvailable;
    }

    /**
     * The minimal available pods to run for this Job
     */
    @JsonProperty("minAvailable")
    public void setMinAvailable(Integer minAvailable) {
        this.minAvailable = minAvailable;
    }

    /**
     * The number of pending pods.
     */
    @JsonProperty("pending")
    public Integer getPending() {
        return pending;
    }

    /**
     * The number of pending pods.
     */
    @JsonProperty("pending")
    public void setPending(Integer pending) {
        this.pending = pending;
    }

    /**
     * The number of Job retries.
     */
    @JsonProperty("retryCount")
    public Integer getRetryCount() {
        return retryCount;
    }

    /**
     * The number of Job retries.
     */
    @JsonProperty("retryCount")
    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    /**
     * The number of running pods.
     */
    @JsonProperty("running")
    public Integer getRunning() {
        return running;
    }

    /**
     * The number of running pods.
     */
    @JsonProperty("running")
    public void setRunning(Integer running) {
        this.running = running;
    }

    /**
     * JobStatus represents the current status of a Job.
     */
    @JsonProperty("runningDuration")
    public Duration getRunningDuration() {
        return runningDuration;
    }

    /**
     * JobStatus represents the current status of a Job.
     */
    @JsonProperty("runningDuration")
    public void setRunningDuration(Duration runningDuration) {
        this.runningDuration = runningDuration;
    }

    /**
     * JobStatus represents the current status of a Job.
     */
    @JsonProperty("state")
    public JobState getState() {
        return state;
    }

    /**
     * JobStatus represents the current status of a Job.
     */
    @JsonProperty("state")
    public void setState(JobState state) {
        this.state = state;
    }

    /**
     * The number of pods which reached phase Succeeded.
     */
    @JsonProperty("succeeded")
    public Integer getSucceeded() {
        return succeeded;
    }

    /**
     * The number of pods which reached phase Succeeded.
     */
    @JsonProperty("succeeded")
    public void setSucceeded(Integer succeeded) {
        this.succeeded = succeeded;
    }

    /**
     * The status of pods for each task
     */
    @JsonProperty("taskStatusCount")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, TaskState> getTaskStatusCount() {
        return taskStatusCount;
    }

    /**
     * The status of pods for each task
     */
    @JsonProperty("taskStatusCount")
    public void setTaskStatusCount(Map<String, TaskState> taskStatusCount) {
        this.taskStatusCount = taskStatusCount;
    }

    /**
     * The number of pods which reached phase Terminating.
     */
    @JsonProperty("terminating")
    public Integer getTerminating() {
        return terminating;
    }

    /**
     * The number of pods which reached phase Terminating.
     */
    @JsonProperty("terminating")
    public void setTerminating(Integer terminating) {
        this.terminating = terminating;
    }

    /**
     * The number of pods which reached phase Unknown.
     */
    @JsonProperty("unknown")
    public Integer getUnknown() {
        return unknown;
    }

    /**
     * The number of pods which reached phase Unknown.
     */
    @JsonProperty("unknown")
    public void setUnknown(Integer unknown) {
        this.unknown = unknown;
    }

    /**
     * Current version of job
     */
    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    /**
     * Current version of job
     */
    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
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
