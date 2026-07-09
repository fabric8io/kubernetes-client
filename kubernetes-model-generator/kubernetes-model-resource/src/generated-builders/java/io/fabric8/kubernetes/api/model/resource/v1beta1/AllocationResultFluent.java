package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.NodeSelector;
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
public class AllocationResultFluent<A extends io.fabric8.kubernetes.api.model.resource.v1beta1.AllocationResultFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String allocationTimestamp;
  private DeviceAllocationResultBuilder devices;
  private NodeSelector nodeSelector;

  public AllocationResultFluent() {
  }
  
  public AllocationResultFluent(AllocationResult instance) {
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
  
  public DeviceAllocationResult buildDevices() {
    return this.devices != null ? this.devices.build() : null;
  }
  
  protected void copyInstance(AllocationResult instance) {
    instance = instance != null ? instance : new AllocationResult();
    if (instance != null) {
        this.withAllocationTimestamp(instance.getAllocationTimestamp());
        this.withDevices(instance.getDevices());
        this.withNodeSelector(instance.getNodeSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DevicesNested<A> editDevices() {
    return this.withNewDevicesLike(Optional.ofNullable(this.buildDevices()).orElse(null));
  }
  
  public DevicesNested<A> editOrNewDevices() {
    return this.withNewDevicesLike(Optional.ofNullable(this.buildDevices()).orElse(new DeviceAllocationResultBuilder().build()));
  }
  
  public DevicesNested<A> editOrNewDevicesLike(DeviceAllocationResult item) {
    return this.withNewDevicesLike(Optional.ofNullable(this.buildDevices()).orElse(item));
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
    AllocationResultFluent that = (AllocationResultFluent) o;
    if (!(Objects.equals(allocationTimestamp, that.allocationTimestamp))) {
      return false;
    }
    if (!(Objects.equals(devices, that.devices))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
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
  
  public String getAllocationTimestamp() {
    return this.allocationTimestamp;
  }
  
  public NodeSelector getNodeSelector() {
    return this.nodeSelector;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllocationTimestamp() {
    return this.allocationTimestamp != null;
  }
  
  public boolean hasDevices() {
    return this.devices != null;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(allocationTimestamp, devices, nodeSelector, additionalProperties);
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
    if (!(allocationTimestamp == null)) {
        sb.append("allocationTimestamp:");
        sb.append(allocationTimestamp);
        sb.append(",");
    }
    if (!(devices == null)) {
        sb.append("devices:");
        sb.append(devices);
        sb.append(",");
    }
    if (!(nodeSelector == null)) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
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
  
  public A withAllocationTimestamp(String allocationTimestamp) {
    this.allocationTimestamp = allocationTimestamp;
    return (A) this;
  }
  
  public A withDevices(DeviceAllocationResult devices) {
    this._visitables.remove("devices");
    if (devices != null) {
        this.devices = new DeviceAllocationResultBuilder(devices);
        this._visitables.get("devices").add(this.devices);
    } else {
        this.devices = null;
        this._visitables.get("devices").remove(this.devices);
    }
    return (A) this;
  }
  
  public DevicesNested<A> withNewDevices() {
    return new DevicesNested(null);
  }
  
  public DevicesNested<A> withNewDevicesLike(DeviceAllocationResult item) {
    return new DevicesNested(item);
  }
  
  public A withNodeSelector(NodeSelector nodeSelector) {
    this.nodeSelector = nodeSelector;
    return (A) this;
  }
  public class DevicesNested<N> extends DeviceAllocationResultFluent<DevicesNested<N>> implements Nested<N>{
  
    DeviceAllocationResultBuilder builder;
  
    DevicesNested(DeviceAllocationResult item) {
      this.builder = new DeviceAllocationResultBuilder(this, item);
    }
  
    public N and() {
      return (N) AllocationResultFluent.this.withDevices(builder.build());
    }
    
    public N endDevices() {
      return and();
    }
    
  }
}