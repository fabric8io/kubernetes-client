package io.fabric8.openshift.api.model.miscellaneous.network.v1alpha1;

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
public class DNSNameResolverResolvedNameFluent<A extends io.fabric8.openshift.api.model.miscellaneous.network.v1alpha1.DNSNameResolverResolvedNameFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private String dnsName;
  private Integer resolutionFailures;
  private ArrayList<DNSNameResolverResolvedAddressBuilder> resolvedAddresses = new ArrayList<DNSNameResolverResolvedAddressBuilder>();

  public DNSNameResolverResolvedNameFluent() {
  }
  
  public DNSNameResolverResolvedNameFluent(DNSNameResolverResolvedName instance) {
    this.copyInstance(instance);
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
  
  public A addAllToResolvedAddresses(Collection<DNSNameResolverResolvedAddress> items) {
    if (this.resolvedAddresses == null) {
      this.resolvedAddresses = new ArrayList();
    }
    for (DNSNameResolverResolvedAddress item : items) {
        DNSNameResolverResolvedAddressBuilder builder = new DNSNameResolverResolvedAddressBuilder(item);
        _visitables.get("resolvedAddresses").add(builder);
        this.resolvedAddresses.add(builder);
    }
    return (A) this;
  }
  
  public ResolvedAddressesNested<A> addNewResolvedAddress() {
    return new ResolvedAddressesNested(-1, null);
  }
  
  public A addNewResolvedAddress(String ip,String lastLookupTime,Integer ttlSeconds) {
    return (A) this.addToResolvedAddresses(new DNSNameResolverResolvedAddress(ip, lastLookupTime, ttlSeconds));
  }
  
  public ResolvedAddressesNested<A> addNewResolvedAddressLike(DNSNameResolverResolvedAddress item) {
    return new ResolvedAddressesNested(-1, item);
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
  
  public A addToResolvedAddresses(DNSNameResolverResolvedAddress... items) {
    if (this.resolvedAddresses == null) {
      this.resolvedAddresses = new ArrayList();
    }
    for (DNSNameResolverResolvedAddress item : items) {
        DNSNameResolverResolvedAddressBuilder builder = new DNSNameResolverResolvedAddressBuilder(item);
        _visitables.get("resolvedAddresses").add(builder);
        this.resolvedAddresses.add(builder);
    }
    return (A) this;
  }
  
  public A addToResolvedAddresses(int index,DNSNameResolverResolvedAddress item) {
    if (this.resolvedAddresses == null) {
      this.resolvedAddresses = new ArrayList();
    }
    DNSNameResolverResolvedAddressBuilder builder = new DNSNameResolverResolvedAddressBuilder(item);
    if (index < 0 || index >= resolvedAddresses.size()) {
        _visitables.get("resolvedAddresses").add(builder);
        resolvedAddresses.add(builder);
    } else {
        _visitables.get("resolvedAddresses").add(builder);
        resolvedAddresses.add(index, builder);
    }
    return (A) this;
  }
  
  public DNSNameResolverResolvedAddress buildFirstResolvedAddress() {
    return this.resolvedAddresses.get(0).build();
  }
  
  public DNSNameResolverResolvedAddress buildLastResolvedAddress() {
    return this.resolvedAddresses.get(resolvedAddresses.size() - 1).build();
  }
  
  public DNSNameResolverResolvedAddress buildMatchingResolvedAddress(Predicate<DNSNameResolverResolvedAddressBuilder> predicate) {
      for (DNSNameResolverResolvedAddressBuilder item : resolvedAddresses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DNSNameResolverResolvedAddress buildResolvedAddress(int index) {
    return this.resolvedAddresses.get(index).build();
  }
  
  public List<DNSNameResolverResolvedAddress> buildResolvedAddresses() {
    return this.resolvedAddresses != null ? build(resolvedAddresses) : null;
  }
  
  protected void copyInstance(DNSNameResolverResolvedName instance) {
    instance = instance != null ? instance : new DNSNameResolverResolvedName();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withDnsName(instance.getDnsName());
        this.withResolutionFailures(instance.getResolutionFailures());
        this.withResolvedAddresses(instance.getResolvedAddresses());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResolvedAddressesNested<A> editFirstResolvedAddress() {
    if (resolvedAddresses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resolvedAddresses"));
    }
    return this.setNewResolvedAddressLike(0, this.buildResolvedAddress(0));
  }
  
  public ResolvedAddressesNested<A> editLastResolvedAddress() {
    int index = resolvedAddresses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resolvedAddresses"));
    }
    return this.setNewResolvedAddressLike(index, this.buildResolvedAddress(index));
  }
  
  public ResolvedAddressesNested<A> editMatchingResolvedAddress(Predicate<DNSNameResolverResolvedAddressBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resolvedAddresses.size();i++) {
      if (predicate.test(resolvedAddresses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resolvedAddresses"));
    }
    return this.setNewResolvedAddressLike(index, this.buildResolvedAddress(index));
  }
  
  public ResolvedAddressesNested<A> editResolvedAddress(int index) {
    if (resolvedAddresses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resolvedAddresses"));
    }
    return this.setNewResolvedAddressLike(index, this.buildResolvedAddress(index));
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
    DNSNameResolverResolvedNameFluent that = (DNSNameResolverResolvedNameFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(dnsName, that.dnsName))) {
      return false;
    }
    if (!(Objects.equals(resolutionFailures, that.resolutionFailures))) {
      return false;
    }
    if (!(Objects.equals(resolvedAddresses, that.resolvedAddresses))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public String getDnsName() {
    return this.dnsName;
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
  
  public Integer getResolutionFailures() {
    return this.resolutionFailures;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasDnsName() {
    return this.dnsName != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResolvedAddress(Predicate<DNSNameResolverResolvedAddressBuilder> predicate) {
      for (DNSNameResolverResolvedAddressBuilder item : resolvedAddresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasResolutionFailures() {
    return this.resolutionFailures != null;
  }
  
  public boolean hasResolvedAddresses() {
    return this.resolvedAddresses != null && !(this.resolvedAddresses.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conditions, dnsName, resolutionFailures, resolvedAddresses, additionalProperties);
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
  
  public A removeAllFromResolvedAddresses(Collection<DNSNameResolverResolvedAddress> items) {
    if (this.resolvedAddresses == null) {
      return (A) this;
    }
    for (DNSNameResolverResolvedAddress item : items) {
        DNSNameResolverResolvedAddressBuilder builder = new DNSNameResolverResolvedAddressBuilder(item);
        _visitables.get("resolvedAddresses").remove(builder);
        this.resolvedAddresses.remove(builder);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromResolvedAddresses(DNSNameResolverResolvedAddress... items) {
    if (this.resolvedAddresses == null) {
      return (A) this;
    }
    for (DNSNameResolverResolvedAddress item : items) {
        DNSNameResolverResolvedAddressBuilder builder = new DNSNameResolverResolvedAddressBuilder(item);
        _visitables.get("resolvedAddresses").remove(builder);
        this.resolvedAddresses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromResolvedAddresses(Predicate<DNSNameResolverResolvedAddressBuilder> predicate) {
    if (resolvedAddresses == null) {
      return (A) this;
    }
    Iterator<DNSNameResolverResolvedAddressBuilder> each = resolvedAddresses.iterator();
    List visitables = _visitables.get("resolvedAddresses");
    while (each.hasNext()) {
        DNSNameResolverResolvedAddressBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ResolvedAddressesNested<A> setNewResolvedAddressLike(int index,DNSNameResolverResolvedAddress item) {
    return new ResolvedAddressesNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToResolvedAddresses(int index,DNSNameResolverResolvedAddress item) {
    if (this.resolvedAddresses == null) {
      this.resolvedAddresses = new ArrayList();
    }
    DNSNameResolverResolvedAddressBuilder builder = new DNSNameResolverResolvedAddressBuilder(item);
    if (index < 0 || index >= resolvedAddresses.size()) {
        _visitables.get("resolvedAddresses").add(builder);
        resolvedAddresses.add(builder);
    } else {
        _visitables.get("resolvedAddresses").add(builder);
        resolvedAddresses.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(dnsName == null)) {
        sb.append("dnsName:");
        sb.append(dnsName);
        sb.append(",");
    }
    if (!(resolutionFailures == null)) {
        sb.append("resolutionFailures:");
        sb.append(resolutionFailures);
        sb.append(",");
    }
    if (!(resolvedAddresses == null) && !(resolvedAddresses.isEmpty())) {
        sb.append("resolvedAddresses:");
        sb.append(resolvedAddresses);
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
  
  public A withDnsName(String dnsName) {
    this.dnsName = dnsName;
    return (A) this;
  }
  
  public A withResolutionFailures(Integer resolutionFailures) {
    this.resolutionFailures = resolutionFailures;
    return (A) this;
  }
  
  public A withResolvedAddresses(List<DNSNameResolverResolvedAddress> resolvedAddresses) {
    if (this.resolvedAddresses != null) {
      this._visitables.get("resolvedAddresses").clear();
    }
    if (resolvedAddresses != null) {
        this.resolvedAddresses = new ArrayList();
        for (DNSNameResolverResolvedAddress item : resolvedAddresses) {
          this.addToResolvedAddresses(item);
        }
    } else {
      this.resolvedAddresses = null;
    }
    return (A) this;
  }
  
  public A withResolvedAddresses(DNSNameResolverResolvedAddress... resolvedAddresses) {
    if (this.resolvedAddresses != null) {
        this.resolvedAddresses.clear();
        _visitables.remove("resolvedAddresses");
    }
    if (resolvedAddresses != null) {
      for (DNSNameResolverResolvedAddress item : resolvedAddresses) {
        this.addToResolvedAddresses(item);
      }
    }
    return (A) this;
  }
  public class ResolvedAddressesNested<N> extends DNSNameResolverResolvedAddressFluent<ResolvedAddressesNested<N>> implements Nested<N>{
  
    DNSNameResolverResolvedAddressBuilder builder;
    int index;
  
    ResolvedAddressesNested(int index,DNSNameResolverResolvedAddress item) {
      this.index = index;
      this.builder = new DNSNameResolverResolvedAddressBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSNameResolverResolvedNameFluent.this.setToResolvedAddresses(index, builder.build());
    }
    
    public N endResolvedAddress() {
      return and();
    }
    
  }
}