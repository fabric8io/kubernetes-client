package io.fabric8.kubernetes.api.model;

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
public class HTTPGetActionFluent<A extends io.fabric8.kubernetes.api.model.HTTPGetActionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String host;
  private ArrayList<HTTPHeaderBuilder> httpHeaders = new ArrayList<HTTPHeaderBuilder>();
  private String path;
  private IntOrStringBuilder port;
  private String scheme;

  public HTTPGetActionFluent() {
  }
  
  public HTTPGetActionFluent(HTTPGetAction instance) {
    this.copyInstance(instance);
  }

  public A addAllToHttpHeaders(Collection<HTTPHeader> items) {
    if (this.httpHeaders == null) {
      this.httpHeaders = new ArrayList();
    }
    for (HTTPHeader item : items) {
        HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
        _visitables.get("httpHeaders").add(builder);
        this.httpHeaders.add(builder);
    }
    return (A) this;
  }
  
  public HttpHeadersNested<A> addNewHttpHeader() {
    return new HttpHeadersNested(-1, null);
  }
  
  public A addNewHttpHeader(String name,String value) {
    return (A) this.addToHttpHeaders(new HTTPHeader(name, value));
  }
  
  public HttpHeadersNested<A> addNewHttpHeaderLike(HTTPHeader item) {
    return new HttpHeadersNested(-1, item);
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
  
  public A addToHttpHeaders(HTTPHeader... items) {
    if (this.httpHeaders == null) {
      this.httpHeaders = new ArrayList();
    }
    for (HTTPHeader item : items) {
        HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
        _visitables.get("httpHeaders").add(builder);
        this.httpHeaders.add(builder);
    }
    return (A) this;
  }
  
  public A addToHttpHeaders(int index,HTTPHeader item) {
    if (this.httpHeaders == null) {
      this.httpHeaders = new ArrayList();
    }
    HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
    if (index < 0 || index >= httpHeaders.size()) {
        _visitables.get("httpHeaders").add(builder);
        httpHeaders.add(builder);
    } else {
        _visitables.get("httpHeaders").add(builder);
        httpHeaders.add(index, builder);
    }
    return (A) this;
  }
  
  public HTTPHeader buildFirstHttpHeader() {
    return this.httpHeaders.get(0).build();
  }
  
  public HTTPHeader buildHttpHeader(int index) {
    return this.httpHeaders.get(index).build();
  }
  
  public List<HTTPHeader> buildHttpHeaders() {
    return this.httpHeaders != null ? build(httpHeaders) : null;
  }
  
  public HTTPHeader buildLastHttpHeader() {
    return this.httpHeaders.get(httpHeaders.size() - 1).build();
  }
  
  public HTTPHeader buildMatchingHttpHeader(Predicate<HTTPHeaderBuilder> predicate) {
      for (HTTPHeaderBuilder item : httpHeaders) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public IntOrString buildPort() {
    return this.port != null ? this.port.build() : null;
  }
  
  protected void copyInstance(HTTPGetAction instance) {
    instance = instance != null ? instance : new HTTPGetAction();
    if (instance != null) {
        this.withHost(instance.getHost());
        this.withHttpHeaders(instance.getHttpHeaders());
        this.withPath(instance.getPath());
        this.withPort(instance.getPort());
        this.withScheme(instance.getScheme());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HttpHeadersNested<A> editFirstHttpHeader() {
    if (httpHeaders.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "httpHeaders"));
    }
    return this.setNewHttpHeaderLike(0, this.buildHttpHeader(0));
  }
  
  public HttpHeadersNested<A> editHttpHeader(int index) {
    if (httpHeaders.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "httpHeaders"));
    }
    return this.setNewHttpHeaderLike(index, this.buildHttpHeader(index));
  }
  
  public HttpHeadersNested<A> editLastHttpHeader() {
    int index = httpHeaders.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "httpHeaders"));
    }
    return this.setNewHttpHeaderLike(index, this.buildHttpHeader(index));
  }
  
  public HttpHeadersNested<A> editMatchingHttpHeader(Predicate<HTTPHeaderBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < httpHeaders.size();i++) {
      if (predicate.test(httpHeaders.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "httpHeaders"));
    }
    return this.setNewHttpHeaderLike(index, this.buildHttpHeader(index));
  }
  
  public PortNested<A> editOrNewPort() {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(new IntOrStringBuilder().build()));
  }
  
  public PortNested<A> editOrNewPortLike(IntOrString item) {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(item));
  }
  
  public PortNested<A> editPort() {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(null));
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
    HTTPGetActionFluent that = (HTTPGetActionFluent) o;
    if (!(Objects.equals(host, that.host))) {
      return false;
    }
    if (!(Objects.equals(httpHeaders, that.httpHeaders))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(scheme, that.scheme))) {
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
  
  public String getHost() {
    return this.host;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public String getScheme() {
    return this.scheme;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHost() {
    return this.host != null;
  }
  
  public boolean hasHttpHeaders() {
    return this.httpHeaders != null && !(this.httpHeaders.isEmpty());
  }
  
  public boolean hasMatchingHttpHeader(Predicate<HTTPHeaderBuilder> predicate) {
      for (HTTPHeaderBuilder item : httpHeaders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasScheme() {
    return this.scheme != null;
  }
  
  public int hashCode() {
    return Objects.hash(host, httpHeaders, path, port, scheme, additionalProperties);
  }
  
  public A removeAllFromHttpHeaders(Collection<HTTPHeader> items) {
    if (this.httpHeaders == null) {
      return (A) this;
    }
    for (HTTPHeader item : items) {
        HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
        _visitables.get("httpHeaders").remove(builder);
        this.httpHeaders.remove(builder);
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
  
  public A removeFromHttpHeaders(HTTPHeader... items) {
    if (this.httpHeaders == null) {
      return (A) this;
    }
    for (HTTPHeader item : items) {
        HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
        _visitables.get("httpHeaders").remove(builder);
        this.httpHeaders.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHttpHeaders(Predicate<HTTPHeaderBuilder> predicate) {
    if (httpHeaders == null) {
      return (A) this;
    }
    Iterator<HTTPHeaderBuilder> each = httpHeaders.iterator();
    List visitables = _visitables.get("httpHeaders");
    while (each.hasNext()) {
        HTTPHeaderBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HttpHeadersNested<A> setNewHttpHeaderLike(int index,HTTPHeader item) {
    return new HttpHeadersNested(index, item);
  }
  
  public A setToHttpHeaders(int index,HTTPHeader item) {
    if (this.httpHeaders == null) {
      this.httpHeaders = new ArrayList();
    }
    HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
    if (index < 0 || index >= httpHeaders.size()) {
        _visitables.get("httpHeaders").add(builder);
        httpHeaders.add(builder);
    } else {
        _visitables.get("httpHeaders").add(builder);
        httpHeaders.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(host == null)) {
        sb.append("host:");
        sb.append(host);
        sb.append(",");
    }
    if (!(httpHeaders == null) && !(httpHeaders.isEmpty())) {
        sb.append("httpHeaders:");
        sb.append(httpHeaders);
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
    if (!(scheme == null)) {
        sb.append("scheme:");
        sb.append(scheme);
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
  
  public A withHost(String host) {
    this.host = host;
    return (A) this;
  }
  
  public A withHttpHeaders(List<HTTPHeader> httpHeaders) {
    if (this.httpHeaders != null) {
      this._visitables.get("httpHeaders").clear();
    }
    if (httpHeaders != null) {
        this.httpHeaders = new ArrayList();
        for (HTTPHeader item : httpHeaders) {
          this.addToHttpHeaders(item);
        }
    } else {
      this.httpHeaders = null;
    }
    return (A) this;
  }
  
  public A withHttpHeaders(HTTPHeader... httpHeaders) {
    if (this.httpHeaders != null) {
        this.httpHeaders.clear();
        _visitables.remove("httpHeaders");
    }
    if (httpHeaders != null) {
      for (HTTPHeader item : httpHeaders) {
        this.addToHttpHeaders(item);
      }
    }
    return (A) this;
  }
  
  public PortNested<A> withNewPort() {
    return new PortNested(null);
  }
  
  public A withNewPort(Object value) {
    return (A) this.withPort(new IntOrString(value));
  }
  
  public PortNested<A> withNewPortLike(IntOrString item) {
    return new PortNested(item);
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withPort(IntOrString port) {
    this._visitables.remove("port");
    if (port != null) {
        this.port = new IntOrStringBuilder(port);
        this._visitables.get("port").add(this.port);
    } else {
        this.port = null;
        this._visitables.get("port").remove(this.port);
    }
    return (A) this;
  }
  
  public A withScheme(String scheme) {
    this.scheme = scheme;
    return (A) this;
  }
  public class HttpHeadersNested<N> extends HTTPHeaderFluent<HttpHeadersNested<N>> implements Nested<N>{
  
    HTTPHeaderBuilder builder;
    int index;
  
    HttpHeadersNested(int index,HTTPHeader item) {
      this.index = index;
      this.builder = new HTTPHeaderBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPGetActionFluent.this.setToHttpHeaders(index, builder.build());
    }
    
    public N endHttpHeader() {
      return and();
    }
    
  }
  public class PortNested<N> extends IntOrStringFluent<PortNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    PortNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPGetActionFluent.this.withPort(builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
}