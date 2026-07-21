package io.fabric8.tekton.resolution.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.tekton.v1.RefSource;
import io.fabric8.tekton.v1.RefSourceBuilder;
import io.fabric8.tekton.v1.RefSourceFluent;
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
public class ResolutionRequestStatusFieldsFluent<A extends io.fabric8.tekton.resolution.v1alpha1.ResolutionRequestStatusFieldsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String data;
  private RefSourceBuilder refSource;

  public ResolutionRequestStatusFieldsFluent() {
  }
  
  public ResolutionRequestStatusFieldsFluent(ResolutionRequestStatusFields instance) {
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
  
  public RefSource buildRefSource() {
    return this.refSource != null ? this.refSource.build() : null;
  }
  
  protected void copyInstance(ResolutionRequestStatusFields instance) {
    instance = instance != null ? instance : new ResolutionRequestStatusFields();
    if (instance != null) {
        this.withData(instance.getData());
        this.withRefSource(instance.getRefSource());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RefSourceNested<A> editOrNewRefSource() {
    return this.withNewRefSourceLike(Optional.ofNullable(this.buildRefSource()).orElse(new RefSourceBuilder().build()));
  }
  
  public RefSourceNested<A> editOrNewRefSourceLike(RefSource item) {
    return this.withNewRefSourceLike(Optional.ofNullable(this.buildRefSource()).orElse(item));
  }
  
  public RefSourceNested<A> editRefSource() {
    return this.withNewRefSourceLike(Optional.ofNullable(this.buildRefSource()).orElse(null));
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
    ResolutionRequestStatusFieldsFluent that = (ResolutionRequestStatusFieldsFluent) o;
    if (!(Objects.equals(data, that.data))) {
      return false;
    }
    if (!(Objects.equals(refSource, that.refSource))) {
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
  
  public String getData() {
    return this.data;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasData() {
    return this.data != null;
  }
  
  public boolean hasRefSource() {
    return this.refSource != null;
  }
  
  public int hashCode() {
    return Objects.hash(data, refSource, additionalProperties);
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
    if (!(data == null)) {
        sb.append("data:");
        sb.append(data);
        sb.append(",");
    }
    if (!(refSource == null)) {
        sb.append("refSource:");
        sb.append(refSource);
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
  
  public A withData(String data) {
    this.data = data;
    return (A) this;
  }
  
  public RefSourceNested<A> withNewRefSource() {
    return new RefSourceNested(null);
  }
  
  public RefSourceNested<A> withNewRefSourceLike(RefSource item) {
    return new RefSourceNested(item);
  }
  
  public A withRefSource(RefSource refSource) {
    this._visitables.remove("refSource");
    if (refSource != null) {
        this.refSource = new RefSourceBuilder(refSource);
        this._visitables.get("refSource").add(this.refSource);
    } else {
        this.refSource = null;
        this._visitables.get("refSource").remove(this.refSource);
    }
    return (A) this;
  }
  public class RefSourceNested<N> extends RefSourceFluent<RefSourceNested<N>> implements Nested<N>{
  
    RefSourceBuilder builder;
  
    RefSourceNested(RefSource item) {
      this.builder = new RefSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) ResolutionRequestStatusFieldsFluent.this.withRefSource(builder.build());
    }
    
    public N endRefSource() {
      return and();
    }
    
  }
}