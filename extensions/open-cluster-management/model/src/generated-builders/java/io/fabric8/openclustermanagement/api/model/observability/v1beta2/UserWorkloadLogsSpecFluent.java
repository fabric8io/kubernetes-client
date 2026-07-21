package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class UserWorkloadLogsSpecFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta2.UserWorkloadLogsSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private UserWorkloadLogsCollectionSpecBuilder collection;

  public UserWorkloadLogsSpecFluent() {
  }
  
  public UserWorkloadLogsSpecFluent(UserWorkloadLogsSpec instance) {
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
  
  public UserWorkloadLogsCollectionSpec buildCollection() {
    return this.collection != null ? this.collection.build() : null;
  }
  
  protected void copyInstance(UserWorkloadLogsSpec instance) {
    instance = instance != null ? instance : new UserWorkloadLogsSpec();
    if (instance != null) {
        this.withCollection(instance.getCollection());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CollectionNested<A> editCollection() {
    return this.withNewCollectionLike(Optional.ofNullable(this.buildCollection()).orElse(null));
  }
  
  public CollectionNested<A> editOrNewCollection() {
    return this.withNewCollectionLike(Optional.ofNullable(this.buildCollection()).orElse(new UserWorkloadLogsCollectionSpecBuilder().build()));
  }
  
  public CollectionNested<A> editOrNewCollectionLike(UserWorkloadLogsCollectionSpec item) {
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
    UserWorkloadLogsSpecFluent that = (UserWorkloadLogsSpecFluent) o;
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
  
  public A withCollection(UserWorkloadLogsCollectionSpec collection) {
    this._visitables.remove("collection");
    if (collection != null) {
        this.collection = new UserWorkloadLogsCollectionSpecBuilder(collection);
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
  
  public CollectionNested<A> withNewCollectionLike(UserWorkloadLogsCollectionSpec item) {
    return new CollectionNested(item);
  }
  public class CollectionNested<N> extends UserWorkloadLogsCollectionSpecFluent<CollectionNested<N>> implements Nested<N>{
  
    UserWorkloadLogsCollectionSpecBuilder builder;
  
    CollectionNested(UserWorkloadLogsCollectionSpec item) {
      this.builder = new UserWorkloadLogsCollectionSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) UserWorkloadLogsSpecFluent.this.withCollection(builder.build());
    }
    
    public N endCollection() {
      return and();
    }
    
  }
}