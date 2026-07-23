package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class PodHttpChaosBaseRuleFluent<A extends io.fabric8.chaosmesh.v1alpha1.PodHttpChaosBaseRuleFluent<A>> extends BaseFluent<A>{

  private PodHttpChaosActionsBuilder actions;
  private Map<String,Object> additionalProperties;
  private PodHttpChaosSelectorBuilder selector;
  private String target;

  public PodHttpChaosBaseRuleFluent() {
  }
  
  public PodHttpChaosBaseRuleFluent(PodHttpChaosBaseRule instance) {
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
  
  public PodHttpChaosActions buildActions() {
    return this.actions != null ? this.actions.build() : null;
  }
  
  public PodHttpChaosSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(PodHttpChaosBaseRule instance) {
    instance = instance != null ? instance : new PodHttpChaosBaseRule();
    if (instance != null) {
        this.withActions(instance.getActions());
        this.withSelector(instance.getSelector());
        this.withTarget(instance.getTarget());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ActionsNested<A> editActions() {
    return this.withNewActionsLike(Optional.ofNullable(this.buildActions()).orElse(null));
  }
  
  public ActionsNested<A> editOrNewActions() {
    return this.withNewActionsLike(Optional.ofNullable(this.buildActions()).orElse(new PodHttpChaosActionsBuilder().build()));
  }
  
  public ActionsNested<A> editOrNewActionsLike(PodHttpChaosActions item) {
    return this.withNewActionsLike(Optional.ofNullable(this.buildActions()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new PodHttpChaosSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(PodHttpChaosSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
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
    PodHttpChaosBaseRuleFluent that = (PodHttpChaosBaseRuleFluent) o;
    if (!(Objects.equals(actions, that.actions))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(target, that.target))) {
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
  
  public String getTarget() {
    return this.target;
  }
  
  public boolean hasActions() {
    return this.actions != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasTarget() {
    return this.target != null;
  }
  
  public int hashCode() {
    return Objects.hash(actions, selector, target, additionalProperties);
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
    if (!(actions == null)) {
        sb.append("actions:");
        sb.append(actions);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(target == null)) {
        sb.append("target:");
        sb.append(target);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActions(PodHttpChaosActions actions) {
    this._visitables.remove("actions");
    if (actions != null) {
        this.actions = new PodHttpChaosActionsBuilder(actions);
        this._visitables.get("actions").add(this.actions);
    } else {
        this.actions = null;
        this._visitables.get("actions").remove(this.actions);
    }
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
  
  public ActionsNested<A> withNewActions() {
    return new ActionsNested(null);
  }
  
  public ActionsNested<A> withNewActionsLike(PodHttpChaosActions item) {
    return new ActionsNested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(PodHttpChaosSelector item) {
    return new SelectorNested(item);
  }
  
  public A withSelector(PodHttpChaosSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new PodHttpChaosSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withTarget(String target) {
    this.target = target;
    return (A) this;
  }
  public class ActionsNested<N> extends PodHttpChaosActionsFluent<ActionsNested<N>> implements Nested<N>{
  
    PodHttpChaosActionsBuilder builder;
  
    ActionsNested(PodHttpChaosActions item) {
      this.builder = new PodHttpChaosActionsBuilder(this, item);
    }
  
    public N and() {
      return (N) PodHttpChaosBaseRuleFluent.this.withActions(builder.build());
    }
    
    public N endActions() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends PodHttpChaosSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    PodHttpChaosSelectorBuilder builder;
  
    SelectorNested(PodHttpChaosSelector item) {
      this.builder = new PodHttpChaosSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PodHttpChaosBaseRuleFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}