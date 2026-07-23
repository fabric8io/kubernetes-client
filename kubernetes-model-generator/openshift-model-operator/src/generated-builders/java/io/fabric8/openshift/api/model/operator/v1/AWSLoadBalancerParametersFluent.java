package io.fabric8.openshift.api.model.operator.v1;

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
public class AWSLoadBalancerParametersFluent<A extends io.fabric8.openshift.api.model.operator.v1.AWSLoadBalancerParametersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AWSClassicLoadBalancerParametersBuilder classicLoadBalancer;
  private AWSNetworkLoadBalancerParametersBuilder networkLoadBalancer;
  private String type;

  public AWSLoadBalancerParametersFluent() {
  }
  
  public AWSLoadBalancerParametersFluent(AWSLoadBalancerParameters instance) {
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
  
  public AWSClassicLoadBalancerParameters buildClassicLoadBalancer() {
    return this.classicLoadBalancer != null ? this.classicLoadBalancer.build() : null;
  }
  
  public AWSNetworkLoadBalancerParameters buildNetworkLoadBalancer() {
    return this.networkLoadBalancer != null ? this.networkLoadBalancer.build() : null;
  }
  
  protected void copyInstance(AWSLoadBalancerParameters instance) {
    instance = instance != null ? instance : new AWSLoadBalancerParameters();
    if (instance != null) {
        this.withClassicLoadBalancer(instance.getClassicLoadBalancer());
        this.withNetworkLoadBalancer(instance.getNetworkLoadBalancer());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClassicLoadBalancerNested<A> editClassicLoadBalancer() {
    return this.withNewClassicLoadBalancerLike(Optional.ofNullable(this.buildClassicLoadBalancer()).orElse(null));
  }
  
  public NetworkLoadBalancerNested<A> editNetworkLoadBalancer() {
    return this.withNewNetworkLoadBalancerLike(Optional.ofNullable(this.buildNetworkLoadBalancer()).orElse(null));
  }
  
  public ClassicLoadBalancerNested<A> editOrNewClassicLoadBalancer() {
    return this.withNewClassicLoadBalancerLike(Optional.ofNullable(this.buildClassicLoadBalancer()).orElse(new AWSClassicLoadBalancerParametersBuilder().build()));
  }
  
  public ClassicLoadBalancerNested<A> editOrNewClassicLoadBalancerLike(AWSClassicLoadBalancerParameters item) {
    return this.withNewClassicLoadBalancerLike(Optional.ofNullable(this.buildClassicLoadBalancer()).orElse(item));
  }
  
  public NetworkLoadBalancerNested<A> editOrNewNetworkLoadBalancer() {
    return this.withNewNetworkLoadBalancerLike(Optional.ofNullable(this.buildNetworkLoadBalancer()).orElse(new AWSNetworkLoadBalancerParametersBuilder().build()));
  }
  
  public NetworkLoadBalancerNested<A> editOrNewNetworkLoadBalancerLike(AWSNetworkLoadBalancerParameters item) {
    return this.withNewNetworkLoadBalancerLike(Optional.ofNullable(this.buildNetworkLoadBalancer()).orElse(item));
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
    AWSLoadBalancerParametersFluent that = (AWSLoadBalancerParametersFluent) o;
    if (!(Objects.equals(classicLoadBalancer, that.classicLoadBalancer))) {
      return false;
    }
    if (!(Objects.equals(networkLoadBalancer, that.networkLoadBalancer))) {
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
  
  public boolean hasClassicLoadBalancer() {
    return this.classicLoadBalancer != null;
  }
  
  public boolean hasNetworkLoadBalancer() {
    return this.networkLoadBalancer != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(classicLoadBalancer, networkLoadBalancer, type, additionalProperties);
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
    if (!(classicLoadBalancer == null)) {
        sb.append("classicLoadBalancer:");
        sb.append(classicLoadBalancer);
        sb.append(",");
    }
    if (!(networkLoadBalancer == null)) {
        sb.append("networkLoadBalancer:");
        sb.append(networkLoadBalancer);
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
  
  public A withClassicLoadBalancer(AWSClassicLoadBalancerParameters classicLoadBalancer) {
    this._visitables.remove("classicLoadBalancer");
    if (classicLoadBalancer != null) {
        this.classicLoadBalancer = new AWSClassicLoadBalancerParametersBuilder(classicLoadBalancer);
        this._visitables.get("classicLoadBalancer").add(this.classicLoadBalancer);
    } else {
        this.classicLoadBalancer = null;
        this._visitables.get("classicLoadBalancer").remove(this.classicLoadBalancer);
    }
    return (A) this;
  }
  
  public A withNetworkLoadBalancer(AWSNetworkLoadBalancerParameters networkLoadBalancer) {
    this._visitables.remove("networkLoadBalancer");
    if (networkLoadBalancer != null) {
        this.networkLoadBalancer = new AWSNetworkLoadBalancerParametersBuilder(networkLoadBalancer);
        this._visitables.get("networkLoadBalancer").add(this.networkLoadBalancer);
    } else {
        this.networkLoadBalancer = null;
        this._visitables.get("networkLoadBalancer").remove(this.networkLoadBalancer);
    }
    return (A) this;
  }
  
  public ClassicLoadBalancerNested<A> withNewClassicLoadBalancer() {
    return new ClassicLoadBalancerNested(null);
  }
  
  public ClassicLoadBalancerNested<A> withNewClassicLoadBalancerLike(AWSClassicLoadBalancerParameters item) {
    return new ClassicLoadBalancerNested(item);
  }
  
  public NetworkLoadBalancerNested<A> withNewNetworkLoadBalancer() {
    return new NetworkLoadBalancerNested(null);
  }
  
  public NetworkLoadBalancerNested<A> withNewNetworkLoadBalancerLike(AWSNetworkLoadBalancerParameters item) {
    return new NetworkLoadBalancerNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ClassicLoadBalancerNested<N> extends AWSClassicLoadBalancerParametersFluent<ClassicLoadBalancerNested<N>> implements Nested<N>{
  
    AWSClassicLoadBalancerParametersBuilder builder;
  
    ClassicLoadBalancerNested(AWSClassicLoadBalancerParameters item) {
      this.builder = new AWSClassicLoadBalancerParametersBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSLoadBalancerParametersFluent.this.withClassicLoadBalancer(builder.build());
    }
    
    public N endClassicLoadBalancer() {
      return and();
    }
    
  }
  public class NetworkLoadBalancerNested<N> extends AWSNetworkLoadBalancerParametersFluent<NetworkLoadBalancerNested<N>> implements Nested<N>{
  
    AWSNetworkLoadBalancerParametersBuilder builder;
  
    NetworkLoadBalancerNested(AWSNetworkLoadBalancerParameters item) {
      this.builder = new AWSNetworkLoadBalancerParametersBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSLoadBalancerParametersFluent.this.withNetworkLoadBalancer(builder.build());
    }
    
    public N endNetworkLoadBalancer() {
      return and();
    }
    
  }
}