package io.fabric8.openshift.api.model.operator.controlplane.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.openshift.api.model.config.v1.SecretNameReference;
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
public class PodNetworkConnectivityCheckSpecFluent<A extends io.fabric8.openshift.api.model.operator.controlplane.v1alpha1.PodNetworkConnectivityCheckSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String sourcePod;
  private String targetEndpoint;
  private SecretNameReference tlsClientCert;

  public PodNetworkConnectivityCheckSpecFluent() {
  }
  
  public PodNetworkConnectivityCheckSpecFluent(PodNetworkConnectivityCheckSpec instance) {
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
  
  protected void copyInstance(PodNetworkConnectivityCheckSpec instance) {
    instance = instance != null ? instance : new PodNetworkConnectivityCheckSpec();
    if (instance != null) {
        this.withSourcePod(instance.getSourcePod());
        this.withTargetEndpoint(instance.getTargetEndpoint());
        this.withTlsClientCert(instance.getTlsClientCert());
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
    PodNetworkConnectivityCheckSpecFluent that = (PodNetworkConnectivityCheckSpecFluent) o;
    if (!(Objects.equals(sourcePod, that.sourcePod))) {
      return false;
    }
    if (!(Objects.equals(targetEndpoint, that.targetEndpoint))) {
      return false;
    }
    if (!(Objects.equals(tlsClientCert, that.tlsClientCert))) {
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
  
  public String getSourcePod() {
    return this.sourcePod;
  }
  
  public String getTargetEndpoint() {
    return this.targetEndpoint;
  }
  
  public SecretNameReference getTlsClientCert() {
    return this.tlsClientCert;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasSourcePod() {
    return this.sourcePod != null;
  }
  
  public boolean hasTargetEndpoint() {
    return this.targetEndpoint != null;
  }
  
  public boolean hasTlsClientCert() {
    return this.tlsClientCert != null;
  }
  
  public int hashCode() {
    return Objects.hash(sourcePod, targetEndpoint, tlsClientCert, additionalProperties);
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
    if (!(sourcePod == null)) {
        sb.append("sourcePod:");
        sb.append(sourcePod);
        sb.append(",");
    }
    if (!(targetEndpoint == null)) {
        sb.append("targetEndpoint:");
        sb.append(targetEndpoint);
        sb.append(",");
    }
    if (!(tlsClientCert == null)) {
        sb.append("tlsClientCert:");
        sb.append(tlsClientCert);
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
  
  public A withNewTlsClientCert(String name) {
    return (A) this.withTlsClientCert(new SecretNameReference(name));
  }
  
  public A withSourcePod(String sourcePod) {
    this.sourcePod = sourcePod;
    return (A) this;
  }
  
  public A withTargetEndpoint(String targetEndpoint) {
    this.targetEndpoint = targetEndpoint;
    return (A) this;
  }
  
  public A withTlsClientCert(SecretNameReference tlsClientCert) {
    this.tlsClientCert = tlsClientCert;
    return (A) this;
  }
  
}