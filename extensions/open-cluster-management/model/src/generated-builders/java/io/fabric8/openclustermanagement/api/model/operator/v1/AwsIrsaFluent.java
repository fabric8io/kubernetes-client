package io.fabric8.openclustermanagement.api.model.operator.v1;

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
public class AwsIrsaFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.AwsIrsaFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String hubClusterArn;
  private String managedClusterArn;

  public AwsIrsaFluent() {
  }
  
  public AwsIrsaFluent(AwsIrsa instance) {
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
  
  protected void copyInstance(AwsIrsa instance) {
    instance = instance != null ? instance : new AwsIrsa();
    if (instance != null) {
        this.withHubClusterArn(instance.getHubClusterArn());
        this.withManagedClusterArn(instance.getManagedClusterArn());
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
    AwsIrsaFluent that = (AwsIrsaFluent) o;
    if (!(Objects.equals(hubClusterArn, that.hubClusterArn))) {
      return false;
    }
    if (!(Objects.equals(managedClusterArn, that.managedClusterArn))) {
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
  
  public String getHubClusterArn() {
    return this.hubClusterArn;
  }
  
  public String getManagedClusterArn() {
    return this.managedClusterArn;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHubClusterArn() {
    return this.hubClusterArn != null;
  }
  
  public boolean hasManagedClusterArn() {
    return this.managedClusterArn != null;
  }
  
  public int hashCode() {
    return Objects.hash(hubClusterArn, managedClusterArn, additionalProperties);
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
    if (!(hubClusterArn == null)) {
        sb.append("hubClusterArn:");
        sb.append(hubClusterArn);
        sb.append(",");
    }
    if (!(managedClusterArn == null)) {
        sb.append("managedClusterArn:");
        sb.append(managedClusterArn);
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
  
  public A withHubClusterArn(String hubClusterArn) {
    this.hubClusterArn = hubClusterArn;
    return (A) this;
  }
  
  public A withManagedClusterArn(String managedClusterArn) {
    this.managedClusterArn = managedClusterArn;
    return (A) this;
  }
  
}