package io.fabric8.kubernetes.api.model.flowcontrol.v1beta3;

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
public class PriorityLevelConfigurationSpecFluent<A extends io.fabric8.kubernetes.api.model.flowcontrol.v1beta3.PriorityLevelConfigurationSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LimitedPriorityLevelConfigurationBuilder limited;
  private String type;

  public PriorityLevelConfigurationSpecFluent() {
  }
  
  public PriorityLevelConfigurationSpecFluent(PriorityLevelConfigurationSpec instance) {
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
  
  public LimitedPriorityLevelConfiguration buildLimited() {
    return this.limited != null ? this.limited.build() : null;
  }
  
  protected void copyInstance(PriorityLevelConfigurationSpec instance) {
    instance = instance != null ? instance : new PriorityLevelConfigurationSpec();
    if (instance != null) {
        this.withLimited(instance.getLimited());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LimitedNested<A> editLimited() {
    return this.withNewLimitedLike(Optional.ofNullable(this.buildLimited()).orElse(null));
  }
  
  public LimitedNested<A> editOrNewLimited() {
    return this.withNewLimitedLike(Optional.ofNullable(this.buildLimited()).orElse(new LimitedPriorityLevelConfigurationBuilder().build()));
  }
  
  public LimitedNested<A> editOrNewLimitedLike(LimitedPriorityLevelConfiguration item) {
    return this.withNewLimitedLike(Optional.ofNullable(this.buildLimited()).orElse(item));
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
    PriorityLevelConfigurationSpecFluent that = (PriorityLevelConfigurationSpecFluent) o;
    if (!(Objects.equals(limited, that.limited))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLimited() {
    return this.limited != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(limited, type, additionalProperties);
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
    if (!(limited == null)) {
        sb.append("limited:");
        sb.append(limited);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withLimited(LimitedPriorityLevelConfiguration limited) {
    this._visitables.remove("limited");
    if (limited != null) {
        this.limited = new LimitedPriorityLevelConfigurationBuilder(limited);
        this._visitables.get("limited").add(this.limited);
    } else {
        this.limited = null;
        this._visitables.get("limited").remove(this.limited);
    }
    return (A) this;
  }
  
  public LimitedNested<A> withNewLimited() {
    return new LimitedNested(null);
  }
  
  public LimitedNested<A> withNewLimitedLike(LimitedPriorityLevelConfiguration item) {
    return new LimitedNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class LimitedNested<N> extends LimitedPriorityLevelConfigurationFluent<LimitedNested<N>> implements Nested<N>{
  
    LimitedPriorityLevelConfigurationBuilder builder;
  
    LimitedNested(LimitedPriorityLevelConfiguration item) {
      this.builder = new LimitedPriorityLevelConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) PriorityLevelConfigurationSpecFluent.this.withLimited(builder.build());
    }
    
    public N endLimited() {
      return and();
    }
    
  }
}