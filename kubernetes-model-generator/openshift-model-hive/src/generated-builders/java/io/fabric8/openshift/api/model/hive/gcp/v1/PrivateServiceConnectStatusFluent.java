package io.fabric8.openshift.api.model.hive.gcp.v1;

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
public class PrivateServiceConnectStatusFluent<A extends io.fabric8.openshift.api.model.hive.gcp.v1.PrivateServiceConnectStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String endpoint;
  private String endpointAddress;
  private String serviceAttachment;
  private String serviceAttachmentFirewall;
  private String serviceAttachmentSubnet;

  public PrivateServiceConnectStatusFluent() {
  }
  
  public PrivateServiceConnectStatusFluent(PrivateServiceConnectStatus instance) {
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
  
  protected void copyInstance(PrivateServiceConnectStatus instance) {
    instance = instance != null ? instance : new PrivateServiceConnectStatus();
    if (instance != null) {
        this.withEndpoint(instance.getEndpoint());
        this.withEndpointAddress(instance.getEndpointAddress());
        this.withServiceAttachment(instance.getServiceAttachment());
        this.withServiceAttachmentFirewall(instance.getServiceAttachmentFirewall());
        this.withServiceAttachmentSubnet(instance.getServiceAttachmentSubnet());
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
    PrivateServiceConnectStatusFluent that = (PrivateServiceConnectStatusFluent) o;
    if (!(Objects.equals(endpoint, that.endpoint))) {
      return false;
    }
    if (!(Objects.equals(endpointAddress, that.endpointAddress))) {
      return false;
    }
    if (!(Objects.equals(serviceAttachment, that.serviceAttachment))) {
      return false;
    }
    if (!(Objects.equals(serviceAttachmentFirewall, that.serviceAttachmentFirewall))) {
      return false;
    }
    if (!(Objects.equals(serviceAttachmentSubnet, that.serviceAttachmentSubnet))) {
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
  
  public String getEndpoint() {
    return this.endpoint;
  }
  
  public String getEndpointAddress() {
    return this.endpointAddress;
  }
  
  public String getServiceAttachment() {
    return this.serviceAttachment;
  }
  
  public String getServiceAttachmentFirewall() {
    return this.serviceAttachmentFirewall;
  }
  
  public String getServiceAttachmentSubnet() {
    return this.serviceAttachmentSubnet;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEndpoint() {
    return this.endpoint != null;
  }
  
  public boolean hasEndpointAddress() {
    return this.endpointAddress != null;
  }
  
  public boolean hasServiceAttachment() {
    return this.serviceAttachment != null;
  }
  
  public boolean hasServiceAttachmentFirewall() {
    return this.serviceAttachmentFirewall != null;
  }
  
  public boolean hasServiceAttachmentSubnet() {
    return this.serviceAttachmentSubnet != null;
  }
  
  public int hashCode() {
    return Objects.hash(endpoint, endpointAddress, serviceAttachment, serviceAttachmentFirewall, serviceAttachmentSubnet, additionalProperties);
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
    if (!(endpoint == null)) {
        sb.append("endpoint:");
        sb.append(endpoint);
        sb.append(",");
    }
    if (!(endpointAddress == null)) {
        sb.append("endpointAddress:");
        sb.append(endpointAddress);
        sb.append(",");
    }
    if (!(serviceAttachment == null)) {
        sb.append("serviceAttachment:");
        sb.append(serviceAttachment);
        sb.append(",");
    }
    if (!(serviceAttachmentFirewall == null)) {
        sb.append("serviceAttachmentFirewall:");
        sb.append(serviceAttachmentFirewall);
        sb.append(",");
    }
    if (!(serviceAttachmentSubnet == null)) {
        sb.append("serviceAttachmentSubnet:");
        sb.append(serviceAttachmentSubnet);
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
  
  public A withEndpoint(String endpoint) {
    this.endpoint = endpoint;
    return (A) this;
  }
  
  public A withEndpointAddress(String endpointAddress) {
    this.endpointAddress = endpointAddress;
    return (A) this;
  }
  
  public A withServiceAttachment(String serviceAttachment) {
    this.serviceAttachment = serviceAttachment;
    return (A) this;
  }
  
  public A withServiceAttachmentFirewall(String serviceAttachmentFirewall) {
    this.serviceAttachmentFirewall = serviceAttachmentFirewall;
    return (A) this;
  }
  
  public A withServiceAttachmentSubnet(String serviceAttachmentSubnet) {
    this.serviceAttachmentSubnet = serviceAttachmentSubnet;
    return (A) this;
  }
  
}