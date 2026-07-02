package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NodeConfigSourceFluent<A extends io.fabric8.kubernetes.api.model.NodeConfigSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConfigMapNodeConfigSourceBuilder configMap;

  public NodeConfigSourceFluent() {
  }
  
  public NodeConfigSourceFluent(NodeConfigSource instance) {
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
  
  public ConfigMapNodeConfigSource buildConfigMap() {
    return this.configMap != null ? this.configMap.build() : null;
  }
  
  protected void copyInstance(NodeConfigSource instance) {
    instance = instance != null ? instance : new NodeConfigSource();
    if (instance != null) {
        this.withConfigMap(instance.getConfigMap());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigMapNested<A> editConfigMap() {
    return this.withNewConfigMapLike(Optional.ofNullable(this.buildConfigMap()).orElse(null));
  }
  
  public ConfigMapNested<A> editOrNewConfigMap() {
    return this.withNewConfigMapLike(Optional.ofNullable(this.buildConfigMap()).orElse(new ConfigMapNodeConfigSourceBuilder().build()));
  }
  
  public ConfigMapNested<A> editOrNewConfigMapLike(ConfigMapNodeConfigSource item) {
    return this.withNewConfigMapLike(Optional.ofNullable(this.buildConfigMap()).orElse(item));
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
    NodeConfigSourceFluent that = (NodeConfigSourceFluent) o;
    if (!(Objects.equals(configMap, that.configMap))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfigMap() {
    return this.configMap != null;
  }
  
  public int hashCode() {
    return Objects.hash(configMap, additionalProperties);
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
    if (!(configMap == null)) {
        sb.append("configMap:");
        sb.append(configMap);
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
  
  public A withConfigMap(ConfigMapNodeConfigSource configMap) {
    this._visitables.remove("configMap");
    if (configMap != null) {
        this.configMap = new ConfigMapNodeConfigSourceBuilder(configMap);
        this._visitables.get("configMap").add(this.configMap);
    } else {
        this.configMap = null;
        this._visitables.get("configMap").remove(this.configMap);
    }
    return (A) this;
  }
  
  public ConfigMapNested<A> withNewConfigMap() {
    return new ConfigMapNested(null);
  }
  
  public A withNewConfigMap(String kubeletConfigKey,String name,String namespace,String resourceVersion,String uid) {
    return (A) this.withConfigMap(new ConfigMapNodeConfigSource(kubeletConfigKey, name, namespace, resourceVersion, uid));
  }
  
  public ConfigMapNested<A> withNewConfigMapLike(ConfigMapNodeConfigSource item) {
    return new ConfigMapNested(item);
  }
  public class ConfigMapNested<N> extends ConfigMapNodeConfigSourceFluent<ConfigMapNested<N>> implements Nested<N>{
  
    ConfigMapNodeConfigSourceBuilder builder;
  
    ConfigMapNested(ConfigMapNodeConfigSource item) {
      this.builder = new ConfigMapNodeConfigSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeConfigSourceFluent.this.withConfigMap(builder.build());
    }
    
    public N endConfigMap() {
      return and();
    }
    
  }
}