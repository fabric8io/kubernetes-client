package io.fabric8.openshift.api.model.config.v1;

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
public class RemoteConnectionInfoFluent<A extends io.fabric8.openshift.api.model.config.v1.RemoteConnectionInfoFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String ca;
  private String certFile;
  private String keyFile;
  private String url;

  public RemoteConnectionInfoFluent() {
  }
  
  public RemoteConnectionInfoFluent(RemoteConnectionInfo instance) {
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
  
  protected void copyInstance(RemoteConnectionInfo instance) {
    instance = instance != null ? instance : new RemoteConnectionInfo();
    if (instance != null) {
        this.withCa(instance.getCa());
        this.withCertFile(instance.getCertFile());
        this.withKeyFile(instance.getKeyFile());
        this.withUrl(instance.getUrl());
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
    RemoteConnectionInfoFluent that = (RemoteConnectionInfoFluent) o;
    if (!(Objects.equals(ca, that.ca))) {
      return false;
    }
    if (!(Objects.equals(certFile, that.certFile))) {
      return false;
    }
    if (!(Objects.equals(keyFile, that.keyFile))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
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
  
  public String getKeyFile() {
    return this.keyFile;
  }
  
  public String getUrl() {
    return this.url;
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
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(ca, certFile, keyFile, url, additionalProperties);
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
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
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
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  
}