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
public class ViolationContextFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1beta1.ViolationContextFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String hubCluster;
  private String policyName;
  private String policyNamespace;
  private List<String> policySets = new ArrayList<String>();
  private Map<String,ReplicatedPolicyStatus> policyViolations;
  private List<String> targetClusters = new ArrayList<String>();

  public ViolationContextFluent() {
  }
  
  public ViolationContextFluent(ViolationContext instance) {
    this.copyInstance(instance);
  }

  public A addAllToPolicySets(Collection<String> items) {
    if (this.policySets == null) {
      this.policySets = new ArrayList();
    }
    for (String item : items) {
      this.policySets.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTargetClusters(Collection<String> items) {
    if (this.targetClusters == null) {
      this.targetClusters = new ArrayList();
    }
    for (String item : items) {
      this.targetClusters.add(item);
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
  
  public A addToPolicySets(String... items) {
    if (this.policySets == null) {
      this.policySets = new ArrayList();
    }
    for (String item : items) {
      this.policySets.add(item);
    }
    return (A) this;
  }
  
  public A addToPolicySets(int index,String item) {
    if (this.policySets == null) {
      this.policySets = new ArrayList();
    }
    this.policySets.add(index, item);
    return (A) this;
  }
  
  public A addToPolicyViolations(Map<String,ReplicatedPolicyStatus> map) {
    if (this.policyViolations == null && map != null) {
      this.policyViolations = new LinkedHashMap();
    }
    if (map != null) {
      this.policyViolations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToPolicyViolations(String key,ReplicatedPolicyStatus value) {
    if (this.policyViolations == null && key != null && value != null) {
      this.policyViolations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.policyViolations.put(key, value);
    }
    return (A) this;
  }
  
  public A addToTargetClusters(String... items) {
    if (this.targetClusters == null) {
      this.targetClusters = new ArrayList();
    }
    for (String item : items) {
      this.targetClusters.add(item);
    }
    return (A) this;
  }
  
  public A addToTargetClusters(int index,String item) {
    if (this.targetClusters == null) {
      this.targetClusters = new ArrayList();
    }
    this.targetClusters.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ViolationContext instance) {
    instance = instance != null ? instance : new ViolationContext();
    if (instance != null) {
        this.withHubCluster(instance.getHubCluster());
        this.withPolicyName(instance.getPolicyName());
        this.withPolicyNamespace(instance.getPolicyNamespace());
        this.withPolicySets(instance.getPolicySets());
        this.withPolicyViolations(instance.getPolicyViolations());
        this.withTargetClusters(instance.getTargetClusters());
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
    ViolationContextFluent that = (ViolationContextFluent) o;
    if (!(Objects.equals(hubCluster, that.hubCluster))) {
      return false;
    }
    if (!(Objects.equals(policyName, that.policyName))) {
      return false;
    }
    if (!(Objects.equals(policyNamespace, that.policyNamespace))) {
      return false;
    }
    if (!(Objects.equals(policySets, that.policySets))) {
      return false;
    }
    if (!(Objects.equals(policyViolations, that.policyViolations))) {
      return false;
    }
    if (!(Objects.equals(targetClusters, that.targetClusters))) {
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
  
  public String getFirstPolicySet() {
    return this.policySets.get(0);
  }
  
  public String getFirstTargetCluster() {
    return this.targetClusters.get(0);
  }
  
  public String getHubCluster() {
    return this.hubCluster;
  }
  
  public String getLastPolicySet() {
    return this.policySets.get(policySets.size() - 1);
  }
  
  public String getLastTargetCluster() {
    return this.targetClusters.get(targetClusters.size() - 1);
  }
  
  public String getMatchingPolicySet(Predicate<String> predicate) {
      for (String item : policySets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingTargetCluster(Predicate<String> predicate) {
      for (String item : targetClusters) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPolicyName() {
    return this.policyName;
  }
  
  public String getPolicyNamespace() {
    return this.policyNamespace;
  }
  
  public String getPolicySet(int index) {
    return this.policySets.get(index);
  }
  
  public List<String> getPolicySets() {
    return this.policySets;
  }
  
  public Map<String,ReplicatedPolicyStatus> getPolicyViolations() {
    return this.policyViolations;
  }
  
  public String getTargetCluster(int index) {
    return this.targetClusters.get(index);
  }
  
  public List<String> getTargetClusters() {
    return this.targetClusters;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHubCluster() {
    return this.hubCluster != null;
  }
  
  public boolean hasMatchingPolicySet(Predicate<String> predicate) {
      for (String item : policySets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTargetCluster(Predicate<String> predicate) {
      for (String item : targetClusters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPolicyName() {
    return this.policyName != null;
  }
  
  public boolean hasPolicyNamespace() {
    return this.policyNamespace != null;
  }
  
  public boolean hasPolicySets() {
    return this.policySets != null && !(this.policySets.isEmpty());
  }
  
  public boolean hasPolicyViolations() {
    return this.policyViolations != null;
  }
  
  public boolean hasTargetClusters() {
    return this.targetClusters != null && !(this.targetClusters.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(hubCluster, policyName, policyNamespace, policySets, policyViolations, targetClusters, additionalProperties);
  }
  
  public A removeAllFromPolicySets(Collection<String> items) {
    if (this.policySets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.policySets.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTargetClusters(Collection<String> items) {
    if (this.targetClusters == null) {
      return (A) this;
    }
    for (String item : items) {
      this.targetClusters.remove(item);
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
  
  public A removeFromPolicySets(String... items) {
    if (this.policySets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.policySets.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPolicyViolations(String key) {
    if (this.policyViolations == null) {
      return (A) this;
    }
    if (key != null && this.policyViolations != null) {
      this.policyViolations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromPolicyViolations(Map<String,ReplicatedPolicyStatus> map) {
    if (this.policyViolations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.policyViolations != null) {
          this.policyViolations.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromTargetClusters(String... items) {
    if (this.targetClusters == null) {
      return (A) this;
    }
    for (String item : items) {
      this.targetClusters.remove(item);
    }
    return (A) this;
  }
  
  public A setToPolicySets(int index,String item) {
    if (this.policySets == null) {
      this.policySets = new ArrayList();
    }
    this.policySets.set(index, item);
    return (A) this;
  }
  
  public A setToTargetClusters(int index,String item) {
    if (this.targetClusters == null) {
      this.targetClusters = new ArrayList();
    }
    this.targetClusters.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(hubCluster == null)) {
        sb.append("hubCluster:");
        sb.append(hubCluster);
        sb.append(",");
    }
    if (!(policyName == null)) {
        sb.append("policyName:");
        sb.append(policyName);
        sb.append(",");
    }
    if (!(policyNamespace == null)) {
        sb.append("policyNamespace:");
        sb.append(policyNamespace);
        sb.append(",");
    }
    if (!(policySets == null) && !(policySets.isEmpty())) {
        sb.append("policySets:");
        sb.append(policySets);
        sb.append(",");
    }
    if (!(policyViolations == null) && !(policyViolations.isEmpty())) {
        sb.append("policyViolations:");
        sb.append(policyViolations);
        sb.append(",");
    }
    if (!(targetClusters == null) && !(targetClusters.isEmpty())) {
        sb.append("targetClusters:");
        sb.append(targetClusters);
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
  
  public A withHubCluster(String hubCluster) {
    this.hubCluster = hubCluster;
    return (A) this;
  }
  
  public A withPolicyName(String policyName) {
    this.policyName = policyName;
    return (A) this;
  }
  
  public A withPolicyNamespace(String policyNamespace) {
    this.policyNamespace = policyNamespace;
    return (A) this;
  }
  
  public A withPolicySets(List<String> policySets) {
    if (policySets != null) {
        this.policySets = new ArrayList();
        for (String item : policySets) {
          this.addToPolicySets(item);
        }
    } else {
      this.policySets = null;
    }
    return (A) this;
  }
  
  public A withPolicySets(String... policySets) {
    if (this.policySets != null) {
        this.policySets.clear();
        _visitables.remove("policySets");
    }
    if (policySets != null) {
      for (String item : policySets) {
        this.addToPolicySets(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withPolicyViolations(Map<String,ReplicatedPolicyStatus> policyViolations) {
    if (policyViolations == null) {
      this.policyViolations = null;
    } else {
      this.policyViolations = new LinkedHashMap(policyViolations);
    }
    return (A) this;
  }
  
  public A withTargetClusters(List<String> targetClusters) {
    if (targetClusters != null) {
        this.targetClusters = new ArrayList();
        for (String item : targetClusters) {
          this.addToTargetClusters(item);
        }
    } else {
      this.targetClusters = null;
    }
    return (A) this;
  }
  
  public A withTargetClusters(String... targetClusters) {
    if (this.targetClusters != null) {
        this.targetClusters.clear();
        _visitables.remove("targetClusters");
    }
    if (targetClusters != null) {
      for (String item : targetClusters) {
        this.addToTargetClusters(item);
      }
    }
    return (A) this;
  }
  
}