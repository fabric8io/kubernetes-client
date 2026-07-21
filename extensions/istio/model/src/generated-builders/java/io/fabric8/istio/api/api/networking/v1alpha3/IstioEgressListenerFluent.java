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
public class IstioEgressListenerFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.IstioEgressListenerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String bind;
  private CaptureMode captureMode;
  private List<String> hosts = new ArrayList<String>();
  private SidecarPortBuilder port;

  public IstioEgressListenerFluent() {
  }
  
  public IstioEgressListenerFluent(IstioEgressListener instance) {
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
  
  public SidecarPort buildPort() {
    return this.port != null ? this.port.build() : null;
  }
  
  protected void copyInstance(IstioEgressListener instance) {
    instance = instance != null ? instance : new IstioEgressListener();
    if (instance != null) {
        this.withBind(instance.getBind());
        this.withCaptureMode(instance.getCaptureMode());
        this.withHosts(instance.getHosts());
        this.withPort(instance.getPort());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PortNested<A> editOrNewPort() {
    return this.withNewPortLike(Optional.ofNullable(this.buildPort()).orElse(new SidecarPortBuilder().build()));
  }
  
  public PortNested<A> editOrNewPortLike(SidecarPort item) {
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
    IstioEgressListenerFluent that = (IstioEgressListenerFluent) o;
    if (!(Objects.equals(bind, that.bind))) {
      return false;
    }
    if (!(Objects.equals(captureMode, that.captureMode))) {
      return false;
    }
    if (!(Objects.equals(hosts, that.hosts))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
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
  
  public CaptureMode getCaptureMode() {
    return this.captureMode;
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBind() {
    return this.bind != null;
  }
  
  public boolean hasCaptureMode() {
    return this.captureMode != null;
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
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public int hashCode() {
    return Objects.hash(bind, captureMode, hosts, port, additionalProperties);
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
    if (!(captureMode == null)) {
        sb.append("captureMode:");
        sb.append(captureMode);
        sb.append(",");
    }
    if (!(hosts == null) && !(hosts.isEmpty())) {
        sb.append("hosts:");
        sb.append(hosts);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
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
  
  public A withCaptureMode(CaptureMode captureMode) {
    this.captureMode = captureMode;
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
  
  public PortNested<A> withNewPort() {
    return new PortNested(null);
  }
  
  public A withNewPort(String name,Long number,String protocol,Long targetPort) {
    return (A) this.withPort(new SidecarPort(name, number, protocol, targetPort));
  }
  
  public PortNested<A> withNewPortLike(SidecarPort item) {
    return new PortNested(item);
  }
  
  public A withPort(SidecarPort port) {
    this._visitables.remove("port");
    if (port != null) {
        this.port = new SidecarPortBuilder(port);
        this._visitables.get("port").add(this.port);
    } else {
        this.port = null;
        this._visitables.get("port").remove(this.port);
    }
    return (A) this;
  }
  public class PortNested<N> extends SidecarPortFluent<PortNested<N>> implements Nested<N>{
  
    SidecarPortBuilder builder;
  
    PortNested(SidecarPort item) {
      this.builder = new SidecarPortBuilder(this, item);
    }
  
    public N and() {
      return (N) IstioEgressListenerFluent.this.withPort(builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
}