package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class WebhookClientConfigFluent<A extends io.fabric8.kubernetes.api.model.admissionregistration.v1.WebhookClientConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String caBundle;
  private ServiceReferenceBuilder service;
  private String url;

  public WebhookClientConfigFluent() {
  }
  
  public WebhookClientConfigFluent(WebhookClientConfig instance) {
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
  
  public ServiceReference buildService() {
    return this.service != null ? this.service.build() : null;
  }
  
  protected void copyInstance(WebhookClientConfig instance) {
    instance = instance != null ? instance : new WebhookClientConfig();
    if (instance != null) {
        this.withCaBundle(instance.getCaBundle());
        this.withService(instance.getService());
        this.withUrl(instance.getUrl());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ServiceNested<A> editOrNewService() {
    return this.withNewServiceLike(Optional.ofNullable(this.buildService()).orElse(new ServiceReferenceBuilder().build()));
  }
  
  public ServiceNested<A> editOrNewServiceLike(ServiceReference item) {
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
    WebhookClientConfigFluent that = (WebhookClientConfigFluent) o;
    if (!(Objects.equals(caBundle, that.caBundle))) {
      return false;
    }
    if (!(Objects.equals(service, that.service))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
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
  
  public String getCaBundle() {
    return this.caBundle;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCaBundle() {
    return this.caBundle != null;
  }
  
  public boolean hasService() {
    return this.service != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(caBundle, service, url, additionalProperties);
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
    if (!(caBundle == null)) {
        sb.append("caBundle:");
        sb.append(caBundle);
        sb.append(",");
    }
    if (!(service == null)) {
        sb.append("service:");
        sb.append(service);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
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
  
  public A withCaBundle(String caBundle) {
    this.caBundle = caBundle;
    return (A) this;
  }
  
  public ServiceNested<A> withNewService() {
    return new ServiceNested(null);
  }
  
  public A withNewService(String name,String namespace,String path,Integer port) {
    return (A) this.withService(new ServiceReference(name, namespace, path, port));
  }
  
  public ServiceNested<A> withNewServiceLike(ServiceReference item) {
    return new ServiceNested(item);
  }
  
  public A withService(ServiceReference service) {
    this._visitables.remove("service");
    if (service != null) {
        this.service = new ServiceReferenceBuilder(service);
        this._visitables.get("service").add(this.service);
    } else {
        this.service = null;
        this._visitables.get("service").remove(this.service);
    }
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  public class ServiceNested<N> extends ServiceReferenceFluent<ServiceNested<N>> implements Nested<N>{
  
    ServiceReferenceBuilder builder;
  
    ServiceNested(ServiceReference item) {
      this.builder = new ServiceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) WebhookClientConfigFluent.this.withService(builder.build());
    }
    
    public N endService() {
      return and();
    }
    
  }
}