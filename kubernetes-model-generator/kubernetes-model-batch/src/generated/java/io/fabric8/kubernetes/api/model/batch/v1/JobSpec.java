
package io.fabric8.kubernetes.api.model.batch.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * JobSpec describes how the job execution will look like.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "activeDeadlineSeconds",
    "backoffLimit",
    "backoffLimitPerIndex",
    "completionMode",
    "completions",
    "managedBy",
    "manualSelector",
    "maxFailedIndexes",
    "parallelism",
    "podFailurePolicy",
    "podReplacementPolicy",
    "selector",
    "successPolicy",
    "suspend",
    "template",
    "ttlSecondsAfterFinished"
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
public class JobSpec implements Editable<JobSpecBuilder>, KubernetesResource
{

    @JsonProperty("activeDeadlineSeconds")
    private Long activeDeadlineSeconds;
    @JsonProperty("backoffLimit")
    private Integer backoffLimit;
    @JsonProperty("backoffLimitPerIndex")
    private Integer backoffLimitPerIndex;
    @JsonProperty("completionMode")
    private String completionMode;
    @JsonProperty("completions")
    private Integer completions;
    @JsonProperty("managedBy")
    private String managedBy;
    @JsonProperty("manualSelector")
    private Boolean manualSelector;
    @JsonProperty("maxFailedIndexes")
    private Integer maxFailedIndexes;
    @JsonProperty("parallelism")
    private Integer parallelism;
    @JsonProperty("podFailurePolicy")
    private PodFailurePolicy podFailurePolicy;
    @JsonProperty("podReplacementPolicy")
    private String podReplacementPolicy;
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonProperty("successPolicy")
    private SuccessPolicy successPolicy;
    @JsonProperty("suspend")
    private Boolean suspend;
    @JsonProperty("template")
    private PodTemplateSpec template;
    @JsonProperty("ttlSecondsAfterFinished")
    private Integer ttlSecondsAfterFinished;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JobSpec() {
    }

    public JobSpec(Long activeDeadlineSeconds, Integer backoffLimit, Integer backoffLimitPerIndex, String completionMode, Integer completions, String managedBy, Boolean manualSelector, Integer maxFailedIndexes, Integer parallelism, PodFailurePolicy podFailurePolicy, String podReplacementPolicy, LabelSelector selector, SuccessPolicy successPolicy, Boolean suspend, PodTemplateSpec template, Integer ttlSecondsAfterFinished) {
        super();
        this.activeDeadlineSeconds = activeDeadlineSeconds;
        this.backoffLimit = backoffLimit;
        this.backoffLimitPerIndex = backoffLimitPerIndex;
        this.completionMode = completionMode;
        this.completions = completions;
        this.managedBy = managedBy;
        this.manualSelector = manualSelector;
        this.maxFailedIndexes = maxFailedIndexes;
        this.parallelism = parallelism;
        this.podFailurePolicy = podFailurePolicy;
        this.podReplacementPolicy = podReplacementPolicy;
        this.selector = selector;
        this.successPolicy = successPolicy;
        this.suspend = suspend;
        this.template = template;
        this.ttlSecondsAfterFinished = ttlSecondsAfterFinished;
    }

    /**
     * Specifies the duration in seconds relative to the startTime that the job may be continuously active before the system tries to terminate it; value must be positive integer. If a Job is suspended (at creation or through an update), this timer will effectively be stopped and reset when the Job is resumed again.
     */
    @JsonProperty("activeDeadlineSeconds")
    public Long getActiveDeadlineSeconds() {
        return activeDeadlineSeconds;
    }

    /**
     * Specifies the duration in seconds relative to the startTime that the job may be continuously active before the system tries to terminate it; value must be positive integer. If a Job is suspended (at creation or through an update), this timer will effectively be stopped and reset when the Job is resumed again.
     */
    @JsonProperty("activeDeadlineSeconds")
    public void setActiveDeadlineSeconds(Long activeDeadlineSeconds) {
        this.activeDeadlineSeconds = activeDeadlineSeconds;
    }

    /**
     * Specifies the number of retries before marking this job failed. Defaults to 6, unless backoffLimitPerIndex (only Indexed Job) is specified. When backoffLimitPerIndex is specified, backoffLimit defaults to 2147483647.
     */
    @JsonProperty("backoffLimit")
    public Integer getBackoffLimit() {
        return backoffLimit;
    }

    /**
     * Specifies the number of retries before marking this job failed. Defaults to 6, unless backoffLimitPerIndex (only Indexed Job) is specified. When backoffLimitPerIndex is specified, backoffLimit defaults to 2147483647.
     */
    @JsonProperty("backoffLimit")
    public void setBackoffLimit(Integer backoffLimit) {
        this.backoffLimit = backoffLimit;
    }

