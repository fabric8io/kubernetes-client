package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PodHttpChaosPatchActionsFluent<A extends io.fabric8.chaosmesh.v1alpha1.PodHttpChaosPatchActionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PodHttpChaosPatchBodyActionBuilder body;
  private List<List<String>> headers = new ArrayList<List<String>>();
  private List<List<String>> queries = new ArrayList<List<String>>();

  public PodHttpChaosPatchActionsFluent() {
  }
  
  public PodHttpChaosPatchActionsFluent(PodHttpChaosPatchActions instance) {
    this.copyInstance(instance);
  }

  public A addAllToHeaders(Collection<List<String>> items) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    for (List<String> item : items) {
      this.headers.add(item);
    }
    return (A) this;
  }
  
  public A addAllToQueries(Collection<List<String>> items) {
    if (this.queries == null) {
      this.queries = new ArrayList();
    }
    for (List<String> item : items) {
      this.queries.add(item);
    }
    return (A) this;
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
  
  public A addToHeaders(List<String>... items) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    for (List<String> item : items) {
      this.headers.add(item);
    }
    return (A) this;
  }
  
  public A addToHeaders(int index,List<String> item) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    this.headers.add(index, item);
    return (A) this;
  }
  
  public A addToQueries(List<String>... items) {
    if (this.queries == null) {
      this.queries = new ArrayList();
    }
    for (List<String> item : items) {
      this.queries.add(item);
    }
    return (A) this;
  }
  
  public A addToQueries(int index,List<String> item) {
    if (this.queries == null) {
      this.queries = new ArrayList();
    }
    this.queries.add(index, item);
    return (A) this;
  }
  
  public PodHttpChaosPatchBodyAction buildBody() {
    return this.body != null ? this.body.build() : null;
  }
  
  protected void copyInstance(PodHttpChaosPatchActions instance) {
    instance = instance != null ? instance : new PodHttpChaosPatchActions();
    if (instance != null) {
        this.withBody(instance.getBody());
        this.withHeaders(instance.getHeaders());
        this.withQueries(instance.getQueries());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BodyNested<A> editBody() {
    return this.withNewBodyLike(Optional.ofNullable(this.buildBody()).orElse(null));
  }
  
  public BodyNested<A> editOrNewBody() {
    return this.withNewBodyLike(Optional.ofNullable(this.buildBody()).orElse(new PodHttpChaosPatchBodyActionBuilder().build()));
  }
  
  public BodyNested<A> editOrNewBodyLike(PodHttpChaosPatchBodyAction item) {
    return this.withNewBodyLike(Optional.ofNullable(this.buildBody()).orElse(item));
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
    PodHttpChaosPatchActionsFluent that = (PodHttpChaosPatchActionsFluent) o;
    if (!(Objects.equals(body, that.body))) {
      return false;
    }
    if (!(Objects.equals(headers, that.headers))) {
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
  
  public List<String> getFirstHeader() {
    return this.headers.get(0);
  }
  
  public List<String> getFirstQuery() {
    return this.queries.get(0);
  }
  
  public List<String> getHeader(int index) {
    return this.headers.get(index);
  }
  
  public List<List<String>> getHeaders() {
    return this.headers;
  }
  
  public List<String> getLastHeader() {
    return this.headers.get(headers.size() - 1);
  }
  
  public List<String> getLastQuery() {
    return this.queries.get(queries.size() - 1);
  }
  
  public List<String> getMatchingHeader(Predicate<List<String>> predicate) {
      for (List<String> item : headers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<String> getMatchingQuery(Predicate<List<String>> predicate) {
      for (List<String> item : queries) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<List<String>> getQueries() {
    return this.queries;
  }
  
  public List<String> getQuery(int index) {
    return this.queries.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBody() {
    return this.body != null;
  }
  
  public boolean hasHeaders() {
    return this.headers != null && !(this.headers.isEmpty());
  }
  
  public boolean hasMatchingHeader(Predicate<List<String>> predicate) {
      for (List<String> item : headers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingQuery(Predicate<List<String>> predicate) {
      for (List<String> item : queries) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasQueries() {
    return this.queries != null && !(this.queries.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(body, headers, queries, additionalProperties);
  }
  
  public A removeAllFromHeaders(Collection<List<String>> items) {
    if (this.headers == null) {
      return (A) this;
    }
    for (List<String> item : items) {
      this.headers.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromQueries(Collection<List<String>> items) {
    if (this.queries == null) {
      return (A) this;
    }
    for (List<String> item : items) {
      this.queries.remove(item);
    }
    return (A) this;
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
  
  public A removeFromHeaders(List<String>... items) {
    if (this.headers == null) {
      return (A) this;
    }
    for (List<String> item : items) {
      this.headers.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromQueries(List<String>... items) {
    if (this.queries == null) {
      return (A) this;
    }
    for (List<String> item : items) {
      this.queries.remove(item);
    }
    return (A) this;
  }
  
  public A setToHeaders(int index,List<String> item) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    this.headers.set(index, item);
    return (A) this;
  }
  
  public A setToQueries(int index,List<String> item) {
    if (this.queries == null) {
      this.queries = new ArrayList();
    }
    this.queries.set(index, item);
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
    if (!(headers == null) && !(headers.isEmpty())) {
        sb.append("headers:");
        sb.append(headers);
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
  
  public A withBody(PodHttpChaosPatchBodyAction body) {
    this._visitables.remove("body");
    if (body != null) {
        this.body = new PodHttpChaosPatchBodyActionBuilder(body);
        this._visitables.get("body").add(this.body);
    } else {
        this.body = null;
        this._visitables.get("body").remove(this.body);
    }
    return (A) this;
  }
  
  public <E>A withHeaders(List<List<String>> headers) {
    if (headers != null) {
        this.headers = new ArrayList();
        for (List<String> item : headers) {
          this.addToHeaders(item);
        }
    } else {
      this.headers = null;
    }
    return (A) this;
  }
  
  public A withHeaders(List<String>... headers) {
    if (this.headers != null) {
        this.headers.clear();
        _visitables.remove("headers");
    }
    if (headers != null) {
      for (List<String> item : headers) {
        this.addToHeaders(item);
      }
    }
    return (A) this;
  }
  
  public BodyNested<A> withNewBody() {
    return new BodyNested(null);
  }
  
  public A withNewBody(String type,String value) {
    return (A) this.withBody(new PodHttpChaosPatchBodyAction(type, value));
  }
  
  public BodyNested<A> withNewBodyLike(PodHttpChaosPatchBodyAction item) {
    return new BodyNested(item);
  }
  
  public <E>A withQueries(List<List<String>> queries) {
    if (queries != null) {
        this.queries = new ArrayList();
        for (List<String> item : queries) {
          this.addToQueries(item);
        }
    } else {
      this.queries = null;
    }
    return (A) this;
  }
  
  public A withQueries(List<String>... queries) {
    if (this.queries != null) {
        this.queries.clear();
        _visitables.remove("queries");
    }
    if (queries != null) {
      for (List<String> item : queries) {
        this.addToQueries(item);
      }
    }
    return (A) this;
  }
  public class BodyNested<N> extends PodHttpChaosPatchBodyActionFluent<BodyNested<N>> implements Nested<N>{
  
    PodHttpChaosPatchBodyActionBuilder builder;
  
    BodyNested(PodHttpChaosPatchBodyAction item) {
      this.builder = new PodHttpChaosPatchBodyActionBuilder(this, item);
    }
  
    public N and() {
      return (N) PodHttpChaosPatchActionsFluent.this.withBody(builder.build());
    }
    
    public N endBody() {
      return and();
    }
    
  }
}