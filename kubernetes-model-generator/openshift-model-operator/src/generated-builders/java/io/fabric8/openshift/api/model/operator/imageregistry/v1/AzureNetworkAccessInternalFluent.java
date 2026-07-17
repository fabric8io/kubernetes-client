package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
public class AzureNetworkAccessInternalFluent<A extends io.fabric8.openshift.api.model.operator.imageregistry.v1.AzureNetworkAccessInternalFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String networkResourceGroupName;
  private String privateEndpointName;
  private String subnetName;
  private String vnetName;

  public AzureNetworkAccessInternalFluent() {
  }
  
  public AzureNetworkAccessInternalFluent(AzureNetworkAccessInternal instance) {
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
  
  protected void copyInstance(AzureNetworkAccessInternal instance) {
    instance = instance != null ? instance : new AzureNetworkAccessInternal();
    if (instance != null) {
        this.withNetworkResourceGroupName(instance.getNetworkResourceGroupName());
        this.withPrivateEndpointName(instance.getPrivateEndpointName());
        this.withSubnetName(instance.getSubnetName());
        this.withVnetName(instance.getVnetName());
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
    AzureNetworkAccessInternalFluent that = (AzureNetworkAccessInternalFluent) o;
    if (!(Objects.equals(networkResourceGroupName, that.networkResourceGroupName))) {
      return false;
    }
    if (!(Objects.equals(privateEndpointName, that.privateEndpointName))) {
      return false;
    }
    if (!(Objects.equals(subnetName, that.subnetName))) {
      return false;
    }
    if (!(Objects.equals(vnetName, that.vnetName))) {
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
  
  public String getNetworkResourceGroupName() {
    return this.networkResourceGroupName;
  }
  
  public String getPrivateEndpointName() {
    return this.privateEndpointName;
  }
  
  public String getSubnetName() {
    return this.subnetName;
  }
  
  public String getVnetName() {
    return this.vnetName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasNetworkResourceGroupName() {
    return this.networkResourceGroupName != null;
  }
  
  public boolean hasPrivateEndpointName() {
    return this.privateEndpointName != null;
  }
  
  public boolean hasSubnetName() {
    return this.subnetName != null;
  }
  
  public boolean hasVnetName() {
    return this.vnetName != null;
  }
  
  public int hashCode() {
    return Objects.hash(networkResourceGroupName, privateEndpointName, subnetName, vnetName, additionalProperties);
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
    if (!(networkResourceGroupName == null)) {
        sb.append("networkResourceGroupName:");
        sb.append(networkResourceGroupName);
        sb.append(",");
    }
    if (!(privateEndpointName == null)) {
        sb.append("privateEndpointName:");
        sb.append(privateEndpointName);
        sb.append(",");
    }
    if (!(subnetName == null)) {
        sb.append("subnetName:");
        sb.append(subnetName);
        sb.append(",");
    }
    if (!(vnetName == null)) {
        sb.append("vnetName:");
        sb.append(vnetName);
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
  
  public A withNetworkResourceGroupName(String networkResourceGroupName) {
    this.networkResourceGroupName = networkResourceGroupName;
    return (A) this;
  }
  
  public A withPrivateEndpointName(String privateEndpointName) {
    this.privateEndpointName = privateEndpointName;
    return (A) this;
  }
  
  public A withSubnetName(String subnetName) {
    this.subnetName = subnetName;
    return (A) this;
  }
  
  public A withVnetName(String vnetName) {
    this.vnetName = vnetName;
    return (A) this;
  }
  
}