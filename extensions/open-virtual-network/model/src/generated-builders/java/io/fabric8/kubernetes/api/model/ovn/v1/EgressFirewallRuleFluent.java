package io.fabric8.kubernetes.api.model.ovn.v1;

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
public class EgressFirewallRuleFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewallRuleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<EgressFirewallPortBuilder> ports = new ArrayList<EgressFirewallPortBuilder>();
  private EgressFirewallDestinationBuilder to;
  private String type;

  public EgressFirewallRuleFluent() {
  }
  
  public EgressFirewallRuleFluent(EgressFirewallRule instance) {
    this.copyInstance(instance);
  }

  public A addAllToPorts(Collection<EgressFirewallPort> items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (EgressFirewallPort item : items) {
        EgressFirewallPortBuilder builder = new EgressFirewallPortBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public PortsNested<A> addNewPort() {
    return new PortsNested(-1, null);
  }
  
  public A addNewPort(Integer port,String protocol) {
    return (A) this.addToPorts(new EgressFirewallPort(port, protocol));
  }
  
  public PortsNested<A> addNewPortLike(EgressFirewallPort item) {
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
  
  public A addToPorts(EgressFirewallPort... items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (EgressFirewallPort item : items) {
        EgressFirewallPortBuilder builder = new EgressFirewallPortBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public A addToPorts(int index,EgressFirewallPort item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    EgressFirewallPortBuilder builder = new EgressFirewallPortBuilder(item);
    if (index < 0 || index >= ports.size()) {
        _visitables.get("ports").add(builder);
        ports.add(builder);
    } else {
        _visitables.get("ports").add(builder);
        ports.add(index, builder);
    }
    return (A) this;
  }
  
  public EgressFirewallPort buildFirstPort() {
    return this.ports.get(0).build();
  }
  
  public EgressFirewallPort buildLastPort() {
    return this.ports.get(ports.size() - 1).build();
  }
  
  public EgressFirewallPort buildMatchingPort(Predicate<EgressFirewallPortBuilder> predicate) {
      for (EgressFirewallPortBuilder item : ports) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public EgressFirewallPort buildPort(int index) {
    return this.ports.get(index).build();
  }
  
  public List<EgressFirewallPort> buildPorts() {
    return this.ports != null ? build(ports) : null;
  }
  
  public EgressFirewallDestination buildTo() {
    return this.to != null ? this.to.build() : null;
  }
  
  protected void copyInstance(EgressFirewallRule instance) {
    instance = instance != null ? instance : new EgressFirewallRule();
    if (instance != null) {
        this.withPorts(instance.getPorts());
        this.withTo(instance.getTo());
        this.withType(instance.getType());
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
  
  public PortsNested<A> editMatchingPort(Predicate<EgressFirewallPortBuilder> predicate) {
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
  
  public ToNested<A> editOrNewTo() {
    return this.withNewToLike(Optional.ofNullable(this.buildTo()).orElse(new EgressFirewallDestinationBuilder().build()));
  }
  
  public ToNested<A> editOrNewToLike(EgressFirewallDestination item) {
    return this.withNewToLike(Optional.ofNullable(this.buildTo()).orElse(item));
  }
  
  public PortsNested<A> editPort(int index) {
    if (ports.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
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
    EgressFirewallRuleFluent that = (EgressFirewallRuleFluent) o;
    if (!(Objects.equals(ports, that.ports))) {
      return false;
    }
    if (!(Objects.equals(to, that.to))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingPort(Predicate<EgressFirewallPortBuilder> predicate) {
      for (EgressFirewallPortBuilder item : ports) {
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
    return this.to != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(ports, to, type, additionalProperties);
  }
  
  public A removeAllFromPorts(Collection<EgressFirewallPort> items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (EgressFirewallPort item : items) {
        EgressFirewallPortBuilder builder = new EgressFirewallPortBuilder(item);
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
  
  public A removeFromPorts(EgressFirewallPort... items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (EgressFirewallPort item : items) {
        EgressFirewallPortBuilder builder = new EgressFirewallPortBuilder(item);
        _visitables.get("ports").remove(builder);
        this.ports.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPorts(Predicate<EgressFirewallPortBuilder> predicate) {
    if (ports == null) {
      return (A) this;
    }
    Iterator<EgressFirewallPortBuilder> each = ports.iterator();
    List visitables = _visitables.get("ports");
    while (each.hasNext()) {
        EgressFirewallPortBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PortsNested<A> setNewPortLike(int index,EgressFirewallPort item) {
    return new PortsNested(index, item);
  }
  
  public A setToPorts(int index,EgressFirewallPort item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    EgressFirewallPortBuilder builder = new EgressFirewallPortBuilder(item);
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
    if (!(ports == null) && !(ports.isEmpty())) {
        sb.append("ports:");
        sb.append(ports);
        sb.append(",");
    }
    if (!(to == null)) {
        sb.append("to:");
        sb.append(to);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public ToNested<A> withNewTo() {
    return new ToNested(null);
  }
  
  public ToNested<A> withNewToLike(EgressFirewallDestination item) {
    return new ToNested(item);
  }
  
  public A withPorts(List<EgressFirewallPort> ports) {
    if (this.ports != null) {
      this._visitables.get("ports").clear();
    }
    if (ports != null) {
        this.ports = new ArrayList();
        for (EgressFirewallPort item : ports) {
          this.addToPorts(item);
        }
    } else {
      this.ports = null;
    }
    return (A) this;
  }
  
  public A withPorts(EgressFirewallPort... ports) {
    if (this.ports != null) {
        this.ports.clear();
        _visitables.remove("ports");
    }
    if (ports != null) {
      for (EgressFirewallPort item : ports) {
        this.addToPorts(item);
      }
    }
    return (A) this;
  }
  
  public A withTo(EgressFirewallDestination to) {
    this._visitables.remove("to");
    if (to != null) {
        this.to = new EgressFirewallDestinationBuilder(to);
        this._visitables.get("to").add(this.to);
    } else {
        this.to = null;
        this._visitables.get("to").remove(this.to);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class PortsNested<N> extends EgressFirewallPortFluent<PortsNested<N>> implements Nested<N>{
  
    EgressFirewallPortBuilder builder;
    int index;
  
    PortsNested(int index,EgressFirewallPort item) {
      this.index = index;
      this.builder = new EgressFirewallPortBuilder(this, item);
    }
  
    public N and() {
      return (N) EgressFirewallRuleFluent.this.setToPorts(index, builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
  public class ToNested<N> extends EgressFirewallDestinationFluent<ToNested<N>> implements Nested<N>{
  
    EgressFirewallDestinationBuilder builder;
  
    ToNested(EgressFirewallDestination item) {
      this.builder = new EgressFirewallDestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) EgressFirewallRuleFluent.this.withTo(builder.build());
    }
    
    public N endTo() {
      return and();
    }
    
  }
}