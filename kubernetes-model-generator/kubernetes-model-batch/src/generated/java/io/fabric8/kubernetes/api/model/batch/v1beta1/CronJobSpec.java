
package io.fabric8.kubernetes.api.model.batch.v1beta1;

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
    "concurrencyPolicy",
    "failedJobsHistoryLimit",
    "jobTemplate",
    "schedule",
    "startingDeadlineSeconds",
    "successfulJobsHistoryLimit",
    "suspend",
    "timeZone"
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
public class CronJobSpec implements KubernetesResource
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
    @JsonProperty("timeZone")
    private String timeZone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CronJobSpec() {
    }

    public CronJobSpec(String concurrencyPolicy, Integer failedJobsHistoryLimit, JobTemplateSpec jobTemplate, String schedule, Long startingDeadlineSeconds, Integer successfulJobsHistoryLimit, Boolean suspend, String timeZone) {
        super();
        this.concurrencyPolicy = concurrencyPolicy;
        this.failedJobsHistoryLimit = failedJobsHistoryLimit;
        this.jobTemplate = jobTemplate;
        this.schedule = schedule;
        this.startingDeadlineSeconds = startingDeadlineSeconds;
        this.successfulJobsHistoryLimit = successfulJobsHistoryLimit;
        this.suspend = suspend;
        this.timeZone = timeZone;
    }

    @JsonProperty("concurrencyPolicy")
    public String getConcurrencyPolicy() {
        return concurrencyPolicy;
    }

    @JsonProperty("concurrencyPolicy")
    public void setConcurrencyPolicy(String concurrencyPolicy) {
        this.concurrencyPolicy = concurrencyPolicy;
    }

    @JsonProperty("failedJobsHistoryLimit")
    public Integer getFailedJobsHistoryLimit() {
        return failedJobsHistoryLimit;
    }

    @JsonProperty("failedJobsHistoryLimit")
    public void setFailedJobsHistoryLimit(Integer failedJobsHistoryLimit) {
        this.failedJobsHistoryLimit = failedJobsHistoryLimit;
    }

    @JsonProperty("jobTemplate")
    public JobTemplateSpec getJobTemplate() {
        return jobTemplate;
    }

    @JsonProperty("jobTemplate")
    public void setJobTemplate(JobTemplateSpec jobTemplate) {
        this.jobTemplate = jobTemplate;
    }

    @JsonProperty("schedule")
    public String getSchedule() {
        return schedule;
    }

    @JsonProperty("schedule")
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @JsonProperty("startingDeadlineSeconds")
    public Long getStartingDeadlineSeconds() {
        return startingDeadlineSeconds;
    }

    @JsonProperty("startingDeadlineSeconds")
    public void setStartingDeadlineSeconds(Long startingDeadlineSeconds) {
        this.startingDeadlineSeconds = startingDeadlineSeconds;
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

    @JsonProperty("timeZone")
    public String getTimeZone() {
        return timeZone;
    }

    @JsonProperty("timeZone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
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
