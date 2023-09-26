
package io.fabric8.kubernetes.api.model.batch.v1;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
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
    "activeDeadlineSeconds",
    "backoffLimit",
    "backoffLimitPerIndex",
    "completionMode",
    "completions",
    "manualSelector",
    "maxFailedIndexes",
    "parallelism",
    "podFailurePolicy",
    "podReplacementPolicy",
    "selector",
    "suspend",
    "template",
    "ttlSecondsAfterFinished"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class JobSpec implements Editable<JobSpecBuilder> , KubernetesResource
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
    private io.fabric8.kubernetes.api.model.LabelSelector selector;
    @JsonProperty("suspend")
    private Boolean suspend;
    @JsonProperty("template")
    private io.fabric8.kubernetes.api.model.PodTemplateSpec template;
    @JsonProperty("ttlSecondsAfterFinished")
    private Integer ttlSecondsAfterFinished;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public JobSpec() {
    }

    public JobSpec(Long activeDeadlineSeconds, Integer backoffLimit, Integer backoffLimitPerIndex, String completionMode, Integer completions, Boolean manualSelector, Integer maxFailedIndexes, Integer parallelism, PodFailurePolicy podFailurePolicy, String podReplacementPolicy, io.fabric8.kubernetes.api.model.LabelSelector selector, Boolean suspend, io.fabric8.kubernetes.api.model.PodTemplateSpec template, Integer ttlSecondsAfterFinished) {
        super();
        this.activeDeadlineSeconds = activeDeadlineSeconds;
        this.backoffLimit = backoffLimit;
        this.backoffLimitPerIndex = backoffLimitPerIndex;
        this.completionMode = completionMode;
        this.completions = completions;
        this.manualSelector = manualSelector;
        this.maxFailedIndexes = maxFailedIndexes;
        this.parallelism = parallelism;
        this.podFailurePolicy = podFailurePolicy;
        this.podReplacementPolicy = podReplacementPolicy;
        this.selector = selector;
        this.suspend = suspend;
        this.template = template;
        this.ttlSecondsAfterFinished = ttlSecondsAfterFinished;
    }

    @JsonProperty("activeDeadlineSeconds")
    public Long getActiveDeadlineSeconds() {
        return activeDeadlineSeconds;
    }

    @JsonProperty("activeDeadlineSeconds")
    public void setActiveDeadlineSeconds(Long activeDeadlineSeconds) {
        this.activeDeadlineSeconds = activeDeadlineSeconds;
    }

    @JsonProperty("backoffLimit")
    public Integer getBackoffLimit() {
        return backoffLimit;
    }

    @JsonProperty("backoffLimit")
    public void setBackoffLimit(Integer backoffLimit) {
        this.backoffLimit = backoffLimit;
    }

    @JsonProperty("backoffLimitPerIndex")
    public Integer getBackoffLimitPerIndex() {
        return backoffLimitPerIndex;
    }

    @JsonProperty("backoffLimitPerIndex")
    public void setBackoffLimitPerIndex(Integer backoffLimitPerIndex) {
        this.backoffLimitPerIndex = backoffLimitPerIndex;
    }

    @JsonProperty("completionMode")
    public String getCompletionMode() {
        return completionMode;
    }

    @JsonProperty("completionMode")
    public void setCompletionMode(String completionMode) {
        this.completionMode = completionMode;
    }

    @JsonProperty("completions")
    public Integer getCompletions() {
        return completions;
    }

    @JsonProperty("completions")
    public void setCompletions(Integer completions) {
        this.completions = completions;
    }

    @JsonProperty("manualSelector")
    public Boolean getManualSelector() {
        return manualSelector;
    }

    @JsonProperty("manualSelector")
    public void setManualSelector(Boolean manualSelector) {
        this.manualSelector = manualSelector;
    }

    @JsonProperty("maxFailedIndexes")
    public Integer getMaxFailedIndexes() {
        return maxFailedIndexes;
    }

    @JsonProperty("maxFailedIndexes")
    public void setMaxFailedIndexes(Integer maxFailedIndexes) {
        this.maxFailedIndexes = maxFailedIndexes;
    }

    @JsonProperty("parallelism")
    public Integer getParallelism() {
        return parallelism;
    }

    @JsonProperty("parallelism")
    public void setParallelism(Integer parallelism) {
        this.parallelism = parallelism;
    }

    @JsonProperty("podFailurePolicy")
    public PodFailurePolicy getPodFailurePolicy() {
        return podFailurePolicy;
    }

    @JsonProperty("podFailurePolicy")
    public void setPodFailurePolicy(PodFailurePolicy podFailurePolicy) {
        this.podFailurePolicy = podFailurePolicy;
    }

    @JsonProperty("podReplacementPolicy")
    public String getPodReplacementPolicy() {
        return podReplacementPolicy;
    }

    @JsonProperty("podReplacementPolicy")
    public void setPodReplacementPolicy(String podReplacementPolicy) {
        this.podReplacementPolicy = podReplacementPolicy;
    }

    @JsonProperty("selector")
    public io.fabric8.kubernetes.api.model.LabelSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(io.fabric8.kubernetes.api.model.LabelSelector selector) {
        this.selector = selector;
    }

    @JsonProperty("suspend")
    public Boolean getSuspend() {
        return suspend;
    }

    @JsonProperty("suspend")
    public void setSuspend(Boolean suspend) {
        this.suspend = suspend;
    }

    @JsonProperty("template")
    public io.fabric8.kubernetes.api.model.PodTemplateSpec getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(io.fabric8.kubernetes.api.model.PodTemplateSpec template) {
        this.template = template;
    }

    @JsonProperty("ttlSecondsAfterFinished")
    public Integer getTtlSecondsAfterFinished() {
        return ttlSecondsAfterFinished;
    }

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
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
