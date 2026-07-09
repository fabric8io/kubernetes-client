package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.gatewayapi.v1.BackendRef;
import io.fabric8.kubernetes.api.model.gatewayapi.v1.BackendRefBuilder;
import io.fabric8.kubernetes.api.model.gatewayapi.v1.BackendRefFluent;
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
public class TLSRouteRuleFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.TLSRouteRuleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<BackendRefBuilder> backendRefs = new ArrayList<BackendRefBuilder>();
  private String name;

  public TLSRouteRuleFluent() {
  }
  
  public TLSRouteRuleFluent(TLSRouteRule instance) {
    this.copyInstance(instance);
  }

  public A addAllToBackendRefs(Collection<BackendRef> items) {
    if (this.backendRefs == null) {
      this.backendRefs = new ArrayList();
    }
    for (BackendRef item : items) {
        BackendRefBuilder builder = new BackendRefBuilder(item);
        _visitables.get("backendRefs").add(builder);
        this.backendRefs.add(builder);
    }
    return (A) this;
  }
  
  public BackendRefsNested<A> addNewBackendRef() {
    return new BackendRefsNested(-1, null);
  }
  
  public BackendRefsNested<A> addNewBackendRefLike(BackendRef item) {
    return new BackendRefsNested(-1, item);
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
  
  public A addToBackendRefs(BackendRef... items) {
    if (this.backendRefs == null) {
      this.backendRefs = new ArrayList();
    }
    for (BackendRef item : items) {
        BackendRefBuilder builder = new BackendRefBuilder(item);
        _visitables.get("backendRefs").add(builder);
        this.backendRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addToBackendRefs(int index,BackendRef item) {
    if (this.backendRefs == null) {
      this.backendRefs = new ArrayList();
    }
    BackendRefBuilder builder = new BackendRefBuilder(item);
    if (index < 0 || index >= backendRefs.size()) {
        _visitables.get("backendRefs").add(builder);
        backendRefs.add(builder);
    } else {
        _visitables.get("backendRefs").add(builder);
        backendRefs.add(index, builder);
    }
    return (A) this;
  }
  
  public BackendRef buildBackendRef(int index) {
    return this.backendRefs.get(index).build();
  }
  
  public List<BackendRef> buildBackendRefs() {
    return this.backendRefs != null ? build(backendRefs) : null;
  }
  
  public BackendRef buildFirstBackendRef() {
    return this.backendRefs.get(0).build();
  }
  
  public BackendRef buildLastBackendRef() {
    return this.backendRefs.get(backendRefs.size() - 1).build();
  }
  
  public BackendRef buildMatchingBackendRef(Predicate<BackendRefBuilder> predicate) {
      for (BackendRefBuilder item : backendRefs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(TLSRouteRule instance) {
    instance = instance != null ? instance : new TLSRouteRule();
    if (instance != null) {
        this.withBackendRefs(instance.getBackendRefs());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BackendRefsNested<A> editBackendRef(int index) {
    if (backendRefs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "backendRefs"));
    }
    return this.setNewBackendRefLike(index, this.buildBackendRef(index));
  }
  
  public BackendRefsNested<A> editFirstBackendRef() {
    if (backendRefs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "backendRefs"));
    }
    return this.setNewBackendRefLike(0, this.buildBackendRef(0));
  }
  
  public BackendRefsNested<A> editLastBackendRef() {
    int index = backendRefs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "backendRefs"));
    }
    return this.setNewBackendRefLike(index, this.buildBackendRef(index));
  }
  
  public BackendRefsNested<A> editMatchingBackendRef(Predicate<BackendRefBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < backendRefs.size();i++) {
      if (predicate.test(backendRefs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "backendRefs"));
    }
    return this.setNewBackendRefLike(index, this.buildBackendRef(index));
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
    TLSRouteRuleFluent that = (TLSRouteRuleFluent) o;
    if (!(Objects.equals(backendRefs, that.backendRefs))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBackendRefs() {
    return this.backendRefs != null && !(this.backendRefs.isEmpty());
  }
  
  public boolean hasMatchingBackendRef(Predicate<BackendRefBuilder> predicate) {
      for (BackendRefBuilder item : backendRefs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(backendRefs, name, additionalProperties);
  }
  
  public A removeAllFromBackendRefs(Collection<BackendRef> items) {
    if (this.backendRefs == null) {
      return (A) this;
    }
    for (BackendRef item : items) {
        BackendRefBuilder builder = new BackendRefBuilder(item);
        _visitables.get("backendRefs").remove(builder);
        this.backendRefs.remove(builder);
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
  
  public A removeFromBackendRefs(BackendRef... items) {
    if (this.backendRefs == null) {
      return (A) this;
    }
    for (BackendRef item : items) {
        BackendRefBuilder builder = new BackendRefBuilder(item);
        _visitables.get("backendRefs").remove(builder);
        this.backendRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromBackendRefs(Predicate<BackendRefBuilder> predicate) {
    if (backendRefs == null) {
      return (A) this;
    }
    Iterator<BackendRefBuilder> each = backendRefs.iterator();
    List visitables = _visitables.get("backendRefs");
    while (each.hasNext()) {
        BackendRefBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public BackendRefsNested<A> setNewBackendRefLike(int index,BackendRef item) {
    return new BackendRefsNested(index, item);
  }
  
  public A setToBackendRefs(int index,BackendRef item) {
    if (this.backendRefs == null) {
      this.backendRefs = new ArrayList();
    }
    BackendRefBuilder builder = new BackendRefBuilder(item);
    if (index < 0 || index >= backendRefs.size()) {
        _visitables.get("backendRefs").add(builder);
        backendRefs.add(builder);
    } else {
        _visitables.get("backendRefs").add(builder);
        backendRefs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(backendRefs == null) && !(backendRefs.isEmpty())) {
        sb.append("backendRefs:");
        sb.append(backendRefs);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withBackendRefs(List<BackendRef> backendRefs) {
    if (this.backendRefs != null) {
      this._visitables.get("backendRefs").clear();
    }
    if (backendRefs != null) {
        this.backendRefs = new ArrayList();
        for (BackendRef item : backendRefs) {
          this.addToBackendRefs(item);
        }
    } else {
      this.backendRefs = null;
    }
    return (A) this;
  }
  
  public A withBackendRefs(BackendRef... backendRefs) {
    if (this.backendRefs != null) {
        this.backendRefs.clear();
        _visitables.remove("backendRefs");
    }
    if (backendRefs != null) {
      for (BackendRef item : backendRefs) {
        this.addToBackendRefs(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  public class BackendRefsNested<N> extends BackendRefFluent<BackendRefsNested<N>> implements Nested<N>{
  
    BackendRefBuilder builder;
    int index;
  
    BackendRefsNested(int index,BackendRef item) {
      this.index = index;
      this.builder = new BackendRefBuilder(this, item);
    }
  
    public N and() {
      return (N) TLSRouteRuleFluent.this.setToBackendRefs(index, builder.build());
    }
    
    public N endBackendRef() {
      return and();
    }
    
  }
}