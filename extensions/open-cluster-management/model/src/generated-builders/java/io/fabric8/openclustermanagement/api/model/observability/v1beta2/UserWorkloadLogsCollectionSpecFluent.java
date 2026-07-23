package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class UserWorkloadLogsCollectionSpecFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta2.UserWorkloadLogsCollectionSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClusterLogForwarderSpecBuilder clusterLogForwarder;

  public UserWorkloadLogsCollectionSpecFluent() {
  }
  
  public UserWorkloadLogsCollectionSpecFluent(UserWorkloadLogsCollectionSpec instance) {
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
  
  public ClusterLogForwarderSpec buildClusterLogForwarder() {
    return this.clusterLogForwarder != null ? this.clusterLogForwarder.build() : null;
  }
  
  protected void copyInstance(UserWorkloadLogsCollectionSpec instance) {
    instance = instance != null ? instance : new UserWorkloadLogsCollectionSpec();
    if (instance != null) {
        this.withClusterLogForwarder(instance.getClusterLogForwarder());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterLogForwarderNested<A> editClusterLogForwarder() {
    return this.withNewClusterLogForwarderLike(Optional.ofNullable(this.buildClusterLogForwarder()).orElse(null));
  }
  
  public ClusterLogForwarderNested<A> editOrNewClusterLogForwarder() {
    return this.withNewClusterLogForwarderLike(Optional.ofNullable(this.buildClusterLogForwarder()).orElse(new ClusterLogForwarderSpecBuilder().build()));
  }
  
  public ClusterLogForwarderNested<A> editOrNewClusterLogForwarderLike(ClusterLogForwarderSpec item) {
    return this.withNewClusterLogForwarderLike(Optional.ofNullable(this.buildClusterLogForwarder()).orElse(item));
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
    UserWorkloadLogsCollectionSpecFluent that = (UserWorkloadLogsCollectionSpecFluent) o;
    if (!(Objects.equals(clusterLogForwarder, that.clusterLogForwarder))) {
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
  
  public boolean hasClusterLogForwarder() {
    return this.clusterLogForwarder != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusterLogForwarder, additionalProperties);
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
    if (!(clusterLogForwarder == null)) {
        sb.append("clusterLogForwarder:");
        sb.append(clusterLogForwarder);
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
  
  public A withClusterLogForwarder(ClusterLogForwarderSpec clusterLogForwarder) {
    this._visitables.remove("clusterLogForwarder");
    if (clusterLogForwarder != null) {
        this.clusterLogForwarder = new ClusterLogForwarderSpecBuilder(clusterLogForwarder);
        this._visitables.get("clusterLogForwarder").add(this.clusterLogForwarder);
    } else {
        this.clusterLogForwarder = null;
        this._visitables.get("clusterLogForwarder").remove(this.clusterLogForwarder);
    }
    return (A) this;
  }
  
  public ClusterLogForwarderNested<A> withNewClusterLogForwarder() {
    return new ClusterLogForwarderNested(null);
  }
  
  public A withNewClusterLogForwarder(Boolean enabled) {
    return (A) this.withClusterLogForwarder(new ClusterLogForwarderSpec(enabled));
  }
  
  public ClusterLogForwarderNested<A> withNewClusterLogForwarderLike(ClusterLogForwarderSpec item) {
    return new ClusterLogForwarderNested(item);
  }
  public class ClusterLogForwarderNested<N> extends ClusterLogForwarderSpecFluent<ClusterLogForwarderNested<N>> implements Nested<N>{
  
    ClusterLogForwarderSpecBuilder builder;
  
    ClusterLogForwarderNested(ClusterLogForwarderSpec item) {
      this.builder = new ClusterLogForwarderSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) UserWorkloadLogsCollectionSpecFluent.this.withClusterLogForwarder(builder.build());
    }
    
    public N endClusterLogForwarder() {
      return and();
    }
    
  }
}