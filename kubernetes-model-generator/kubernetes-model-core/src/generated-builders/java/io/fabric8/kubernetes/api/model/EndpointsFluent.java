package io.fabric8.kubernetes.api.model;

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
public class EndpointsFluent<A extends io.fabric8.kubernetes.api.model.EndpointsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String kind;
  private ObjectMetaBuilder metadata;
  private ArrayList<EndpointSubsetBuilder> subsets = new ArrayList<EndpointSubsetBuilder>();

  public EndpointsFluent() {
  }
  
  public EndpointsFluent(Endpoints instance) {
    this.copyInstance(instance);
  }

  public A addAllToSubsets(Collection<EndpointSubset> items) {
    if (this.subsets == null) {
      this.subsets = new ArrayList();
    }
    for (EndpointSubset item : items) {
        EndpointSubsetBuilder builder = new EndpointSubsetBuilder(item);
        _visitables.get("subsets").add(builder);
        this.subsets.add(builder);
    }
    return (A) this;
  }
  
  public SubsetsNested<A> addNewSubset() {
    return new SubsetsNested(-1, null);
  }
  
  public SubsetsNested<A> addNewSubsetLike(EndpointSubset item) {
    return new SubsetsNested(-1, item);
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
  
  public A addToSubsets(EndpointSubset... items) {
    if (this.subsets == null) {
      this.subsets = new ArrayList();
    }
    for (EndpointSubset item : items) {
        EndpointSubsetBuilder builder = new EndpointSubsetBuilder(item);
        _visitables.get("subsets").add(builder);
        this.subsets.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubsets(int index,EndpointSubset item) {
    if (this.subsets == null) {
      this.subsets = new ArrayList();
    }
    EndpointSubsetBuilder builder = new EndpointSubsetBuilder(item);
    if (index < 0 || index >= subsets.size()) {
        _visitables.get("subsets").add(builder);
        subsets.add(builder);
    } else {
        _visitables.get("subsets").add(builder);
        subsets.add(index, builder);
    }
    return (A) this;
  }
  
  public EndpointSubset buildFirstSubset() {
    return this.subsets.get(0).build();
  }
  
  public EndpointSubset buildLastSubset() {
    return this.subsets.get(subsets.size() - 1).build();
  }
  
  public EndpointSubset buildMatchingSubset(Predicate<EndpointSubsetBuilder> predicate) {
      for (EndpointSubsetBuilder item : subsets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public EndpointSubset buildSubset(int index) {
    return this.subsets.get(index).build();
  }
  
  public List<EndpointSubset> buildSubsets() {
    return this.subsets != null ? build(subsets) : null;
  }
  
  protected void copyInstance(Endpoints instance) {
    instance = instance != null ? instance : new Endpoints();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withSubsets(instance.getSubsets());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SubsetsNested<A> editFirstSubset() {
    if (subsets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "subsets"));
    }
    return this.setNewSubsetLike(0, this.buildSubset(0));
  }
  
  public SubsetsNested<A> editLastSubset() {
    int index = subsets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "subsets"));
    }
    return this.setNewSubsetLike(index, this.buildSubset(index));
  }
  
  public SubsetsNested<A> editMatchingSubset(Predicate<EndpointSubsetBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < subsets.size();i++) {
      if (predicate.test(subsets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "subsets"));
    }
    return this.setNewSubsetLike(index, this.buildSubset(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public SubsetsNested<A> editSubset(int index) {
    if (subsets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "subsets"));
    }
    return this.setNewSubsetLike(index, this.buildSubset(index));
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
    EndpointsFluent that = (EndpointsFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(subsets, that.subsets))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingSubset(Predicate<EndpointSubsetBuilder> predicate) {
      for (EndpointSubsetBuilder item : subsets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasSubsets() {
    return this.subsets != null && !(this.subsets.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, kind, metadata, subsets, additionalProperties);
  }
  
  public A removeAllFromSubsets(Collection<EndpointSubset> items) {
    if (this.subsets == null) {
      return (A) this;
    }
    for (EndpointSubset item : items) {
        EndpointSubsetBuilder builder = new EndpointSubsetBuilder(item);
        _visitables.get("subsets").remove(builder);
        this.subsets.remove(builder);
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
  
  public A removeFromSubsets(EndpointSubset... items) {
    if (this.subsets == null) {
      return (A) this;
    }
    for (EndpointSubset item : items) {
        EndpointSubsetBuilder builder = new EndpointSubsetBuilder(item);
        _visitables.get("subsets").remove(builder);
        this.subsets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubsets(Predicate<EndpointSubsetBuilder> predicate) {
    if (subsets == null) {
      return (A) this;
    }
    Iterator<EndpointSubsetBuilder> each = subsets.iterator();
    List visitables = _visitables.get("subsets");
    while (each.hasNext()) {
        EndpointSubsetBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SubsetsNested<A> setNewSubsetLike(int index,EndpointSubset item) {
    return new SubsetsNested(index, item);
  }
  
  public A setToSubsets(int index,EndpointSubset item) {
    if (this.subsets == null) {
      this.subsets = new ArrayList();
    }
    EndpointSubsetBuilder builder = new EndpointSubsetBuilder(item);
    if (index < 0 || index >= subsets.size()) {
        _visitables.get("subsets").add(builder);
        subsets.add(builder);
    } else {
        _visitables.get("subsets").add(builder);
        subsets.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(subsets == null) && !(subsets.isEmpty())) {
        sb.append("subsets:");
        sb.append(subsets);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public A withSubsets(List<EndpointSubset> subsets) {
    if (this.subsets != null) {
      this._visitables.get("subsets").clear();
    }
    if (subsets != null) {
        this.subsets = new ArrayList();
        for (EndpointSubset item : subsets) {
          this.addToSubsets(item);
        }
    } else {
      this.subsets = null;
    }
    return (A) this;
  }
  
  public A withSubsets(EndpointSubset... subsets) {
    if (this.subsets != null) {
        this.subsets.clear();
        _visitables.remove("subsets");
    }
    if (subsets != null) {
      for (EndpointSubset item : subsets) {
        this.addToSubsets(item);
      }
    }
    return (A) this;
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointsFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class SubsetsNested<N> extends EndpointSubsetFluent<SubsetsNested<N>> implements Nested<N>{
  
    EndpointSubsetBuilder builder;
    int index;
  
    SubsetsNested(int index,EndpointSubset item) {
      this.index = index;
      this.builder = new EndpointSubsetBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointsFluent.this.setToSubsets(index, builder.build());
    }
    
    public N endSubset() {
      return and();
    }
    
  }
}