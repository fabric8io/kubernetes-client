package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class GenericPlacementFieldsFluent<A extends io.fabric8.openclustermanagement.api.model.apps.v1.GenericPlacementFieldsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LabelSelectorBuilder clusterSelector;
  private ArrayList<GenericClusterReferenceBuilder> clusters = new ArrayList<GenericClusterReferenceBuilder>();

  public GenericPlacementFieldsFluent() {
  }
  
  public GenericPlacementFieldsFluent(GenericPlacementFields instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusters(Collection<GenericClusterReference> items) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    for (GenericClusterReference item : items) {
        GenericClusterReferenceBuilder builder = new GenericClusterReferenceBuilder(item);
        _visitables.get("clusters").add(builder);
        this.clusters.add(builder);
    }
    return (A) this;
  }
  
  public ClustersNested<A> addNewCluster() {
    return new ClustersNested(-1, null);
  }
  
  public A addNewCluster(String name) {
    return (A) this.addToClusters(new GenericClusterReference(name));
  }
  
  public ClustersNested<A> addNewClusterLike(GenericClusterReference item) {
    return new ClustersNested(-1, item);
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
  
  public A addToClusters(GenericClusterReference... items) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    for (GenericClusterReference item : items) {
        GenericClusterReferenceBuilder builder = new GenericClusterReferenceBuilder(item);
        _visitables.get("clusters").add(builder);
        this.clusters.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusters(int index,GenericClusterReference item) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    GenericClusterReferenceBuilder builder = new GenericClusterReferenceBuilder(item);
    if (index < 0 || index >= clusters.size()) {
        _visitables.get("clusters").add(builder);
        clusters.add(builder);
    } else {
        _visitables.get("clusters").add(builder);
        clusters.add(index, builder);
    }
    return (A) this;
  }
  
  public GenericClusterReference buildCluster(int index) {
    return this.clusters.get(index).build();
  }
  
  public LabelSelector buildClusterSelector() {
    return this.clusterSelector != null ? this.clusterSelector.build() : null;
  }
  
  public List<GenericClusterReference> buildClusters() {
    return this.clusters != null ? build(clusters) : null;
  }
  
  public GenericClusterReference buildFirstCluster() {
    return this.clusters.get(0).build();
  }
  
  public GenericClusterReference buildLastCluster() {
    return this.clusters.get(clusters.size() - 1).build();
  }
  
  public GenericClusterReference buildMatchingCluster(Predicate<GenericClusterReferenceBuilder> predicate) {
      for (GenericClusterReferenceBuilder item : clusters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(GenericPlacementFields instance) {
    instance = instance != null ? instance : new GenericPlacementFields();
    if (instance != null) {
        this.withClusterSelector(instance.getClusterSelector());
        this.withClusters(instance.getClusters());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClustersNested<A> editCluster(int index) {
    if (clusters.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusters"));
    }
    return this.setNewClusterLike(index, this.buildCluster(index));
  }
  
  public ClusterSelectorNested<A> editClusterSelector() {
    return this.withNewClusterSelectorLike(Optional.ofNullable(this.buildClusterSelector()).orElse(null));
  }
  
  public ClustersNested<A> editFirstCluster() {
    if (clusters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusters"));
    }
    return this.setNewClusterLike(0, this.buildCluster(0));
  }
  
  public ClustersNested<A> editLastCluster() {
    int index = clusters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusters"));
    }
    return this.setNewClusterLike(index, this.buildCluster(index));
  }
  
  public ClustersNested<A> editMatchingCluster(Predicate<GenericClusterReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusters.size();i++) {
      if (predicate.test(clusters.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusters"));
    }
    return this.setNewClusterLike(index, this.buildCluster(index));
  }
  
  public ClusterSelectorNested<A> editOrNewClusterSelector() {
    return this.withNewClusterSelectorLike(Optional.ofNullable(this.buildClusterSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public ClusterSelectorNested<A> editOrNewClusterSelectorLike(LabelSelector item) {
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
    GenericPlacementFieldsFluent that = (GenericPlacementFieldsFluent) o;
    if (!(Objects.equals(clusterSelector, that.clusterSelector))) {
      return false;
    }
    if (!(Objects.equals(clusters, that.clusters))) {
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
  
  public boolean hasClusters() {
    return this.clusters != null && !(this.clusters.isEmpty());
  }
  
  public boolean hasMatchingCluster(Predicate<GenericClusterReferenceBuilder> predicate) {
      for (GenericClusterReferenceBuilder item : clusters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(clusterSelector, clusters, additionalProperties);
  }
  
  public A removeAllFromClusters(Collection<GenericClusterReference> items) {
    if (this.clusters == null) {
      return (A) this;
    }
    for (GenericClusterReference item : items) {
        GenericClusterReferenceBuilder builder = new GenericClusterReferenceBuilder(item);
        _visitables.get("clusters").remove(builder);
        this.clusters.remove(builder);
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
  
  public A removeFromClusters(GenericClusterReference... items) {
    if (this.clusters == null) {
      return (A) this;
    }
    for (GenericClusterReference item : items) {
        GenericClusterReferenceBuilder builder = new GenericClusterReferenceBuilder(item);
        _visitables.get("clusters").remove(builder);
        this.clusters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromClusters(Predicate<GenericClusterReferenceBuilder> predicate) {
    if (clusters == null) {
      return (A) this;
    }
    Iterator<GenericClusterReferenceBuilder> each = clusters.iterator();
    List visitables = _visitables.get("clusters");
    while (each.hasNext()) {
        GenericClusterReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ClustersNested<A> setNewClusterLike(int index,GenericClusterReference item) {
    return new ClustersNested(index, item);
  }
  
  public A setToClusters(int index,GenericClusterReference item) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    GenericClusterReferenceBuilder builder = new GenericClusterReferenceBuilder(item);
    if (index < 0 || index >= clusters.size()) {
        _visitables.get("clusters").add(builder);
        clusters.add(builder);
    } else {
        _visitables.get("clusters").add(builder);
        clusters.set(index, builder);
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
    if (!(clusters == null) && !(clusters.isEmpty())) {
        sb.append("clusters:");
        sb.append(clusters);
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
  
  public A withClusterSelector(LabelSelector clusterSelector) {
    this._visitables.remove("clusterSelector");
    if (clusterSelector != null) {
        this.clusterSelector = new LabelSelectorBuilder(clusterSelector);
        this._visitables.get("clusterSelector").add(this.clusterSelector);
    } else {
        this.clusterSelector = null;
        this._visitables.get("clusterSelector").remove(this.clusterSelector);
    }
    return (A) this;
  }
  
  public A withClusters(List<GenericClusterReference> clusters) {
    if (this.clusters != null) {
      this._visitables.get("clusters").clear();
    }
    if (clusters != null) {
        this.clusters = new ArrayList();
        for (GenericClusterReference item : clusters) {
          this.addToClusters(item);
        }
    } else {
      this.clusters = null;
    }
    return (A) this;
  }
  
  public A withClusters(GenericClusterReference... clusters) {
    if (this.clusters != null) {
        this.clusters.clear();
        _visitables.remove("clusters");
    }
    if (clusters != null) {
      for (GenericClusterReference item : clusters) {
        this.addToClusters(item);
      }
    }
    return (A) this;
  }
  
  public ClusterSelectorNested<A> withNewClusterSelector() {
    return new ClusterSelectorNested(null);
  }
  
  public ClusterSelectorNested<A> withNewClusterSelectorLike(LabelSelector item) {
    return new ClusterSelectorNested(item);
  }
  public class ClusterSelectorNested<N> extends LabelSelectorFluent<ClusterSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    ClusterSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericPlacementFieldsFluent.this.withClusterSelector(builder.build());
    }
    
    public N endClusterSelector() {
      return and();
    }
    
  }
  public class ClustersNested<N> extends GenericClusterReferenceFluent<ClustersNested<N>> implements Nested<N>{
  
    GenericClusterReferenceBuilder builder;
    int index;
  
    ClustersNested(int index,GenericClusterReference item) {
      this.index = index;
      this.builder = new GenericClusterReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericPlacementFieldsFluent.this.setToClusters(index, builder.build());
    }
    
    public N endCluster() {
      return and();
    }
    
  }
}