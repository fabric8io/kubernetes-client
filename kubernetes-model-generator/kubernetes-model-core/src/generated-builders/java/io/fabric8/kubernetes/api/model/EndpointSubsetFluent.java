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
public class EndpointSubsetFluent<A extends io.fabric8.kubernetes.api.model.EndpointSubsetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<EndpointAddressBuilder> addresses = new ArrayList<EndpointAddressBuilder>();
  private ArrayList<EndpointAddressBuilder> notReadyAddresses = new ArrayList<EndpointAddressBuilder>();
  private ArrayList<EndpointPortBuilder> ports = new ArrayList<EndpointPortBuilder>();

  public EndpointSubsetFluent() {
  }
  
  public EndpointSubsetFluent(EndpointSubset instance) {
    this.copyInstance(instance);
  }

  public A addAllToAddresses(Collection<EndpointAddress> items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (EndpointAddress item : items) {
        EndpointAddressBuilder builder = new EndpointAddressBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToNotReadyAddresses(Collection<EndpointAddress> items) {
    if (this.notReadyAddresses == null) {
      this.notReadyAddresses = new ArrayList();
    }
    for (EndpointAddress item : items) {
        EndpointAddressBuilder builder = new EndpointAddressBuilder(item);
        _visitables.get("notReadyAddresses").add(builder);
        this.notReadyAddresses.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPorts(Collection<EndpointPort> items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (EndpointPort item : items) {
        EndpointPortBuilder builder = new EndpointPortBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public AddressesNested<A> addNewAddress() {
    return new AddressesNested(-1, null);
  }
  
  public AddressesNested<A> addNewAddressLike(EndpointAddress item) {
    return new AddressesNested(-1, item);
  }
  
  public NotReadyAddressesNested<A> addNewNotReadyAddress() {
    return new NotReadyAddressesNested(-1, null);
  }
  
  public NotReadyAddressesNested<A> addNewNotReadyAddressLike(EndpointAddress item) {
    return new NotReadyAddressesNested(-1, item);
  }
  
  public PortsNested<A> addNewPort() {
    return new PortsNested(-1, null);
  }
  
  public A addNewPort(String appProtocol,String name,Integer port,String protocol) {
    return (A) this.addToPorts(new EndpointPort(appProtocol, name, port, protocol));
  }
  
  public PortsNested<A> addNewPortLike(EndpointPort item) {
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
  
  public A addToAddresses(EndpointAddress... items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (EndpointAddress item : items) {
        EndpointAddressBuilder builder = new EndpointAddressBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
    }
    return (A) this;
  }
  
  public A addToAddresses(int index,EndpointAddress item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    EndpointAddressBuilder builder = new EndpointAddressBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToNotReadyAddresses(EndpointAddress... items) {
    if (this.notReadyAddresses == null) {
      this.notReadyAddresses = new ArrayList();
    }
    for (EndpointAddress item : items) {
        EndpointAddressBuilder builder = new EndpointAddressBuilder(item);
        _visitables.get("notReadyAddresses").add(builder);
        this.notReadyAddresses.add(builder);
    }
    return (A) this;
  }
  
  public A addToNotReadyAddresses(int index,EndpointAddress item) {
    if (this.notReadyAddresses == null) {
      this.notReadyAddresses = new ArrayList();
    }
    EndpointAddressBuilder builder = new EndpointAddressBuilder(item);
    if (index < 0 || index >= notReadyAddresses.size()) {
        _visitables.get("notReadyAddresses").add(builder);
        notReadyAddresses.add(builder);
    } else {
        _visitables.get("notReadyAddresses").add(builder);
        notReadyAddresses.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPorts(EndpointPort... items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (EndpointPort item : items) {
        EndpointPortBuilder builder = new EndpointPortBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public A addToPorts(int index,EndpointPort item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    EndpointPortBuilder builder = new EndpointPortBuilder(item);
    if (index < 0 || index >= ports.size()) {
        _visitables.get("ports").add(builder);
        ports.add(builder);
    } else {
        _visitables.get("ports").add(builder);
        ports.add(index, builder);
    }
    return (A) this;
  }
  
  public EndpointAddress buildAddress(int index) {
    return this.addresses.get(index).build();
  }
  
  public List<EndpointAddress> buildAddresses() {
    return this.addresses != null ? build(addresses) : null;
  }
  
  public EndpointAddress buildFirstAddress() {
    return this.addresses.get(0).build();
  }
  
  public EndpointAddress buildFirstNotReadyAddress() {
    return this.notReadyAddresses.get(0).build();
  }
  
  public EndpointPort buildFirstPort() {
    return this.ports.get(0).build();
  }
  
  public EndpointAddress buildLastAddress() {
    return this.addresses.get(addresses.size() - 1).build();
  }
  
  public EndpointAddress buildLastNotReadyAddress() {
    return this.notReadyAddresses.get(notReadyAddresses.size() - 1).build();
  }
  
  public EndpointPort buildLastPort() {
    return this.ports.get(ports.size() - 1).build();
  }
  
  public EndpointAddress buildMatchingAddress(Predicate<EndpointAddressBuilder> predicate) {
      for (EndpointAddressBuilder item : addresses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public EndpointAddress buildMatchingNotReadyAddress(Predicate<EndpointAddressBuilder> predicate) {
      for (EndpointAddressBuilder item : notReadyAddresses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public EndpointPort buildMatchingPort(Predicate<EndpointPortBuilder> predicate) {
      for (EndpointPortBuilder item : ports) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public EndpointAddress buildNotReadyAddress(int index) {
    return this.notReadyAddresses.get(index).build();
  }
  
  public List<EndpointAddress> buildNotReadyAddresses() {
    return this.notReadyAddresses != null ? build(notReadyAddresses) : null;
  }
  
  public EndpointPort buildPort(int index) {
    return this.ports.get(index).build();
  }
  
  public List<EndpointPort> buildPorts() {
    return this.ports != null ? build(ports) : null;
  }
  
  protected void copyInstance(EndpointSubset instance) {
    instance = instance != null ? instance : new EndpointSubset();
    if (instance != null) {
        this.withAddresses(instance.getAddresses());
        this.withNotReadyAddresses(instance.getNotReadyAddresses());
        this.withPorts(instance.getPorts());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AddressesNested<A> editAddress(int index) {
    if (addresses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "addresses"));
    }
    return this.setNewAddressLike(index, this.buildAddress(index));
  }
  
  public AddressesNested<A> editFirstAddress() {
    if (addresses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "addresses"));
    }
    return this.setNewAddressLike(0, this.buildAddress(0));
  }
  
  public NotReadyAddressesNested<A> editFirstNotReadyAddress() {
    if (notReadyAddresses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "notReadyAddresses"));
    }
    return this.setNewNotReadyAddressLike(0, this.buildNotReadyAddress(0));
  }
  
  public PortsNested<A> editFirstPort() {
    if (ports.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(0, this.buildPort(0));
  }
  
  public AddressesNested<A> editLastAddress() {
    int index = addresses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "addresses"));
    }
    return this.setNewAddressLike(index, this.buildAddress(index));
  }
  
  public NotReadyAddressesNested<A> editLastNotReadyAddress() {
    int index = notReadyAddresses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "notReadyAddresses"));
    }
    return this.setNewNotReadyAddressLike(index, this.buildNotReadyAddress(index));
  }
  
  public PortsNested<A> editLastPort() {
    int index = ports.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public AddressesNested<A> editMatchingAddress(Predicate<EndpointAddressBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < addresses.size();i++) {
      if (predicate.test(addresses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "addresses"));
    }
    return this.setNewAddressLike(index, this.buildAddress(index));
  }
  
  public NotReadyAddressesNested<A> editMatchingNotReadyAddress(Predicate<EndpointAddressBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < notReadyAddresses.size();i++) {
      if (predicate.test(notReadyAddresses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "notReadyAddresses"));
    }
    return this.setNewNotReadyAddressLike(index, this.buildNotReadyAddress(index));
  }
  
  public PortsNested<A> editMatchingPort(Predicate<EndpointPortBuilder> predicate) {
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
  
  public NotReadyAddressesNested<A> editNotReadyAddress(int index) {
    if (notReadyAddresses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "notReadyAddresses"));
    }
    return this.setNewNotReadyAddressLike(index, this.buildNotReadyAddress(index));
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
    EndpointSubsetFluent that = (EndpointSubsetFluent) o;
    if (!(Objects.equals(addresses, that.addresses))) {
      return false;
    }
    if (!(Objects.equals(notReadyAddresses, that.notReadyAddresses))) {
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
  
  public boolean hasAddresses() {
    return this.addresses != null && !(this.addresses.isEmpty());
  }
  
  public boolean hasMatchingAddress(Predicate<EndpointAddressBuilder> predicate) {
      for (EndpointAddressBuilder item : addresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNotReadyAddress(Predicate<EndpointAddressBuilder> predicate) {
      for (EndpointAddressBuilder item : notReadyAddresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPort(Predicate<EndpointPortBuilder> predicate) {
      for (EndpointPortBuilder item : ports) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNotReadyAddresses() {
    return this.notReadyAddresses != null && !(this.notReadyAddresses.isEmpty());
  }
  
  public boolean hasPorts() {
    return this.ports != null && !(this.ports.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(addresses, notReadyAddresses, ports, additionalProperties);
  }
  
  public A removeAllFromAddresses(Collection<EndpointAddress> items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (EndpointAddress item : items) {
        EndpointAddressBuilder builder = new EndpointAddressBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromNotReadyAddresses(Collection<EndpointAddress> items) {
    if (this.notReadyAddresses == null) {
      return (A) this;
    }
    for (EndpointAddress item : items) {
        EndpointAddressBuilder builder = new EndpointAddressBuilder(item);
        _visitables.get("notReadyAddresses").remove(builder);
        this.notReadyAddresses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPorts(Collection<EndpointPort> items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (EndpointPort item : items) {
        EndpointPortBuilder builder = new EndpointPortBuilder(item);
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
  
  public A removeFromAddresses(EndpointAddress... items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (EndpointAddress item : items) {
        EndpointAddressBuilder builder = new EndpointAddressBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromNotReadyAddresses(EndpointAddress... items) {
    if (this.notReadyAddresses == null) {
      return (A) this;
    }
    for (EndpointAddress item : items) {
        EndpointAddressBuilder builder = new EndpointAddressBuilder(item);
        _visitables.get("notReadyAddresses").remove(builder);
        this.notReadyAddresses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPorts(EndpointPort... items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (EndpointPort item : items) {
        EndpointPortBuilder builder = new EndpointPortBuilder(item);
        _visitables.get("ports").remove(builder);
        this.ports.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAddresses(Predicate<EndpointAddressBuilder> predicate) {
    if (addresses == null) {
      return (A) this;
    }
    Iterator<EndpointAddressBuilder> each = addresses.iterator();
    List visitables = _visitables.get("addresses");
    while (each.hasNext()) {
        EndpointAddressBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromNotReadyAddresses(Predicate<EndpointAddressBuilder> predicate) {
    if (notReadyAddresses == null) {
      return (A) this;
    }
    Iterator<EndpointAddressBuilder> each = notReadyAddresses.iterator();
    List visitables = _visitables.get("notReadyAddresses");
    while (each.hasNext()) {
        EndpointAddressBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPorts(Predicate<EndpointPortBuilder> predicate) {
    if (ports == null) {
      return (A) this;
    }
    Iterator<EndpointPortBuilder> each = ports.iterator();
    List visitables = _visitables.get("ports");
    while (each.hasNext()) {
        EndpointPortBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AddressesNested<A> setNewAddressLike(int index,EndpointAddress item) {
    return new AddressesNested(index, item);
  }
  
  public NotReadyAddressesNested<A> setNewNotReadyAddressLike(int index,EndpointAddress item) {
    return new NotReadyAddressesNested(index, item);
  }
  
  public PortsNested<A> setNewPortLike(int index,EndpointPort item) {
    return new PortsNested(index, item);
  }
  
  public A setToAddresses(int index,EndpointAddress item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    EndpointAddressBuilder builder = new EndpointAddressBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToNotReadyAddresses(int index,EndpointAddress item) {
    if (this.notReadyAddresses == null) {
      this.notReadyAddresses = new ArrayList();
    }
    EndpointAddressBuilder builder = new EndpointAddressBuilder(item);
    if (index < 0 || index >= notReadyAddresses.size()) {
        _visitables.get("notReadyAddresses").add(builder);
        notReadyAddresses.add(builder);
    } else {
        _visitables.get("notReadyAddresses").add(builder);
        notReadyAddresses.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPorts(int index,EndpointPort item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    EndpointPortBuilder builder = new EndpointPortBuilder(item);
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
    if (!(addresses == null) && !(addresses.isEmpty())) {
        sb.append("addresses:");
        sb.append(addresses);
        sb.append(",");
    }
    if (!(notReadyAddresses == null) && !(notReadyAddresses.isEmpty())) {
        sb.append("notReadyAddresses:");
        sb.append(notReadyAddresses);
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
  
  public A withAddresses(List<EndpointAddress> addresses) {
    if (this.addresses != null) {
      this._visitables.get("addresses").clear();
    }
    if (addresses != null) {
        this.addresses = new ArrayList();
        for (EndpointAddress item : addresses) {
          this.addToAddresses(item);
        }
    } else {
      this.addresses = null;
    }
    return (A) this;
  }
  
  public A withAddresses(EndpointAddress... addresses) {
    if (this.addresses != null) {
        this.addresses.clear();
        _visitables.remove("addresses");
    }
    if (addresses != null) {
      for (EndpointAddress item : addresses) {
        this.addToAddresses(item);
      }
    }
    return (A) this;
  }
  
  public A withNotReadyAddresses(List<EndpointAddress> notReadyAddresses) {
    if (this.notReadyAddresses != null) {
      this._visitables.get("notReadyAddresses").clear();
    }
    if (notReadyAddresses != null) {
        this.notReadyAddresses = new ArrayList();
        for (EndpointAddress item : notReadyAddresses) {
          this.addToNotReadyAddresses(item);
        }
    } else {
      this.notReadyAddresses = null;
    }
    return (A) this;
  }
  
  public A withNotReadyAddresses(EndpointAddress... notReadyAddresses) {
    if (this.notReadyAddresses != null) {
        this.notReadyAddresses.clear();
        _visitables.remove("notReadyAddresses");
    }
    if (notReadyAddresses != null) {
      for (EndpointAddress item : notReadyAddresses) {
        this.addToNotReadyAddresses(item);
      }
    }
    return (A) this;
  }
  
  public A withPorts(List<EndpointPort> ports) {
    if (this.ports != null) {
      this._visitables.get("ports").clear();
    }
    if (ports != null) {
        this.ports = new ArrayList();
        for (EndpointPort item : ports) {
          this.addToPorts(item);
        }
    } else {
      this.ports = null;
    }
    return (A) this;
  }
  
  public A withPorts(EndpointPort... ports) {
    if (this.ports != null) {
        this.ports.clear();
        _visitables.remove("ports");
    }
    if (ports != null) {
      for (EndpointPort item : ports) {
        this.addToPorts(item);
      }
    }
    return (A) this;
  }
  public class AddressesNested<N> extends EndpointAddressFluent<AddressesNested<N>> implements Nested<N>{
  
    EndpointAddressBuilder builder;
    int index;
  
    AddressesNested(int index,EndpointAddress item) {
      this.index = index;
      this.builder = new EndpointAddressBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointSubsetFluent.this.setToAddresses(index, builder.build());
    }
    
    public N endAddress() {
      return and();
    }
    
  }
  public class NotReadyAddressesNested<N> extends EndpointAddressFluent<NotReadyAddressesNested<N>> implements Nested<N>{
  
    EndpointAddressBuilder builder;
    int index;
  
    NotReadyAddressesNested(int index,EndpointAddress item) {
      this.index = index;
      this.builder = new EndpointAddressBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointSubsetFluent.this.setToNotReadyAddresses(index, builder.build());
    }
    
    public N endNotReadyAddress() {
      return and();
    }
    
  }
  public class PortsNested<N> extends EndpointPortFluent<PortsNested<N>> implements Nested<N>{
  
    EndpointPortBuilder builder;
    int index;
  
    PortsNested(int index,EndpointPort item) {
      this.index = index;
      this.builder = new EndpointPortBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointSubsetFluent.this.setToPorts(index, builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
}