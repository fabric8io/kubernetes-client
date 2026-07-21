package io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1;

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
public class AuthFluent<A extends io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AuthFluent<A>> extends BaseFluent<A>{

  private String accessKey;
  private Map<String,Object> additionalProperties;
  private SecretBuilder secret;
  private String secretKey;
  private String serviceAccountName;

  public AuthFluent() {
  }
  
  public AuthFluent(Auth instance) {
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
  
  public Secret buildSecret() {
    return this.secret != null ? this.secret.build() : null;
  }
  
  protected void copyInstance(Auth instance) {
    instance = instance != null ? instance : new Auth();
    if (instance != null) {
        this.withAccessKey(instance.getAccessKey());
        this.withSecret(instance.getSecret());
        this.withSecretKey(instance.getSecretKey());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SecretNested<A> editOrNewSecret() {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(new SecretBuilder().build()));
  }
  
  public SecretNested<A> editOrNewSecretLike(Secret item) {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(item));
  }
  
  public SecretNested<A> editSecret() {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(null));
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
    AuthFluent that = (AuthFluent) o;
    if (!(Objects.equals(accessKey, that.accessKey))) {
      return false;
    }
    if (!(Objects.equals(secret, that.secret))) {
      return false;
    }
    if (!(Objects.equals(secretKey, that.secretKey))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAccessKey() {
    return this.accessKey;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getSecretKey() {
    return this.secretKey;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public boolean hasAccessKey() {
    return this.accessKey != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasSecret() {
    return this.secret != null;
  }
  
  public boolean hasSecretKey() {
    return this.secretKey != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public int hashCode() {
    return Objects.hash(accessKey, secret, secretKey, serviceAccountName, additionalProperties);
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
    if (!(accessKey == null)) {
        sb.append("accessKey:");
        sb.append(accessKey);
        sb.append(",");
    }
    if (!(secret == null)) {
        sb.append("secret:");
        sb.append(secret);
        sb.append(",");
    }
    if (!(secretKey == null)) {
        sb.append("secretKey:");
        sb.append(secretKey);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccessKey(String accessKey) {
    this.accessKey = accessKey;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public SecretNested<A> withNewSecret() {
    return new SecretNested(null);
  }
  
  public SecretNested<A> withNewSecretLike(Secret item) {
    return new SecretNested(item);
  }
  
  public A withSecret(Secret secret) {
    this._visitables.remove("secret");
    if (secret != null) {
        this.secret = new SecretBuilder(secret);
        this._visitables.get("secret").add(this.secret);
    } else {
        this.secret = null;
        this._visitables.get("secret").remove(this.secret);
    }
    return (A) this;
  }
  
  public A withSecretKey(String secretKey) {
    this.secretKey = secretKey;
    return (A) this;
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  public class SecretNested<N> extends SecretFluent<SecretNested<N>> implements Nested<N>{
  
    SecretBuilder builder;
  
    SecretNested(Secret item) {
      this.builder = new SecretBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthFluent.this.withSecret(builder.build());
    }
    
    public N endSecret() {
      return and();
    }
    
  }
}