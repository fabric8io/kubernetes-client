package io.fabric8.certmanager.api.model.acme.v1;

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
public class Route53KubernetesAuthFluent<A extends io.fabric8.certmanager.api.model.acme.v1.Route53KubernetesAuthFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ServiceAccountRefBuilder serviceAccountRef;

  public Route53KubernetesAuthFluent() {
  }
  
  public Route53KubernetesAuthFluent(Route53KubernetesAuth instance) {
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
  
  public ServiceAccountRef buildServiceAccountRef() {
    return this.serviceAccountRef != null ? this.serviceAccountRef.build() : null;
  }
  
  protected void copyInstance(Route53KubernetesAuth instance) {
    instance = instance != null ? instance : new Route53KubernetesAuth();
    if (instance != null) {
        this.withServiceAccountRef(instance.getServiceAccountRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ServiceAccountRefNested<A> editOrNewServiceAccountRef() {
    return this.withNewServiceAccountRefLike(Optional.ofNullable(this.buildServiceAccountRef()).orElse(new ServiceAccountRefBuilder().build()));
  }
  
  public ServiceAccountRefNested<A> editOrNewServiceAccountRefLike(ServiceAccountRef item) {
    return this.withNewServiceAccountRefLike(Optional.ofNullable(this.buildServiceAccountRef()).orElse(item));
  }
  
  public ServiceAccountRefNested<A> editServiceAccountRef() {
    return this.withNewServiceAccountRefLike(Optional.ofNullable(this.buildServiceAccountRef()).orElse(null));
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
    Route53KubernetesAuthFluent that = (Route53KubernetesAuthFluent) o;
    if (!(Objects.equals(serviceAccountRef, that.serviceAccountRef))) {
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
  
  public boolean hasServiceAccountRef() {
    return this.serviceAccountRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(serviceAccountRef, additionalProperties);
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
    if (!(serviceAccountRef == null)) {
        sb.append("serviceAccountRef:");
        sb.append(serviceAccountRef);
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
  
  public ServiceAccountRefNested<A> withNewServiceAccountRef() {
    return new ServiceAccountRefNested(null);
  }
  
  public ServiceAccountRefNested<A> withNewServiceAccountRefLike(ServiceAccountRef item) {
    return new ServiceAccountRefNested(item);
  }
  
  public A withServiceAccountRef(ServiceAccountRef serviceAccountRef) {
    this._visitables.remove("serviceAccountRef");
    if (serviceAccountRef != null) {
        this.serviceAccountRef = new ServiceAccountRefBuilder(serviceAccountRef);
        this._visitables.get("serviceAccountRef").add(this.serviceAccountRef);
    } else {
        this.serviceAccountRef = null;
        this._visitables.get("serviceAccountRef").remove(this.serviceAccountRef);
    }
    return (A) this;
  }
  public class ServiceAccountRefNested<N> extends ServiceAccountRefFluent<ServiceAccountRefNested<N>> implements Nested<N>{
  
    ServiceAccountRefBuilder builder;
  
    ServiceAccountRefNested(ServiceAccountRef item) {
      this.builder = new ServiceAccountRefBuilder(this, item);
    }
  
    public N and() {
      return (N) Route53KubernetesAuthFluent.this.withServiceAccountRef(builder.build());
    }
    
    public N endServiceAccountRef() {
      return and();
    }
    
  }
}