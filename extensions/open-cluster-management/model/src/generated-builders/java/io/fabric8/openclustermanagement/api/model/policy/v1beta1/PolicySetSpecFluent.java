package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PolicySetSpecFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1beta1.PolicySetSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String description;
  private List<String> policies = new ArrayList<String>();

  public PolicySetSpecFluent() {
  }
  
  public PolicySetSpecFluent(PolicySetSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToPolicies(Collection<String> items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (String item : items) {
      this.policies.add(item);
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
  
  public A addToPolicies(String... items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (String item : items) {
      this.policies.add(item);
    }
    return (A) this;
  }
  
  public A addToPolicies(int index,String item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    this.policies.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(PolicySetSpec instance) {
    instance = instance != null ? instance : new PolicySetSpec();
    if (instance != null) {
        this.withDescription(instance.getDescription());
        this.withPolicies(instance.getPolicies());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    PolicySetSpecFluent that = (PolicySetSpecFluent) o;
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(policies, that.policies))) {
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
  
  public String getDescription() {
    return this.description;
  }
  
  public String getFirstPolicy() {
    return this.policies.get(0);
  }
  
  public String getLastPolicy() {
    return this.policies.get(policies.size() - 1);
  }
  
  public String getMatchingPolicy(Predicate<String> predicate) {
      for (String item : policies) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<String> getPolicies() {
    return this.policies;
  }
  
  public String getPolicy(int index) {
    return this.policies.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasMatchingPolicy(Predicate<String> predicate) {
      for (String item : policies) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPolicies() {
    return this.policies != null && !(this.policies.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(description, policies, additionalProperties);
  }
  
  public A removeAllFromPolicies(Collection<String> items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (String item : items) {
      this.policies.remove(item);
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
  
  public A removeFromPolicies(String... items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (String item : items) {
      this.policies.remove(item);
    }
    return (A) this;
  }
  
  public A setToPolicies(int index,String item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    this.policies.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(policies == null) && !(policies.isEmpty())) {
        sb.append("policies:");
        sb.append(policies);
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
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withPolicies(List<String> policies) {
    if (policies != null) {
        this.policies = new ArrayList();
        for (String item : policies) {
          this.addToPolicies(item);
        }
    } else {
      this.policies = null;
    }
    return (A) this;
  }
  
  public A withPolicies(String... policies) {
    if (this.policies != null) {
        this.policies.clear();
        _visitables.remove("policies");
    }
    if (policies != null) {
      for (String item : policies) {
        this.addToPolicies(item);
      }
    }
    return (A) this;
  }
  
}