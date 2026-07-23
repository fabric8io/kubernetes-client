package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.kubernetes.api.model.IntOrStringFluent;
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
public class RollingUpdateDeploymentFluent<A extends io.fabric8.kubernetes.api.model.apps.RollingUpdateDeploymentFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private IntOrStringBuilder maxSurge;
  private IntOrStringBuilder maxUnavailable;

  public RollingUpdateDeploymentFluent() {
  }
  
  public RollingUpdateDeploymentFluent(RollingUpdateDeployment instance) {
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
  
  public IntOrString buildMaxSurge() {
    return this.maxSurge != null ? this.maxSurge.build() : null;
  }
  
  public IntOrString buildMaxUnavailable() {
    return this.maxUnavailable != null ? this.maxUnavailable.build() : null;
  }
  
  protected void copyInstance(RollingUpdateDeployment instance) {
    instance = instance != null ? instance : new RollingUpdateDeployment();
    if (instance != null) {
        this.withMaxSurge(instance.getMaxSurge());
        this.withMaxUnavailable(instance.getMaxUnavailable());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MaxSurgeNested<A> editMaxSurge() {
    return this.withNewMaxSurgeLike(Optional.ofNullable(this.buildMaxSurge()).orElse(null));
  }
  
  public MaxUnavailableNested<A> editMaxUnavailable() {
    return this.withNewMaxUnavailableLike(Optional.ofNullable(this.buildMaxUnavailable()).orElse(null));
  }
  
  public MaxSurgeNested<A> editOrNewMaxSurge() {
    return this.withNewMaxSurgeLike(Optional.ofNullable(this.buildMaxSurge()).orElse(new IntOrStringBuilder().build()));
  }
  
  public MaxSurgeNested<A> editOrNewMaxSurgeLike(IntOrString item) {
    return this.withNewMaxSurgeLike(Optional.ofNullable(this.buildMaxSurge()).orElse(item));
  }
  
  public MaxUnavailableNested<A> editOrNewMaxUnavailable() {
    return this.withNewMaxUnavailableLike(Optional.ofNullable(this.buildMaxUnavailable()).orElse(new IntOrStringBuilder().build()));
  }
  
  public MaxUnavailableNested<A> editOrNewMaxUnavailableLike(IntOrString item) {
    return this.withNewMaxUnavailableLike(Optional.ofNullable(this.buildMaxUnavailable()).orElse(item));
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
    RollingUpdateDeploymentFluent that = (RollingUpdateDeploymentFluent) o;
    if (!(Objects.equals(maxSurge, that.maxSurge))) {
      return false;
    }
    if (!(Objects.equals(maxUnavailable, that.maxUnavailable))) {
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
  
  public boolean hasMaxSurge() {
    return this.maxSurge != null;
  }
  
  public boolean hasMaxUnavailable() {
    return this.maxUnavailable != null;
  }
  
  public int hashCode() {
    return Objects.hash(maxSurge, maxUnavailable, additionalProperties);
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
    if (!(maxSurge == null)) {
        sb.append("maxSurge:");
        sb.append(maxSurge);
        sb.append(",");
    }
    if (!(maxUnavailable == null)) {
        sb.append("maxUnavailable:");
        sb.append(maxUnavailable);
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
  
  public A withMaxSurge(IntOrString maxSurge) {
    this._visitables.remove("maxSurge");
    if (maxSurge != null) {
        this.maxSurge = new IntOrStringBuilder(maxSurge);
        this._visitables.get("maxSurge").add(this.maxSurge);
    } else {
        this.maxSurge = null;
        this._visitables.get("maxSurge").remove(this.maxSurge);
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
  
  public MaxSurgeNested<A> withNewMaxSurge() {
    return new MaxSurgeNested(null);
  }
  
  public A withNewMaxSurge(Object value) {
    return (A) this.withMaxSurge(new IntOrString(value));
  }
  
  public MaxSurgeNested<A> withNewMaxSurgeLike(IntOrString item) {
    return new MaxSurgeNested(item);
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
  public class MaxSurgeNested<N> extends IntOrStringFluent<MaxSurgeNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    MaxSurgeNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) RollingUpdateDeploymentFluent.this.withMaxSurge(builder.build());
    }
    
    public N endMaxSurge() {
      return and();
    }
    
  }
  public class MaxUnavailableNested<N> extends IntOrStringFluent<MaxUnavailableNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    MaxUnavailableNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) RollingUpdateDeploymentFluent.this.withMaxUnavailable(builder.build());
    }
    
    public N endMaxUnavailable() {
      return and();
    }
    
  }
}