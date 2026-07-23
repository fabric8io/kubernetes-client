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
public class VdpaDeviceFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.VdpaDeviceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String driver;
  private String parentDevice;
  private String path;
  private String pciAddress;
  private String pfPciAddress;
  private String representorDevice;

  public VdpaDeviceFluent() {
  }
  
  public VdpaDeviceFluent(VdpaDevice instance) {
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
  
  protected void copyInstance(VdpaDevice instance) {
    instance = instance != null ? instance : new VdpaDevice();
    if (instance != null) {
        this.withDriver(instance.getDriver());
        this.withParentDevice(instance.getParentDevice());
        this.withPath(instance.getPath());
        this.withPciAddress(instance.getPciAddress());
        this.withPfPciAddress(instance.getPfPciAddress());
        this.withRepresentorDevice(instance.getRepresentorDevice());
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
    VdpaDeviceFluent that = (VdpaDeviceFluent) o;
    if (!(Objects.equals(driver, that.driver))) {
      return false;
    }
    if (!(Objects.equals(parentDevice, that.parentDevice))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(pciAddress, that.pciAddress))) {
      return false;
    }
    if (!(Objects.equals(pfPciAddress, that.pfPciAddress))) {
      return false;
    }
    if (!(Objects.equals(representorDevice, that.representorDevice))) {
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
  
  public String getDriver() {
    return this.driver;
  }
  
  public String getParentDevice() {
    return this.parentDevice;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public String getPciAddress() {
    return this.pciAddress;
  }
  
  public String getPfPciAddress() {
    return this.pfPciAddress;
  }
  
  public String getRepresentorDevice() {
    return this.representorDevice;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDriver() {
    return this.driver != null;
  }
  
  public boolean hasParentDevice() {
    return this.parentDevice != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasPciAddress() {
    return this.pciAddress != null;
  }
  
  public boolean hasPfPciAddress() {
    return this.pfPciAddress != null;
  }
  
  public boolean hasRepresentorDevice() {
    return this.representorDevice != null;
  }
  
  public int hashCode() {
    return Objects.hash(driver, parentDevice, path, pciAddress, pfPciAddress, representorDevice, additionalProperties);
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
    if (!(driver == null)) {
        sb.append("driver:");
        sb.append(driver);
        sb.append(",");
    }
    if (!(parentDevice == null)) {
        sb.append("parentDevice:");
        sb.append(parentDevice);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
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
    if (!(representorDevice == null)) {
        sb.append("representorDevice:");
        sb.append(representorDevice);
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
  
  public A withDriver(String driver) {
    this.driver = driver;
    return (A) this;
  }
  
  public A withParentDevice(String parentDevice) {
    this.parentDevice = parentDevice;
    return (A) this;
  }
  
  public A withPath(String path) {
    this.path = path;
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
  
  public A withRepresentorDevice(String representorDevice) {
    this.representorDevice = representorDevice;
    return (A) this;
  }
  
}