package io.fabric8.openshift.api.model.miscellaneous.helm.v1beta1;

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
public class HelmChartRepositorySpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.helm.v1beta1.HelmChartRepositorySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConnectionConfigBuilder connectionConfig;
  private String description;
  private Boolean disabled;
  private String name;

  public HelmChartRepositorySpecFluent() {
  }
  
  public HelmChartRepositorySpecFluent(HelmChartRepositorySpec instance) {
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
  
  public ConnectionConfig buildConnectionConfig() {
    return this.connectionConfig != null ? this.connectionConfig.build() : null;
  }
  
  protected void copyInstance(HelmChartRepositorySpec instance) {
    instance = instance != null ? instance : new HelmChartRepositorySpec();
    if (instance != null) {
        this.withConnectionConfig(instance.getConnectionConfig());
        this.withDescription(instance.getDescription());
        this.withDisabled(instance.getDisabled());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConnectionConfigNested<A> editConnectionConfig() {
    return this.withNewConnectionConfigLike(Optional.ofNullable(this.buildConnectionConfig()).orElse(null));
  }
  
  public ConnectionConfigNested<A> editOrNewConnectionConfig() {
    return this.withNewConnectionConfigLike(Optional.ofNullable(this.buildConnectionConfig()).orElse(new ConnectionConfigBuilder().build()));
  }
  
  public ConnectionConfigNested<A> editOrNewConnectionConfigLike(ConnectionConfig item) {
    return this.withNewConnectionConfigLike(Optional.ofNullable(this.buildConnectionConfig()).orElse(item));
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
    HelmChartRepositorySpecFluent that = (HelmChartRepositorySpecFluent) o;
    if (!(Objects.equals(connectionConfig, that.connectionConfig))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(disabled, that.disabled))) {
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
  
  public String getDescription() {
    return this.description;
  }
  
  public Boolean getDisabled() {
    return this.disabled;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConnectionConfig() {
    return this.connectionConfig != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasDisabled() {
    return this.disabled != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(connectionConfig, description, disabled, name, additionalProperties);
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
    if (!(connectionConfig == null)) {
        sb.append("connectionConfig:");
        sb.append(connectionConfig);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(disabled == null)) {
        sb.append("disabled:");
        sb.append(disabled);
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
  
  public A withConnectionConfig(ConnectionConfig connectionConfig) {
    this._visitables.remove("connectionConfig");
    if (connectionConfig != null) {
        this.connectionConfig = new ConnectionConfigBuilder(connectionConfig);
        this._visitables.get("connectionConfig").add(this.connectionConfig);
    } else {
        this.connectionConfig = null;
        this._visitables.get("connectionConfig").remove(this.connectionConfig);
    }
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withDisabled() {
    return withDisabled(true);
  }
  
  public A withDisabled(Boolean disabled) {
    this.disabled = disabled;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public ConnectionConfigNested<A> withNewConnectionConfig() {
    return new ConnectionConfigNested(null);
  }
  
  public ConnectionConfigNested<A> withNewConnectionConfigLike(ConnectionConfig item) {
    return new ConnectionConfigNested(item);
  }
  public class ConnectionConfigNested<N> extends ConnectionConfigFluent<ConnectionConfigNested<N>> implements Nested<N>{
  
    ConnectionConfigBuilder builder;
  
    ConnectionConfigNested(ConnectionConfig item) {
      this.builder = new ConnectionConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HelmChartRepositorySpecFluent.this.withConnectionConfig(builder.build());
    }
    
    public N endConnectionConfig() {
      return and();
    }
    
  }
}