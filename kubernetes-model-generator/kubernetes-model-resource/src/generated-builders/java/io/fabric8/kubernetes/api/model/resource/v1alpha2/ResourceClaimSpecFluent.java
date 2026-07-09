package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
public class ResourceClaimSpecFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String allocationMode;
  private ResourceClaimParametersReferenceBuilder parametersRef;
  private String resourceClassName;

  public ResourceClaimSpecFluent() {
  }
  
  public ResourceClaimSpecFluent(ResourceClaimSpec instance) {
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
  
  public ResourceClaimParametersReference buildParametersRef() {
    return this.parametersRef != null ? this.parametersRef.build() : null;
  }
  
  protected void copyInstance(ResourceClaimSpec instance) {
    instance = instance != null ? instance : new ResourceClaimSpec();
    if (instance != null) {
        this.withAllocationMode(instance.getAllocationMode());
        this.withParametersRef(instance.getParametersRef());
        this.withResourceClassName(instance.getResourceClassName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ParametersRefNested<A> editOrNewParametersRef() {
    return this.withNewParametersRefLike(Optional.ofNullable(this.buildParametersRef()).orElse(new ResourceClaimParametersReferenceBuilder().build()));
  }
  
  public ParametersRefNested<A> editOrNewParametersRefLike(ResourceClaimParametersReference item) {
    return this.withNewParametersRefLike(Optional.ofNullable(this.buildParametersRef()).orElse(item));
  }
  
  public ParametersRefNested<A> editParametersRef() {
    return this.withNewParametersRefLike(Optional.ofNullable(this.buildParametersRef()).orElse(null));
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
    ResourceClaimSpecFluent that = (ResourceClaimSpecFluent) o;
    if (!(Objects.equals(allocationMode, that.allocationMode))) {
      return false;
    }
    if (!(Objects.equals(parametersRef, that.parametersRef))) {
      return false;
    }
    if (!(Objects.equals(resourceClassName, that.resourceClassName))) {
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
  
  public String getAllocationMode() {
    return this.allocationMode;
  }
  
  public String getResourceClassName() {
    return this.resourceClassName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllocationMode() {
    return this.allocationMode != null;
  }
  
  public boolean hasParametersRef() {
    return this.parametersRef != null;
  }
  
  public boolean hasResourceClassName() {
    return this.resourceClassName != null;
  }
  
  public int hashCode() {
    return Objects.hash(allocationMode, parametersRef, resourceClassName, additionalProperties);
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
    if (!(allocationMode == null)) {
        sb.append("allocationMode:");
        sb.append(allocationMode);
        sb.append(",");
    }
    if (!(parametersRef == null)) {
        sb.append("parametersRef:");
        sb.append(parametersRef);
        sb.append(",");
    }
    if (!(resourceClassName == null)) {
        sb.append("resourceClassName:");
        sb.append(resourceClassName);
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
  
  public A withAllocationMode(String allocationMode) {
    this.allocationMode = allocationMode;
    return (A) this;
  }
  
  public ParametersRefNested<A> withNewParametersRef() {
    return new ParametersRefNested(null);
  }
  
  public A withNewParametersRef(String apiGroup,String kind,String name) {
    return (A) this.withParametersRef(new ResourceClaimParametersReference(apiGroup, kind, name));
  }
  
  public ParametersRefNested<A> withNewParametersRefLike(ResourceClaimParametersReference item) {
    return new ParametersRefNested(item);
  }
  
  public A withParametersRef(ResourceClaimParametersReference parametersRef) {
    this._visitables.remove("parametersRef");
    if (parametersRef != null) {
        this.parametersRef = new ResourceClaimParametersReferenceBuilder(parametersRef);
        this._visitables.get("parametersRef").add(this.parametersRef);
    } else {
        this.parametersRef = null;
        this._visitables.get("parametersRef").remove(this.parametersRef);
    }
    return (A) this;
  }
  
  public A withResourceClassName(String resourceClassName) {
    this.resourceClassName = resourceClassName;
    return (A) this;
  }
  public class ParametersRefNested<N> extends ResourceClaimParametersReferenceFluent<ParametersRefNested<N>> implements Nested<N>{
  
    ResourceClaimParametersReferenceBuilder builder;
  
    ParametersRefNested(ResourceClaimParametersReference item) {
      this.builder = new ResourceClaimParametersReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceClaimSpecFluent.this.withParametersRef(builder.build());
    }
    
    public N endParametersRef() {
      return and();
    }
    
  }
}