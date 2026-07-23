package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ImageRegistryConfigProxyFluent<A extends io.fabric8.openshift.api.model.operator.imageregistry.v1.ImageRegistryConfigProxyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String http;
  private String https;
  private String noProxy;

  public ImageRegistryConfigProxyFluent() {
  }
  
  public ImageRegistryConfigProxyFluent(ImageRegistryConfigProxy instance) {
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
  
  protected void copyInstance(ImageRegistryConfigProxy instance) {
    instance = instance != null ? instance : new ImageRegistryConfigProxy();
    if (instance != null) {
        this.withHttp(instance.getHttp());
        this.withHttps(instance.getHttps());
        this.withNoProxy(instance.getNoProxy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    ImageRegistryConfigProxyFluent that = (ImageRegistryConfigProxyFluent) o;
    if (!(Objects.equals(http, that.http))) {
      return false;
    }
    if (!(Objects.equals(https, that.https))) {
      return false;
    }
    if (!(Objects.equals(noProxy, that.noProxy))) {
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
  
  public String getHttp() {
    return this.http;
  }
  
  public String getHttps() {
    return this.https;
  }
  
  public String getNoProxy() {
    return this.noProxy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHttp() {
    return this.http != null;
  }
  
  public boolean hasHttps() {
    return this.https != null;
  }
  
  public boolean hasNoProxy() {
    return this.noProxy != null;
  }
  
  public int hashCode() {
    return Objects.hash(http, https, noProxy, additionalProperties);
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
    if (!(http == null)) {
        sb.append("http:");
        sb.append(http);
        sb.append(",");
    }
    if (!(https == null)) {
        sb.append("https:");
        sb.append(https);
        sb.append(",");
    }
    if (!(noProxy == null)) {
        sb.append("noProxy:");
        sb.append(noProxy);
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
  
  public A withHttp(String http) {
    this.http = http;
    return (A) this;
  }
  
  public A withHttps(String https) {
    this.https = https;
    return (A) this;
  }
  
  public A withNoProxy(String noProxy) {
    this.noProxy = noProxy;
    return (A) this;
  }
  
}