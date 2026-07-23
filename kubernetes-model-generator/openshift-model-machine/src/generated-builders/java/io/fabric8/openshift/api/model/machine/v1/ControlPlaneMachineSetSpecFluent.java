package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import java.lang.Integer;
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
public class ControlPlaneMachineSetSpecFluent<A extends io.fabric8.openshift.api.model.machine.v1.ControlPlaneMachineSetSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String machineNamePrefix;
  private Integer replicas;
  private LabelSelectorBuilder selector;
  private String state;
  private ControlPlaneMachineSetStrategyBuilder strategy;
  private ControlPlaneMachineSetTemplateBuilder template;

  public ControlPlaneMachineSetSpecFluent() {
  }
  
  public ControlPlaneMachineSetSpecFluent(ControlPlaneMachineSetSpec instance) {
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
  
  public LabelSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  public ControlPlaneMachineSetStrategy buildStrategy() {
    return this.strategy != null ? this.strategy.build() : null;
  }
  
  public ControlPlaneMachineSetTemplate buildTemplate() {
    return this.template != null ? this.template.build() : null;
  }
  
  protected void copyInstance(ControlPlaneMachineSetSpec instance) {
    instance = instance != null ? instance : new ControlPlaneMachineSetSpec();
    if (instance != null) {
        this.withMachineNamePrefix(instance.getMachineNamePrefix());
        this.withReplicas(instance.getReplicas());
        this.withSelector(instance.getSelector());
        this.withState(instance.getState());
        this.withStrategy(instance.getStrategy());
        this.withTemplate(instance.getTemplate());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(LabelSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public StrategyNested<A> editOrNewStrategy() {
    return this.withNewStrategyLike(Optional.ofNullable(this.buildStrategy()).orElse(new ControlPlaneMachineSetStrategyBuilder().build()));
  }
  
  public StrategyNested<A> editOrNewStrategyLike(ControlPlaneMachineSetStrategy item) {
    return this.withNewStrategyLike(Optional.ofNullable(this.buildStrategy()).orElse(item));
  }
  
  public TemplateNested<A> editOrNewTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(new ControlPlaneMachineSetTemplateBuilder().build()));
  }
  
  public TemplateNested<A> editOrNewTemplateLike(ControlPlaneMachineSetTemplate item) {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(item));
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
    ControlPlaneMachineSetSpecFluent that = (ControlPlaneMachineSetSpecFluent) o;
    if (!(Objects.equals(machineNamePrefix, that.machineNamePrefix))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
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
  
  public String getMachineNamePrefix() {
    return this.machineNamePrefix;
  }
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public String getState() {
    return this.state;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMachineNamePrefix() {
    return this.machineNamePrefix != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public boolean hasStrategy() {
    return this.strategy != null;
  }
  
  public boolean hasTemplate() {
    return this.template != null;
  }
  
  public int hashCode() {
    return Objects.hash(machineNamePrefix, replicas, selector, state, strategy, template, additionalProperties);
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
    if (!(machineNamePrefix == null)) {
        sb.append("machineNamePrefix:");
        sb.append(machineNamePrefix);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
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
  
  public A withMachineNamePrefix(String machineNamePrefix) {
    this.machineNamePrefix = machineNamePrefix;
    return (A) this;
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
  
  public A withNewStrategy(String type) {
    return (A) this.withStrategy(new ControlPlaneMachineSetStrategy(type));
  }
  
  public StrategyNested<A> withNewStrategyLike(ControlPlaneMachineSetStrategy item) {
    return new StrategyNested(item);
  }
  
  public TemplateNested<A> withNewTemplate() {
    return new TemplateNested(null);
  }
  
  public TemplateNested<A> withNewTemplateLike(ControlPlaneMachineSetTemplate item) {
    return new TemplateNested(item);
  }
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
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
  
  public A withState(String state) {
    this.state = state;
    return (A) this;
  }
  
  public A withStrategy(ControlPlaneMachineSetStrategy strategy) {
    this._visitables.remove("strategy");
    if (strategy != null) {
        this.strategy = new ControlPlaneMachineSetStrategyBuilder(strategy);
        this._visitables.get("strategy").add(this.strategy);
    } else {
        this.strategy = null;
        this._visitables.get("strategy").remove(this.strategy);
    }
    return (A) this;
  }
  
  public A withTemplate(ControlPlaneMachineSetTemplate template) {
    this._visitables.remove("template");
    if (template != null) {
        this.template = new ControlPlaneMachineSetTemplateBuilder(template);
        this._visitables.get("template").add(this.template);
    } else {
        this.template = null;
        this._visitables.get("template").remove(this.template);
    }
    return (A) this;
  }
  public class SelectorNested<N> extends LabelSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    SelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ControlPlaneMachineSetSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
  public class StrategyNested<N> extends ControlPlaneMachineSetStrategyFluent<StrategyNested<N>> implements Nested<N>{
  
    ControlPlaneMachineSetStrategyBuilder builder;
  
    StrategyNested(ControlPlaneMachineSetStrategy item) {
      this.builder = new ControlPlaneMachineSetStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) ControlPlaneMachineSetSpecFluent.this.withStrategy(builder.build());
    }
    
    public N endStrategy() {
      return and();
    }
    
  }
  public class TemplateNested<N> extends ControlPlaneMachineSetTemplateFluent<TemplateNested<N>> implements Nested<N>{
  
    ControlPlaneMachineSetTemplateBuilder builder;
  
    TemplateNested(ControlPlaneMachineSetTemplate item) {
      this.builder = new ControlPlaneMachineSetTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) ControlPlaneMachineSetSpecFluent.this.withTemplate(builder.build());
    }
    
    public N endTemplate() {
      return and();
    }
    
  }
}