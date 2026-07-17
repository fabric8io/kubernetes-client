package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class AWSNetworkLoadBalancerParametersFluent<A extends io.fabric8.openshift.api.model.operator.v1.AWSNetworkLoadBalancerParametersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> eipAllocations = new ArrayList<String>();
  private AWSSubnetsBuilder subnets;

  public AWSNetworkLoadBalancerParametersFluent() {
  }
  
  public AWSNetworkLoadBalancerParametersFluent(AWSNetworkLoadBalancerParameters instance) {
    this.copyInstance(instance);
  }

  public A addAllToEipAllocations(Collection<String> items) {
    if (this.eipAllocations == null) {
      this.eipAllocations = new ArrayList();
    }
    for (String item : items) {
      this.eipAllocations.add(item);
    }
    return (A) this;
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
  
  public A addToEipAllocations(String... items) {
    if (this.eipAllocations == null) {
      this.eipAllocations = new ArrayList();
    }
    for (String item : items) {
      this.eipAllocations.add(item);
    }
    return (A) this;
  }
  
  public A addToEipAllocations(int index,String item) {
    if (this.eipAllocations == null) {
      this.eipAllocations = new ArrayList();
    }
    this.eipAllocations.add(index, item);
    return (A) this;
  }
  
  public AWSSubnets buildSubnets() {
    return this.subnets != null ? this.subnets.build() : null;
  }
  
  protected void copyInstance(AWSNetworkLoadBalancerParameters instance) {
    instance = instance != null ? instance : new AWSNetworkLoadBalancerParameters();
    if (instance != null) {
        this.withEipAllocations(instance.getEipAllocations());
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
    AWSNetworkLoadBalancerParametersFluent that = (AWSNetworkLoadBalancerParametersFluent) o;
    if (!(Objects.equals(eipAllocations, that.eipAllocations))) {
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
  
  public String getEipAllocation(int index) {
    return this.eipAllocations.get(index);
  }
  
  public List<String> getEipAllocations() {
    return this.eipAllocations;
  }
  
  public String getFirstEipAllocation() {
    return this.eipAllocations.get(0);
  }
  
  public String getLastEipAllocation() {
    return this.eipAllocations.get(eipAllocations.size() - 1);
  }
  
  public String getMatchingEipAllocation(Predicate<String> predicate) {
      for (String item : eipAllocations) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEipAllocations() {
    return this.eipAllocations != null && !(this.eipAllocations.isEmpty());
  }
  
  public boolean hasMatchingEipAllocation(Predicate<String> predicate) {
      for (String item : eipAllocations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSubnets() {
    return this.subnets != null;
  }
  
  public int hashCode() {
    return Objects.hash(eipAllocations, subnets, additionalProperties);
  }
  
  public A removeAllFromEipAllocations(Collection<String> items) {
    if (this.eipAllocations == null) {
      return (A) this;
    }
    for (String item : items) {
      this.eipAllocations.remove(item);
    }
    return (A) this;
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
  
  public A removeFromEipAllocations(String... items) {
    if (this.eipAllocations == null) {
      return (A) this;
    }
    for (String item : items) {
      this.eipAllocations.remove(item);
    }
    return (A) this;
  }
  
  public A setToEipAllocations(int index,String item) {
    if (this.eipAllocations == null) {
      this.eipAllocations = new ArrayList();
    }
    this.eipAllocations.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(eipAllocations == null) && !(eipAllocations.isEmpty())) {
        sb.append("eipAllocations:");
        sb.append(eipAllocations);
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
  
  public A withEipAllocations(List<String> eipAllocations) {
    if (eipAllocations != null) {
        this.eipAllocations = new ArrayList();
        for (String item : eipAllocations) {
          this.addToEipAllocations(item);
        }
    } else {
      this.eipAllocations = null;
    }
    return (A) this;
  }
  
  public A withEipAllocations(String... eipAllocations) {
    if (this.eipAllocations != null) {
        this.eipAllocations.clear();
        _visitables.remove("eipAllocations");
    }
    if (eipAllocations != null) {
      for (String item : eipAllocations) {
        this.addToEipAllocations(item);
      }
    }
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
      return (N) AWSNetworkLoadBalancerParametersFluent.this.withSubnets(builder.build());
    }
    
    public N endSubnets() {
      return and();
    }
    
  }
}