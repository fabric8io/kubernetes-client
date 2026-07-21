package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
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
public class DefaultWebhookConfigurationFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.DefaultWebhookConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private BindConfigurationBuilder bindConfiguration;

  public DefaultWebhookConfigurationFluent() {
  }
  
  public DefaultWebhookConfigurationFluent(DefaultWebhookConfiguration instance) {
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
  
  public BindConfiguration buildBindConfiguration() {
    return this.bindConfiguration != null ? this.bindConfiguration.build() : null;
  }
  
  protected void copyInstance(DefaultWebhookConfiguration instance) {
    instance = instance != null ? instance : new DefaultWebhookConfiguration();
    if (instance != null) {
        this.withBindConfiguration(instance.getBindConfiguration());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BindConfigurationNested<A> editBindConfiguration() {
    return this.withNewBindConfigurationLike(Optional.ofNullable(this.buildBindConfiguration()).orElse(null));
  }
  
  public BindConfigurationNested<A> editOrNewBindConfiguration() {
    return this.withNewBindConfigurationLike(Optional.ofNullable(this.buildBindConfiguration()).orElse(new BindConfigurationBuilder().build()));
  }
  
  public BindConfigurationNested<A> editOrNewBindConfigurationLike(BindConfiguration item) {
    return this.withNewBindConfigurationLike(Optional.ofNullable(this.buildBindConfiguration()).orElse(item));
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
    DefaultWebhookConfigurationFluent that = (DefaultWebhookConfigurationFluent) o;
    if (!(Objects.equals(bindConfiguration, that.bindConfiguration))) {
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
  
  public boolean hasBindConfiguration() {
    return this.bindConfiguration != null;
  }
  
  public int hashCode() {
    return Objects.hash(bindConfiguration, additionalProperties);
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
    if (!(bindConfiguration == null)) {
        sb.append("bindConfiguration:");
        sb.append(bindConfiguration);
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
  
  public A withBindConfiguration(BindConfiguration bindConfiguration) {
    this._visitables.remove("bindConfiguration");
    if (bindConfiguration != null) {
        this.bindConfiguration = new BindConfigurationBuilder(bindConfiguration);
        this._visitables.get("bindConfiguration").add(this.bindConfiguration);
    } else {
        this.bindConfiguration = null;
        this._visitables.get("bindConfiguration").remove(this.bindConfiguration);
    }
    return (A) this;
  }
  
  public BindConfigurationNested<A> withNewBindConfiguration() {
    return new BindConfigurationNested(null);
  }
  
  public A withNewBindConfiguration(Integer healthProbePort,Boolean hostNetwork,Integer metricsPort,Integer port) {
    return (A) this.withBindConfiguration(new BindConfiguration(healthProbePort, hostNetwork, metricsPort, port));
  }
  
  public BindConfigurationNested<A> withNewBindConfigurationLike(BindConfiguration item) {
    return new BindConfigurationNested(item);
  }
  public class BindConfigurationNested<N> extends BindConfigurationFluent<BindConfigurationNested<N>> implements Nested<N>{
  
    BindConfigurationBuilder builder;
  
    BindConfigurationNested(BindConfiguration item) {
      this.builder = new BindConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) DefaultWebhookConfigurationFluent.this.withBindConfiguration(builder.build());
    }
    
    public N endBindConfiguration() {
      return and();
    }
    
  }
}