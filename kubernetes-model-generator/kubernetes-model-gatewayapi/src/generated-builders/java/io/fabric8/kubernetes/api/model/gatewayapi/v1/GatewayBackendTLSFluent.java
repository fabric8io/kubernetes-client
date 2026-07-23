package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
public class GatewayBackendTLSFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayBackendTLSFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SecretObjectReferenceBuilder clientCertificateRef;

  public GatewayBackendTLSFluent() {
  }
  
  public GatewayBackendTLSFluent(GatewayBackendTLS instance) {
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
  
  public SecretObjectReference buildClientCertificateRef() {
    return this.clientCertificateRef != null ? this.clientCertificateRef.build() : null;
  }
  
  protected void copyInstance(GatewayBackendTLS instance) {
    instance = instance != null ? instance : new GatewayBackendTLS();
    if (instance != null) {
        this.withClientCertificateRef(instance.getClientCertificateRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClientCertificateRefNested<A> editClientCertificateRef() {
    return this.withNewClientCertificateRefLike(Optional.ofNullable(this.buildClientCertificateRef()).orElse(null));
  }
  
  public ClientCertificateRefNested<A> editOrNewClientCertificateRef() {
    return this.withNewClientCertificateRefLike(Optional.ofNullable(this.buildClientCertificateRef()).orElse(new SecretObjectReferenceBuilder().build()));
  }
  
  public ClientCertificateRefNested<A> editOrNewClientCertificateRefLike(SecretObjectReference item) {
    return this.withNewClientCertificateRefLike(Optional.ofNullable(this.buildClientCertificateRef()).orElse(item));
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
    GatewayBackendTLSFluent that = (GatewayBackendTLSFluent) o;
    if (!(Objects.equals(clientCertificateRef, that.clientCertificateRef))) {
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
  
  public boolean hasClientCertificateRef() {
    return this.clientCertificateRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(clientCertificateRef, additionalProperties);
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
    if (!(clientCertificateRef == null)) {
        sb.append("clientCertificateRef:");
        sb.append(clientCertificateRef);
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
  
  public A withClientCertificateRef(SecretObjectReference clientCertificateRef) {
    this._visitables.remove("clientCertificateRef");
    if (clientCertificateRef != null) {
        this.clientCertificateRef = new SecretObjectReferenceBuilder(clientCertificateRef);
        this._visitables.get("clientCertificateRef").add(this.clientCertificateRef);
    } else {
        this.clientCertificateRef = null;
        this._visitables.get("clientCertificateRef").remove(this.clientCertificateRef);
    }
    return (A) this;
  }
  
  public ClientCertificateRefNested<A> withNewClientCertificateRef() {
    return new ClientCertificateRefNested(null);
  }
  
  public A withNewClientCertificateRef(String group,String kind,String name,String namespace) {
    return (A) this.withClientCertificateRef(new SecretObjectReference(group, kind, name, namespace));
  }
  
  public ClientCertificateRefNested<A> withNewClientCertificateRefLike(SecretObjectReference item) {
    return new ClientCertificateRefNested(item);
  }
  public class ClientCertificateRefNested<N> extends SecretObjectReferenceFluent<ClientCertificateRefNested<N>> implements Nested<N>{
  
    SecretObjectReferenceBuilder builder;
  
    ClientCertificateRefNested(SecretObjectReference item) {
      this.builder = new SecretObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) GatewayBackendTLSFluent.this.withClientCertificateRef(builder.build());
    }
    
    public N endClientCertificateRef() {
      return and();
    }
    
  }
}