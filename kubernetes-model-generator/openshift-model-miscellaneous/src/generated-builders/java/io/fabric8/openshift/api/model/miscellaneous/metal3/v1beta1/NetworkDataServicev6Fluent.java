package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
public class NetworkDataServicev6Fluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.NetworkDataServicev6Fluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> dns = new ArrayList<String>();
  private String dnsFromIPPool;

  public NetworkDataServicev6Fluent() {
  }
  
  public NetworkDataServicev6Fluent(NetworkDataServicev6 instance) {
    this.copyInstance(instance);
  }

  public A addAllToDns(Collection<String> items) {
    if (this.dns == null) {
      this.dns = new ArrayList();
    }
    for (String item : items) {
      this.dns.add(item);
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
  
  public A addToDns(String... items) {
    if (this.dns == null) {
      this.dns = new ArrayList();
    }
    for (String item : items) {
      this.dns.add(item);
    }
    return (A) this;
  }
  
  public A addToDns(int index,String item) {
    if (this.dns == null) {
      this.dns = new ArrayList();
    }
    this.dns.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(NetworkDataServicev6 instance) {
    instance = instance != null ? instance : new NetworkDataServicev6();
    if (instance != null) {
        this.withDns(instance.getDns());
        this.withDnsFromIPPool(instance.getDnsFromIPPool());
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
    NetworkDataServicev6Fluent that = (NetworkDataServicev6Fluent) o;
    if (!(Objects.equals(dns, that.dns))) {
      return false;
    }
    if (!(Objects.equals(dnsFromIPPool, that.dnsFromIPPool))) {
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
  
  public String getDn(int index) {
    return this.dns.get(index);
  }
  
  public List<String> getDns() {
    return this.dns;
  }
  
  public String getDnsFromIPPool() {
    return this.dnsFromIPPool;
  }
  
  public String getFirstDn() {
    return this.dns.get(0);
  }
  
  public String getLastDn() {
    return this.dns.get(dns.size() - 1);
  }
  
  public String getMatchingDn(Predicate<String> predicate) {
      for (String item : dns) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDns() {
    return this.dns != null && !(this.dns.isEmpty());
  }
  
  public boolean hasDnsFromIPPool() {
    return this.dnsFromIPPool != null;
  }
  
  public boolean hasMatchingDn(Predicate<String> predicate) {
      for (String item : dns) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(dns, dnsFromIPPool, additionalProperties);
  }
  
  public A removeAllFromDns(Collection<String> items) {
    if (this.dns == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dns.remove(item);
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
  
  public A removeFromDns(String... items) {
    if (this.dns == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dns.remove(item);
    }
    return (A) this;
  }
  
  public A setToDns(int index,String item) {
    if (this.dns == null) {
      this.dns = new ArrayList();
    }
    this.dns.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(dns == null) && !(dns.isEmpty())) {
        sb.append("dns:");
        sb.append(dns);
        sb.append(",");
    }
    if (!(dnsFromIPPool == null)) {
        sb.append("dnsFromIPPool:");
        sb.append(dnsFromIPPool);
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
  
  public A withDns(List<String> dns) {
    if (dns != null) {
        this.dns = new ArrayList();
        for (String item : dns) {
          this.addToDns(item);
        }
    } else {
      this.dns = null;
    }
    return (A) this;
  }
  
  public A withDns(String... dns) {
    if (this.dns != null) {
        this.dns.clear();
        _visitables.remove("dns");
    }
    if (dns != null) {
      for (String item : dns) {
        this.addToDns(item);
      }
    }
    return (A) this;
  }
  
  public A withDnsFromIPPool(String dnsFromIPPool) {
    this.dnsFromIPPool = dnsFromIPPool;
    return (A) this;
  }
  
}