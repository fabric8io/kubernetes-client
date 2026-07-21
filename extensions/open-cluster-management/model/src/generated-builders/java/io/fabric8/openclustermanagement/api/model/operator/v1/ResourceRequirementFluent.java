package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirementsFluent;
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
public class ResourceRequirementFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.ResourceRequirementFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ResourceRequirementsBuilder resourceRequirements;
  private String type;

  public ResourceRequirementFluent() {
  }
  
  public ResourceRequirementFluent(ResourceRequirement instance) {
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
  
  public ResourceRequirements buildResourceRequirements() {
    return this.resourceRequirements != null ? this.resourceRequirements.build() : null;
  }
  
  protected void copyInstance(ResourceRequirement instance) {
    instance = instance != null ? instance : new ResourceRequirement();
    if (instance != null) {
        this.withResourceRequirements(instance.getResourceRequirements());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ResourceRequirementsNested<A> editOrNewResourceRequirements() {
    return this.withNewResourceRequirementsLike(Optional.ofNullable(this.buildResourceRequirements()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ResourceRequirementsNested<A> editOrNewResourceRequirementsLike(ResourceRequirements item) {
    return this.withNewResourceRequirementsLike(Optional.ofNullable(this.buildResourceRequirements()).orElse(item));
  }
  
  public ResourceRequirementsNested<A> editResourceRequirements() {
    return this.withNewResourceRequirementsLike(Optional.ofNullable(this.buildResourceRequirements()).orElse(null));
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
    ResourceRequirementFluent that = (ResourceRequirementFluent) o;
    if (!(Objects.equals(resourceRequirements, that.resourceRequirements))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasResourceRequirements() {
    return this.resourceRequirements != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(resourceRequirements, type, additionalProperties);
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
    if (!(resourceRequirements == null)) {
        sb.append("resourceRequirements:");
        sb.append(resourceRequirements);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public ResourceRequirementsNested<A> withNewResourceRequirements() {
    return new ResourceRequirementsNested(null);
  }
  
  public ResourceRequirementsNested<A> withNewResourceRequirementsLike(ResourceRequirements item) {
    return new ResourceRequirementsNested(item);
  }
  
  public A withResourceRequirements(ResourceRequirements resourceRequirements) {
    this._visitables.remove("resourceRequirements");
    if (resourceRequirements != null) {
        this.resourceRequirements = new ResourceRequirementsBuilder(resourceRequirements);
        this._visitables.get("resourceRequirements").add(this.resourceRequirements);
    } else {
        this.resourceRequirements = null;
        this._visitables.get("resourceRequirements").remove(this.resourceRequirements);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ResourceRequirementsNested<N> extends ResourceRequirementsFluent<ResourceRequirementsNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourceRequirementsNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceRequirementFluent.this.withResourceRequirements(builder.build());
    }
    
    public N endResourceRequirements() {
      return and();
    }
    
  }
}