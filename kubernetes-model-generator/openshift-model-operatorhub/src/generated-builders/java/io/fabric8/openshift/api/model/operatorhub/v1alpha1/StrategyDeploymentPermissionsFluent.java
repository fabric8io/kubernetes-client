package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.rbac.PolicyRule;
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
public class StrategyDeploymentPermissionsFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.StrategyDeploymentPermissionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<PolicyRule> rules = new ArrayList<PolicyRule>();
  private String serviceAccountName;

  public StrategyDeploymentPermissionsFluent() {
  }
  
  public StrategyDeploymentPermissionsFluent(StrategyDeploymentPermissions instance) {
    this.copyInstance(instance);
  }

  public A addAllToRules(Collection<PolicyRule> items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (PolicyRule item : items) {
      this.rules.add(item);
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
  
  public A addToRules(PolicyRule... items) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    for (PolicyRule item : items) {
      this.rules.add(item);
    }
    return (A) this;
  }
  
  public A addToRules(int index,PolicyRule item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    this.rules.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(StrategyDeploymentPermissions instance) {
    instance = instance != null ? instance : new StrategyDeploymentPermissions();
    if (instance != null) {
        this.withRules(instance.getRules());
        this.withServiceAccountName(instance.getServiceAccountName());
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
    StrategyDeploymentPermissionsFluent that = (StrategyDeploymentPermissionsFluent) o;
    if (!(Objects.equals(rules, that.rules))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
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
  
  public PolicyRule getFirstRule() {
    return this.rules.get(0);
  }
  
  public PolicyRule getLastRule() {
    return this.rules.get(rules.size() - 1);
  }
  
  public PolicyRule getMatchingRule(Predicate<PolicyRule> predicate) {
      for (PolicyRule item : rules) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public PolicyRule getRule(int index) {
    return this.rules.get(index);
  }
  
  public List<PolicyRule> getRules() {
    return this.rules;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingRule(Predicate<PolicyRule> predicate) {
      for (PolicyRule item : rules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRules() {
    return this.rules != null && !(this.rules.isEmpty());
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public int hashCode() {
    return Objects.hash(rules, serviceAccountName, additionalProperties);
  }
  
  public A removeAllFromRules(Collection<PolicyRule> items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (PolicyRule item : items) {
      this.rules.remove(item);
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
  
  public A removeFromRules(PolicyRule... items) {
    if (this.rules == null) {
      return (A) this;
    }
    for (PolicyRule item : items) {
      this.rules.remove(item);
    }
    return (A) this;
  }
  
  public A setToRules(int index,PolicyRule item) {
    if (this.rules == null) {
      this.rules = new ArrayList();
    }
    this.rules.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(rules == null) && !(rules.isEmpty())) {
        sb.append("rules:");
        sb.append(rules);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
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
  
  public A withRules(List<PolicyRule> rules) {
    if (rules != null) {
        this.rules = new ArrayList();
        for (PolicyRule item : rules) {
          this.addToRules(item);
        }
    } else {
      this.rules = null;
    }
    return (A) this;
  }
  
  public A withRules(PolicyRule... rules) {
    if (this.rules != null) {
        this.rules.clear();
        _visitables.remove("rules");
    }
    if (rules != null) {
      for (PolicyRule item : rules) {
        this.addToRules(item);
      }
    }
    return (A) this;
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  
}