package io.fabric8.kubernetes.api.model;

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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class LoadBalancerIngressFluent<A extends io.fabric8.kubernetes.api.model.LoadBalancerIngressFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String hostname;
  private String ip;
  private String ipMode;
  private ArrayList<PortStatusBuilder> ports = new ArrayList<PortStatusBuilder>();

  public LoadBalancerIngressFluent() {
  }
  
  public LoadBalancerIngressFluent(LoadBalancerIngress instance) {
    this.copyInstance(instance);
  }

  public A addAllToPorts(Collection<PortStatus> items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (PortStatus item : items) {
        PortStatusBuilder builder = new PortStatusBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public PortsNested<A> addNewPort() {
    return new PortsNested(-1, null);
  }
  
  public A addNewPort(String error,Integer port,String protocol) {
    return (A) this.addToPorts(new PortStatus(error, port, protocol));
  }
  
  public PortsNested<A> addNewPortLike(PortStatus item) {
    return new PortsNested(-1, item);
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
  
  public A addToPorts(PortStatus... items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (PortStatus item : items) {
        PortStatusBuilder builder = new PortStatusBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public A addToPorts(int index,PortStatus item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    PortStatusBuilder builder = new PortStatusBuilder(item);
    if (index < 0 || index >= ports.size()) {
        _visitables.get("ports").add(builder);
        ports.add(builder);
    } else {
        _visitables.get("ports").add(builder);
        ports.add(index, builder);
    }
    return (A) this;
  }
  
  public PortStatus buildFirstPort() {
    return this.ports.get(0).build();
  }
  
  public PortStatus buildLastPort() {
    return this.ports.get(ports.size() - 1).build();
  }
  
  public PortStatus buildMatchingPort(Predicate<PortStatusBuilder> predicate) {
      for (PortStatusBuilder item : ports) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PortStatus buildPort(int index) {
    return this.ports.get(index).build();
  }
  
  public List<PortStatus> buildPorts() {
    return this.ports != null ? build(ports) : null;
  }
  
  protected void copyInstance(LoadBalancerIngress instance) {
    instance = instance != null ? instance : new LoadBalancerIngress();
    if (instance != null) {
        this.withHostname(instance.getHostname());
        this.withIp(instance.getIp());
        this.withIpMode(instance.getIpMode());
        this.withPorts(instance.getPorts());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PortsNested<A> editFirstPort() {
    if (ports.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(0, this.buildPort(0));
  }
  
  public PortsNested<A> editLastPort() {
    int index = ports.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public PortsNested<A> editMatchingPort(Predicate<PortStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ports.size();i++) {
      if (predicate.test(ports.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public PortsNested<A> editPort(int index) {
    if (ports.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
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
    LoadBalancerIngressFluent that = (LoadBalancerIngressFluent) o;
    if (!(Objects.equals(hostname, that.hostname))) {
      return false;
    }
    if (!(Objects.equals(ip, that.ip))) {
      return false;
    }
    if (!(Objects.equals(ipMode, that.ipMode))) {
      return false;
    }
    if (!(Objects.equals(ports, that.ports))) {
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
  
  public String getIp() {
    return this.ip;
  }
  
  public String getIpMode() {
    return this.ipMode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHostname() {
    return this.hostname != null;
  }
  
  public boolean hasIp() {
    return this.ip != null;
  }
  
  public boolean hasIpMode() {
    return this.ipMode != null;
  }
  
  public boolean hasMatchingPort(Predicate<PortStatusBuilder> predicate) {
      for (PortStatusBuilder item : ports) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPorts() {
    return this.ports != null && !(this.ports.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(hostname, ip, ipMode, ports, additionalProperties);
  }
  
  public A removeAllFromPorts(Collection<PortStatus> items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (PortStatus item : items) {
        PortStatusBuilder builder = new PortStatusBuilder(item);
        _visitables.get("ports").remove(builder);
        this.ports.remove(builder);
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
  
  public A removeFromPorts(PortStatus... items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (PortStatus item : items) {
        PortStatusBuilder builder = new PortStatusBuilder(item);
        _visitables.get("ports").remove(builder);
        this.ports.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPorts(Predicate<PortStatusBuilder> predicate) {
    if (ports == null) {
      return (A) this;
    }
    Iterator<PortStatusBuilder> each = ports.iterator();
    List visitables = _visitables.get("ports");
    while (each.hasNext()) {
        PortStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PortsNested<A> setNewPortLike(int index,PortStatus item) {
    return new PortsNested(index, item);
  }
  
  public A setToPorts(int index,PortStatus item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    PortStatusBuilder builder = new PortStatusBuilder(item);
    if (index < 0 || index >= ports.size()) {
        _visitables.get("ports").add(builder);
        ports.add(builder);
    } else {
        _visitables.get("ports").add(builder);
        ports.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(hostname == null)) {
        sb.append("hostname:");
        sb.append(hostname);
        sb.append(",");
    }
    if (!(ip == null)) {
        sb.append("ip:");
        sb.append(ip);
        sb.append(",");
    }
    if (!(ipMode == null)) {
        sb.append("ipMode:");
        sb.append(ipMode);
        sb.append(",");
    }
    if (!(ports == null) && !(ports.isEmpty())) {
        sb.append("ports:");
        sb.append(ports);
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
  
  public A withHostname(String hostname) {
    this.hostname = hostname;
    return (A) this;
  }
  
  public A withIp(String ip) {
    this.ip = ip;
    return (A) this;
  }
  
  public A withIpMode(String ipMode) {
    this.ipMode = ipMode;
    return (A) this;
  }
  
  public A withPorts(List<PortStatus> ports) {
    if (this.ports != null) {
      this._visitables.get("ports").clear();
    }
    if (ports != null) {
        this.ports = new ArrayList();
        for (PortStatus item : ports) {
          this.addToPorts(item);
        }
    } else {
      this.ports = null;
    }
    return (A) this;
  }
  
  public A withPorts(PortStatus... ports) {
    if (this.ports != null) {
        this.ports.clear();
        _visitables.remove("ports");
    }
    if (ports != null) {
      for (PortStatus item : ports) {
        this.addToPorts(item);
      }
    }
    return (A) this;
  }
  public class PortsNested<N> extends PortStatusFluent<PortsNested<N>> implements Nested<N>{
  
    PortStatusBuilder builder;
    int index;
  
    PortsNested(int index,PortStatus item) {
      this.index = index;
      this.builder = new PortStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerIngressFluent.this.setToPorts(index, builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
}