package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PodGroupResourceClaimFluent<A extends io.fabric8.kubernetes.api.model.scheduling.v1alpha2.PodGroupResourceClaimFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private String resourceClaimName;
  private String resourceClaimTemplateName;

  public PodGroupResourceClaimFluent() {
  }
  
  public PodGroupResourceClaimFluent(PodGroupResourceClaim instance) {
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
  
  protected void copyInstance(PodGroupResourceClaim instance) {
    instance = instance != null ? instance : new PodGroupResourceClaim();
    if (instance != null) {
        this.withName(instance.getName());
        this.withResourceClaimName(instance.getResourceClaimName());
        this.withResourceClaimTemplateName(instance.getResourceClaimTemplateName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    PodGroupResourceClaimFluent that = (PodGroupResourceClaimFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(resourceClaimName, that.resourceClaimName))) {
      return false;
    }
    if (!(Objects.equals(resourceClaimTemplateName, that.resourceClaimTemplateName))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public String getResourceClaimName() {
    return this.resourceClaimName;
  }
  
  public String getResourceClaimTemplateName() {
    return this.resourceClaimTemplateName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasResourceClaimName() {
    return this.resourceClaimName != null;
  }
  
  public boolean hasResourceClaimTemplateName() {
    return this.resourceClaimTemplateName != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, resourceClaimName, resourceClaimTemplateName, additionalProperties);
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
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(resourceClaimName == null)) {
        sb.append("resourceClaimName:");
        sb.append(resourceClaimName);
        sb.append(",");
    }
    if (!(resourceClaimTemplateName == null)) {
        sb.append("resourceClaimTemplateName:");
        sb.append(resourceClaimTemplateName);
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withResourceClaimName(String resourceClaimName) {
    this.resourceClaimName = resourceClaimName;
    return (A) this;
  }
  
  public A withResourceClaimTemplateName(String resourceClaimTemplateName) {
    this.resourceClaimTemplateName = resourceClaimTemplateName;
    return (A) this;
  }
  
}