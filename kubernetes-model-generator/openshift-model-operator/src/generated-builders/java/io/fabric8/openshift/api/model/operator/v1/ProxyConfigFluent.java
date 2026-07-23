package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ProxyConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.ProxyConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String bindAddress;
  private String iptablesSyncPeriod;
  private Map<String,List<String>> proxyArguments;

  public ProxyConfigFluent() {
  }
  
  public ProxyConfigFluent(ProxyConfig instance) {
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
  
  public A addToProxyArguments(Map<String,List<String>> map) {
    if (this.proxyArguments == null && map != null) {
      this.proxyArguments = new LinkedHashMap();
    }
    if (map != null) {
      this.proxyArguments.putAll(map);
    }
    return (A) this;
  }
  
  public A addToProxyArguments(String key,List<String> value) {
    if (this.proxyArguments == null && key != null && value != null) {
      this.proxyArguments = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.proxyArguments.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(ProxyConfig instance) {
    instance = instance != null ? instance : new ProxyConfig();
    if (instance != null) {
        this.withBindAddress(instance.getBindAddress());
        this.withIptablesSyncPeriod(instance.getIptablesSyncPeriod());
        this.withProxyArguments(instance.getProxyArguments());
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
    ProxyConfigFluent that = (ProxyConfigFluent) o;
    if (!(Objects.equals(bindAddress, that.bindAddress))) {
      return false;
    }
    if (!(Objects.equals(iptablesSyncPeriod, that.iptablesSyncPeriod))) {
      return false;
    }
    if (!(Objects.equals(proxyArguments, that.proxyArguments))) {
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
  
  public String getBindAddress() {
    return this.bindAddress;
  }
  
  public String getIptablesSyncPeriod() {
    return this.iptablesSyncPeriod;
  }
  
  public Map<String,List<String>> getProxyArguments() {
    return this.proxyArguments;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBindAddress() {
    return this.bindAddress != null;
  }
  
  public boolean hasIptablesSyncPeriod() {
    return this.iptablesSyncPeriod != null;
  }
  
  public boolean hasProxyArguments() {
    return this.proxyArguments != null;
  }
  
  public int hashCode() {
    return Objects.hash(bindAddress, iptablesSyncPeriod, proxyArguments, additionalProperties);
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
  
  public A removeFromProxyArguments(String key) {
    if (this.proxyArguments == null) {
      return (A) this;
    }
    if (key != null && this.proxyArguments != null) {
      this.proxyArguments.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromProxyArguments(Map<String,List<String>> map) {
    if (this.proxyArguments == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.proxyArguments != null) {
          this.proxyArguments.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(bindAddress == null)) {
        sb.append("bindAddress:");
        sb.append(bindAddress);
        sb.append(",");
    }
    if (!(iptablesSyncPeriod == null)) {
        sb.append("iptablesSyncPeriod:");
        sb.append(iptablesSyncPeriod);
        sb.append(",");
    }
    if (!(proxyArguments == null) && !(proxyArguments.isEmpty())) {
        sb.append("proxyArguments:");
        sb.append(proxyArguments);
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
  
  public A withBindAddress(String bindAddress) {
    this.bindAddress = bindAddress;
    return (A) this;
  }
  
  public A withIptablesSyncPeriod(String iptablesSyncPeriod) {
    this.iptablesSyncPeriod = iptablesSyncPeriod;
    return (A) this;
  }
  
  public <K,V>A withProxyArguments(Map<String,List<String>> proxyArguments) {
    if (proxyArguments == null) {
      this.proxyArguments = null;
    } else {
      this.proxyArguments = new LinkedHashMap(proxyArguments);
    }
    return (A) this;
  }
  
}