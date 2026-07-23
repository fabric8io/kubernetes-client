package io.fabric8.chaosmesh.v1alpha1;

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
public class AzureChaosSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.AzureChaosSpecFluent<A>> extends BaseFluent<A>{

  private String action;
  private Map<String,Object> additionalProperties;
  private String diskName;
  private String duration;
  private Integer lun;
  private String remoteCluster;
  private String resourceGroupName;
  private String secretName;
  private String subscriptionID;
  private String vmName;

  public AzureChaosSpecFluent() {
  }
  
  public AzureChaosSpecFluent(AzureChaosSpec instance) {
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
  
  protected void copyInstance(AzureChaosSpec instance) {
    instance = instance != null ? instance : new AzureChaosSpec();
    if (instance != null) {
        this.withAction(instance.getAction());
        this.withDiskName(instance.getDiskName());
        this.withDuration(instance.getDuration());
        this.withLun(instance.getLun());
        this.withRemoteCluster(instance.getRemoteCluster());
        this.withResourceGroupName(instance.getResourceGroupName());
        this.withSecretName(instance.getSecretName());
        this.withSubscriptionID(instance.getSubscriptionID());
        this.withVmName(instance.getVmName());
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
    AzureChaosSpecFluent that = (AzureChaosSpecFluent) o;
    if (!(Objects.equals(action, that.action))) {
      return false;
    }
    if (!(Objects.equals(diskName, that.diskName))) {
      return false;
    }
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(lun, that.lun))) {
      return false;
    }
    if (!(Objects.equals(remoteCluster, that.remoteCluster))) {
      return false;
    }
    if (!(Objects.equals(resourceGroupName, that.resourceGroupName))) {
      return false;
    }
    if (!(Objects.equals(secretName, that.secretName))) {
      return false;
    }
    if (!(Objects.equals(subscriptionID, that.subscriptionID))) {
      return false;
    }
    if (!(Objects.equals(vmName, that.vmName))) {
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
  
  public String getDiskName() {
    return this.diskName;
  }
  
  public String getDuration() {
    return this.duration;
  }
  
  public Integer getLun() {
    return this.lun;
  }
  
  public String getRemoteCluster() {
    return this.remoteCluster;
  }
  
  public String getResourceGroupName() {
    return this.resourceGroupName;
  }
  
  public String getSecretName() {
    return this.secretName;
  }
  
  public String getSubscriptionID() {
    return this.subscriptionID;
  }
  
  public String getVmName() {
    return this.vmName;
  }
  
  public boolean hasAction() {
    return this.action != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDiskName() {
    return this.diskName != null;
  }
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasLun() {
    return this.lun != null;
  }
  
  public boolean hasRemoteCluster() {
    return this.remoteCluster != null;
  }
  
  public boolean hasResourceGroupName() {
    return this.resourceGroupName != null;
  }
  
  public boolean hasSecretName() {
    return this.secretName != null;
  }
  
  public boolean hasSubscriptionID() {
    return this.subscriptionID != null;
  }
  
  public boolean hasVmName() {
    return this.vmName != null;
  }
  
  public int hashCode() {
    return Objects.hash(action, diskName, duration, lun, remoteCluster, resourceGroupName, secretName, subscriptionID, vmName, additionalProperties);
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
    if (!(diskName == null)) {
        sb.append("diskName:");
        sb.append(diskName);
        sb.append(",");
    }
    if (!(duration == null)) {
        sb.append("duration:");
        sb.append(duration);
        sb.append(",");
    }
    if (!(lun == null)) {
        sb.append("lun:");
        sb.append(lun);
        sb.append(",");
    }
    if (!(remoteCluster == null)) {
        sb.append("remoteCluster:");
        sb.append(remoteCluster);
        sb.append(",");
    }
    if (!(resourceGroupName == null)) {
        sb.append("resourceGroupName:");
        sb.append(resourceGroupName);
        sb.append(",");
    }
    if (!(secretName == null)) {
        sb.append("secretName:");
        sb.append(secretName);
        sb.append(",");
    }
    if (!(subscriptionID == null)) {
        sb.append("subscriptionID:");
        sb.append(subscriptionID);
        sb.append(",");
    }
    if (!(vmName == null)) {
        sb.append("vmName:");
        sb.append(vmName);
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
  
  public A withDiskName(String diskName) {
    this.diskName = diskName;
    return (A) this;
  }
  
  public A withDuration(String duration) {
    this.duration = duration;
    return (A) this;
  }
  
  public A withLun(Integer lun) {
    this.lun = lun;
    return (A) this;
  }
  
  public A withRemoteCluster(String remoteCluster) {
    this.remoteCluster = remoteCluster;
    return (A) this;
  }
  
  public A withResourceGroupName(String resourceGroupName) {
    this.resourceGroupName = resourceGroupName;
    return (A) this;
  }
  
  public A withSecretName(String secretName) {
    this.secretName = secretName;
    return (A) this;
  }
  
  public A withSubscriptionID(String subscriptionID) {
    this.subscriptionID = subscriptionID;
    return (A) this;
  }
  
  public A withVmName(String vmName) {
    this.vmName = vmName;
    return (A) this;
  }
  
}