    /**
     * Specifies the limit for the number of retries within an index before marking this index as failed. When enabled the number of failures per index is kept in the pod's batch.kubernetes.io/job-index-failure-count annotation. It can only be set when Job's completionMode=Indexed, and the Pod's restart policy is Never. The field is immutable.
     */
    @JsonProperty("backoffLimitPerIndex")
    public Integer getBackoffLimitPerIndex() {
        return backoffLimitPerIndex;
    }

    /**
     * Specifies the limit for the number of retries within an index before marking this index as failed. When enabled the number of failures per index is kept in the pod's batch.kubernetes.io/job-index-failure-count annotation. It can only be set when Job's completionMode=Indexed, and the Pod's restart policy is Never. The field is immutable.
     */
    @JsonProperty("backoffLimitPerIndex")
    public void setBackoffLimitPerIndex(Integer backoffLimitPerIndex) {
        this.backoffLimitPerIndex = backoffLimitPerIndex;
    }

    /**
     * completionMode specifies how Pod completions are tracked. It can be `NonIndexed` (default) or `Indexed`.<br><p> <br><p> `NonIndexed` means that the Job is considered complete when there have been .spec.completions successfully completed Pods. Each Pod completion is homologous to each other.<br><p> <br><p> `Indexed` means that the Pods of a Job get an associated completion index from 0 to (.spec.completions - 1), available in the annotation batch.kubernetes.io/job-completion-index. The Job is considered complete when there is one successfully completed Pod for each index. When value is `Indexed`, .spec.completions must be specified and `.spec.parallelism` must be less than or equal to 10^5. In addition, The Pod name takes the form `$(job-name)-$(index)-$(random-string)`, the Pod hostname takes the form `$(job-name)-$(index)`.<br><p> <br><p> More completion modes can be added in the future. If the Job controller observes a mode that it doesn't recognize, which is possible during upgrades due to version skew, the controller skips updates for the Job.
     */
    @JsonProperty("completionMode")
    public String getCompletionMode() {
        return completionMode;
    }

    /**
     * completionMode specifies how Pod completions are tracked. It can be `NonIndexed` (default) or `Indexed`.<br><p> <br><p> `NonIndexed` means that the Job is considered complete when there have been .spec.completions successfully completed Pods. Each Pod completion is homologous to each other.<br><p> <br><p> `Indexed` means that the Pods of a Job get an associated completion index from 0 to (.spec.completions - 1), available in the annotation batch.kubernetes.io/job-completion-index. The Job is considered complete when there is one successfully completed Pod for each index. When value is `Indexed`, .spec.completions must be specified and `.spec.parallelism` must be less than or equal to 10^5. In addition, The Pod name takes the form `$(job-name)-$(index)-$(random-string)`, the Pod hostname takes the form `$(job-name)-$(index)`.<br><p> <br><p> More completion modes can be added in the future. If the Job controller observes a mode that it doesn't recognize, which is possible during upgrades due to version skew, the controller skips updates for the Job.
     */
    @JsonProperty("completionMode")
    public void setCompletionMode(String completionMode) {
        this.completionMode = completionMode;
    }

    /**
     * Specifies the desired number of successfully finished pods the job should be run with.  Setting to null means that the success of any pod signals the success of all pods, and allows parallelism to have any positive value.  Setting to 1 means that parallelism is limited to 1 and the success of that pod signals the success of the job. More info: https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/
     */
    @JsonProperty("completions")
    public Integer getCompletions() {
        return completions;
    }

    /**
     * Specifies the desired number of successfully finished pods the job should be run with.  Setting to null means that the success of any pod signals the success of all pods, and allows parallelism to have any positive value.  Setting to 1 means that parallelism is limited to 1 and the success of that pod signals the success of the job. More info: https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/
     */
    @JsonProperty("completions")
    public void setCompletions(Integer completions) {
        this.completions = completions;
    }

    /**
     * ManagedBy field indicates the controller that manages a Job. The k8s Job controller reconciles jobs which don't have this field at all or the field value is the reserved string `kubernetes.io/job-controller`, but skips reconciling Jobs with a custom value for this field. The value must be a valid domain-prefixed path (e.g. acme.io/foo) - all characters before the first "/" must be a valid subdomain as defined by RFC 1123. All characters trailing the first "/" must be valid HTTP Path characters as defined by RFC 3986. The value cannot exceed 63 characters. This field is immutable.<br><p> <br><p> This field is beta-level. The job controller accepts setting the field when the feature gate JobManagedBy is enabled (enabled by default).
     */
    @JsonProperty("managedBy")
    public String getManagedBy() {
        return managedBy;
    }

