package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class SubsetFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.SubsetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> labels;
  private String name;
  private TrafficPolicyBuilder trafficPolicy;

  public SubsetFluent() {
  }
  
  public SubsetFluent(Subset instance) {
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
  
  public A addToLabels(Map<String,String> map) {
    if (this.labels == null && map != null) {
      this.labels = new LinkedHashMap();
    }
    if (map != null) {
      this.labels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabels(String key,String value) {
    if (this.labels == null && key != null && value != null) {
      this.labels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labels.put(key, value);
    }
    return (A) this;
  }
  
  public TrafficPolicy buildTrafficPolicy() {
    return this.trafficPolicy != null ? this.trafficPolicy.build() : null;
  }
  
  protected void copyInstance(Subset instance) {
    instance = instance != null ? instance : new Subset();
    if (instance != null) {
        this.withLabels(instance.getLabels());
        this.withName(instance.getName());
        this.withTrafficPolicy(instance.getTrafficPolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TrafficPolicyNested<A> editOrNewTrafficPolicy() {
    return this.withNewTrafficPolicyLike(Optional.ofNullable(this.buildTrafficPolicy()).orElse(new TrafficPolicyBuilder().build()));
  }
  
  public TrafficPolicyNested<A> editOrNewTrafficPolicyLike(TrafficPolicy item) {
    return this.withNewTrafficPolicyLike(Optional.ofNullable(this.buildTrafficPolicy()).orElse(item));
  }
  
  public TrafficPolicyNested<A> editTrafficPolicy() {
    return this.withNewTrafficPolicyLike(Optional.ofNullable(this.buildTrafficPolicy()).orElse(null));
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
    SubsetFluent that = (SubsetFluent) o;
    if (!(Objects.equals(labels, that.labels))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(trafficPolicy, that.trafficPolicy))) {
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
  
  public Map<String,String> getLabels() {
    return this.labels;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLabels() {
    return this.labels != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasTrafficPolicy() {
    return this.trafficPolicy != null;
  }
  
  public int hashCode() {
    return Objects.hash(labels, name, trafficPolicy, additionalProperties);
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
  
  public A removeFromLabels(String key) {
    if (this.labels == null) {
      return (A) this;
    }
    if (key != null && this.labels != null) {
      this.labels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabels(Map<String,String> map) {
    if (this.labels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labels != null) {
          this.labels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(trafficPolicy == null)) {
        sb.append("trafficPolicy:");
        sb.append(trafficPolicy);
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
  
  public <K,V>A withLabels(Map<String,String> labels) {
    if (labels == null) {
      this.labels = null;
    } else {
      this.labels = new LinkedHashMap(labels);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public TrafficPolicyNested<A> withNewTrafficPolicy() {
    return new TrafficPolicyNested(null);
  }
  
  public TrafficPolicyNested<A> withNewTrafficPolicyLike(TrafficPolicy item) {
    return new TrafficPolicyNested(item);
  }
  
  public A withTrafficPolicy(TrafficPolicy trafficPolicy) {
    this._visitables.remove("trafficPolicy");
    if (trafficPolicy != null) {
        this.trafficPolicy = new TrafficPolicyBuilder(trafficPolicy);
        this._visitables.get("trafficPolicy").add(this.trafficPolicy);
    } else {
        this.trafficPolicy = null;
        this._visitables.get("trafficPolicy").remove(this.trafficPolicy);
    }
    return (A) this;
  }
  public class TrafficPolicyNested<N> extends TrafficPolicyFluent<TrafficPolicyNested<N>> implements Nested<N>{
  
    TrafficPolicyBuilder builder;
  
    TrafficPolicyNested(TrafficPolicy item) {
      this.builder = new TrafficPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) SubsetFluent.this.withTrafficPolicy(builder.build());
    }
    
    public N endTrafficPolicy() {
      return and();
    }
    
  }
}