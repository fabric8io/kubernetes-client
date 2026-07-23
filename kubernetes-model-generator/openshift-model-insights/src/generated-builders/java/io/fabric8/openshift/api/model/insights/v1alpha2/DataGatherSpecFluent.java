package io.fabric8.openshift.api.model.insights.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class DataGatherSpecFluent<A extends io.fabric8.openshift.api.model.insights.v1alpha2.DataGatherSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> dataPolicy = new ArrayList<String>();
  private GatherersBuilder gatherers;
  private StorageBuilder storage;

  public DataGatherSpecFluent() {
  }
  
  public DataGatherSpecFluent(DataGatherSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToDataPolicy(Collection<String> items) {
    if (this.dataPolicy == null) {
      this.dataPolicy = new ArrayList();
    }
    for (String item : items) {
      this.dataPolicy.add(item);
    }
    return (A) this;
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
  
  public A addToDataPolicy(String... items) {
    if (this.dataPolicy == null) {
      this.dataPolicy = new ArrayList();
    }
    for (String item : items) {
      this.dataPolicy.add(item);
    }
    return (A) this;
  }
  
  public A addToDataPolicy(int index,String item) {
    if (this.dataPolicy == null) {
      this.dataPolicy = new ArrayList();
    }
    this.dataPolicy.add(index, item);
    return (A) this;
  }
  
  public Gatherers buildGatherers() {
    return this.gatherers != null ? this.gatherers.build() : null;
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
  
  public GatherersNested<A> editGatherers() {
    return this.withNewGatherersLike(Optional.ofNullable(this.buildGatherers()).orElse(null));
  }
  
  public GatherersNested<A> editOrNewGatherers() {
    return this.withNewGatherersLike(Optional.ofNullable(this.buildGatherers()).orElse(new GatherersBuilder().build()));
  }
  
  public GatherersNested<A> editOrNewGatherersLike(Gatherers item) {
    return this.withNewGatherersLike(Optional.ofNullable(this.buildGatherers()).orElse(item));
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
  
  public List<String> getDataPolicy() {
    return this.dataPolicy;
  }
  
  public String getDataPolicy(int index) {
    return this.dataPolicy.get(index);
  }
  
  public String getFirstDataPolicy() {
    return this.dataPolicy.get(0);
  }
  
  public String getLastDataPolicy() {
    return this.dataPolicy.get(dataPolicy.size() - 1);
  }
  
  public String getMatchingDataPolicy(Predicate<String> predicate) {
      for (String item : dataPolicy) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDataPolicy() {
    return this.dataPolicy != null && !(this.dataPolicy.isEmpty());
  }
  
  public boolean hasGatherers() {
    return this.gatherers != null;
  }
  
  public boolean hasMatchingDataPolicy(Predicate<String> predicate) {
      for (String item : dataPolicy) {
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
  
  public A removeAllFromDataPolicy(Collection<String> items) {
    if (this.dataPolicy == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dataPolicy.remove(item);
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
  
  public A removeFromDataPolicy(String... items) {
    if (this.dataPolicy == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dataPolicy.remove(item);
    }
    return (A) this;
  }
  
  public A setToDataPolicy(int index,String item) {
    if (this.dataPolicy == null) {
      this.dataPolicy = new ArrayList();
    }
    this.dataPolicy.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(dataPolicy == null) && !(dataPolicy.isEmpty())) {
        sb.append("dataPolicy:");
        sb.append(dataPolicy);
        sb.append(",");
    }
    if (!(gatherers == null)) {
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
  
  public A withDataPolicy(List<String> dataPolicy) {
    if (dataPolicy != null) {
        this.dataPolicy = new ArrayList();
        for (String item : dataPolicy) {
          this.addToDataPolicy(item);
        }
    } else {
      this.dataPolicy = null;
    }
    return (A) this;
  }
  
  public A withDataPolicy(String... dataPolicy) {
    if (this.dataPolicy != null) {
        this.dataPolicy.clear();
        _visitables.remove("dataPolicy");
    }
    if (dataPolicy != null) {
      for (String item : dataPolicy) {
        this.addToDataPolicy(item);
      }
    }
    return (A) this;
  }
  
  public A withGatherers(Gatherers gatherers) {
    this._visitables.remove("gatherers");
    if (gatherers != null) {
        this.gatherers = new GatherersBuilder(gatherers);
        this._visitables.get("gatherers").add(this.gatherers);
    } else {
        this.gatherers = null;
        this._visitables.get("gatherers").remove(this.gatherers);
    }
    return (A) this;
  }
  
  public GatherersNested<A> withNewGatherers() {
    return new GatherersNested(null);
  }
  
  public GatherersNested<A> withNewGatherersLike(Gatherers item) {
    return new GatherersNested(item);
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
  public class GatherersNested<N> extends GatherersFluent<GatherersNested<N>> implements Nested<N>{
  
    GatherersBuilder builder;
  
    GatherersNested(Gatherers item) {
      this.builder = new GatherersBuilder(this, item);
    }
  
    public N and() {
      return (N) DataGatherSpecFluent.this.withGatherers(builder.build());
    }
    
    public N endGatherers() {
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