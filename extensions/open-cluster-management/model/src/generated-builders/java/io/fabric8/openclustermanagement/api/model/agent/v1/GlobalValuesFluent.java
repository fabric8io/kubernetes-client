package io.fabric8.openclustermanagement.api.model.agent.v1;

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
public class GlobalValuesFluent<A extends io.fabric8.openclustermanagement.api.model.agent.v1.GlobalValuesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> imageOverrides;
  private String imagePullPolicy;
  private String imagePullSecret;
  private Map<String,String> nodeSelector;
  private Map<String,String> proxyConfig;

  public GlobalValuesFluent() {
  }
  
  public GlobalValuesFluent(GlobalValues instance) {
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
  
  public A addToImageOverrides(Map<String,String> map) {
    if (this.imageOverrides == null && map != null) {
      this.imageOverrides = new LinkedHashMap();
    }
    if (map != null) {
      this.imageOverrides.putAll(map);
    }
    return (A) this;
  }
  
  public A addToImageOverrides(String key,String value) {
    if (this.imageOverrides == null && key != null && value != null) {
      this.imageOverrides = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.imageOverrides.put(key, value);
    }
    return (A) this;
  }
  
  public A addToNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null && map != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (map != null) {
      this.nodeSelector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNodeSelector(String key,String value) {
    if (this.nodeSelector == null && key != null && value != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.nodeSelector.put(key, value);
    }
    return (A) this;
  }
  
  public A addToProxyConfig(Map<String,String> map) {
    if (this.proxyConfig == null && map != null) {
      this.proxyConfig = new LinkedHashMap();
    }
    if (map != null) {
      this.proxyConfig.putAll(map);
    }
    return (A) this;
  }
  
  public A addToProxyConfig(String key,String value) {
    if (this.proxyConfig == null && key != null && value != null) {
      this.proxyConfig = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.proxyConfig.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(GlobalValues instance) {
    instance = instance != null ? instance : new GlobalValues();
    if (instance != null) {
        this.withImageOverrides(instance.getImageOverrides());
        this.withImagePullPolicy(instance.getImagePullPolicy());
        this.withImagePullSecret(instance.getImagePullSecret());
        this.withNodeSelector(instance.getNodeSelector());
        this.withProxyConfig(instance.getProxyConfig());
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
    GlobalValuesFluent that = (GlobalValuesFluent) o;
    if (!(Objects.equals(imageOverrides, that.imageOverrides))) {
      return false;
    }
    if (!(Objects.equals(imagePullPolicy, that.imagePullPolicy))) {
      return false;
    }
    if (!(Objects.equals(imagePullSecret, that.imagePullSecret))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(proxyConfig, that.proxyConfig))) {
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
  
  public Map<String,String> getImageOverrides() {
    return this.imageOverrides;
  }
  
  public String getImagePullPolicy() {
    return this.imagePullPolicy;
  }
  
  public String getImagePullSecret() {
    return this.imagePullSecret;
  }
  
  public Map<String,String> getNodeSelector() {
    return this.nodeSelector;
  }
  
  public Map<String,String> getProxyConfig() {
    return this.proxyConfig;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasImageOverrides() {
    return this.imageOverrides != null;
  }
  
  public boolean hasImagePullPolicy() {
    return this.imagePullPolicy != null;
  }
  
  public boolean hasImagePullSecret() {
    return this.imagePullSecret != null;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasProxyConfig() {
    return this.proxyConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(imageOverrides, imagePullPolicy, imagePullSecret, nodeSelector, proxyConfig, additionalProperties);
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
  
  public A removeFromImageOverrides(String key) {
    if (this.imageOverrides == null) {
      return (A) this;
    }
    if (key != null && this.imageOverrides != null) {
      this.imageOverrides.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromImageOverrides(Map<String,String> map) {
    if (this.imageOverrides == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.imageOverrides != null) {
          this.imageOverrides.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromNodeSelector(String key) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (key != null && this.nodeSelector != null) {
      this.nodeSelector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.nodeSelector != null) {
          this.nodeSelector.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromProxyConfig(String key) {
    if (this.proxyConfig == null) {
      return (A) this;
    }
    if (key != null && this.proxyConfig != null) {
      this.proxyConfig.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromProxyConfig(Map<String,String> map) {
    if (this.proxyConfig == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.proxyConfig != null) {
          this.proxyConfig.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(imageOverrides == null) && !(imageOverrides.isEmpty())) {
        sb.append("imageOverrides:");
        sb.append(imageOverrides);
        sb.append(",");
    }
    if (!(imagePullPolicy == null)) {
        sb.append("imagePullPolicy:");
        sb.append(imagePullPolicy);
        sb.append(",");
    }
    if (!(imagePullSecret == null)) {
        sb.append("imagePullSecret:");
        sb.append(imagePullSecret);
        sb.append(",");
    }
    if (!(nodeSelector == null) && !(nodeSelector.isEmpty())) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
        sb.append(",");
    }
    if (!(proxyConfig == null) && !(proxyConfig.isEmpty())) {
        sb.append("proxyConfig:");
        sb.append(proxyConfig);
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
  
  public <K,V>A withImageOverrides(Map<String,String> imageOverrides) {
    if (imageOverrides == null) {
      this.imageOverrides = null;
    } else {
      this.imageOverrides = new LinkedHashMap(imageOverrides);
    }
    return (A) this;
  }
  
  public A withImagePullPolicy(String imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
    return (A) this;
  }
  
  public A withImagePullSecret(String imagePullSecret) {
    this.imagePullSecret = imagePullSecret;
    return (A) this;
  }
  
  public <K,V>A withNodeSelector(Map<String,String> nodeSelector) {
    if (nodeSelector == null) {
      this.nodeSelector = null;
    } else {
      this.nodeSelector = new LinkedHashMap(nodeSelector);
    }
    return (A) this;
  }
  
  public <K,V>A withProxyConfig(Map<String,String> proxyConfig) {
    if (proxyConfig == null) {
      this.proxyConfig = null;
    } else {
      this.proxyConfig = new LinkedHashMap(proxyConfig);
    }
    return (A) this;
  }
  
}