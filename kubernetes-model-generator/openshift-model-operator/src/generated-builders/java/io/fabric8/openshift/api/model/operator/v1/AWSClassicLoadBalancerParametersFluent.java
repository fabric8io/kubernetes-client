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
public class AWSClassicLoadBalancerParametersFluent<A extends io.fabric8.openshift.api.model.operator.v1.AWSClassicLoadBalancerParametersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String connectionIdleTimeout;
  private AWSSubnetsBuilder subnets;

  public AWSClassicLoadBalancerParametersFluent() {
  }
  
  public AWSClassicLoadBalancerParametersFluent(AWSClassicLoadBalancerParameters instance) {
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
  
  public AWSSubnets buildSubnets() {
    return this.subnets != null ? this.subnets.build() : null;
  }
  
  protected void copyInstance(AWSClassicLoadBalancerParameters instance) {
    instance = instance != null ? instance : new AWSClassicLoadBalancerParameters();
    if (instance != null) {
        this.withConnectionIdleTimeout(instance.getConnectionIdleTimeout());
        this.withSubnets(instance.getSubnets());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SubnetsNested<A> editOrNewSubnets() {
    return this.withNewSubnetsLike(Optional.ofNullable(this.buildSubnets()).orElse(new AWSSubnetsBuilder().build()));
  }
  
  public SubnetsNested<A> editOrNewSubnetsLike(AWSSubnets item) {
    return this.withNewSubnetsLike(Optional.ofNullable(this.buildSubnets()).orElse(item));
  }
  
  public SubnetsNested<A> editSubnets() {
    return this.withNewSubnetsLike(Optional.ofNullable(this.buildSubnets()).orElse(null));
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
    AWSClassicLoadBalancerParametersFluent that = (AWSClassicLoadBalancerParametersFluent) o;
    if (!(Objects.equals(connectionIdleTimeout, that.connectionIdleTimeout))) {
      return false;
    }
    if (!(Objects.equals(subnets, that.subnets))) {
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
  
  public String getConnectionIdleTimeout() {
    return this.connectionIdleTimeout;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConnectionIdleTimeout() {
    return this.connectionIdleTimeout != null;
  }
  
  public boolean hasSubnets() {
    return this.subnets != null;
  }
  
  public int hashCode() {
    return Objects.hash(connectionIdleTimeout, subnets, additionalProperties);
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
    if (!(connectionIdleTimeout == null)) {
        sb.append("connectionIdleTimeout:");
        sb.append(connectionIdleTimeout);
        sb.append(",");
    }
    if (!(subnets == null)) {
        sb.append("subnets:");
        sb.append(subnets);
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
  
  public A withConnectionIdleTimeout(String connectionIdleTimeout) {
    this.connectionIdleTimeout = connectionIdleTimeout;
    return (A) this;
  }
  
  public SubnetsNested<A> withNewSubnets() {
    return new SubnetsNested(null);
  }
  
  public SubnetsNested<A> withNewSubnetsLike(AWSSubnets item) {
    return new SubnetsNested(item);
  }
  
  public A withSubnets(AWSSubnets subnets) {
    this._visitables.remove("subnets");
    if (subnets != null) {
        this.subnets = new AWSSubnetsBuilder(subnets);
        this._visitables.get("subnets").add(this.subnets);
    } else {
        this.subnets = null;
        this._visitables.get("subnets").remove(this.subnets);
    }
    return (A) this;
  }
  public class SubnetsNested<N> extends AWSSubnetsFluent<SubnetsNested<N>> implements Nested<N>{
  
    AWSSubnetsBuilder builder;
  
    SubnetsNested(AWSSubnets item) {
      this.builder = new AWSSubnetsBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSClassicLoadBalancerParametersFluent.this.withSubnets(builder.build());
    }
    
    public N endSubnets() {
      return and();
    }
    
  }
}