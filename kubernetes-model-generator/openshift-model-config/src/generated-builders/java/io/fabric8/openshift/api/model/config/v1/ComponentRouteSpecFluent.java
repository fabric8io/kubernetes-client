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
public class ComponentRouteSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.ComponentRouteSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String hostname;
  private String name;
  private String namespace;
  private SecretNameReferenceBuilder servingCertKeyPairSecret;

  public ComponentRouteSpecFluent() {
  }
  
  public ComponentRouteSpecFluent(ComponentRouteSpec instance) {
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
  
  public SecretNameReference buildServingCertKeyPairSecret() {
    return this.servingCertKeyPairSecret != null ? this.servingCertKeyPairSecret.build() : null;
  }
  
  protected void copyInstance(ComponentRouteSpec instance) {
    instance = instance != null ? instance : new ComponentRouteSpec();
    if (instance != null) {
        this.withHostname(instance.getHostname());
        this.withName(instance.getName());
        this.withNamespace(instance.getNamespace());
        this.withServingCertKeyPairSecret(instance.getServingCertKeyPairSecret());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ServingCertKeyPairSecretNested<A> editOrNewServingCertKeyPairSecret() {
    return this.withNewServingCertKeyPairSecretLike(Optional.ofNullable(this.buildServingCertKeyPairSecret()).orElse(new SecretNameReferenceBuilder().build()));
  }
  
  public ServingCertKeyPairSecretNested<A> editOrNewServingCertKeyPairSecretLike(SecretNameReference item) {
    return this.withNewServingCertKeyPairSecretLike(Optional.ofNullable(this.buildServingCertKeyPairSecret()).orElse(item));
  }
  
  public ServingCertKeyPairSecretNested<A> editServingCertKeyPairSecret() {
    return this.withNewServingCertKeyPairSecretLike(Optional.ofNullable(this.buildServingCertKeyPairSecret()).orElse(null));
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
    ComponentRouteSpecFluent that = (ComponentRouteSpecFluent) o;
    if (!(Objects.equals(hostname, that.hostname))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(servingCertKeyPairSecret, that.servingCertKeyPairSecret))) {
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
  
  public String getHostname() {
    return this.hostname;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHostname() {
    return this.hostname != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasServingCertKeyPairSecret() {
    return this.servingCertKeyPairSecret != null;
  }
  
  public int hashCode() {
    return Objects.hash(hostname, name, namespace, servingCertKeyPairSecret, additionalProperties);
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
    if (!(hostname == null)) {
        sb.append("hostname:");
        sb.append(hostname);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(servingCertKeyPairSecret == null)) {
        sb.append("servingCertKeyPairSecret:");
        sb.append(servingCertKeyPairSecret);
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
  
  public A withHostname(String hostname) {
    this.hostname = hostname;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public ServingCertKeyPairSecretNested<A> withNewServingCertKeyPairSecret() {
    return new ServingCertKeyPairSecretNested(null);
  }
  
  public A withNewServingCertKeyPairSecret(String name) {
    return (A) this.withServingCertKeyPairSecret(new SecretNameReference(name));
  }
  
  public ServingCertKeyPairSecretNested<A> withNewServingCertKeyPairSecretLike(SecretNameReference item) {
    return new ServingCertKeyPairSecretNested(item);
  }
  
  public A withServingCertKeyPairSecret(SecretNameReference servingCertKeyPairSecret) {
    this._visitables.remove("servingCertKeyPairSecret");
    if (servingCertKeyPairSecret != null) {
        this.servingCertKeyPairSecret = new SecretNameReferenceBuilder(servingCertKeyPairSecret);
        this._visitables.get("servingCertKeyPairSecret").add(this.servingCertKeyPairSecret);
    } else {
        this.servingCertKeyPairSecret = null;
        this._visitables.get("servingCertKeyPairSecret").remove(this.servingCertKeyPairSecret);
    }
    return (A) this;
  }
  public class ServingCertKeyPairSecretNested<N> extends SecretNameReferenceFluent<ServingCertKeyPairSecretNested<N>> implements Nested<N>{
  
    SecretNameReferenceBuilder builder;
  
    ServingCertKeyPairSecretNested(SecretNameReference item) {
      this.builder = new SecretNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ComponentRouteSpecFluent.this.withServingCertKeyPairSecret(builder.build());
    }
    
    public N endServingCertKeyPairSecret() {
      return and();
    }
    
  }
}