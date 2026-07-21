package io.fabric8.chaosmesh.v1alpha1;

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
public class AWSSelectorFluent<A extends io.fabric8.chaosmesh.v1alpha1.AWSSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String awsRegion;
  private String deviceName;
  private String ec2Instance;
  private String endpoint;
  private String volumeID;

  public AWSSelectorFluent() {
  }
  
  public AWSSelectorFluent(AWSSelector instance) {
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
  
  protected void copyInstance(AWSSelector instance) {
    instance = instance != null ? instance : new AWSSelector();
    if (instance != null) {
        this.withAwsRegion(instance.getAwsRegion());
        this.withDeviceName(instance.getDeviceName());
        this.withEc2Instance(instance.getEc2Instance());
        this.withEndpoint(instance.getEndpoint());
        this.withVolumeID(instance.getVolumeID());
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
    AWSSelectorFluent that = (AWSSelectorFluent) o;
    if (!(Objects.equals(awsRegion, that.awsRegion))) {
      return false;
    }
    if (!(Objects.equals(deviceName, that.deviceName))) {
      return false;
    }
    if (!(Objects.equals(ec2Instance, that.ec2Instance))) {
      return false;
    }
    if (!(Objects.equals(endpoint, that.endpoint))) {
      return false;
    }
    if (!(Objects.equals(volumeID, that.volumeID))) {
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
  
  public String getAwsRegion() {
    return this.awsRegion;
  }
  
  public String getDeviceName() {
    return this.deviceName;
  }
  
  public String getEc2Instance() {
    return this.ec2Instance;
  }
  
  public String getEndpoint() {
    return this.endpoint;
  }
  
  public String getVolumeID() {
    return this.volumeID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAwsRegion() {
    return this.awsRegion != null;
  }
  
  public boolean hasDeviceName() {
    return this.deviceName != null;
  }
  
  public boolean hasEc2Instance() {
    return this.ec2Instance != null;
  }
  
  public boolean hasEndpoint() {
    return this.endpoint != null;
  }
  
  public boolean hasVolumeID() {
    return this.volumeID != null;
  }
  
  public int hashCode() {
    return Objects.hash(awsRegion, deviceName, ec2Instance, endpoint, volumeID, additionalProperties);
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
    if (!(awsRegion == null)) {
        sb.append("awsRegion:");
        sb.append(awsRegion);
        sb.append(",");
    }
    if (!(deviceName == null)) {
        sb.append("deviceName:");
        sb.append(deviceName);
        sb.append(",");
    }
    if (!(ec2Instance == null)) {
        sb.append("ec2Instance:");
        sb.append(ec2Instance);
        sb.append(",");
    }
    if (!(endpoint == null)) {
        sb.append("endpoint:");
        sb.append(endpoint);
        sb.append(",");
    }
    if (!(volumeID == null)) {
        sb.append("volumeID:");
        sb.append(volumeID);
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
  
  public A withAwsRegion(String awsRegion) {
    this.awsRegion = awsRegion;
    return (A) this;
  }
  
  public A withDeviceName(String deviceName) {
    this.deviceName = deviceName;
    return (A) this;
  }
  
  public A withEc2Instance(String ec2Instance) {
    this.ec2Instance = ec2Instance;
    return (A) this;
  }
  
  public A withEndpoint(String endpoint) {
    this.endpoint = endpoint;
    return (A) this;
  }
  
  public A withVolumeID(String volumeID) {
    this.volumeID = volumeID;
    return (A) this;
  }
  
}