package io.fabric8.openshift.api.model.installer.vsphere.v1;

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
public class NetworkDeviceSpecFluent<A extends io.fabric8.openshift.api.model.installer.vsphere.v1.NetworkDeviceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String gateway;
  private List<String> ipAddrs = new ArrayList<String>();
  private List<String> nameservers = new ArrayList<String>();

  public NetworkDeviceSpecFluent() {
  }
  
  public NetworkDeviceSpecFluent(NetworkDeviceSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToIpAddrs(Collection<String> items) {
    if (this.ipAddrs == null) {
      this.ipAddrs = new ArrayList();
    }
    for (String item : items) {
      this.ipAddrs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNameservers(Collection<String> items) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    for (String item : items) {
      this.nameservers.add(item);
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
  
  public A addToIpAddrs(String... items) {
    if (this.ipAddrs == null) {
      this.ipAddrs = new ArrayList();
    }
    for (String item : items) {
      this.ipAddrs.add(item);
    }
    return (A) this;
  }
  
  public A addToIpAddrs(int index,String item) {
    if (this.ipAddrs == null) {
      this.ipAddrs = new ArrayList();
    }
    this.ipAddrs.add(index, item);
    return (A) this;
  }
  
  public A addToNameservers(String... items) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    for (String item : items) {
      this.nameservers.add(item);
    }
    return (A) this;
  }
  
  public A addToNameservers(int index,String item) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    this.nameservers.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(NetworkDeviceSpec instance) {
    instance = instance != null ? instance : new NetworkDeviceSpec();
    if (instance != null) {
        this.withGateway(instance.getGateway());
        this.withIpAddrs(instance.getIpAddrs());
        this.withNameservers(instance.getNameservers());
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
    NetworkDeviceSpecFluent that = (NetworkDeviceSpecFluent) o;
    if (!(Objects.equals(gateway, that.gateway))) {
      return false;
    }
    if (!(Objects.equals(ipAddrs, that.ipAddrs))) {
      return false;
    }
    if (!(Objects.equals(nameservers, that.nameservers))) {
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
  
  public String getFirstIpAddr() {
    return this.ipAddrs.get(0);
  }
  
  public String getFirstNameserver() {
    return this.nameservers.get(0);
  }
  
  public String getGateway() {
    return this.gateway;
  }
  
  public String getIpAddr(int index) {
    return this.ipAddrs.get(index);
  }
  
  public List<String> getIpAddrs() {
    return this.ipAddrs;
  }
  
  public String getLastIpAddr() {
    return this.ipAddrs.get(ipAddrs.size() - 1);
  }
  
  public String getLastNameserver() {
    return this.nameservers.get(nameservers.size() - 1);
  }
  
  public String getMatchingIpAddr(Predicate<String> predicate) {
      for (String item : ipAddrs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNameserver(Predicate<String> predicate) {
      for (String item : nameservers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNameserver(int index) {
    return this.nameservers.get(index);
  }
  
  public List<String> getNameservers() {
    return this.nameservers;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGateway() {
    return this.gateway != null;
  }
  
  public boolean hasIpAddrs() {
    return this.ipAddrs != null && !(this.ipAddrs.isEmpty());
  }
  
  public boolean hasMatchingIpAddr(Predicate<String> predicate) {
      for (String item : ipAddrs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNameserver(Predicate<String> predicate) {
      for (String item : nameservers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNameservers() {
    return this.nameservers != null && !(this.nameservers.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(gateway, ipAddrs, nameservers, additionalProperties);
  }
  
  public A removeAllFromIpAddrs(Collection<String> items) {
    if (this.ipAddrs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ipAddrs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNameservers(Collection<String> items) {
    if (this.nameservers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nameservers.remove(item);
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
  
  public A removeFromIpAddrs(String... items) {
    if (this.ipAddrs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ipAddrs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNameservers(String... items) {
    if (this.nameservers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nameservers.remove(item);
    }
    return (A) this;
  }
  
  public A setToIpAddrs(int index,String item) {
    if (this.ipAddrs == null) {
      this.ipAddrs = new ArrayList();
    }
    this.ipAddrs.set(index, item);
    return (A) this;
  }
  
  public A setToNameservers(int index,String item) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    this.nameservers.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(gateway == null)) {
        sb.append("gateway:");
        sb.append(gateway);
        sb.append(",");
    }
    if (!(ipAddrs == null) && !(ipAddrs.isEmpty())) {
        sb.append("ipAddrs:");
        sb.append(ipAddrs);
        sb.append(",");
    }
    if (!(nameservers == null) && !(nameservers.isEmpty())) {
        sb.append("nameservers:");
        sb.append(nameservers);
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
  
  public A withGateway(String gateway) {
    this.gateway = gateway;
    return (A) this;
  }
  
  public A withIpAddrs(List<String> ipAddrs) {
    if (ipAddrs != null) {
        this.ipAddrs = new ArrayList();
        for (String item : ipAddrs) {
          this.addToIpAddrs(item);
        }
    } else {
      this.ipAddrs = null;
    }
    return (A) this;
  }
  
  public A withIpAddrs(String... ipAddrs) {
    if (this.ipAddrs != null) {
        this.ipAddrs.clear();
        _visitables.remove("ipAddrs");
    }
    if (ipAddrs != null) {
      for (String item : ipAddrs) {
        this.addToIpAddrs(item);
      }
    }
    return (A) this;
  }
  
  public A withNameservers(List<String> nameservers) {
    if (nameservers != null) {
        this.nameservers = new ArrayList();
        for (String item : nameservers) {
          this.addToNameservers(item);
        }
    } else {
      this.nameservers = null;
    }
    return (A) this;
  }
  
  public A withNameservers(String... nameservers) {
    if (this.nameservers != null) {
        this.nameservers.clear();
        _visitables.remove("nameservers");
    }
    if (nameservers != null) {
      for (String item : nameservers) {
        this.addToNameservers(item);
      }
    }
    return (A) this;
  }
  
}