
package io.fabric8.kubernetes.api.model.batch.v1beta1;

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

/**
 * CronJobSpec describes how the job execution will look like and when it will actually run.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "concurrencyPolicy",
    "failedJobsHistoryLimit",
    "jobTemplate",
    "schedule",
    "startingDeadlineSeconds",
    "successfulJobsHistoryLimit",
    "suspend"
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
public class CronJobSpec implements Editable<CronJobSpecBuilder>, KubernetesResource
{

    @JsonProperty("concurrencyPolicy")
    private String concurrencyPolicy;
    @JsonProperty("failedJobsHistoryLimit")
    private Integer failedJobsHistoryLimit;
    @JsonProperty("jobTemplate")
    private JobTemplateSpec jobTemplate;
    @JsonProperty("schedule")
    private String schedule;
    @JsonProperty("startingDeadlineSeconds")
    private Long startingDeadlineSeconds;
    @JsonProperty("successfulJobsHistoryLimit")
    private Integer successfulJobsHistoryLimit;
    @JsonProperty("suspend")
    private Boolean suspend;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CronJobSpec() {
    }

    public CronJobSpec(String concurrencyPolicy, Integer failedJobsHistoryLimit, JobTemplateSpec jobTemplate, String schedule, Long startingDeadlineSeconds, Integer successfulJobsHistoryLimit, Boolean suspend) {
        super();
        this.concurrencyPolicy = concurrencyPolicy;
        this.failedJobsHistoryLimit = failedJobsHistoryLimit;
        this.jobTemplate = jobTemplate;
        this.schedule = schedule;
        this.startingDeadlineSeconds = startingDeadlineSeconds;
        this.successfulJobsHistoryLimit = successfulJobsHistoryLimit;
        this.suspend = suspend;
    }

    /**
     * Specifies how to treat concurrent executions of a Job. Valid values are: - "Allow" (default): allows CronJobs to run concurrently; - "Forbid": forbids concurrent runs, skipping next run if previous run hasn't finished yet; - "Replace": cancels currently running job and replaces it with a new one
     */
    @JsonProperty("concurrencyPolicy")
    public String getConcurrencyPolicy() {
        return concurrencyPolicy;
    }

    /**
     * Specifies how to treat concurrent executions of a Job. Valid values are: - "Allow" (default): allows CronJobs to run concurrently; - "Forbid": forbids concurrent runs, skipping next run if previous run hasn't finished yet; - "Replace": cancels currently running job and replaces it with a new one
     */
    @JsonProperty("concurrencyPolicy")
    public void setConcurrencyPolicy(String concurrencyPolicy) {
        this.concurrencyPolicy = concurrencyPolicy;
    }

    /**
     * The number of failed finished jobs to retain. This is a pointer to distinguish between explicit zero and not specified. Defaults to 1.
     */
    @JsonProperty("failedJobsHistoryLimit")
    public Integer getFailedJobsHistoryLimit() {
        return failedJobsHistoryLimit;
    }

    /**
     * The number of failed finished jobs to retain. This is a pointer to distinguish between explicit zero and not specified. Defaults to 1.
     */
    @JsonProperty("failedJobsHistoryLimit")
    public void setFailedJobsHistoryLimit(Integer failedJobsHistoryLimit) {
        this.failedJobsHistoryLimit = failedJobsHistoryLimit;
    }

    /**
     * CronJobSpec describes how the job execution will look like and when it will actually run.
     */
    @JsonProperty("jobTemplate")
    public JobTemplateSpec getJobTemplate() {
        return jobTemplate;
    }

    /**
     * CronJobSpec describes how the job execution will look like and when it will actually run.
     */
    @JsonProperty("jobTemplate")
    public void setJobTemplate(JobTemplateSpec jobTemplate) {
        this.jobTemplate = jobTemplate;
    }

    /**
     * The schedule in Cron format, see https://en.wikipedia.org/wiki/Cron.
     */
    @JsonProperty("schedule")
    public String getSchedule() {
        return schedule;
    }

    /**
     * The schedule in Cron format, see https://en.wikipedia.org/wiki/Cron.
     */
    @JsonProperty("schedule")
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * Optional deadline in seconds for starting the job if it misses scheduled time for any reason.  Missed jobs executions will be counted as failed ones.
     */
    @JsonProperty("startingDeadlineSeconds")
    public Long getStartingDeadlineSeconds() {
        return startingDeadlineSeconds;
    }

    /**
     * Optional deadline in seconds for starting the job if it misses scheduled time for any reason.  Missed jobs executions will be counted as failed ones.
     */
    @JsonProperty("startingDeadlineSeconds")
    public void setStartingDeadlineSeconds(Long startingDeadlineSeconds) {
        this.startingDeadlineSeconds = startingDeadlineSeconds;
    }

    /**
     * The number of successful finished jobs to retain. This is a pointer to distinguish between explicit zero and not specified. Defaults to 3.
     */
    @JsonProperty("successfulJobsHistoryLimit")
    public Integer getSuccessfulJobsHistoryLimit() {
        return successfulJobsHistoryLimit;
    }

    /**
     * The number of successful finished jobs to retain. This is a pointer to distinguish between explicit zero and not specified. Defaults to 3.
     */
    @JsonProperty("successfulJobsHistoryLimit")
    public void setSuccessfulJobsHistoryLimit(Integer successfulJobsHistoryLimit) {
        this.successfulJobsHistoryLimit = successfulJobsHistoryLimit;
    }

    /**
     * This flag tells the controller to suspend subsequent executions, it does not apply to already started executions.  Defaults to false.
     */
    @JsonProperty("suspend")
    public Boolean getSuspend() {
        return suspend;
    }

    /**
     * This flag tells the controller to suspend subsequent executions, it does not apply to already started executions.  Defaults to false.
     */
    @JsonProperty("suspend")
    public void setSuspend(Boolean suspend) {
        this.suspend = suspend;
    }

    @JsonIgnore
    public CronJobSpecBuilder edit() {
        return new CronJobSpecBuilder(this);
    }

    @JsonIgnore
    public CronJobSpecBuilder toBuilder() {
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
        if (!(o instanceof CronJobSpec)) {
            return false;
        }
        CronJobSpec other = (CronJobSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$concurrencyPolicy = this.getConcurrencyPolicy();
        Object other$concurrencyPolicy = other.getConcurrencyPolicy();
        if (this$concurrencyPolicy == null ? other$concurrencyPolicy != null : !this$concurrencyPolicy.equals(other$concurrencyPolicy)) {
            return false;
        }
        Object this$failedJobsHistoryLimit = this.getFailedJobsHistoryLimit();
        Object other$failedJobsHistoryLimit = other.getFailedJobsHistoryLimit();
        if (this$failedJobsHistoryLimit == null ? other$failedJobsHistoryLimit != null : !this$failedJobsHistoryLimit.equals(other$failedJobsHistoryLimit)) {
            return false;
        }
        Object this$jobTemplate = this.getJobTemplate();
        Object other$jobTemplate = other.getJobTemplate();
        if (this$jobTemplate == null ? other$jobTemplate != null : !this$jobTemplate.equals(other$jobTemplate)) {
            return false;
        }
        Object this$schedule = this.getSchedule();
        Object other$schedule = other.getSchedule();
        if (this$schedule == null ? other$schedule != null : !this$schedule.equals(other$schedule)) {
            return false;
        }
        Object this$startingDeadlineSeconds = this.getStartingDeadlineSeconds();
        Object other$startingDeadlineSeconds = other.getStartingDeadlineSeconds();
        if (this$startingDeadlineSeconds == null ? other$startingDeadlineSeconds != null : !this$startingDeadlineSeconds.equals(other$startingDeadlineSeconds)) {
            return false;
        }
        Object this$successfulJobsHistoryLimit = this.getSuccessfulJobsHistoryLimit();
        Object other$successfulJobsHistoryLimit = other.getSuccessfulJobsHistoryLimit();
        if (this$successfulJobsHistoryLimit == null ? other$successfulJobsHistoryLimit != null : !this$successfulJobsHistoryLimit.equals(other$successfulJobsHistoryLimit)) {
            return false;
        }
        Object this$suspend = this.getSuspend();
        Object other$suspend = other.getSuspend();
        if (this$suspend == null ? other$suspend != null : !this$suspend.equals(other$suspend)) {
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
        return other instanceof CronJobSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $concurrencyPolicy = this.getConcurrencyPolicy();
        result = result * prime + ($concurrencyPolicy == null ? 43 : $concurrencyPolicy.hashCode());
        Object $failedJobsHistoryLimit = this.getFailedJobsHistoryLimit();
        result = result * prime + ($failedJobsHistoryLimit == null ? 43 : $failedJobsHistoryLimit.hashCode());
        Object $jobTemplate = this.getJobTemplate();
        result = result * prime + ($jobTemplate == null ? 43 : $jobTemplate.hashCode());
        Object $schedule = this.getSchedule();
        result = result * prime + ($schedule == null ? 43 : $schedule.hashCode());
        Object $startingDeadlineSeconds = this.getStartingDeadlineSeconds();
        result = result * prime + ($startingDeadlineSeconds == null ? 43 : $startingDeadlineSeconds.hashCode());
        Object $successfulJobsHistoryLimit = this.getSuccessfulJobsHistoryLimit();
        result = result * prime + ($successfulJobsHistoryLimit == null ? 43 : $successfulJobsHistoryLimit.hashCode());
        Object $suspend = this.getSuspend();
        result = result * prime + ($suspend == null ? 43 : $suspend.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CronJobSpec(" + "concurrencyPolicy=" + this.getConcurrencyPolicy() + ", failedJobsHistoryLimit=" + this.getFailedJobsHistoryLimit() + ", jobTemplate=" + this.getJobTemplate() + ", schedule=" + this.getSchedule() + ", startingDeadlineSeconds=" + this.getStartingDeadlineSeconds() + ", successfulJobsHistoryLimit=" + this.getSuccessfulJobsHistoryLimit() + ", suspend=" + this.getSuspend() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
