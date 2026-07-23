package io.fabric8.tekton.triggers.v1alpha1;

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
public class ClusterInterceptorSpecFluent<A extends io.fabric8.tekton.triggers.v1alpha1.ClusterInterceptorSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClientConfigBuilder clientConfig;

  public ClusterInterceptorSpecFluent() {
  }
  
  public ClusterInterceptorSpecFluent(ClusterInterceptorSpec instance) {
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
  
  public ClientConfig buildClientConfig() {
    return this.clientConfig != null ? this.clientConfig.build() : null;
  }
  
  protected void copyInstance(ClusterInterceptorSpec instance) {
    instance = instance != null ? instance : new ClusterInterceptorSpec();
    if (instance != null) {
        this.withClientConfig(instance.getClientConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClientConfigNested<A> editClientConfig() {
    return this.withNewClientConfigLike(Optional.ofNullable(this.buildClientConfig()).orElse(null));
  }
  
  public ClientConfigNested<A> editOrNewClientConfig() {
    return this.withNewClientConfigLike(Optional.ofNullable(this.buildClientConfig()).orElse(new ClientConfigBuilder().build()));
  }
  
  public ClientConfigNested<A> editOrNewClientConfigLike(ClientConfig item) {
    return this.withNewClientConfigLike(Optional.ofNullable(this.buildClientConfig()).orElse(item));
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
    ClusterInterceptorSpecFluent that = (ClusterInterceptorSpecFluent) o;
    if (!(Objects.equals(clientConfig, that.clientConfig))) {
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
  
  public boolean hasClientConfig() {
    return this.clientConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(clientConfig, additionalProperties);
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
    if (!(clientConfig == null)) {
        sb.append("clientConfig:");
        sb.append(clientConfig);
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
  
  public A withClientConfig(ClientConfig clientConfig) {
    this._visitables.remove("clientConfig");
    if (clientConfig != null) {
        this.clientConfig = new ClientConfigBuilder(clientConfig);
        this._visitables.get("clientConfig").add(this.clientConfig);
    } else {
        this.clientConfig = null;
        this._visitables.get("clientConfig").remove(this.clientConfig);
    }
    return (A) this;
  }
  
  public ClientConfigNested<A> withNewClientConfig() {
    return new ClientConfigNested(null);
  }
  
  public ClientConfigNested<A> withNewClientConfigLike(ClientConfig item) {
    return new ClientConfigNested(item);
  }
  public class ClientConfigNested<N> extends ClientConfigFluent<ClientConfigNested<N>> implements Nested<N>{
  
    ClientConfigBuilder builder;
  
    ClientConfigNested(ClientConfig item) {
      this.builder = new ClientConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterInterceptorSpecFluent.this.withClientConfig(builder.build());
    }
    
    public N endClientConfig() {
      return and();
    }
    
  }
}