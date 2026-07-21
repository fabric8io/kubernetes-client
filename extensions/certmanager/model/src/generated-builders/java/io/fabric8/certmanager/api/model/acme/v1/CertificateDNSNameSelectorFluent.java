package io.fabric8.certmanager.api.model.acme.v1;

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
public class CertificateDNSNameSelectorFluent<A extends io.fabric8.certmanager.api.model.acme.v1.CertificateDNSNameSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> dnsNames = new ArrayList<String>();
  private List<String> dnsZones = new ArrayList<String>();
  private Map<String,String> matchLabels;

  public CertificateDNSNameSelectorFluent() {
  }
  
  public CertificateDNSNameSelectorFluent(CertificateDNSNameSelector instance) {
    this.copyInstance(instance);
  }

  public A addAllToDnsNames(Collection<String> items) {
    if (this.dnsNames == null) {
      this.dnsNames = new ArrayList();
    }
    for (String item : items) {
      this.dnsNames.add(item);
    }
    return (A) this;
  }
  
  public A addAllToDnsZones(Collection<String> items) {
    if (this.dnsZones == null) {
      this.dnsZones = new ArrayList();
    }
    for (String item : items) {
      this.dnsZones.add(item);
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
  
  public A addToDnsNames(String... items) {
    if (this.dnsNames == null) {
      this.dnsNames = new ArrayList();
    }
    for (String item : items) {
      this.dnsNames.add(item);
    }
    return (A) this;
  }
  
  public A addToDnsNames(int index,String item) {
    if (this.dnsNames == null) {
      this.dnsNames = new ArrayList();
    }
    this.dnsNames.add(index, item);
    return (A) this;
  }
  
  public A addToDnsZones(String... items) {
    if (this.dnsZones == null) {
      this.dnsZones = new ArrayList();
    }
    for (String item : items) {
      this.dnsZones.add(item);
    }
    return (A) this;
  }
  
  public A addToDnsZones(int index,String item) {
    if (this.dnsZones == null) {
      this.dnsZones = new ArrayList();
    }
    this.dnsZones.add(index, item);
    return (A) this;
  }
  
  public A addToMatchLabels(Map<String,String> map) {
    if (this.matchLabels == null && map != null) {
      this.matchLabels = new LinkedHashMap();
    }
    if (map != null) {
      this.matchLabels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToMatchLabels(String key,String value) {
    if (this.matchLabels == null && key != null && value != null) {
      this.matchLabels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.matchLabels.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(CertificateDNSNameSelector instance) {
    instance = instance != null ? instance : new CertificateDNSNameSelector();
    if (instance != null) {
        this.withDnsNames(instance.getDnsNames());
        this.withDnsZones(instance.getDnsZones());
        this.withMatchLabels(instance.getMatchLabels());
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
    CertificateDNSNameSelectorFluent that = (CertificateDNSNameSelectorFluent) o;
    if (!(Objects.equals(dnsNames, that.dnsNames))) {
      return false;
    }
    if (!(Objects.equals(dnsZones, that.dnsZones))) {
      return false;
    }
    if (!(Objects.equals(matchLabels, that.matchLabels))) {
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
  
  public String getDnsName(int index) {
    return this.dnsNames.get(index);
  }
  
  public List<String> getDnsNames() {
    return this.dnsNames;
  }
  
  public String getDnsZone(int index) {
    return this.dnsZones.get(index);
  }
  
  public List<String> getDnsZones() {
    return this.dnsZones;
  }
  
  public String getFirstDnsName() {
    return this.dnsNames.get(0);
  }
  
  public String getFirstDnsZone() {
    return this.dnsZones.get(0);
  }
  
  public String getLastDnsName() {
    return this.dnsNames.get(dnsNames.size() - 1);
  }
  
  public String getLastDnsZone() {
    return this.dnsZones.get(dnsZones.size() - 1);
  }
  
  public Map<String,String> getMatchLabels() {
    return this.matchLabels;
  }
  
  public String getMatchingDnsName(Predicate<String> predicate) {
      for (String item : dnsNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingDnsZone(Predicate<String> predicate) {
      for (String item : dnsZones) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDnsNames() {
    return this.dnsNames != null && !(this.dnsNames.isEmpty());
  }
  
  public boolean hasDnsZones() {
    return this.dnsZones != null && !(this.dnsZones.isEmpty());
  }
  
  public boolean hasMatchLabels() {
    return this.matchLabels != null;
  }
  
  public boolean hasMatchingDnsName(Predicate<String> predicate) {
      for (String item : dnsNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDnsZone(Predicate<String> predicate) {
      for (String item : dnsZones) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(dnsNames, dnsZones, matchLabels, additionalProperties);
  }
  
  public A removeAllFromDnsNames(Collection<String> items) {
    if (this.dnsNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dnsNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromDnsZones(Collection<String> items) {
    if (this.dnsZones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dnsZones.remove(item);
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
  
  public A removeFromDnsNames(String... items) {
    if (this.dnsNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dnsNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromDnsZones(String... items) {
    if (this.dnsZones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dnsZones.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromMatchLabels(String key) {
    if (this.matchLabels == null) {
      return (A) this;
    }
    if (key != null && this.matchLabels != null) {
      this.matchLabels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromMatchLabels(Map<String,String> map) {
    if (this.matchLabels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.matchLabels != null) {
          this.matchLabels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToDnsNames(int index,String item) {
    if (this.dnsNames == null) {
      this.dnsNames = new ArrayList();
    }
    this.dnsNames.set(index, item);
    return (A) this;
  }
  
  public A setToDnsZones(int index,String item) {
    if (this.dnsZones == null) {
      this.dnsZones = new ArrayList();
    }
    this.dnsZones.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(dnsNames == null) && !(dnsNames.isEmpty())) {
        sb.append("dnsNames:");
        sb.append(dnsNames);
        sb.append(",");
    }
    if (!(dnsZones == null) && !(dnsZones.isEmpty())) {
        sb.append("dnsZones:");
        sb.append(dnsZones);
        sb.append(",");
    }
    if (!(matchLabels == null) && !(matchLabels.isEmpty())) {
        sb.append("matchLabels:");
        sb.append(matchLabels);
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
  
  public A withDnsNames(List<String> dnsNames) {
    if (dnsNames != null) {
        this.dnsNames = new ArrayList();
        for (String item : dnsNames) {
          this.addToDnsNames(item);
        }
    } else {
      this.dnsNames = null;
    }
    return (A) this;
  }
  
  public A withDnsNames(String... dnsNames) {
    if (this.dnsNames != null) {
        this.dnsNames.clear();
        _visitables.remove("dnsNames");
    }
    if (dnsNames != null) {
      for (String item : dnsNames) {
        this.addToDnsNames(item);
      }
    }
    return (A) this;
  }
  
  public A withDnsZones(List<String> dnsZones) {
    if (dnsZones != null) {
        this.dnsZones = new ArrayList();
        for (String item : dnsZones) {
          this.addToDnsZones(item);
        }
    } else {
      this.dnsZones = null;
    }
    return (A) this;
  }
  
  public A withDnsZones(String... dnsZones) {
    if (this.dnsZones != null) {
        this.dnsZones.clear();
        _visitables.remove("dnsZones");
    }
    if (dnsZones != null) {
      for (String item : dnsZones) {
        this.addToDnsZones(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withMatchLabels(Map<String,String> matchLabels) {
    if (matchLabels == null) {
      this.matchLabels = null;
    } else {
      this.matchLabels = new LinkedHashMap(matchLabels);
    }
    return (A) this;
  }
  
}