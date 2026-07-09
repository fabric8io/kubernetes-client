package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.TypedLocalObjectReference;
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
public class IngressBackendFluent<A extends io.fabric8.kubernetes.api.model.networking.v1.IngressBackendFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private TypedLocalObjectReference resource;
  private IngressServiceBackendBuilder service;

  public IngressBackendFluent() {
  }
  
  public IngressBackendFluent(IngressBackend instance) {
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
  
  public IngressServiceBackend buildService() {
    return this.service != null ? this.service.build() : null;
  }
  
  protected void copyInstance(IngressBackend instance) {
    instance = instance != null ? instance : new IngressBackend();
    if (instance != null) {
        this.withResource(instance.getResource());
        this.withService(instance.getService());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ServiceNested<A> editOrNewService() {
    return this.withNewServiceLike(Optional.ofNullable(this.buildService()).orElse(new IngressServiceBackendBuilder().build()));
  }
  
  public ServiceNested<A> editOrNewServiceLike(IngressServiceBackend item) {
    return this.withNewServiceLike(Optional.ofNullable(this.buildService()).orElse(item));
  }
  
  public ServiceNested<A> editService() {
    return this.withNewServiceLike(Optional.ofNullable(this.buildService()).orElse(null));
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
    IngressBackendFluent that = (IngressBackendFluent) o;
    if (!(Objects.equals(resource, that.resource))) {
      return false;
    }
    if (!(Objects.equals(service, that.service))) {
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
  
  public TypedLocalObjectReference getResource() {
    return this.resource;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasResource() {
    return this.resource != null;
  }
  
  public boolean hasService() {
    return this.service != null;
  }
  
  public int hashCode() {
    return Objects.hash(resource, service, additionalProperties);
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
    if (!(resource == null)) {
        sb.append("resource:");
        sb.append(resource);
        sb.append(",");
    }
    if (!(service == null)) {
        sb.append("service:");
        sb.append(service);
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
  
  public A withNewResource(String apiGroup,String kind,String name) {
    return (A) this.withResource(new TypedLocalObjectReference(apiGroup, kind, name));
  }
  
  public ServiceNested<A> withNewService() {
    return new ServiceNested(null);
  }
  
  public ServiceNested<A> withNewServiceLike(IngressServiceBackend item) {
    return new ServiceNested(item);
  }
  
  public A withResource(TypedLocalObjectReference resource) {
    this.resource = resource;
    return (A) this;
  }
  
  public A withService(IngressServiceBackend service) {
    this._visitables.remove("service");
    if (service != null) {
        this.service = new IngressServiceBackendBuilder(service);
        this._visitables.get("service").add(this.service);
    } else {
        this.service = null;
        this._visitables.get("service").remove(this.service);
    }
    return (A) this;
  }
  public class ServiceNested<N> extends IngressServiceBackendFluent<ServiceNested<N>> implements Nested<N>{
  
    IngressServiceBackendBuilder builder;
  
    ServiceNested(IngressServiceBackend item) {
      this.builder = new IngressServiceBackendBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressBackendFluent.this.withService(builder.build());
    }
    
    public N endService() {
      return and();
    }
    
  }
}