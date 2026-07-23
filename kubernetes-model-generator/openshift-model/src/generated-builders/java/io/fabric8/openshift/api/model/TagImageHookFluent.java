package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class TagImageHookFluent<A extends io.fabric8.openshift.api.model.TagImageHookFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String containerName;
  private ObjectReferenceBuilder to;

  public TagImageHookFluent() {
  }
  
  public TagImageHookFluent(TagImageHook instance) {
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
  
  public ObjectReference buildTo() {
    return this.to != null ? this.to.build() : null;
  }
  
  protected void copyInstance(TagImageHook instance) {
    instance = instance != null ? instance : new TagImageHook();
    if (instance != null) {
        this.withContainerName(instance.getContainerName());
        this.withTo(instance.getTo());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ToNested<A> editOrNewTo() {
    return this.withNewToLike(Optional.ofNullable(this.buildTo()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public ToNested<A> editOrNewToLike(ObjectReference item) {
    return this.withNewToLike(Optional.ofNullable(this.buildTo()).orElse(item));
  }
  
  public ToNested<A> editTo() {
    return this.withNewToLike(Optional.ofNullable(this.buildTo()).orElse(null));
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
    TagImageHookFluent that = (TagImageHookFluent) o;
    if (!(Objects.equals(containerName, that.containerName))) {
      return false;
    }
    if (!(Objects.equals(to, that.to))) {
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
  
  public String getContainerName() {
    return this.containerName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerName() {
    return this.containerName != null;
  }
  
  public boolean hasTo() {
    return this.to != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerName, to, additionalProperties);
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
    if (!(containerName == null)) {
        sb.append("containerName:");
        sb.append(containerName);
        sb.append(",");
    }
    if (!(to == null)) {
        sb.append("to:");
        sb.append(to);
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
  
  public A withContainerName(String containerName) {
    this.containerName = containerName;
    return (A) this;
  }
  
  public ToNested<A> withNewTo() {
    return new ToNested(null);
  }
  
  public ToNested<A> withNewToLike(ObjectReference item) {
    return new ToNested(item);
  }
  
  public A withTo(ObjectReference to) {
    this._visitables.remove("to");
    if (to != null) {
        this.to = new ObjectReferenceBuilder(to);
        this._visitables.get("to").add(this.to);
    } else {
        this.to = null;
        this._visitables.get("to").remove(this.to);
    }
    return (A) this;
  }
  public class ToNested<N> extends ObjectReferenceFluent<ToNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    ToNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) TagImageHookFluent.this.withTo(builder.build());
    }
    
    public N endTo() {
      return and();
    }
    
  }
}