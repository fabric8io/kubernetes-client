package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

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
public class PodGroupSchedulingPolicyFluent<A extends io.fabric8.kubernetes.api.model.scheduling.v1alpha2.PodGroupSchedulingPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private BasicSchedulingPolicyBuilder basic;
  private GangSchedulingPolicyBuilder gang;

  public PodGroupSchedulingPolicyFluent() {
  }
  
  public PodGroupSchedulingPolicyFluent(PodGroupSchedulingPolicy instance) {
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
  
  public BasicSchedulingPolicy buildBasic() {
    return this.basic != null ? this.basic.build() : null;
  }
  
  public GangSchedulingPolicy buildGang() {
    return this.gang != null ? this.gang.build() : null;
  }
  
  protected void copyInstance(PodGroupSchedulingPolicy instance) {
    instance = instance != null ? instance : new PodGroupSchedulingPolicy();
    if (instance != null) {
        this.withBasic(instance.getBasic());
        this.withGang(instance.getGang());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BasicNested<A> editBasic() {
    return this.withNewBasicLike(Optional.ofNullable(this.buildBasic()).orElse(null));
  }
  
  public GangNested<A> editGang() {
    return this.withNewGangLike(Optional.ofNullable(this.buildGang()).orElse(null));
  }
  
  public BasicNested<A> editOrNewBasic() {
    return this.withNewBasicLike(Optional.ofNullable(this.buildBasic()).orElse(new BasicSchedulingPolicyBuilder().build()));
  }
  
  public BasicNested<A> editOrNewBasicLike(BasicSchedulingPolicy item) {
    return this.withNewBasicLike(Optional.ofNullable(this.buildBasic()).orElse(item));
  }
  
  public GangNested<A> editOrNewGang() {
    return this.withNewGangLike(Optional.ofNullable(this.buildGang()).orElse(new GangSchedulingPolicyBuilder().build()));
  }
  
  public GangNested<A> editOrNewGangLike(GangSchedulingPolicy item) {
    return this.withNewGangLike(Optional.ofNullable(this.buildGang()).orElse(item));
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
    PodGroupSchedulingPolicyFluent that = (PodGroupSchedulingPolicyFluent) o;
    if (!(Objects.equals(basic, that.basic))) {
      return false;
    }
    if (!(Objects.equals(gang, that.gang))) {
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
  
  public boolean hasBasic() {
    return this.basic != null;
  }
  
  public boolean hasGang() {
    return this.gang != null;
  }
  
  public int hashCode() {
    return Objects.hash(basic, gang, additionalProperties);
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
    if (!(basic == null)) {
        sb.append("basic:");
        sb.append(basic);
        sb.append(",");
    }
    if (!(gang == null)) {
        sb.append("gang:");
        sb.append(gang);
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
  
  public A withBasic(BasicSchedulingPolicy basic) {
    this._visitables.remove("basic");
    if (basic != null) {
        this.basic = new BasicSchedulingPolicyBuilder(basic);
        this._visitables.get("basic").add(this.basic);
    } else {
        this.basic = null;
        this._visitables.get("basic").remove(this.basic);
    }
    return (A) this;
  }
  
  public A withGang(GangSchedulingPolicy gang) {
    this._visitables.remove("gang");
    if (gang != null) {
        this.gang = new GangSchedulingPolicyBuilder(gang);
        this._visitables.get("gang").add(this.gang);
    } else {
        this.gang = null;
        this._visitables.get("gang").remove(this.gang);
    }
    return (A) this;
  }
  
  public BasicNested<A> withNewBasic() {
    return new BasicNested(null);
  }
  
  public BasicNested<A> withNewBasicLike(BasicSchedulingPolicy item) {
    return new BasicNested(item);
  }
  
  public GangNested<A> withNewGang() {
    return new GangNested(null);
  }
  
  public A withNewGang(Integer minCount) {
    return (A) this.withGang(new GangSchedulingPolicy(minCount));
  }
  
  public GangNested<A> withNewGangLike(GangSchedulingPolicy item) {
    return new GangNested(item);
  }
  public class BasicNested<N> extends BasicSchedulingPolicyFluent<BasicNested<N>> implements Nested<N>{
  
    BasicSchedulingPolicyBuilder builder;
  
    BasicNested(BasicSchedulingPolicy item) {
      this.builder = new BasicSchedulingPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) PodGroupSchedulingPolicyFluent.this.withBasic(builder.build());
    }
    
    public N endBasic() {
      return and();
    }
    
  }
  public class GangNested<N> extends GangSchedulingPolicyFluent<GangNested<N>> implements Nested<N>{
  
    GangSchedulingPolicyBuilder builder;
  
    GangNested(GangSchedulingPolicy item) {
      this.builder = new GangSchedulingPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) PodGroupSchedulingPolicyFluent.this.withGang(builder.build());
    }
    
    public N endGang() {
      return and();
    }
    
  }
}