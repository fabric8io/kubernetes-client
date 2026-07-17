package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ResourceQuotaStatus;
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
public class ClusterResourceQuotaStatusFluent<A extends io.fabric8.openshift.api.model.ClusterResourceQuotaStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ResourceQuotaStatusByNamespaceBuilder> namespaces = new ArrayList<ResourceQuotaStatusByNamespaceBuilder>();
  private ResourceQuotaStatus total;

  public ClusterResourceQuotaStatusFluent() {
  }
  
  public ClusterResourceQuotaStatusFluent(ClusterResourceQuotaStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToNamespaces(Collection<ResourceQuotaStatusByNamespace> items) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    for (ResourceQuotaStatusByNamespace item : items) {
        ResourceQuotaStatusByNamespaceBuilder builder = new ResourceQuotaStatusByNamespaceBuilder(item);
        _visitables.get("namespaces").add(builder);
        this.namespaces.add(builder);
    }
    return (A) this;
  }
  
  public NamespacesNested<A> addNewNamespace() {
    return new NamespacesNested(-1, null);
  }
  
  public NamespacesNested<A> addNewNamespaceLike(ResourceQuotaStatusByNamespace item) {
    return new NamespacesNested(-1, item);
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
  
  public A addToNamespaces(ResourceQuotaStatusByNamespace... items) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    for (ResourceQuotaStatusByNamespace item : items) {
        ResourceQuotaStatusByNamespaceBuilder builder = new ResourceQuotaStatusByNamespaceBuilder(item);
        _visitables.get("namespaces").add(builder);
        this.namespaces.add(builder);
    }
    return (A) this;
  }
  
  public A addToNamespaces(int index,ResourceQuotaStatusByNamespace item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    ResourceQuotaStatusByNamespaceBuilder builder = new ResourceQuotaStatusByNamespaceBuilder(item);
    if (index < 0 || index >= namespaces.size()) {
        _visitables.get("namespaces").add(builder);
        namespaces.add(builder);
    } else {
        _visitables.get("namespaces").add(builder);
        namespaces.add(index, builder);
    }
    return (A) this;
  }
  
  public ResourceQuotaStatusByNamespace buildFirstNamespace() {
    return this.namespaces.get(0).build();
  }
  
  public ResourceQuotaStatusByNamespace buildLastNamespace() {
    return this.namespaces.get(namespaces.size() - 1).build();
  }
  
  public ResourceQuotaStatusByNamespace buildMatchingNamespace(Predicate<ResourceQuotaStatusByNamespaceBuilder> predicate) {
      for (ResourceQuotaStatusByNamespaceBuilder item : namespaces) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourceQuotaStatusByNamespace buildNamespace(int index) {
    return this.namespaces.get(index).build();
  }
  
  public List<ResourceQuotaStatusByNamespace> buildNamespaces() {
    return this.namespaces != null ? build(namespaces) : null;
  }
  
  protected void copyInstance(ClusterResourceQuotaStatus instance) {
    instance = instance != null ? instance : new ClusterResourceQuotaStatus();
    if (instance != null) {
        this.withNamespaces(instance.getNamespaces());
        this.withTotal(instance.getTotal());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NamespacesNested<A> editFirstNamespace() {
    if (namespaces.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "namespaces"));
    }
    return this.setNewNamespaceLike(0, this.buildNamespace(0));
  }
  
  public NamespacesNested<A> editLastNamespace() {
    int index = namespaces.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "namespaces"));
    }
    return this.setNewNamespaceLike(index, this.buildNamespace(index));
  }
  
  public NamespacesNested<A> editMatchingNamespace(Predicate<ResourceQuotaStatusByNamespaceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < namespaces.size();i++) {
      if (predicate.test(namespaces.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "namespaces"));
    }
    return this.setNewNamespaceLike(index, this.buildNamespace(index));
  }
  
  public NamespacesNested<A> editNamespace(int index) {
    if (namespaces.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "namespaces"));
    }
    return this.setNewNamespaceLike(index, this.buildNamespace(index));
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
    ClusterResourceQuotaStatusFluent that = (ClusterResourceQuotaStatusFluent) o;
    if (!(Objects.equals(namespaces, that.namespaces))) {
      return false;
    }
    if (!(Objects.equals(total, that.total))) {
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
  
  public ResourceQuotaStatus getTotal() {
    return this.total;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingNamespace(Predicate<ResourceQuotaStatusByNamespaceBuilder> predicate) {
      for (ResourceQuotaStatusByNamespaceBuilder item : namespaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaces() {
    return this.namespaces != null && !(this.namespaces.isEmpty());
  }
  
  public boolean hasTotal() {
    return this.total != null;
  }
  
  public int hashCode() {
    return Objects.hash(namespaces, total, additionalProperties);
  }
  
  public A removeAllFromNamespaces(Collection<ResourceQuotaStatusByNamespace> items) {
    if (this.namespaces == null) {
      return (A) this;
    }
    for (ResourceQuotaStatusByNamespace item : items) {
        ResourceQuotaStatusByNamespaceBuilder builder = new ResourceQuotaStatusByNamespaceBuilder(item);
        _visitables.get("namespaces").remove(builder);
        this.namespaces.remove(builder);
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
  
  public A removeFromNamespaces(ResourceQuotaStatusByNamespace... items) {
    if (this.namespaces == null) {
      return (A) this;
    }
    for (ResourceQuotaStatusByNamespace item : items) {
        ResourceQuotaStatusByNamespaceBuilder builder = new ResourceQuotaStatusByNamespaceBuilder(item);
        _visitables.get("namespaces").remove(builder);
        this.namespaces.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromNamespaces(Predicate<ResourceQuotaStatusByNamespaceBuilder> predicate) {
    if (namespaces == null) {
      return (A) this;
    }
    Iterator<ResourceQuotaStatusByNamespaceBuilder> each = namespaces.iterator();
    List visitables = _visitables.get("namespaces");
    while (each.hasNext()) {
        ResourceQuotaStatusByNamespaceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public NamespacesNested<A> setNewNamespaceLike(int index,ResourceQuotaStatusByNamespace item) {
    return new NamespacesNested(index, item);
  }
  
  public A setToNamespaces(int index,ResourceQuotaStatusByNamespace item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    ResourceQuotaStatusByNamespaceBuilder builder = new ResourceQuotaStatusByNamespaceBuilder(item);
    if (index < 0 || index >= namespaces.size()) {
        _visitables.get("namespaces").add(builder);
        namespaces.add(builder);
    } else {
        _visitables.get("namespaces").add(builder);
        namespaces.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(namespaces == null) && !(namespaces.isEmpty())) {
        sb.append("namespaces:");
        sb.append(namespaces);
        sb.append(",");
    }
    if (!(total == null)) {
        sb.append("total:");
        sb.append(total);
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
  
  public A withNamespaces(List<ResourceQuotaStatusByNamespace> namespaces) {
    if (this.namespaces != null) {
      this._visitables.get("namespaces").clear();
    }
    if (namespaces != null) {
        this.namespaces = new ArrayList();
        for (ResourceQuotaStatusByNamespace item : namespaces) {
          this.addToNamespaces(item);
        }
    } else {
      this.namespaces = null;
    }
    return (A) this;
  }
  
  public A withNamespaces(ResourceQuotaStatusByNamespace... namespaces) {
    if (this.namespaces != null) {
        this.namespaces.clear();
        _visitables.remove("namespaces");
    }
    if (namespaces != null) {
      for (ResourceQuotaStatusByNamespace item : namespaces) {
        this.addToNamespaces(item);
      }
    }
    return (A) this;
  }
  
  public A withTotal(ResourceQuotaStatus total) {
    this.total = total;
    return (A) this;
  }
  public class NamespacesNested<N> extends ResourceQuotaStatusByNamespaceFluent<NamespacesNested<N>> implements Nested<N>{
  
    ResourceQuotaStatusByNamespaceBuilder builder;
    int index;
  
    NamespacesNested(int index,ResourceQuotaStatusByNamespace item) {
      this.index = index;
      this.builder = new ResourceQuotaStatusByNamespaceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterResourceQuotaStatusFluent.this.setToNamespaces(index, builder.build());
    }
    
    public N endNamespace() {
      return and();
    }
    
  }
}