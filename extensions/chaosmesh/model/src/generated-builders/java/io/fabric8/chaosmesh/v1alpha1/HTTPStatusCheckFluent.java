package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HTTPStatusCheckFluent<A extends io.fabric8.chaosmesh.v1alpha1.HTTPStatusCheckFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String body;
  private HTTPCriteriaBuilder criteria;
  private Map<String,List<String>> headers;
  private String method;
  private String url;

  public HTTPStatusCheckFluent() {
  }
  
  public HTTPStatusCheckFluent(HTTPStatusCheck instance) {
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
  
  public A addToHeaders(Map<String,List<String>> map) {
    if (this.headers == null && map != null) {
      this.headers = new LinkedHashMap();
    }
    if (map != null) {
      this.headers.putAll(map);
    }
    return (A) this;
  }
  
  public A addToHeaders(String key,List<String> value) {
    if (this.headers == null && key != null && value != null) {
      this.headers = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.headers.put(key, value);
    }
    return (A) this;
  }
  
  public HTTPCriteria buildCriteria() {
    return this.criteria != null ? this.criteria.build() : null;
  }
  
  protected void copyInstance(HTTPStatusCheck instance) {
    instance = instance != null ? instance : new HTTPStatusCheck();
    if (instance != null) {
        this.withBody(instance.getBody());
        this.withCriteria(instance.getCriteria());
        this.withHeaders(instance.getHeaders());
        this.withMethod(instance.getMethod());
        this.withUrl(instance.getUrl());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CriteriaNested<A> editCriteria() {
    return this.withNewCriteriaLike(Optional.ofNullable(this.buildCriteria()).orElse(null));
  }
  
  public CriteriaNested<A> editOrNewCriteria() {
    return this.withNewCriteriaLike(Optional.ofNullable(this.buildCriteria()).orElse(new HTTPCriteriaBuilder().build()));
  }
  
  public CriteriaNested<A> editOrNewCriteriaLike(HTTPCriteria item) {
    return this.withNewCriteriaLike(Optional.ofNullable(this.buildCriteria()).orElse(item));
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
    HTTPStatusCheckFluent that = (HTTPStatusCheckFluent) o;
    if (!(Objects.equals(body, that.body))) {
      return false;
    }
    if (!(Objects.equals(criteria, that.criteria))) {
      return false;
    }
    if (!(Objects.equals(headers, that.headers))) {
      return false;
    }
    if (!(Objects.equals(method, that.method))) {
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
  
  public String getBody() {
    return this.body;
  }
  
  public Map<String,List<String>> getHeaders() {
    return this.headers;
  }
  
  public String getMethod() {
    return this.method;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBody() {
    return this.body != null;
  }
  
  public boolean hasCriteria() {
    return this.criteria != null;
  }
  
  public boolean hasHeaders() {
    return this.headers != null;
  }
  
  public boolean hasMethod() {
    return this.method != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(body, criteria, headers, method, url, additionalProperties);
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
  
  public A removeFromHeaders(Map<String,List<String>> map) {
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(body == null)) {
        sb.append("body:");
        sb.append(body);
        sb.append(",");
    }
    if (!(criteria == null)) {
        sb.append("criteria:");
        sb.append(criteria);
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
  
  public A withBody(String body) {
    this.body = body;
    return (A) this;
  }
  
  public A withCriteria(HTTPCriteria criteria) {
    this._visitables.remove("criteria");
    if (criteria != null) {
        this.criteria = new HTTPCriteriaBuilder(criteria);
        this._visitables.get("criteria").add(this.criteria);
    } else {
        this.criteria = null;
        this._visitables.get("criteria").remove(this.criteria);
    }
    return (A) this;
  }
  
  public <K,V>A withHeaders(Map<String,List<String>> headers) {
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
  
  public CriteriaNested<A> withNewCriteria() {
    return new CriteriaNested(null);
  }
  
  public A withNewCriteria(String statusCode) {
    return (A) this.withCriteria(new HTTPCriteria(statusCode));
  }
  
  public CriteriaNested<A> withNewCriteriaLike(HTTPCriteria item) {
    return new CriteriaNested(item);
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  public class CriteriaNested<N> extends HTTPCriteriaFluent<CriteriaNested<N>> implements Nested<N>{
  
    HTTPCriteriaBuilder builder;
  
    CriteriaNested(HTTPCriteria item) {
      this.builder = new HTTPCriteriaBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPStatusCheckFluent.this.withCriteria(builder.build());
    }
    
    public N endCriteria() {
      return and();
    }
    
  }
}