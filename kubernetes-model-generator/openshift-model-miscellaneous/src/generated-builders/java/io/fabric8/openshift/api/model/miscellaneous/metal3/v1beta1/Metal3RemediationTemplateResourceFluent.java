package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
public class Metal3RemediationTemplateResourceFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3RemediationTemplateResourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Metal3RemediationSpecBuilder spec;

  public Metal3RemediationTemplateResourceFluent() {
  }
  
  public Metal3RemediationTemplateResourceFluent(Metal3RemediationTemplateResource instance) {
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
  
  public Metal3RemediationSpec buildSpec() {
    return this.spec != null ? this.spec.build() : null;
  }
  
  protected void copyInstance(Metal3RemediationTemplateResource instance) {
    instance = instance != null ? instance : new Metal3RemediationTemplateResource();
    if (instance != null) {
        this.withSpec(instance.getSpec());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SpecNested<A> editOrNewSpec() {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(new Metal3RemediationSpecBuilder().build()));
  }
  
  public SpecNested<A> editOrNewSpecLike(Metal3RemediationSpec item) {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(item));
  }
  
  public SpecNested<A> editSpec() {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(null));
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
    Metal3RemediationTemplateResourceFluent that = (Metal3RemediationTemplateResourceFluent) o;
    if (!(Objects.equals(spec, that.spec))) {
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
  
  public boolean hasSpec() {
    return this.spec != null;
  }
  
  public int hashCode() {
    return Objects.hash(spec, additionalProperties);
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
    if (!(spec == null)) {
        sb.append("spec:");
        sb.append(spec);
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
  
  public SpecNested<A> withNewSpec() {
    return new SpecNested(null);
  }
  
  public SpecNested<A> withNewSpecLike(Metal3RemediationSpec item) {
    return new SpecNested(item);
  }
  
  public A withSpec(Metal3RemediationSpec spec) {
    this._visitables.remove("spec");
    if (spec != null) {
        this.spec = new Metal3RemediationSpecBuilder(spec);
        this._visitables.get("spec").add(this.spec);
    } else {
        this.spec = null;
        this._visitables.get("spec").remove(this.spec);
    }
    return (A) this;
  }
  public class SpecNested<N> extends Metal3RemediationSpecFluent<SpecNested<N>> implements Nested<N>{
  
    Metal3RemediationSpecBuilder builder;
  
    SpecNested(Metal3RemediationSpec item) {
      this.builder = new Metal3RemediationSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3RemediationTemplateResourceFluent.this.withSpec(builder.build());
    }
    
    public N endSpec() {
      return and();
    }
    
  }
}