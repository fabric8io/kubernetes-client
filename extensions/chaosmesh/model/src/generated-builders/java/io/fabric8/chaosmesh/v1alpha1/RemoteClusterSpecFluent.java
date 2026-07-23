package io.fabric8.chaosmesh.v1alpha1;

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
public class RemoteClusterSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.RemoteClusterSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String configOverride;
  private RemoteClusterKubeConfigBuilder kubeConfig;
  private String namespace;
  private String version;

  public RemoteClusterSpecFluent() {
  }
  
  public RemoteClusterSpecFluent(RemoteClusterSpec instance) {
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
  
  public RemoteClusterKubeConfig buildKubeConfig() {
    return this.kubeConfig != null ? this.kubeConfig.build() : null;
  }
  
  protected void copyInstance(RemoteClusterSpec instance) {
    instance = instance != null ? instance : new RemoteClusterSpec();
    if (instance != null) {
        this.withConfigOverride(instance.getConfigOverride());
        this.withKubeConfig(instance.getKubeConfig());
        this.withNamespace(instance.getNamespace());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public KubeConfigNested<A> editKubeConfig() {
    return this.withNewKubeConfigLike(Optional.ofNullable(this.buildKubeConfig()).orElse(null));
  }
  
  public KubeConfigNested<A> editOrNewKubeConfig() {
    return this.withNewKubeConfigLike(Optional.ofNullable(this.buildKubeConfig()).orElse(new RemoteClusterKubeConfigBuilder().build()));
  }
  
  public KubeConfigNested<A> editOrNewKubeConfigLike(RemoteClusterKubeConfig item) {
    return this.withNewKubeConfigLike(Optional.ofNullable(this.buildKubeConfig()).orElse(item));
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
    RemoteClusterSpecFluent that = (RemoteClusterSpecFluent) o;
    if (!(Objects.equals(configOverride, that.configOverride))) {
      return false;
    }
    if (!(Objects.equals(kubeConfig, that.kubeConfig))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public String getConfigOverride() {
    return this.configOverride;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfigOverride() {
    return this.configOverride != null;
  }
  
  public boolean hasKubeConfig() {
    return this.kubeConfig != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(configOverride, kubeConfig, namespace, version, additionalProperties);
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
    if (!(configOverride == null)) {
        sb.append("configOverride:");
        sb.append(configOverride);
        sb.append(",");
    }
    if (!(kubeConfig == null)) {
        sb.append("kubeConfig:");
        sb.append(kubeConfig);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public A withConfigOverride(String configOverride) {
    this.configOverride = configOverride;
    return (A) this;
  }
  
  public A withKubeConfig(RemoteClusterKubeConfig kubeConfig) {
    this._visitables.remove("kubeConfig");
    if (kubeConfig != null) {
        this.kubeConfig = new RemoteClusterKubeConfigBuilder(kubeConfig);
        this._visitables.get("kubeConfig").add(this.kubeConfig);
    } else {
        this.kubeConfig = null;
        this._visitables.get("kubeConfig").remove(this.kubeConfig);
    }
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public KubeConfigNested<A> withNewKubeConfig() {
    return new KubeConfigNested(null);
  }
  
  public KubeConfigNested<A> withNewKubeConfigLike(RemoteClusterKubeConfig item) {
    return new KubeConfigNested(item);
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  public class KubeConfigNested<N> extends RemoteClusterKubeConfigFluent<KubeConfigNested<N>> implements Nested<N>{
  
    RemoteClusterKubeConfigBuilder builder;
  
    KubeConfigNested(RemoteClusterKubeConfig item) {
      this.builder = new RemoteClusterKubeConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) RemoteClusterSpecFluent.this.withKubeConfig(builder.build());
    }
    
    public N endKubeConfig() {
      return and();
    }
    
  }
}