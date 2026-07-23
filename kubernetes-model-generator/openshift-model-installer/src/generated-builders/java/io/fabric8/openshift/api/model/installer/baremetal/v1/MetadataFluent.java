package io.fabric8.openshift.api.model.installer.baremetal.v1;

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
public class MetadataFluent<A extends io.fabric8.openshift.api.model.installer.baremetal.v1.MetadataFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String bootstrapProvisioningIP;
  private String libvirtURI;
  private String provisioningHostIP;

  public MetadataFluent() {
  }
  
  public MetadataFluent(Metadata instance) {
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
  
  protected void copyInstance(Metadata instance) {
    instance = instance != null ? instance : new Metadata();
    if (instance != null) {
        this.withBootstrapProvisioningIP(instance.getBootstrapProvisioningIP());
        this.withLibvirtURI(instance.getLibvirtURI());
        this.withProvisioningHostIP(instance.getProvisioningHostIP());
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
    MetadataFluent that = (MetadataFluent) o;
    if (!(Objects.equals(bootstrapProvisioningIP, that.bootstrapProvisioningIP))) {
      return false;
    }
    if (!(Objects.equals(libvirtURI, that.libvirtURI))) {
      return false;
    }
    if (!(Objects.equals(provisioningHostIP, that.provisioningHostIP))) {
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
  
  public String getBootstrapProvisioningIP() {
    return this.bootstrapProvisioningIP;
  }
  
  public String getLibvirtURI() {
    return this.libvirtURI;
  }
  
  public String getProvisioningHostIP() {
    return this.provisioningHostIP;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBootstrapProvisioningIP() {
    return this.bootstrapProvisioningIP != null;
  }
  
  public boolean hasLibvirtURI() {
    return this.libvirtURI != null;
  }
  
  public boolean hasProvisioningHostIP() {
    return this.provisioningHostIP != null;
  }
  
  public int hashCode() {
    return Objects.hash(bootstrapProvisioningIP, libvirtURI, provisioningHostIP, additionalProperties);
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
    if (!(bootstrapProvisioningIP == null)) {
        sb.append("bootstrapProvisioningIP:");
        sb.append(bootstrapProvisioningIP);
        sb.append(",");
    }
    if (!(libvirtURI == null)) {
        sb.append("libvirtURI:");
        sb.append(libvirtURI);
        sb.append(",");
    }
    if (!(provisioningHostIP == null)) {
        sb.append("provisioningHostIP:");
        sb.append(provisioningHostIP);
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
  
  public A withBootstrapProvisioningIP(String bootstrapProvisioningIP) {
    this.bootstrapProvisioningIP = bootstrapProvisioningIP;
    return (A) this;
  }
  
  public A withLibvirtURI(String libvirtURI) {
    this.libvirtURI = libvirtURI;
    return (A) this;
  }
  
  public A withProvisioningHostIP(String provisioningHostIP) {
    this.provisioningHostIP = provisioningHostIP;
    return (A) this;
  }
  
}