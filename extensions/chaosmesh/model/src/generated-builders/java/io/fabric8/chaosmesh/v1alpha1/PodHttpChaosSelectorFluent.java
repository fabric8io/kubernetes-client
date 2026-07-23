package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class PodHttpChaosSelectorFluent<A extends io.fabric8.chaosmesh.v1alpha1.PodHttpChaosSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer code;
  private String method;
  private String path;
  private Integer port;
  private Map<String,String> requestHeaders;
  private Map<String,String> responseHeaders;

  public PodHttpChaosSelectorFluent() {
  }
  
  public PodHttpChaosSelectorFluent(PodHttpChaosSelector instance) {
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
  
  public A addToRequestHeaders(Map<String,String> map) {
    if (this.requestHeaders == null && map != null) {
      this.requestHeaders = new LinkedHashMap();
    }
    if (map != null) {
      this.requestHeaders.putAll(map);
    }
    return (A) this;
  }
  
  public A addToRequestHeaders(String key,String value) {
    if (this.requestHeaders == null && key != null && value != null) {
      this.requestHeaders = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.requestHeaders.put(key, value);
    }
    return (A) this;
  }
  
  public A addToResponseHeaders(Map<String,String> map) {
    if (this.responseHeaders == null && map != null) {
      this.responseHeaders = new LinkedHashMap();
    }
    if (map != null) {
      this.responseHeaders.putAll(map);
    }
    return (A) this;
  }
  
  public A addToResponseHeaders(String key,String value) {
    if (this.responseHeaders == null && key != null && value != null) {
      this.responseHeaders = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.responseHeaders.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(PodHttpChaosSelector instance) {
    instance = instance != null ? instance : new PodHttpChaosSelector();
    if (instance != null) {
        this.withCode(instance.getCode());
        this.withMethod(instance.getMethod());
        this.withPath(instance.getPath());
        this.withPort(instance.getPort());
        this.withRequestHeaders(instance.getRequestHeaders());
        this.withResponseHeaders(instance.getResponseHeaders());
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
    PodHttpChaosSelectorFluent that = (PodHttpChaosSelectorFluent) o;
    if (!(Objects.equals(code, that.code))) {
      return false;
    }
    if (!(Objects.equals(method, that.method))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(requestHeaders, that.requestHeaders))) {
      return false;
    }
    if (!(Objects.equals(responseHeaders, that.responseHeaders))) {
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
  
  public Integer getCode() {
    return this.code;
  }
  
  public String getMethod() {
    return this.method;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public Map<String,String> getRequestHeaders() {
    return this.requestHeaders;
  }
  
  public Map<String,String> getResponseHeaders() {
    return this.responseHeaders;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCode() {
    return this.code != null;
  }
  
  public boolean hasMethod() {
    return this.method != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasRequestHeaders() {
    return this.requestHeaders != null;
  }
  
  public boolean hasResponseHeaders() {
    return this.responseHeaders != null;
  }
  
  public int hashCode() {
    return Objects.hash(code, method, path, port, requestHeaders, responseHeaders, additionalProperties);
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
  
  public A removeFromRequestHeaders(String key) {
    if (this.requestHeaders == null) {
      return (A) this;
    }
    if (key != null && this.requestHeaders != null) {
      this.requestHeaders.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromRequestHeaders(Map<String,String> map) {
    if (this.requestHeaders == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.requestHeaders != null) {
          this.requestHeaders.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromResponseHeaders(String key) {
    if (this.responseHeaders == null) {
      return (A) this;
    }
    if (key != null && this.responseHeaders != null) {
      this.responseHeaders.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromResponseHeaders(Map<String,String> map) {
    if (this.responseHeaders == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.responseHeaders != null) {
          this.responseHeaders.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(code == null)) {
        sb.append("code:");
        sb.append(code);
        sb.append(",");
    }
    if (!(method == null)) {
        sb.append("method:");
        sb.append(method);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(requestHeaders == null) && !(requestHeaders.isEmpty())) {
        sb.append("requestHeaders:");
        sb.append(requestHeaders);
        sb.append(",");
    }
    if (!(responseHeaders == null) && !(responseHeaders.isEmpty())) {
        sb.append("responseHeaders:");
        sb.append(responseHeaders);
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
  
  public A withCode(Integer code) {
    this.code = code;
    return (A) this;
  }
  
  public A withMethod(String method) {
    this.method = method;
    return (A) this;
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
  public <K,V>A withRequestHeaders(Map<String,String> requestHeaders) {
    if (requestHeaders == null) {
      this.requestHeaders = null;
    } else {
      this.requestHeaders = new LinkedHashMap(requestHeaders);
    }
    return (A) this;
  }
  
  public <K,V>A withResponseHeaders(Map<String,String> responseHeaders) {
    if (responseHeaders == null) {
      this.responseHeaders = null;
    } else {
      this.responseHeaders = new LinkedHashMap(responseHeaders);
    }
    return (A) this;
  }
  
}