package io.fabric8.kubernetes.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.kubernetes.api.model.IntOrStringFluent;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class PodDisruptionBudgetSpecFluent<A extends io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private IntOrStringBuilder maxUnavailable;
  private IntOrStringBuilder minAvailable;
  private LabelSelectorBuilder selector;

  public PodDisruptionBudgetSpecFluent() {
  }
  
  public PodDisruptionBudgetSpecFluent(PodDisruptionBudgetSpec instance) {
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
  
  public IntOrString buildMaxUnavailable() {
    return this.maxUnavailable != null ? this.maxUnavailable.build() : null;
  }
  
  public IntOrString buildMinAvailable() {
    return this.minAvailable != null ? this.minAvailable.build() : null;
  }
  
  public LabelSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(PodDisruptionBudgetSpec instance) {
    instance = instance != null ? instance : new PodDisruptionBudgetSpec();
    if (instance != null) {
        this.withMaxUnavailable(instance.getMaxUnavailable());
        this.withMinAvailable(instance.getMinAvailable());
        this.withSelector(instance.getSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MaxUnavailableNested<A> editMaxUnavailable() {
    return this.withNewMaxUnavailableLike(Optional.ofNullable(this.buildMaxUnavailable()).orElse(null));
  }
  
  public MinAvailableNested<A> editMinAvailable() {
    return this.withNewMinAvailableLike(Optional.ofNullable(this.buildMinAvailable()).orElse(null));
  }
  
  public MaxUnavailableNested<A> editOrNewMaxUnavailable() {
    return this.withNewMaxUnavailableLike(Optional.ofNullable(this.buildMaxUnavailable()).orElse(new IntOrStringBuilder().build()));
  }
  
  public MaxUnavailableNested<A> editOrNewMaxUnavailableLike(IntOrString item) {
    return this.withNewMaxUnavailableLike(Optional.ofNullable(this.buildMaxUnavailable()).orElse(item));
  }
  
  public MinAvailableNested<A> editOrNewMinAvailable() {
    return this.withNewMinAvailableLike(Optional.ofNullable(this.buildMinAvailable()).orElse(new IntOrStringBuilder().build()));
  }
  
  public MinAvailableNested<A> editOrNewMinAvailableLike(IntOrString item) {
    return this.withNewMinAvailableLike(Optional.ofNullable(this.buildMinAvailable()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(LabelSelector item) {
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
    PodDisruptionBudgetSpecFluent that = (PodDisruptionBudgetSpecFluent) o;
    if (!(Objects.equals(maxUnavailable, that.maxUnavailable))) {
      return false;
    }
    if (!(Objects.equals(minAvailable, that.minAvailable))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMaxUnavailable() {
    return this.maxUnavailable != null;
  }
  
  public boolean hasMinAvailable() {
    return this.minAvailable != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public int hashCode() {
    return Objects.hash(maxUnavailable, minAvailable, selector, additionalProperties);
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
    if (!(maxUnavailable == null)) {
        sb.append("maxUnavailable:");
        sb.append(maxUnavailable);
        sb.append(",");
    }
    if (!(minAvailable == null)) {
        sb.append("minAvailable:");
        sb.append(minAvailable);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
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
  
  public A withMaxUnavailable(IntOrString maxUnavailable) {
    this._visitables.remove("maxUnavailable");
    if (maxUnavailable != null) {
        this.maxUnavailable = new IntOrStringBuilder(maxUnavailable);
        this._visitables.get("maxUnavailable").add(this.maxUnavailable);
    } else {
        this.maxUnavailable = null;
        this._visitables.get("maxUnavailable").remove(this.maxUnavailable);
    }
    return (A) this;
  }
  
  public A withMinAvailable(IntOrString minAvailable) {
    this._visitables.remove("minAvailable");
    if (minAvailable != null) {
        this.minAvailable = new IntOrStringBuilder(minAvailable);
        this._visitables.get("minAvailable").add(this.minAvailable);
    } else {
        this.minAvailable = null;
        this._visitables.get("minAvailable").remove(this.minAvailable);
    }
    return (A) this;
  }
  
  public MaxUnavailableNested<A> withNewMaxUnavailable() {
    return new MaxUnavailableNested(null);
  }
  
  public A withNewMaxUnavailable(Object value) {
    return (A) this.withMaxUnavailable(new IntOrString(value));
  }
  
  public MaxUnavailableNested<A> withNewMaxUnavailableLike(IntOrString item) {
    return new MaxUnavailableNested(item);
  }
  
  public MinAvailableNested<A> withNewMinAvailable() {
    return new MinAvailableNested(null);
  }
  
  public A withNewMinAvailable(Object value) {
    return (A) this.withMinAvailable(new IntOrString(value));
  }
  
  public MinAvailableNested<A> withNewMinAvailableLike(IntOrString item) {
    return new MinAvailableNested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(LabelSelector item) {
    return new SelectorNested(item);
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
  public class MaxUnavailableNested<N> extends IntOrStringFluent<MaxUnavailableNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    MaxUnavailableNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) PodDisruptionBudgetSpecFluent.this.withMaxUnavailable(builder.build());
    }
    
    public N endMaxUnavailable() {
      return and();
    }
    
  }
  public class MinAvailableNested<N> extends IntOrStringFluent<MinAvailableNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    MinAvailableNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) PodDisruptionBudgetSpecFluent.this.withMinAvailable(builder.build());
    }
    
    public N endMinAvailable() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends LabelSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    SelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PodDisruptionBudgetSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}