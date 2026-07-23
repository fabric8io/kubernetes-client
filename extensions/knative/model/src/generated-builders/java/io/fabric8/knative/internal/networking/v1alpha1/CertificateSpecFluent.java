package io.fabric8.knative.internal.networking.v1alpha1;

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
public class CertificateSpecFluent<A extends io.fabric8.knative.internal.networking.v1alpha1.CertificateSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> dnsNames = new ArrayList<String>();
  private String domain;
  private String secretName;

  public CertificateSpecFluent() {
  }
  
  public CertificateSpecFluent(CertificateSpec instance) {
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
  
  protected void copyInstance(CertificateSpec instance) {
    instance = instance != null ? instance : new CertificateSpec();
    if (instance != null) {
        this.withDnsNames(instance.getDnsNames());
        this.withDomain(instance.getDomain());
        this.withSecretName(instance.getSecretName());
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
    CertificateSpecFluent that = (CertificateSpecFluent) o;
    if (!(Objects.equals(dnsNames, that.dnsNames))) {
      return false;
    }
    if (!(Objects.equals(domain, that.domain))) {
      return false;
    }
    if (!(Objects.equals(secretName, that.secretName))) {
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
  
  public String getDomain() {
    return this.domain;
  }
  
  public String getFirstDnsName() {
    return this.dnsNames.get(0);
  }
  
  public String getLastDnsName() {
    return this.dnsNames.get(dnsNames.size() - 1);
  }
  
  public String getMatchingDnsName(Predicate<String> predicate) {
      for (String item : dnsNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getSecretName() {
    return this.secretName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDnsNames() {
    return this.dnsNames != null && !(this.dnsNames.isEmpty());
  }
  
  public boolean hasDomain() {
    return this.domain != null;
  }
  
  public boolean hasMatchingDnsName(Predicate<String> predicate) {
      for (String item : dnsNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSecretName() {
    return this.secretName != null;
  }
  
  public int hashCode() {
    return Objects.hash(dnsNames, domain, secretName, additionalProperties);
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
  
  public A setToDnsNames(int index,String item) {
    if (this.dnsNames == null) {
      this.dnsNames = new ArrayList();
    }
    this.dnsNames.set(index, item);
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
    if (!(domain == null)) {
        sb.append("domain:");
        sb.append(domain);
        sb.append(",");
    }
    if (!(secretName == null)) {
        sb.append("secretName:");
        sb.append(secretName);
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
  
  public A withDomain(String domain) {
    this.domain = domain;
    return (A) this;
  }
  
  public A withSecretName(String secretName) {
    this.secretName = secretName;
    return (A) this;
  }
  
}