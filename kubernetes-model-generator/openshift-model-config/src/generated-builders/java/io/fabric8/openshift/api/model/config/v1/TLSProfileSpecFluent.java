package io.fabric8.openshift.api.model.config.v1;

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
public class TLSProfileSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.TLSProfileSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> ciphers = new ArrayList<String>();
  private String minTLSVersion;

  public TLSProfileSpecFluent() {
  }
  
  public TLSProfileSpecFluent(TLSProfileSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToCiphers(Collection<String> items) {
    if (this.ciphers == null) {
      this.ciphers = new ArrayList();
    }
    for (String item : items) {
      this.ciphers.add(item);
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
  
  public A addToCiphers(String... items) {
    if (this.ciphers == null) {
      this.ciphers = new ArrayList();
    }
    for (String item : items) {
      this.ciphers.add(item);
    }
    return (A) this;
  }
  
  public A addToCiphers(int index,String item) {
    if (this.ciphers == null) {
      this.ciphers = new ArrayList();
    }
    this.ciphers.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(TLSProfileSpec instance) {
    instance = instance != null ? instance : new TLSProfileSpec();
    if (instance != null) {
        this.withCiphers(instance.getCiphers());
        this.withMinTLSVersion(instance.getMinTLSVersion());
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
    TLSProfileSpecFluent that = (TLSProfileSpecFluent) o;
    if (!(Objects.equals(ciphers, that.ciphers))) {
      return false;
    }
    if (!(Objects.equals(minTLSVersion, that.minTLSVersion))) {
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
  
  public String getCipher(int index) {
    return this.ciphers.get(index);
  }
  
  public List<String> getCiphers() {
    return this.ciphers;
  }
  
  public String getFirstCipher() {
    return this.ciphers.get(0);
  }
  
  public String getLastCipher() {
    return this.ciphers.get(ciphers.size() - 1);
  }
  
  public String getMatchingCipher(Predicate<String> predicate) {
      for (String item : ciphers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMinTLSVersion() {
    return this.minTLSVersion;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCiphers() {
    return this.ciphers != null && !(this.ciphers.isEmpty());
  }
  
  public boolean hasMatchingCipher(Predicate<String> predicate) {
      for (String item : ciphers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMinTLSVersion() {
    return this.minTLSVersion != null;
  }
  
  public int hashCode() {
    return Objects.hash(ciphers, minTLSVersion, additionalProperties);
  }
  
  public A removeAllFromCiphers(Collection<String> items) {
    if (this.ciphers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ciphers.remove(item);
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
  
  public A removeFromCiphers(String... items) {
    if (this.ciphers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ciphers.remove(item);
    }
    return (A) this;
  }
  
  public A setToCiphers(int index,String item) {
    if (this.ciphers == null) {
      this.ciphers = new ArrayList();
    }
    this.ciphers.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ciphers == null) && !(ciphers.isEmpty())) {
        sb.append("ciphers:");
        sb.append(ciphers);
        sb.append(",");
    }
    if (!(minTLSVersion == null)) {
        sb.append("minTLSVersion:");
        sb.append(minTLSVersion);
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
  
  public A withCiphers(List<String> ciphers) {
    if (ciphers != null) {
        this.ciphers = new ArrayList();
        for (String item : ciphers) {
          this.addToCiphers(item);
        }
    } else {
      this.ciphers = null;
    }
    return (A) this;
  }
  
  public A withCiphers(String... ciphers) {
    if (this.ciphers != null) {
        this.ciphers.clear();
        _visitables.remove("ciphers");
    }
    if (ciphers != null) {
      for (String item : ciphers) {
        this.addToCiphers(item);
      }
    }
    return (A) this;
  }
  
  public A withMinTLSVersion(String minTLSVersion) {
    this.minTLSVersion = minTLSVersion;
    return (A) this;
  }
  
}