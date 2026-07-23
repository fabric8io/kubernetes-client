package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
public class ListenerFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.ListenerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AllowedRoutesBuilder allowedRoutes;
  private String hostname;
  private String name;
  private Integer port;
  private String protocol;
  private ListenerTLSConfigBuilder tls;

  public ListenerFluent() {
  }
  
  public ListenerFluent(Listener instance) {
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
  
  public AllowedRoutes buildAllowedRoutes() {
    return this.allowedRoutes != null ? this.allowedRoutes.build() : null;
  }
  
  public ListenerTLSConfig buildTls() {
    return this.tls != null ? this.tls.build() : null;
  }
  
  protected void copyInstance(Listener instance) {
    instance = instance != null ? instance : new Listener();
    if (instance != null) {
        this.withAllowedRoutes(instance.getAllowedRoutes());
        this.withHostname(instance.getHostname());
        this.withName(instance.getName());
        this.withPort(instance.getPort());
        this.withProtocol(instance.getProtocol());
        this.withTls(instance.getTls());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AllowedRoutesNested<A> editAllowedRoutes() {
    return this.withNewAllowedRoutesLike(Optional.ofNullable(this.buildAllowedRoutes()).orElse(null));
  }
  
  public AllowedRoutesNested<A> editOrNewAllowedRoutes() {
    return this.withNewAllowedRoutesLike(Optional.ofNullable(this.buildAllowedRoutes()).orElse(new AllowedRoutesBuilder().build()));
  }
  
  public AllowedRoutesNested<A> editOrNewAllowedRoutesLike(AllowedRoutes item) {
    return this.withNewAllowedRoutesLike(Optional.ofNullable(this.buildAllowedRoutes()).orElse(item));
  }
  
  public TlsNested<A> editOrNewTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(new ListenerTLSConfigBuilder().build()));
  }
  
  public TlsNested<A> editOrNewTlsLike(ListenerTLSConfig item) {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(item));
  }
  
  public TlsNested<A> editTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(null));
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
    ListenerFluent that = (ListenerFluent) o;
    if (!(Objects.equals(allowedRoutes, that.allowedRoutes))) {
      return false;
    }
    if (!(Objects.equals(hostname, that.hostname))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(protocol, that.protocol))) {
      return false;
    }
    if (!(Objects.equals(tls, that.tls))) {
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
  
  public String getHostname() {
    return this.hostname;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public String getProtocol() {
    return this.protocol;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowedRoutes() {
    return this.allowedRoutes != null;
  }
  
  public boolean hasHostname() {
    return this.hostname != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasProtocol() {
    return this.protocol != null;
  }
  
  public boolean hasTls() {
    return this.tls != null;
  }
  
  public int hashCode() {
    return Objects.hash(allowedRoutes, hostname, name, port, protocol, tls, additionalProperties);
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
    if (!(allowedRoutes == null)) {
        sb.append("allowedRoutes:");
        sb.append(allowedRoutes);
        sb.append(",");
    }
    if (!(hostname == null)) {
        sb.append("hostname:");
        sb.append(hostname);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(protocol == null)) {
        sb.append("protocol:");
        sb.append(protocol);
        sb.append(",");
    }
    if (!(tls == null)) {
        sb.append("tls:");
        sb.append(tls);
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
  
  public A withAllowedRoutes(AllowedRoutes allowedRoutes) {
    this._visitables.remove("allowedRoutes");
    if (allowedRoutes != null) {
        this.allowedRoutes = new AllowedRoutesBuilder(allowedRoutes);
        this._visitables.get("allowedRoutes").add(this.allowedRoutes);
    } else {
        this.allowedRoutes = null;
        this._visitables.get("allowedRoutes").remove(this.allowedRoutes);
    }
    return (A) this;
  }
  
  public A withHostname(String hostname) {
    this.hostname = hostname;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public AllowedRoutesNested<A> withNewAllowedRoutes() {
    return new AllowedRoutesNested(null);
  }
  
  public AllowedRoutesNested<A> withNewAllowedRoutesLike(AllowedRoutes item) {
    return new AllowedRoutesNested(item);
  }
  
  public TlsNested<A> withNewTls() {
    return new TlsNested(null);
  }
  
  public TlsNested<A> withNewTlsLike(ListenerTLSConfig item) {
    return new TlsNested(item);
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
  public A withProtocol(String protocol) {
    this.protocol = protocol;
    return (A) this;
  }
  
  public A withTls(ListenerTLSConfig tls) {
    this._visitables.remove("tls");
    if (tls != null) {
        this.tls = new ListenerTLSConfigBuilder(tls);
        this._visitables.get("tls").add(this.tls);
    } else {
        this.tls = null;
        this._visitables.get("tls").remove(this.tls);
    }
    return (A) this;
  }
  public class AllowedRoutesNested<N> extends AllowedRoutesFluent<AllowedRoutesNested<N>> implements Nested<N>{
  
    AllowedRoutesBuilder builder;
  
    AllowedRoutesNested(AllowedRoutes item) {
      this.builder = new AllowedRoutesBuilder(this, item);
    }
  
    public N and() {
      return (N) ListenerFluent.this.withAllowedRoutes(builder.build());
    }
    
    public N endAllowedRoutes() {
      return and();
    }
    
  }
  public class TlsNested<N> extends ListenerTLSConfigFluent<TlsNested<N>> implements Nested<N>{
  
    ListenerTLSConfigBuilder builder;
  
    TlsNested(ListenerTLSConfig item) {
      this.builder = new ListenerTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ListenerFluent.this.withTls(builder.build());
    }
    
    public N endTls() {
      return and();
    }
    
  }
}