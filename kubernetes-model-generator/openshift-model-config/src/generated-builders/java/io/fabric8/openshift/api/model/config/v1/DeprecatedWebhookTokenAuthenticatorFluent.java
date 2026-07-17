package io.fabric8.openshift.api.model.config.v1;

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
public class DeprecatedWebhookTokenAuthenticatorFluent<A extends io.fabric8.openshift.api.model.config.v1.DeprecatedWebhookTokenAuthenticatorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SecretNameReferenceBuilder kubeConfig;

  public DeprecatedWebhookTokenAuthenticatorFluent() {
  }
  
  public DeprecatedWebhookTokenAuthenticatorFluent(DeprecatedWebhookTokenAuthenticator instance) {
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
  
  public SecretNameReference buildKubeConfig() {
    return this.kubeConfig != null ? this.kubeConfig.build() : null;
  }
  
  protected void copyInstance(DeprecatedWebhookTokenAuthenticator instance) {
    instance = instance != null ? instance : new DeprecatedWebhookTokenAuthenticator();
    if (instance != null) {
        this.withKubeConfig(instance.getKubeConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public KubeConfigNested<A> editKubeConfig() {
    return this.withNewKubeConfigLike(Optional.ofNullable(this.buildKubeConfig()).orElse(null));
  }
  
  public KubeConfigNested<A> editOrNewKubeConfig() {
    return this.withNewKubeConfigLike(Optional.ofNullable(this.buildKubeConfig()).orElse(new SecretNameReferenceBuilder().build()));
  }
  
  public KubeConfigNested<A> editOrNewKubeConfigLike(SecretNameReference item) {
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
    DeprecatedWebhookTokenAuthenticatorFluent that = (DeprecatedWebhookTokenAuthenticatorFluent) o;
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasKubeConfig() {
    return this.kubeConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(kubeConfig, additionalProperties);
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
  
  public A withKubeConfig(SecretNameReference kubeConfig) {
    this._visitables.remove("kubeConfig");
    if (kubeConfig != null) {
        this.kubeConfig = new SecretNameReferenceBuilder(kubeConfig);
        this._visitables.get("kubeConfig").add(this.kubeConfig);
    } else {
        this.kubeConfig = null;
        this._visitables.get("kubeConfig").remove(this.kubeConfig);
    }
    return (A) this;
  }
  
  public KubeConfigNested<A> withNewKubeConfig() {
    return new KubeConfigNested(null);
  }
  
  public A withNewKubeConfig(String name) {
    return (A) this.withKubeConfig(new SecretNameReference(name));
  }
  
  public KubeConfigNested<A> withNewKubeConfigLike(SecretNameReference item) {
    return new KubeConfigNested(item);
  }
  public class KubeConfigNested<N> extends SecretNameReferenceFluent<KubeConfigNested<N>> implements Nested<N>{
  
    SecretNameReferenceBuilder builder;
  
    KubeConfigNested(SecretNameReference item) {
      this.builder = new SecretNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) DeprecatedWebhookTokenAuthenticatorFluent.this.withKubeConfig(builder.build());
    }
    
    public N endKubeConfig() {
      return and();
    }
    
  }
}