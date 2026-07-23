package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class ServerTLSSettingsTLSCertificateFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ServerTLSSettingsTLSCertificateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String caCertificates;
  private String privateKey;
  private String serverCertificate;

  public ServerTLSSettingsTLSCertificateFluent() {
  }
  
  public ServerTLSSettingsTLSCertificateFluent(ServerTLSSettingsTLSCertificate instance) {
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
  
  protected void copyInstance(ServerTLSSettingsTLSCertificate instance) {
    instance = instance != null ? instance : new ServerTLSSettingsTLSCertificate();
    if (instance != null) {
        this.withCaCertificates(instance.getCaCertificates());
        this.withPrivateKey(instance.getPrivateKey());
        this.withServerCertificate(instance.getServerCertificate());
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
    ServerTLSSettingsTLSCertificateFluent that = (ServerTLSSettingsTLSCertificateFluent) o;
    if (!(Objects.equals(caCertificates, that.caCertificates))) {
      return false;
    }
    if (!(Objects.equals(privateKey, that.privateKey))) {
      return false;
    }
    if (!(Objects.equals(serverCertificate, that.serverCertificate))) {
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
  
  public String getCaCertificates() {
    return this.caCertificates;
  }
  
  public String getPrivateKey() {
    return this.privateKey;
  }
  
  public String getServerCertificate() {
    return this.serverCertificate;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCaCertificates() {
    return this.caCertificates != null;
  }
  
  public boolean hasPrivateKey() {
    return this.privateKey != null;
  }
  
  public boolean hasServerCertificate() {
    return this.serverCertificate != null;
  }
  
  public int hashCode() {
    return Objects.hash(caCertificates, privateKey, serverCertificate, additionalProperties);
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
    if (!(caCertificates == null)) {
        sb.append("caCertificates:");
        sb.append(caCertificates);
        sb.append(",");
    }
    if (!(privateKey == null)) {
        sb.append("privateKey:");
        sb.append(privateKey);
        sb.append(",");
    }
    if (!(serverCertificate == null)) {
        sb.append("serverCertificate:");
        sb.append(serverCertificate);
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
  
  public A withCaCertificates(String caCertificates) {
    this.caCertificates = caCertificates;
    return (A) this;
  }
  
  public A withPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return (A) this;
  }
  
  public A withServerCertificate(String serverCertificate) {
    this.serverCertificate = serverCertificate;
    return (A) this;
  }
  
}