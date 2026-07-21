package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class ComponentConfigFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.ComponentConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConfigOverrideBuilder configOverrides;
  private Boolean enabled;
  private String name;

  public ComponentConfigFluent() {
  }
  
  public ComponentConfigFluent(ComponentConfig instance) {
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
  
  public ConfigOverride buildConfigOverrides() {
    return this.configOverrides != null ? this.configOverrides.build() : null;
  }
  
  protected void copyInstance(ComponentConfig instance) {
    instance = instance != null ? instance : new ComponentConfig();
    if (instance != null) {
        this.withConfigOverrides(instance.getConfigOverrides());
        this.withEnabled(instance.getEnabled());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigOverridesNested<A> editConfigOverrides() {
    return this.withNewConfigOverridesLike(Optional.ofNullable(this.buildConfigOverrides()).orElse(null));
  }
  
  public ConfigOverridesNested<A> editOrNewConfigOverrides() {
    return this.withNewConfigOverridesLike(Optional.ofNullable(this.buildConfigOverrides()).orElse(new ConfigOverrideBuilder().build()));
  }
  
  public ConfigOverridesNested<A> editOrNewConfigOverridesLike(ConfigOverride item) {
    return this.withNewConfigOverridesLike(Optional.ofNullable(this.buildConfigOverrides()).orElse(item));
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
    ComponentConfigFluent that = (ComponentConfigFluent) o;
    if (!(Objects.equals(configOverrides, that.configOverrides))) {
      return false;
    }
    if (!(Objects.equals(enabled, that.enabled))) {
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
  
  public Boolean getEnabled() {
    return this.enabled;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfigOverrides() {
    return this.configOverrides != null;
  }
  
  public boolean hasEnabled() {
    return this.enabled != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(configOverrides, enabled, name, additionalProperties);
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
    if (!(configOverrides == null)) {
        sb.append("configOverrides:");
        sb.append(configOverrides);
        sb.append(",");
    }
    if (!(enabled == null)) {
        sb.append("enabled:");
        sb.append(enabled);
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
  
  public A withConfigOverrides(ConfigOverride configOverrides) {
    this._visitables.remove("configOverrides");
    if (configOverrides != null) {
        this.configOverrides = new ConfigOverrideBuilder(configOverrides);
        this._visitables.get("configOverrides").add(this.configOverrides);
    } else {
        this.configOverrides = null;
        this._visitables.get("configOverrides").remove(this.configOverrides);
    }
    return (A) this;
  }
  
  public A withEnabled() {
    return withEnabled(true);
  }
  
  public A withEnabled(Boolean enabled) {
    this.enabled = enabled;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public ConfigOverridesNested<A> withNewConfigOverrides() {
    return new ConfigOverridesNested(null);
  }
  
  public ConfigOverridesNested<A> withNewConfigOverridesLike(ConfigOverride item) {
    return new ConfigOverridesNested(item);
  }
  public class ConfigOverridesNested<N> extends ConfigOverrideFluent<ConfigOverridesNested<N>> implements Nested<N>{
  
    ConfigOverrideBuilder builder;
  
    ConfigOverridesNested(ConfigOverride item) {
      this.builder = new ConfigOverrideBuilder(this, item);
    }
  
    public N and() {
      return (N) ComponentConfigFluent.this.withConfigOverrides(builder.build());
    }
    
    public N endConfigOverrides() {
      return and();
    }
    
  }
}