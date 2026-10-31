package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

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
public class CompositePodGroupSchedulingPolicyFluent<A extends io.fabric8.kubernetes.api.model.scheduling.v1alpha3.CompositePodGroupSchedulingPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CompositeBasicSchedulingPolicyBuilder basic;
  private CompositeGangSchedulingPolicyBuilder gang;

  public CompositePodGroupSchedulingPolicyFluent() {
  }
  
  public CompositePodGroupSchedulingPolicyFluent(CompositePodGroupSchedulingPolicy instance) {
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
  
  public CompositeBasicSchedulingPolicy buildBasic() {
    return this.basic != null ? this.basic.build() : null;
  }
  
  public CompositeGangSchedulingPolicy buildGang() {
    return this.gang != null ? this.gang.build() : null;
  }
  
  protected void copyInstance(CompositePodGroupSchedulingPolicy instance) {
    instance = instance != null ? instance : new CompositePodGroupSchedulingPolicy();
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
    return this.withNewBasicLike(Optional.ofNullable(this.buildBasic()).orElse(new CompositeBasicSchedulingPolicyBuilder().build()));
  }
  
  public BasicNested<A> editOrNewBasicLike(CompositeBasicSchedulingPolicy item) {
    return this.withNewBasicLike(Optional.ofNullable(this.buildBasic()).orElse(item));
  }
  
  public GangNested<A> editOrNewGang() {
    return this.withNewGangLike(Optional.ofNullable(this.buildGang()).orElse(new CompositeGangSchedulingPolicyBuilder().build()));
  }
  
  public GangNested<A> editOrNewGangLike(CompositeGangSchedulingPolicy item) {
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
    CompositePodGroupSchedulingPolicyFluent that = (CompositePodGroupSchedulingPolicyFluent) o;
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
  
  public A withBasic(CompositeBasicSchedulingPolicy basic) {
    this._visitables.remove("basic");
    if (basic != null) {
        this.basic = new CompositeBasicSchedulingPolicyBuilder(basic);
        this._visitables.get("basic").add(this.basic);
    } else {
        this.basic = null;
        this._visitables.get("basic").remove(this.basic);
    }
    return (A) this;
  }
  
  public A withGang(CompositeGangSchedulingPolicy gang) {
    this._visitables.remove("gang");
    if (gang != null) {
        this.gang = new CompositeGangSchedulingPolicyBuilder(gang);
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
  
  public BasicNested<A> withNewBasicLike(CompositeBasicSchedulingPolicy item) {
    return new BasicNested(item);
  }
  
  public GangNested<A> withNewGang() {
    return new GangNested(null);
  }
  
  public A withNewGang(Integer minGroupCount) {
    return (A) this.withGang(new CompositeGangSchedulingPolicy(minGroupCount));
  }
  
  public GangNested<A> withNewGangLike(CompositeGangSchedulingPolicy item) {
    return new GangNested(item);
  }
  public class BasicNested<N> extends CompositeBasicSchedulingPolicyFluent<BasicNested<N>> implements Nested<N>{
  
    CompositeBasicSchedulingPolicyBuilder builder;
  
    BasicNested(CompositeBasicSchedulingPolicy item) {
      this.builder = new CompositeBasicSchedulingPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) CompositePodGroupSchedulingPolicyFluent.this.withBasic(builder.build());
    }
    
    public N endBasic() {
      return and();
    }
    
  }
  public class GangNested<N> extends CompositeGangSchedulingPolicyFluent<GangNested<N>> implements Nested<N>{
  
    CompositeGangSchedulingPolicyBuilder builder;
  
    GangNested(CompositeGangSchedulingPolicy item) {
      this.builder = new CompositeGangSchedulingPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) CompositePodGroupSchedulingPolicyFluent.this.withGang(builder.build());
    }
    
    public N endGang() {
      return and();
    }
    
  }
}