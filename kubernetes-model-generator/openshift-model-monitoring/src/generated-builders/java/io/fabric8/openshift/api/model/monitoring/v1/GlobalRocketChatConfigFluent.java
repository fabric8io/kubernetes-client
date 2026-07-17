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
public class GlobalRocketChatConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.GlobalRocketChatConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiURL;
  private SecretKeySelector token;
  private SecretKeySelector tokenID;

  public GlobalRocketChatConfigFluent() {
  }
  
  public GlobalRocketChatConfigFluent(GlobalRocketChatConfig instance) {
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
  
  protected void copyInstance(GlobalRocketChatConfig instance) {
    instance = instance != null ? instance : new GlobalRocketChatConfig();
    if (instance != null) {
        this.withApiURL(instance.getApiURL());
        this.withToken(instance.getToken());
        this.withTokenID(instance.getTokenID());
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
    GlobalRocketChatConfigFluent that = (GlobalRocketChatConfigFluent) o;
    if (!(Objects.equals(apiURL, that.apiURL))) {
      return false;
    }
    if (!(Objects.equals(token, that.token))) {
      return false;
    }
    if (!(Objects.equals(tokenID, that.tokenID))) {
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
  
  public String getApiURL() {
    return this.apiURL;
  }
  
  public SecretKeySelector getToken() {
    return this.token;
  }
  
  public SecretKeySelector getTokenID() {
    return this.tokenID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiURL() {
    return this.apiURL != null;
  }
  
  public boolean hasToken() {
    return this.token != null;
  }
  
  public boolean hasTokenID() {
    return this.tokenID != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiURL, token, tokenID, additionalProperties);
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
    if (!(apiURL == null)) {
        sb.append("apiURL:");
        sb.append(apiURL);
        sb.append(",");
    }
    if (!(token == null)) {
        sb.append("token:");
        sb.append(token);
        sb.append(",");
    }
    if (!(tokenID == null)) {
        sb.append("tokenID:");
        sb.append(tokenID);
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
  
  public A withApiURL(String apiURL) {
    this.apiURL = apiURL;
    return (A) this;
  }
  
  public A withNewToken(String key,String name,Boolean optional) {
    return (A) this.withToken(new SecretKeySelector(key, name, optional));
  }
  
  public A withNewTokenID(String key,String name,Boolean optional) {
    return (A) this.withTokenID(new SecretKeySelector(key, name, optional));
  }
  
  public A withToken(SecretKeySelector token) {
    this.token = token;
    return (A) this;
  }
  
  public A withTokenID(SecretKeySelector tokenID) {
    this.tokenID = tokenID;
    return (A) this;
  }
  
}