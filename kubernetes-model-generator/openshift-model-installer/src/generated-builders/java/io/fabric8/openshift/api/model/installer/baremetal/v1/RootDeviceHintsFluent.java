package io.fabric8.openshift.api.model.installer.baremetal.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class RootDeviceHintsFluent<A extends io.fabric8.openshift.api.model.installer.baremetal.v1.RootDeviceHintsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String deviceName;
  private String hctl;
  private Integer minSizeGigabytes;
  private String model;
  private Boolean rotational;
  private String serialNumber;
  private String vendor;
  private String wwn;
  private String wwnVendorExtension;
  private String wwnWithExtension;

  public RootDeviceHintsFluent() {
  }
  
  public RootDeviceHintsFluent(RootDeviceHints instance) {
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
  
  protected void copyInstance(RootDeviceHints instance) {
    instance = instance != null ? instance : new RootDeviceHints();
    if (instance != null) {
        this.withDeviceName(instance.getDeviceName());
        this.withHctl(instance.getHctl());
        this.withMinSizeGigabytes(instance.getMinSizeGigabytes());
        this.withModel(instance.getModel());
        this.withRotational(instance.getRotational());
        this.withSerialNumber(instance.getSerialNumber());
        this.withVendor(instance.getVendor());
        this.withWwn(instance.getWwn());
        this.withWwnVendorExtension(instance.getWwnVendorExtension());
        this.withWwnWithExtension(instance.getWwnWithExtension());
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
    RootDeviceHintsFluent that = (RootDeviceHintsFluent) o;
    if (!(Objects.equals(deviceName, that.deviceName))) {
      return false;
    }
    if (!(Objects.equals(hctl, that.hctl))) {
      return false;
    }
    if (!(Objects.equals(minSizeGigabytes, that.minSizeGigabytes))) {
      return false;
    }
    if (!(Objects.equals(model, that.model))) {
      return false;
    }
    if (!(Objects.equals(rotational, that.rotational))) {
      return false;
    }
    if (!(Objects.equals(serialNumber, that.serialNumber))) {
      return false;
    }
    if (!(Objects.equals(vendor, that.vendor))) {
      return false;
    }
    if (!(Objects.equals(wwn, that.wwn))) {
      return false;
    }
    if (!(Objects.equals(wwnVendorExtension, that.wwnVendorExtension))) {
      return false;
    }
    if (!(Objects.equals(wwnWithExtension, that.wwnWithExtension))) {
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
  
  public String getDeviceName() {
    return this.deviceName;
  }
  
  public String getHctl() {
    return this.hctl;
  }
  
  public Integer getMinSizeGigabytes() {
    return this.minSizeGigabytes;
  }
  
  public String getModel() {
    return this.model;
  }
  
  public Boolean getRotational() {
    return this.rotational;
  }
  
  public String getSerialNumber() {
    return this.serialNumber;
  }
  
  public String getVendor() {
    return this.vendor;
  }
  
  public String getWwn() {
    return this.wwn;
  }
  
  public String getWwnVendorExtension() {
    return this.wwnVendorExtension;
  }
  
  public String getWwnWithExtension() {
    return this.wwnWithExtension;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDeviceName() {
    return this.deviceName != null;
  }
  
  public boolean hasHctl() {
    return this.hctl != null;
  }
  
  public boolean hasMinSizeGigabytes() {
    return this.minSizeGigabytes != null;
  }
  
  public boolean hasModel() {
    return this.model != null;
  }
  
  public boolean hasRotational() {
    return this.rotational != null;
  }
  
  public boolean hasSerialNumber() {
    return this.serialNumber != null;
  }
  
  public boolean hasVendor() {
    return this.vendor != null;
  }
  
  public boolean hasWwn() {
    return this.wwn != null;
  }
  
  public boolean hasWwnVendorExtension() {
    return this.wwnVendorExtension != null;
  }
  
  public boolean hasWwnWithExtension() {
    return this.wwnWithExtension != null;
  }
  
  public int hashCode() {
    return Objects.hash(deviceName, hctl, minSizeGigabytes, model, rotational, serialNumber, vendor, wwn, wwnVendorExtension, wwnWithExtension, additionalProperties);
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
    if (!(deviceName == null)) {
        sb.append("deviceName:");
        sb.append(deviceName);
        sb.append(",");
    }
    if (!(hctl == null)) {
        sb.append("hctl:");
        sb.append(hctl);
        sb.append(",");
    }
    if (!(minSizeGigabytes == null)) {
        sb.append("minSizeGigabytes:");
        sb.append(minSizeGigabytes);
        sb.append(",");
    }
    if (!(model == null)) {
        sb.append("model:");
        sb.append(model);
        sb.append(",");
    }
    if (!(rotational == null)) {
        sb.append("rotational:");
        sb.append(rotational);
        sb.append(",");
    }
    if (!(serialNumber == null)) {
        sb.append("serialNumber:");
        sb.append(serialNumber);
        sb.append(",");
    }
    if (!(vendor == null)) {
        sb.append("vendor:");
        sb.append(vendor);
        sb.append(",");
    }
    if (!(wwn == null)) {
        sb.append("wwn:");
        sb.append(wwn);
        sb.append(",");
    }
    if (!(wwnVendorExtension == null)) {
        sb.append("wwnVendorExtension:");
        sb.append(wwnVendorExtension);
        sb.append(",");
    }
    if (!(wwnWithExtension == null)) {
        sb.append("wwnWithExtension:");
        sb.append(wwnWithExtension);
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
  
  public A withDeviceName(String deviceName) {
    this.deviceName = deviceName;
    return (A) this;
  }
  
  public A withHctl(String hctl) {
    this.hctl = hctl;
    return (A) this;
  }
  
  public A withMinSizeGigabytes(Integer minSizeGigabytes) {
    this.minSizeGigabytes = minSizeGigabytes;
    return (A) this;
  }
  
  public A withModel(String model) {
    this.model = model;
    return (A) this;
  }
  
  public A withRotational() {
    return withRotational(true);
  }
  
  public A withRotational(Boolean rotational) {
    this.rotational = rotational;
    return (A) this;
  }
  
  public A withSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return (A) this;
  }
  
  public A withVendor(String vendor) {
    this.vendor = vendor;
    return (A) this;
  }
  
  public A withWwn(String wwn) {
    this.wwn = wwn;
    return (A) this;
  }
  
  public A withWwnVendorExtension(String wwnVendorExtension) {
    this.wwnVendorExtension = wwnVendorExtension;
    return (A) this;
  }
  
  public A withWwnWithExtension(String wwnWithExtension) {
    this.wwnWithExtension = wwnWithExtension;
    return (A) this;
  }
  
}