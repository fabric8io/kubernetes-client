package io.fabric8.openshift.api.model;

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
public class WebHookTriggerFluent<A extends io.fabric8.openshift.api.model.WebHookTriggerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean allowEnv;
  private String secret;
  private SecretLocalReferenceBuilder secretReference;

  public WebHookTriggerFluent() {
  }
  
  public WebHookTriggerFluent(WebHookTrigger instance) {
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
  
  public SecretLocalReference buildSecretReference() {
    return this.secretReference != null ? this.secretReference.build() : null;
  }
  
  protected void copyInstance(WebHookTrigger instance) {
    instance = instance != null ? instance : new WebHookTrigger();
    if (instance != null) {
        this.withAllowEnv(instance.getAllowEnv());
        this.withSecret(instance.getSecret());
        this.withSecretReference(instance.getSecretReference());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SecretReferenceNested<A> editOrNewSecretReference() {
    return this.withNewSecretReferenceLike(Optional.ofNullable(this.buildSecretReference()).orElse(new SecretLocalReferenceBuilder().build()));
  }
  
  public SecretReferenceNested<A> editOrNewSecretReferenceLike(SecretLocalReference item) {
    return this.withNewSecretReferenceLike(Optional.ofNullable(this.buildSecretReference()).orElse(item));
  }
  
  public SecretReferenceNested<A> editSecretReference() {
    return this.withNewSecretReferenceLike(Optional.ofNullable(this.buildSecretReference()).orElse(null));
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
    WebHookTriggerFluent that = (WebHookTriggerFluent) o;
    if (!(Objects.equals(allowEnv, that.allowEnv))) {
      return false;
    }
    if (!(Objects.equals(secret, that.secret))) {
      return false;
    }
    if (!(Objects.equals(secretReference, that.secretReference))) {
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
  
  public Boolean getAllowEnv() {
    return this.allowEnv;
  }
  
  public String getSecret() {
    return this.secret;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowEnv() {
    return this.allowEnv != null;
  }
  
  public boolean hasSecret() {
    return this.secret != null;
  }
  
  public boolean hasSecretReference() {
    return this.secretReference != null;
  }
  
  public int hashCode() {
    return Objects.hash(allowEnv, secret, secretReference, additionalProperties);
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
    if (!(allowEnv == null)) {
        sb.append("allowEnv:");
        sb.append(allowEnv);
        sb.append(",");
    }
    if (!(secret == null)) {
        sb.append("secret:");
        sb.append(secret);
        sb.append(",");
    }
    if (!(secretReference == null)) {
        sb.append("secretReference:");
        sb.append(secretReference);
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
  
  public A withAllowEnv() {
    return withAllowEnv(true);
  }
  
  public A withAllowEnv(Boolean allowEnv) {
    this.allowEnv = allowEnv;
    return (A) this;
  }
  
  public SecretReferenceNested<A> withNewSecretReference() {
    return new SecretReferenceNested(null);
  }
  
  public A withNewSecretReference(String name) {
    return (A) this.withSecretReference(new SecretLocalReference(name));
  }
  
  public SecretReferenceNested<A> withNewSecretReferenceLike(SecretLocalReference item) {
    return new SecretReferenceNested(item);
  }
  
  public A withSecret(String secret) {
    this.secret = secret;
    return (A) this;
  }
  
  public A withSecretReference(SecretLocalReference secretReference) {
    this._visitables.remove("secretReference");
    if (secretReference != null) {
        this.secretReference = new SecretLocalReferenceBuilder(secretReference);
        this._visitables.get("secretReference").add(this.secretReference);
    } else {
        this.secretReference = null;
        this._visitables.get("secretReference").remove(this.secretReference);
    }
    return (A) this;
  }
  public class SecretReferenceNested<N> extends SecretLocalReferenceFluent<SecretReferenceNested<N>> implements Nested<N>{
  
    SecretLocalReferenceBuilder builder;
  
    SecretReferenceNested(SecretLocalReference item) {
      this.builder = new SecretLocalReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) WebHookTriggerFluent.this.withSecretReference(builder.build());
    }
    
    public N endSecretReference() {
      return and();
    }
    
  }
}