    /**
     * ManagedBy field indicates the controller that manages a Job. The k8s Job controller reconciles jobs which don't have this field at all or the field value is the reserved string `kubernetes.io/job-controller`, but skips reconciling Jobs with a custom value for this field. The value must be a valid domain-prefixed path (e.g. acme.io/foo) - all characters before the first "/" must be a valid subdomain as defined by RFC 1123. All characters trailing the first "/" must be valid HTTP Path characters as defined by RFC 3986. The value cannot exceed 63 characters. This field is immutable.<br><p> <br><p> This field is beta-level. The job controller accepts setting the field when the feature gate JobManagedBy is enabled (enabled by default).
     */
    @JsonProperty("managedBy")
    public void setManagedBy(String managedBy) {
        this.managedBy = managedBy;
    }

    /**
     * manualSelector controls generation of pod labels and pod selectors. Leave `manualSelector` unset unless you are certain what you are doing. When false or unset, the system pick labels unique to this job and appends those labels to the pod template.  When true, the user is responsible for picking unique labels and specifying the selector.  Failure to pick a unique label may cause this and other jobs to not function correctly.  However, You may see `manualSelector=true` in jobs that were created with the old `extensions/v1beta1` API. More info: https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/#specifying-your-own-pod-selector
     */
    @JsonProperty("manualSelector")
    public Boolean getManualSelector() {
        return manualSelector;
    }

    /**
     * manualSelector controls generation of pod labels and pod selectors. Leave `manualSelector` unset unless you are certain what you are doing. When false or unset, the system pick labels unique to this job and appends those labels to the pod template.  When true, the user is responsible for picking unique labels and specifying the selector.  Failure to pick a unique label may cause this and other jobs to not function correctly.  However, You may see `manualSelector=true` in jobs that were created with the old `extensions/v1beta1` API. More info: https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/#specifying-your-own-pod-selector
     */
    @JsonProperty("manualSelector")
    public void setManualSelector(Boolean manualSelector) {
        this.manualSelector = manualSelector;
    }

    /**
     * Specifies the maximal number of failed indexes before marking the Job as failed, when backoffLimitPerIndex is set. Once the number of failed indexes exceeds this number the entire Job is marked as Failed and its execution is terminated. When left as null the job continues execution of all of its indexes and is marked with the `Complete` Job condition. It can only be specified when backoffLimitPerIndex is set. It can be null or up to completions. It is required and must be less than or equal to 10^4 when is completions greater than 10^5.
     */
    @JsonProperty("maxFailedIndexes")
    public Integer getMaxFailedIndexes() {
        return maxFailedIndexes;
    }

    /**
     * Specifies the maximal number of failed indexes before marking the Job as failed, when backoffLimitPerIndex is set. Once the number of failed indexes exceeds this number the entire Job is marked as Failed and its execution is terminated. When left as null the job continues execution of all of its indexes and is marked with the `Complete` Job condition. It can only be specified when backoffLimitPerIndex is set. It can be null or up to completions. It is required and must be less than or equal to 10^4 when is completions greater than 10^5.
     */
    @JsonProperty("maxFailedIndexes")
    public void setMaxFailedIndexes(Integer maxFailedIndexes) {
        this.maxFailedIndexes = maxFailedIndexes;
    }

    /**
     * Specifies the maximum desired number of pods the job should run at any given time. The actual number of pods running in steady state will be less than this number when ((.spec.completions - .status.successful) &lt; .spec.parallelism), i.e. when the work left to do is less than max parallelism. More info: https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/
     */
    @JsonProperty("parallelism")
    public Integer getParallelism() {
        return parallelism;
    }

    /**
     * Specifies the maximum desired number of pods the job should run at any given time. The actual number of pods running in steady state will be less than this number when ((.spec.completions - .status.successful) &lt; .spec.parallelism), i.e. when the work left to do is less than max parallelism. More info: https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/
     */
    @JsonProperty("parallelism")
    public void setParallelism(Integer parallelism) {
        this.parallelism = parallelism;
    }

    /**
     * JobSpec describes how the job execution will look like.
     */
    @JsonProperty("podFailurePolicy")
    public PodFailurePolicy getPodFailurePolicy() {
        return podFailurePolicy;
    }

    /**
     * JobSpec describes how the job execution will look like.
     */
    @JsonProperty("podFailurePolicy")
    public void setPodFailurePolicy(PodFailurePolicy podFailurePolicy) {
        this.podFailurePolicy = podFailurePolicy;
    }

