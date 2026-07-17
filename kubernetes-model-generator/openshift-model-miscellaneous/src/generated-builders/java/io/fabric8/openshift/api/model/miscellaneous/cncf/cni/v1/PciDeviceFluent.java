package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

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
public class PciDeviceFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.PciDeviceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String pciAddress;
  private String pfPciAddress;
  private String rdmaDevice;
  private String representorDevice;
  private String vhostNet;

  public PciDeviceFluent() {
  }
  
  public PciDeviceFluent(PciDevice instance) {
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
  
  protected void copyInstance(PciDevice instance) {
    instance = instance != null ? instance : new PciDevice();
    if (instance != null) {
        this.withPciAddress(instance.getPciAddress());
        this.withPfPciAddress(instance.getPfPciAddress());
        this.withRdmaDevice(instance.getRdmaDevice());
        this.withRepresentorDevice(instance.getRepresentorDevice());
        this.withVhostNet(instance.getVhostNet());
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
    PciDeviceFluent that = (PciDeviceFluent) o;
    if (!(Objects.equals(pciAddress, that.pciAddress))) {
      return false;
    }
    if (!(Objects.equals(pfPciAddress, that.pfPciAddress))) {
      return false;
    }
    if (!(Objects.equals(rdmaDevice, that.rdmaDevice))) {
      return false;
    }
    if (!(Objects.equals(representorDevice, that.representorDevice))) {
      return false;
    }
    if (!(Objects.equals(vhostNet, that.vhostNet))) {
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
  
  public String getPciAddress() {
    return this.pciAddress;
  }
  
  public String getPfPciAddress() {
    return this.pfPciAddress;
  }
  
  public String getRdmaDevice() {
    return this.rdmaDevice;
  }
  
  public String getRepresentorDevice() {
    return this.representorDevice;
  }
  
  public String getVhostNet() {
    return this.vhostNet;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPciAddress() {
    return this.pciAddress != null;
  }
  
  public boolean hasPfPciAddress() {
    return this.pfPciAddress != null;
  }
  
  public boolean hasRdmaDevice() {
    return this.rdmaDevice != null;
  }
  
  public boolean hasRepresentorDevice() {
    return this.representorDevice != null;
  }
  
  public boolean hasVhostNet() {
    return this.vhostNet != null;
  }
  
  public int hashCode() {
    return Objects.hash(pciAddress, pfPciAddress, rdmaDevice, representorDevice, vhostNet, additionalProperties);
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
    if (!(pciAddress == null)) {
        sb.append("pciAddress:");
        sb.append(pciAddress);
        sb.append(",");
    }
    if (!(pfPciAddress == null)) {
        sb.append("pfPciAddress:");
        sb.append(pfPciAddress);
        sb.append(",");
    }
    if (!(rdmaDevice == null)) {
        sb.append("rdmaDevice:");
        sb.append(rdmaDevice);
        sb.append(",");
    }
    if (!(representorDevice == null)) {
        sb.append("representorDevice:");
        sb.append(representorDevice);
        sb.append(",");
    }
    if (!(vhostNet == null)) {
        sb.append("vhostNet:");
        sb.append(vhostNet);
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
  
  public A withPciAddress(String pciAddress) {
    this.pciAddress = pciAddress;
    return (A) this;
  }
  
  public A withPfPciAddress(String pfPciAddress) {
    this.pfPciAddress = pfPciAddress;
    return (A) this;
  }
  
  public A withRdmaDevice(String rdmaDevice) {
    this.rdmaDevice = rdmaDevice;
    return (A) this;
  }
  
  public A withRepresentorDevice(String representorDevice) {
    this.representorDevice = representorDevice;
    return (A) this;
  }
  
  public A withVhostNet(String vhostNet) {
    this.vhostNet = vhostNet;
    return (A) this;
  }
  
}