
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
 * JobSpec describes how the job execution will look like and when it will actually run.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxRetry",
    "minAvailable",
    "minSuccess",
    "plugins",
    "policies",
    "priorityClassName",
    "queue",
    "runningEstimate",
    "schedulerName",
    "tasks",
    "ttlSecondsAfterFinished",
    "volumes"
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
public class JobSpec implements Editable<JobSpecBuilder>, KubernetesResource
{

    @JsonProperty("maxRetry")
    private Integer maxRetry;
    @JsonProperty("minAvailable")
    private Integer minAvailable;
    @JsonProperty("minSuccess")
    private Integer minSuccess;
    @JsonProperty("plugins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> plugins = new LinkedHashMap<>();
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LifecyclePolicy> policies = new ArrayList<>();
    @JsonProperty("priorityClassName")
    private String priorityClassName;
    @JsonProperty("queue")
    private String queue;
    @JsonProperty("runningEstimate")
    private Duration runningEstimate;
    @JsonProperty("schedulerName")
    private String schedulerName;
    @JsonProperty("tasks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskSpec> tasks = new ArrayList<>();
    @JsonProperty("ttlSecondsAfterFinished")
    private Integer ttlSecondsAfterFinished;
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VolumeSpec> volumes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JobSpec() {
    }

    public JobSpec(Integer maxRetry, Integer minAvailable, Integer minSuccess, Map<String, List<String>> plugins, List<LifecyclePolicy> policies, String priorityClassName, String queue, Duration runningEstimate, String schedulerName, List<TaskSpec> tasks, Integer ttlSecondsAfterFinished, List<VolumeSpec> volumes) {
        super();
        this.maxRetry = maxRetry;
        this.minAvailable = minAvailable;
        this.minSuccess = minSuccess;
        this.plugins = plugins;
        this.policies = policies;
        this.priorityClassName = priorityClassName;
        this.queue = queue;
        this.runningEstimate = runningEstimate;
        this.schedulerName = schedulerName;
        this.tasks = tasks;
        this.ttlSecondsAfterFinished = ttlSecondsAfterFinished;
        this.volumes = volumes;
    }

    /**
     * Specifies the maximum number of retries before marking this Job failed. Defaults to 3.
     */
    @JsonProperty("maxRetry")
    public Integer getMaxRetry() {
        return maxRetry;
    }

    /**
     * Specifies the maximum number of retries before marking this Job failed. Defaults to 3.
     */
    @JsonProperty("maxRetry")
    public void setMaxRetry(Integer maxRetry) {
        this.maxRetry = maxRetry;
    }

    /**
     * The minimal available pods to run for this Job Defaults to the summary of tasks' replicas
     */
    @JsonProperty("minAvailable")
    public Integer getMinAvailable() {
        return minAvailable;
    }

    /**
     * The minimal available pods to run for this Job Defaults to the summary of tasks' replicas
     */
    @JsonProperty("minAvailable")
    public void setMinAvailable(Integer minAvailable) {
        this.minAvailable = minAvailable;
    }

    /**
     * The minimal success pods to run for this Job
     */
    @JsonProperty("minSuccess")
    public Integer getMinSuccess() {
        return minSuccess;
    }

    /**
     * The minimal success pods to run for this Job
     */
    @JsonProperty("minSuccess")
    public void setMinSuccess(Integer minSuccess) {
        this.minSuccess = minSuccess;
    }

    /**
     * Specifies the plugin of job Key is plugin name, value is the arguments of the plugin
     */
    @JsonProperty("plugins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getPlugins() {
        return plugins;
    }

    /**
     * Specifies the plugin of job Key is plugin name, value is the arguments of the plugin
     */
    @JsonProperty("plugins")
    public void setPlugins(Map<String, List<String>> plugins) {
        this.plugins = plugins;
    }

    /**
     * Specifies the default lifecycle of tasks
     */
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LifecyclePolicy> getPolicies() {
        return policies;
    }

    /**
     * Specifies the default lifecycle of tasks
     */
    @JsonProperty("policies")
    public void setPolicies(List<LifecyclePolicy> policies) {
        this.policies = policies;
    }

    /**
     * If specified, indicates the job's priority.
     */
    @JsonProperty("priorityClassName")
    public String getPriorityClassName() {
        return priorityClassName;
    }

    /**
     * If specified, indicates the job's priority.
     */
    @JsonProperty("priorityClassName")
    public void setPriorityClassName(String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    /**
     * Specifies the queue that will be used in the scheduler, "default" queue is used this leaves empty.
     */
    @JsonProperty("queue")
    public String getQueue() {
        return queue;
    }

    /**
     * Specifies the queue that will be used in the scheduler, "default" queue is used this leaves empty.
     */
    @JsonProperty("queue")
    public void setQueue(String queue) {
        this.queue = queue;
    }

    /**
     * JobSpec describes how the job execution will look like and when it will actually run.
     */
    @JsonProperty("runningEstimate")
    public Duration getRunningEstimate() {
        return runningEstimate;
    }

    /**
     * JobSpec describes how the job execution will look like and when it will actually run.
     */
    @JsonProperty("runningEstimate")
    public void setRunningEstimate(Duration runningEstimate) {
        this.runningEstimate = runningEstimate;
    }

    /**
     * SchedulerName is the default value of `tasks.template.spec.schedulerName`.
     */
    @JsonProperty("schedulerName")
    public String getSchedulerName() {
        return schedulerName;
    }

    /**
     * SchedulerName is the default value of `tasks.template.spec.schedulerName`.
     */
    @JsonProperty("schedulerName")
    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    /**
     * Tasks specifies the task specification of Job
     */
    @JsonProperty("tasks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaskSpec> getTasks() {
        return tasks;
    }

    /**
     * Tasks specifies the task specification of Job
     */
    @JsonProperty("tasks")
    public void setTasks(List<TaskSpec> tasks) {
        this.tasks = tasks;
    }

    /**
     * ttlSecondsAfterFinished limits the lifetime of a Job that has finished execution (either Completed or Failed). If this field is set, ttlSecondsAfterFinished after the Job finishes, it is eligible to be automatically deleted. If this field is unset, the Job won't be automatically deleted. If this field is set to zero, the Job becomes eligible to be deleted immediately after it finishes.
     */
    @JsonProperty("ttlSecondsAfterFinished")
    public Integer getTtlSecondsAfterFinished() {
        return ttlSecondsAfterFinished;
    }

    /**
     * ttlSecondsAfterFinished limits the lifetime of a Job that has finished execution (either Completed or Failed). If this field is set, ttlSecondsAfterFinished after the Job finishes, it is eligible to be automatically deleted. If this field is unset, the Job won't be automatically deleted. If this field is set to zero, the Job becomes eligible to be deleted immediately after it finishes.
     */
    @JsonProperty("ttlSecondsAfterFinished")
    public void setTtlSecondsAfterFinished(Integer ttlSecondsAfterFinished) {
        this.ttlSecondsAfterFinished = ttlSecondsAfterFinished;
    }

    /**
     * The volumes mount on Job
     */
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeSpec> getVolumes() {
        return volumes;
    }

    /**
     * The volumes mount on Job
     */
    @JsonProperty("volumes")
    public void setVolumes(List<VolumeSpec> volumes) {
        this.volumes = volumes;
    }

    @JsonIgnore
    public JobSpecBuilder edit() {
        return new JobSpecBuilder(this);
    }

    @JsonIgnore
    public JobSpecBuilder toBuilder() {
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
        if (!(o instanceof JobSpec)) {
            return false;
        }
        JobSpec other = (JobSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$maxRetry = this.getMaxRetry();
        Object other$maxRetry = other.getMaxRetry();
        if (this$maxRetry == null ? other$maxRetry != null : !this$maxRetry.equals(other$maxRetry)) {
            return false;
        }
        Object this$minAvailable = this.getMinAvailable();
        Object other$minAvailable = other.getMinAvailable();
        if (this$minAvailable == null ? other$minAvailable != null : !this$minAvailable.equals(other$minAvailable)) {
            return false;
        }
        Object this$minSuccess = this.getMinSuccess();
        Object other$minSuccess = other.getMinSuccess();
        if (this$minSuccess == null ? other$minSuccess != null : !this$minSuccess.equals(other$minSuccess)) {
            return false;
        }
        Object this$plugins = this.getPlugins();
        Object other$plugins = other.getPlugins();
        if (this$plugins == null ? other$plugins != null : !this$plugins.equals(other$plugins)) {
            return false;
        }
        Object this$policies = this.getPolicies();
        Object other$policies = other.getPolicies();
        if (this$policies == null ? other$policies != null : !this$policies.equals(other$policies)) {
            return false;
        }
        Object this$priorityClassName = this.getPriorityClassName();
        Object other$priorityClassName = other.getPriorityClassName();
        if (this$priorityClassName == null ? other$priorityClassName != null : !this$priorityClassName.equals(other$priorityClassName)) {
            return false;
        }
        Object this$queue = this.getQueue();
        Object other$queue = other.getQueue();
        if (this$queue == null ? other$queue != null : !this$queue.equals(other$queue)) {
            return false;
        }
        Object this$runningEstimate = this.getRunningEstimate();
        Object other$runningEstimate = other.getRunningEstimate();
        if (this$runningEstimate == null ? other$runningEstimate != null : !this$runningEstimate.equals(other$runningEstimate)) {
            return false;
        }
        Object this$schedulerName = this.getSchedulerName();
        Object other$schedulerName = other.getSchedulerName();
        if (this$schedulerName == null ? other$schedulerName != null : !this$schedulerName.equals(other$schedulerName)) {
            return false;
        }
        Object this$tasks = this.getTasks();
        Object other$tasks = other.getTasks();
        if (this$tasks == null ? other$tasks != null : !this$tasks.equals(other$tasks)) {
            return false;
        }
        Object this$ttlSecondsAfterFinished = this.getTtlSecondsAfterFinished();
        Object other$ttlSecondsAfterFinished = other.getTtlSecondsAfterFinished();
        if (this$ttlSecondsAfterFinished == null ? other$ttlSecondsAfterFinished != null : !this$ttlSecondsAfterFinished.equals(other$ttlSecondsAfterFinished)) {
            return false;
        }
        Object this$volumes = this.getVolumes();
        Object other$volumes = other.getVolumes();
        if (this$volumes == null ? other$volumes != null : !this$volumes.equals(other$volumes)) {
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
        return other instanceof JobSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $maxRetry = this.getMaxRetry();
        result = result * prime + ($maxRetry == null ? 43 : $maxRetry.hashCode());
        Object $minAvailable = this.getMinAvailable();
        result = result * prime + ($minAvailable == null ? 43 : $minAvailable.hashCode());
        Object $minSuccess = this.getMinSuccess();
        result = result * prime + ($minSuccess == null ? 43 : $minSuccess.hashCode());
        Object $plugins = this.getPlugins();
        result = result * prime + ($plugins == null ? 43 : $plugins.hashCode());
        Object $policies = this.getPolicies();
        result = result * prime + ($policies == null ? 43 : $policies.hashCode());
        Object $priorityClassName = this.getPriorityClassName();
        result = result * prime + ($priorityClassName == null ? 43 : $priorityClassName.hashCode());
        Object $queue = this.getQueue();
        result = result * prime + ($queue == null ? 43 : $queue.hashCode());
        Object $runningEstimate = this.getRunningEstimate();
        result = result * prime + ($runningEstimate == null ? 43 : $runningEstimate.hashCode());
        Object $schedulerName = this.getSchedulerName();
        result = result * prime + ($schedulerName == null ? 43 : $schedulerName.hashCode());
        Object $tasks = this.getTasks();
        result = result * prime + ($tasks == null ? 43 : $tasks.hashCode());
        Object $ttlSecondsAfterFinished = this.getTtlSecondsAfterFinished();
        result = result * prime + ($ttlSecondsAfterFinished == null ? 43 : $ttlSecondsAfterFinished.hashCode());
        Object $volumes = this.getVolumes();
        result = result * prime + ($volumes == null ? 43 : $volumes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "JobSpec(" + "maxRetry=" + this.getMaxRetry() + ", minAvailable=" + this.getMinAvailable() + ", minSuccess=" + this.getMinSuccess() + ", plugins=" + this.getPlugins() + ", policies=" + this.getPolicies() + ", priorityClassName=" + this.getPriorityClassName() + ", queue=" + this.getQueue() + ", runningEstimate=" + this.getRunningEstimate() + ", schedulerName=" + this.getSchedulerName() + ", tasks=" + this.getTasks() + ", ttlSecondsAfterFinished=" + this.getTtlSecondsAfterFinished() + ", volumes=" + this.getVolumes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
