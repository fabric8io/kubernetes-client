package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.kubernetes.api.model.IntOrStringFluent;
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
public class HTTP01ChallengeFluent<A extends io.fabric8.knative.internal.networking.v1alpha1.HTTP01ChallengeFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String serviceName;
  private String serviceNamespace;
  private IntOrStringBuilder servicePort;
  private String url;

  public HTTP01ChallengeFluent() {
  }
  
  public HTTP01ChallengeFluent(HTTP01Challenge instance) {
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
  
  public IntOrString buildServicePort() {
    return this.servicePort != null ? this.servicePort.build() : null;
  }
  
  protected void copyInstance(HTTP01Challenge instance) {
    instance = instance != null ? instance : new HTTP01Challenge();
    if (instance != null) {
        this.withServiceName(instance.getServiceName());
        this.withServiceNamespace(instance.getServiceNamespace());
        this.withServicePort(instance.getServicePort());
        this.withUrl(instance.getUrl());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ServicePortNested<A> editOrNewServicePort() {
    return this.withNewServicePortLike(Optional.ofNullable(this.buildServicePort()).orElse(new IntOrStringBuilder().build()));
  }
  
  public ServicePortNested<A> editOrNewServicePortLike(IntOrString item) {
    return this.withNewServicePortLike(Optional.ofNullable(this.buildServicePort()).orElse(item));
  }
  
  public ServicePortNested<A> editServicePort() {
    return this.withNewServicePortLike(Optional.ofNullable(this.buildServicePort()).orElse(null));
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
    HTTP01ChallengeFluent that = (HTTP01ChallengeFluent) o;
    if (!(Objects.equals(serviceName, that.serviceName))) {
      return false;
    }
    if (!(Objects.equals(serviceNamespace, that.serviceNamespace))) {
      return false;
    }
    if (!(Objects.equals(servicePort, that.servicePort))) {
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
  
  public String getServiceName() {
    return this.serviceName;
  }
  
  public String getServiceNamespace() {
    return this.serviceNamespace;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasServiceName() {
    return this.serviceName != null;
  }
  
  public boolean hasServiceNamespace() {
    return this.serviceNamespace != null;
  }
  
  public boolean hasServicePort() {
    return this.servicePort != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(serviceName, serviceNamespace, servicePort, url, additionalProperties);
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
    if (!(serviceName == null)) {
        sb.append("serviceName:");
        sb.append(serviceName);
        sb.append(",");
    }
    if (!(serviceNamespace == null)) {
        sb.append("serviceNamespace:");
        sb.append(serviceNamespace);
        sb.append(",");
    }
    if (!(servicePort == null)) {
        sb.append("servicePort:");
        sb.append(servicePort);
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
  
  public ServicePortNested<A> withNewServicePort() {
    return new ServicePortNested(null);
  }
  
  public A withNewServicePort(Object value) {
    return (A) this.withServicePort(new IntOrString(value));
  }
  
  public ServicePortNested<A> withNewServicePortLike(IntOrString item) {
    return new ServicePortNested(item);
  }
  
  public A withServiceName(String serviceName) {
    this.serviceName = serviceName;
    return (A) this;
  }
  
  public A withServiceNamespace(String serviceNamespace) {
    this.serviceNamespace = serviceNamespace;
    return (A) this;
  }
  
  public A withServicePort(IntOrString servicePort) {
    this._visitables.remove("servicePort");
    if (servicePort != null) {
        this.servicePort = new IntOrStringBuilder(servicePort);
        this._visitables.get("servicePort").add(this.servicePort);
    } else {
        this.servicePort = null;
        this._visitables.get("servicePort").remove(this.servicePort);
    }
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  public class ServicePortNested<N> extends IntOrStringFluent<ServicePortNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    ServicePortNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTP01ChallengeFluent.this.withServicePort(builder.build());
    }
    
    public N endServicePort() {
      return and();
    }
    
  }
}