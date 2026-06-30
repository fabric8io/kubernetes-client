package io.fabric8.kubernetes.api.model;

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
public class ContainerExtendedResourceRequestFluent<A extends io.fabric8.kubernetes.api.model.ContainerExtendedResourceRequestFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String containerName;
  private String requestName;
  private String resourceName;

  public ContainerExtendedResourceRequestFluent() {
  }
  
  public ContainerExtendedResourceRequestFluent(ContainerExtendedResourceRequest instance) {
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
  
  protected void copyInstance(ContainerExtendedResourceRequest instance) {
    instance = instance != null ? instance : new ContainerExtendedResourceRequest();
    if (instance != null) {
        this.withContainerName(instance.getContainerName());
        this.withRequestName(instance.getRequestName());
        this.withResourceName(instance.getResourceName());
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
    ContainerExtendedResourceRequestFluent that = (ContainerExtendedResourceRequestFluent) o;
    if (!(Objects.equals(containerName, that.containerName))) {
      return false;
    }
    if (!(Objects.equals(requestName, that.requestName))) {
      return false;
    }
    if (!(Objects.equals(resourceName, that.resourceName))) {
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
  
  public String getRequestName() {
    return this.requestName;
  }
  
  public String getResourceName() {
    return this.resourceName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerName() {
    return this.containerName != null;
  }
  
  public boolean hasRequestName() {
    return this.requestName != null;
  }
  
  public boolean hasResourceName() {
    return this.resourceName != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerName, requestName, resourceName, additionalProperties);
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
    if (!(requestName == null)) {
        sb.append("requestName:");
        sb.append(requestName);
        sb.append(",");
    }
    if (!(resourceName == null)) {
        sb.append("resourceName:");
        sb.append(resourceName);
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
  
  public A withRequestName(String requestName) {
    this.requestName = requestName;
    return (A) this;
  }
  
  public A withResourceName(String resourceName) {
    this.resourceName = resourceName;
    return (A) this;
  }
  
}