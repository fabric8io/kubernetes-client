package io.fabric8.openclustermanagement.api.model.cluster.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedNamespaceConfig;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedNamespaceConfigBuilder;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedNamespaceConfigFluent;
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
public class ManagedClusterSetSpecFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta2.ManagedClusterSetSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ManagedClusterSelectorBuilder clusterSelector;
  private ArrayList<ManagedNamespaceConfigBuilder> managedNamespaces = new ArrayList<ManagedNamespaceConfigBuilder>();

  public ManagedClusterSetSpecFluent() {
  }
  
  public ManagedClusterSetSpecFluent(ManagedClusterSetSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToManagedNamespaces(Collection<ManagedNamespaceConfig> items) {
    if (this.managedNamespaces == null) {
      this.managedNamespaces = new ArrayList();
    }
    for (ManagedNamespaceConfig item : items) {
        ManagedNamespaceConfigBuilder builder = new ManagedNamespaceConfigBuilder(item);
        _visitables.get("managedNamespaces").add(builder);
        this.managedNamespaces.add(builder);
    }
    return (A) this;
  }
  
  public ManagedNamespacesNested<A> addNewManagedNamespace() {
    return new ManagedNamespacesNested(-1, null);
  }
  
  public A addNewManagedNamespace(String name) {
    return (A) this.addToManagedNamespaces(new ManagedNamespaceConfig(name));
  }
  
  public ManagedNamespacesNested<A> addNewManagedNamespaceLike(ManagedNamespaceConfig item) {
    return new ManagedNamespacesNested(-1, item);
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
  
  public A addToManagedNamespaces(ManagedNamespaceConfig... items) {
    if (this.managedNamespaces == null) {
      this.managedNamespaces = new ArrayList();
    }
    for (ManagedNamespaceConfig item : items) {
        ManagedNamespaceConfigBuilder builder = new ManagedNamespaceConfigBuilder(item);
        _visitables.get("managedNamespaces").add(builder);
        this.managedNamespaces.add(builder);
    }
    return (A) this;
  }
  
  public A addToManagedNamespaces(int index,ManagedNamespaceConfig item) {
    if (this.managedNamespaces == null) {
      this.managedNamespaces = new ArrayList();
    }
    ManagedNamespaceConfigBuilder builder = new ManagedNamespaceConfigBuilder(item);
    if (index < 0 || index >= managedNamespaces.size()) {
        _visitables.get("managedNamespaces").add(builder);
        managedNamespaces.add(builder);
    } else {
        _visitables.get("managedNamespaces").add(builder);
        managedNamespaces.add(index, builder);
    }
    return (A) this;
  }
  
  public ManagedClusterSelector buildClusterSelector() {
    return this.clusterSelector != null ? this.clusterSelector.build() : null;
  }
  
  public ManagedNamespaceConfig buildFirstManagedNamespace() {
    return this.managedNamespaces.get(0).build();
  }
  
  public ManagedNamespaceConfig buildLastManagedNamespace() {
    return this.managedNamespaces.get(managedNamespaces.size() - 1).build();
  }
  
  public ManagedNamespaceConfig buildManagedNamespace(int index) {
    return this.managedNamespaces.get(index).build();
  }
  
  public List<ManagedNamespaceConfig> buildManagedNamespaces() {
    return this.managedNamespaces != null ? build(managedNamespaces) : null;
  }
  
  public ManagedNamespaceConfig buildMatchingManagedNamespace(Predicate<ManagedNamespaceConfigBuilder> predicate) {
      for (ManagedNamespaceConfigBuilder item : managedNamespaces) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ManagedClusterSetSpec instance) {
    instance = instance != null ? instance : new ManagedClusterSetSpec();
    if (instance != null) {
        this.withClusterSelector(instance.getClusterSelector());
        this.withManagedNamespaces(instance.getManagedNamespaces());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterSelectorNested<A> editClusterSelector() {
    return this.withNewClusterSelectorLike(Optional.ofNullable(this.buildClusterSelector()).orElse(null));
  }
  
  public ManagedNamespacesNested<A> editFirstManagedNamespace() {
    if (managedNamespaces.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "managedNamespaces"));
    }
    return this.setNewManagedNamespaceLike(0, this.buildManagedNamespace(0));
  }
  
  public ManagedNamespacesNested<A> editLastManagedNamespace() {
    int index = managedNamespaces.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "managedNamespaces"));
    }
    return this.setNewManagedNamespaceLike(index, this.buildManagedNamespace(index));
  }
  
  public ManagedNamespacesNested<A> editManagedNamespace(int index) {
    if (managedNamespaces.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "managedNamespaces"));
    }
    return this.setNewManagedNamespaceLike(index, this.buildManagedNamespace(index));
  }
  
  public ManagedNamespacesNested<A> editMatchingManagedNamespace(Predicate<ManagedNamespaceConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < managedNamespaces.size();i++) {
      if (predicate.test(managedNamespaces.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "managedNamespaces"));
    }
    return this.setNewManagedNamespaceLike(index, this.buildManagedNamespace(index));
  }
  
  public ClusterSelectorNested<A> editOrNewClusterSelector() {
    return this.withNewClusterSelectorLike(Optional.ofNullable(this.buildClusterSelector()).orElse(new ManagedClusterSelectorBuilder().build()));
  }
  
  public ClusterSelectorNested<A> editOrNewClusterSelectorLike(ManagedClusterSelector item) {
    return this.withNewClusterSelectorLike(Optional.ofNullable(this.buildClusterSelector()).orElse(item));
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
    ManagedClusterSetSpecFluent that = (ManagedClusterSetSpecFluent) o;
    if (!(Objects.equals(clusterSelector, that.clusterSelector))) {
      return false;
    }
    if (!(Objects.equals(managedNamespaces, that.managedNamespaces))) {
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
  
  public boolean hasClusterSelector() {
    return this.clusterSelector != null;
  }
  
  public boolean hasManagedNamespaces() {
    return this.managedNamespaces != null && !(this.managedNamespaces.isEmpty());
  }
  
  public boolean hasMatchingManagedNamespace(Predicate<ManagedNamespaceConfigBuilder> predicate) {
      for (ManagedNamespaceConfigBuilder item : managedNamespaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(clusterSelector, managedNamespaces, additionalProperties);
  }
  
  public A removeAllFromManagedNamespaces(Collection<ManagedNamespaceConfig> items) {
    if (this.managedNamespaces == null) {
      return (A) this;
    }
    for (ManagedNamespaceConfig item : items) {
        ManagedNamespaceConfigBuilder builder = new ManagedNamespaceConfigBuilder(item);
        _visitables.get("managedNamespaces").remove(builder);
        this.managedNamespaces.remove(builder);
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
  
  public A removeFromManagedNamespaces(ManagedNamespaceConfig... items) {
    if (this.managedNamespaces == null) {
      return (A) this;
    }
    for (ManagedNamespaceConfig item : items) {
        ManagedNamespaceConfigBuilder builder = new ManagedNamespaceConfigBuilder(item);
        _visitables.get("managedNamespaces").remove(builder);
        this.managedNamespaces.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromManagedNamespaces(Predicate<ManagedNamespaceConfigBuilder> predicate) {
    if (managedNamespaces == null) {
      return (A) this;
    }
    Iterator<ManagedNamespaceConfigBuilder> each = managedNamespaces.iterator();
    List visitables = _visitables.get("managedNamespaces");
    while (each.hasNext()) {
        ManagedNamespaceConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ManagedNamespacesNested<A> setNewManagedNamespaceLike(int index,ManagedNamespaceConfig item) {
    return new ManagedNamespacesNested(index, item);
  }
  
  public A setToManagedNamespaces(int index,ManagedNamespaceConfig item) {
    if (this.managedNamespaces == null) {
      this.managedNamespaces = new ArrayList();
    }
    ManagedNamespaceConfigBuilder builder = new ManagedNamespaceConfigBuilder(item);
    if (index < 0 || index >= managedNamespaces.size()) {
        _visitables.get("managedNamespaces").add(builder);
        managedNamespaces.add(builder);
    } else {
        _visitables.get("managedNamespaces").add(builder);
        managedNamespaces.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterSelector == null)) {
        sb.append("clusterSelector:");
        sb.append(clusterSelector);
        sb.append(",");
    }
    if (!(managedNamespaces == null) && !(managedNamespaces.isEmpty())) {
        sb.append("managedNamespaces:");
        sb.append(managedNamespaces);
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
  
  public A withClusterSelector(ManagedClusterSelector clusterSelector) {
    this._visitables.remove("clusterSelector");
    if (clusterSelector != null) {
        this.clusterSelector = new ManagedClusterSelectorBuilder(clusterSelector);
        this._visitables.get("clusterSelector").add(this.clusterSelector);
    } else {
        this.clusterSelector = null;
        this._visitables.get("clusterSelector").remove(this.clusterSelector);
    }
    return (A) this;
  }
  
  public A withManagedNamespaces(List<ManagedNamespaceConfig> managedNamespaces) {
    if (this.managedNamespaces != null) {
      this._visitables.get("managedNamespaces").clear();
    }
    if (managedNamespaces != null) {
        this.managedNamespaces = new ArrayList();
        for (ManagedNamespaceConfig item : managedNamespaces) {
          this.addToManagedNamespaces(item);
        }
    } else {
      this.managedNamespaces = null;
    }
    return (A) this;
  }
  
  public A withManagedNamespaces(ManagedNamespaceConfig... managedNamespaces) {
    if (this.managedNamespaces != null) {
        this.managedNamespaces.clear();
        _visitables.remove("managedNamespaces");
    }
    if (managedNamespaces != null) {
      for (ManagedNamespaceConfig item : managedNamespaces) {
        this.addToManagedNamespaces(item);
      }
    }
    return (A) this;
  }
  
  public ClusterSelectorNested<A> withNewClusterSelector() {
    return new ClusterSelectorNested(null);
  }
  
  public ClusterSelectorNested<A> withNewClusterSelectorLike(ManagedClusterSelector item) {
    return new ClusterSelectorNested(item);
  }
  public class ClusterSelectorNested<N> extends ManagedClusterSelectorFluent<ClusterSelectorNested<N>> implements Nested<N>{
  
    ManagedClusterSelectorBuilder builder;
  
    ClusterSelectorNested(ManagedClusterSelector item) {
      this.builder = new ManagedClusterSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ManagedClusterSetSpecFluent.this.withClusterSelector(builder.build());
    }
    
    public N endClusterSelector() {
      return and();
    }
    
  }
  public class ManagedNamespacesNested<N> extends ManagedNamespaceConfigFluent<ManagedNamespacesNested<N>> implements Nested<N>{
  
    ManagedNamespaceConfigBuilder builder;
    int index;
  
    ManagedNamespacesNested(int index,ManagedNamespaceConfig item) {
      this.index = index;
      this.builder = new ManagedNamespaceConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ManagedClusterSetSpecFluent.this.setToManagedNamespaces(index, builder.build());
    }
    
    public N endManagedNamespace() {
      return and();
    }
    
  }
}