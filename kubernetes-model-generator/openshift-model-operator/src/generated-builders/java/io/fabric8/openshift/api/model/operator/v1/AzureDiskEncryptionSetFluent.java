package io.fabric8.openshift.api.model.operator.v1;

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
public class AzureDiskEncryptionSetFluent<A extends io.fabric8.openshift.api.model.operator.v1.AzureDiskEncryptionSetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private String resourceGroup;
  private String subscriptionID;

  public AzureDiskEncryptionSetFluent() {
  }
  
  public AzureDiskEncryptionSetFluent(AzureDiskEncryptionSet instance) {
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
  
  protected void copyInstance(AzureDiskEncryptionSet instance) {
    instance = instance != null ? instance : new AzureDiskEncryptionSet();
    if (instance != null) {
        this.withName(instance.getName());
        this.withResourceGroup(instance.getResourceGroup());
        this.withSubscriptionID(instance.getSubscriptionID());
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
    AzureDiskEncryptionSetFluent that = (AzureDiskEncryptionSetFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(resourceGroup, that.resourceGroup))) {
      return false;
    }
    if (!(Objects.equals(subscriptionID, that.subscriptionID))) {
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
  
  public String getSubscriptionID() {
    return this.subscriptionID;
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
  
  public boolean hasSubscriptionID() {
    return this.subscriptionID != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, resourceGroup, subscriptionID, additionalProperties);
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
    if (!(subscriptionID == null)) {
        sb.append("subscriptionID:");
        sb.append(subscriptionID);
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
  
  public A withSubscriptionID(String subscriptionID) {
    this.subscriptionID = subscriptionID;
    return (A) this;
  }
  
}