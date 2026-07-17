package io.fabric8.openshift.api.model.operator.network.v1;

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
public class EgressRouterSpecFluent<A extends io.fabric8.openshift.api.model.operator.network.v1.EgressRouterSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<EgressRouterAddressBuilder> addresses = new ArrayList<EgressRouterAddressBuilder>();
  private String mode;
  private EgressRouterInterfaceBuilder networkInterface;
  private RedirectConfigBuilder redirect;

  public EgressRouterSpecFluent() {
  }
  
  public EgressRouterSpecFluent(EgressRouterSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAddresses(Collection<EgressRouterAddress> items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (EgressRouterAddress item : items) {
        EgressRouterAddressBuilder builder = new EgressRouterAddressBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
    }
    return (A) this;
  }
  
  public AddressesNested<A> addNewAddress() {
    return new AddressesNested(-1, null);
  }
  
  public A addNewAddress(String gateway,String ip) {
    return (A) this.addToAddresses(new EgressRouterAddress(gateway, ip));
  }
  
  public AddressesNested<A> addNewAddressLike(EgressRouterAddress item) {
    return new AddressesNested(-1, item);
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
  
  public A addToAddresses(EgressRouterAddress... items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (EgressRouterAddress item : items) {
        EgressRouterAddressBuilder builder = new EgressRouterAddressBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
    }
    return (A) this;
  }
  
  public A addToAddresses(int index,EgressRouterAddress item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    EgressRouterAddressBuilder builder = new EgressRouterAddressBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.add(index, builder);
    }
    return (A) this;
  }
  
  public EgressRouterAddress buildAddress(int index) {
    return this.addresses.get(index).build();
  }
  
  public List<EgressRouterAddress> buildAddresses() {
    return this.addresses != null ? build(addresses) : null;
  }
  
  public EgressRouterAddress buildFirstAddress() {
    return this.addresses.get(0).build();
  }
  
  public EgressRouterAddress buildLastAddress() {
    return this.addresses.get(addresses.size() - 1).build();
  }
  
  public EgressRouterAddress buildMatchingAddress(Predicate<EgressRouterAddressBuilder> predicate) {
      for (EgressRouterAddressBuilder item : addresses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public EgressRouterInterface buildNetworkInterface() {
    return this.networkInterface != null ? this.networkInterface.build() : null;
  }
  
  public RedirectConfig buildRedirect() {
    return this.redirect != null ? this.redirect.build() : null;
  }
  
  protected void copyInstance(EgressRouterSpec instance) {
    instance = instance != null ? instance : new EgressRouterSpec();
    if (instance != null) {
        this.withAddresses(instance.getAddresses());
        this.withMode(instance.getMode());
        this.withNetworkInterface(instance.getNetworkInterface());
        this.withRedirect(instance.getRedirect());
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
  
  public AddressesNested<A> editLastAddress() {
    int index = addresses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "addresses"));
    }
    return this.setNewAddressLike(index, this.buildAddress(index));
  }
  
  public AddressesNested<A> editMatchingAddress(Predicate<EgressRouterAddressBuilder> predicate) {
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
  
  public NetworkInterfaceNested<A> editNetworkInterface() {
    return this.withNewNetworkInterfaceLike(Optional.ofNullable(this.buildNetworkInterface()).orElse(null));
  }
  
  public NetworkInterfaceNested<A> editOrNewNetworkInterface() {
    return this.withNewNetworkInterfaceLike(Optional.ofNullable(this.buildNetworkInterface()).orElse(new EgressRouterInterfaceBuilder().build()));
  }
  
  public NetworkInterfaceNested<A> editOrNewNetworkInterfaceLike(EgressRouterInterface item) {
    return this.withNewNetworkInterfaceLike(Optional.ofNullable(this.buildNetworkInterface()).orElse(item));
  }
  
  public RedirectNested<A> editOrNewRedirect() {
    return this.withNewRedirectLike(Optional.ofNullable(this.buildRedirect()).orElse(new RedirectConfigBuilder().build()));
  }
  
  public RedirectNested<A> editOrNewRedirectLike(RedirectConfig item) {
    return this.withNewRedirectLike(Optional.ofNullable(this.buildRedirect()).orElse(item));
  }
  
  public RedirectNested<A> editRedirect() {
    return this.withNewRedirectLike(Optional.ofNullable(this.buildRedirect()).orElse(null));
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
    EgressRouterSpecFluent that = (EgressRouterSpecFluent) o;
    if (!(Objects.equals(addresses, that.addresses))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(networkInterface, that.networkInterface))) {
      return false;
    }
    if (!(Objects.equals(redirect, that.redirect))) {
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
  
  public String getMode() {
    return this.mode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddresses() {
    return this.addresses != null && !(this.addresses.isEmpty());
  }
  
  public boolean hasMatchingAddress(Predicate<EgressRouterAddressBuilder> predicate) {
      for (EgressRouterAddressBuilder item : addresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasNetworkInterface() {
    return this.networkInterface != null;
  }
  
  public boolean hasRedirect() {
    return this.redirect != null;
  }
  
  public int hashCode() {
    return Objects.hash(addresses, mode, networkInterface, redirect, additionalProperties);
  }
  
  public A removeAllFromAddresses(Collection<EgressRouterAddress> items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (EgressRouterAddress item : items) {
        EgressRouterAddressBuilder builder = new EgressRouterAddressBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
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
  
  public A removeFromAddresses(EgressRouterAddress... items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (EgressRouterAddress item : items) {
        EgressRouterAddressBuilder builder = new EgressRouterAddressBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAddresses(Predicate<EgressRouterAddressBuilder> predicate) {
    if (addresses == null) {
      return (A) this;
    }
    Iterator<EgressRouterAddressBuilder> each = addresses.iterator();
    List visitables = _visitables.get("addresses");
    while (each.hasNext()) {
        EgressRouterAddressBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AddressesNested<A> setNewAddressLike(int index,EgressRouterAddress item) {
    return new AddressesNested(index, item);
  }
  
  public A setToAddresses(int index,EgressRouterAddress item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    EgressRouterAddressBuilder builder = new EgressRouterAddressBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.set(index, builder);
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
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(networkInterface == null)) {
        sb.append("networkInterface:");
        sb.append(networkInterface);
        sb.append(",");
    }
    if (!(redirect == null)) {
        sb.append("redirect:");
        sb.append(redirect);
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
  
  public A withAddresses(List<EgressRouterAddress> addresses) {
    if (this.addresses != null) {
      this._visitables.get("addresses").clear();
    }
    if (addresses != null) {
        this.addresses = new ArrayList();
        for (EgressRouterAddress item : addresses) {
          this.addToAddresses(item);
        }
    } else {
      this.addresses = null;
    }
    return (A) this;
  }
  
  public A withAddresses(EgressRouterAddress... addresses) {
    if (this.addresses != null) {
        this.addresses.clear();
        _visitables.remove("addresses");
    }
    if (addresses != null) {
      for (EgressRouterAddress item : addresses) {
        this.addToAddresses(item);
      }
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public A withNetworkInterface(EgressRouterInterface networkInterface) {
    this._visitables.remove("networkInterface");
    if (networkInterface != null) {
        this.networkInterface = new EgressRouterInterfaceBuilder(networkInterface);
        this._visitables.get("networkInterface").add(this.networkInterface);
    } else {
        this.networkInterface = null;
        this._visitables.get("networkInterface").remove(this.networkInterface);
    }
    return (A) this;
  }
  
  public NetworkInterfaceNested<A> withNewNetworkInterface() {
    return new NetworkInterfaceNested(null);
  }
  
  public NetworkInterfaceNested<A> withNewNetworkInterfaceLike(EgressRouterInterface item) {
    return new NetworkInterfaceNested(item);
  }
  
  public RedirectNested<A> withNewRedirect() {
    return new RedirectNested(null);
  }
  
  public RedirectNested<A> withNewRedirectLike(RedirectConfig item) {
    return new RedirectNested(item);
  }
  
  public A withRedirect(RedirectConfig redirect) {
    this._visitables.remove("redirect");
    if (redirect != null) {
        this.redirect = new RedirectConfigBuilder(redirect);
        this._visitables.get("redirect").add(this.redirect);
    } else {
        this.redirect = null;
        this._visitables.get("redirect").remove(this.redirect);
    }
    return (A) this;
  }
  public class AddressesNested<N> extends EgressRouterAddressFluent<AddressesNested<N>> implements Nested<N>{
  
    EgressRouterAddressBuilder builder;
    int index;
  
    AddressesNested(int index,EgressRouterAddress item) {
      this.index = index;
      this.builder = new EgressRouterAddressBuilder(this, item);
    }
  
    public N and() {
      return (N) EgressRouterSpecFluent.this.setToAddresses(index, builder.build());
    }
    
    public N endAddress() {
      return and();
    }
    
  }
  public class NetworkInterfaceNested<N> extends EgressRouterInterfaceFluent<NetworkInterfaceNested<N>> implements Nested<N>{
  
    EgressRouterInterfaceBuilder builder;
  
    NetworkInterfaceNested(EgressRouterInterface item) {
      this.builder = new EgressRouterInterfaceBuilder(this, item);
    }
  
    public N and() {
      return (N) EgressRouterSpecFluent.this.withNetworkInterface(builder.build());
    }
    
    public N endNetworkInterface() {
      return and();
    }
    
  }
  public class RedirectNested<N> extends RedirectConfigFluent<RedirectNested<N>> implements Nested<N>{
  
    RedirectConfigBuilder builder;
  
    RedirectNested(RedirectConfig item) {
      this.builder = new RedirectConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) EgressRouterSpecFluent.this.withRedirect(builder.build());
    }
    
    public N endRedirect() {
      return and();
    }
    
  }
}