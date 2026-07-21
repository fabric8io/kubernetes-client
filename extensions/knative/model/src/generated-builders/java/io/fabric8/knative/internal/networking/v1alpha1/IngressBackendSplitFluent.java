package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.kubernetes.api.model.IntOrStringFluent;
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
public class IngressBackendSplitFluent<A extends io.fabric8.knative.internal.networking.v1alpha1.IngressBackendSplitFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> appendHeaders;
  private Integer percent;
  private String serviceName;
  private String serviceNamespace;
  private IntOrStringBuilder servicePort;

  public IngressBackendSplitFluent() {
  }
  
  public IngressBackendSplitFluent(IngressBackendSplit instance) {
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
  
  public A addToAppendHeaders(Map<String,String> map) {
    if (this.appendHeaders == null && map != null) {
      this.appendHeaders = new LinkedHashMap();
    }
    if (map != null) {
      this.appendHeaders.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAppendHeaders(String key,String value) {
    if (this.appendHeaders == null && key != null && value != null) {
      this.appendHeaders = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.appendHeaders.put(key, value);
    }
    return (A) this;
  }
  
  public IntOrString buildServicePort() {
    return this.servicePort != null ? this.servicePort.build() : null;
  }
  
  protected void copyInstance(IngressBackendSplit instance) {
    instance = instance != null ? instance : new IngressBackendSplit();
    if (instance != null) {
        this.withAppendHeaders(instance.getAppendHeaders());
        this.withPercent(instance.getPercent());
        this.withServiceName(instance.getServiceName());
        this.withServiceNamespace(instance.getServiceNamespace());
        this.withServicePort(instance.getServicePort());
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
    IngressBackendSplitFluent that = (IngressBackendSplitFluent) o;
    if (!(Objects.equals(appendHeaders, that.appendHeaders))) {
      return false;
    }
    if (!(Objects.equals(percent, that.percent))) {
      return false;
    }
    if (!(Objects.equals(serviceName, that.serviceName))) {
      return false;
    }
    if (!(Objects.equals(serviceNamespace, that.serviceNamespace))) {
      return false;
    }
    if (!(Objects.equals(servicePort, that.servicePort))) {
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
  
  public Map<String,String> getAppendHeaders() {
    return this.appendHeaders;
  }
  
  public Integer getPercent() {
    return this.percent;
  }
  
  public String getServiceName() {
    return this.serviceName;
  }
  
  public String getServiceNamespace() {
    return this.serviceNamespace;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAppendHeaders() {
    return this.appendHeaders != null;
  }
  
  public boolean hasPercent() {
    return this.percent != null;
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
  
  public int hashCode() {
    return Objects.hash(appendHeaders, percent, serviceName, serviceNamespace, servicePort, additionalProperties);
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
  
  public A removeFromAppendHeaders(String key) {
    if (this.appendHeaders == null) {
      return (A) this;
    }
    if (key != null && this.appendHeaders != null) {
      this.appendHeaders.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAppendHeaders(Map<String,String> map) {
    if (this.appendHeaders == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.appendHeaders != null) {
          this.appendHeaders.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(appendHeaders == null) && !(appendHeaders.isEmpty())) {
        sb.append("appendHeaders:");
        sb.append(appendHeaders);
        sb.append(",");
    }
    if (!(percent == null)) {
        sb.append("percent:");
        sb.append(percent);
        sb.append(",");
    }
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
  
  public <K,V>A withAppendHeaders(Map<String,String> appendHeaders) {
    if (appendHeaders == null) {
      this.appendHeaders = null;
    } else {
      this.appendHeaders = new LinkedHashMap(appendHeaders);
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
  
  public A withPercent(Integer percent) {
    this.percent = percent;
    return (A) this;
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
  public class ServicePortNested<N> extends IntOrStringFluent<ServicePortNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    ServicePortNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressBackendSplitFluent.this.withServicePort(builder.build());
    }
    
    public N endServicePort() {
      return and();
    }
    
  }
}