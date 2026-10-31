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
public class PolicySetExclusionFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1beta1.PolicySetExclusionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> clusterNames = new ArrayList<String>();
  private String policyName;
  private String reason;

  public PolicySetExclusionFluent() {
  }
  
  public PolicySetExclusionFluent(PolicySetExclusion instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusterNames(Collection<String> items) {
    if (this.clusterNames == null) {
      this.clusterNames = new ArrayList();
    }
    for (String item : items) {
      this.clusterNames.add(item);
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
  
  public A addToClusterNames(String... items) {
    if (this.clusterNames == null) {
      this.clusterNames = new ArrayList();
    }
    for (String item : items) {
      this.clusterNames.add(item);
    }
    return (A) this;
  }
  
  public A addToClusterNames(int index,String item) {
    if (this.clusterNames == null) {
      this.clusterNames = new ArrayList();
    }
    this.clusterNames.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(PolicySetExclusion instance) {
    instance = instance != null ? instance : new PolicySetExclusion();
    if (instance != null) {
        this.withClusterNames(instance.getClusterNames());
        this.withPolicyName(instance.getPolicyName());
        this.withReason(instance.getReason());
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
    PolicySetExclusionFluent that = (PolicySetExclusionFluent) o;
    if (!(Objects.equals(clusterNames, that.clusterNames))) {
      return false;
    }
    if (!(Objects.equals(policyName, that.policyName))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
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
  
  public String getClusterName(int index) {
    return this.clusterNames.get(index);
  }
  
  public List<String> getClusterNames() {
    return this.clusterNames;
  }
  
  public String getFirstClusterName() {
    return this.clusterNames.get(0);
  }
  
  public String getLastClusterName() {
    return this.clusterNames.get(clusterNames.size() - 1);
  }
  
  public String getMatchingClusterName(Predicate<String> predicate) {
      for (String item : clusterNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPolicyName() {
    return this.policyName;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterNames() {
    return this.clusterNames != null && !(this.clusterNames.isEmpty());
  }
  
  public boolean hasMatchingClusterName(Predicate<String> predicate) {
      for (String item : clusterNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPolicyName() {
    return this.policyName != null;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusterNames, policyName, reason, additionalProperties);
  }
  
  public A removeAllFromClusterNames(Collection<String> items) {
    if (this.clusterNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.clusterNames.remove(item);
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
  
  public A removeFromClusterNames(String... items) {
    if (this.clusterNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.clusterNames.remove(item);
    }
    return (A) this;
  }
  
  public A setToClusterNames(int index,String item) {
    if (this.clusterNames == null) {
      this.clusterNames = new ArrayList();
    }
    this.clusterNames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterNames == null) && !(clusterNames.isEmpty())) {
        sb.append("clusterNames:");
        sb.append(clusterNames);
        sb.append(",");
    }
    if (!(policyName == null)) {
        sb.append("policyName:");
        sb.append(policyName);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
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
  
  public A withClusterNames(List<String> clusterNames) {
    if (clusterNames != null) {
        this.clusterNames = new ArrayList();
        for (String item : clusterNames) {
          this.addToClusterNames(item);
        }
    } else {
      this.clusterNames = null;
    }
    return (A) this;
  }
  
  public A withClusterNames(String... clusterNames) {
    if (this.clusterNames != null) {
        this.clusterNames.clear();
        _visitables.remove("clusterNames");
    }
    if (clusterNames != null) {
      for (String item : clusterNames) {
        this.addToClusterNames(item);
      }
    }
    return (A) this;
  }
  
  public A withPolicyName(String policyName) {
    this.policyName = policyName;
    return (A) this;
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
}