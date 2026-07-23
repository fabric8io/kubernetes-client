package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NetworkSpecFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.NetworkSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NetworkDeviceSpecBuilder> devices = new ArrayList<NetworkDeviceSpecBuilder>();

  public NetworkSpecFluent() {
  }
  
  public NetworkSpecFluent(NetworkSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToDevices(Collection<NetworkDeviceSpec> items) {
    if (this.devices == null) {
      this.devices = new ArrayList();
    }
    for (NetworkDeviceSpec item : items) {
        NetworkDeviceSpecBuilder builder = new NetworkDeviceSpecBuilder(item);
        _visitables.get("devices").add(builder);
        this.devices.add(builder);
    }
    return (A) this;
  }
  
  public DevicesNested<A> addNewDevice() {
    return new DevicesNested(-1, null);
  }
  
  public DevicesNested<A> addNewDeviceLike(NetworkDeviceSpec item) {
    return new DevicesNested(-1, item);
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
  
  public A addToDevices(NetworkDeviceSpec... items) {
    if (this.devices == null) {
      this.devices = new ArrayList();
    }
    for (NetworkDeviceSpec item : items) {
        NetworkDeviceSpecBuilder builder = new NetworkDeviceSpecBuilder(item);
        _visitables.get("devices").add(builder);
        this.devices.add(builder);
    }
    return (A) this;
  }
  
  public A addToDevices(int index,NetworkDeviceSpec item) {
    if (this.devices == null) {
      this.devices = new ArrayList();
    }
    NetworkDeviceSpecBuilder builder = new NetworkDeviceSpecBuilder(item);
    if (index < 0 || index >= devices.size()) {
        _visitables.get("devices").add(builder);
        devices.add(builder);
    } else {
        _visitables.get("devices").add(builder);
        devices.add(index, builder);
    }
    return (A) this;
  }
  
  public NetworkDeviceSpec buildDevice(int index) {
    return this.devices.get(index).build();
  }
  
  public List<NetworkDeviceSpec> buildDevices() {
    return this.devices != null ? build(devices) : null;
  }
  
  public NetworkDeviceSpec buildFirstDevice() {
    return this.devices.get(0).build();
  }
  
  public NetworkDeviceSpec buildLastDevice() {
    return this.devices.get(devices.size() - 1).build();
  }
  
  public NetworkDeviceSpec buildMatchingDevice(Predicate<NetworkDeviceSpecBuilder> predicate) {
      for (NetworkDeviceSpecBuilder item : devices) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(NetworkSpec instance) {
    instance = instance != null ? instance : new NetworkSpec();
    if (instance != null) {
        this.withDevices(instance.getDevices());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DevicesNested<A> editDevice(int index) {
    if (devices.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "devices"));
    }
    return this.setNewDeviceLike(index, this.buildDevice(index));
  }
  
  public DevicesNested<A> editFirstDevice() {
    if (devices.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "devices"));
    }
    return this.setNewDeviceLike(0, this.buildDevice(0));
  }
  
  public DevicesNested<A> editLastDevice() {
    int index = devices.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "devices"));
    }
    return this.setNewDeviceLike(index, this.buildDevice(index));
  }
  
  public DevicesNested<A> editMatchingDevice(Predicate<NetworkDeviceSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < devices.size();i++) {
      if (predicate.test(devices.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "devices"));
    }
    return this.setNewDeviceLike(index, this.buildDevice(index));
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
    NetworkSpecFluent that = (NetworkSpecFluent) o;
    if (!(Objects.equals(devices, that.devices))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDevices() {
    return this.devices != null && !(this.devices.isEmpty());
  }
  
  public boolean hasMatchingDevice(Predicate<NetworkDeviceSpecBuilder> predicate) {
      for (NetworkDeviceSpecBuilder item : devices) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(devices, additionalProperties);
  }
  
  public A removeAllFromDevices(Collection<NetworkDeviceSpec> items) {
    if (this.devices == null) {
      return (A) this;
    }
    for (NetworkDeviceSpec item : items) {
        NetworkDeviceSpecBuilder builder = new NetworkDeviceSpecBuilder(item);
        _visitables.get("devices").remove(builder);
        this.devices.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromDevices(NetworkDeviceSpec... items) {
    if (this.devices == null) {
      return (A) this;
    }
    for (NetworkDeviceSpec item : items) {
        NetworkDeviceSpecBuilder builder = new NetworkDeviceSpecBuilder(item);
        _visitables.get("devices").remove(builder);
        this.devices.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDevices(Predicate<NetworkDeviceSpecBuilder> predicate) {
    if (devices == null) {
      return (A) this;
    }
    Iterator<NetworkDeviceSpecBuilder> each = devices.iterator();
    List visitables = _visitables.get("devices");
    while (each.hasNext()) {
        NetworkDeviceSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DevicesNested<A> setNewDeviceLike(int index,NetworkDeviceSpec item) {
    return new DevicesNested(index, item);
  }
  
  public A setToDevices(int index,NetworkDeviceSpec item) {
    if (this.devices == null) {
      this.devices = new ArrayList();
    }
    NetworkDeviceSpecBuilder builder = new NetworkDeviceSpecBuilder(item);
    if (index < 0 || index >= devices.size()) {
        _visitables.get("devices").add(builder);
        devices.add(builder);
    } else {
        _visitables.get("devices").add(builder);
        devices.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(devices == null) && !(devices.isEmpty())) {
        sb.append("devices:");
        sb.append(devices);
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
  
  public A withDevices(List<NetworkDeviceSpec> devices) {
    if (this.devices != null) {
      this._visitables.get("devices").clear();
    }
    if (devices != null) {
        this.devices = new ArrayList();
        for (NetworkDeviceSpec item : devices) {
          this.addToDevices(item);
        }
    } else {
      this.devices = null;
    }
    return (A) this;
  }
  
  public A withDevices(NetworkDeviceSpec... devices) {
    if (this.devices != null) {
        this.devices.clear();
        _visitables.remove("devices");
    }
    if (devices != null) {
      for (NetworkDeviceSpec item : devices) {
        this.addToDevices(item);
      }
    }
    return (A) this;
  }
  public class DevicesNested<N> extends NetworkDeviceSpecFluent<DevicesNested<N>> implements Nested<N>{
  
    NetworkDeviceSpecBuilder builder;
    int index;
  
    DevicesNested(int index,NetworkDeviceSpec item) {
      this.index = index;
      this.builder = new NetworkDeviceSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.setToDevices(index, builder.build());
    }
    
    public N endDevice() {
      return and();
    }
    
  }
}