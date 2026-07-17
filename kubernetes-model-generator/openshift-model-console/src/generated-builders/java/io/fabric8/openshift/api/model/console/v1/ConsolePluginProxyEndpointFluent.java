package io.fabric8.openshift.api.model.console.v1;

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
public class ConsolePluginProxyEndpointFluent<A extends io.fabric8.openshift.api.model.console.v1.ConsolePluginProxyEndpointFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConsolePluginProxyServiceConfigBuilder service;
  private String type;

  public ConsolePluginProxyEndpointFluent() {
  }
  
  public ConsolePluginProxyEndpointFluent(ConsolePluginProxyEndpoint instance) {
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
  
  public ConsolePluginProxyServiceConfig buildService() {
    return this.service != null ? this.service.build() : null;
  }
  
  protected void copyInstance(ConsolePluginProxyEndpoint instance) {
    instance = instance != null ? instance : new ConsolePluginProxyEndpoint();
    if (instance != null) {
        this.withService(instance.getService());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ServiceNested<A> editOrNewService() {
    return this.withNewServiceLike(Optional.ofNullable(this.buildService()).orElse(new ConsolePluginProxyServiceConfigBuilder().build()));
  }
  
  public ServiceNested<A> editOrNewServiceLike(ConsolePluginProxyServiceConfig item) {
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
    ConsolePluginProxyEndpointFluent that = (ConsolePluginProxyEndpointFluent) o;
    if (!(Objects.equals(service, that.service))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasService() {
    return this.service != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(service, type, additionalProperties);
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
    if (!(service == null)) {
        sb.append("service:");
        sb.append(service);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public ServiceNested<A> withNewService() {
    return new ServiceNested(null);
  }
  
  public A withNewService(String name,String namespace,Integer port) {
    return (A) this.withService(new ConsolePluginProxyServiceConfig(name, namespace, port));
  }
  
  public ServiceNested<A> withNewServiceLike(ConsolePluginProxyServiceConfig item) {
    return new ServiceNested(item);
  }
  
  public A withService(ConsolePluginProxyServiceConfig service) {
    this._visitables.remove("service");
    if (service != null) {
        this.service = new ConsolePluginProxyServiceConfigBuilder(service);
        this._visitables.get("service").add(this.service);
    } else {
        this.service = null;
        this._visitables.get("service").remove(this.service);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ServiceNested<N> extends ConsolePluginProxyServiceConfigFluent<ServiceNested<N>> implements Nested<N>{
  
    ConsolePluginProxyServiceConfigBuilder builder;
  
    ServiceNested(ConsolePluginProxyServiceConfig item) {
      this.builder = new ConsolePluginProxyServiceConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsolePluginProxyEndpointFluent.this.withService(builder.build());
    }
    
    public N endService() {
      return and();
    }
    
  }
}