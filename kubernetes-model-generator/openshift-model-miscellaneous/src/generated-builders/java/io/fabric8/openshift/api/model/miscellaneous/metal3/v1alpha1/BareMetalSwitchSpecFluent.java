package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.SecretReference;
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
public class BareMetalSwitchSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.BareMetalSwitchSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String address;
  private SecretReference credentials;
  private String deviceType;
  private Boolean disableCertificateVerification;
  private String driver;
  private String macAddress;
  private Integer port;

  public BareMetalSwitchSpecFluent() {
  }
  
  public BareMetalSwitchSpecFluent(BareMetalSwitchSpec instance) {
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
  
  protected void copyInstance(BareMetalSwitchSpec instance) {
    instance = instance != null ? instance : new BareMetalSwitchSpec();
    if (instance != null) {
        this.withAddress(instance.getAddress());
        this.withCredentials(instance.getCredentials());
        this.withDeviceType(instance.getDeviceType());
        this.withDisableCertificateVerification(instance.getDisableCertificateVerification());
        this.withDriver(instance.getDriver());
        this.withMacAddress(instance.getMacAddress());
        this.withPort(instance.getPort());
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
    BareMetalSwitchSpecFluent that = (BareMetalSwitchSpecFluent) o;
    if (!(Objects.equals(address, that.address))) {
      return false;
    }
    if (!(Objects.equals(credentials, that.credentials))) {
      return false;
    }
    if (!(Objects.equals(deviceType, that.deviceType))) {
      return false;
    }
    if (!(Objects.equals(disableCertificateVerification, that.disableCertificateVerification))) {
      return false;
    }
    if (!(Objects.equals(driver, that.driver))) {
      return false;
    }
    if (!(Objects.equals(macAddress, that.macAddress))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
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
  
  public String getAddress() {
    return this.address;
  }
  
  public SecretReference getCredentials() {
    return this.credentials;
  }
  
  public String getDeviceType() {
    return this.deviceType;
  }
  
  public Boolean getDisableCertificateVerification() {
    return this.disableCertificateVerification;
  }
  
  public String getDriver() {
    return this.driver;
  }
  
  public String getMacAddress() {
    return this.macAddress;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddress() {
    return this.address != null;
  }
  
  public boolean hasCredentials() {
    return this.credentials != null;
  }
  
  public boolean hasDeviceType() {
    return this.deviceType != null;
  }
  
  public boolean hasDisableCertificateVerification() {
    return this.disableCertificateVerification != null;
  }
  
  public boolean hasDriver() {
    return this.driver != null;
  }
  
  public boolean hasMacAddress() {
    return this.macAddress != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public int hashCode() {
    return Objects.hash(address, credentials, deviceType, disableCertificateVerification, driver, macAddress, port, additionalProperties);
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
    if (!(address == null)) {
        sb.append("address:");
        sb.append(address);
        sb.append(",");
    }
    if (!(credentials == null)) {
        sb.append("credentials:");
        sb.append(credentials);
        sb.append(",");
    }
    if (!(deviceType == null)) {
        sb.append("deviceType:");
        sb.append(deviceType);
        sb.append(",");
    }
    if (!(disableCertificateVerification == null)) {
        sb.append("disableCertificateVerification:");
        sb.append(disableCertificateVerification);
        sb.append(",");
    }
    if (!(driver == null)) {
        sb.append("driver:");
        sb.append(driver);
        sb.append(",");
    }
    if (!(macAddress == null)) {
        sb.append("macAddress:");
        sb.append(macAddress);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
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
  
  public A withAddress(String address) {
    this.address = address;
    return (A) this;
  }
  
  public A withCredentials(SecretReference credentials) {
    this.credentials = credentials;
    return (A) this;
  }
  
  public A withDeviceType(String deviceType) {
    this.deviceType = deviceType;
    return (A) this;
  }
  
  public A withDisableCertificateVerification() {
    return withDisableCertificateVerification(true);
  }
  
  public A withDisableCertificateVerification(Boolean disableCertificateVerification) {
    this.disableCertificateVerification = disableCertificateVerification;
    return (A) this;
  }
  
  public A withDriver(String driver) {
    this.driver = driver;
    return (A) this;
  }
  
  public A withMacAddress(String macAddress) {
    this.macAddress = macAddress;
    return (A) this;
  }
  
  public A withNewCredentials(String name,String namespace) {
    return (A) this.withCredentials(new SecretReference(name, namespace));
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
}