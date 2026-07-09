package io.fabric8.kubernetes.api.model.extensions;

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
public class DeploymentSpecFluent<A extends io.fabric8.kubernetes.api.model.extensions.DeploymentSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer minReadySeconds;
  private Boolean paused;
  private Integer progressDeadlineSeconds;
  private Integer replicas;
  private Integer revisionHistoryLimit;
  private RollbackConfigBuilder rollbackTo;
  private LabelSelectorBuilder selector;
  private DeploymentStrategyBuilder strategy;
  private PodTemplateSpecBuilder template;

  public DeploymentSpecFluent() {
  }
  
  public DeploymentSpecFluent(DeploymentSpec instance) {
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
  
  public RollbackConfig buildRollbackTo() {
    return this.rollbackTo != null ? this.rollbackTo.build() : null;
  }
  
  public LabelSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  public DeploymentStrategy buildStrategy() {
    return this.strategy != null ? this.strategy.build() : null;
  }
  
  public PodTemplateSpec buildTemplate() {
    return this.template != null ? this.template.build() : null;
  }
  
  protected void copyInstance(DeploymentSpec instance) {
    instance = instance != null ? instance : new DeploymentSpec();
    if (instance != null) {
        this.withMinReadySeconds(instance.getMinReadySeconds());
        this.withPaused(instance.getPaused());
        this.withProgressDeadlineSeconds(instance.getProgressDeadlineSeconds());
        this.withReplicas(instance.getReplicas());
        this.withRevisionHistoryLimit(instance.getRevisionHistoryLimit());
        this.withRollbackTo(instance.getRollbackTo());
        this.withSelector(instance.getSelector());
        this.withStrategy(instance.getStrategy());
        this.withTemplate(instance.getTemplate());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RollbackToNested<A> editOrNewRollbackTo() {
    return this.withNewRollbackToLike(Optional.ofNullable(this.buildRollbackTo()).orElse(new RollbackConfigBuilder().build()));
  }
  
  public RollbackToNested<A> editOrNewRollbackToLike(RollbackConfig item) {
    return this.withNewRollbackToLike(Optional.ofNullable(this.buildRollbackTo()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(LabelSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public StrategyNested<A> editOrNewStrategy() {
    return this.withNewStrategyLike(Optional.ofNullable(this.buildStrategy()).orElse(new DeploymentStrategyBuilder().build()));
  }
  
  public StrategyNested<A> editOrNewStrategyLike(DeploymentStrategy item) {
    return this.withNewStrategyLike(Optional.ofNullable(this.buildStrategy()).orElse(item));
  }
  
  public TemplateNested<A> editOrNewTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(new PodTemplateSpecBuilder().build()));
  }
  
  public TemplateNested<A> editOrNewTemplateLike(PodTemplateSpec item) {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(item));
  }
  
  public RollbackToNested<A> editRollbackTo() {
    return this.withNewRollbackToLike(Optional.ofNullable(this.buildRollbackTo()).orElse(null));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
  }
  
  public StrategyNested<A> editStrategy() {
    return this.withNewStrategyLike(Optional.ofNullable(this.buildStrategy()).orElse(null));
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
    DeploymentSpecFluent that = (DeploymentSpecFluent) o;
    if (!(Objects.equals(minReadySeconds, that.minReadySeconds))) {
      return false;
    }
    if (!(Objects.equals(paused, that.paused))) {
      return false;
    }
    if (!(Objects.equals(progressDeadlineSeconds, that.progressDeadlineSeconds))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(revisionHistoryLimit, that.revisionHistoryLimit))) {
      return false;
    }
    if (!(Objects.equals(rollbackTo, that.rollbackTo))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(strategy, that.strategy))) {
      return false;
    }
    if (!(Objects.equals(template, that.template))) {
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
  
  public Integer getMinReadySeconds() {
    return this.minReadySeconds;
  }
  
  public Boolean getPaused() {
    return this.paused;
  }
  
  public Integer getProgressDeadlineSeconds() {
    return this.progressDeadlineSeconds;
  }
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public Integer getRevisionHistoryLimit() {
    return this.revisionHistoryLimit;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMinReadySeconds() {
    return this.minReadySeconds != null;
  }
  
  public boolean hasPaused() {
    return this.paused != null;
  }
  
  public boolean hasProgressDeadlineSeconds() {
    return this.progressDeadlineSeconds != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasRevisionHistoryLimit() {
    return this.revisionHistoryLimit != null;
  }
  
  public boolean hasRollbackTo() {
    return this.rollbackTo != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasStrategy() {
    return this.strategy != null;
  }
  
  public boolean hasTemplate() {
    return this.template != null;
  }
  
  public int hashCode() {
    return Objects.hash(minReadySeconds, paused, progressDeadlineSeconds, replicas, revisionHistoryLimit, rollbackTo, selector, strategy, template, additionalProperties);
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
    if (!(minReadySeconds == null)) {
        sb.append("minReadySeconds:");
        sb.append(minReadySeconds);
        sb.append(",");
    }
    if (!(paused == null)) {
        sb.append("paused:");
        sb.append(paused);
        sb.append(",");
    }
    if (!(progressDeadlineSeconds == null)) {
        sb.append("progressDeadlineSeconds:");
        sb.append(progressDeadlineSeconds);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(revisionHistoryLimit == null)) {
        sb.append("revisionHistoryLimit:");
        sb.append(revisionHistoryLimit);
        sb.append(",");
    }
    if (!(rollbackTo == null)) {
        sb.append("rollbackTo:");
        sb.append(rollbackTo);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(strategy == null)) {
        sb.append("strategy:");
        sb.append(strategy);
        sb.append(",");
    }
    if (!(template == null)) {
        sb.append("template:");
        sb.append(template);
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
  
  public A withMinReadySeconds(Integer minReadySeconds) {
    this.minReadySeconds = minReadySeconds;
    return (A) this;
  }
  
  public RollbackToNested<A> withNewRollbackTo() {
    return new RollbackToNested(null);
  }
  
  public A withNewRollbackTo(Long revision) {
    return (A) this.withRollbackTo(new RollbackConfig(revision));
  }
  
  public RollbackToNested<A> withNewRollbackToLike(RollbackConfig item) {
    return new RollbackToNested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(LabelSelector item) {
    return new SelectorNested(item);
  }
  
  public StrategyNested<A> withNewStrategy() {
    return new StrategyNested(null);
  }
  
  public StrategyNested<A> withNewStrategyLike(DeploymentStrategy item) {
    return new StrategyNested(item);
  }
  
  public TemplateNested<A> withNewTemplate() {
    return new TemplateNested(null);
  }
  
  public TemplateNested<A> withNewTemplateLike(PodTemplateSpec item) {
    return new TemplateNested(item);
  }
  
  public A withPaused() {
    return withPaused(true);
  }
  
  public A withPaused(Boolean paused) {
    this.paused = paused;
    return (A) this;
  }
  
  public A withProgressDeadlineSeconds(Integer progressDeadlineSeconds) {
    this.progressDeadlineSeconds = progressDeadlineSeconds;
    return (A) this;
  }
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
  public A withRevisionHistoryLimit(Integer revisionHistoryLimit) {
    this.revisionHistoryLimit = revisionHistoryLimit;
    return (A) this;
  }
  
  public A withRollbackTo(RollbackConfig rollbackTo) {
    this._visitables.remove("rollbackTo");
    if (rollbackTo != null) {
        this.rollbackTo = new RollbackConfigBuilder(rollbackTo);
        this._visitables.get("rollbackTo").add(this.rollbackTo);
    } else {
        this.rollbackTo = null;
        this._visitables.get("rollbackTo").remove(this.rollbackTo);
    }
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
  
  public A withStrategy(DeploymentStrategy strategy) {
    this._visitables.remove("strategy");
    if (strategy != null) {
        this.strategy = new DeploymentStrategyBuilder(strategy);
        this._visitables.get("strategy").add(this.strategy);
    } else {
        this.strategy = null;
        this._visitables.get("strategy").remove(this.strategy);
    }
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
  public class RollbackToNested<N> extends RollbackConfigFluent<RollbackToNested<N>> implements Nested<N>{
  
    RollbackConfigBuilder builder;
  
    RollbackToNested(RollbackConfig item) {
      this.builder = new RollbackConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentSpecFluent.this.withRollbackTo(builder.build());
    }
    
    public N endRollbackTo() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends LabelSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    SelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
  public class StrategyNested<N> extends DeploymentStrategyFluent<StrategyNested<N>> implements Nested<N>{
  
    DeploymentStrategyBuilder builder;
  
    StrategyNested(DeploymentStrategy item) {
      this.builder = new DeploymentStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentSpecFluent.this.withStrategy(builder.build());
    }
    
    public N endStrategy() {
      return and();
    }
    
  }
  public class TemplateNested<N> extends PodTemplateSpecFluent<TemplateNested<N>> implements Nested<N>{
  
    PodTemplateSpecBuilder builder;
  
    TemplateNested(PodTemplateSpec item) {
      this.builder = new PodTemplateSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentSpecFluent.this.withTemplate(builder.build());
    }
    
    public N endTemplate() {
      return and();
    }
    
  }
}