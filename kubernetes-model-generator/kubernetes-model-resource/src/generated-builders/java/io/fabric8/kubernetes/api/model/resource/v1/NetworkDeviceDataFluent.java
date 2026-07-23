package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NetworkDeviceDataFluent<A extends io.fabric8.kubernetes.api.model.resource.v1.NetworkDeviceDataFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String hardwareAddress;
  private String interfaceName;
  private List<String> ips = new ArrayList<String>();

  public NetworkDeviceDataFluent() {
  }
  
  public NetworkDeviceDataFluent(NetworkDeviceData instance) {
    this.copyInstance(instance);
  }

  public A addAllToIps(Collection<String> items) {
    if (this.ips == null) {
      this.ips = new ArrayList();
    }
    for (String item : items) {
      this.ips.add(item);
    }
    return (A) this;
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
  
  public A addToIps(String... items) {
    if (this.ips == null) {
      this.ips = new ArrayList();
    }
    for (String item : items) {
      this.ips.add(item);
    }
    return (A) this;
  }
  
  public A addToIps(int index,String item) {
    if (this.ips == null) {
      this.ips = new ArrayList();
    }
    this.ips.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(NetworkDeviceData instance) {
    instance = instance != null ? instance : new NetworkDeviceData();
    if (instance != null) {
        this.withHardwareAddress(instance.getHardwareAddress());
        this.withInterfaceName(instance.getInterfaceName());
        this.withIps(instance.getIps());
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
    NetworkDeviceDataFluent that = (NetworkDeviceDataFluent) o;
    if (!(Objects.equals(hardwareAddress, that.hardwareAddress))) {
      return false;
    }
    if (!(Objects.equals(interfaceName, that.interfaceName))) {
      return false;
    }
    if (!(Objects.equals(ips, that.ips))) {
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
  
  public String getFirstIp() {
    return this.ips.get(0);
  }
  
  public String getHardwareAddress() {
    return this.hardwareAddress;
  }
  
  public String getInterfaceName() {
    return this.interfaceName;
  }
  
  public String getIp(int index) {
    return this.ips.get(index);
  }
  
  public List<String> getIps() {
    return this.ips;
  }
  
  public String getLastIp() {
    return this.ips.get(ips.size() - 1);
  }
  
  public String getMatchingIp(Predicate<String> predicate) {
      for (String item : ips) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHardwareAddress() {
    return this.hardwareAddress != null;
  }
  
  public boolean hasInterfaceName() {
    return this.interfaceName != null;
  }
  
  public boolean hasIps() {
    return this.ips != null && !(this.ips.isEmpty());
  }
  
  public boolean hasMatchingIp(Predicate<String> predicate) {
      for (String item : ips) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(hardwareAddress, interfaceName, ips, additionalProperties);
  }
  
  public A removeAllFromIps(Collection<String> items) {
    if (this.ips == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ips.remove(item);
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
  
  public A removeFromIps(String... items) {
    if (this.ips == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ips.remove(item);
    }
    return (A) this;
  }
  
  public A setToIps(int index,String item) {
    if (this.ips == null) {
      this.ips = new ArrayList();
    }
    this.ips.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(hardwareAddress == null)) {
        sb.append("hardwareAddress:");
        sb.append(hardwareAddress);
        sb.append(",");
    }
    if (!(interfaceName == null)) {
        sb.append("interfaceName:");
        sb.append(interfaceName);
        sb.append(",");
    }
    if (!(ips == null) && !(ips.isEmpty())) {
        sb.append("ips:");
        sb.append(ips);
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
  
  public A withHardwareAddress(String hardwareAddress) {
    this.hardwareAddress = hardwareAddress;
    return (A) this;
  }
  
  public A withInterfaceName(String interfaceName) {
    this.interfaceName = interfaceName;
    return (A) this;
  }
  
  public A withIps(List<String> ips) {
    if (ips != null) {
        this.ips = new ArrayList();
        for (String item : ips) {
          this.addToIps(item);
        }
    } else {
      this.ips = null;
    }
    return (A) this;
  }
  
  public A withIps(String... ips) {
    if (this.ips != null) {
        this.ips.clear();
        _visitables.remove("ips");
    }
    if (ips != null) {
      for (String item : ips) {
        this.addToIps(item);
      }
    }
    return (A) this;
  }
  
}