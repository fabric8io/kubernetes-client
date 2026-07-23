package io.fabric8.openshift.api.model.hive.v1;

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
public class SpecificControllerConfigFluent<A extends io.fabric8.openshift.api.model.hive.v1.SpecificControllerConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ControllerConfigBuilder config;
  private String name;

  public SpecificControllerConfigFluent() {
  }
  
  public SpecificControllerConfigFluent(SpecificControllerConfig instance) {
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
  
  public ControllerConfig buildConfig() {
    return this.config != null ? this.config.build() : null;
  }
  
  protected void copyInstance(SpecificControllerConfig instance) {
    instance = instance != null ? instance : new SpecificControllerConfig();
    if (instance != null) {
        this.withConfig(instance.getConfig());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigNested<A> editConfig() {
    return this.withNewConfigLike(Optional.ofNullable(this.buildConfig()).orElse(null));
  }
  
  public ConfigNested<A> editOrNewConfig() {
    return this.withNewConfigLike(Optional.ofNullable(this.buildConfig()).orElse(new ControllerConfigBuilder().build()));
  }
  
  public ConfigNested<A> editOrNewConfigLike(ControllerConfig item) {
    return this.withNewConfigLike(Optional.ofNullable(this.buildConfig()).orElse(item));
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
    SpecificControllerConfigFluent that = (SpecificControllerConfigFluent) o;
    if (!(Objects.equals(config, that.config))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfig() {
    return this.config != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(config, name, additionalProperties);
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
    if (!(config == null)) {
        sb.append("config:");
        sb.append(config);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withConfig(ControllerConfig config) {
    this._visitables.remove("config");
    if (config != null) {
        this.config = new ControllerConfigBuilder(config);
        this._visitables.get("config").add(this.config);
    } else {
        this.config = null;
        this._visitables.get("config").remove(this.config);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public ConfigNested<A> withNewConfig() {
    return new ConfigNested(null);
  }
  
  public ConfigNested<A> withNewConfigLike(ControllerConfig item) {
    return new ConfigNested(item);
  }
  public class ConfigNested<N> extends ControllerConfigFluent<ConfigNested<N>> implements Nested<N>{
  
    ControllerConfigBuilder builder;
  
    ConfigNested(ControllerConfig item) {
      this.builder = new ControllerConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) SpecificControllerConfigFluent.this.withConfig(builder.build());
    }
    
    public N endConfig() {
      return and();
    }
    
  }
}