package io.fabric8.openshift.api.model.hive.v1;

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
public class PrivateLinkConfigFluent<A extends io.fabric8.openshift.api.model.hive.v1.PrivateLinkConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private GCPPrivateServiceConnectConfigBuilder gcp;

  public PrivateLinkConfigFluent() {
  }
  
  public PrivateLinkConfigFluent(PrivateLinkConfig instance) {
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
  
  public GCPPrivateServiceConnectConfig buildGcp() {
    return this.gcp != null ? this.gcp.build() : null;
  }
  
  protected void copyInstance(PrivateLinkConfig instance) {
    instance = instance != null ? instance : new PrivateLinkConfig();
    if (instance != null) {
        this.withGcp(instance.getGcp());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GcpNested<A> editGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(null));
  }
  
  public GcpNested<A> editOrNewGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(new GCPPrivateServiceConnectConfigBuilder().build()));
  }
  
  public GcpNested<A> editOrNewGcpLike(GCPPrivateServiceConnectConfig item) {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(item));
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
    PrivateLinkConfigFluent that = (PrivateLinkConfigFluent) o;
    if (!(Objects.equals(gcp, that.gcp))) {
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
  
  public boolean hasGcp() {
    return this.gcp != null;
  }
  
  public int hashCode() {
    return Objects.hash(gcp, additionalProperties);
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
    if (!(gcp == null)) {
        sb.append("gcp:");
        sb.append(gcp);
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
  
  public A withGcp(GCPPrivateServiceConnectConfig gcp) {
    this._visitables.remove("gcp");
    if (gcp != null) {
        this.gcp = new GCPPrivateServiceConnectConfigBuilder(gcp);
        this._visitables.get("gcp").add(this.gcp);
    } else {
        this.gcp = null;
        this._visitables.get("gcp").remove(this.gcp);
    }
    return (A) this;
  }
  
  public GcpNested<A> withNewGcp() {
    return new GcpNested(null);
  }
  
  public GcpNested<A> withNewGcpLike(GCPPrivateServiceConnectConfig item) {
    return new GcpNested(item);
  }
  public class GcpNested<N> extends GCPPrivateServiceConnectConfigFluent<GcpNested<N>> implements Nested<N>{
  
    GCPPrivateServiceConnectConfigBuilder builder;
  
    GcpNested(GCPPrivateServiceConnectConfig item) {
      this.builder = new GCPPrivateServiceConnectConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) PrivateLinkConfigFluent.this.withGcp(builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
}