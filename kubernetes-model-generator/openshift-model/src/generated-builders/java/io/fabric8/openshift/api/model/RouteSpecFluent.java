package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class RouteSpecFluent<A extends io.fabric8.openshift.api.model.RouteSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<RouteTargetReferenceBuilder> alternateBackends = new ArrayList<RouteTargetReferenceBuilder>();
  private String host;
  private RouteHTTPHeadersBuilder httpHeaders;
  private String path;
  private RoutePortBuilder port;
  private String subdomain;
  private TLSConfigBuilder tls;
  private RouteTargetReferenceBuilder to;
  private String wildcardPolicy;

  public RouteSpecFluent() {
  }
  
  public RouteSpecFluent(RouteSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAlternateBackends(Collection<RouteTargetReference> items) {
    if (this.alternateBackends == null) {
      this.alternateBackends = new ArrayList();
    }
    for (RouteTargetReference item : items) {
        RouteTargetReferenceBuilder builder = new RouteTargetReferenceBuilder(item);
        _visitables.get("alternateBackends").add(builder);
        this.alternateBackends.add(builder);
    }
    return (A) this;
  }
  
  public AlternateBackendsNested<A> addNewAlternateBackend() {
    return new AlternateBackendsNested(-1, null);
  }
  
  public A addNewAlternateBackend(String kind,String name,Integer weight) {
    return (A) this.addToAlternateBackends(new RouteTargetReference(kind, name, weight));
  }
  
  public AlternateBackendsNested<A> addNewAlternateBackendLike(RouteTargetReference item) {
    return new AlternateBackendsNested(-1, item);
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
  
  public A addToAlternateBackends(RouteTargetReference... items) {
    if (this.alternateBackends == null) {
      this.alternateBackends = new ArrayList();
    }
    for (RouteTargetReference item : items) {
        RouteTargetReferenceBuilder builder = new RouteTargetReferenceBuilder(item);
        _visitables.get("alternateBackends").add(builder);
        this.alternateBackends.add(builder);
    }
    return (A) this;
  }
  
  public A addToAlternateBackends(int index,RouteTargetReference item) {
    if (this.alternateBackends == null) {
      this.alternateBackends = new ArrayList();
    }
    RouteTargetReferenceBuilder builder = new RouteTargetReferenceBuilder(item);
    if (index < 0 || index >= alternateBackends.size()) {
        _visitables.get("alternateBackends").add(builder);
        alternateBackends.add(builder);
    } else {
        _visitables.get("alternateBackends").add(builder);
        alternateBackends.add(index, builder);
    }
    return (A) this;
  }
  
  public RouteTargetReference buildAlternateBackend(int index) {
    return this.alternateBackends.get(index).build();
  }
  
  public List<RouteTargetReference> buildAlternateBackends() {
    return this.alternateBackends != null ? build(alternateBackends) : null;
  }
  
  public RouteTargetReference buildFirstAlternateBackend() {
    return this.alternateBackends.get(0).build();
  }
  
  public RouteHTTPHeaders buildHttpHeaders() {
    return this.httpHeaders != null ? this.httpHeaders.build() : null;
  }
  
  public RouteTargetReference buildLastAlternateBackend() {
    return this.alternateBackends.get(alternateBackends.size() - 1).build();
  }
  
  public RouteTargetReference buildMatchingAlternateBackend(Predicate<RouteTargetReferenceBuilder> predicate) {
      for (RouteTargetReferenceBuilder item : alternateBackends) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RoutePort buildPort() {
    return this.port != null ? this.port.build() : null;
  }
  
  public TLSConfig buildTls() {
    return this.tls != null ? this.tls.build() : null;
  }
  
  public RouteTargetReference buildTo() {
    return this.to != null ? this.to.build() : null;
  }
  
  protected void copyInstance(RouteSpec instance) {
    instance = instance != null ? instance : new RouteSpec();
    if (instance != null) {
        this.withAlternateBackends(instance.getAlternateBackends());
        this.withHost(instance.getHost());
        this.withHttpHeaders(instance.getHttpHeaders());
        this.withPath(instance.getPath());
        this.withPort(instance.getPort());
        this.withSubdomain(instance.getSubdomain());
        this.withTls(instance.getTls());
        this.withTo(instance.getTo());
        this.withWildcardPolicy(instance.getWildcardPolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AlternateBackendsNested<A> editAlternateBackend(int index) {
    if (alternateBackends.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "alternateBackends"));
    }
    return this.setNewAlternateBackendLike(index, this.buildAlternateBackend(index));
  }
  
  public AlternateBackendsNested<A> editFirstAlternateBackend() {
    if (alternateBackends.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "alternateBackends"));
    }
    return this.setNewAlternateBackendLike(0, this.buildAlternateBackend(0));
  }
  
  public HttpHeadersNested<A> editHttpHeaders() {
    return this.withNewHttpHeadersLike(Optional.ofNullable(this.buildHttpHeaders()).orElse(null));
  }
  
  public AlternateBackendsNested<A> editLastAlternateBackend() {
    int index = alternateBackends.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "alternateBackends"));
    }
    return this.setNewAlternateBackendLike(index, this.buildAlternateBackend(index));
  }
  
  public AlternateBackendsNested<A> editMatchingAlternateBackend(Predicate<RouteTargetReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < alternateBackends.size();i++) {
      if (predicate.test(alternateBackends.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "alternateBackends"));
    }
    return this.setNewAlternateBackendLike(index, this.buildAlternateBackend(index));
  }
  
  public HttpHeadersNested<A> editOrNewHttpHeaders() {
    return this.withNewHttpHeadersLike(Optional.ofNullable(this.buildHttpHeaders()).orElse(new RouteHTTPHeadersBuilder().build()));
  }
  
  public HttpHeadersNested<A> editOrNewHttpHeadersLike(RouteHTTPHeaders item) {
    return this.withNewHttpHeadersLike(Optional.ofNullable(this.buildHttpHeaders()).orElse(item));
  }
  
  public PortNested<A> editOrNewPort() {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(new RoutePortBuilder().build()));
  }
  
  public PortNested<A> editOrNewPortLike(RoutePort item) {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(item));
  }
  
  public TlsNested<A> editOrNewTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(new TLSConfigBuilder().build()));
  }
  
  public TlsNested<A> editOrNewTlsLike(TLSConfig item) {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(item));
  }
  
  public ToNested<A> editOrNewTo() {
    return this.withNewToLike(Optional.ofNullable(this.buildTo()).orElse(new RouteTargetReferenceBuilder().build()));
  }
  
  public ToNested<A> editOrNewToLike(RouteTargetReference item) {
    return this.withNewToLike(Optional.ofNullable(this.buildTo()).orElse(item));
  }
  
  public PortNested<A> editPort() {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(null));
  }
  
  public TlsNested<A> editTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(null));
  }
  
  public ToNested<A> editTo() {
    return this.withNewToLike(Optional.ofNullable(this.buildTo()).orElse(null));
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
    RouteSpecFluent that = (RouteSpecFluent) o;
    if (!(Objects.equals(alternateBackends, that.alternateBackends))) {
      return false;
    }
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
    if (!(Objects.equals(subdomain, that.subdomain))) {
      return false;
    }
    if (!(Objects.equals(tls, that.tls))) {
      return false;
    }
    if (!(Objects.equals(to, that.to))) {
      return false;
    }
    if (!(Objects.equals(wildcardPolicy, that.wildcardPolicy))) {
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
  
  public String getSubdomain() {
    return this.subdomain;
  }
  
  public String getWildcardPolicy() {
    return this.wildcardPolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAlternateBackends() {
    return this.alternateBackends != null && !(this.alternateBackends.isEmpty());
  }
  
  public boolean hasHost() {
    return this.host != null;
  }
  
  public boolean hasHttpHeaders() {
    return this.httpHeaders != null;
  }
  
  public boolean hasMatchingAlternateBackend(Predicate<RouteTargetReferenceBuilder> predicate) {
      for (RouteTargetReferenceBuilder item : alternateBackends) {
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
  
  public boolean hasSubdomain() {
    return this.subdomain != null;
  }
  
  public boolean hasTls() {
    return this.tls != null;
  }
  
  public boolean hasTo() {
    return this.to != null;
  }
  
  public boolean hasWildcardPolicy() {
    return this.wildcardPolicy != null;
  }
  
  public int hashCode() {
    return Objects.hash(alternateBackends, host, httpHeaders, path, port, subdomain, tls, to, wildcardPolicy, additionalProperties);
  }
  
  public A removeAllFromAlternateBackends(Collection<RouteTargetReference> items) {
    if (this.alternateBackends == null) {
      return (A) this;
    }
    for (RouteTargetReference item : items) {
        RouteTargetReferenceBuilder builder = new RouteTargetReferenceBuilder(item);
        _visitables.get("alternateBackends").remove(builder);
        this.alternateBackends.remove(builder);
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
  
  public A removeFromAlternateBackends(RouteTargetReference... items) {
    if (this.alternateBackends == null) {
      return (A) this;
    }
    for (RouteTargetReference item : items) {
        RouteTargetReferenceBuilder builder = new RouteTargetReferenceBuilder(item);
        _visitables.get("alternateBackends").remove(builder);
        this.alternateBackends.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAlternateBackends(Predicate<RouteTargetReferenceBuilder> predicate) {
    if (alternateBackends == null) {
      return (A) this;
    }
    Iterator<RouteTargetReferenceBuilder> each = alternateBackends.iterator();
    List visitables = _visitables.get("alternateBackends");
    while (each.hasNext()) {
        RouteTargetReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AlternateBackendsNested<A> setNewAlternateBackendLike(int index,RouteTargetReference item) {
    return new AlternateBackendsNested(index, item);
  }
  
  public A setToAlternateBackends(int index,RouteTargetReference item) {
    if (this.alternateBackends == null) {
      this.alternateBackends = new ArrayList();
    }
    RouteTargetReferenceBuilder builder = new RouteTargetReferenceBuilder(item);
    if (index < 0 || index >= alternateBackends.size()) {
        _visitables.get("alternateBackends").add(builder);
        alternateBackends.add(builder);
    } else {
        _visitables.get("alternateBackends").add(builder);
        alternateBackends.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(alternateBackends == null) && !(alternateBackends.isEmpty())) {
        sb.append("alternateBackends:");
        sb.append(alternateBackends);
        sb.append(",");
    }
    if (!(host == null)) {
        sb.append("host:");
        sb.append(host);
        sb.append(",");
    }
    if (!(httpHeaders == null)) {
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
    if (!(subdomain == null)) {
        sb.append("subdomain:");
        sb.append(subdomain);
        sb.append(",");
    }
    if (!(tls == null)) {
        sb.append("tls:");
        sb.append(tls);
        sb.append(",");
    }
    if (!(to == null)) {
        sb.append("to:");
        sb.append(to);
        sb.append(",");
    }
    if (!(wildcardPolicy == null)) {
        sb.append("wildcardPolicy:");
        sb.append(wildcardPolicy);
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
  
  public A withAlternateBackends(List<RouteTargetReference> alternateBackends) {
    if (this.alternateBackends != null) {
      this._visitables.get("alternateBackends").clear();
    }
    if (alternateBackends != null) {
        this.alternateBackends = new ArrayList();
        for (RouteTargetReference item : alternateBackends) {
          this.addToAlternateBackends(item);
        }
    } else {
      this.alternateBackends = null;
    }
    return (A) this;
  }
  
  public A withAlternateBackends(RouteTargetReference... alternateBackends) {
    if (this.alternateBackends != null) {
        this.alternateBackends.clear();
        _visitables.remove("alternateBackends");
    }
    if (alternateBackends != null) {
      for (RouteTargetReference item : alternateBackends) {
        this.addToAlternateBackends(item);
      }
    }
    return (A) this;
  }
  
  public A withHost(String host) {
    this.host = host;
    return (A) this;
  }
  
  public A withHttpHeaders(RouteHTTPHeaders httpHeaders) {
    this._visitables.remove("httpHeaders");
    if (httpHeaders != null) {
        this.httpHeaders = new RouteHTTPHeadersBuilder(httpHeaders);
        this._visitables.get("httpHeaders").add(this.httpHeaders);
    } else {
        this.httpHeaders = null;
        this._visitables.get("httpHeaders").remove(this.httpHeaders);
    }
    return (A) this;
  }
  
  public HttpHeadersNested<A> withNewHttpHeaders() {
    return new HttpHeadersNested(null);
  }
  
  public HttpHeadersNested<A> withNewHttpHeadersLike(RouteHTTPHeaders item) {
    return new HttpHeadersNested(item);
  }
  
  public PortNested<A> withNewPort() {
    return new PortNested(null);
  }
  
  public PortNested<A> withNewPortLike(RoutePort item) {
    return new PortNested(item);
  }
  
  public TlsNested<A> withNewTls() {
    return new TlsNested(null);
  }
  
  public TlsNested<A> withNewTlsLike(TLSConfig item) {
    return new TlsNested(item);
  }
  
  public ToNested<A> withNewTo() {
    return new ToNested(null);
  }
  
  public A withNewTo(String kind,String name,Integer weight) {
    return (A) this.withTo(new RouteTargetReference(kind, name, weight));
  }
  
  public ToNested<A> withNewToLike(RouteTargetReference item) {
    return new ToNested(item);
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withPort(RoutePort port) {
    this._visitables.remove("port");
    if (port != null) {
        this.port = new RoutePortBuilder(port);
        this._visitables.get("port").add(this.port);
    } else {
        this.port = null;
        this._visitables.get("port").remove(this.port);
    }
    return (A) this;
  }
  
  public A withSubdomain(String subdomain) {
    this.subdomain = subdomain;
    return (A) this;
  }
  
  public A withTls(TLSConfig tls) {
    this._visitables.remove("tls");
    if (tls != null) {
        this.tls = new TLSConfigBuilder(tls);
        this._visitables.get("tls").add(this.tls);
    } else {
        this.tls = null;
        this._visitables.get("tls").remove(this.tls);
    }
    return (A) this;
  }
  
  public A withTo(RouteTargetReference to) {
    this._visitables.remove("to");
    if (to != null) {
        this.to = new RouteTargetReferenceBuilder(to);
        this._visitables.get("to").add(this.to);
    } else {
        this.to = null;
        this._visitables.get("to").remove(this.to);
    }
    return (A) this;
  }
  
  public A withWildcardPolicy(String wildcardPolicy) {
    this.wildcardPolicy = wildcardPolicy;
    return (A) this;
  }
  public class AlternateBackendsNested<N> extends RouteTargetReferenceFluent<AlternateBackendsNested<N>> implements Nested<N>{
  
    RouteTargetReferenceBuilder builder;
    int index;
  
    AlternateBackendsNested(int index,RouteTargetReference item) {
      this.index = index;
      this.builder = new RouteTargetReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) RouteSpecFluent.this.setToAlternateBackends(index, builder.build());
    }
    
    public N endAlternateBackend() {
      return and();
    }
    
  }
  public class HttpHeadersNested<N> extends RouteHTTPHeadersFluent<HttpHeadersNested<N>> implements Nested<N>{
  
    RouteHTTPHeadersBuilder builder;
  
    HttpHeadersNested(RouteHTTPHeaders item) {
      this.builder = new RouteHTTPHeadersBuilder(this, item);
    }
  
    public N and() {
      return (N) RouteSpecFluent.this.withHttpHeaders(builder.build());
    }
    
    public N endHttpHeaders() {
      return and();
    }
    
  }
  public class PortNested<N> extends RoutePortFluent<PortNested<N>> implements Nested<N>{
  
    RoutePortBuilder builder;
  
    PortNested(RoutePort item) {
      this.builder = new RoutePortBuilder(this, item);
    }
  
    public N and() {
      return (N) RouteSpecFluent.this.withPort(builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
  public class TlsNested<N> extends TLSConfigFluent<TlsNested<N>> implements Nested<N>{
  
    TLSConfigBuilder builder;
  
    TlsNested(TLSConfig item) {
      this.builder = new TLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) RouteSpecFluent.this.withTls(builder.build());
    }
    
    public N endTls() {
      return and();
    }
    
  }
  public class ToNested<N> extends RouteTargetReferenceFluent<ToNested<N>> implements Nested<N>{
  
    RouteTargetReferenceBuilder builder;
  
    ToNested(RouteTargetReference item) {
      this.builder = new RouteTargetReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) RouteSpecFluent.this.withTo(builder.build());
    }
    
    public N endTo() {
      return and();
    }
    
  }
}