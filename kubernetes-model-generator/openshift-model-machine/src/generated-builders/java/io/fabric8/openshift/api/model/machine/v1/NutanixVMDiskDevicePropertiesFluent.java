package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class NutanixVMDiskDevicePropertiesFluent<A extends io.fabric8.openshift.api.model.machine.v1.NutanixVMDiskDevicePropertiesFluent<A>> extends BaseFluent<A>{

  private String adapterType;
  private Map<String,Object> additionalProperties;
  private Integer deviceIndex;
  private String deviceType;

  public NutanixVMDiskDevicePropertiesFluent() {
  }
  
  public NutanixVMDiskDevicePropertiesFluent(NutanixVMDiskDeviceProperties instance) {
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
  
  protected void copyInstance(NutanixVMDiskDeviceProperties instance) {
    instance = instance != null ? instance : new NutanixVMDiskDeviceProperties();
    if (instance != null) {
        this.withAdapterType(instance.getAdapterType());
        this.withDeviceIndex(instance.getDeviceIndex());
        this.withDeviceType(instance.getDeviceType());
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
    NutanixVMDiskDevicePropertiesFluent that = (NutanixVMDiskDevicePropertiesFluent) o;
    if (!(Objects.equals(adapterType, that.adapterType))) {
      return false;
    }
    if (!(Objects.equals(deviceIndex, that.deviceIndex))) {
      return false;
    }
    if (!(Objects.equals(deviceType, that.deviceType))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAdapterType() {
    return this.adapterType;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Integer getDeviceIndex() {
    return this.deviceIndex;
  }
  
  public String getDeviceType() {
    return this.deviceType;
  }
  
  public boolean hasAdapterType() {
    return this.adapterType != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDeviceIndex() {
    return this.deviceIndex != null;
  }
  
  public boolean hasDeviceType() {
    return this.deviceType != null;
  }
  
  public int hashCode() {
    return Objects.hash(adapterType, deviceIndex, deviceType, additionalProperties);
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
    if (!(adapterType == null)) {
        sb.append("adapterType:");
        sb.append(adapterType);
        sb.append(",");
    }
    if (!(deviceIndex == null)) {
        sb.append("deviceIndex:");
        sb.append(deviceIndex);
        sb.append(",");
    }
    if (!(deviceType == null)) {
        sb.append("deviceType:");
        sb.append(deviceType);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdapterType(String adapterType) {
    this.adapterType = adapterType;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withDeviceIndex(Integer deviceIndex) {
    this.deviceIndex = deviceIndex;
    return (A) this;
  }
  
  public A withDeviceType(String deviceType) {
    this.deviceType = deviceType;
    return (A) this;
  }
  
}