package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Duration;
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
public class RolloutConfigFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.RolloutConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private IntOrStringBuilder maxFailures;
  private Duration minSuccessTime;
  private String progressDeadline;

  public RolloutConfigFluent() {
  }
  
  public RolloutConfigFluent(RolloutConfig instance) {
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
  
  public IntOrString buildMaxFailures() {
    return this.maxFailures != null ? this.maxFailures.build() : null;
  }
  
  protected void copyInstance(RolloutConfig instance) {
    instance = instance != null ? instance : new RolloutConfig();
    if (instance != null) {
        this.withMaxFailures(instance.getMaxFailures());
        this.withMinSuccessTime(instance.getMinSuccessTime());
        this.withProgressDeadline(instance.getProgressDeadline());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MaxFailuresNested<A> editMaxFailures() {
    return this.withNewMaxFailuresLike(Optional.ofNullable(this.buildMaxFailures()).orElse(null));
  }
  
  public MaxFailuresNested<A> editOrNewMaxFailures() {
    return this.withNewMaxFailuresLike(Optional.ofNullable(this.buildMaxFailures()).orElse(new IntOrStringBuilder().build()));
  }
  
  public MaxFailuresNested<A> editOrNewMaxFailuresLike(IntOrString item) {
    return this.withNewMaxFailuresLike(Optional.ofNullable(this.buildMaxFailures()).orElse(item));
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
    RolloutConfigFluent that = (RolloutConfigFluent) o;
    if (!(Objects.equals(maxFailures, that.maxFailures))) {
      return false;
    }
    if (!(Objects.equals(minSuccessTime, that.minSuccessTime))) {
      return false;
    }
    if (!(Objects.equals(progressDeadline, that.progressDeadline))) {
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
  
  public Duration getMinSuccessTime() {
    return this.minSuccessTime;
  }
  
  public String getProgressDeadline() {
    return this.progressDeadline;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMaxFailures() {
    return this.maxFailures != null;
  }
  
  public boolean hasMinSuccessTime() {
    return this.minSuccessTime != null;
  }
  
  public boolean hasProgressDeadline() {
    return this.progressDeadline != null;
  }
  
  public int hashCode() {
    return Objects.hash(maxFailures, minSuccessTime, progressDeadline, additionalProperties);
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
    if (!(maxFailures == null)) {
        sb.append("maxFailures:");
        sb.append(maxFailures);
        sb.append(",");
    }
    if (!(minSuccessTime == null)) {
        sb.append("minSuccessTime:");
        sb.append(minSuccessTime);
        sb.append(",");
    }
    if (!(progressDeadline == null)) {
        sb.append("progressDeadline:");
        sb.append(progressDeadline);
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
  
  public A withMaxFailures(IntOrString maxFailures) {
    this._visitables.remove("maxFailures");
    if (maxFailures != null) {
        this.maxFailures = new IntOrStringBuilder(maxFailures);
        this._visitables.get("maxFailures").add(this.maxFailures);
    } else {
        this.maxFailures = null;
        this._visitables.get("maxFailures").remove(this.maxFailures);
    }
    return (A) this;
  }
  
  public A withMinSuccessTime(Duration minSuccessTime) {
    this.minSuccessTime = minSuccessTime;
    return (A) this;
  }
  
  public MaxFailuresNested<A> withNewMaxFailures() {
    return new MaxFailuresNested(null);
  }
  
  public A withNewMaxFailures(Object value) {
    return (A) this.withMaxFailures(new IntOrString(value));
  }
  
  public MaxFailuresNested<A> withNewMaxFailuresLike(IntOrString item) {
    return new MaxFailuresNested(item);
  }
  
  public A withProgressDeadline(String progressDeadline) {
    this.progressDeadline = progressDeadline;
    return (A) this;
  }
  public class MaxFailuresNested<N> extends IntOrStringFluent<MaxFailuresNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    MaxFailuresNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) RolloutConfigFluent.this.withMaxFailures(builder.build());
    }
    
    public N endMaxFailures() {
      return and();
    }
    
  }
}