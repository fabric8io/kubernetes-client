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
public class AWSChaosSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.AWSChaosSpecFluent<A>> extends BaseFluent<A>{

  private String action;
  private Map<String,Object> additionalProperties;
  private String awsRegion;
  private String deviceName;
  private String duration;
  private String ec2Instance;
  private String endpoint;
  private String remoteCluster;
  private String secretName;
  private String volumeID;

  public AWSChaosSpecFluent() {
  }
  
  public AWSChaosSpecFluent(AWSChaosSpec instance) {
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
  
  protected void copyInstance(AWSChaosSpec instance) {
    instance = instance != null ? instance : new AWSChaosSpec();
    if (instance != null) {
        this.withAction(instance.getAction());
        this.withAwsRegion(instance.getAwsRegion());
        this.withDeviceName(instance.getDeviceName());
        this.withDuration(instance.getDuration());
        this.withEc2Instance(instance.getEc2Instance());
        this.withEndpoint(instance.getEndpoint());
        this.withRemoteCluster(instance.getRemoteCluster());
        this.withSecretName(instance.getSecretName());
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
    AWSChaosSpecFluent that = (AWSChaosSpecFluent) o;
    if (!(Objects.equals(action, that.action))) {
      return false;
    }
    if (!(Objects.equals(awsRegion, that.awsRegion))) {
      return false;
    }
    if (!(Objects.equals(deviceName, that.deviceName))) {
      return false;
    }
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(ec2Instance, that.ec2Instance))) {
      return false;
    }
    if (!(Objects.equals(endpoint, that.endpoint))) {
      return false;
    }
    if (!(Objects.equals(remoteCluster, that.remoteCluster))) {
      return false;
    }
    if (!(Objects.equals(secretName, that.secretName))) {
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
  
  public String getAction() {
    return this.action;
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
  
  public String getDuration() {
    return this.duration;
  }
  
  public String getEc2Instance() {
    return this.ec2Instance;
  }
  
  public String getEndpoint() {
    return this.endpoint;
  }
  
  public String getRemoteCluster() {
    return this.remoteCluster;
  }
  
  public String getSecretName() {
    return this.secretName;
  }
  
  public String getVolumeID() {
    return this.volumeID;
  }
  
  public boolean hasAction() {
    return this.action != null;
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
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasEc2Instance() {
    return this.ec2Instance != null;
  }
  
  public boolean hasEndpoint() {
    return this.endpoint != null;
  }
  
  public boolean hasRemoteCluster() {
    return this.remoteCluster != null;
  }
  
  public boolean hasSecretName() {
    return this.secretName != null;
  }
  
  public boolean hasVolumeID() {
    return this.volumeID != null;
  }
  
  public int hashCode() {
    return Objects.hash(action, awsRegion, deviceName, duration, ec2Instance, endpoint, remoteCluster, secretName, volumeID, additionalProperties);
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
    if (!(action == null)) {
        sb.append("action:");
        sb.append(action);
        sb.append(",");
    }
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
    if (!(duration == null)) {
        sb.append("duration:");
        sb.append(duration);
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
    if (!(remoteCluster == null)) {
        sb.append("remoteCluster:");
        sb.append(remoteCluster);
        sb.append(",");
    }
    if (!(secretName == null)) {
        sb.append("secretName:");
        sb.append(secretName);
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
  
  public A withAction(String action) {
    this.action = action;
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
  
  public A withAwsRegion(String awsRegion) {
    this.awsRegion = awsRegion;
    return (A) this;
  }
  
  public A withDeviceName(String deviceName) {
    this.deviceName = deviceName;
    return (A) this;
  }
  
  public A withDuration(String duration) {
    this.duration = duration;
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
  
  public A withRemoteCluster(String remoteCluster) {
    this.remoteCluster = remoteCluster;
    return (A) this;
  }
  
  public A withSecretName(String secretName) {
    this.secretName = secretName;
    return (A) this;
  }
  
  public A withVolumeID(String volumeID) {
    this.volumeID = volumeID;
    return (A) this;
  }
  
}