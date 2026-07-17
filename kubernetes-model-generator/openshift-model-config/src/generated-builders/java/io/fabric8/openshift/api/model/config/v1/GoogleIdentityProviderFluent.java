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
public class GoogleIdentityProviderFluent<A extends io.fabric8.openshift.api.model.config.v1.GoogleIdentityProviderFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clientID;
  private SecretNameReferenceBuilder clientSecret;
  private String hostedDomain;

  public GoogleIdentityProviderFluent() {
  }
  
  public GoogleIdentityProviderFluent(GoogleIdentityProvider instance) {
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
  
  public SecretNameReference buildClientSecret() {
    return this.clientSecret != null ? this.clientSecret.build() : null;
  }
  
  protected void copyInstance(GoogleIdentityProvider instance) {
    instance = instance != null ? instance : new GoogleIdentityProvider();
    if (instance != null) {
        this.withClientID(instance.getClientID());
        this.withClientSecret(instance.getClientSecret());
        this.withHostedDomain(instance.getHostedDomain());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClientSecretNested<A> editClientSecret() {
    return this.withNewClientSecretLike(Optional.ofNullable(this.buildClientSecret()).orElse(null));
  }
  
  public ClientSecretNested<A> editOrNewClientSecret() {
    return this.withNewClientSecretLike(Optional.ofNullable(this.buildClientSecret()).orElse(new SecretNameReferenceBuilder().build()));
  }
  
  public ClientSecretNested<A> editOrNewClientSecretLike(SecretNameReference item) {
    return this.withNewClientSecretLike(Optional.ofNullable(this.buildClientSecret()).orElse(item));
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
    GoogleIdentityProviderFluent that = (GoogleIdentityProviderFluent) o;
    if (!(Objects.equals(clientID, that.clientID))) {
      return false;
    }
    if (!(Objects.equals(clientSecret, that.clientSecret))) {
      return false;
    }
    if (!(Objects.equals(hostedDomain, that.hostedDomain))) {
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
  
  public String getClientID() {
    return this.clientID;
  }
  
  public String getHostedDomain() {
    return this.hostedDomain;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClientID() {
    return this.clientID != null;
  }
  
  public boolean hasClientSecret() {
    return this.clientSecret != null;
  }
  
  public boolean hasHostedDomain() {
    return this.hostedDomain != null;
  }
  
  public int hashCode() {
    return Objects.hash(clientID, clientSecret, hostedDomain, additionalProperties);
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
    if (!(clientID == null)) {
        sb.append("clientID:");
        sb.append(clientID);
        sb.append(",");
    }
    if (!(clientSecret == null)) {
        sb.append("clientSecret:");
        sb.append(clientSecret);
        sb.append(",");
    }
    if (!(hostedDomain == null)) {
        sb.append("hostedDomain:");
        sb.append(hostedDomain);
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
  
  public A withClientID(String clientID) {
    this.clientID = clientID;
    return (A) this;
  }
  
  public A withClientSecret(SecretNameReference clientSecret) {
    this._visitables.remove("clientSecret");
    if (clientSecret != null) {
        this.clientSecret = new SecretNameReferenceBuilder(clientSecret);
        this._visitables.get("clientSecret").add(this.clientSecret);
    } else {
        this.clientSecret = null;
        this._visitables.get("clientSecret").remove(this.clientSecret);
    }
    return (A) this;
  }
  
  public A withHostedDomain(String hostedDomain) {
    this.hostedDomain = hostedDomain;
    return (A) this;
  }
  
  public ClientSecretNested<A> withNewClientSecret() {
    return new ClientSecretNested(null);
  }
  
  public A withNewClientSecret(String name) {
    return (A) this.withClientSecret(new SecretNameReference(name));
  }
  
  public ClientSecretNested<A> withNewClientSecretLike(SecretNameReference item) {
    return new ClientSecretNested(item);
  }
  public class ClientSecretNested<N> extends SecretNameReferenceFluent<ClientSecretNested<N>> implements Nested<N>{
  
    SecretNameReferenceBuilder builder;
  
    ClientSecretNested(SecretNameReference item) {
      this.builder = new SecretNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) GoogleIdentityProviderFluent.this.withClientSecret(builder.build());
    }
    
    public N endClientSecret() {
      return and();
    }
    
  }
}