package io.fabric8.openshift.api.model.insights.v1alpha1;

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
public class DataGatherSpecFluent<A extends io.fabric8.openshift.api.model.insights.v1alpha1.DataGatherSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String dataPolicy;
  private ArrayList<GathererConfigBuilder> gatherers = new ArrayList<GathererConfigBuilder>();
  private StorageBuilder storage;

  public DataGatherSpecFluent() {
  }
  
  public DataGatherSpecFluent(DataGatherSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToGatherers(Collection<GathererConfig> items) {
    if (this.gatherers == null) {
      this.gatherers = new ArrayList();
    }
    for (GathererConfig item : items) {
        GathererConfigBuilder builder = new GathererConfigBuilder(item);
        _visitables.get("gatherers").add(builder);
        this.gatherers.add(builder);
    }
    return (A) this;
  }
  
  public GatherersNested<A> addNewGatherer() {
    return new GatherersNested(-1, null);
  }
  
  public A addNewGatherer(String name,String state) {
    return (A) this.addToGatherers(new GathererConfig(name, state));
  }
  
  public GatherersNested<A> addNewGathererLike(GathererConfig item) {
    return new GatherersNested(-1, item);
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
  
  public A addToGatherers(GathererConfig... items) {
    if (this.gatherers == null) {
      this.gatherers = new ArrayList();
    }
    for (GathererConfig item : items) {
        GathererConfigBuilder builder = new GathererConfigBuilder(item);
        _visitables.get("gatherers").add(builder);
        this.gatherers.add(builder);
    }
    return (A) this;
  }
  
  public A addToGatherers(int index,GathererConfig item) {
    if (this.gatherers == null) {
      this.gatherers = new ArrayList();
    }
    GathererConfigBuilder builder = new GathererConfigBuilder(item);
    if (index < 0 || index >= gatherers.size()) {
        _visitables.get("gatherers").add(builder);
        gatherers.add(builder);
    } else {
        _visitables.get("gatherers").add(builder);
        gatherers.add(index, builder);
    }
    return (A) this;
  }
  
  public GathererConfig buildFirstGatherer() {
    return this.gatherers.get(0).build();
  }
  
  public GathererConfig buildGatherer(int index) {
    return this.gatherers.get(index).build();
  }
  
  public List<GathererConfig> buildGatherers() {
    return this.gatherers != null ? build(gatherers) : null;
  }
  
  public GathererConfig buildLastGatherer() {
    return this.gatherers.get(gatherers.size() - 1).build();
  }
  
  public GathererConfig buildMatchingGatherer(Predicate<GathererConfigBuilder> predicate) {
      for (GathererConfigBuilder item : gatherers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Storage buildStorage() {
    return this.storage != null ? this.storage.build() : null;
  }
  
  protected void copyInstance(DataGatherSpec instance) {
    instance = instance != null ? instance : new DataGatherSpec();
    if (instance != null) {
        this.withDataPolicy(instance.getDataPolicy());
        this.withGatherers(instance.getGatherers());
        this.withStorage(instance.getStorage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GatherersNested<A> editFirstGatherer() {
    if (gatherers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "gatherers"));
    }
    return this.setNewGathererLike(0, this.buildGatherer(0));
  }
  
  public GatherersNested<A> editGatherer(int index) {
    if (gatherers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "gatherers"));
    }
    return this.setNewGathererLike(index, this.buildGatherer(index));
  }
  
  public GatherersNested<A> editLastGatherer() {
    int index = gatherers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "gatherers"));
    }
    return this.setNewGathererLike(index, this.buildGatherer(index));
  }
  
  public GatherersNested<A> editMatchingGatherer(Predicate<GathererConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < gatherers.size();i++) {
      if (predicate.test(gatherers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "gatherers"));
    }
    return this.setNewGathererLike(index, this.buildGatherer(index));
  }
  
  public StorageNested<A> editOrNewStorage() {
    return this.withNewStorageLike(Optional.ofNullable(this.buildStorage()).orElse(new StorageBuilder().build()));
  }
  
  public StorageNested<A> editOrNewStorageLike(Storage item) {
    return this.withNewStorageLike(Optional.ofNullable(this.buildStorage()).orElse(item));
  }
  
  public StorageNested<A> editStorage() {
    return this.withNewStorageLike(Optional.ofNullable(this.buildStorage()).orElse(null));
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
    DataGatherSpecFluent that = (DataGatherSpecFluent) o;
    if (!(Objects.equals(dataPolicy, that.dataPolicy))) {
      return false;
    }
    if (!(Objects.equals(gatherers, that.gatherers))) {
      return false;
    }
    if (!(Objects.equals(storage, that.storage))) {
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
  
  public String getDataPolicy() {
    return this.dataPolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDataPolicy() {
    return this.dataPolicy != null;
  }
  
  public boolean hasGatherers() {
    return this.gatherers != null && !(this.gatherers.isEmpty());
  }
  
  public boolean hasMatchingGatherer(Predicate<GathererConfigBuilder> predicate) {
      for (GathererConfigBuilder item : gatherers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasStorage() {
    return this.storage != null;
  }
  
  public int hashCode() {
    return Objects.hash(dataPolicy, gatherers, storage, additionalProperties);
  }
  
  public A removeAllFromGatherers(Collection<GathererConfig> items) {
    if (this.gatherers == null) {
      return (A) this;
    }
    for (GathererConfig item : items) {
        GathererConfigBuilder builder = new GathererConfigBuilder(item);
        _visitables.get("gatherers").remove(builder);
        this.gatherers.remove(builder);
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
  
  public A removeFromGatherers(GathererConfig... items) {
    if (this.gatherers == null) {
      return (A) this;
    }
    for (GathererConfig item : items) {
        GathererConfigBuilder builder = new GathererConfigBuilder(item);
        _visitables.get("gatherers").remove(builder);
        this.gatherers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromGatherers(Predicate<GathererConfigBuilder> predicate) {
    if (gatherers == null) {
      return (A) this;
    }
    Iterator<GathererConfigBuilder> each = gatherers.iterator();
    List visitables = _visitables.get("gatherers");
    while (each.hasNext()) {
        GathererConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public GatherersNested<A> setNewGathererLike(int index,GathererConfig item) {
    return new GatherersNested(index, item);
  }
  
  public A setToGatherers(int index,GathererConfig item) {
    if (this.gatherers == null) {
      this.gatherers = new ArrayList();
    }
    GathererConfigBuilder builder = new GathererConfigBuilder(item);
    if (index < 0 || index >= gatherers.size()) {
        _visitables.get("gatherers").add(builder);
        gatherers.add(builder);
    } else {
        _visitables.get("gatherers").add(builder);
        gatherers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(dataPolicy == null)) {
        sb.append("dataPolicy:");
        sb.append(dataPolicy);
        sb.append(",");
    }
    if (!(gatherers == null) && !(gatherers.isEmpty())) {
        sb.append("gatherers:");
        sb.append(gatherers);
        sb.append(",");
    }
    if (!(storage == null)) {
        sb.append("storage:");
        sb.append(storage);
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
  
  public A withDataPolicy(String dataPolicy) {
    this.dataPolicy = dataPolicy;
    return (A) this;
  }
  
  public A withGatherers(List<GathererConfig> gatherers) {
    if (this.gatherers != null) {
      this._visitables.get("gatherers").clear();
    }
    if (gatherers != null) {
        this.gatherers = new ArrayList();
        for (GathererConfig item : gatherers) {
          this.addToGatherers(item);
        }
    } else {
      this.gatherers = null;
    }
    return (A) this;
  }
  
  public A withGatherers(GathererConfig... gatherers) {
    if (this.gatherers != null) {
        this.gatherers.clear();
        _visitables.remove("gatherers");
    }
    if (gatherers != null) {
      for (GathererConfig item : gatherers) {
        this.addToGatherers(item);
      }
    }
    return (A) this;
  }
  
  public StorageNested<A> withNewStorage() {
    return new StorageNested(null);
  }
  
  public StorageNested<A> withNewStorageLike(Storage item) {
    return new StorageNested(item);
  }
  
  public A withStorage(Storage storage) {
    this._visitables.remove("storage");
    if (storage != null) {
        this.storage = new StorageBuilder(storage);
        this._visitables.get("storage").add(this.storage);
    } else {
        this.storage = null;
        this._visitables.get("storage").remove(this.storage);
    }
    return (A) this;
  }
  public class GatherersNested<N> extends GathererConfigFluent<GatherersNested<N>> implements Nested<N>{
  
    GathererConfigBuilder builder;
    int index;
  
    GatherersNested(int index,GathererConfig item) {
      this.index = index;
      this.builder = new GathererConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) DataGatherSpecFluent.this.setToGatherers(index, builder.build());
    }
    
    public N endGatherer() {
      return and();
    }
    
  }
  public class StorageNested<N> extends StorageFluent<StorageNested<N>> implements Nested<N>{
  
    StorageBuilder builder;
  
    StorageNested(Storage item) {
      this.builder = new StorageBuilder(this, item);
    }
  
    public N and() {
      return (N) DataGatherSpecFluent.this.withStorage(builder.build());
    }
    
    public N endStorage() {
      return and();
    }
    
  }
}