package io.fabric8.kubernetes.api.model.batch.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class CronJobSpecFluent<A extends io.fabric8.kubernetes.api.model.batch.v1.CronJobSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String concurrencyPolicy;
  private Integer failedJobsHistoryLimit;
  private JobTemplateSpecBuilder jobTemplate;
  private String schedule;
  private Long startingDeadlineSeconds;
  private Integer successfulJobsHistoryLimit;
  private Boolean suspend;
  private String timeZone;

  public CronJobSpecFluent() {
  }
  
  public CronJobSpecFluent(CronJobSpec instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public JobTemplateSpec buildJobTemplate() {
    return this.jobTemplate != null ? this.jobTemplate.build() : null;
  }
  
  protected void copyInstance(CronJobSpec instance) {
    instance = instance != null ? instance : new CronJobSpec();
    if (instance != null) {
        this.withConcurrencyPolicy(instance.getConcurrencyPolicy());
        this.withFailedJobsHistoryLimit(instance.getFailedJobsHistoryLimit());
        this.withJobTemplate(instance.getJobTemplate());
        this.withSchedule(instance.getSchedule());
        this.withStartingDeadlineSeconds(instance.getStartingDeadlineSeconds());
        this.withSuccessfulJobsHistoryLimit(instance.getSuccessfulJobsHistoryLimit());
        this.withSuspend(instance.getSuspend());
        this.withTimeZone(instance.getTimeZone());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public JobTemplateNested<A> editJobTemplate() {
    return this.withNewJobTemplateLike(Optional.ofNullable(this.buildJobTemplate()).orElse(null));
  }
  
  public JobTemplateNested<A> editOrNewJobTemplate() {
    return this.withNewJobTemplateLike(Optional.ofNullable(this.buildJobTemplate()).orElse(new JobTemplateSpecBuilder().build()));
  }
  
  public JobTemplateNested<A> editOrNewJobTemplateLike(JobTemplateSpec item) {
    return this.withNewJobTemplateLike(Optional.ofNullable(this.buildJobTemplate()).orElse(item));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    CronJobSpecFluent that = (CronJobSpecFluent) o;
    if (!(Objects.equals(concurrencyPolicy, that.concurrencyPolicy))) {
      return false;
    }
    if (!(Objects.equals(failedJobsHistoryLimit, that.failedJobsHistoryLimit))) {
      return false;
    }
    if (!(Objects.equals(jobTemplate, that.jobTemplate))) {
      return false;
    }
    if (!(Objects.equals(schedule, that.schedule))) {
      return false;
    }
    if (!(Objects.equals(startingDeadlineSeconds, that.startingDeadlineSeconds))) {
      return false;
    }
    if (!(Objects.equals(successfulJobsHistoryLimit, that.successfulJobsHistoryLimit))) {
      return false;
    }
    if (!(Objects.equals(suspend, that.suspend))) {
      return false;
    }
    if (!(Objects.equals(timeZone, that.timeZone))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getConcurrencyPolicy() {
    return this.concurrencyPolicy;
  }
  
  public Integer getFailedJobsHistoryLimit() {
    return this.failedJobsHistoryLimit;
  }
  
  public String getSchedule() {
    return this.schedule;
  }
  
  public Long getStartingDeadlineSeconds() {
    return this.startingDeadlineSeconds;
  }
  
  public Integer getSuccessfulJobsHistoryLimit() {
    return this.successfulJobsHistoryLimit;
  }
  
  public Boolean getSuspend() {
    return this.suspend;
  }
  
  public String getTimeZone() {
    return this.timeZone;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConcurrencyPolicy() {
    return this.concurrencyPolicy != null;
  }
  
  public boolean hasFailedJobsHistoryLimit() {
    return this.failedJobsHistoryLimit != null;
  }
  
  public boolean hasJobTemplate() {
    return this.jobTemplate != null;
  }
  
  public boolean hasSchedule() {
    return this.schedule != null;
  }
  
  public boolean hasStartingDeadlineSeconds() {
    return this.startingDeadlineSeconds != null;
  }
  
  public boolean hasSuccessfulJobsHistoryLimit() {
    return this.successfulJobsHistoryLimit != null;
  }
  
  public boolean hasSuspend() {
    return this.suspend != null;
  }
  
  public boolean hasTimeZone() {
    return this.timeZone != null;
  }
  
  public int hashCode() {
    return Objects.hash(concurrencyPolicy, failedJobsHistoryLimit, jobTemplate, schedule, startingDeadlineSeconds, successfulJobsHistoryLimit, suspend, timeZone, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(concurrencyPolicy == null)) {
        sb.append("concurrencyPolicy:");
        sb.append(concurrencyPolicy);
        sb.append(",");
    }
    if (!(failedJobsHistoryLimit == null)) {
        sb.append("failedJobsHistoryLimit:");
        sb.append(failedJobsHistoryLimit);
        sb.append(",");
    }
    if (!(jobTemplate == null)) {
        sb.append("jobTemplate:");
        sb.append(jobTemplate);
        sb.append(",");
    }
    if (!(schedule == null)) {
        sb.append("schedule:");
        sb.append(schedule);
        sb.append(",");
    }
    if (!(startingDeadlineSeconds == null)) {
        sb.append("startingDeadlineSeconds:");
        sb.append(startingDeadlineSeconds);
        sb.append(",");
    }
    if (!(successfulJobsHistoryLimit == null)) {
        sb.append("successfulJobsHistoryLimit:");
        sb.append(successfulJobsHistoryLimit);
        sb.append(",");
    }
    if (!(suspend == null)) {
        sb.append("suspend:");
        sb.append(suspend);
        sb.append(",");
    }
    if (!(timeZone == null)) {
        sb.append("timeZone:");
        sb.append(timeZone);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withConcurrencyPolicy(String concurrencyPolicy) {
    this.concurrencyPolicy = concurrencyPolicy;
    return (A) this;
  }
  
  public A withFailedJobsHistoryLimit(Integer failedJobsHistoryLimit) {
    this.failedJobsHistoryLimit = failedJobsHistoryLimit;
    return (A) this;
  }
  
  public A withJobTemplate(JobTemplateSpec jobTemplate) {
    this._visitables.remove("jobTemplate");
    if (jobTemplate != null) {
        this.jobTemplate = new JobTemplateSpecBuilder(jobTemplate);
        this._visitables.get("jobTemplate").add(this.jobTemplate);
    } else {
        this.jobTemplate = null;
        this._visitables.get("jobTemplate").remove(this.jobTemplate);
    }
    return (A) this;
  }
  
  public JobTemplateNested<A> withNewJobTemplate() {
    return new JobTemplateNested(null);
  }
  
  public JobTemplateNested<A> withNewJobTemplateLike(JobTemplateSpec item) {
    return new JobTemplateNested(item);
  }
  
  public A withSchedule(String schedule) {
    this.schedule = schedule;
    return (A) this;
  }
  
  public A withStartingDeadlineSeconds(Long startingDeadlineSeconds) {
    this.startingDeadlineSeconds = startingDeadlineSeconds;
    return (A) this;
  }
  
  public A withSuccessfulJobsHistoryLimit(Integer successfulJobsHistoryLimit) {
    this.successfulJobsHistoryLimit = successfulJobsHistoryLimit;
    return (A) this;
  }
  
  public A withSuspend() {
    return withSuspend(true);
  }
  
  public A withSuspend(Boolean suspend) {
    this.suspend = suspend;
    return (A) this;
  }
  
  public A withTimeZone(String timeZone) {
    this.timeZone = timeZone;
    return (A) this;
  }
  public class JobTemplateNested<N> extends JobTemplateSpecFluent<JobTemplateNested<N>> implements Nested<N>{
  
    JobTemplateSpecBuilder builder;
  
    JobTemplateNested(JobTemplateSpec item) {
      this.builder = new JobTemplateSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) CronJobSpecFluent.this.withJobTemplate(builder.build());
    }
    
    public N endJobTemplate() {
      return and();
    }
    
  }
}