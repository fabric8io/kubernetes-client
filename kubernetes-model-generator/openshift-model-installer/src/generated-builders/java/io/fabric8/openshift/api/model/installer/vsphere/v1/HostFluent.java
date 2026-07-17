package io.fabric8.openshift.api.model.installer.vsphere.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HostFluent<A extends io.fabric8.openshift.api.model.installer.vsphere.v1.HostFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String failureDomain;
  private NetworkDeviceSpecBuilder networkDevice;
  private String role;

  public HostFluent() {
  }
  
  public HostFluent(Host instance) {
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
  
  public NetworkDeviceSpec buildNetworkDevice() {
    return this.networkDevice != null ? this.networkDevice.build() : null;
  }
  
  protected void copyInstance(Host instance) {
    instance = instance != null ? instance : new Host();
    if (instance != null) {
        this.withFailureDomain(instance.getFailureDomain());
        this.withNetworkDevice(instance.getNetworkDevice());
        this.withRole(instance.getRole());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NetworkDeviceNested<A> editNetworkDevice() {
    return this.withNewNetworkDeviceLike(Optional.ofNullable(this.buildNetworkDevice()).orElse(null));
  }
  
  public NetworkDeviceNested<A> editOrNewNetworkDevice() {
    return this.withNewNetworkDeviceLike(Optional.ofNullable(this.buildNetworkDevice()).orElse(new NetworkDeviceSpecBuilder().build()));
  }
  
  public NetworkDeviceNested<A> editOrNewNetworkDeviceLike(NetworkDeviceSpec item) {
    return this.withNewNetworkDeviceLike(Optional.ofNullable(this.buildNetworkDevice()).orElse(item));
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
    HostFluent that = (HostFluent) o;
    if (!(Objects.equals(failureDomain, that.failureDomain))) {
      return false;
    }
    if (!(Objects.equals(networkDevice, that.networkDevice))) {
      return false;
    }
    if (!(Objects.equals(role, that.role))) {
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
  
  public String getFailureDomain() {
    return this.failureDomain;
  }
  
  public String getRole() {
    return this.role;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFailureDomain() {
    return this.failureDomain != null;
  }
  
  public boolean hasNetworkDevice() {
    return this.networkDevice != null;
  }
  
  public boolean hasRole() {
    return this.role != null;
  }
  
  public int hashCode() {
    return Objects.hash(failureDomain, networkDevice, role, additionalProperties);
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
    if (!(failureDomain == null)) {
        sb.append("failureDomain:");
        sb.append(failureDomain);
        sb.append(",");
    }
    if (!(networkDevice == null)) {
        sb.append("networkDevice:");
        sb.append(networkDevice);
        sb.append(",");
    }
    if (!(role == null)) {
        sb.append("role:");
        sb.append(role);
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
  
  public A withFailureDomain(String failureDomain) {
    this.failureDomain = failureDomain;
    return (A) this;
  }
  
  public A withNetworkDevice(NetworkDeviceSpec networkDevice) {
    this._visitables.remove("networkDevice");
    if (networkDevice != null) {
        this.networkDevice = new NetworkDeviceSpecBuilder(networkDevice);
        this._visitables.get("networkDevice").add(this.networkDevice);
    } else {
        this.networkDevice = null;
        this._visitables.get("networkDevice").remove(this.networkDevice);
    }
    return (A) this;
  }
  
  public NetworkDeviceNested<A> withNewNetworkDevice() {
    return new NetworkDeviceNested(null);
  }
  
  public NetworkDeviceNested<A> withNewNetworkDeviceLike(NetworkDeviceSpec item) {
    return new NetworkDeviceNested(item);
  }
  
  public A withRole(String role) {
    this.role = role;
    return (A) this;
  }
  public class NetworkDeviceNested<N> extends NetworkDeviceSpecFluent<NetworkDeviceNested<N>> implements Nested<N>{
  
    NetworkDeviceSpecBuilder builder;
  
    NetworkDeviceNested(NetworkDeviceSpec item) {
      this.builder = new NetworkDeviceSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) HostFluent.this.withNetworkDevice(builder.build());
    }
    
    public N endNetworkDevice() {
      return and();
    }
    
  }
}