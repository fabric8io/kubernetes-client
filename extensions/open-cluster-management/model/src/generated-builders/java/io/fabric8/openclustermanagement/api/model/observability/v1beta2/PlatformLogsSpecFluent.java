package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PlatformLogsSpecFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta2.PlatformLogsSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PlatformLogsCollectionSpecBuilder collection;

  public PlatformLogsSpecFluent() {
  }
  
  public PlatformLogsSpecFluent(PlatformLogsSpec instance) {
    this.copyInstance(instance);
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
  
  public PlatformLogsCollectionSpec buildCollection() {
    return this.collection != null ? this.collection.build() : null;
  }
  
  protected void copyInstance(PlatformLogsSpec instance) {
    instance = instance != null ? instance : new PlatformLogsSpec();
    if (instance != null) {
        this.withCollection(instance.getCollection());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CollectionNested<A> editCollection() {
    return this.withNewCollectionLike(Optional.ofNullable(this.buildCollection()).orElse(null));
  }
  
  public CollectionNested<A> editOrNewCollection() {
    return this.withNewCollectionLike(Optional.ofNullable(this.buildCollection()).orElse(new PlatformLogsCollectionSpecBuilder().build()));
  }
  
  public CollectionNested<A> editOrNewCollectionLike(PlatformLogsCollectionSpec item) {
    return this.withNewCollectionLike(Optional.ofNullable(this.buildCollection()).orElse(item));
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
    PlatformLogsSpecFluent that = (PlatformLogsSpecFluent) o;
    if (!(Objects.equals(collection, that.collection))) {
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
  
  public boolean hasCollection() {
    return this.collection != null;
  }
  
  public int hashCode() {
    return Objects.hash(collection, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(collection == null)) {
        sb.append("collection:");
        sb.append(collection);
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
  
  public A withCollection(PlatformLogsCollectionSpec collection) {
    this._visitables.remove("collection");
    if (collection != null) {
        this.collection = new PlatformLogsCollectionSpecBuilder(collection);
        this._visitables.get("collection").add(this.collection);
    } else {
        this.collection = null;
        this._visitables.get("collection").remove(this.collection);
    }
    return (A) this;
  }
  
  public CollectionNested<A> withNewCollection() {
    return new CollectionNested(null);
  }
  
  public A withNewCollection(Boolean enabled) {
    return (A) this.withCollection(new PlatformLogsCollectionSpec(enabled));
  }
  
  public CollectionNested<A> withNewCollectionLike(PlatformLogsCollectionSpec item) {
    return new CollectionNested(item);
  }
  public class CollectionNested<N> extends PlatformLogsCollectionSpecFluent<CollectionNested<N>> implements Nested<N>{
  
    PlatformLogsCollectionSpecBuilder builder;
  
    CollectionNested(PlatformLogsCollectionSpec item) {
      this.builder = new PlatformLogsCollectionSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformLogsSpecFluent.this.withCollection(builder.build());
    }
    
    public N endCollection() {
      return and();
    }
    
  }
}