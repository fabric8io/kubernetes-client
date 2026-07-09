package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class GatewayStatusFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<GatewayStatusAddressBuilder> addresses = new ArrayList<GatewayStatusAddressBuilder>();
  private Integer attachedListenerSets;
  private List<Condition> conditions = new ArrayList<Condition>();
  private ArrayList<ListenerStatusBuilder> listeners = new ArrayList<ListenerStatusBuilder>();

  public GatewayStatusFluent() {
  }
  
  public GatewayStatusFluent(GatewayStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAddresses(Collection<GatewayStatusAddress> items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (GatewayStatusAddress item : items) {
        GatewayStatusAddressBuilder builder = new GatewayStatusAddressBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToListeners(Collection<ListenerStatus> items) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    for (ListenerStatus item : items) {
        ListenerStatusBuilder builder = new ListenerStatusBuilder(item);
        _visitables.get("listeners").add(builder);
        this.listeners.add(builder);
    }
    return (A) this;
  }
  
  public AddressesNested<A> addNewAddress() {
    return new AddressesNested(-1, null);
  }
  
  public A addNewAddress(String type,String value) {
    return (A) this.addToAddresses(new GatewayStatusAddress(type, value));
  }
  
  public AddressesNested<A> addNewAddressLike(GatewayStatusAddress item) {
    return new AddressesNested(-1, item);
  }
  
  public ListenersNested<A> addNewListener() {
    return new ListenersNested(-1, null);
  }
  
  public ListenersNested<A> addNewListenerLike(ListenerStatus item) {
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
  
  public A addToAddresses(GatewayStatusAddress... items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (GatewayStatusAddress item : items) {
        GatewayStatusAddressBuilder builder = new GatewayStatusAddressBuilder(item);
        _visitables.get("addresses").add(builder);
        this.addresses.add(builder);
    }
    return (A) this;
  }
  
  public A addToAddresses(int index,GatewayStatusAddress item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    GatewayStatusAddressBuilder builder = new GatewayStatusAddressBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToListeners(ListenerStatus... items) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    for (ListenerStatus item : items) {
        ListenerStatusBuilder builder = new ListenerStatusBuilder(item);
        _visitables.get("listeners").add(builder);
        this.listeners.add(builder);
    }
    return (A) this;
  }
  
  public A addToListeners(int index,ListenerStatus item) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    ListenerStatusBuilder builder = new ListenerStatusBuilder(item);
    if (index < 0 || index >= listeners.size()) {
        _visitables.get("listeners").add(builder);
        listeners.add(builder);
    } else {
        _visitables.get("listeners").add(builder);
        listeners.add(index, builder);
    }
    return (A) this;
  }
  
  public GatewayStatusAddress buildAddress(int index) {
    return this.addresses.get(index).build();
  }
  
  public List<GatewayStatusAddress> buildAddresses() {
    return this.addresses != null ? build(addresses) : null;
  }
  
  public GatewayStatusAddress buildFirstAddress() {
    return this.addresses.get(0).build();
  }
  
  public ListenerStatus buildFirstListener() {
    return this.listeners.get(0).build();
  }
  
  public GatewayStatusAddress buildLastAddress() {
    return this.addresses.get(addresses.size() - 1).build();
  }
  
  public ListenerStatus buildLastListener() {
    return this.listeners.get(listeners.size() - 1).build();
  }
  
  public ListenerStatus buildListener(int index) {
    return this.listeners.get(index).build();
  }
  
  public List<ListenerStatus> buildListeners() {
    return this.listeners != null ? build(listeners) : null;
  }
  
  public GatewayStatusAddress buildMatchingAddress(Predicate<GatewayStatusAddressBuilder> predicate) {
      for (GatewayStatusAddressBuilder item : addresses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ListenerStatus buildMatchingListener(Predicate<ListenerStatusBuilder> predicate) {
      for (ListenerStatusBuilder item : listeners) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(GatewayStatus instance) {
    instance = instance != null ? instance : new GatewayStatus();
    if (instance != null) {
        this.withAddresses(instance.getAddresses());
        this.withAttachedListenerSets(instance.getAttachedListenerSets());
        this.withConditions(instance.getConditions());
        this.withListeners(instance.getListeners());
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
  
  public ListenersNested<A> editFirstListener() {
    if (listeners.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "listeners"));
    }
    return this.setNewListenerLike(0, this.buildListener(0));
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
  
  public AddressesNested<A> editMatchingAddress(Predicate<GatewayStatusAddressBuilder> predicate) {
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
  
  public ListenersNested<A> editMatchingListener(Predicate<ListenerStatusBuilder> predicate) {
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
    GatewayStatusFluent that = (GatewayStatusFluent) o;
    if (!(Objects.equals(addresses, that.addresses))) {
      return false;
    }
    if (!(Objects.equals(attachedListenerSets, that.attachedListenerSets))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(listeners, that.listeners))) {
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
  
  public Integer getAttachedListenerSets() {
    return this.attachedListenerSets;
  }
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddresses() {
    return this.addresses != null && !(this.addresses.isEmpty());
  }
  
  public boolean hasAttachedListenerSets() {
    return this.attachedListenerSets != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasListeners() {
    return this.listeners != null && !(this.listeners.isEmpty());
  }
  
  public boolean hasMatchingAddress(Predicate<GatewayStatusAddressBuilder> predicate) {
      for (GatewayStatusAddressBuilder item : addresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingListener(Predicate<ListenerStatusBuilder> predicate) {
      for (ListenerStatusBuilder item : listeners) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(addresses, attachedListenerSets, conditions, listeners, additionalProperties);
  }
  
  public A removeAllFromAddresses(Collection<GatewayStatusAddress> items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (GatewayStatusAddress item : items) {
        GatewayStatusAddressBuilder builder = new GatewayStatusAddressBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromListeners(Collection<ListenerStatus> items) {
    if (this.listeners == null) {
      return (A) this;
    }
    for (ListenerStatus item : items) {
        ListenerStatusBuilder builder = new ListenerStatusBuilder(item);
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
  
  public A removeFromAddresses(GatewayStatusAddress... items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (GatewayStatusAddress item : items) {
        GatewayStatusAddressBuilder builder = new GatewayStatusAddressBuilder(item);
        _visitables.get("addresses").remove(builder);
        this.addresses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromListeners(ListenerStatus... items) {
    if (this.listeners == null) {
      return (A) this;
    }
    for (ListenerStatus item : items) {
        ListenerStatusBuilder builder = new ListenerStatusBuilder(item);
        _visitables.get("listeners").remove(builder);
        this.listeners.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAddresses(Predicate<GatewayStatusAddressBuilder> predicate) {
    if (addresses == null) {
      return (A) this;
    }
    Iterator<GatewayStatusAddressBuilder> each = addresses.iterator();
    List visitables = _visitables.get("addresses");
    while (each.hasNext()) {
        GatewayStatusAddressBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromListeners(Predicate<ListenerStatusBuilder> predicate) {
    if (listeners == null) {
      return (A) this;
    }
    Iterator<ListenerStatusBuilder> each = listeners.iterator();
    List visitables = _visitables.get("listeners");
    while (each.hasNext()) {
        ListenerStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AddressesNested<A> setNewAddressLike(int index,GatewayStatusAddress item) {
    return new AddressesNested(index, item);
  }
  
  public ListenersNested<A> setNewListenerLike(int index,ListenerStatus item) {
    return new ListenersNested(index, item);
  }
  
  public A setToAddresses(int index,GatewayStatusAddress item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    GatewayStatusAddressBuilder builder = new GatewayStatusAddressBuilder(item);
    if (index < 0 || index >= addresses.size()) {
        _visitables.get("addresses").add(builder);
        addresses.add(builder);
    } else {
        _visitables.get("addresses").add(builder);
        addresses.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToListeners(int index,ListenerStatus item) {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    ListenerStatusBuilder builder = new ListenerStatusBuilder(item);
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
    if (!(attachedListenerSets == null)) {
        sb.append("attachedListenerSets:");
        sb.append(attachedListenerSets);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(listeners == null) && !(listeners.isEmpty())) {
        sb.append("listeners:");
        sb.append(listeners);
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
  
  public A withAddresses(List<GatewayStatusAddress> addresses) {
    if (this.addresses != null) {
      this._visitables.get("addresses").clear();
    }
    if (addresses != null) {
        this.addresses = new ArrayList();
        for (GatewayStatusAddress item : addresses) {
          this.addToAddresses(item);
        }
    } else {
      this.addresses = null;
    }
    return (A) this;
  }
  
  public A withAddresses(GatewayStatusAddress... addresses) {
    if (this.addresses != null) {
        this.addresses.clear();
        _visitables.remove("addresses");
    }
    if (addresses != null) {
      for (GatewayStatusAddress item : addresses) {
        this.addToAddresses(item);
      }
    }
    return (A) this;
  }
  
  public A withAttachedListenerSets(Integer attachedListenerSets) {
    this.attachedListenerSets = attachedListenerSets;
    return (A) this;
  }
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withListeners(List<ListenerStatus> listeners) {
    if (this.listeners != null) {
      this._visitables.get("listeners").clear();
    }
    if (listeners != null) {
        this.listeners = new ArrayList();
        for (ListenerStatus item : listeners) {
          this.addToListeners(item);
        }
    } else {
      this.listeners = null;
    }
    return (A) this;
  }
  
  public A withListeners(ListenerStatus... listeners) {
    if (this.listeners != null) {
        this.listeners.clear();
        _visitables.remove("listeners");
    }
    if (listeners != null) {
      for (ListenerStatus item : listeners) {
        this.addToListeners(item);
      }
    }
    return (A) this;
  }
  public class AddressesNested<N> extends GatewayStatusAddressFluent<AddressesNested<N>> implements Nested<N>{
  
    GatewayStatusAddressBuilder builder;
    int index;
  
    AddressesNested(int index,GatewayStatusAddress item) {
      this.index = index;
      this.builder = new GatewayStatusAddressBuilder(this, item);
    }
  
    public N and() {
      return (N) GatewayStatusFluent.this.setToAddresses(index, builder.build());
    }
    
    public N endAddress() {
      return and();
    }
    
  }
  public class ListenersNested<N> extends ListenerStatusFluent<ListenersNested<N>> implements Nested<N>{
  
    ListenerStatusBuilder builder;
    int index;
  
    ListenersNested(int index,ListenerStatus item) {
      this.index = index;
      this.builder = new ListenerStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) GatewayStatusFluent.this.setToListeners(index, builder.build());
    }
    
    public N endListener() {
      return and();
    }
    
  }
}