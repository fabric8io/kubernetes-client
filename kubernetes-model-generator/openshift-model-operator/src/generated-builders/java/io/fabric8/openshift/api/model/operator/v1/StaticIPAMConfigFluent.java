package io.fabric8.openshift.api.model.operator.v1;

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
public class StaticIPAMConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.StaticIPAMConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<StaticIPAMAddressesBuilder> addresses = new ArrayList<StaticIPAMAddressesBuilder>();
  private StaticIPAMDNSBuilder dns;
  private ArrayList<StaticIPAMRoutesBuilder> routes = new ArrayList<StaticIPAMRoutesBuilder>();

  public StaticIPAMConfigFluent() {
  }
  
  public StaticIPAMConfigFluent(StaticIPAMConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToAddresses(Collection<StaticIPAMAddresses> items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (StaticIPAMAddresses item : items) {
        StaticIPAMAddressesBuilder builder = new StaticIPAMAddressesBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRoutes(Collection<StaticIPAMRoutes> items) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    for (StaticIPAMRoutes item : items) {
        StaticIPAMRoutesBuilder builder = new StaticIPAMRoutesBuilder(item);
        _visitables.get("routes").add(builder);
        this.routes.add(builder);
    }
    return (A) this;
  }
  
  public AddressesNested<A> addNewAddress() {
    return new AddressesNested(-1, null);
  }
  
  public A addNewAddress(String address,String gateway) {
    return (A) this.addToAddresses(new StaticIPAMAddresses(address, gateway));
  }
  
  public AddressesNested<A> addNewAddressLike(StaticIPAMAddresses item) {
    return new AddressesNested(-1, item);
  }
  
  public RoutesNested<A> addNewRoute() {
    return new RoutesNested(-1, null);
  }
  
  public A addNewRoute(String destination,String gateway) {
    return (A) this.addToRoutes(new StaticIPAMRoutes(destination, gateway));
  }
  
  public RoutesNested<A> addNewRouteLike(StaticIPAMRoutes item) {
    return new RoutesNested(-1, item);
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
  
  public A addToAddresses(StaticIPAMAddresses... items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (StaticIPAMAddresses item : items) {
        StaticIPAMAddressesBuilder builder = new StaticIPAMAddressesBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
    }
    return (A) this;
  }
  
  public A addToAddresses(int index,StaticIPAMAddresses item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    StaticIPAMAddressesBuilder builder = new StaticIPAMAddressesBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRoutes(StaticIPAMRoutes... items) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    for (StaticIPAMRoutes item : items) {
        StaticIPAMRoutesBuilder builder = new StaticIPAMRoutesBuilder(item);
        _visitables.get("routes").add(builder);
        this.routes.add(builder);
    }
    return (A) this;
  }
  
  public A addToRoutes(int index,StaticIPAMRoutes item) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    StaticIPAMRoutesBuilder builder = new StaticIPAMRoutesBuilder(item);
    if (index < 0 || index >= routes.size()) {
        _visitables.get("routes").add(builder);
        routes.add(builder);
    } else {
        _visitables.get("routes").add(builder);
        routes.add(index, builder);
    }
    return (A) this;
  }
  
  public StaticIPAMAddresses buildAddress(int index) {
    return this.addresses.get(index).build();
  }
  
  public List<StaticIPAMAddresses> buildAddresses() {
    return this.addresses != null ? build(addresses) : null;
  }
  
  public StaticIPAMDNS buildDns() {
    return this.dns != null ? this.dns.build() : null;
  }
  
  public StaticIPAMAddresses buildFirstAddress() {
    return this.addresses.get(0).build();
  }
  
  public StaticIPAMRoutes buildFirstRoute() {
    return this.routes.get(0).build();
  }
  
  public StaticIPAMAddresses buildLastAddress() {
    return this.addresses.get(addresses.size() - 1).build();
  }
  
  public StaticIPAMRoutes buildLastRoute() {
    return this.routes.get(routes.size() - 1).build();
  }
  
  public StaticIPAMAddresses buildMatchingAddress(Predicate<StaticIPAMAddressesBuilder> predicate) {
      for (StaticIPAMAddressesBuilder item : addresses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StaticIPAMRoutes buildMatchingRoute(Predicate<StaticIPAMRoutesBuilder> predicate) {
      for (StaticIPAMRoutesBuilder item : routes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StaticIPAMRoutes buildRoute(int index) {
    return this.routes.get(index).build();
  }
  
  public List<StaticIPAMRoutes> buildRoutes() {
    return this.routes != null ? build(routes) : null;
  }
  
  protected void copyInstance(StaticIPAMConfig instance) {
    instance = instance != null ? instance : new StaticIPAMConfig();
    if (instance != null) {
        this.withAddresses(instance.getAddresses());
        this.withDns(instance.getDns());
        this.withRoutes(instance.getRoutes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AddressesNested<A> editAddress(int index) {
    if (addresses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "addresses"));
    }
    return this.setNewAddressLike(index, this.buildAddress(index));
  }
  
  public DnsNested<A> editDns() {
    return this.withNewDnsLike(Optional.ofNullable(this.buildDns()).orElse(null));
  }
  
  public AddressesNested<A> editFirstAddress() {
    if (addresses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "addresses"));
    }
    return this.setNewAddressLike(0, this.buildAddress(0));
  }
  
  public RoutesNested<A> editFirstRoute() {
    if (routes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "routes"));
    }
    return this.setNewRouteLike(0, this.buildRoute(0));
  }
  
  public AddressesNested<A> editLastAddress() {
    int index = addresses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "addresses"));
    }
    return this.setNewAddressLike(index, this.buildAddress(index));
  }
  
  public RoutesNested<A> editLastRoute() {
    int index = routes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "routes"));
    }
    return this.setNewRouteLike(index, this.buildRoute(index));
  }
  
  public AddressesNested<A> editMatchingAddress(Predicate<StaticIPAMAddressesBuilder> predicate) {
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
  
  public RoutesNested<A> editMatchingRoute(Predicate<StaticIPAMRoutesBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < routes.size();i++) {
      if (predicate.test(routes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "routes"));
    }
    return this.setNewRouteLike(index, this.buildRoute(index));
  }
  
  public DnsNested<A> editOrNewDns() {
    return this.withNewDnsLike(Optional.ofNullable(this.buildDns()).orElse(new StaticIPAMDNSBuilder().build()));
  }
  
  public DnsNested<A> editOrNewDnsLike(StaticIPAMDNS item) {
    return this.withNewDnsLike(Optional.ofNullable(this.buildDns()).orElse(item));
  }
  
  public RoutesNested<A> editRoute(int index) {
    if (routes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "routes"));
    }
    return this.setNewRouteLike(index, this.buildRoute(index));
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
    StaticIPAMConfigFluent that = (StaticIPAMConfigFluent) o;
    if (!(Objects.equals(addresses, that.addresses))) {
      return false;
    }
    if (!(Objects.equals(dns, that.dns))) {
      return false;
    }
    if (!(Objects.equals(routes, that.routes))) {
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
  
  public boolean hasDns() {
    return this.dns != null;
  }
  
  public boolean hasMatchingAddress(Predicate<StaticIPAMAddressesBuilder> predicate) {
      for (StaticIPAMAddressesBuilder item : addresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRoute(Predicate<StaticIPAMRoutesBuilder> predicate) {
      for (StaticIPAMRoutesBuilder item : routes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRoutes() {
    return this.routes != null && !(this.routes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(addresses, dns, routes, additionalProperties);
  }
  
  public A removeAllFromAddresses(Collection<StaticIPAMAddresses> items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (StaticIPAMAddresses item : items) {
        StaticIPAMAddressesBuilder builder = new StaticIPAMAddressesBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRoutes(Collection<StaticIPAMRoutes> items) {
    if (this.routes == null) {
      return (A) this;
    }
    for (StaticIPAMRoutes item : items) {
        StaticIPAMRoutesBuilder builder = new StaticIPAMRoutesBuilder(item);
        _visitables.get("routes").remove(builder);
        this.routes.remove(builder);
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
  
  public A removeFromAddresses(StaticIPAMAddresses... items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (StaticIPAMAddresses item : items) {
        StaticIPAMAddressesBuilder builder = new StaticIPAMAddressesBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRoutes(StaticIPAMRoutes... items) {
    if (this.routes == null) {
      return (A) this;
    }
    for (StaticIPAMRoutes item : items) {
        StaticIPAMRoutesBuilder builder = new StaticIPAMRoutesBuilder(item);
        _visitables.get("routes").remove(builder);
        this.routes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAddresses(Predicate<StaticIPAMAddressesBuilder> predicate) {
    if (addresses == null) {
      return (A) this;
    }
    Iterator<StaticIPAMAddressesBuilder> each = addresses.iterator();
    List visitables = _visitables.get("addresses");
    while (each.hasNext()) {
        StaticIPAMAddressesBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRoutes(Predicate<StaticIPAMRoutesBuilder> predicate) {
    if (routes == null) {
      return (A) this;
    }
    Iterator<StaticIPAMRoutesBuilder> each = routes.iterator();
    List visitables = _visitables.get("routes");
    while (each.hasNext()) {
        StaticIPAMRoutesBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AddressesNested<A> setNewAddressLike(int index,StaticIPAMAddresses item) {
    return new AddressesNested(index, item);
  }
  
  public RoutesNested<A> setNewRouteLike(int index,StaticIPAMRoutes item) {
    return new RoutesNested(index, item);
  }
  
  public A setToAddresses(int index,StaticIPAMAddresses item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    StaticIPAMAddressesBuilder builder = new StaticIPAMAddressesBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRoutes(int index,StaticIPAMRoutes item) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    StaticIPAMRoutesBuilder builder = new StaticIPAMRoutesBuilder(item);
    if (index < 0 || index >= routes.size()) {
        _visitables.get("routes").add(builder);
        routes.add(builder);
    } else {
        _visitables.get("routes").add(builder);
        routes.set(index, builder);
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
    if (!(dns == null)) {
        sb.append("dns:");
        sb.append(dns);
        sb.append(",");
    }
    if (!(routes == null) && !(routes.isEmpty())) {
        sb.append("routes:");
        sb.append(routes);
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
  
  public A withAddresses(List<StaticIPAMAddresses> addresses) {
    if (this.addresses != null) {
      this._visitables.get("addresses").clear();
    }
    if (addresses != null) {
        this.addresses = new ArrayList();
        for (StaticIPAMAddresses item : addresses) {
          this.addToAddresses(item);
        }
    } else {
      this.addresses = null;
    }
    return (A) this;
  }
  
  public A withAddresses(StaticIPAMAddresses... addresses) {
    if (this.addresses != null) {
        this.addresses.clear();
        _visitables.remove("addresses");
    }
    if (addresses != null) {
      for (StaticIPAMAddresses item : addresses) {
        this.addToAddresses(item);
      }
    }
    return (A) this;
  }
  
  public A withDns(StaticIPAMDNS dns) {
    this._visitables.remove("dns");
    if (dns != null) {
        this.dns = new StaticIPAMDNSBuilder(dns);
        this._visitables.get("dns").add(this.dns);
    } else {
        this.dns = null;
        this._visitables.get("dns").remove(this.dns);
    }
    return (A) this;
  }
  
  public DnsNested<A> withNewDns() {
    return new DnsNested(null);
  }
  
  public DnsNested<A> withNewDnsLike(StaticIPAMDNS item) {
    return new DnsNested(item);
  }
  
  public A withRoutes(List<StaticIPAMRoutes> routes) {
    if (this.routes != null) {
      this._visitables.get("routes").clear();
    }
    if (routes != null) {
        this.routes = new ArrayList();
        for (StaticIPAMRoutes item : routes) {
          this.addToRoutes(item);
        }
    } else {
      this.routes = null;
    }
    return (A) this;
  }
  
  public A withRoutes(StaticIPAMRoutes... routes) {
    if (this.routes != null) {
        this.routes.clear();
        _visitables.remove("routes");
    }
    if (routes != null) {
      for (StaticIPAMRoutes item : routes) {
        this.addToRoutes(item);
      }
    }
    return (A) this;
  }
  public class AddressesNested<N> extends StaticIPAMAddressesFluent<AddressesNested<N>> implements Nested<N>{
  
    StaticIPAMAddressesBuilder builder;
    int index;
  
    AddressesNested(int index,StaticIPAMAddresses item) {
      this.index = index;
      this.builder = new StaticIPAMAddressesBuilder(this, item);
    }
  
    public N and() {
      return (N) StaticIPAMConfigFluent.this.setToAddresses(index, builder.build());
    }
    
    public N endAddress() {
      return and();
    }
    
  }
  public class DnsNested<N> extends StaticIPAMDNSFluent<DnsNested<N>> implements Nested<N>{
  
    StaticIPAMDNSBuilder builder;
  
    DnsNested(StaticIPAMDNS item) {
      this.builder = new StaticIPAMDNSBuilder(this, item);
    }
  
    public N and() {
      return (N) StaticIPAMConfigFluent.this.withDns(builder.build());
    }
    
    public N endDns() {
      return and();
    }
    
  }
  public class RoutesNested<N> extends StaticIPAMRoutesFluent<RoutesNested<N>> implements Nested<N>{
  
    StaticIPAMRoutesBuilder builder;
    int index;
  
    RoutesNested(int index,StaticIPAMRoutes item) {
      this.index = index;
      this.builder = new StaticIPAMRoutesBuilder(this, item);
    }
  
    public N and() {
      return (N) StaticIPAMConfigFluent.this.setToRoutes(index, builder.build());
    }
    
    public N endRoute() {
      return and();
    }
    
  }
}