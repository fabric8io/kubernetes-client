package io.fabric8.openshift.api.model.hive.gcp.v1;

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
public class PlatformFluent<A extends io.fabric8.openshift.api.model.hive.gcp.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LocalObjectReferenceBuilder credentialsSecretRef;
  private PrivateServiceConnectBuilder privateServiceConnect;
  private String region;

  public PlatformFluent() {
  }
  
  public PlatformFluent(Platform instance) {
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
  
  public LocalObjectReference buildCredentialsSecretRef() {
    return this.credentialsSecretRef != null ? this.credentialsSecretRef.build() : null;
  }
  
  public PrivateServiceConnect buildPrivateServiceConnect() {
    return this.privateServiceConnect != null ? this.privateServiceConnect.build() : null;
  }
  
  protected void copyInstance(Platform instance) {
    instance = instance != null ? instance : new Platform();
    if (instance != null) {
        this.withCredentialsSecretRef(instance.getCredentialsSecretRef());
        this.withPrivateServiceConnect(instance.getPrivateServiceConnect());
        this.withRegion(instance.getRegion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CredentialsSecretRefNested<A> editCredentialsSecretRef() {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(null));
  }
  
  public CredentialsSecretRefNested<A> editOrNewCredentialsSecretRef() {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public CredentialsSecretRefNested<A> editOrNewCredentialsSecretRefLike(LocalObjectReference item) {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(item));
  }
  
  public PrivateServiceConnectNested<A> editOrNewPrivateServiceConnect() {
    return this.withNewPrivateServiceConnectLike(Optional.ofNullable(this.buildPrivateServiceConnect()).orElse(new PrivateServiceConnectBuilder().build()));
  }
  
  public PrivateServiceConnectNested<A> editOrNewPrivateServiceConnectLike(PrivateServiceConnect item) {
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
    PlatformFluent that = (PlatformFluent) o;
    if (!(Objects.equals(credentialsSecretRef, that.credentialsSecretRef))) {
      return false;
    }
    if (!(Objects.equals(privateServiceConnect, that.privateServiceConnect))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
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
  
  public String getRegion() {
    return this.region;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCredentialsSecretRef() {
    return this.credentialsSecretRef != null;
  }
  
  public boolean hasPrivateServiceConnect() {
    return this.privateServiceConnect != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public int hashCode() {
    return Objects.hash(credentialsSecretRef, privateServiceConnect, region, additionalProperties);
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
    if (!(credentialsSecretRef == null)) {
        sb.append("credentialsSecretRef:");
        sb.append(credentialsSecretRef);
        sb.append(",");
    }
    if (!(privateServiceConnect == null)) {
        sb.append("privateServiceConnect:");
        sb.append(privateServiceConnect);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
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
  
  public A withCredentialsSecretRef(LocalObjectReference credentialsSecretRef) {
    this._visitables.remove("credentialsSecretRef");
    if (credentialsSecretRef != null) {
        this.credentialsSecretRef = new LocalObjectReferenceBuilder(credentialsSecretRef);
        this._visitables.get("credentialsSecretRef").add(this.credentialsSecretRef);
    } else {
        this.credentialsSecretRef = null;
        this._visitables.get("credentialsSecretRef").remove(this.credentialsSecretRef);
    }
    return (A) this;
  }
  
  public CredentialsSecretRefNested<A> withNewCredentialsSecretRef() {
    return new CredentialsSecretRefNested(null);
  }
  
  public A withNewCredentialsSecretRef(String name) {
    return (A) this.withCredentialsSecretRef(new LocalObjectReference(name));
  }
  
  public CredentialsSecretRefNested<A> withNewCredentialsSecretRefLike(LocalObjectReference item) {
    return new CredentialsSecretRefNested(item);
  }
  
  public PrivateServiceConnectNested<A> withNewPrivateServiceConnect() {
    return new PrivateServiceConnectNested(null);
  }
  
  public PrivateServiceConnectNested<A> withNewPrivateServiceConnectLike(PrivateServiceConnect item) {
    return new PrivateServiceConnectNested(item);
  }
  
  public A withPrivateServiceConnect(PrivateServiceConnect privateServiceConnect) {
    this._visitables.remove("privateServiceConnect");
    if (privateServiceConnect != null) {
        this.privateServiceConnect = new PrivateServiceConnectBuilder(privateServiceConnect);
        this._visitables.get("privateServiceConnect").add(this.privateServiceConnect);
    } else {
        this.privateServiceConnect = null;
        this._visitables.get("privateServiceConnect").remove(this.privateServiceConnect);
    }
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  public class CredentialsSecretRefNested<N> extends LocalObjectReferenceFluent<CredentialsSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CredentialsSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withCredentialsSecretRef(builder.build());
    }
    
    public N endCredentialsSecretRef() {
      return and();
    }
    
  }
  public class PrivateServiceConnectNested<N> extends PrivateServiceConnectFluent<PrivateServiceConnectNested<N>> implements Nested<N>{
  
    PrivateServiceConnectBuilder builder;
  
    PrivateServiceConnectNested(PrivateServiceConnect item) {
      this.builder = new PrivateServiceConnectBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withPrivateServiceConnect(builder.build());
    }
    
    public N endPrivateServiceConnect() {
      return and();
    }
    
  }
}