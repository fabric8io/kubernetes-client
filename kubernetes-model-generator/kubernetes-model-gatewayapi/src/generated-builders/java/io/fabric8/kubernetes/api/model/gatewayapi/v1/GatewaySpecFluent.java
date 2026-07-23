package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
public class GatewaySpecFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewaySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<GatewaySpecAddressBuilder> addresses = new ArrayList<GatewaySpecAddressBuilder>();
  private AllowedListenersBuilder allowedListeners;
  private String defaultScope;
  private String gatewayClassName;
  private GatewayInfrastructureBuilder infrastructure;
  private ArrayList<ListenerBuilder> listeners = new ArrayList<ListenerBuilder>();
  private GatewayTLSConfigBuilder tls;

  public GatewaySpecFluent() {
  }
  
  public GatewaySpecFluent(GatewaySpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAddresses(Collection<GatewaySpecAddress> items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (GatewaySpecAddress item : items) {
        GatewaySpecAddressBuilder builder = new GatewaySpecAddressBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToListeners(Collection<Listener> items) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    for (Listener item : items) {
        ListenerBuilder builder = new ListenerBuilder(item);
        _visitables.get("listeners").add(builder);
        this.listeners.add(builder);
    }
    return (A) this;
  }
  
  public AddressesNested<A> addNewAddress() {
    return new AddressesNested(-1, null);
  }
  
  public A addNewAddress(String type,String value) {
    return (A) this.addToAddresses(new GatewaySpecAddress(type, value));
  }
  
  public AddressesNested<A> addNewAddressLike(GatewaySpecAddress item) {
    return new AddressesNested(-1, item);
  }
  
  public ListenersNested<A> addNewListener() {
    return new ListenersNested(-1, null);
  }
  
  public ListenersNested<A> addNewListenerLike(Listener item) {
    return new ListenersNested(-1, item);
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
  
  public A addToAddresses(GatewaySpecAddress... items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (GatewaySpecAddress item : items) {
        GatewaySpecAddressBuilder builder = new GatewaySpecAddressBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
    }
    return (A) this;
  }
  
  public A addToAddresses(int index,GatewaySpecAddress item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    GatewaySpecAddressBuilder builder = new GatewaySpecAddressBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToListeners(Listener... items) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    for (Listener item : items) {
        ListenerBuilder builder = new ListenerBuilder(item);
        _visitables.get("listeners").add(builder);
        this.listeners.add(builder);
    }
    return (A) this;
  }
  
  public A addToListeners(int index,Listener item) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    ListenerBuilder builder = new ListenerBuilder(item);
    if (index < 0 || index >= listeners.size()) {
        _visitables.get("listeners").add(builder);
        listeners.add(builder);
    } else {
        _visitables.get("listeners").add(builder);
        listeners.add(index, builder);
    }
    return (A) this;
  }
  
  public GatewaySpecAddress buildAddress(int index) {
    return this.addresses.get(index).build();
  }
  
  public List<GatewaySpecAddress> buildAddresses() {
    return this.addresses != null ? build(addresses) : null;
  }
  
  public AllowedListeners buildAllowedListeners() {
    return this.allowedListeners != null ? this.allowedListeners.build() : null;
  }
  
  public GatewaySpecAddress buildFirstAddress() {
    return this.addresses.get(0).build();
  }
  
  public Listener buildFirstListener() {
    return this.listeners.get(0).build();
  }
  
  public GatewayInfrastructure buildInfrastructure() {
    return this.infrastructure != null ? this.infrastructure.build() : null;
  }
  
  public GatewaySpecAddress buildLastAddress() {
    return this.addresses.get(addresses.size() - 1).build();
  }
  
  public Listener buildLastListener() {
    return this.listeners.get(listeners.size() - 1).build();
  }
  
  public Listener buildListener(int index) {
    return this.listeners.get(index).build();
  }
  
  public List<Listener> buildListeners() {
    return this.listeners != null ? build(listeners) : null;
  }
  
  public GatewaySpecAddress buildMatchingAddress(Predicate<GatewaySpecAddressBuilder> predicate) {
      for (GatewaySpecAddressBuilder item : addresses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Listener buildMatchingListener(Predicate<ListenerBuilder> predicate) {
      for (ListenerBuilder item : listeners) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GatewayTLSConfig buildTls() {
    return this.tls != null ? this.tls.build() : null;
  }
  
  protected void copyInstance(GatewaySpec instance) {
    instance = instance != null ? instance : new GatewaySpec();
    if (instance != null) {
        this.withAddresses(instance.getAddresses());
        this.withAllowedListeners(instance.getAllowedListeners());
        this.withDefaultScope(instance.getDefaultScope());
        this.withGatewayClassName(instance.getGatewayClassName());
        this.withInfrastructure(instance.getInfrastructure());
        this.withListeners(instance.getListeners());
        this.withTls(instance.getTls());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AddressesNested<A> editAddress(int index) {
    if (addresses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "addresses"));
    }
    return this.setNewAddressLike(index, this.buildAddress(index));
  }
  
  public AllowedListenersNested<A> editAllowedListeners() {
    return this.withNewAllowedListenersLike(Optional.ofNullable(this.buildAllowedListeners()).orElse(null));
  }
  
  public AddressesNested<A> editFirstAddress() {
    if (addresses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "addresses"));
    }
    return this.setNewAddressLike(0, this.buildAddress(0));
  }
  
  public ListenersNested<A> editFirstListener() {
    if (listeners.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "listeners"));
    }
    return this.setNewListenerLike(0, this.buildListener(0));
  }
  
  public InfrastructureNested<A> editInfrastructure() {
    return this.withNewInfrastructureLike(Optional.ofNullable(this.buildInfrastructure()).orElse(null));
  }
  
  public AddressesNested<A> editLastAddress() {
    int index = addresses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "addresses"));
    }
    return this.setNewAddressLike(index, this.buildAddress(index));
  }
  
  public ListenersNested<A> editLastListener() {
    int index = listeners.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "listeners"));
    }
    return this.setNewListenerLike(index, this.buildListener(index));
  }
  
  public ListenersNested<A> editListener(int index) {
    if (listeners.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "listeners"));
    }
    return this.setNewListenerLike(index, this.buildListener(index));
  }
  
  public AddressesNested<A> editMatchingAddress(Predicate<GatewaySpecAddressBuilder> predicate) {
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
  
  public ListenersNested<A> editMatchingListener(Predicate<ListenerBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < listeners.size();i++) {
      if (predicate.test(listeners.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "listeners"));
    }
    return this.setNewListenerLike(index, this.buildListener(index));
  }
  
  public AllowedListenersNested<A> editOrNewAllowedListeners() {
    return this.withNewAllowedListenersLike(Optional.ofNullable(this.buildAllowedListeners()).orElse(new AllowedListenersBuilder().build()));
  }
  
  public AllowedListenersNested<A> editOrNewAllowedListenersLike(AllowedListeners item) {
    return this.withNewAllowedListenersLike(Optional.ofNullable(this.buildAllowedListeners()).orElse(item));
  }
  
  public InfrastructureNested<A> editOrNewInfrastructure() {
    return this.withNewInfrastructureLike(Optional.ofNullable(this.buildInfrastructure()).orElse(new GatewayInfrastructureBuilder().build()));
  }
  
  public InfrastructureNested<A> editOrNewInfrastructureLike(GatewayInfrastructure item) {
    return this.withNewInfrastructureLike(Optional.ofNullable(this.buildInfrastructure()).orElse(item));
  }
  
  public TlsNested<A> editOrNewTls() {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(new GatewayTLSConfigBuilder().build()));
  }
  
  public TlsNested<A> editOrNewTlsLike(GatewayTLSConfig item) {
    return this.withNewTlsLike(Optional.ofNullable(this.buildTls()).orElse(item));
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
    GatewaySpecFluent that = (GatewaySpecFluent) o;
    if (!(Objects.equals(addresses, that.addresses))) {
      return false;
    }
    if (!(Objects.equals(allowedListeners, that.allowedListeners))) {
      return false;
    }
    if (!(Objects.equals(defaultScope, that.defaultScope))) {
      return false;
    }
    if (!(Objects.equals(gatewayClassName, that.gatewayClassName))) {
      return false;
    }
    if (!(Objects.equals(infrastructure, that.infrastructure))) {
      return false;
    }
    if (!(Objects.equals(listeners, that.listeners))) {
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
  
  public String getDefaultScope() {
    return this.defaultScope;
  }
  
  public String getGatewayClassName() {
    return this.gatewayClassName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddresses() {
    return this.addresses != null && !(this.addresses.isEmpty());
  }
  
  public boolean hasAllowedListeners() {
    return this.allowedListeners != null;
  }
  
  public boolean hasDefaultScope() {
    return this.defaultScope != null;
  }
  
  public boolean hasGatewayClassName() {
    return this.gatewayClassName != null;
  }
  
  public boolean hasInfrastructure() {
    return this.infrastructure != null;
  }
  
  public boolean hasListeners() {
    return this.listeners != null && !(this.listeners.isEmpty());
  }
  
  public boolean hasMatchingAddress(Predicate<GatewaySpecAddressBuilder> predicate) {
      for (GatewaySpecAddressBuilder item : addresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingListener(Predicate<ListenerBuilder> predicate) {
      for (ListenerBuilder item : listeners) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTls() {
    return this.tls != null;
  }
  
  public int hashCode() {
    return Objects.hash(addresses, allowedListeners, defaultScope, gatewayClassName, infrastructure, listeners, tls, additionalProperties);
  }
  
  public A removeAllFromAddresses(Collection<GatewaySpecAddress> items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (GatewaySpecAddress item : items) {
        GatewaySpecAddressBuilder builder = new GatewaySpecAddressBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromListeners(Collection<Listener> items) {
    if (this.listeners == null) {
      return (A) this;
    }
    for (Listener item : items) {
        ListenerBuilder builder = new ListenerBuilder(item);
        _visitables.get("listeners").remove(builder);
        this.listeners.remove(builder);
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
  
  public A removeFromAddresses(GatewaySpecAddress... items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (GatewaySpecAddress item : items) {
        GatewaySpecAddressBuilder builder = new GatewaySpecAddressBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromListeners(Listener... items) {
    if (this.listeners == null) {
      return (A) this;
    }
    for (Listener item : items) {
        ListenerBuilder builder = new ListenerBuilder(item);
        _visitables.get("listeners").remove(builder);
        this.listeners.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAddresses(Predicate<GatewaySpecAddressBuilder> predicate) {
    if (addresses == null) {
      return (A) this;
    }
    Iterator<GatewaySpecAddressBuilder> each = addresses.iterator();
    List visitables = _visitables.get("addresses");
    while (each.hasNext()) {
        GatewaySpecAddressBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromListeners(Predicate<ListenerBuilder> predicate) {
    if (listeners == null) {
      return (A) this;
    }
    Iterator<ListenerBuilder> each = listeners.iterator();
    List visitables = _visitables.get("listeners");
    while (each.hasNext()) {
        ListenerBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AddressesNested<A> setNewAddressLike(int index,GatewaySpecAddress item) {
    return new AddressesNested(index, item);
  }
  
  public ListenersNested<A> setNewListenerLike(int index,Listener item) {
    return new ListenersNested(index, item);
  }
  
  public A setToAddresses(int index,GatewaySpecAddress item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    GatewaySpecAddressBuilder builder = new GatewaySpecAddressBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToListeners(int index,Listener item) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    ListenerBuilder builder = new ListenerBuilder(item);
    if (index < 0 || index >= listeners.size()) {
        _visitables.get("listeners").add(builder);
        listeners.add(builder);
    } else {
        _visitables.get("listeners").add(builder);
        listeners.set(index, builder);
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
    if (!(allowedListeners == null)) {
        sb.append("allowedListeners:");
        sb.append(allowedListeners);
        sb.append(",");
    }
    if (!(defaultScope == null)) {
        sb.append("defaultScope:");
        sb.append(defaultScope);
        sb.append(",");
    }
    if (!(gatewayClassName == null)) {
        sb.append("gatewayClassName:");
        sb.append(gatewayClassName);
        sb.append(",");
    }
    if (!(infrastructure == null)) {
        sb.append("infrastructure:");
        sb.append(infrastructure);
        sb.append(",");
    }
    if (!(listeners == null) && !(listeners.isEmpty())) {
        sb.append("listeners:");
        sb.append(listeners);
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
  
  public A withAddresses(List<GatewaySpecAddress> addresses) {
    if (this.addresses != null) {
      this._visitables.get("addresses").clear();
    }
    if (addresses != null) {
        this.addresses = new ArrayList();
        for (GatewaySpecAddress item : addresses) {
          this.addToAddresses(item);
        }
    } else {
      this.addresses = null;
    }
    return (A) this;
  }
  
  public A withAddresses(GatewaySpecAddress... addresses) {
    if (this.addresses != null) {
        this.addresses.clear();
        _visitables.remove("addresses");
    }
    if (addresses != null) {
      for (GatewaySpecAddress item : addresses) {
        this.addToAddresses(item);
      }
    }
    return (A) this;
  }
  
  public A withAllowedListeners(AllowedListeners allowedListeners) {
    this._visitables.remove("allowedListeners");
    if (allowedListeners != null) {
        this.allowedListeners = new AllowedListenersBuilder(allowedListeners);
        this._visitables.get("allowedListeners").add(this.allowedListeners);
    } else {
        this.allowedListeners = null;
        this._visitables.get("allowedListeners").remove(this.allowedListeners);
    }
    return (A) this;
  }
  
  public A withDefaultScope(String defaultScope) {
    this.defaultScope = defaultScope;
    return (A) this;
  }
  
  public A withGatewayClassName(String gatewayClassName) {
    this.gatewayClassName = gatewayClassName;
    return (A) this;
  }
  
  public A withInfrastructure(GatewayInfrastructure infrastructure) {
    this._visitables.remove("infrastructure");
    if (infrastructure != null) {
        this.infrastructure = new GatewayInfrastructureBuilder(infrastructure);
        this._visitables.get("infrastructure").add(this.infrastructure);
    } else {
        this.infrastructure = null;
        this._visitables.get("infrastructure").remove(this.infrastructure);
    }
    return (A) this;
  }
  
  public A withListeners(List<Listener> listeners) {
    if (this.listeners != null) {
      this._visitables.get("listeners").clear();
    }
    if (listeners != null) {
        this.listeners = new ArrayList();
        for (Listener item : listeners) {
          this.addToListeners(item);
        }
    } else {
      this.listeners = null;
    }
    return (A) this;
  }
  
  public A withListeners(Listener... listeners) {
    if (this.listeners != null) {
        this.listeners.clear();
        _visitables.remove("listeners");
    }
    if (listeners != null) {
      for (Listener item : listeners) {
        this.addToListeners(item);
      }
    }
    return (A) this;
  }
  
  public AllowedListenersNested<A> withNewAllowedListeners() {
    return new AllowedListenersNested(null);
  }
  
  public AllowedListenersNested<A> withNewAllowedListenersLike(AllowedListeners item) {
    return new AllowedListenersNested(item);
  }
  
  public InfrastructureNested<A> withNewInfrastructure() {
    return new InfrastructureNested(null);
  }
  
  public InfrastructureNested<A> withNewInfrastructureLike(GatewayInfrastructure item) {
    return new InfrastructureNested(item);
  }
  
  public TlsNested<A> withNewTls() {
    return new TlsNested(null);
  }
  
  public TlsNested<A> withNewTlsLike(GatewayTLSConfig item) {
    return new TlsNested(item);
  }
  
  public A withTls(GatewayTLSConfig tls) {
    this._visitables.remove("tls");
    if (tls != null) {
        this.tls = new GatewayTLSConfigBuilder(tls);
        this._visitables.get("tls").add(this.tls);
    } else {
        this.tls = null;
        this._visitables.get("tls").remove(this.tls);
    }
    return (A) this;
  }
  public class AddressesNested<N> extends GatewaySpecAddressFluent<AddressesNested<N>> implements Nested<N>{
  
    GatewaySpecAddressBuilder builder;
    int index;
  
    AddressesNested(int index,GatewaySpecAddress item) {
      this.index = index;
      this.builder = new GatewaySpecAddressBuilder(this, item);
    }
  
    public N and() {
      return (N) GatewaySpecFluent.this.setToAddresses(index, builder.build());
    }
    
    public N endAddress() {
      return and();
    }
    
  }
  public class AllowedListenersNested<N> extends AllowedListenersFluent<AllowedListenersNested<N>> implements Nested<N>{
  
    AllowedListenersBuilder builder;
  
    AllowedListenersNested(AllowedListeners item) {
      this.builder = new AllowedListenersBuilder(this, item);
    }
  
    public N and() {
      return (N) GatewaySpecFluent.this.withAllowedListeners(builder.build());
    }
    
    public N endAllowedListeners() {
      return and();
    }
    
  }
  public class InfrastructureNested<N> extends GatewayInfrastructureFluent<InfrastructureNested<N>> implements Nested<N>{
  
    GatewayInfrastructureBuilder builder;
  
    InfrastructureNested(GatewayInfrastructure item) {
      this.builder = new GatewayInfrastructureBuilder(this, item);
    }
  
    public N and() {
      return (N) GatewaySpecFluent.this.withInfrastructure(builder.build());
    }
    
    public N endInfrastructure() {
      return and();
    }
    
  }
  public class ListenersNested<N> extends ListenerFluent<ListenersNested<N>> implements Nested<N>{
  
    ListenerBuilder builder;
    int index;
  
    ListenersNested(int index,Listener item) {
      this.index = index;
      this.builder = new ListenerBuilder(this, item);
    }
  
    public N and() {
      return (N) GatewaySpecFluent.this.setToListeners(index, builder.build());
    }
    
    public N endListener() {
      return and();
    }
    
  }
  public class TlsNested<N> extends GatewayTLSConfigFluent<TlsNested<N>> implements Nested<N>{
  
    GatewayTLSConfigBuilder builder;
  
    TlsNested(GatewayTLSConfig item) {
      this.builder = new GatewayTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) GatewaySpecFluent.this.withTls(builder.build());
    }
    
    public N endTls() {
      return and();
    }
    
  }
}