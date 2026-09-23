package io.fabric8.openshift.api.model.installer.aws.v1;

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
public class HostPlacementFluent<A extends io.fabric8.openshift.api.model.installer.aws.v1.HostPlacementFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String affinity;
  private ArrayList<DedicatedHostBuilder> dedicatedHost = new ArrayList<DedicatedHostBuilder>();

  public HostPlacementFluent() {
  }
  
  public HostPlacementFluent(HostPlacement instance) {
    this.copyInstance(instance);
  }

  public A addAllToDedicatedHost(Collection<DedicatedHost> items) {
    if (this.dedicatedHost == null) {
      this.dedicatedHost = new ArrayList();
    }
    for (DedicatedHost item : items) {
        DedicatedHostBuilder builder = new DedicatedHostBuilder(item);
        _visitables.get("dedicatedHost").add(builder);
        this.dedicatedHost.add(builder);
    }
    return (A) this;
  }
  
  public DedicatedHostNested<A> addNewDedicatedHost() {
    return new DedicatedHostNested(-1, null);
  }
  
  public A addNewDedicatedHost(String id) {
    return (A) this.addToDedicatedHost(new DedicatedHost(id));
  }
  
  public DedicatedHostNested<A> addNewDedicatedHostLike(DedicatedHost item) {
    return new DedicatedHostNested(-1, item);
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
  
  public A addToDedicatedHost(DedicatedHost... items) {
    if (this.dedicatedHost == null) {
      this.dedicatedHost = new ArrayList();
    }
    for (DedicatedHost item : items) {
        DedicatedHostBuilder builder = new DedicatedHostBuilder(item);
        _visitables.get("dedicatedHost").add(builder);
        this.dedicatedHost.add(builder);
    }
    return (A) this;
  }
  
  public A addToDedicatedHost(int index,DedicatedHost item) {
    if (this.dedicatedHost == null) {
      this.dedicatedHost = new ArrayList();
    }
    DedicatedHostBuilder builder = new DedicatedHostBuilder(item);
    if (index < 0 || index >= dedicatedHost.size()) {
        _visitables.get("dedicatedHost").add(builder);
        dedicatedHost.add(builder);
    } else {
        _visitables.get("dedicatedHost").add(builder);
        dedicatedHost.add(index, builder);
    }
    return (A) this;
  }
  
  public List<DedicatedHost> buildDedicatedHost() {
    return this.dedicatedHost != null ? build(dedicatedHost) : null;
  }
  
  public DedicatedHost buildDedicatedHost(int index) {
    return this.dedicatedHost.get(index).build();
  }
  
  public DedicatedHost buildFirstDedicatedHost() {
    return this.dedicatedHost.get(0).build();
  }
  
  public DedicatedHost buildLastDedicatedHost() {
    return this.dedicatedHost.get(dedicatedHost.size() - 1).build();
  }
  
  public DedicatedHost buildMatchingDedicatedHost(Predicate<DedicatedHostBuilder> predicate) {
      for (DedicatedHostBuilder item : dedicatedHost) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(HostPlacement instance) {
    instance = instance != null ? instance : new HostPlacement();
    if (instance != null) {
        this.withAffinity(instance.getAffinity());
        this.withDedicatedHost(instance.getDedicatedHost());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DedicatedHostNested<A> editDedicatedHost(int index) {
    if (dedicatedHost.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dedicatedHost"));
    }
    return this.setNewDedicatedHostLike(index, this.buildDedicatedHost(index));
  }
  
  public DedicatedHostNested<A> editFirstDedicatedHost() {
    if (dedicatedHost.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dedicatedHost"));
    }
    return this.setNewDedicatedHostLike(0, this.buildDedicatedHost(0));
  }
  
  public DedicatedHostNested<A> editLastDedicatedHost() {
    int index = dedicatedHost.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dedicatedHost"));
    }
    return this.setNewDedicatedHostLike(index, this.buildDedicatedHost(index));
  }
  
  public DedicatedHostNested<A> editMatchingDedicatedHost(Predicate<DedicatedHostBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < dedicatedHost.size();i++) {
      if (predicate.test(dedicatedHost.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "dedicatedHost"));
    }
    return this.setNewDedicatedHostLike(index, this.buildDedicatedHost(index));
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
    HostPlacementFluent that = (HostPlacementFluent) o;
    if (!(Objects.equals(affinity, that.affinity))) {
      return false;
    }
    if (!(Objects.equals(dedicatedHost, that.dedicatedHost))) {
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
  
  public String getAffinity() {
    return this.affinity;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAffinity() {
    return this.affinity != null;
  }
  
  public boolean hasDedicatedHost() {
    return this.dedicatedHost != null && !(this.dedicatedHost.isEmpty());
  }
  
  public boolean hasMatchingDedicatedHost(Predicate<DedicatedHostBuilder> predicate) {
      for (DedicatedHostBuilder item : dedicatedHost) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(affinity, dedicatedHost, additionalProperties);
  }
  
  public A removeAllFromDedicatedHost(Collection<DedicatedHost> items) {
    if (this.dedicatedHost == null) {
      return (A) this;
    }
    for (DedicatedHost item : items) {
        DedicatedHostBuilder builder = new DedicatedHostBuilder(item);
        _visitables.get("dedicatedHost").remove(builder);
        this.dedicatedHost.remove(builder);
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
  
  public A removeFromDedicatedHost(DedicatedHost... items) {
    if (this.dedicatedHost == null) {
      return (A) this;
    }
    for (DedicatedHost item : items) {
        DedicatedHostBuilder builder = new DedicatedHostBuilder(item);
        _visitables.get("dedicatedHost").remove(builder);
        this.dedicatedHost.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDedicatedHost(Predicate<DedicatedHostBuilder> predicate) {
    if (dedicatedHost == null) {
      return (A) this;
    }
    Iterator<DedicatedHostBuilder> each = dedicatedHost.iterator();
    List visitables = _visitables.get("dedicatedHost");
    while (each.hasNext()) {
        DedicatedHostBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DedicatedHostNested<A> setNewDedicatedHostLike(int index,DedicatedHost item) {
    return new DedicatedHostNested(index, item);
  }
  
  public A setToDedicatedHost(int index,DedicatedHost item) {
    if (this.dedicatedHost == null) {
      this.dedicatedHost = new ArrayList();
    }
    DedicatedHostBuilder builder = new DedicatedHostBuilder(item);
    if (index < 0 || index >= dedicatedHost.size()) {
        _visitables.get("dedicatedHost").add(builder);
        dedicatedHost.add(builder);
    } else {
        _visitables.get("dedicatedHost").add(builder);
        dedicatedHost.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(affinity == null)) {
        sb.append("affinity:");
        sb.append(affinity);
        sb.append(",");
    }
    if (!(dedicatedHost == null) && !(dedicatedHost.isEmpty())) {
        sb.append("dedicatedHost:");
        sb.append(dedicatedHost);
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
  
  public A withAffinity(String affinity) {
    this.affinity = affinity;
    return (A) this;
  }
  
  public A withDedicatedHost(List<DedicatedHost> dedicatedHost) {
    if (this.dedicatedHost != null) {
      this._visitables.get("dedicatedHost").clear();
    }
    if (dedicatedHost != null) {
        this.dedicatedHost = new ArrayList();
        for (DedicatedHost item : dedicatedHost) {
          this.addToDedicatedHost(item);
        }
    } else {
      this.dedicatedHost = null;
    }
    return (A) this;
  }
  
  public A withDedicatedHost(DedicatedHost... dedicatedHost) {
    if (this.dedicatedHost != null) {
        this.dedicatedHost.clear();
        _visitables.remove("dedicatedHost");
    }
    if (dedicatedHost != null) {
      for (DedicatedHost item : dedicatedHost) {
        this.addToDedicatedHost(item);
      }
    }
    return (A) this;
  }
  public class DedicatedHostNested<N> extends DedicatedHostFluent<DedicatedHostNested<N>> implements Nested<N>{
  
    DedicatedHostBuilder builder;
    int index;
  
    DedicatedHostNested(int index,DedicatedHost item) {
      this.index = index;
      this.builder = new DedicatedHostBuilder(this, item);
    }
  
    public N and() {
      return (N) HostPlacementFluent.this.setToDedicatedHost(index, builder.build());
    }
    
    public N endDedicatedHost() {
      return and();
    }
    
  }
}