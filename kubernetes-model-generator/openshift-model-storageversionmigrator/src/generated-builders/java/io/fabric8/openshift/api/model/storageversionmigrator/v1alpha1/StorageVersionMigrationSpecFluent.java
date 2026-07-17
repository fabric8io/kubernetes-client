package io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1;

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
public class StorageVersionMigrationSpecFluent<A extends io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageVersionMigrationSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String continueToken;
  private StorageVersionMigrationSpecResourceBuilder resource;

  public StorageVersionMigrationSpecFluent() {
  }
  
  public StorageVersionMigrationSpecFluent(StorageVersionMigrationSpec instance) {
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
  
  public StorageVersionMigrationSpecResource buildResource() {
    return this.resource != null ? this.resource.build() : null;
  }
  
  protected void copyInstance(StorageVersionMigrationSpec instance) {
    instance = instance != null ? instance : new StorageVersionMigrationSpec();
    if (instance != null) {
        this.withContinueToken(instance.getContinueToken());
        this.withResource(instance.getResource());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResourceNested<A> editOrNewResource() {
    return this.withNewResourceLike(Optional.ofNullable(this.buildResource()).orElse(new StorageVersionMigrationSpecResourceBuilder().build()));
  }
  
  public ResourceNested<A> editOrNewResourceLike(StorageVersionMigrationSpecResource item) {
    return this.withNewResourceLike(Optional.ofNullable(this.buildResource()).orElse(item));
  }
  
  public ResourceNested<A> editResource() {
    return this.withNewResourceLike(Optional.ofNullable(this.buildResource()).orElse(null));
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
    StorageVersionMigrationSpecFluent that = (StorageVersionMigrationSpecFluent) o;
    if (!(Objects.equals(continueToken, that.continueToken))) {
      return false;
    }
    if (!(Objects.equals(resource, that.resource))) {
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
  
  public String getContinueToken() {
    return this.continueToken;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContinueToken() {
    return this.continueToken != null;
  }
  
  public boolean hasResource() {
    return this.resource != null;
  }
  
  public int hashCode() {
    return Objects.hash(continueToken, resource, additionalProperties);
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
    if (!(continueToken == null)) {
        sb.append("continueToken:");
        sb.append(continueToken);
        sb.append(",");
    }
    if (!(resource == null)) {
        sb.append("resource:");
        sb.append(resource);
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
  
  public A withContinueToken(String continueToken) {
    this.continueToken = continueToken;
    return (A) this;
  }
  
  public ResourceNested<A> withNewResource() {
    return new ResourceNested(null);
  }
  
  public A withNewResource(String group,String resource,String version) {
    return (A) this.withResource(new StorageVersionMigrationSpecResource(group, resource, version));
  }
  
  public ResourceNested<A> withNewResourceLike(StorageVersionMigrationSpecResource item) {
    return new ResourceNested(item);
  }
  
  public A withResource(StorageVersionMigrationSpecResource resource) {
    this._visitables.remove("resource");
    if (resource != null) {
        this.resource = new StorageVersionMigrationSpecResourceBuilder(resource);
        this._visitables.get("resource").add(this.resource);
    } else {
        this.resource = null;
        this._visitables.get("resource").remove(this.resource);
    }
    return (A) this;
  }
  public class ResourceNested<N> extends StorageVersionMigrationSpecResourceFluent<ResourceNested<N>> implements Nested<N>{
  
    StorageVersionMigrationSpecResourceBuilder builder;
  
    ResourceNested(StorageVersionMigrationSpecResource item) {
      this.builder = new StorageVersionMigrationSpecResourceBuilder(this, item);
    }
  
    public N and() {
      return (N) StorageVersionMigrationSpecFluent.this.withResource(builder.build());
    }
    
    public N endResource() {
      return and();
    }
    
  }
}