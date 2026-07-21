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
public class PodHttpChaosReplaceActionsFluent<A extends io.fabric8.chaosmesh.v1alpha1.PodHttpChaosReplaceActionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String body;
  private Integer code;
  private Map<String,String> headers;
  private String method;
  private String path;
  private Map<String,String> queries;

  public PodHttpChaosReplaceActionsFluent() {
  }
  
  public PodHttpChaosReplaceActionsFluent(PodHttpChaosReplaceActions instance) {
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
  
  public A addToHeaders(Map<String,String> map) {
    if (this.headers == null && map != null) {
      this.headers = new LinkedHashMap();
    }
    if (map != null) {
      this.headers.putAll(map);
    }
    return (A) this;
  }
  
  public A addToHeaders(String key,String value) {
    if (this.headers == null && key != null && value != null) {
      this.headers = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.headers.put(key, value);
    }
    return (A) this;
  }
  
  public A addToQueries(Map<String,String> map) {
    if (this.queries == null && map != null) {
      this.queries = new LinkedHashMap();
    }
    if (map != null) {
      this.queries.putAll(map);
    }
    return (A) this;
  }
  
  public A addToQueries(String key,String value) {
    if (this.queries == null && key != null && value != null) {
      this.queries = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.queries.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(PodHttpChaosReplaceActions instance) {
    instance = instance != null ? instance : new PodHttpChaosReplaceActions();
    if (instance != null) {
        this.withBody(instance.getBody());
        this.withCode(instance.getCode());
        this.withHeaders(instance.getHeaders());
        this.withMethod(instance.getMethod());
        this.withPath(instance.getPath());
        this.withQueries(instance.getQueries());
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
    PodHttpChaosReplaceActionsFluent that = (PodHttpChaosReplaceActionsFluent) o;
    if (!(Objects.equals(body, that.body))) {
      return false;
    }
    if (!(Objects.equals(code, that.code))) {
      return false;
    }
    if (!(Objects.equals(headers, that.headers))) {
      return false;
    }
    if (!(Objects.equals(method, that.method))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(queries, that.queries))) {
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
  
  public String getBody() {
    return this.body;
  }
  
  public Integer getCode() {
    return this.code;
  }
  
  public Map<String,String> getHeaders() {
    return this.headers;
  }
  
  public String getMethod() {
    return this.method;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public Map<String,String> getQueries() {
    return this.queries;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBody() {
    return this.body != null;
  }
  
  public boolean hasCode() {
    return this.code != null;
  }
  
  public boolean hasHeaders() {
    return this.headers != null;
  }
  
  public boolean hasMethod() {
    return this.method != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasQueries() {
    return this.queries != null;
  }
  
  public int hashCode() {
    return Objects.hash(body, code, headers, method, path, queries, additionalProperties);
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
  
  public A removeFromHeaders(String key) {
    if (this.headers == null) {
      return (A) this;
    }
    if (key != null && this.headers != null) {
      this.headers.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromHeaders(Map<String,String> map) {
    if (this.headers == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.headers != null) {
          this.headers.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromQueries(String key) {
    if (this.queries == null) {
      return (A) this;
    }
    if (key != null && this.queries != null) {
      this.queries.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromQueries(Map<String,String> map) {
    if (this.queries == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.queries != null) {
          this.queries.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(body == null)) {
        sb.append("body:");
        sb.append(body);
        sb.append(",");
    }
    if (!(code == null)) {
        sb.append("code:");
        sb.append(code);
        sb.append(",");
    }
    if (!(headers == null) && !(headers.isEmpty())) {
        sb.append("headers:");
        sb.append(headers);
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
    if (!(queries == null) && !(queries.isEmpty())) {
        sb.append("queries:");
        sb.append(queries);
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
  
  public A withBody(String body) {
    this.body = body;
    return (A) this;
  }
  
  public A withCode(Integer code) {
    this.code = code;
    return (A) this;
  }
  
  public <K,V>A withHeaders(Map<String,String> headers) {
    if (headers == null) {
      this.headers = null;
    } else {
      this.headers = new LinkedHashMap(headers);
    }
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
  
  public <K,V>A withQueries(Map<String,String> queries) {
    if (queries == null) {
      this.queries = null;
    } else {
      this.queries = new LinkedHashMap(queries);
    }
    return (A) this;
  }
  
}