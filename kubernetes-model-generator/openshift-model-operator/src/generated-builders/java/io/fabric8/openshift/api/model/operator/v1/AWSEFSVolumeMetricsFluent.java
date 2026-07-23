package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class AWSEFSVolumeMetricsFluent<A extends io.fabric8.openshift.api.model.operator.v1.AWSEFSVolumeMetricsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AWSEFSVolumeMetricsRecursiveWalkConfigBuilder recursiveWalk;
  private String state;

  public AWSEFSVolumeMetricsFluent() {
  }
  
  public AWSEFSVolumeMetricsFluent(AWSEFSVolumeMetrics instance) {
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
  
  public AWSEFSVolumeMetricsRecursiveWalkConfig buildRecursiveWalk() {
    return this.recursiveWalk != null ? this.recursiveWalk.build() : null;
  }
  
  protected void copyInstance(AWSEFSVolumeMetrics instance) {
    instance = instance != null ? instance : new AWSEFSVolumeMetrics();
    if (instance != null) {
        this.withRecursiveWalk(instance.getRecursiveWalk());
        this.withState(instance.getState());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RecursiveWalkNested<A> editOrNewRecursiveWalk() {
    return this.withNewRecursiveWalkLike(Optional.ofNullable(this.buildRecursiveWalk()).orElse(new AWSEFSVolumeMetricsRecursiveWalkConfigBuilder().build()));
  }
  
  public RecursiveWalkNested<A> editOrNewRecursiveWalkLike(AWSEFSVolumeMetricsRecursiveWalkConfig item) {
    return this.withNewRecursiveWalkLike(Optional.ofNullable(this.buildRecursiveWalk()).orElse(item));
  }
  
  public RecursiveWalkNested<A> editRecursiveWalk() {
    return this.withNewRecursiveWalkLike(Optional.ofNullable(this.buildRecursiveWalk()).orElse(null));
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
    AWSEFSVolumeMetricsFluent that = (AWSEFSVolumeMetricsFluent) o;
    if (!(Objects.equals(recursiveWalk, that.recursiveWalk))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
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
  
  public String getState() {
    return this.state;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasRecursiveWalk() {
    return this.recursiveWalk != null;
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public int hashCode() {
    return Objects.hash(recursiveWalk, state, additionalProperties);
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
    if (!(recursiveWalk == null)) {
        sb.append("recursiveWalk:");
        sb.append(recursiveWalk);
        sb.append(",");
    }
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
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
  
  public RecursiveWalkNested<A> withNewRecursiveWalk() {
    return new RecursiveWalkNested(null);
  }
  
  public A withNewRecursiveWalk(Integer fsRateLimit,Integer refreshPeriodMinutes) {
    return (A) this.withRecursiveWalk(new AWSEFSVolumeMetricsRecursiveWalkConfig(fsRateLimit, refreshPeriodMinutes));
  }
  
  public RecursiveWalkNested<A> withNewRecursiveWalkLike(AWSEFSVolumeMetricsRecursiveWalkConfig item) {
    return new RecursiveWalkNested(item);
  }
  
  public A withRecursiveWalk(AWSEFSVolumeMetricsRecursiveWalkConfig recursiveWalk) {
    this._visitables.remove("recursiveWalk");
    if (recursiveWalk != null) {
        this.recursiveWalk = new AWSEFSVolumeMetricsRecursiveWalkConfigBuilder(recursiveWalk);
        this._visitables.get("recursiveWalk").add(this.recursiveWalk);
    } else {
        this.recursiveWalk = null;
        this._visitables.get("recursiveWalk").remove(this.recursiveWalk);
    }
    return (A) this;
  }
  
  public A withState(String state) {
    this.state = state;
    return (A) this;
  }
  public class RecursiveWalkNested<N> extends AWSEFSVolumeMetricsRecursiveWalkConfigFluent<RecursiveWalkNested<N>> implements Nested<N>{
  
    AWSEFSVolumeMetricsRecursiveWalkConfigBuilder builder;
  
    RecursiveWalkNested(AWSEFSVolumeMetricsRecursiveWalkConfig item) {
      this.builder = new AWSEFSVolumeMetricsRecursiveWalkConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSEFSVolumeMetricsFluent.this.withRecursiveWalk(builder.build());
    }
    
    public N endRecursiveWalk() {
      return and();
    }
    
  }
}