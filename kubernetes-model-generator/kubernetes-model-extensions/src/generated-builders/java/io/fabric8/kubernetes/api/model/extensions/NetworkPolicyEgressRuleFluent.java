package io.fabric8.kubernetes.api.model.extensions;

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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NetworkPolicyEgressRuleFluent<A extends io.fabric8.kubernetes.api.model.extensions.NetworkPolicyEgressRuleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NetworkPolicyPortBuilder> ports = new ArrayList<NetworkPolicyPortBuilder>();
  private ArrayList<NetworkPolicyPeerBuilder> to = new ArrayList<NetworkPolicyPeerBuilder>();

  public NetworkPolicyEgressRuleFluent() {
  }
  
  public NetworkPolicyEgressRuleFluent(NetworkPolicyEgressRule instance) {
    this.copyInstance(instance);
  }

  public A addAllToPorts(Collection<NetworkPolicyPort> items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (NetworkPolicyPort item : items) {
        NetworkPolicyPortBuilder builder = new NetworkPolicyPortBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTo(Collection<NetworkPolicyPeer> items) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    for (NetworkPolicyPeer item : items) {
        NetworkPolicyPeerBuilder builder = new NetworkPolicyPeerBuilder(item);
        _visitables.get("to").add(builder);
        this.to.add(builder);
    }
    return (A) this;
  }
  
  public PortsNested<A> addNewPort() {
    return new PortsNested(-1, null);
  }
  
  public PortsNested<A> addNewPortLike(NetworkPolicyPort item) {
    return new PortsNested(-1, item);
  }
  
  public ToNested<A> addNewTo() {
    return new ToNested(-1, null);
  }
  
  public ToNested<A> addNewToLike(NetworkPolicyPeer item) {
    return new ToNested(-1, item);
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
  
  public A addToPorts(NetworkPolicyPort... items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (NetworkPolicyPort item : items) {
        NetworkPolicyPortBuilder builder = new NetworkPolicyPortBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public A addToPorts(int index,NetworkPolicyPort item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    NetworkPolicyPortBuilder builder = new NetworkPolicyPortBuilder(item);
    if (index < 0 || index >= ports.size()) {
        _visitables.get("ports").add(builder);
        ports.add(builder);
    } else {
        _visitables.get("ports").add(builder);
        ports.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTo(NetworkPolicyPeer... items) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    for (NetworkPolicyPeer item : items) {
        NetworkPolicyPeerBuilder builder = new NetworkPolicyPeerBuilder(item);
        _visitables.get("to").add(builder);
        this.to.add(builder);
    }
    return (A) this;
  }
  
  public A addToTo(int index,NetworkPolicyPeer item) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    NetworkPolicyPeerBuilder builder = new NetworkPolicyPeerBuilder(item);
    if (index < 0 || index >= to.size()) {
        _visitables.get("to").add(builder);
        to.add(builder);
    } else {
        _visitables.get("to").add(builder);
        to.add(index, builder);
    }
    return (A) this;
  }
  
  public NetworkPolicyPort buildFirstPort() {
    return this.ports.get(0).build();
  }
  
  public NetworkPolicyPeer buildFirstTo() {
    return this.to.get(0).build();
  }
  
  public NetworkPolicyPort buildLastPort() {
    return this.ports.get(ports.size() - 1).build();
  }
  
  public NetworkPolicyPeer buildLastTo() {
    return this.to.get(to.size() - 1).build();
  }
  
  public NetworkPolicyPort buildMatchingPort(Predicate<NetworkPolicyPortBuilder> predicate) {
      for (NetworkPolicyPortBuilder item : ports) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkPolicyPeer buildMatchingTo(Predicate<NetworkPolicyPeerBuilder> predicate) {
      for (NetworkPolicyPeerBuilder item : to) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkPolicyPort buildPort(int index) {
    return this.ports.get(index).build();
  }
  
  public List<NetworkPolicyPort> buildPorts() {
    return this.ports != null ? build(ports) : null;
  }
  
  public List<NetworkPolicyPeer> buildTo() {
    return this.to != null ? build(to) : null;
  }
  
  public NetworkPolicyPeer buildTo(int index) {
    return this.to.get(index).build();
  }
  
  protected void copyInstance(NetworkPolicyEgressRule instance) {
    instance = instance != null ? instance : new NetworkPolicyEgressRule();
    if (instance != null) {
        this.withPorts(instance.getPorts());
        this.withTo(instance.getTo());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PortsNested<A> editFirstPort() {
    if (ports.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(0, this.buildPort(0));
  }
  
  public ToNested<A> editFirstTo() {
    if (to.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "to"));
    }
    return this.setNewToLike(0, this.buildTo(0));
  }
  
  public PortsNested<A> editLastPort() {
    int index = ports.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public ToNested<A> editLastTo() {
    int index = to.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "to"));
    }
    return this.setNewToLike(index, this.buildTo(index));
  }
  
  public PortsNested<A> editMatchingPort(Predicate<NetworkPolicyPortBuilder> predicate) {
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
  
  public ToNested<A> editMatchingTo(Predicate<NetworkPolicyPeerBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < to.size();i++) {
      if (predicate.test(to.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "to"));
    }
    return this.setNewToLike(index, this.buildTo(index));
  }
  
  public PortsNested<A> editPort(int index) {
    if (ports.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public ToNested<A> editTo(int index) {
    if (to.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "to"));
    }
    return this.setNewToLike(index, this.buildTo(index));
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
    NetworkPolicyEgressRuleFluent that = (NetworkPolicyEgressRuleFluent) o;
    if (!(Objects.equals(ports, that.ports))) {
      return false;
    }
    if (!(Objects.equals(to, that.to))) {
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
  
  public boolean hasMatchingPort(Predicate<NetworkPolicyPortBuilder> predicate) {
      for (NetworkPolicyPortBuilder item : ports) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTo(Predicate<NetworkPolicyPeerBuilder> predicate) {
      for (NetworkPolicyPeerBuilder item : to) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPorts() {
    return this.ports != null && !(this.ports.isEmpty());
  }
  
  public boolean hasTo() {
    return this.to != null && !(this.to.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(ports, to, additionalProperties);
  }
  
  public A removeAllFromPorts(Collection<NetworkPolicyPort> items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (NetworkPolicyPort item : items) {
        NetworkPolicyPortBuilder builder = new NetworkPolicyPortBuilder(item);
        _visitables.get("ports").remove(builder);
        this.ports.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTo(Collection<NetworkPolicyPeer> items) {
    if (this.to == null) {
      return (A) this;
    }
    for (NetworkPolicyPeer item : items) {
        NetworkPolicyPeerBuilder builder = new NetworkPolicyPeerBuilder(item);
        _visitables.get("to").remove(builder);
        this.to.remove(builder);
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
  
  public A removeFromPorts(NetworkPolicyPort... items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (NetworkPolicyPort item : items) {
        NetworkPolicyPortBuilder builder = new NetworkPolicyPortBuilder(item);
        _visitables.get("ports").remove(builder);
        this.ports.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTo(NetworkPolicyPeer... items) {
    if (this.to == null) {
      return (A) this;
    }
    for (NetworkPolicyPeer item : items) {
        NetworkPolicyPeerBuilder builder = new NetworkPolicyPeerBuilder(item);
        _visitables.get("to").remove(builder);
        this.to.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPorts(Predicate<NetworkPolicyPortBuilder> predicate) {
    if (ports == null) {
      return (A) this;
    }
    Iterator<NetworkPolicyPortBuilder> each = ports.iterator();
    List visitables = _visitables.get("ports");
    while (each.hasNext()) {
        NetworkPolicyPortBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTo(Predicate<NetworkPolicyPeerBuilder> predicate) {
    if (to == null) {
      return (A) this;
    }
    Iterator<NetworkPolicyPeerBuilder> each = to.iterator();
    List visitables = _visitables.get("to");
    while (each.hasNext()) {
        NetworkPolicyPeerBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PortsNested<A> setNewPortLike(int index,NetworkPolicyPort item) {
    return new PortsNested(index, item);
  }
  
  public ToNested<A> setNewToLike(int index,NetworkPolicyPeer item) {
    return new ToNested(index, item);
  }
  
  public A setToPorts(int index,NetworkPolicyPort item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    NetworkPolicyPortBuilder builder = new NetworkPolicyPortBuilder(item);
    if (index < 0 || index >= ports.size()) {
        _visitables.get("ports").add(builder);
        ports.add(builder);
    } else {
        _visitables.get("ports").add(builder);
        ports.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTo(int index,NetworkPolicyPeer item) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    NetworkPolicyPeerBuilder builder = new NetworkPolicyPeerBuilder(item);
    if (index < 0 || index >= to.size()) {
        _visitables.get("to").add(builder);
        to.add(builder);
    } else {
        _visitables.get("to").add(builder);
        to.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ports == null) && !(ports.isEmpty())) {
        sb.append("ports:");
        sb.append(ports);
        sb.append(",");
    }
    if (!(to == null) && !(to.isEmpty())) {
        sb.append("to:");
        sb.append(to);
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
  
  public A withPorts(List<NetworkPolicyPort> ports) {
    if (this.ports != null) {
      this._visitables.get("ports").clear();
    }
    if (ports != null) {
        this.ports = new ArrayList();
        for (NetworkPolicyPort item : ports) {
          this.addToPorts(item);
        }
    } else {
      this.ports = null;
    }
    return (A) this;
  }
  
  public A withPorts(NetworkPolicyPort... ports) {
    if (this.ports != null) {
        this.ports.clear();
        _visitables.remove("ports");
    }
    if (ports != null) {
      for (NetworkPolicyPort item : ports) {
        this.addToPorts(item);
      }
    }
    return (A) this;
  }
  
  public A withTo(List<NetworkPolicyPeer> to) {
    if (this.to != null) {
      this._visitables.get("to").clear();
    }
    if (to != null) {
        this.to = new ArrayList();
        for (NetworkPolicyPeer item : to) {
          this.addToTo(item);
        }
    } else {
      this.to = null;
    }
    return (A) this;
  }
  
  public A withTo(NetworkPolicyPeer... to) {
    if (this.to != null) {
        this.to.clear();
        _visitables.remove("to");
    }
    if (to != null) {
      for (NetworkPolicyPeer item : to) {
        this.addToTo(item);
      }
    }
    return (A) this;
  }
  public class PortsNested<N> extends NetworkPolicyPortFluent<PortsNested<N>> implements Nested<N>{
  
    NetworkPolicyPortBuilder builder;
    int index;
  
    PortsNested(int index,NetworkPolicyPort item) {
      this.index = index;
      this.builder = new NetworkPolicyPortBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkPolicyEgressRuleFluent.this.setToPorts(index, builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
  public class ToNested<N> extends NetworkPolicyPeerFluent<ToNested<N>> implements Nested<N>{
  
    NetworkPolicyPeerBuilder builder;
    int index;
  
    ToNested(int index,NetworkPolicyPeer item) {
      this.index = index;
      this.builder = new NetworkPolicyPeerBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkPolicyEgressRuleFluent.this.setToTo(index, builder.build());
    }
    
    public N endTo() {
      return and();
    }
    
  }
}