package io.fabric8.openshift.api.model.hive.azure.v1;

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
public class DiskEncryptionSetFluent<A extends io.fabric8.openshift.api.model.hive.azure.v1.DiskEncryptionSetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private String resourceGroup;
  private String subscriptionId;

  public DiskEncryptionSetFluent() {
  }
  
  public DiskEncryptionSetFluent(DiskEncryptionSet instance) {
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
  
  protected void copyInstance(DiskEncryptionSet instance) {
    instance = instance != null ? instance : new DiskEncryptionSet();
    if (instance != null) {
        this.withName(instance.getName());
        this.withResourceGroup(instance.getResourceGroup());
        this.withSubscriptionId(instance.getSubscriptionId());
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
    DiskEncryptionSetFluent that = (DiskEncryptionSetFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(resourceGroup, that.resourceGroup))) {
      return false;
    }
    if (!(Objects.equals(subscriptionId, that.subscriptionId))) {
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
  
  public String getResourceGroup() {
    return this.resourceGroup;
  }
  
  public String getSubscriptionId() {
    return this.subscriptionId;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasResourceGroup() {
    return this.resourceGroup != null;
  }
  
  public boolean hasSubscriptionId() {
    return this.subscriptionId != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, resourceGroup, subscriptionId, additionalProperties);
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
    if (!(resourceGroup == null)) {
        sb.append("resourceGroup:");
        sb.append(resourceGroup);
        sb.append(",");
    }
    if (!(subscriptionId == null)) {
        sb.append("subscriptionId:");
        sb.append(subscriptionId);
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
  
  public A withResourceGroup(String resourceGroup) {
    this.resourceGroup = resourceGroup;
    return (A) this;
  }
  
  public A withSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
    return (A) this;
  }
  
}