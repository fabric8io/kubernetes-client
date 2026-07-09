package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class GRPCRouteMatchFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.GRPCRouteMatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<GRPCHeaderMatchBuilder> headers = new ArrayList<GRPCHeaderMatchBuilder>();
  private GRPCMethodMatchBuilder method;

  public GRPCRouteMatchFluent() {
  }
  
  public GRPCRouteMatchFluent(GRPCRouteMatch instance) {
    this.copyInstance(instance);
  }

  public A addAllToHeaders(Collection<GRPCHeaderMatch> items) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    for (GRPCHeaderMatch item : items) {
        GRPCHeaderMatchBuilder builder = new GRPCHeaderMatchBuilder(item);
        _visitables.get("headers").add(builder);
        this.headers.add(builder);
    }
    return (A) this;
  }
  
  public HeadersNested<A> addNewHeader() {
    return new HeadersNested(-1, null);
  }
  
  public A addNewHeader(String name,String type,String value) {
    return (A) this.addToHeaders(new GRPCHeaderMatch(name, type, value));
  }
  
  public HeadersNested<A> addNewHeaderLike(GRPCHeaderMatch item) {
    return new HeadersNested(-1, item);
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
  
  public A addToHeaders(GRPCHeaderMatch... items) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    for (GRPCHeaderMatch item : items) {
        GRPCHeaderMatchBuilder builder = new GRPCHeaderMatchBuilder(item);
        _visitables.get("headers").add(builder);
        this.headers.add(builder);
    }
    return (A) this;
  }
  
  public A addToHeaders(int index,GRPCHeaderMatch item) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    GRPCHeaderMatchBuilder builder = new GRPCHeaderMatchBuilder(item);
    if (index < 0 || index >= headers.size()) {
        _visitables.get("headers").add(builder);
        headers.add(builder);
    } else {
        _visitables.get("headers").add(builder);
        headers.add(index, builder);
    }
    return (A) this;
  }
  
  public GRPCHeaderMatch buildFirstHeader() {
    return this.headers.get(0).build();
  }
  
  public GRPCHeaderMatch buildHeader(int index) {
    return this.headers.get(index).build();
  }
  
  public List<GRPCHeaderMatch> buildHeaders() {
    return this.headers != null ? build(headers) : null;
  }
  
  public GRPCHeaderMatch buildLastHeader() {
    return this.headers.get(headers.size() - 1).build();
  }
  
  public GRPCHeaderMatch buildMatchingHeader(Predicate<GRPCHeaderMatchBuilder> predicate) {
      for (GRPCHeaderMatchBuilder item : headers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GRPCMethodMatch buildMethod() {
    return this.method != null ? this.method.build() : null;
  }
  
  protected void copyInstance(GRPCRouteMatch instance) {
    instance = instance != null ? instance : new GRPCRouteMatch();
    if (instance != null) {
        this.withHeaders(instance.getHeaders());
        this.withMethod(instance.getMethod());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HeadersNested<A> editFirstHeader() {
    if (headers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "headers"));
    }
    return this.setNewHeaderLike(0, this.buildHeader(0));
  }
  
  public HeadersNested<A> editHeader(int index) {
    if (headers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "headers"));
    }
    return this.setNewHeaderLike(index, this.buildHeader(index));
  }
  
  public HeadersNested<A> editLastHeader() {
    int index = headers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "headers"));
    }
    return this.setNewHeaderLike(index, this.buildHeader(index));
  }
  
  public HeadersNested<A> editMatchingHeader(Predicate<GRPCHeaderMatchBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < headers.size();i++) {
      if (predicate.test(headers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "headers"));
    }
    return this.setNewHeaderLike(index, this.buildHeader(index));
  }
  
  public MethodNested<A> editMethod() {
    return this.withNewMethodLike(Optional.ofNullable(this.buildMethod()).orElse(null));
  }
  
  public MethodNested<A> editOrNewMethod() {
    return this.withNewMethodLike(Optional.ofNullable(this.buildMethod()).orElse(new GRPCMethodMatchBuilder().build()));
  }
  
  public MethodNested<A> editOrNewMethodLike(GRPCMethodMatch item) {
    return this.withNewMethodLike(Optional.ofNullable(this.buildMethod()).orElse(item));
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
    GRPCRouteMatchFluent that = (GRPCRouteMatchFluent) o;
    if (!(Objects.equals(headers, that.headers))) {
      return false;
    }
    if (!(Objects.equals(method, that.method))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHeaders() {
    return this.headers != null && !(this.headers.isEmpty());
  }
  
  public boolean hasMatchingHeader(Predicate<GRPCHeaderMatchBuilder> predicate) {
      for (GRPCHeaderMatchBuilder item : headers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMethod() {
    return this.method != null;
  }
  
  public int hashCode() {
    return Objects.hash(headers, method, additionalProperties);
  }
  
  public A removeAllFromHeaders(Collection<GRPCHeaderMatch> items) {
    if (this.headers == null) {
      return (A) this;
    }
    for (GRPCHeaderMatch item : items) {
        GRPCHeaderMatchBuilder builder = new GRPCHeaderMatchBuilder(item);
        _visitables.get("headers").remove(builder);
        this.headers.remove(builder);
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
  
  public A removeFromHeaders(GRPCHeaderMatch... items) {
    if (this.headers == null) {
      return (A) this;
    }
    for (GRPCHeaderMatch item : items) {
        GRPCHeaderMatchBuilder builder = new GRPCHeaderMatchBuilder(item);
        _visitables.get("headers").remove(builder);
        this.headers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHeaders(Predicate<GRPCHeaderMatchBuilder> predicate) {
    if (headers == null) {
      return (A) this;
    }
    Iterator<GRPCHeaderMatchBuilder> each = headers.iterator();
    List visitables = _visitables.get("headers");
    while (each.hasNext()) {
        GRPCHeaderMatchBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HeadersNested<A> setNewHeaderLike(int index,GRPCHeaderMatch item) {
    return new HeadersNested(index, item);
  }
  
  public A setToHeaders(int index,GRPCHeaderMatch item) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    GRPCHeaderMatchBuilder builder = new GRPCHeaderMatchBuilder(item);
    if (index < 0 || index >= headers.size()) {
        _visitables.get("headers").add(builder);
        headers.add(builder);
    } else {
        _visitables.get("headers").add(builder);
        headers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
  
  public A withHeaders(List<GRPCHeaderMatch> headers) {
    if (this.headers != null) {
      this._visitables.get("headers").clear();
    }
    if (headers != null) {
        this.headers = new ArrayList();
        for (GRPCHeaderMatch item : headers) {
          this.addToHeaders(item);
        }
    } else {
      this.headers = null;
    }
    return (A) this;
  }
  
  public A withHeaders(GRPCHeaderMatch... headers) {
    if (this.headers != null) {
        this.headers.clear();
        _visitables.remove("headers");
    }
    if (headers != null) {
      for (GRPCHeaderMatch item : headers) {
        this.addToHeaders(item);
      }
    }
    return (A) this;
  }
  
  public A withMethod(GRPCMethodMatch method) {
    this._visitables.remove("method");
    if (method != null) {
        this.method = new GRPCMethodMatchBuilder(method);
        this._visitables.get("method").add(this.method);
    } else {
        this.method = null;
        this._visitables.get("method").remove(this.method);
    }
    return (A) this;
  }
  
  public MethodNested<A> withNewMethod() {
    return new MethodNested(null);
  }
  
  public A withNewMethod(String method,String service,String type) {
    return (A) this.withMethod(new GRPCMethodMatch(method, service, type));
  }
  
  public MethodNested<A> withNewMethodLike(GRPCMethodMatch item) {
    return new MethodNested(item);
  }
  public class HeadersNested<N> extends GRPCHeaderMatchFluent<HeadersNested<N>> implements Nested<N>{
  
    GRPCHeaderMatchBuilder builder;
    int index;
  
    HeadersNested(int index,GRPCHeaderMatch item) {
      this.index = index;
      this.builder = new GRPCHeaderMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) GRPCRouteMatchFluent.this.setToHeaders(index, builder.build());
    }
    
    public N endHeader() {
      return and();
    }
    
  }
  public class MethodNested<N> extends GRPCMethodMatchFluent<MethodNested<N>> implements Nested<N>{
  
    GRPCMethodMatchBuilder builder;
  
    MethodNested(GRPCMethodMatch item) {
      this.builder = new GRPCMethodMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) GRPCRouteMatchFluent.this.withMethod(builder.build());
    }
    
    public N endMethod() {
      return and();
    }
    
  }
}