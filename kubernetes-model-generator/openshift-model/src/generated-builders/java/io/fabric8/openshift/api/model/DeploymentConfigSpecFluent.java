package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.PodTemplateSpecBuilder;
import io.fabric8.kubernetes.api.model.PodTemplateSpecFluent;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class DeploymentConfigSpecFluent<A extends io.fabric8.openshift.api.model.DeploymentConfigSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer minReadySeconds;
  private Boolean paused;
  private Integer replicas;
  private Integer revisionHistoryLimit;
  private Map<String,String> selector;
  private DeploymentStrategyBuilder strategy;
  private PodTemplateSpecBuilder template;
  private Boolean test;
  private ArrayList<DeploymentTriggerPolicyBuilder> triggers = new ArrayList<DeploymentTriggerPolicyBuilder>();

  public DeploymentConfigSpecFluent() {
  }
  
  public DeploymentConfigSpecFluent(DeploymentConfigSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTriggers(Collection<DeploymentTriggerPolicy> items) {
    if (this.triggers == null) {
      this.triggers = new ArrayList();
    }
    for (DeploymentTriggerPolicy item : items) {
        DeploymentTriggerPolicyBuilder builder = new DeploymentTriggerPolicyBuilder(item);
        _visitables.get("triggers").add(builder);
        this.triggers.add(builder);
    }
    return (A) this;
  }
  
  public TriggersNested<A> addNewTrigger() {
    return new TriggersNested(-1, null);
  }
  
  public TriggersNested<A> addNewTriggerLike(DeploymentTriggerPolicy item) {
    return new TriggersNested(-1, item);
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
  
  public A addToSelector(Map<String,String> map) {
    if (this.selector == null && map != null) {
      this.selector = new LinkedHashMap();
    }
    if (map != null) {
      this.selector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToSelector(String key,String value) {
    if (this.selector == null && key != null && value != null) {
      this.selector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.selector.put(key, value);
    }
    return (A) this;
  }
  
  public A addToTriggers(DeploymentTriggerPolicy... items) {
    if (this.triggers == null) {
      this.triggers = new ArrayList();
    }
    for (DeploymentTriggerPolicy item : items) {
        DeploymentTriggerPolicyBuilder builder = new DeploymentTriggerPolicyBuilder(item);
        _visitables.get("triggers").add(builder);
        this.triggers.add(builder);
    }
    return (A) this;
  }
  
  public A addToTriggers(int index,DeploymentTriggerPolicy item) {
    if (this.triggers == null) {
      this.triggers = new ArrayList();
    }
    DeploymentTriggerPolicyBuilder builder = new DeploymentTriggerPolicyBuilder(item);
    if (index < 0 || index >= triggers.size()) {
        _visitables.get("triggers").add(builder);
        triggers.add(builder);
    } else {
        _visitables.get("triggers").add(builder);
        triggers.add(index, builder);
    }
    return (A) this;
  }
  
  public DeploymentTriggerPolicy buildFirstTrigger() {
    return this.triggers.get(0).build();
  }
  
  public DeploymentTriggerPolicy buildLastTrigger() {
    return this.triggers.get(triggers.size() - 1).build();
  }
  
  public DeploymentTriggerPolicy buildMatchingTrigger(Predicate<DeploymentTriggerPolicyBuilder> predicate) {
      for (DeploymentTriggerPolicyBuilder item : triggers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DeploymentStrategy buildStrategy() {
    return this.strategy != null ? this.strategy.build() : null;
  }
  
  public PodTemplateSpec buildTemplate() {
    return this.template != null ? this.template.build() : null;
  }
  
  public DeploymentTriggerPolicy buildTrigger(int index) {
    return this.triggers.get(index).build();
  }
  
  public List<DeploymentTriggerPolicy> buildTriggers() {
    return this.triggers != null ? build(triggers) : null;
  }
  
  protected void copyInstance(DeploymentConfigSpec instance) {
    instance = instance != null ? instance : new DeploymentConfigSpec();
    if (instance != null) {
        this.withMinReadySeconds(instance.getMinReadySeconds());
        this.withPaused(instance.getPaused());
        this.withReplicas(instance.getReplicas());
        this.withRevisionHistoryLimit(instance.getRevisionHistoryLimit());
        this.withSelector(instance.getSelector());
        this.withStrategy(instance.getStrategy());
        this.withTemplate(instance.getTemplate());
        this.withTest(instance.getTest());
        this.withTriggers(instance.getTriggers());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TriggersNested<A> editFirstTrigger() {
    if (triggers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "triggers"));
    }
    return this.setNewTriggerLike(0, this.buildTrigger(0));
  }
  
  public TriggersNested<A> editLastTrigger() {
    int index = triggers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "triggers"));
    }
    return this.setNewTriggerLike(index, this.buildTrigger(index));
  }
  
  public TriggersNested<A> editMatchingTrigger(Predicate<DeploymentTriggerPolicyBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < triggers.size();i++) {
      if (predicate.test(triggers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "triggers"));
    }
    return this.setNewTriggerLike(index, this.buildTrigger(index));
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
  
  public StrategyNested<A> editStrategy() {
    return this.withNewStrategyLike(Optional.ofNullable(this.buildStrategy()).orElse(null));
  }
  
  public TemplateNested<A> editTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(null));
  }
  
  public TriggersNested<A> editTrigger(int index) {
    if (triggers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "triggers"));
    }
    return this.setNewTriggerLike(index, this.buildTrigger(index));
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
    DeploymentConfigSpecFluent that = (DeploymentConfigSpecFluent) o;
    if (!(Objects.equals(minReadySeconds, that.minReadySeconds))) {
      return false;
    }
    if (!(Objects.equals(paused, that.paused))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(revisionHistoryLimit, that.revisionHistoryLimit))) {
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
    if (!(Objects.equals(test, that.test))) {
      return false;
    }
    if (!(Objects.equals(triggers, that.triggers))) {
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
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public Integer getRevisionHistoryLimit() {
    return this.revisionHistoryLimit;
  }
  
  public Map<String,String> getSelector() {
    return this.selector;
  }
  
  public Boolean getTest() {
    return this.test;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingTrigger(Predicate<DeploymentTriggerPolicyBuilder> predicate) {
      for (DeploymentTriggerPolicyBuilder item : triggers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMinReadySeconds() {
    return this.minReadySeconds != null;
  }
  
  public boolean hasPaused() {
    return this.paused != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasRevisionHistoryLimit() {
    return this.revisionHistoryLimit != null;
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
  
  public boolean hasTest() {
    return this.test != null;
  }
  
  public boolean hasTriggers() {
    return this.triggers != null && !(this.triggers.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(minReadySeconds, paused, replicas, revisionHistoryLimit, selector, strategy, template, test, triggers, additionalProperties);
  }
  
  public A removeAllFromTriggers(Collection<DeploymentTriggerPolicy> items) {
    if (this.triggers == null) {
      return (A) this;
    }
    for (DeploymentTriggerPolicy item : items) {
        DeploymentTriggerPolicyBuilder builder = new DeploymentTriggerPolicyBuilder(item);
        _visitables.get("triggers").remove(builder);
        this.triggers.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromSelector(String key) {
    if (this.selector == null) {
      return (A) this;
    }
    if (key != null && this.selector != null) {
      this.selector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromSelector(Map<String,String> map) {
    if (this.selector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.selector != null) {
          this.selector.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromTriggers(DeploymentTriggerPolicy... items) {
    if (this.triggers == null) {
      return (A) this;
    }
    for (DeploymentTriggerPolicy item : items) {
        DeploymentTriggerPolicyBuilder builder = new DeploymentTriggerPolicyBuilder(item);
        _visitables.get("triggers").remove(builder);
        this.triggers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTriggers(Predicate<DeploymentTriggerPolicyBuilder> predicate) {
    if (triggers == null) {
      return (A) this;
    }
    Iterator<DeploymentTriggerPolicyBuilder> each = triggers.iterator();
    List visitables = _visitables.get("triggers");
    while (each.hasNext()) {
        DeploymentTriggerPolicyBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TriggersNested<A> setNewTriggerLike(int index,DeploymentTriggerPolicy item) {
    return new TriggersNested(index, item);
  }
  
  public A setToTriggers(int index,DeploymentTriggerPolicy item) {
    if (this.triggers == null) {
      this.triggers = new ArrayList();
    }
    DeploymentTriggerPolicyBuilder builder = new DeploymentTriggerPolicyBuilder(item);
    if (index < 0 || index >= triggers.size()) {
        _visitables.get("triggers").add(builder);
        triggers.add(builder);
    } else {
        _visitables.get("triggers").add(builder);
        triggers.set(index, builder);
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
    if (!(selector == null) && !(selector.isEmpty())) {
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
    if (!(test == null)) {
        sb.append("test:");
        sb.append(test);
        sb.append(",");
    }
    if (!(triggers == null) && !(triggers.isEmpty())) {
        sb.append("triggers:");
        sb.append(triggers);
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
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
  public A withRevisionHistoryLimit(Integer revisionHistoryLimit) {
    this.revisionHistoryLimit = revisionHistoryLimit;
    return (A) this;
  }
  
  public <K,V>A withSelector(Map<String,String> selector) {
    if (selector == null) {
      this.selector = null;
    } else {
      this.selector = new LinkedHashMap(selector);
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
  
  public A withTest() {
    return withTest(true);
  }
  
  public A withTest(Boolean test) {
    this.test = test;
    return (A) this;
  }
  
  public A withTriggers(List<DeploymentTriggerPolicy> triggers) {
    if (this.triggers != null) {
      this._visitables.get("triggers").clear();
    }
    if (triggers != null) {
        this.triggers = new ArrayList();
        for (DeploymentTriggerPolicy item : triggers) {
          this.addToTriggers(item);
        }
    } else {
      this.triggers = null;
    }
    return (A) this;
  }
  
  public A withTriggers(DeploymentTriggerPolicy... triggers) {
    if (this.triggers != null) {
        this.triggers.clear();
        _visitables.remove("triggers");
    }
    if (triggers != null) {
      for (DeploymentTriggerPolicy item : triggers) {
        this.addToTriggers(item);
      }
    }
    return (A) this;
  }
  public class StrategyNested<N> extends DeploymentStrategyFluent<StrategyNested<N>> implements Nested<N>{
  
    DeploymentStrategyBuilder builder;
  
    StrategyNested(DeploymentStrategy item) {
      this.builder = new DeploymentStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentConfigSpecFluent.this.withStrategy(builder.build());
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
      return (N) DeploymentConfigSpecFluent.this.withTemplate(builder.build());
    }
    
    public N endTemplate() {
      return and();
    }
    
  }
  public class TriggersNested<N> extends DeploymentTriggerPolicyFluent<TriggersNested<N>> implements Nested<N>{
  
    DeploymentTriggerPolicyBuilder builder;
    int index;
  
    TriggersNested(int index,DeploymentTriggerPolicy item) {
      this.index = index;
      this.builder = new DeploymentTriggerPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentConfigSpecFluent.this.setToTriggers(index, builder.build());
    }
    
    public N endTrigger() {
      return and();
    }
    
  }
}