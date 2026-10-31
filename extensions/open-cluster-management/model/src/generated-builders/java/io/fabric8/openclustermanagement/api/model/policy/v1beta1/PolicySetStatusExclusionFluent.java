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
public class PolicySetStatusExclusionFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1beta1.PolicySetStatusExclusionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> clusters = new ArrayList<String>();
  private String policyName;

  public PolicySetStatusExclusionFluent() {
  }
  
  public PolicySetStatusExclusionFluent(PolicySetStatusExclusion instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusters(Collection<String> items) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    for (String item : items) {
      this.clusters.add(item);
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
  
  public A addToClusters(String... items) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    for (String item : items) {
      this.clusters.add(item);
    }
    return (A) this;
  }
  
  public A addToClusters(int index,String item) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    this.clusters.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(PolicySetStatusExclusion instance) {
    instance = instance != null ? instance : new PolicySetStatusExclusion();
    if (instance != null) {
        this.withClusters(instance.getClusters());
        this.withPolicyName(instance.getPolicyName());
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
    PolicySetStatusExclusionFluent that = (PolicySetStatusExclusionFluent) o;
    if (!(Objects.equals(clusters, that.clusters))) {
      return false;
    }
    if (!(Objects.equals(policyName, that.policyName))) {
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
  
  public String getCluster(int index) {
    return this.clusters.get(index);
  }
  
  public List<String> getClusters() {
    return this.clusters;
  }
  
  public String getFirstCluster() {
    return this.clusters.get(0);
  }
  
  public String getLastCluster() {
    return this.clusters.get(clusters.size() - 1);
  }
  
  public String getMatchingCluster(Predicate<String> predicate) {
      for (String item : clusters) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPolicyName() {
    return this.policyName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusters() {
    return this.clusters != null && !(this.clusters.isEmpty());
  }
  
  public boolean hasMatchingCluster(Predicate<String> predicate) {
      for (String item : clusters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPolicyName() {
    return this.policyName != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusters, policyName, additionalProperties);
  }
  
  public A removeAllFromClusters(Collection<String> items) {
    if (this.clusters == null) {
      return (A) this;
    }
    for (String item : items) {
      this.clusters.remove(item);
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
  
  public A removeFromClusters(String... items) {
    if (this.clusters == null) {
      return (A) this;
    }
    for (String item : items) {
      this.clusters.remove(item);
    }
    return (A) this;
  }
  
  public A setToClusters(int index,String item) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    this.clusters.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusters == null) && !(clusters.isEmpty())) {
        sb.append("clusters:");
        sb.append(clusters);
        sb.append(",");
    }
    if (!(policyName == null)) {
        sb.append("policyName:");
        sb.append(policyName);
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
  
  public A withClusters(List<String> clusters) {
    if (clusters != null) {
        this.clusters = new ArrayList();
        for (String item : clusters) {
          this.addToClusters(item);
        }
    } else {
      this.clusters = null;
    }
    return (A) this;
  }
  
  public A withClusters(String... clusters) {
    if (this.clusters != null) {
        this.clusters.clear();
        _visitables.remove("clusters");
    }
    if (clusters != null) {
      for (String item : clusters) {
        this.addToClusters(item);
      }
    }
    return (A) this;
  }
  
  public A withPolicyName(String policyName) {
    this.policyName = policyName;
    return (A) this;
  }
  
}