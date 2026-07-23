package io.fabric8.openshift.api.model.hive.gcp.v1;

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
public class PlatformStatusFluent<A extends io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PrivateServiceConnectStatusBuilder privateServiceConnect;

  public PlatformStatusFluent() {
  }
  
  public PlatformStatusFluent(PlatformStatus instance) {
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
  
  public PrivateServiceConnectStatus buildPrivateServiceConnect() {
    return this.privateServiceConnect != null ? this.privateServiceConnect.build() : null;
  }
  
  protected void copyInstance(PlatformStatus instance) {
    instance = instance != null ? instance : new PlatformStatus();
    if (instance != null) {
        this.withPrivateServiceConnect(instance.getPrivateServiceConnect());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PrivateServiceConnectNested<A> editOrNewPrivateServiceConnect() {
    return this.withNewPrivateServiceConnectLike(Optional.ofNullable(this.buildPrivateServiceConnect()).orElse(new PrivateServiceConnectStatusBuilder().build()));
  }
  
  public PrivateServiceConnectNested<A> editOrNewPrivateServiceConnectLike(PrivateServiceConnectStatus item) {
    return this.withNewPrivateServiceConnectLike(Optional.ofNullable(this.buildPrivateServiceConnect()).orElse(item));
  }
  
  public PrivateServiceConnectNested<A> editPrivateServiceConnect() {
    return this.withNewPrivateServiceConnectLike(Optional.ofNullable(this.buildPrivateServiceConnect()).orElse(null));
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
    PlatformStatusFluent that = (PlatformStatusFluent) o;
    if (!(Objects.equals(privateServiceConnect, that.privateServiceConnect))) {
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
  
  public boolean hasPrivateServiceConnect() {
    return this.privateServiceConnect != null;
  }
  
  public int hashCode() {
    return Objects.hash(privateServiceConnect, additionalProperties);
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
    if (!(privateServiceConnect == null)) {
        sb.append("privateServiceConnect:");
        sb.append(privateServiceConnect);
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
  
  public PrivateServiceConnectNested<A> withNewPrivateServiceConnect() {
    return new PrivateServiceConnectNested(null);
  }
  
  public A withNewPrivateServiceConnect(String endpoint,String endpointAddress,String serviceAttachment,String serviceAttachmentFirewall,String serviceAttachmentSubnet) {
    return (A) this.withPrivateServiceConnect(new PrivateServiceConnectStatus(endpoint, endpointAddress, serviceAttachment, serviceAttachmentFirewall, serviceAttachmentSubnet));
  }
  
  public PrivateServiceConnectNested<A> withNewPrivateServiceConnectLike(PrivateServiceConnectStatus item) {
    return new PrivateServiceConnectNested(item);
  }
  
  public A withPrivateServiceConnect(PrivateServiceConnectStatus privateServiceConnect) {
    this._visitables.remove("privateServiceConnect");
    if (privateServiceConnect != null) {
        this.privateServiceConnect = new PrivateServiceConnectStatusBuilder(privateServiceConnect);
        this._visitables.get("privateServiceConnect").add(this.privateServiceConnect);
    } else {
        this.privateServiceConnect = null;
        this._visitables.get("privateServiceConnect").remove(this.privateServiceConnect);
    }
    return (A) this;
  }
  public class PrivateServiceConnectNested<N> extends PrivateServiceConnectStatusFluent<PrivateServiceConnectNested<N>> implements Nested<N>{
  
    PrivateServiceConnectStatusBuilder builder;
  
    PrivateServiceConnectNested(PrivateServiceConnectStatus item) {
      this.builder = new PrivateServiceConnectStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withPrivateServiceConnect(builder.build());
    }
    
    public N endPrivateServiceConnect() {
      return and();
    }
    
  }
}