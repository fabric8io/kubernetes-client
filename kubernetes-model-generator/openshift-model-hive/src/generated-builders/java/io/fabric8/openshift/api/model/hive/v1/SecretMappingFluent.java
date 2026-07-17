package io.fabric8.openshift.api.model.hive.v1;

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
public class SecretMappingFluent<A extends io.fabric8.openshift.api.model.hive.v1.SecretMappingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SecretReferenceBuilder sourceRef;
  private SecretReferenceBuilder targetRef;

  public SecretMappingFluent() {
  }
  
  public SecretMappingFluent(SecretMapping instance) {
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
  
  public SecretReference buildSourceRef() {
    return this.sourceRef != null ? this.sourceRef.build() : null;
  }
  
  public SecretReference buildTargetRef() {
    return this.targetRef != null ? this.targetRef.build() : null;
  }
  
  protected void copyInstance(SecretMapping instance) {
    instance = instance != null ? instance : new SecretMapping();
    if (instance != null) {
        this.withSourceRef(instance.getSourceRef());
        this.withTargetRef(instance.getTargetRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SourceRefNested<A> editOrNewSourceRef() {
    return this.withNewSourceRefLike(Optional.ofNullable(this.buildSourceRef()).orElse(new SecretReferenceBuilder().build()));
  }
  
  public SourceRefNested<A> editOrNewSourceRefLike(SecretReference item) {
    return this.withNewSourceRefLike(Optional.ofNullable(this.buildSourceRef()).orElse(item));
  }
  
  public TargetRefNested<A> editOrNewTargetRef() {
    return this.withNewTargetRefLike(Optional.ofNullable(this.buildTargetRef()).orElse(new SecretReferenceBuilder().build()));
  }
  
  public TargetRefNested<A> editOrNewTargetRefLike(SecretReference item) {
    return this.withNewTargetRefLike(Optional.ofNullable(this.buildTargetRef()).orElse(item));
  }
  
  public SourceRefNested<A> editSourceRef() {
    return this.withNewSourceRefLike(Optional.ofNullable(this.buildSourceRef()).orElse(null));
  }
  
  public TargetRefNested<A> editTargetRef() {
    return this.withNewTargetRefLike(Optional.ofNullable(this.buildTargetRef()).orElse(null));
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
    SecretMappingFluent that = (SecretMappingFluent) o;
    if (!(Objects.equals(sourceRef, that.sourceRef))) {
      return false;
    }
    if (!(Objects.equals(targetRef, that.targetRef))) {
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
  
  public boolean hasSourceRef() {
    return this.sourceRef != null;
  }
  
  public boolean hasTargetRef() {
    return this.targetRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(sourceRef, targetRef, additionalProperties);
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
    if (!(sourceRef == null)) {
        sb.append("sourceRef:");
        sb.append(sourceRef);
        sb.append(",");
    }
    if (!(targetRef == null)) {
        sb.append("targetRef:");
        sb.append(targetRef);
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
  
  public SourceRefNested<A> withNewSourceRef() {
    return new SourceRefNested(null);
  }
  
  public A withNewSourceRef(String name,String namespace) {
    return (A) this.withSourceRef(new SecretReference(name, namespace));
  }
  
  public SourceRefNested<A> withNewSourceRefLike(SecretReference item) {
    return new SourceRefNested(item);
  }
  
  public TargetRefNested<A> withNewTargetRef() {
    return new TargetRefNested(null);
  }
  
  public A withNewTargetRef(String name,String namespace) {
    return (A) this.withTargetRef(new SecretReference(name, namespace));
  }
  
  public TargetRefNested<A> withNewTargetRefLike(SecretReference item) {
    return new TargetRefNested(item);
  }
  
  public A withSourceRef(SecretReference sourceRef) {
    this._visitables.remove("sourceRef");
    if (sourceRef != null) {
        this.sourceRef = new SecretReferenceBuilder(sourceRef);
        this._visitables.get("sourceRef").add(this.sourceRef);
    } else {
        this.sourceRef = null;
        this._visitables.get("sourceRef").remove(this.sourceRef);
    }
    return (A) this;
  }
  
  public A withTargetRef(SecretReference targetRef) {
    this._visitables.remove("targetRef");
    if (targetRef != null) {
        this.targetRef = new SecretReferenceBuilder(targetRef);
        this._visitables.get("targetRef").add(this.targetRef);
    } else {
        this.targetRef = null;
        this._visitables.get("targetRef").remove(this.targetRef);
    }
    return (A) this;
  }
  public class SourceRefNested<N> extends SecretReferenceFluent<SourceRefNested<N>> implements Nested<N>{
  
    SecretReferenceBuilder builder;
  
    SourceRefNested(SecretReference item) {
      this.builder = new SecretReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) SecretMappingFluent.this.withSourceRef(builder.build());
    }
    
    public N endSourceRef() {
      return and();
    }
    
  }
  public class TargetRefNested<N> extends SecretReferenceFluent<TargetRefNested<N>> implements Nested<N>{
  
    SecretReferenceBuilder builder;
  
    TargetRefNested(SecretReference item) {
      this.builder = new SecretReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) SecretMappingFluent.this.withTargetRef(builder.build());
    }
    
    public N endTargetRef() {
      return and();
    }
    
  }
}