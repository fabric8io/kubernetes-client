package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
public class HardwareSystemVendorFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.HardwareSystemVendorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String manufacturer;
  private String productName;
  private String serialNumber;

  public HardwareSystemVendorFluent() {
  }
  
  public HardwareSystemVendorFluent(HardwareSystemVendor instance) {
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
  
  protected void copyInstance(HardwareSystemVendor instance) {
    instance = instance != null ? instance : new HardwareSystemVendor();
    if (instance != null) {
        this.withManufacturer(instance.getManufacturer());
        this.withProductName(instance.getProductName());
        this.withSerialNumber(instance.getSerialNumber());
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
    HardwareSystemVendorFluent that = (HardwareSystemVendorFluent) o;
    if (!(Objects.equals(manufacturer, that.manufacturer))) {
      return false;
    }
    if (!(Objects.equals(productName, that.productName))) {
      return false;
    }
    if (!(Objects.equals(serialNumber, that.serialNumber))) {
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
  
  public String getManufacturer() {
    return this.manufacturer;
  }
  
  public String getProductName() {
    return this.productName;
  }
  
  public String getSerialNumber() {
    return this.serialNumber;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasManufacturer() {
    return this.manufacturer != null;
  }
  
  public boolean hasProductName() {
    return this.productName != null;
  }
  
  public boolean hasSerialNumber() {
    return this.serialNumber != null;
  }
  
  public int hashCode() {
    return Objects.hash(manufacturer, productName, serialNumber, additionalProperties);
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
    if (!(manufacturer == null)) {
        sb.append("manufacturer:");
        sb.append(manufacturer);
        sb.append(",");
    }
    if (!(productName == null)) {
        sb.append("productName:");
        sb.append(productName);
        sb.append(",");
    }
    if (!(serialNumber == null)) {
        sb.append("serialNumber:");
        sb.append(serialNumber);
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
  
  public A withManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
    return (A) this;
  }
  
  public A withProductName(String productName) {
    this.productName = productName;
    return (A) this;
  }
  
  public A withSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return (A) this;
  }
  
}