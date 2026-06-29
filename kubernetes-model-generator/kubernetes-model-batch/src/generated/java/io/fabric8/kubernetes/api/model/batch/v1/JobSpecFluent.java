package io.fabric8.kubernetes.api.model.batch.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.PodTemplateSpecBuilder;
import io.fabric8.kubernetes.api.model.PodTemplateSpecFluent;
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
public class JobSpecFluent<A extends io.fabric8.kubernetes.api.model.batch.v1.JobSpecFluent<A>> extends BaseFluent<A>{

  private Long activeDeadlineSeconds;
  private Map<String,Object> additionalProperties;
  private Integer backoffLimit;
  private Integer backoffLimitPerIndex;
  private String completionMode;
  private Integer completions;
  private String managedBy;
  private Boolean manualSelector;
  private Integer maxFailedIndexes;
  private Integer parallelism;
  private PodFailurePolicyBuilder podFailurePolicy;
  private String podReplacementPolicy;
  private LabelSelectorBuilder selector;
  private SuccessPolicyBuilder successPolicy;
  private Boolean suspend;
  private PodTemplateSpecBuilder template;
  private Integer ttlSecondsAfterFinished;

  public JobSpecFluent() {
  }
  
  public JobSpecFluent(JobSpec instance) {
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
  
  public PodFailurePolicy buildPodFailurePolicy() {
    return this.podFailurePolicy != null ? this.podFailurePolicy.build() : null;
  }
  
  public LabelSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  public SuccessPolicy buildSuccessPolicy() {
    return this.successPolicy != null ? this.successPolicy.build() : null;
  }
  
  public PodTemplateSpec buildTemplate() {
    return this.template != null ? this.template.build() : null;
  }
  
  protected void copyInstance(JobSpec instance) {
    instance = instance != null ? instance : new JobSpec();
    if (instance != null) {
        this.withActiveDeadlineSeconds(instance.getActiveDeadlineSeconds());
        this.withBackoffLimit(instance.getBackoffLimit());
        this.withBackoffLimitPerIndex(instance.getBackoffLimitPerIndex());
        this.withCompletionMode(instance.getCompletionMode());
        this.withCompletions(instance.getCompletions());
        this.withManagedBy(instance.getManagedBy());
        this.withManualSelector(instance.getManualSelector());
        this.withMaxFailedIndexes(instance.getMaxFailedIndexes());
        this.withParallelism(instance.getParallelism());
        this.withPodFailurePolicy(instance.getPodFailurePolicy());
        this.withPodReplacementPolicy(instance.getPodReplacementPolicy());
        this.withSelector(instance.getSelector());
        this.withSuccessPolicy(instance.getSuccessPolicy());
        this.withSuspend(instance.getSuspend());
        this.withTemplate(instance.getTemplate());
        this.withTtlSecondsAfterFinished(instance.getTtlSecondsAfterFinished());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PodFailurePolicyNested<A> editOrNewPodFailurePolicy() {
    return this.withNewPodFailurePolicyLike(Optional.ofNullable(this.buildPodFailurePolicy()).orElse(new PodFailurePolicyBuilder().build()));
  }
  
  public PodFailurePolicyNested<A> editOrNewPodFailurePolicyLike(PodFailurePolicy item) {
    return this.withNewPodFailurePolicyLike(Optional.ofNullable(this.buildPodFailurePolicy()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(LabelSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public SuccessPolicyNested<A> editOrNewSuccessPolicy() {
    return this.withNewSuccessPolicyLike(Optional.ofNullable(this.buildSuccessPolicy()).orElse(new SuccessPolicyBuilder().build()));
  }
  
  public SuccessPolicyNested<A> editOrNewSuccessPolicyLike(SuccessPolicy item) {
    return this.withNewSuccessPolicyLike(Optional.ofNullable(this.buildSuccessPolicy()).orElse(item));
  }
  
  public TemplateNested<A> editOrNewTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(new PodTemplateSpecBuilder().build()));
  }
  
  public TemplateNested<A> editOrNewTemplateLike(PodTemplateSpec item) {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(item));
  }
  
  public PodFailurePolicyNested<A> editPodFailurePolicy() {
    return this.withNewPodFailurePolicyLike(Optional.ofNullable(this.buildPodFailurePolicy()).orElse(null));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
  }
  
  public SuccessPolicyNested<A> editSuccessPolicy() {
    return this.withNewSuccessPolicyLike(Optional.ofNullable(this.buildSuccessPolicy()).orElse(null));
  }
  
  public TemplateNested<A> editTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(null));
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
    JobSpecFluent that = (JobSpecFluent) o;
    if (!(Objects.equals(activeDeadlineSeconds, that.activeDeadlineSeconds))) {
      return false;
    }
    if (!(Objects.equals(backoffLimit, that.backoffLimit))) {
      return false;
    }
    if (!(Objects.equals(backoffLimitPerIndex, that.backoffLimitPerIndex))) {
      return false;
    }
    if (!(Objects.equals(completionMode, that.completionMode))) {
      return false;
    }
    if (!(Objects.equals(completions, that.completions))) {
      return false;
    }
    if (!(Objects.equals(managedBy, that.managedBy))) {
      return false;
    }
    if (!(Objects.equals(manualSelector, that.manualSelector))) {
      return false;
    }
    if (!(Objects.equals(maxFailedIndexes, that.maxFailedIndexes))) {
      return false;
    }
    if (!(Objects.equals(parallelism, that.parallelism))) {
      return false;
    }
    if (!(Objects.equals(podFailurePolicy, that.podFailurePolicy))) {
      return false;
    }
    if (!(Objects.equals(podReplacementPolicy, that.podReplacementPolicy))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(successPolicy, that.successPolicy))) {
      return false;
    }
    if (!(Objects.equals(suspend, that.suspend))) {
      return false;
    }
    if (!(Objects.equals(template, that.template))) {
      return false;
    }
    if (!(Objects.equals(ttlSecondsAfterFinished, that.ttlSecondsAfterFinished))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Long getActiveDeadlineSeconds() {
    return this.activeDeadlineSeconds;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Integer getBackoffLimit() {
    return this.backoffLimit;
  }
  
  public Integer getBackoffLimitPerIndex() {
    return this.backoffLimitPerIndex;
  }
  
  public String getCompletionMode() {
    return this.completionMode;
  }
  
  public Integer getCompletions() {
    return this.completions;
  }
  
  public String getManagedBy() {
    return this.managedBy;
  }
  
  public Boolean getManualSelector() {
    return this.manualSelector;
  }
  
  public Integer getMaxFailedIndexes() {
    return this.maxFailedIndexes;
  }
  
  public Integer getParallelism() {
    return this.parallelism;
  }
  
  public String getPodReplacementPolicy() {
    return this.podReplacementPolicy;
  }
  
  public Boolean getSuspend() {
    return this.suspend;
  }
  
  public Integer getTtlSecondsAfterFinished() {
    return this.ttlSecondsAfterFinished;
  }
  
  public boolean hasActiveDeadlineSeconds() {
    return this.activeDeadlineSeconds != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBackoffLimit() {
    return this.backoffLimit != null;
  }
  
  public boolean hasBackoffLimitPerIndex() {
    return this.backoffLimitPerIndex != null;
  }
  
  public boolean hasCompletionMode() {
    return this.completionMode != null;
  }
  
  public boolean hasCompletions() {
    return this.completions != null;
  }
  
  public boolean hasManagedBy() {
    return this.managedBy != null;
  }
  
  public boolean hasManualSelector() {
    return this.manualSelector != null;
  }
  
  public boolean hasMaxFailedIndexes() {
    return this.maxFailedIndexes != null;
  }
  
  public boolean hasParallelism() {
    return this.parallelism != null;
  }
  
  public boolean hasPodFailurePolicy() {
    return this.podFailurePolicy != null;
  }
  
  public boolean hasPodReplacementPolicy() {
    return this.podReplacementPolicy != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasSuccessPolicy() {
    return this.successPolicy != null;
  }
  
  public boolean hasSuspend() {
    return this.suspend != null;
  }
  
  public boolean hasTemplate() {
    return this.template != null;
  }
  
  public boolean hasTtlSecondsAfterFinished() {
    return this.ttlSecondsAfterFinished != null;
  }
  
  public int hashCode() {
    return Objects.hash(activeDeadlineSeconds, backoffLimit, backoffLimitPerIndex, completionMode, completions, managedBy, manualSelector, maxFailedIndexes, parallelism, podFailurePolicy, podReplacementPolicy, selector, successPolicy, suspend, template, ttlSecondsAfterFinished, additionalProperties);
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
    if (!(activeDeadlineSeconds == null)) {
        sb.append("activeDeadlineSeconds:");
        sb.append(activeDeadlineSeconds);
        sb.append(",");
    }
    if (!(backoffLimit == null)) {
        sb.append("backoffLimit:");
        sb.append(backoffLimit);
        sb.append(",");
    }
    if (!(backoffLimitPerIndex == null)) {
        sb.append("backoffLimitPerIndex:");
        sb.append(backoffLimitPerIndex);
        sb.append(",");
    }
    if (!(completionMode == null)) {
        sb.append("completionMode:");
        sb.append(completionMode);
        sb.append(",");
    }
    if (!(completions == null)) {
        sb.append("completions:");
        sb.append(completions);
        sb.append(",");
    }
    if (!(managedBy == null)) {
        sb.append("managedBy:");
        sb.append(managedBy);
        sb.append(",");
    }
    if (!(manualSelector == null)) {
        sb.append("manualSelector:");
        sb.append(manualSelector);
        sb.append(",");
    }
    if (!(maxFailedIndexes == null)) {
        sb.append("maxFailedIndexes:");
        sb.append(maxFailedIndexes);
        sb.append(",");
    }
    if (!(parallelism == null)) {
        sb.append("parallelism:");
        sb.append(parallelism);
        sb.append(",");
    }
    if (!(podFailurePolicy == null)) {
        sb.append("podFailurePolicy:");
        sb.append(podFailurePolicy);
        sb.append(",");
    }
    if (!(podReplacementPolicy == null)) {
        sb.append("podReplacementPolicy:");
        sb.append(podReplacementPolicy);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(successPolicy == null)) {
        sb.append("successPolicy:");
        sb.append(successPolicy);
        sb.append(",");
    }
    if (!(suspend == null)) {
        sb.append("suspend:");
        sb.append(suspend);
        sb.append(",");
    }
    if (!(template == null)) {
        sb.append("template:");
        sb.append(template);
        sb.append(",");
    }
    if (!(ttlSecondsAfterFinished == null)) {
        sb.append("ttlSecondsAfterFinished:");
        sb.append(ttlSecondsAfterFinished);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActiveDeadlineSeconds(Long activeDeadlineSeconds) {
    this.activeDeadlineSeconds = activeDeadlineSeconds;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withBackoffLimit(Integer backoffLimit) {
    this.backoffLimit = backoffLimit;
    return (A) this;
  }
  
  public A withBackoffLimitPerIndex(Integer backoffLimitPerIndex) {
    this.backoffLimitPerIndex = backoffLimitPerIndex;
    return (A) this;
  }
  
  public A withCompletionMode(String completionMode) {
    this.completionMode = completionMode;
    return (A) this;
  }
  
  public A withCompletions(Integer completions) {
    this.completions = completions;
    return (A) this;
  }
  
  public A withManagedBy(String managedBy) {
    this.managedBy = managedBy;
    return (A) this;
  }
  
  public A withManualSelector() {
    return withManualSelector(true);
  }
  
  public A withManualSelector(Boolean manualSelector) {
    this.manualSelector = manualSelector;
    return (A) this;
  }
  
  public A withMaxFailedIndexes(Integer maxFailedIndexes) {
    this.maxFailedIndexes = maxFailedIndexes;
    return (A) this;
  }
  
  public PodFailurePolicyNested<A> withNewPodFailurePolicy() {
    return new PodFailurePolicyNested(null);
  }
  
  public PodFailurePolicyNested<A> withNewPodFailurePolicyLike(PodFailurePolicy item) {
    return new PodFailurePolicyNested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(LabelSelector item) {
    return new SelectorNested(item);
  }
  
  public SuccessPolicyNested<A> withNewSuccessPolicy() {
    return new SuccessPolicyNested(null);
  }
  
  public SuccessPolicyNested<A> withNewSuccessPolicyLike(SuccessPolicy item) {
    return new SuccessPolicyNested(item);
  }
  
  public TemplateNested<A> withNewTemplate() {
    return new TemplateNested(null);
  }
  
  public TemplateNested<A> withNewTemplateLike(PodTemplateSpec item) {
    return new TemplateNested(item);
  }
  
  public A withParallelism(Integer parallelism) {
    this.parallelism = parallelism;
    return (A) this;
  }
  
  public A withPodFailurePolicy(PodFailurePolicy podFailurePolicy) {
    this._visitables.remove("podFailurePolicy");
    if (podFailurePolicy != null) {
        this.podFailurePolicy = new PodFailurePolicyBuilder(podFailurePolicy);
        this._visitables.get("podFailurePolicy").add(this.podFailurePolicy);
    } else {
        this.podFailurePolicy = null;
        this._visitables.get("podFailurePolicy").remove(this.podFailurePolicy);
    }
    return (A) this;
  }
  
  public A withPodReplacementPolicy(String podReplacementPolicy) {
    this.podReplacementPolicy = podReplacementPolicy;
    return (A) this;
  }
  
  public A withSelector(LabelSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new LabelSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withSuccessPolicy(SuccessPolicy successPolicy) {
    this._visitables.remove("successPolicy");
    if (successPolicy != null) {
        this.successPolicy = new SuccessPolicyBuilder(successPolicy);
        this._visitables.get("successPolicy").add(this.successPolicy);
    } else {
        this.successPolicy = null;
        this._visitables.get("successPolicy").remove(this.successPolicy);
    }
    return (A) this;
  }
  
  public A withSuspend() {
    return withSuspend(true);
  }
  
  public A withSuspend(Boolean suspend) {
    this.suspend = suspend;
    return (A) this;
  }
  
  public A withTemplate(PodTemplateSpec template) {
    this._visitables.remove("template");
    if (template != null) {
        this.template = new PodTemplateSpecBuilder(template);
        this._visitables.get("template").add(this.template);
    } else {
        this.template = null;
        this._visitables.get("template").remove(this.template);
    }
    return (A) this;
  }
  
  public A withTtlSecondsAfterFinished(Integer ttlSecondsAfterFinished) {
    this.ttlSecondsAfterFinished = ttlSecondsAfterFinished;
    return (A) this;
  }
  public class PodFailurePolicyNested<N> extends PodFailurePolicyFluent<PodFailurePolicyNested<N>> implements Nested<N>{
  
    PodFailurePolicyBuilder builder;
  
    PodFailurePolicyNested(PodFailurePolicy item) {
      this.builder = new PodFailurePolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) JobSpecFluent.this.withPodFailurePolicy(builder.build());
    }
    
    public N endPodFailurePolicy() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends LabelSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    SelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) JobSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
  public class SuccessPolicyNested<N> extends SuccessPolicyFluent<SuccessPolicyNested<N>> implements Nested<N>{
  
    SuccessPolicyBuilder builder;
  
    SuccessPolicyNested(SuccessPolicy item) {
      this.builder = new SuccessPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) JobSpecFluent.this.withSuccessPolicy(builder.build());
    }
    
    public N endSuccessPolicy() {
      return and();
    }
    
  }
  public class TemplateNested<N> extends PodTemplateSpecFluent<TemplateNested<N>> implements Nested<N>{
  
    PodTemplateSpecBuilder builder;
  
    TemplateNested(PodTemplateSpec item) {
      this.builder = new PodTemplateSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) JobSpecFluent.this.withTemplate(builder.build());
    }
    
    public N endTemplate() {
      return and();
    }
    
  }
}