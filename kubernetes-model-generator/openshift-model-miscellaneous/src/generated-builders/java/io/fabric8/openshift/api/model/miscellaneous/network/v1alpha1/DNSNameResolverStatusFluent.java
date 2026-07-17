package io.fabric8.openshift.api.model.miscellaneous.network.v1alpha1;

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
public class DNSNameResolverStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.network.v1alpha1.DNSNameResolverStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<DNSNameResolverResolvedNameBuilder> resolvedNames = new ArrayList<DNSNameResolverResolvedNameBuilder>();

  public DNSNameResolverStatusFluent() {
  }
  
  public DNSNameResolverStatusFluent(DNSNameResolverStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToResolvedNames(Collection<DNSNameResolverResolvedName> items) {
    if (this.resolvedNames == null) {
      this.resolvedNames = new ArrayList();
    }
    for (DNSNameResolverResolvedName item : items) {
        DNSNameResolverResolvedNameBuilder builder = new DNSNameResolverResolvedNameBuilder(item);
        _visitables.get("resolvedNames").add(builder);
        this.resolvedNames.add(builder);
    }
    return (A) this;
  }
  
  public ResolvedNamesNested<A> addNewResolvedName() {
    return new ResolvedNamesNested(-1, null);
  }
  
  public ResolvedNamesNested<A> addNewResolvedNameLike(DNSNameResolverResolvedName item) {
    return new ResolvedNamesNested(-1, item);
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
  
  public A addToResolvedNames(DNSNameResolverResolvedName... items) {
    if (this.resolvedNames == null) {
      this.resolvedNames = new ArrayList();
    }
    for (DNSNameResolverResolvedName item : items) {
        DNSNameResolverResolvedNameBuilder builder = new DNSNameResolverResolvedNameBuilder(item);
        _visitables.get("resolvedNames").add(builder);
        this.resolvedNames.add(builder);
    }
    return (A) this;
  }
  
  public A addToResolvedNames(int index,DNSNameResolverResolvedName item) {
    if (this.resolvedNames == null) {
      this.resolvedNames = new ArrayList();
    }
    DNSNameResolverResolvedNameBuilder builder = new DNSNameResolverResolvedNameBuilder(item);
    if (index < 0 || index >= resolvedNames.size()) {
        _visitables.get("resolvedNames").add(builder);
        resolvedNames.add(builder);
    } else {
        _visitables.get("resolvedNames").add(builder);
        resolvedNames.add(index, builder);
    }
    return (A) this;
  }
  
  public DNSNameResolverResolvedName buildFirstResolvedName() {
    return this.resolvedNames.get(0).build();
  }
  
  public DNSNameResolverResolvedName buildLastResolvedName() {
    return this.resolvedNames.get(resolvedNames.size() - 1).build();
  }
  
  public DNSNameResolverResolvedName buildMatchingResolvedName(Predicate<DNSNameResolverResolvedNameBuilder> predicate) {
      for (DNSNameResolverResolvedNameBuilder item : resolvedNames) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DNSNameResolverResolvedName buildResolvedName(int index) {
    return this.resolvedNames.get(index).build();
  }
  
  public List<DNSNameResolverResolvedName> buildResolvedNames() {
    return this.resolvedNames != null ? build(resolvedNames) : null;
  }
  
  protected void copyInstance(DNSNameResolverStatus instance) {
    instance = instance != null ? instance : new DNSNameResolverStatus();
    if (instance != null) {
        this.withResolvedNames(instance.getResolvedNames());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResolvedNamesNested<A> editFirstResolvedName() {
    if (resolvedNames.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resolvedNames"));
    }
    return this.setNewResolvedNameLike(0, this.buildResolvedName(0));
  }
  
  public ResolvedNamesNested<A> editLastResolvedName() {
    int index = resolvedNames.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resolvedNames"));
    }
    return this.setNewResolvedNameLike(index, this.buildResolvedName(index));
  }
  
  public ResolvedNamesNested<A> editMatchingResolvedName(Predicate<DNSNameResolverResolvedNameBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resolvedNames.size();i++) {
      if (predicate.test(resolvedNames.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resolvedNames"));
    }
    return this.setNewResolvedNameLike(index, this.buildResolvedName(index));
  }
  
  public ResolvedNamesNested<A> editResolvedName(int index) {
    if (resolvedNames.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resolvedNames"));
    }
    return this.setNewResolvedNameLike(index, this.buildResolvedName(index));
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
    DNSNameResolverStatusFluent that = (DNSNameResolverStatusFluent) o;
    if (!(Objects.equals(resolvedNames, that.resolvedNames))) {
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
  
  public boolean hasMatchingResolvedName(Predicate<DNSNameResolverResolvedNameBuilder> predicate) {
      for (DNSNameResolverResolvedNameBuilder item : resolvedNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasResolvedNames() {
    return this.resolvedNames != null && !(this.resolvedNames.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(resolvedNames, additionalProperties);
  }
  
  public A removeAllFromResolvedNames(Collection<DNSNameResolverResolvedName> items) {
    if (this.resolvedNames == null) {
      return (A) this;
    }
    for (DNSNameResolverResolvedName item : items) {
        DNSNameResolverResolvedNameBuilder builder = new DNSNameResolverResolvedNameBuilder(item);
        _visitables.get("resolvedNames").remove(builder);
        this.resolvedNames.remove(builder);
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
  
  public A removeFromResolvedNames(DNSNameResolverResolvedName... items) {
    if (this.resolvedNames == null) {
      return (A) this;
    }
    for (DNSNameResolverResolvedName item : items) {
        DNSNameResolverResolvedNameBuilder builder = new DNSNameResolverResolvedNameBuilder(item);
        _visitables.get("resolvedNames").remove(builder);
        this.resolvedNames.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromResolvedNames(Predicate<DNSNameResolverResolvedNameBuilder> predicate) {
    if (resolvedNames == null) {
      return (A) this;
    }
    Iterator<DNSNameResolverResolvedNameBuilder> each = resolvedNames.iterator();
    List visitables = _visitables.get("resolvedNames");
    while (each.hasNext()) {
        DNSNameResolverResolvedNameBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ResolvedNamesNested<A> setNewResolvedNameLike(int index,DNSNameResolverResolvedName item) {
    return new ResolvedNamesNested(index, item);
  }
  
  public A setToResolvedNames(int index,DNSNameResolverResolvedName item) {
    if (this.resolvedNames == null) {
      this.resolvedNames = new ArrayList();
    }
    DNSNameResolverResolvedNameBuilder builder = new DNSNameResolverResolvedNameBuilder(item);
    if (index < 0 || index >= resolvedNames.size()) {
        _visitables.get("resolvedNames").add(builder);
        resolvedNames.add(builder);
    } else {
        _visitables.get("resolvedNames").add(builder);
        resolvedNames.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(resolvedNames == null) && !(resolvedNames.isEmpty())) {
        sb.append("resolvedNames:");
        sb.append(resolvedNames);
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
  
  public A withResolvedNames(List<DNSNameResolverResolvedName> resolvedNames) {
    if (this.resolvedNames != null) {
      this._visitables.get("resolvedNames").clear();
    }
    if (resolvedNames != null) {
        this.resolvedNames = new ArrayList();
        for (DNSNameResolverResolvedName item : resolvedNames) {
          this.addToResolvedNames(item);
        }
    } else {
      this.resolvedNames = null;
    }
    return (A) this;
  }
  
  public A withResolvedNames(DNSNameResolverResolvedName... resolvedNames) {
    if (this.resolvedNames != null) {
        this.resolvedNames.clear();
        _visitables.remove("resolvedNames");
    }
    if (resolvedNames != null) {
      for (DNSNameResolverResolvedName item : resolvedNames) {
        this.addToResolvedNames(item);
      }
    }
    return (A) this;
  }
  public class ResolvedNamesNested<N> extends DNSNameResolverResolvedNameFluent<ResolvedNamesNested<N>> implements Nested<N>{
  
    DNSNameResolverResolvedNameBuilder builder;
    int index;
  
    ResolvedNamesNested(int index,DNSNameResolverResolvedName item) {
      this.index = index;
      this.builder = new DNSNameResolverResolvedNameBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSNameResolverStatusFluent.this.setToResolvedNames(index, builder.build());
    }
    
    public N endResolvedName() {
      return and();
    }
    
  }
}