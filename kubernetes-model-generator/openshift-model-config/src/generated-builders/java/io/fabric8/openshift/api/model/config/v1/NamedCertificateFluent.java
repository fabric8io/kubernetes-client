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
public class NamedCertificateFluent<A extends io.fabric8.openshift.api.model.config.v1.NamedCertificateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String certFile;
  private String keyFile;
  private List<String> names = new ArrayList<String>();

  public NamedCertificateFluent() {
  }
  
  public NamedCertificateFluent(NamedCertificate instance) {
    this.copyInstance(instance);
  }

  public A addAllToNames(Collection<String> items) {
    if (this.names == null) {
      this.names = new ArrayList();
    }
    for (String item : items) {
      this.names.add(item);
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
  
  public A addToNames(String... items) {
    if (this.names == null) {
      this.names = new ArrayList();
    }
    for (String item : items) {
      this.names.add(item);
    }
    return (A) this;
  }
  
  public A addToNames(int index,String item) {
    if (this.names == null) {
      this.names = new ArrayList();
    }
    this.names.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(NamedCertificate instance) {
    instance = instance != null ? instance : new NamedCertificate();
    if (instance != null) {
        this.withCertFile(instance.getCertFile());
        this.withKeyFile(instance.getKeyFile());
        this.withNames(instance.getNames());
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
    NamedCertificateFluent that = (NamedCertificateFluent) o;
    if (!(Objects.equals(certFile, that.certFile))) {
      return false;
    }
    if (!(Objects.equals(keyFile, that.keyFile))) {
      return false;
    }
    if (!(Objects.equals(names, that.names))) {
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
  
  public String getCertFile() {
    return this.certFile;
  }
  
  public String getFirstName() {
    return this.names.get(0);
  }
  
  public String getKeyFile() {
    return this.keyFile;
  }
  
  public String getLastName() {
    return this.names.get(names.size() - 1);
  }
  
  public String getMatchingName(Predicate<String> predicate) {
      for (String item : names) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName(int index) {
    return this.names.get(index);
  }
  
  public List<String> getNames() {
    return this.names;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCertFile() {
    return this.certFile != null;
  }
  
  public boolean hasKeyFile() {
    return this.keyFile != null;
  }
  
  public boolean hasMatchingName(Predicate<String> predicate) {
      for (String item : names) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNames() {
    return this.names != null && !(this.names.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(certFile, keyFile, names, additionalProperties);
  }
  
  public A removeAllFromNames(Collection<String> items) {
    if (this.names == null) {
      return (A) this;
    }
    for (String item : items) {
      this.names.remove(item);
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
  
  public A removeFromNames(String... items) {
    if (this.names == null) {
      return (A) this;
    }
    for (String item : items) {
      this.names.remove(item);
    }
    return (A) this;
  }
  
  public A setToNames(int index,String item) {
    if (this.names == null) {
      this.names = new ArrayList();
    }
    this.names.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(certFile == null)) {
        sb.append("certFile:");
        sb.append(certFile);
        sb.append(",");
    }
    if (!(keyFile == null)) {
        sb.append("keyFile:");
        sb.append(keyFile);
        sb.append(",");
    }
    if (!(names == null) && !(names.isEmpty())) {
        sb.append("names:");
        sb.append(names);
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
  
  public A withCertFile(String certFile) {
    this.certFile = certFile;
    return (A) this;
  }
  
  public A withKeyFile(String keyFile) {
    this.keyFile = keyFile;
    return (A) this;
  }
  
  public A withNames(List<String> names) {
    if (names != null) {
        this.names = new ArrayList();
        for (String item : names) {
          this.addToNames(item);
        }
    } else {
      this.names = null;
    }
    return (A) this;
  }
  
  public A withNames(String... names) {
    if (this.names != null) {
        this.names.clear();
        _visitables.remove("names");
    }
    if (names != null) {
      for (String item : names) {
        this.addToNames(item);
      }
    }
    return (A) this;
  }
  
}