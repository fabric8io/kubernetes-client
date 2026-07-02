package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class DownwardAPIVolumeFileFluent<A extends io.fabric8.kubernetes.api.model.DownwardAPIVolumeFileFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ObjectFieldSelectorBuilder fieldRef;
  private Integer mode;
  private String path;
  private ResourceFieldSelectorBuilder resourceFieldRef;

  public DownwardAPIVolumeFileFluent() {
  }
  
  public DownwardAPIVolumeFileFluent(DownwardAPIVolumeFile instance) {
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
  
  public ObjectFieldSelector buildFieldRef() {
    return this.fieldRef != null ? this.fieldRef.build() : null;
  }
  
  public ResourceFieldSelector buildResourceFieldRef() {
    return this.resourceFieldRef != null ? this.resourceFieldRef.build() : null;
  }
  
  protected void copyInstance(DownwardAPIVolumeFile instance) {
    instance = instance != null ? instance : new DownwardAPIVolumeFile();
    if (instance != null) {
        this.withFieldRef(instance.getFieldRef());
        this.withMode(instance.getMode());
        this.withPath(instance.getPath());
        this.withResourceFieldRef(instance.getResourceFieldRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FieldRefNested<A> editFieldRef() {
    return this.withNewFieldRefLike(Optional.ofNullable(this.buildFieldRef()).orElse(null));
  }
  
  public FieldRefNested<A> editOrNewFieldRef() {
    return this.withNewFieldRefLike(Optional.ofNullable(this.buildFieldRef()).orElse(new ObjectFieldSelectorBuilder().build()));
  }
  
  public FieldRefNested<A> editOrNewFieldRefLike(ObjectFieldSelector item) {
    return this.withNewFieldRefLike(Optional.ofNullable(this.buildFieldRef()).orElse(item));
  }
  
  public ResourceFieldRefNested<A> editOrNewResourceFieldRef() {
    return this.withNewResourceFieldRefLike(Optional.ofNullable(this.buildResourceFieldRef()).orElse(new ResourceFieldSelectorBuilder().build()));
  }
  
  public ResourceFieldRefNested<A> editOrNewResourceFieldRefLike(ResourceFieldSelector item) {
    return this.withNewResourceFieldRefLike(Optional.ofNullable(this.buildResourceFieldRef()).orElse(item));
  }
  
  public ResourceFieldRefNested<A> editResourceFieldRef() {
    return this.withNewResourceFieldRefLike(Optional.ofNullable(this.buildResourceFieldRef()).orElse(null));
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
    DownwardAPIVolumeFileFluent that = (DownwardAPIVolumeFileFluent) o;
    if (!(Objects.equals(fieldRef, that.fieldRef))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(resourceFieldRef, that.resourceFieldRef))) {
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
  
  public Integer getMode() {
    return this.mode;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFieldRef() {
    return this.fieldRef != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasResourceFieldRef() {
    return this.resourceFieldRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(fieldRef, mode, path, resourceFieldRef, additionalProperties);
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
    if (!(fieldRef == null)) {
        sb.append("fieldRef:");
        sb.append(fieldRef);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(resourceFieldRef == null)) {
        sb.append("resourceFieldRef:");
        sb.append(resourceFieldRef);
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
  
  public A withFieldRef(ObjectFieldSelector fieldRef) {
    this._visitables.remove("fieldRef");
    if (fieldRef != null) {
        this.fieldRef = new ObjectFieldSelectorBuilder(fieldRef);
        this._visitables.get("fieldRef").add(this.fieldRef);
    } else {
        this.fieldRef = null;
        this._visitables.get("fieldRef").remove(this.fieldRef);
    }
    return (A) this;
  }
  
  public A withMode(Integer mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public FieldRefNested<A> withNewFieldRef() {
    return new FieldRefNested(null);
  }
  
  public A withNewFieldRef(String apiVersion,String fieldPath) {
    return (A) this.withFieldRef(new ObjectFieldSelector(apiVersion, fieldPath));
  }
  
  public FieldRefNested<A> withNewFieldRefLike(ObjectFieldSelector item) {
    return new FieldRefNested(item);
  }
  
  public ResourceFieldRefNested<A> withNewResourceFieldRef() {
    return new ResourceFieldRefNested(null);
  }
  
  public ResourceFieldRefNested<A> withNewResourceFieldRefLike(ResourceFieldSelector item) {
    return new ResourceFieldRefNested(item);
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withResourceFieldRef(ResourceFieldSelector resourceFieldRef) {
    this._visitables.remove("resourceFieldRef");
    if (resourceFieldRef != null) {
        this.resourceFieldRef = new ResourceFieldSelectorBuilder(resourceFieldRef);
        this._visitables.get("resourceFieldRef").add(this.resourceFieldRef);
    } else {
        this.resourceFieldRef = null;
        this._visitables.get("resourceFieldRef").remove(this.resourceFieldRef);
    }
    return (A) this;
  }
  public class FieldRefNested<N> extends ObjectFieldSelectorFluent<FieldRefNested<N>> implements Nested<N>{
  
    ObjectFieldSelectorBuilder builder;
  
    FieldRefNested(ObjectFieldSelector item) {
      this.builder = new ObjectFieldSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) DownwardAPIVolumeFileFluent.this.withFieldRef(builder.build());
    }
    
    public N endFieldRef() {
      return and();
    }
    
  }
  public class ResourceFieldRefNested<N> extends ResourceFieldSelectorFluent<ResourceFieldRefNested<N>> implements Nested<N>{
  
    ResourceFieldSelectorBuilder builder;
  
    ResourceFieldRefNested(ResourceFieldSelector item) {
      this.builder = new ResourceFieldSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) DownwardAPIVolumeFileFluent.this.withResourceFieldRef(builder.build());
    }
    
    public N endResourceFieldRef() {
      return and();
    }
    
  }
}