    /**
     * podReplacementPolicy specifies when to create replacement Pods. Possible values are: - TerminatingOrFailed means that we recreate pods<br><p>   when they are terminating (has a metadata.deletionTimestamp) or failed.<br><p> - Failed means to wait until a previously created Pod is fully terminated (has phase<br><p>   Failed or Succeeded) before creating a replacement Pod.<br><p> <br><p> When using podFailurePolicy, Failed is the the only allowed value. TerminatingOrFailed and Failed are allowed values when podFailurePolicy is not in use.
     */
    @JsonProperty("podReplacementPolicy")
    public String getPodReplacementPolicy() {
        return podReplacementPolicy;
    }

    /**
     * podReplacementPolicy specifies when to create replacement Pods. Possible values are: - TerminatingOrFailed means that we recreate pods<br><p>   when they are terminating (has a metadata.deletionTimestamp) or failed.<br><p> - Failed means to wait until a previously created Pod is fully terminated (has phase<br><p>   Failed or Succeeded) before creating a replacement Pod.<br><p> <br><p> When using podFailurePolicy, Failed is the the only allowed value. TerminatingOrFailed and Failed are allowed values when podFailurePolicy is not in use.
     */
    @JsonProperty("podReplacementPolicy")
    public void setPodReplacementPolicy(String podReplacementPolicy) {
        this.podReplacementPolicy = podReplacementPolicy;
    }

    /**
     * JobSpec describes how the job execution will look like.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * JobSpec describes how the job execution will look like.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    /**
     * JobSpec describes how the job execution will look like.
     */
    @JsonProperty("successPolicy")
    public SuccessPolicy getSuccessPolicy() {
        return successPolicy;
    }

    /**
     * JobSpec describes how the job execution will look like.
     */
    @JsonProperty("successPolicy")
    public void setSuccessPolicy(SuccessPolicy successPolicy) {
        this.successPolicy = successPolicy;
    }

    /**
     * suspend specifies whether the Job controller should create Pods or not. If a Job is created with suspend set to true, no Pods are created by the Job controller. If a Job is suspended after creation (i.e. the flag goes from false to true), the Job controller will delete all active Pods associated with this Job. Users must design their workload to gracefully handle this. Suspending a Job will reset the StartTime field of the Job, effectively resetting the ActiveDeadlineSeconds timer too. Defaults to false.
     */
    @JsonProperty("suspend")
    public Boolean getSuspend() {
        return suspend;
    }

    /**
     * suspend specifies whether the Job controller should create Pods or not. If a Job is created with suspend set to true, no Pods are created by the Job controller. If a Job is suspended after creation (i.e. the flag goes from false to true), the Job controller will delete all active Pods associated with this Job. Users must design their workload to gracefully handle this. Suspending a Job will reset the StartTime field of the Job, effectively resetting the ActiveDeadlineSeconds timer too. Defaults to false.
     */
    @JsonProperty("suspend")
    public void setSuspend(Boolean suspend) {
        this.suspend = suspend;
    }

    /**
     * JobSpec describes how the job execution will look like.
     */
    @JsonProperty("template")
    public PodTemplateSpec getTemplate() {
        return template;
    }

    /**
     * JobSpec describes how the job execution will look like.
     */
    @JsonProperty("template")
    public void setTemplate(PodTemplateSpec template) {
        this.template = template;
    }

    /**
     * ttlSecondsAfterFinished limits the lifetime of a Job that has finished execution (either Complete or Failed). If this field is set, ttlSecondsAfterFinished after the Job finishes, it is eligible to be automatically deleted. When the Job is being deleted, its lifecycle guarantees (e.g. finalizers) will be honored. If this field is unset, the Job won't be automatically deleted. If this field is set to zero, the Job becomes eligible to be deleted immediately after it finishes.
     */
    @JsonProperty("ttlSecondsAfterFinished")
    public Integer getTtlSecondsAfterFinished() {
        return ttlSecondsAfterFinished;
    }

    /**
     * ttlSecondsAfterFinished limits the lifetime of a Job that has finished execution (either Complete or Failed). If this field is set, ttlSecondsAfterFinished after the Job finishes, it is eligible to be automatically deleted. When the Job is being deleted, its lifecycle guarantees (e.g. finalizers) will be honored. If this field is unset, the Job won't be automatically deleted. If this field is set to zero, the Job becomes eligible to be deleted immediately after it finishes.
     */
    @JsonProperty("ttlSecondsAfterFinished")
    public void setTtlSecondsAfterFinished(Integer ttlSecondsAfterFinished) {
        this.ttlSecondsAfterFinished = ttlSecondsAfterFinished;
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

}
