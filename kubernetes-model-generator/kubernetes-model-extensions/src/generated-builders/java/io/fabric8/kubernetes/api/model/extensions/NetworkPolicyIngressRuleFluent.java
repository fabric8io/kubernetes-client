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
public class NetworkPolicyIngressRuleFluent<A extends io.fabric8.kubernetes.api.model.extensions.NetworkPolicyIngressRuleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NetworkPolicyPeerBuilder> from = new ArrayList<NetworkPolicyPeerBuilder>();
  private ArrayList<NetworkPolicyPortBuilder> ports = new ArrayList<NetworkPolicyPortBuilder>();

  public NetworkPolicyIngressRuleFluent() {
  }
  
  public NetworkPolicyIngressRuleFluent(NetworkPolicyIngressRule instance) {
    this.copyInstance(instance);
  }

  public A addAllToFrom(Collection<NetworkPolicyPeer> items) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    for (NetworkPolicyPeer item : items) {
        NetworkPolicyPeerBuilder builder = new NetworkPolicyPeerBuilder(item);
        _visitables.get("from").add(builder);
        this.from.add(builder);
    }
    return (A) this;
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
  
  public FromNested<A> addNewFrom() {
    return new FromNested(-1, null);
  }
  
  public FromNested<A> addNewFromLike(NetworkPolicyPeer item) {
    return new FromNested(-1, item);
  }
  
  public PortsNested<A> addNewPort() {
    return new PortsNested(-1, null);
  }
  
  public PortsNested<A> addNewPortLike(NetworkPolicyPort item) {
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
  
  public A addToFrom(NetworkPolicyPeer... items) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    for (NetworkPolicyPeer item : items) {
        NetworkPolicyPeerBuilder builder = new NetworkPolicyPeerBuilder(item);
        _visitables.get("from").add(builder);
        this.from.add(builder);
    }
    return (A) this;
  }
  
  public A addToFrom(int index,NetworkPolicyPeer item) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    NetworkPolicyPeerBuilder builder = new NetworkPolicyPeerBuilder(item);
    if (index < 0 || index >= from.size()) {
        _visitables.get("from").add(builder);
        from.add(builder);
    } else {
        _visitables.get("from").add(builder);
        from.add(index, builder);
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
  
  public NetworkPolicyPeer buildFirstFrom() {
    return this.from.get(0).build();
  }
  
  public NetworkPolicyPort buildFirstPort() {
    return this.ports.get(0).build();
  }
  
  public List<NetworkPolicyPeer> buildFrom() {
    return this.from != null ? build(from) : null;
  }
  
  public NetworkPolicyPeer buildFrom(int index) {
    return this.from.get(index).build();
  }
  
  public NetworkPolicyPeer buildLastFrom() {
    return this.from.get(from.size() - 1).build();
  }
  
  public NetworkPolicyPort buildLastPort() {
    return this.ports.get(ports.size() - 1).build();
  }
  
  public NetworkPolicyPeer buildMatchingFrom(Predicate<NetworkPolicyPeerBuilder> predicate) {
      for (NetworkPolicyPeerBuilder item : from) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkPolicyPort buildMatchingPort(Predicate<NetworkPolicyPortBuilder> predicate) {
      for (NetworkPolicyPortBuilder item : ports) {
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
  
  protected void copyInstance(NetworkPolicyIngressRule instance) {
    instance = instance != null ? instance : new NetworkPolicyIngressRule();
    if (instance != null) {
        this.withFrom(instance.getFrom());
        this.withPorts(instance.getPorts());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FromNested<A> editFirstFrom() {
    if (from.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "from"));
    }
    return this.setNewFromLike(0, this.buildFrom(0));
  }
  
  public PortsNested<A> editFirstPort() {
    if (ports.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(0, this.buildPort(0));
  }
  
  public FromNested<A> editFrom(int index) {
    if (from.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "from"));
    }
    return this.setNewFromLike(index, this.buildFrom(index));
  }
  
  public FromNested<A> editLastFrom() {
    int index = from.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "from"));
    }
    return this.setNewFromLike(index, this.buildFrom(index));
  }
  
  public PortsNested<A> editLastPort() {
    int index = ports.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public FromNested<A> editMatchingFrom(Predicate<NetworkPolicyPeerBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < from.size();i++) {
      if (predicate.test(from.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "from"));
    }
    return this.setNewFromLike(index, this.buildFrom(index));
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
    NetworkPolicyIngressRuleFluent that = (NetworkPolicyIngressRuleFluent) o;
    if (!(Objects.equals(from, that.from))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFrom() {
    return this.from != null && !(this.from.isEmpty());
  }
  
  public boolean hasMatchingFrom(Predicate<NetworkPolicyPeerBuilder> predicate) {
      for (NetworkPolicyPeerBuilder item : from) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPort(Predicate<NetworkPolicyPortBuilder> predicate) {
      for (NetworkPolicyPortBuilder item : ports) {
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
    return Objects.hash(from, ports, additionalProperties);
  }
  
  public A removeAllFromFrom(Collection<NetworkPolicyPeer> items) {
    if (this.from == null) {
      return (A) this;
    }
    for (NetworkPolicyPeer item : items) {
        NetworkPolicyPeerBuilder builder = new NetworkPolicyPeerBuilder(item);
        _visitables.get("from").remove(builder);
        this.from.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromFrom(NetworkPolicyPeer... items) {
    if (this.from == null) {
      return (A) this;
    }
    for (NetworkPolicyPeer item : items) {
        NetworkPolicyPeerBuilder builder = new NetworkPolicyPeerBuilder(item);
        _visitables.get("from").remove(builder);
        this.from.remove(builder);
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
  
  public A removeMatchingFromFrom(Predicate<NetworkPolicyPeerBuilder> predicate) {
    if (from == null) {
      return (A) this;
    }
    Iterator<NetworkPolicyPeerBuilder> each = from.iterator();
    List visitables = _visitables.get("from");
    while (each.hasNext()) {
        NetworkPolicyPeerBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
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
  
  public FromNested<A> setNewFromLike(int index,NetworkPolicyPeer item) {
    return new FromNested(index, item);
  }
  
  public PortsNested<A> setNewPortLike(int index,NetworkPolicyPort item) {
    return new PortsNested(index, item);
  }
  
  public A setToFrom(int index,NetworkPolicyPeer item) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    NetworkPolicyPeerBuilder builder = new NetworkPolicyPeerBuilder(item);
    if (index < 0 || index >= from.size()) {
        _visitables.get("from").add(builder);
        from.add(builder);
    } else {
        _visitables.get("from").add(builder);
        from.set(index, builder);
    }
    return (A) this;
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(from == null) && !(from.isEmpty())) {
        sb.append("from:");
        sb.append(from);
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
  
  public A withFrom(List<NetworkPolicyPeer> from) {
    if (this.from != null) {
      this._visitables.get("from").clear();
    }
    if (from != null) {
        this.from = new ArrayList();
        for (NetworkPolicyPeer item : from) {
          this.addToFrom(item);
        }
    } else {
      this.from = null;
    }
    return (A) this;
  }
  
  public A withFrom(NetworkPolicyPeer... from) {
    if (this.from != null) {
        this.from.clear();
        _visitables.remove("from");
    }
    if (from != null) {
      for (NetworkPolicyPeer item : from) {
        this.addToFrom(item);
      }
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
  public class FromNested<N> extends NetworkPolicyPeerFluent<FromNested<N>> implements Nested<N>{
  
    NetworkPolicyPeerBuilder builder;
    int index;
  
    FromNested(int index,NetworkPolicyPeer item) {
      this.index = index;
      this.builder = new NetworkPolicyPeerBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkPolicyIngressRuleFluent.this.setToFrom(index, builder.build());
    }
    
    public N endFrom() {
      return and();
    }
    
  }
  public class PortsNested<N> extends NetworkPolicyPortFluent<PortsNested<N>> implements Nested<N>{
  
    NetworkPolicyPortBuilder builder;
    int index;
  
    PortsNested(int index,NetworkPolicyPort item) {
      this.index = index;
      this.builder = new NetworkPolicyPortBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkPolicyIngressRuleFluent.this.setToPorts(index, builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
}