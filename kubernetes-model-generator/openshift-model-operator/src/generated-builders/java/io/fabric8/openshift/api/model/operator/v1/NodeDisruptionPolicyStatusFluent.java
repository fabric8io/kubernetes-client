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
public class NodeDisruptionPolicyStatusFluent<A extends io.fabric8.openshift.api.model.operator.v1.NodeDisruptionPolicyStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NodeDisruptionPolicyClusterStatusBuilder clusterPolicies;

  public NodeDisruptionPolicyStatusFluent() {
  }
  
  public NodeDisruptionPolicyStatusFluent(NodeDisruptionPolicyStatus instance) {
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
  
  public NodeDisruptionPolicyClusterStatus buildClusterPolicies() {
    return this.clusterPolicies != null ? this.clusterPolicies.build() : null;
  }
  
  protected void copyInstance(NodeDisruptionPolicyStatus instance) {
    instance = instance != null ? instance : new NodeDisruptionPolicyStatus();
    if (instance != null) {
        this.withClusterPolicies(instance.getClusterPolicies());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterPoliciesNested<A> editClusterPolicies() {
    return this.withNewClusterPoliciesLike(Optional.ofNullable(this.buildClusterPolicies()).orElse(null));
  }
  
  public ClusterPoliciesNested<A> editOrNewClusterPolicies() {
    return this.withNewClusterPoliciesLike(Optional.ofNullable(this.buildClusterPolicies()).orElse(new NodeDisruptionPolicyClusterStatusBuilder().build()));
  }
  
  public ClusterPoliciesNested<A> editOrNewClusterPoliciesLike(NodeDisruptionPolicyClusterStatus item) {
    return this.withNewClusterPoliciesLike(Optional.ofNullable(this.buildClusterPolicies()).orElse(item));
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
    NodeDisruptionPolicyStatusFluent that = (NodeDisruptionPolicyStatusFluent) o;
    if (!(Objects.equals(clusterPolicies, that.clusterPolicies))) {
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
  
  public boolean hasClusterPolicies() {
    return this.clusterPolicies != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusterPolicies, additionalProperties);
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
    if (!(clusterPolicies == null)) {
        sb.append("clusterPolicies:");
        sb.append(clusterPolicies);
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
  
  public A withClusterPolicies(NodeDisruptionPolicyClusterStatus clusterPolicies) {
    this._visitables.remove("clusterPolicies");
    if (clusterPolicies != null) {
        this.clusterPolicies = new NodeDisruptionPolicyClusterStatusBuilder(clusterPolicies);
        this._visitables.get("clusterPolicies").add(this.clusterPolicies);
    } else {
        this.clusterPolicies = null;
        this._visitables.get("clusterPolicies").remove(this.clusterPolicies);
    }
    return (A) this;
  }
  
  public ClusterPoliciesNested<A> withNewClusterPolicies() {
    return new ClusterPoliciesNested(null);
  }
  
  public ClusterPoliciesNested<A> withNewClusterPoliciesLike(NodeDisruptionPolicyClusterStatus item) {
    return new ClusterPoliciesNested(item);
  }
  public class ClusterPoliciesNested<N> extends NodeDisruptionPolicyClusterStatusFluent<ClusterPoliciesNested<N>> implements Nested<N>{
  
    NodeDisruptionPolicyClusterStatusBuilder builder;
  
    ClusterPoliciesNested(NodeDisruptionPolicyClusterStatus item) {
      this.builder = new NodeDisruptionPolicyClusterStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeDisruptionPolicyStatusFluent.this.withClusterPolicies(builder.build());
    }
    
    public N endClusterPolicies() {
      return and();
    }
    
  }
}