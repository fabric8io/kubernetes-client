package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Float;
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
public class KubeClientConfigFluent<A extends io.fabric8.openshift.api.model.config.v1.KubeClientConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClientConnectionOverridesBuilder connectionOverrides;
  private String kubeConfig;

  public KubeClientConfigFluent() {
  }
  
  public KubeClientConfigFluent(KubeClientConfig instance) {
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
  
  public ClientConnectionOverrides buildConnectionOverrides() {
    return this.connectionOverrides != null ? this.connectionOverrides.build() : null;
  }
  
  protected void copyInstance(KubeClientConfig instance) {
    instance = instance != null ? instance : new KubeClientConfig();
    if (instance != null) {
        this.withConnectionOverrides(instance.getConnectionOverrides());
        this.withKubeConfig(instance.getKubeConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConnectionOverridesNested<A> editConnectionOverrides() {
    return this.withNewConnectionOverridesLike(Optional.ofNullable(this.buildConnectionOverrides()).orElse(null));
  }
  
  public ConnectionOverridesNested<A> editOrNewConnectionOverrides() {
    return this.withNewConnectionOverridesLike(Optional.ofNullable(this.buildConnectionOverrides()).orElse(new ClientConnectionOverridesBuilder().build()));
  }
  
  public ConnectionOverridesNested<A> editOrNewConnectionOverridesLike(ClientConnectionOverrides item) {
    return this.withNewConnectionOverridesLike(Optional.ofNullable(this.buildConnectionOverrides()).orElse(item));
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
    KubeClientConfigFluent that = (KubeClientConfigFluent) o;
    if (!(Objects.equals(connectionOverrides, that.connectionOverrides))) {
      return false;
    }
    if (!(Objects.equals(kubeConfig, that.kubeConfig))) {
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
  
  public String getKubeConfig() {
    return this.kubeConfig;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConnectionOverrides() {
    return this.connectionOverrides != null;
  }
  
  public boolean hasKubeConfig() {
    return this.kubeConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(connectionOverrides, kubeConfig, additionalProperties);
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
    if (!(connectionOverrides == null)) {
        sb.append("connectionOverrides:");
        sb.append(connectionOverrides);
        sb.append(",");
    }
    if (!(kubeConfig == null)) {
        sb.append("kubeConfig:");
        sb.append(kubeConfig);
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
  
  public A withConnectionOverrides(ClientConnectionOverrides connectionOverrides) {
    this._visitables.remove("connectionOverrides");
    if (connectionOverrides != null) {
        this.connectionOverrides = new ClientConnectionOverridesBuilder(connectionOverrides);
        this._visitables.get("connectionOverrides").add(this.connectionOverrides);
    } else {
        this.connectionOverrides = null;
        this._visitables.get("connectionOverrides").remove(this.connectionOverrides);
    }
    return (A) this;
  }
  
  public A withKubeConfig(String kubeConfig) {
    this.kubeConfig = kubeConfig;
    return (A) this;
  }
  
  public ConnectionOverridesNested<A> withNewConnectionOverrides() {
    return new ConnectionOverridesNested(null);
  }
  
  public A withNewConnectionOverrides(String acceptContentTypes,Integer burst,String contentType,Float qps) {
    return (A) this.withConnectionOverrides(new ClientConnectionOverrides(acceptContentTypes, burst, contentType, qps));
  }
  
  public ConnectionOverridesNested<A> withNewConnectionOverridesLike(ClientConnectionOverrides item) {
    return new ConnectionOverridesNested(item);
  }
  public class ConnectionOverridesNested<N> extends ClientConnectionOverridesFluent<ConnectionOverridesNested<N>> implements Nested<N>{
  
    ClientConnectionOverridesBuilder builder;
  
    ConnectionOverridesNested(ClientConnectionOverrides item) {
      this.builder = new ClientConnectionOverridesBuilder(this, item);
    }
  
    public N and() {
      return (N) KubeClientConfigFluent.this.withConnectionOverrides(builder.build());
    }
    
    public N endConnectionOverrides() {
      return and();
    }
    
  }
}