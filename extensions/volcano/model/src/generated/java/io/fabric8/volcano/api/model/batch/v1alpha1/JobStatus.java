
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof JobStatus)) {
            return false;
        }
        JobStatus other = (JobStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$controlledResources = this.getControlledResources();
        Object other$controlledResources = other.getControlledResources();
        if (this$controlledResources == null ? other$controlledResources != null : !this$controlledResources.equals(other$controlledResources)) {
            return false;
        }
        Object this$failed = this.getFailed();
        Object other$failed = other.getFailed();
        if (this$failed == null ? other$failed != null : !this$failed.equals(other$failed)) {
            return false;
        }
        Object this$minAvailable = this.getMinAvailable();
        Object other$minAvailable = other.getMinAvailable();
        if (this$minAvailable == null ? other$minAvailable != null : !this$minAvailable.equals(other$minAvailable)) {
            return false;
        }
        Object this$pending = this.getPending();
        Object other$pending = other.getPending();
        if (this$pending == null ? other$pending != null : !this$pending.equals(other$pending)) {
            return false;
        }
        Object this$retryCount = this.getRetryCount();
        Object other$retryCount = other.getRetryCount();
        if (this$retryCount == null ? other$retryCount != null : !this$retryCount.equals(other$retryCount)) {
            return false;
        }
        Object this$running = this.getRunning();
        Object other$running = other.getRunning();
        if (this$running == null ? other$running != null : !this$running.equals(other$running)) {
            return false;
        }
        Object this$runningDuration = this.getRunningDuration();
        Object other$runningDuration = other.getRunningDuration();
        if (this$runningDuration == null ? other$runningDuration != null : !this$runningDuration.equals(other$runningDuration)) {
            return false;
        }
        Object this$state = this.getState();
        Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
            return false;
        }
        Object this$succeeded = this.getSucceeded();
        Object other$succeeded = other.getSucceeded();
        if (this$succeeded == null ? other$succeeded != null : !this$succeeded.equals(other$succeeded)) {
            return false;
        }
        Object this$taskStatusCount = this.getTaskStatusCount();
        Object other$taskStatusCount = other.getTaskStatusCount();
        if (this$taskStatusCount == null ? other$taskStatusCount != null : !this$taskStatusCount.equals(other$taskStatusCount)) {
            return false;
        }
        Object this$terminating = this.getTerminating();
        Object other$terminating = other.getTerminating();
        if (this$terminating == null ? other$terminating != null : !this$terminating.equals(other$terminating)) {
            return false;
        }
        Object this$unknown = this.getUnknown();
        Object other$unknown = other.getUnknown();
        if (this$unknown == null ? other$unknown != null : !this$unknown.equals(other$unknown)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof JobStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $controlledResources = this.getControlledResources();
        result = result * prime + ($controlledResources == null ? 43 : $controlledResources.hashCode());
        Object $failed = this.getFailed();
        result = result * prime + ($failed == null ? 43 : $failed.hashCode());
        Object $minAvailable = this.getMinAvailable();
        result = result * prime + ($minAvailable == null ? 43 : $minAvailable.hashCode());
        Object $pending = this.getPending();
        result = result * prime + ($pending == null ? 43 : $pending.hashCode());
        Object $retryCount = this.getRetryCount();
        result = result * prime + ($retryCount == null ? 43 : $retryCount.hashCode());
        Object $running = this.getRunning();
        result = result * prime + ($running == null ? 43 : $running.hashCode());
        Object $runningDuration = this.getRunningDuration();
        result = result * prime + ($runningDuration == null ? 43 : $runningDuration.hashCode());
        Object $state = this.getState();
        result = result * prime + ($state == null ? 43 : $state.hashCode());
        Object $succeeded = this.getSucceeded();
        result = result * prime + ($succeeded == null ? 43 : $succeeded.hashCode());
        Object $taskStatusCount = this.getTaskStatusCount();
        result = result * prime + ($taskStatusCount == null ? 43 : $taskStatusCount.hashCode());
        Object $terminating = this.getTerminating();
        result = result * prime + ($terminating == null ? 43 : $terminating.hashCode());
        Object $unknown = this.getUnknown();
        result = result * prime + ($unknown == null ? 43 : $unknown.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "JobStatus(" + "conditions=" + this.getConditions() + ", controlledResources=" + this.getControlledResources() + ", failed=" + this.getFailed() + ", minAvailable=" + this.getMinAvailable() + ", pending=" + this.getPending() + ", retryCount=" + this.getRetryCount() + ", running=" + this.getRunning() + ", runningDuration=" + this.getRunningDuration() + ", state=" + this.getState() + ", succeeded=" + this.getSucceeded() + ", taskStatusCount=" + this.getTaskStatusCount() + ", terminating=" + this.getTerminating() + ", unknown=" + this.getUnknown() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
