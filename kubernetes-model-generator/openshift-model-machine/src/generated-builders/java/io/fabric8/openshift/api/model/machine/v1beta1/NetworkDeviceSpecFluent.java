package io.fabric8.openshift.api.model.machine.v1beta1;

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
public class NetworkDeviceSpecFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.NetworkDeviceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<AddressesFromPoolBuilder> addressesFromPools = new ArrayList<AddressesFromPoolBuilder>();
  private String gateway;
  private List<String> ipAddrs = new ArrayList<String>();
  private List<String> nameservers = new ArrayList<String>();
  private String networkName;

  public NetworkDeviceSpecFluent() {
  }
  
  public NetworkDeviceSpecFluent(NetworkDeviceSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAddressesFromPools(Collection<AddressesFromPool> items) {
    if (this.addressesFromPools == null) {
      this.addressesFromPools = new ArrayList();
    }
    for (AddressesFromPool item : items) {
        AddressesFromPoolBuilder builder = new AddressesFromPoolBuilder(item);
        _visitables.get("addressesFromPools").add(builder);
        this.addressesFromPools.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToIpAddrs(Collection<String> items) {
    if (this.ipAddrs == null) {
      this.ipAddrs = new ArrayList();
    }
    for (String item : items) {
      this.ipAddrs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNameservers(Collection<String> items) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    for (String item : items) {
      this.nameservers.add(item);
    }
    return (A) this;
  }
  
  public AddressesFromPoolsNested<A> addNewAddressesFromPool() {
    return new AddressesFromPoolsNested(-1, null);
  }
  
  public A addNewAddressesFromPool(String group,String name,String resource) {
    return (A) this.addToAddressesFromPools(new AddressesFromPool(group, name, resource));
  }
  
  public AddressesFromPoolsNested<A> addNewAddressesFromPoolLike(AddressesFromPool item) {
    return new AddressesFromPoolsNested(-1, item);
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
  
  public A addToAddressesFromPools(AddressesFromPool... items) {
    if (this.addressesFromPools == null) {
      this.addressesFromPools = new ArrayList();
    }
    for (AddressesFromPool item : items) {
        AddressesFromPoolBuilder builder = new AddressesFromPoolBuilder(item);
        _visitables.get("addressesFromPools").add(builder);
        this.addressesFromPools.add(builder);
    }
    return (A) this;
  }
  
  public A addToAddressesFromPools(int index,AddressesFromPool item) {
    if (this.addressesFromPools == null) {
      this.addressesFromPools = new ArrayList();
    }
    AddressesFromPoolBuilder builder = new AddressesFromPoolBuilder(item);
    if (index < 0 || index >= addressesFromPools.size()) {
        _visitables.get("addressesFromPools").add(builder);
        addressesFromPools.add(builder);
    } else {
        _visitables.get("addressesFromPools").add(builder);
        addressesFromPools.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToIpAddrs(String... items) {
    if (this.ipAddrs == null) {
      this.ipAddrs = new ArrayList();
    }
    for (String item : items) {
      this.ipAddrs.add(item);
    }
    return (A) this;
  }
  
  public A addToIpAddrs(int index,String item) {
    if (this.ipAddrs == null) {
      this.ipAddrs = new ArrayList();
    }
    this.ipAddrs.add(index, item);
    return (A) this;
  }
  
  public A addToNameservers(String... items) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    for (String item : items) {
      this.nameservers.add(item);
    }
    return (A) this;
  }
  
  public A addToNameservers(int index,String item) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    this.nameservers.add(index, item);
    return (A) this;
  }
  
  public AddressesFromPool buildAddressesFromPool(int index) {
    return this.addressesFromPools.get(index).build();
  }
  
  public List<AddressesFromPool> buildAddressesFromPools() {
    return this.addressesFromPools != null ? build(addressesFromPools) : null;
  }
  
  public AddressesFromPool buildFirstAddressesFromPool() {
    return this.addressesFromPools.get(0).build();
  }
  
  public AddressesFromPool buildLastAddressesFromPool() {
    return this.addressesFromPools.get(addressesFromPools.size() - 1).build();
  }
  
  public AddressesFromPool buildMatchingAddressesFromPool(Predicate<AddressesFromPoolBuilder> predicate) {
      for (AddressesFromPoolBuilder item : addressesFromPools) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(NetworkDeviceSpec instance) {
    instance = instance != null ? instance : new NetworkDeviceSpec();
    if (instance != null) {
        this.withAddressesFromPools(instance.getAddressesFromPools());
        this.withGateway(instance.getGateway());
        this.withIpAddrs(instance.getIpAddrs());
        this.withNameservers(instance.getNameservers());
        this.withNetworkName(instance.getNetworkName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AddressesFromPoolsNested<A> editAddressesFromPool(int index) {
    if (addressesFromPools.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "addressesFromPools"));
    }
    return this.setNewAddressesFromPoolLike(index, this.buildAddressesFromPool(index));
  }
  
  public AddressesFromPoolsNested<A> editFirstAddressesFromPool() {
    if (addressesFromPools.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "addressesFromPools"));
    }
    return this.setNewAddressesFromPoolLike(0, this.buildAddressesFromPool(0));
  }
  
  public AddressesFromPoolsNested<A> editLastAddressesFromPool() {
    int index = addressesFromPools.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "addressesFromPools"));
    }
    return this.setNewAddressesFromPoolLike(index, this.buildAddressesFromPool(index));
  }
  
  public AddressesFromPoolsNested<A> editMatchingAddressesFromPool(Predicate<AddressesFromPoolBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < addressesFromPools.size();i++) {
      if (predicate.test(addressesFromPools.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "addressesFromPools"));
    }
    return this.setNewAddressesFromPoolLike(index, this.buildAddressesFromPool(index));
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
    NetworkDeviceSpecFluent that = (NetworkDeviceSpecFluent) o;
    if (!(Objects.equals(addressesFromPools, that.addressesFromPools))) {
      return false;
    }
    if (!(Objects.equals(gateway, that.gateway))) {
      return false;
    }
    if (!(Objects.equals(ipAddrs, that.ipAddrs))) {
      return false;
    }
    if (!(Objects.equals(nameservers, that.nameservers))) {
      return false;
    }
    if (!(Objects.equals(networkName, that.networkName))) {
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
  
  public String getFirstIpAddr() {
    return this.ipAddrs.get(0);
  }
  
  public String getFirstNameserver() {
    return this.nameservers.get(0);
  }
  
  public String getGateway() {
    return this.gateway;
  }
  
  public String getIpAddr(int index) {
    return this.ipAddrs.get(index);
  }
  
  public List<String> getIpAddrs() {
    return this.ipAddrs;
  }
  
  public String getLastIpAddr() {
    return this.ipAddrs.get(ipAddrs.size() - 1);
  }
  
  public String getLastNameserver() {
    return this.nameservers.get(nameservers.size() - 1);
  }
  
  public String getMatchingIpAddr(Predicate<String> predicate) {
      for (String item : ipAddrs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNameserver(Predicate<String> predicate) {
      for (String item : nameservers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNameserver(int index) {
    return this.nameservers.get(index);
  }
  
  public List<String> getNameservers() {
    return this.nameservers;
  }
  
  public String getNetworkName() {
    return this.networkName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddressesFromPools() {
    return this.addressesFromPools != null && !(this.addressesFromPools.isEmpty());
  }
  
  public boolean hasGateway() {
    return this.gateway != null;
  }
  
  public boolean hasIpAddrs() {
    return this.ipAddrs != null && !(this.ipAddrs.isEmpty());
  }
  
  public boolean hasMatchingAddressesFromPool(Predicate<AddressesFromPoolBuilder> predicate) {
      for (AddressesFromPoolBuilder item : addressesFromPools) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIpAddr(Predicate<String> predicate) {
      for (String item : ipAddrs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNameserver(Predicate<String> predicate) {
      for (String item : nameservers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNameservers() {
    return this.nameservers != null && !(this.nameservers.isEmpty());
  }
  
  public boolean hasNetworkName() {
    return this.networkName != null;
  }
  
  public int hashCode() {
    return Objects.hash(addressesFromPools, gateway, ipAddrs, nameservers, networkName, additionalProperties);
  }
  
  public A removeAllFromAddressesFromPools(Collection<AddressesFromPool> items) {
    if (this.addressesFromPools == null) {
      return (A) this;
    }
    for (AddressesFromPool item : items) {
        AddressesFromPoolBuilder builder = new AddressesFromPoolBuilder(item);
        _visitables.get("addressesFromPools").remove(builder);
        this.addressesFromPools.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromIpAddrs(Collection<String> items) {
    if (this.ipAddrs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ipAddrs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNameservers(Collection<String> items) {
    if (this.nameservers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nameservers.remove(item);
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
  
  public A removeFromAddressesFromPools(AddressesFromPool... items) {
    if (this.addressesFromPools == null) {
      return (A) this;
    }
    for (AddressesFromPool item : items) {
        AddressesFromPoolBuilder builder = new AddressesFromPoolBuilder(item);
        _visitables.get("addressesFromPools").remove(builder);
        this.addressesFromPools.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromIpAddrs(String... items) {
    if (this.ipAddrs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ipAddrs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNameservers(String... items) {
    if (this.nameservers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nameservers.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAddressesFromPools(Predicate<AddressesFromPoolBuilder> predicate) {
    if (addressesFromPools == null) {
      return (A) this;
    }
    Iterator<AddressesFromPoolBuilder> each = addressesFromPools.iterator();
    List visitables = _visitables.get("addressesFromPools");
    while (each.hasNext()) {
        AddressesFromPoolBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AddressesFromPoolsNested<A> setNewAddressesFromPoolLike(int index,AddressesFromPool item) {
    return new AddressesFromPoolsNested(index, item);
  }
  
  public A setToAddressesFromPools(int index,AddressesFromPool item) {
    if (this.addressesFromPools == null) {
      this.addressesFromPools = new ArrayList();
    }
    AddressesFromPoolBuilder builder = new AddressesFromPoolBuilder(item);
    if (index < 0 || index >= addressesFromPools.size()) {
        _visitables.get("addressesFromPools").add(builder);
        addressesFromPools.add(builder);
    } else {
        _visitables.get("addressesFromPools").add(builder);
        addressesFromPools.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToIpAddrs(int index,String item) {
    if (this.ipAddrs == null) {
      this.ipAddrs = new ArrayList();
    }
    this.ipAddrs.set(index, item);
    return (A) this;
  }
  
  public A setToNameservers(int index,String item) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    this.nameservers.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(addressesFromPools == null) && !(addressesFromPools.isEmpty())) {
        sb.append("addressesFromPools:");
        sb.append(addressesFromPools);
        sb.append(",");
    }
    if (!(gateway == null)) {
        sb.append("gateway:");
        sb.append(gateway);
        sb.append(",");
    }
    if (!(ipAddrs == null) && !(ipAddrs.isEmpty())) {
        sb.append("ipAddrs:");
        sb.append(ipAddrs);
        sb.append(",");
    }
    if (!(nameservers == null) && !(nameservers.isEmpty())) {
        sb.append("nameservers:");
        sb.append(nameservers);
        sb.append(",");
    }
    if (!(networkName == null)) {
        sb.append("networkName:");
        sb.append(networkName);
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
  
  public A withAddressesFromPools(List<AddressesFromPool> addressesFromPools) {
    if (this.addressesFromPools != null) {
      this._visitables.get("addressesFromPools").clear();
    }
    if (addressesFromPools != null) {
        this.addressesFromPools = new ArrayList();
        for (AddressesFromPool item : addressesFromPools) {
          this.addToAddressesFromPools(item);
        }
    } else {
      this.addressesFromPools = null;
    }
    return (A) this;
  }
  
  public A withAddressesFromPools(AddressesFromPool... addressesFromPools) {
    if (this.addressesFromPools != null) {
        this.addressesFromPools.clear();
        _visitables.remove("addressesFromPools");
    }
    if (addressesFromPools != null) {
      for (AddressesFromPool item : addressesFromPools) {
        this.addToAddressesFromPools(item);
      }
    }
    return (A) this;
  }
  
  public A withGateway(String gateway) {
    this.gateway = gateway;
    return (A) this;
  }
  
  public A withIpAddrs(List<String> ipAddrs) {
    if (ipAddrs != null) {
        this.ipAddrs = new ArrayList();
        for (String item : ipAddrs) {
          this.addToIpAddrs(item);
        }
    } else {
      this.ipAddrs = null;
    }
    return (A) this;
  }
  
  public A withIpAddrs(String... ipAddrs) {
    if (this.ipAddrs != null) {
        this.ipAddrs.clear();
        _visitables.remove("ipAddrs");
    }
    if (ipAddrs != null) {
      for (String item : ipAddrs) {
        this.addToIpAddrs(item);
      }
    }
    return (A) this;
  }
  
  public A withNameservers(List<String> nameservers) {
    if (nameservers != null) {
        this.nameservers = new ArrayList();
        for (String item : nameservers) {
          this.addToNameservers(item);
        }
    } else {
      this.nameservers = null;
    }
    return (A) this;
  }
  
  public A withNameservers(String... nameservers) {
    if (this.nameservers != null) {
        this.nameservers.clear();
        _visitables.remove("nameservers");
    }
    if (nameservers != null) {
      for (String item : nameservers) {
        this.addToNameservers(item);
      }
    }
    return (A) this;
  }
  
  public A withNetworkName(String networkName) {
    this.networkName = networkName;
    return (A) this;
  }
  public class AddressesFromPoolsNested<N> extends AddressesFromPoolFluent<AddressesFromPoolsNested<N>> implements Nested<N>{
  
    AddressesFromPoolBuilder builder;
    int index;
  
    AddressesFromPoolsNested(int index,AddressesFromPool item) {
      this.index = index;
      this.builder = new AddressesFromPoolBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkDeviceSpecFluent.this.setToAddressesFromPools(index, builder.build());
    }
    
    public N endAddressesFromPool() {
      return and();
    }
    
  }
}