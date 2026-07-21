package io.fabric8.openclustermanagement.api.model.operator.v1;

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
public class BootstrapKubeConfigsFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.BootstrapKubeConfigsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LocalSecretsConfigBuilder localSecretsConfig;
  private String type;

  public BootstrapKubeConfigsFluent() {
  }
  
  public BootstrapKubeConfigsFluent(BootstrapKubeConfigs instance) {
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
  
  public LocalSecretsConfig buildLocalSecretsConfig() {
    return this.localSecretsConfig != null ? this.localSecretsConfig.build() : null;
  }
  
  protected void copyInstance(BootstrapKubeConfigs instance) {
    instance = instance != null ? instance : new BootstrapKubeConfigs();
    if (instance != null) {
        this.withLocalSecretsConfig(instance.getLocalSecretsConfig());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LocalSecretsConfigNested<A> editLocalSecretsConfig() {
    return this.withNewLocalSecretsConfigLike(Optional.ofNullable(this.buildLocalSecretsConfig()).orElse(null));
  }
  
  public LocalSecretsConfigNested<A> editOrNewLocalSecretsConfig() {
    return this.withNewLocalSecretsConfigLike(Optional.ofNullable(this.buildLocalSecretsConfig()).orElse(new LocalSecretsConfigBuilder().build()));
  }
  
  public LocalSecretsConfigNested<A> editOrNewLocalSecretsConfigLike(LocalSecretsConfig item) {
    return this.withNewLocalSecretsConfigLike(Optional.ofNullable(this.buildLocalSecretsConfig()).orElse(item));
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
    BootstrapKubeConfigsFluent that = (BootstrapKubeConfigsFluent) o;
    if (!(Objects.equals(localSecretsConfig, that.localSecretsConfig))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLocalSecretsConfig() {
    return this.localSecretsConfig != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(localSecretsConfig, type, additionalProperties);
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
    if (!(localSecretsConfig == null)) {
        sb.append("localSecretsConfig:");
        sb.append(localSecretsConfig);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withLocalSecretsConfig(LocalSecretsConfig localSecretsConfig) {
    this._visitables.remove("localSecretsConfig");
    if (localSecretsConfig != null) {
        this.localSecretsConfig = new LocalSecretsConfigBuilder(localSecretsConfig);
        this._visitables.get("localSecretsConfig").add(this.localSecretsConfig);
    } else {
        this.localSecretsConfig = null;
        this._visitables.get("localSecretsConfig").remove(this.localSecretsConfig);
    }
    return (A) this;
  }
  
  public LocalSecretsConfigNested<A> withNewLocalSecretsConfig() {
    return new LocalSecretsConfigNested(null);
  }
  
  public LocalSecretsConfigNested<A> withNewLocalSecretsConfigLike(LocalSecretsConfig item) {
    return new LocalSecretsConfigNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class LocalSecretsConfigNested<N> extends LocalSecretsConfigFluent<LocalSecretsConfigNested<N>> implements Nested<N>{
  
    LocalSecretsConfigBuilder builder;
  
    LocalSecretsConfigNested(LocalSecretsConfig item) {
      this.builder = new LocalSecretsConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) BootstrapKubeConfigsFluent.this.withLocalSecretsConfig(builder.build());
    }
    
    public N endLocalSecretsConfig() {
      return and();
    }
    
  }
}