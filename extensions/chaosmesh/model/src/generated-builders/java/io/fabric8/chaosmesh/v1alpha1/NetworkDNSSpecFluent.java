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
public class NetworkDNSSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.NetworkDNSSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String dnsDomainName;
  private String dnsIp;
  private String dnsServer;

  public NetworkDNSSpecFluent() {
  }
  
  public NetworkDNSSpecFluent(NetworkDNSSpec instance) {
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
  
  protected void copyInstance(NetworkDNSSpec instance) {
    instance = instance != null ? instance : new NetworkDNSSpec();
    if (instance != null) {
        this.withDnsDomainName(instance.getDnsDomainName());
        this.withDnsIp(instance.getDnsIp());
        this.withDnsServer(instance.getDnsServer());
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
    NetworkDNSSpecFluent that = (NetworkDNSSpecFluent) o;
    if (!(Objects.equals(dnsDomainName, that.dnsDomainName))) {
      return false;
    }
    if (!(Objects.equals(dnsIp, that.dnsIp))) {
      return false;
    }
    if (!(Objects.equals(dnsServer, that.dnsServer))) {
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
  
  public String getDnsDomainName() {
    return this.dnsDomainName;
  }
  
  public String getDnsIp() {
    return this.dnsIp;
  }
  
  public String getDnsServer() {
    return this.dnsServer;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDnsDomainName() {
    return this.dnsDomainName != null;
  }
  
  public boolean hasDnsIp() {
    return this.dnsIp != null;
  }
  
  public boolean hasDnsServer() {
    return this.dnsServer != null;
  }
  
  public int hashCode() {
    return Objects.hash(dnsDomainName, dnsIp, dnsServer, additionalProperties);
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
    if (!(dnsDomainName == null)) {
        sb.append("dnsDomainName:");
        sb.append(dnsDomainName);
        sb.append(",");
    }
    if (!(dnsIp == null)) {
        sb.append("dnsIp:");
        sb.append(dnsIp);
        sb.append(",");
    }
    if (!(dnsServer == null)) {
        sb.append("dnsServer:");
        sb.append(dnsServer);
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
  
  public A withDnsDomainName(String dnsDomainName) {
    this.dnsDomainName = dnsDomainName;
    return (A) this;
  }
  
  public A withDnsIp(String dnsIp) {
    this.dnsIp = dnsIp;
    return (A) this;
  }
  
  public A withDnsServer(String dnsServer) {
    this.dnsServer = dnsServer;
    return (A) this;
  }
  
}