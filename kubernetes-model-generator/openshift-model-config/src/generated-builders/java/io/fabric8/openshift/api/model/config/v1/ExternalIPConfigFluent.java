package io.fabric8.openshift.api.model.config.v1;

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
public class ExternalIPConfigFluent<A extends io.fabric8.openshift.api.model.config.v1.ExternalIPConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> autoAssignCIDRs = new ArrayList<String>();
  private ExternalIPPolicyBuilder policy;

  public ExternalIPConfigFluent() {
  }
  
  public ExternalIPConfigFluent(ExternalIPConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToAutoAssignCIDRs(Collection<String> items) {
    if (this.autoAssignCIDRs == null) {
      this.autoAssignCIDRs = new ArrayList();
    }
    for (String item : items) {
      this.autoAssignCIDRs.add(item);
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
  
  public A addToAutoAssignCIDRs(String... items) {
    if (this.autoAssignCIDRs == null) {
      this.autoAssignCIDRs = new ArrayList();
    }
    for (String item : items) {
      this.autoAssignCIDRs.add(item);
    }
    return (A) this;
  }
  
  public A addToAutoAssignCIDRs(int index,String item) {
    if (this.autoAssignCIDRs == null) {
      this.autoAssignCIDRs = new ArrayList();
    }
    this.autoAssignCIDRs.add(index, item);
    return (A) this;
  }
  
  public ExternalIPPolicy buildPolicy() {
    return this.policy != null ? this.policy.build() : null;
  }
  
  protected void copyInstance(ExternalIPConfig instance) {
    instance = instance != null ? instance : new ExternalIPConfig();
    if (instance != null) {
        this.withAutoAssignCIDRs(instance.getAutoAssignCIDRs());
        this.withPolicy(instance.getPolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PolicyNested<A> editOrNewPolicy() {
    return this.withNewPolicyLike(Optional.ofNullable(this.buildPolicy()).orElse(new ExternalIPPolicyBuilder().build()));
  }
  
  public PolicyNested<A> editOrNewPolicyLike(ExternalIPPolicy item) {
    return this.withNewPolicyLike(Optional.ofNullable(this.buildPolicy()).orElse(item));
  }
  
  public PolicyNested<A> editPolicy() {
    return this.withNewPolicyLike(Optional.ofNullable(this.buildPolicy()).orElse(null));
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
    ExternalIPConfigFluent that = (ExternalIPConfigFluent) o;
    if (!(Objects.equals(autoAssignCIDRs, that.autoAssignCIDRs))) {
      return false;
    }
    if (!(Objects.equals(policy, that.policy))) {
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
  
  public String getAutoAssignCIDR(int index) {
    return this.autoAssignCIDRs.get(index);
  }
  
  public List<String> getAutoAssignCIDRs() {
    return this.autoAssignCIDRs;
  }
  
  public String getFirstAutoAssignCIDR() {
    return this.autoAssignCIDRs.get(0);
  }
  
  public String getLastAutoAssignCIDR() {
    return this.autoAssignCIDRs.get(autoAssignCIDRs.size() - 1);
  }
  
  public String getMatchingAutoAssignCIDR(Predicate<String> predicate) {
      for (String item : autoAssignCIDRs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAutoAssignCIDRs() {
    return this.autoAssignCIDRs != null && !(this.autoAssignCIDRs.isEmpty());
  }
  
  public boolean hasMatchingAutoAssignCIDR(Predicate<String> predicate) {
      for (String item : autoAssignCIDRs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPolicy() {
    return this.policy != null;
  }
  
  public int hashCode() {
    return Objects.hash(autoAssignCIDRs, policy, additionalProperties);
  }
  
  public A removeAllFromAutoAssignCIDRs(Collection<String> items) {
    if (this.autoAssignCIDRs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.autoAssignCIDRs.remove(item);
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
  
  public A removeFromAutoAssignCIDRs(String... items) {
    if (this.autoAssignCIDRs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.autoAssignCIDRs.remove(item);
    }
    return (A) this;
  }
  
  public A setToAutoAssignCIDRs(int index,String item) {
    if (this.autoAssignCIDRs == null) {
      this.autoAssignCIDRs = new ArrayList();
    }
    this.autoAssignCIDRs.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(autoAssignCIDRs == null) && !(autoAssignCIDRs.isEmpty())) {
        sb.append("autoAssignCIDRs:");
        sb.append(autoAssignCIDRs);
        sb.append(",");
    }
    if (!(policy == null)) {
        sb.append("policy:");
        sb.append(policy);
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
  
  public A withAutoAssignCIDRs(List<String> autoAssignCIDRs) {
    if (autoAssignCIDRs != null) {
        this.autoAssignCIDRs = new ArrayList();
        for (String item : autoAssignCIDRs) {
          this.addToAutoAssignCIDRs(item);
        }
    } else {
      this.autoAssignCIDRs = null;
    }
    return (A) this;
  }
  
  public A withAutoAssignCIDRs(String... autoAssignCIDRs) {
    if (this.autoAssignCIDRs != null) {
        this.autoAssignCIDRs.clear();
        _visitables.remove("autoAssignCIDRs");
    }
    if (autoAssignCIDRs != null) {
      for (String item : autoAssignCIDRs) {
        this.addToAutoAssignCIDRs(item);
      }
    }
    return (A) this;
  }
  
  public PolicyNested<A> withNewPolicy() {
    return new PolicyNested(null);
  }
  
  public PolicyNested<A> withNewPolicyLike(ExternalIPPolicy item) {
    return new PolicyNested(item);
  }
  
  public A withPolicy(ExternalIPPolicy policy) {
    this._visitables.remove("policy");
    if (policy != null) {
        this.policy = new ExternalIPPolicyBuilder(policy);
        this._visitables.get("policy").add(this.policy);
    } else {
        this.policy = null;
        this._visitables.get("policy").remove(this.policy);
    }
    return (A) this;
  }
  public class PolicyNested<N> extends ExternalIPPolicyFluent<PolicyNested<N>> implements Nested<N>{
  
    ExternalIPPolicyBuilder builder;
  
    PolicyNested(ExternalIPPolicy item) {
      this.builder = new ExternalIPPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) ExternalIPConfigFluent.this.withPolicy(builder.build());
    }
    
    public N endPolicy() {
      return and();
    }
    
  }
}