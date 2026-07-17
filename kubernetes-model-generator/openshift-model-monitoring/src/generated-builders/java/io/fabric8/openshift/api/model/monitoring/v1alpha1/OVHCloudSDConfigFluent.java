package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import java.lang.Boolean;
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
public class OVHCloudSDConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.OVHCloudSDConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String applicationKey;
  private SecretKeySelector applicationSecret;
  private SecretKeySelector consumerKey;
  private String endpoint;
  private String refreshInterval;
  private String service;

  public OVHCloudSDConfigFluent() {
  }
  
  public OVHCloudSDConfigFluent(OVHCloudSDConfig instance) {
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
  
  protected void copyInstance(OVHCloudSDConfig instance) {
    instance = instance != null ? instance : new OVHCloudSDConfig();
    if (instance != null) {
        this.withApplicationKey(instance.getApplicationKey());
        this.withApplicationSecret(instance.getApplicationSecret());
        this.withConsumerKey(instance.getConsumerKey());
        this.withEndpoint(instance.getEndpoint());
        this.withRefreshInterval(instance.getRefreshInterval());
        this.withService(instance.getService());
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
    OVHCloudSDConfigFluent that = (OVHCloudSDConfigFluent) o;
    if (!(Objects.equals(applicationKey, that.applicationKey))) {
      return false;
    }
    if (!(Objects.equals(applicationSecret, that.applicationSecret))) {
      return false;
    }
    if (!(Objects.equals(consumerKey, that.consumerKey))) {
      return false;
    }
    if (!(Objects.equals(endpoint, that.endpoint))) {
      return false;
    }
    if (!(Objects.equals(refreshInterval, that.refreshInterval))) {
      return false;
    }
    if (!(Objects.equals(service, that.service))) {
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
  
  public String getApplicationKey() {
    return this.applicationKey;
  }
  
  public SecretKeySelector getApplicationSecret() {
    return this.applicationSecret;
  }
  
  public SecretKeySelector getConsumerKey() {
    return this.consumerKey;
  }
  
  public String getEndpoint() {
    return this.endpoint;
  }
  
  public String getRefreshInterval() {
    return this.refreshInterval;
  }
  
  public String getService() {
    return this.service;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApplicationKey() {
    return this.applicationKey != null;
  }
  
  public boolean hasApplicationSecret() {
    return this.applicationSecret != null;
  }
  
  public boolean hasConsumerKey() {
    return this.consumerKey != null;
  }
  
  public boolean hasEndpoint() {
    return this.endpoint != null;
  }
  
  public boolean hasRefreshInterval() {
    return this.refreshInterval != null;
  }
  
  public boolean hasService() {
    return this.service != null;
  }
  
  public int hashCode() {
    return Objects.hash(applicationKey, applicationSecret, consumerKey, endpoint, refreshInterval, service, additionalProperties);
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
    if (!(applicationKey == null)) {
        sb.append("applicationKey:");
        sb.append(applicationKey);
        sb.append(",");
    }
    if (!(applicationSecret == null)) {
        sb.append("applicationSecret:");
        sb.append(applicationSecret);
        sb.append(",");
    }
    if (!(consumerKey == null)) {
        sb.append("consumerKey:");
        sb.append(consumerKey);
        sb.append(",");
    }
    if (!(endpoint == null)) {
        sb.append("endpoint:");
        sb.append(endpoint);
        sb.append(",");
    }
    if (!(refreshInterval == null)) {
        sb.append("refreshInterval:");
        sb.append(refreshInterval);
        sb.append(",");
    }
    if (!(service == null)) {
        sb.append("service:");
        sb.append(service);
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
  
  public A withApplicationKey(String applicationKey) {
    this.applicationKey = applicationKey;
    return (A) this;
  }
  
  public A withApplicationSecret(SecretKeySelector applicationSecret) {
    this.applicationSecret = applicationSecret;
    return (A) this;
  }
  
  public A withConsumerKey(SecretKeySelector consumerKey) {
    this.consumerKey = consumerKey;
    return (A) this;
  }
  
  public A withEndpoint(String endpoint) {
    this.endpoint = endpoint;
    return (A) this;
  }
  
  public A withNewApplicationSecret(String key,String name,Boolean optional) {
    return (A) this.withApplicationSecret(new SecretKeySelector(key, name, optional));
  }
  
  public A withNewConsumerKey(String key,String name,Boolean optional) {
    return (A) this.withConsumerKey(new SecretKeySelector(key, name, optional));
  }
  
  public A withRefreshInterval(String refreshInterval) {
    this.refreshInterval = refreshInterval;
    return (A) this;
  }
  
  public A withService(String service) {
    this.service = service;
    return (A) this;
  }
  
}