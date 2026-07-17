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
public class EtcdConnectionInfoFluent<A extends io.fabric8.openshift.api.model.config.v1.EtcdConnectionInfoFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String ca;
  private String certFile;
  private String keyFile;
  private List<String> urls = new ArrayList<String>();

  public EtcdConnectionInfoFluent() {
  }
  
  public EtcdConnectionInfoFluent(EtcdConnectionInfo instance) {
    this.copyInstance(instance);
  }

  public A addAllToUrls(Collection<String> items) {
    if (this.urls == null) {
      this.urls = new ArrayList();
    }
    for (String item : items) {
      this.urls.add(item);
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
  
  public A addToUrls(String... items) {
    if (this.urls == null) {
      this.urls = new ArrayList();
    }
    for (String item : items) {
      this.urls.add(item);
    }
    return (A) this;
  }
  
  public A addToUrls(int index,String item) {
    if (this.urls == null) {
      this.urls = new ArrayList();
    }
    this.urls.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(EtcdConnectionInfo instance) {
    instance = instance != null ? instance : new EtcdConnectionInfo();
    if (instance != null) {
        this.withCa(instance.getCa());
        this.withCertFile(instance.getCertFile());
        this.withKeyFile(instance.getKeyFile());
        this.withUrls(instance.getUrls());
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
    EtcdConnectionInfoFluent that = (EtcdConnectionInfoFluent) o;
    if (!(Objects.equals(ca, that.ca))) {
      return false;
    }
    if (!(Objects.equals(certFile, that.certFile))) {
      return false;
    }
    if (!(Objects.equals(keyFile, that.keyFile))) {
      return false;
    }
    if (!(Objects.equals(urls, that.urls))) {
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
  
  public String getCa() {
    return this.ca;
  }
  
  public String getCertFile() {
    return this.certFile;
  }
  
  public String getFirstUrl() {
    return this.urls.get(0);
  }
  
  public String getKeyFile() {
    return this.keyFile;
  }
  
  public String getLastUrl() {
    return this.urls.get(urls.size() - 1);
  }
  
  public String getMatchingUrl(Predicate<String> predicate) {
      for (String item : urls) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getUrl(int index) {
    return this.urls.get(index);
  }
  
  public List<String> getUrls() {
    return this.urls;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCa() {
    return this.ca != null;
  }
  
  public boolean hasCertFile() {
    return this.certFile != null;
  }
  
  public boolean hasKeyFile() {
    return this.keyFile != null;
  }
  
  public boolean hasMatchingUrl(Predicate<String> predicate) {
      for (String item : urls) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasUrls() {
    return this.urls != null && !(this.urls.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(ca, certFile, keyFile, urls, additionalProperties);
  }
  
  public A removeAllFromUrls(Collection<String> items) {
    if (this.urls == null) {
      return (A) this;
    }
    for (String item : items) {
      this.urls.remove(item);
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
  
  public A removeFromUrls(String... items) {
    if (this.urls == null) {
      return (A) this;
    }
    for (String item : items) {
      this.urls.remove(item);
    }
    return (A) this;
  }
  
  public A setToUrls(int index,String item) {
    if (this.urls == null) {
      this.urls = new ArrayList();
    }
    this.urls.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ca == null)) {
        sb.append("ca:");
        sb.append(ca);
        sb.append(",");
    }
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
    if (!(urls == null) && !(urls.isEmpty())) {
        sb.append("urls:");
        sb.append(urls);
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
  
  public A withCa(String ca) {
    this.ca = ca;
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
  
  public A withUrls(List<String> urls) {
    if (urls != null) {
        this.urls = new ArrayList();
        for (String item : urls) {
          this.addToUrls(item);
        }
    } else {
      this.urls = null;
    }
    return (A) this;
  }
  
  public A withUrls(String... urls) {
    if (this.urls != null) {
        this.urls.clear();
        _visitables.remove("urls");
    }
    if (urls != null) {
      for (String item : urls) {
        this.addToUrls(item);
      }
    }
    return (A) this;
  }
  
}