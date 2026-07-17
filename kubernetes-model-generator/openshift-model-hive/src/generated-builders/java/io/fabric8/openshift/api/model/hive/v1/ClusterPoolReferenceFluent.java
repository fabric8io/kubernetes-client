package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
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
public class ClusterPoolReferenceFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterPoolReferenceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String claimName;
  private String claimedTimestamp;
  private LocalObjectReferenceBuilder clusterDeploymentCustomization;
  private String namespace;
  private String poolName;

  public ClusterPoolReferenceFluent() {
  }
  
  public ClusterPoolReferenceFluent(ClusterPoolReference instance) {
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
  
  public LocalObjectReference buildClusterDeploymentCustomization() {
    return this.clusterDeploymentCustomization != null ? this.clusterDeploymentCustomization.build() : null;
  }
  
  protected void copyInstance(ClusterPoolReference instance) {
    instance = instance != null ? instance : new ClusterPoolReference();
    if (instance != null) {
        this.withClaimName(instance.getClaimName());
        this.withClaimedTimestamp(instance.getClaimedTimestamp());
        this.withClusterDeploymentCustomization(instance.getClusterDeploymentCustomization());
        this.withNamespace(instance.getNamespace());
        this.withPoolName(instance.getPoolName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterDeploymentCustomizationNested<A> editClusterDeploymentCustomization() {
    return this.withNewClusterDeploymentCustomizationLike(Optional.ofNullable(this.buildClusterDeploymentCustomization()).orElse(null));
  }
  
  public ClusterDeploymentCustomizationNested<A> editOrNewClusterDeploymentCustomization() {
    return this.withNewClusterDeploymentCustomizationLike(Optional.ofNullable(this.buildClusterDeploymentCustomization()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public ClusterDeploymentCustomizationNested<A> editOrNewClusterDeploymentCustomizationLike(LocalObjectReference item) {
    return this.withNewClusterDeploymentCustomizationLike(Optional.ofNullable(this.buildClusterDeploymentCustomization()).orElse(item));
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
    ClusterPoolReferenceFluent that = (ClusterPoolReferenceFluent) o;
    if (!(Objects.equals(claimName, that.claimName))) {
      return false;
    }
    if (!(Objects.equals(claimedTimestamp, that.claimedTimestamp))) {
      return false;
    }
    if (!(Objects.equals(clusterDeploymentCustomization, that.clusterDeploymentCustomization))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(poolName, that.poolName))) {
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
  
  public String getClaimName() {
    return this.claimName;
  }
  
  public String getClaimedTimestamp() {
    return this.claimedTimestamp;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getPoolName() {
    return this.poolName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClaimName() {
    return this.claimName != null;
  }
  
  public boolean hasClaimedTimestamp() {
    return this.claimedTimestamp != null;
  }
  
  public boolean hasClusterDeploymentCustomization() {
    return this.clusterDeploymentCustomization != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasPoolName() {
    return this.poolName != null;
  }
  
  public int hashCode() {
    return Objects.hash(claimName, claimedTimestamp, clusterDeploymentCustomization, namespace, poolName, additionalProperties);
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
    if (!(claimName == null)) {
        sb.append("claimName:");
        sb.append(claimName);
        sb.append(",");
    }
    if (!(claimedTimestamp == null)) {
        sb.append("claimedTimestamp:");
        sb.append(claimedTimestamp);
        sb.append(",");
    }
    if (!(clusterDeploymentCustomization == null)) {
        sb.append("clusterDeploymentCustomization:");
        sb.append(clusterDeploymentCustomization);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(poolName == null)) {
        sb.append("poolName:");
        sb.append(poolName);
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
  
  public A withClaimName(String claimName) {
    this.claimName = claimName;
    return (A) this;
  }
  
  public A withClaimedTimestamp(String claimedTimestamp) {
    this.claimedTimestamp = claimedTimestamp;
    return (A) this;
  }
  
  public A withClusterDeploymentCustomization(LocalObjectReference clusterDeploymentCustomization) {
    this._visitables.remove("clusterDeploymentCustomization");
    if (clusterDeploymentCustomization != null) {
        this.clusterDeploymentCustomization = new LocalObjectReferenceBuilder(clusterDeploymentCustomization);
        this._visitables.get("clusterDeploymentCustomization").add(this.clusterDeploymentCustomization);
    } else {
        this.clusterDeploymentCustomization = null;
        this._visitables.get("clusterDeploymentCustomization").remove(this.clusterDeploymentCustomization);
    }
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public ClusterDeploymentCustomizationNested<A> withNewClusterDeploymentCustomization() {
    return new ClusterDeploymentCustomizationNested(null);
  }
  
  public A withNewClusterDeploymentCustomization(String name) {
    return (A) this.withClusterDeploymentCustomization(new LocalObjectReference(name));
  }
  
  public ClusterDeploymentCustomizationNested<A> withNewClusterDeploymentCustomizationLike(LocalObjectReference item) {
    return new ClusterDeploymentCustomizationNested(item);
  }
  
  public A withPoolName(String poolName) {
    this.poolName = poolName;
    return (A) this;
  }
  public class ClusterDeploymentCustomizationNested<N> extends LocalObjectReferenceFluent<ClusterDeploymentCustomizationNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    ClusterDeploymentCustomizationNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterPoolReferenceFluent.this.withClusterDeploymentCustomization(builder.build());
    }
    
    public N endClusterDeploymentCustomization() {
      return and();
    }
    
  }
}