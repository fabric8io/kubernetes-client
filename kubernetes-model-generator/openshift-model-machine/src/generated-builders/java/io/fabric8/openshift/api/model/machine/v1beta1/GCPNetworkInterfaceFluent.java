package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class GCPNetworkInterfaceFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.GCPNetworkInterfaceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String network;
  private String projectID;
  private Boolean publicIP;
  private String subnetwork;

  public GCPNetworkInterfaceFluent() {
  }
  
  public GCPNetworkInterfaceFluent(GCPNetworkInterface instance) {
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
  
  protected void copyInstance(GCPNetworkInterface instance) {
    instance = instance != null ? instance : new GCPNetworkInterface();
    if (instance != null) {
        this.withNetwork(instance.getNetwork());
        this.withProjectID(instance.getProjectID());
        this.withPublicIP(instance.getPublicIP());
        this.withSubnetwork(instance.getSubnetwork());
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
    GCPNetworkInterfaceFluent that = (GCPNetworkInterfaceFluent) o;
    if (!(Objects.equals(network, that.network))) {
      return false;
    }
    if (!(Objects.equals(projectID, that.projectID))) {
      return false;
    }
    if (!(Objects.equals(publicIP, that.publicIP))) {
      return false;
    }
    if (!(Objects.equals(subnetwork, that.subnetwork))) {
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
  
  public String getNetwork() {
    return this.network;
  }
  
  public String getProjectID() {
    return this.projectID;
  }
  
  public Boolean getPublicIP() {
    return this.publicIP;
  }
  
  public String getSubnetwork() {
    return this.subnetwork;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasNetwork() {
    return this.network != null;
  }
  
  public boolean hasProjectID() {
    return this.projectID != null;
  }
  
  public boolean hasPublicIP() {
    return this.publicIP != null;
  }
  
  public boolean hasSubnetwork() {
    return this.subnetwork != null;
  }
  
  public int hashCode() {
    return Objects.hash(network, projectID, publicIP, subnetwork, additionalProperties);
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
    if (!(network == null)) {
        sb.append("network:");
        sb.append(network);
        sb.append(",");
    }
    if (!(projectID == null)) {
        sb.append("projectID:");
        sb.append(projectID);
        sb.append(",");
    }
    if (!(publicIP == null)) {
        sb.append("publicIP:");
        sb.append(publicIP);
        sb.append(",");
    }
    if (!(subnetwork == null)) {
        sb.append("subnetwork:");
        sb.append(subnetwork);
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
  
  public A withNetwork(String network) {
    this.network = network;
    return (A) this;
  }
  
  public A withProjectID(String projectID) {
    this.projectID = projectID;
    return (A) this;
  }
  
  public A withPublicIP() {
    return withPublicIP(true);
  }
  
  public A withPublicIP(Boolean publicIP) {
    this.publicIP = publicIP;
    return (A) this;
  }
  
  public A withSubnetwork(String subnetwork) {
    this.subnetwork = subnetwork;
    return (A) this;
  }
  
}