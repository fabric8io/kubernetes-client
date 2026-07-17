package io.fabric8.openshift.api.model.monitoring.v1;

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
public class GlobalWeChatConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.GlobalWeChatConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiCorpID;
  private SecretKeySelector apiSecret;
  private String apiURL;

  public GlobalWeChatConfigFluent() {
  }
  
  public GlobalWeChatConfigFluent(GlobalWeChatConfig instance) {
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
  
  protected void copyInstance(GlobalWeChatConfig instance) {
    instance = instance != null ? instance : new GlobalWeChatConfig();
    if (instance != null) {
        this.withApiCorpID(instance.getApiCorpID());
        this.withApiSecret(instance.getApiSecret());
        this.withApiURL(instance.getApiURL());
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
    GlobalWeChatConfigFluent that = (GlobalWeChatConfigFluent) o;
    if (!(Objects.equals(apiCorpID, that.apiCorpID))) {
      return false;
    }
    if (!(Objects.equals(apiSecret, that.apiSecret))) {
      return false;
    }
    if (!(Objects.equals(apiURL, that.apiURL))) {
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
  
  public String getApiCorpID() {
    return this.apiCorpID;
  }
  
  public SecretKeySelector getApiSecret() {
    return this.apiSecret;
  }
  
  public String getApiURL() {
    return this.apiURL;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiCorpID() {
    return this.apiCorpID != null;
  }
  
  public boolean hasApiSecret() {
    return this.apiSecret != null;
  }
  
  public boolean hasApiURL() {
    return this.apiURL != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiCorpID, apiSecret, apiURL, additionalProperties);
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
    if (!(apiCorpID == null)) {
        sb.append("apiCorpID:");
        sb.append(apiCorpID);
        sb.append(",");
    }
    if (!(apiSecret == null)) {
        sb.append("apiSecret:");
        sb.append(apiSecret);
        sb.append(",");
    }
    if (!(apiURL == null)) {
        sb.append("apiURL:");
        sb.append(apiURL);
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
  
  public A withApiCorpID(String apiCorpID) {
    this.apiCorpID = apiCorpID;
    return (A) this;
  }
  
  public A withApiSecret(SecretKeySelector apiSecret) {
    this.apiSecret = apiSecret;
    return (A) this;
  }
  
  public A withApiURL(String apiURL) {
    this.apiURL = apiURL;
    return (A) this;
  }
  
  public A withNewApiSecret(String key,String name,Boolean optional) {
    return (A) this.withApiSecret(new SecretKeySelector(key, name, optional));
  }
  
}