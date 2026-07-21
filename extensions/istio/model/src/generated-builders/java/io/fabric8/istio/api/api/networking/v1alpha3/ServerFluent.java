package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class ServerFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ServerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String bind;
  private String defaultEndpoint;
  private List<String> hosts = new ArrayList<String>();
  private String name;
  private PortBuilder port;
  private ServerTLSSettingsBuilder tls;

  public ServerFluent() {
  }
  
  public ServerFluent(Server instance) {
    this.copyInstance(instance);
  }

  public A addAllToHosts(Collection<String> items) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    for (String item : items) {
      this.hosts.add(item);
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
  
  public A addToHosts(String... items) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    for (String item : items) {
      this.hosts.add(item);
    }
    return (A) this;
  }
  
  public A addToHosts(int index,String item) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    this.hosts.add(index, item);
    return (A) this;
  }
  
  public Port buildPort() {
    return this.port != null ? this.port.build() : null;
  }
  
  public ServerTLSSettings buildTls() {
    return this.tls != null ? this.tls.build() : null;
  }
  
  protected void copyInstance(Server instance) {
    instance = instance != null ? instance : new Server();
    if (instance != null) {
        this.withBind(instance.getBind());
        this.withDefaultEndpoint(instance.getDefaultEndpoint());
        this.withHosts(instance.getHosts());
        this.withName(instance.getName());
        this.withPort(instance.getPort());
        this.withTls(instance.getTls());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PortNested<A> editOrNewPort() {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(new PortBuilder().build()));
  }
  
  public PortNested<A> editOrNewPortLike(Port item) {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(item));
  }
  
  public TlsNested<A> editOrNewTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(new ServerTLSSettingsBuilder().build()));
  }
  
  public TlsNested<A> editOrNewTlsLike(ServerTLSSettings item) {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(item));
  }
  
  public PortNested<A> editPort() {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(null));
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
    ServerFluent that = (ServerFluent) o;
    if (!(Objects.equals(bind, that.bind))) {
      return false;
    }
    if (!(Objects.equals(defaultEndpoint, that.defaultEndpoint))) {
      return false;
    }
    if (!(Objects.equals(hosts, that.hosts))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
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
  
  public String getBind() {
    return this.bind;
  }
  
  public String getDefaultEndpoint() {
    return this.defaultEndpoint;
  }
  
  public String getFirstHost() {
    return this.hosts.get(0);
  }
  
  public String getHost(int index) {
    return this.hosts.get(index);
  }
  
  public List<String> getHosts() {
    return this.hosts;
  }
  
  public String getLastHost() {
    return this.hosts.get(hosts.size() - 1);
  }
  
  public String getMatchingHost(Predicate<String> predicate) {
      for (String item : hosts) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBind() {
    return this.bind != null;
  }
  
  public boolean hasDefaultEndpoint() {
    return this.defaultEndpoint != null;
  }
  
  public boolean hasHosts() {
    return this.hosts != null && !(this.hosts.isEmpty());
  }
  
  public boolean hasMatchingHost(Predicate<String> predicate) {
      for (String item : hosts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasTls() {
    return this.tls != null;
  }
  
  public int hashCode() {
    return Objects.hash(bind, defaultEndpoint, hosts, name, port, tls, additionalProperties);
  }
  
  public A removeAllFromHosts(Collection<String> items) {
    if (this.hosts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.hosts.remove(item);
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
  
  public A removeFromHosts(String... items) {
    if (this.hosts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.hosts.remove(item);
    }
    return (A) this;
  }
  
  public A setToHosts(int index,String item) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    this.hosts.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(bind == null)) {
        sb.append("bind:");
        sb.append(bind);
        sb.append(",");
    }
    if (!(defaultEndpoint == null)) {
        sb.append("defaultEndpoint:");
        sb.append(defaultEndpoint);
        sb.append(",");
    }
    if (!(hosts == null) && !(hosts.isEmpty())) {
        sb.append("hosts:");
        sb.append(hosts);
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
  
  public A withBind(String bind) {
    this.bind = bind;
    return (A) this;
  }
  
  public A withDefaultEndpoint(String defaultEndpoint) {
    this.defaultEndpoint = defaultEndpoint;
    return (A) this;
  }
  
  public A withHosts(List<String> hosts) {
    if (hosts != null) {
        this.hosts = new ArrayList();
        for (String item : hosts) {
          this.addToHosts(item);
        }
    } else {
      this.hosts = null;
    }
    return (A) this;
  }
  
  public A withHosts(String... hosts) {
    if (this.hosts != null) {
        this.hosts.clear();
        _visitables.remove("hosts");
    }
    if (hosts != null) {
      for (String item : hosts) {
        this.addToHosts(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public PortNested<A> withNewPort() {
    return new PortNested(null);
  }
  
  public A withNewPort(String name,Long number,String protocol,Long targetPort) {
    return (A) this.withPort(new Port(name, number, protocol, targetPort));
  }
  
  public PortNested<A> withNewPortLike(Port item) {
    return new PortNested(item);
  }
  
  public TlsNested<A> withNewTls() {
    return new TlsNested(null);
  }
  
  public TlsNested<A> withNewTlsLike(ServerTLSSettings item) {
    return new TlsNested(item);
  }
  
  public A withPort(Port port) {
    this._visitables.remove("port");
    if (port != null) {
        this.port = new PortBuilder(port);
        this._visitables.get("port").add(this.port);
    } else {
        this.port = null;
        this._visitables.get("port").remove(this.port);
    }
    return (A) this;
  }
  
  public A withTls(ServerTLSSettings tls) {
    this._visitables.remove("tls");
    if (tls != null) {
        this.tls = new ServerTLSSettingsBuilder(tls);
        this._visitables.get("tls").add(this.tls);
    } else {
        this.tls = null;
        this._visitables.get("tls").remove(this.tls);
    }
    return (A) this;
  }
  public class PortNested<N> extends PortFluent<PortNested<N>> implements Nested<N>{
  
    PortBuilder builder;
  
    PortNested(Port item) {
      this.builder = new PortBuilder(this, item);
    }
  
    public N and() {
      return (N) ServerFluent.this.withPort(builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
  public class TlsNested<N> extends ServerTLSSettingsFluent<TlsNested<N>> implements Nested<N>{
  
    ServerTLSSettingsBuilder builder;
  
    TlsNested(ServerTLSSettings item) {
      this.builder = new ServerTLSSettingsBuilder(this, item);
    }
  
    public N and() {
      return (N) ServerFluent.this.withTls(builder.build());
    }
    
    public N endTls() {
      return and();
    }
    
  }
}