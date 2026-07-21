package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorBuilder;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorFluent;
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
public class ACMEIssuerDNS01ProviderAkamaiFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderAkamaiFluent<A>> extends BaseFluent<A>{

  private SecretKeySelectorBuilder accessTokenSecretRef;
  private Map<String,Object> additionalProperties;
  private SecretKeySelectorBuilder clientSecretSecretRef;
  private SecretKeySelectorBuilder clientTokenSecretRef;
  private String serviceConsumerDomain;

  public ACMEIssuerDNS01ProviderAkamaiFluent() {
  }
  
  public ACMEIssuerDNS01ProviderAkamaiFluent(ACMEIssuerDNS01ProviderAkamai instance) {
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
  
  public SecretKeySelector buildAccessTokenSecretRef() {
    return this.accessTokenSecretRef != null ? this.accessTokenSecretRef.build() : null;
  }
  
  public SecretKeySelector buildClientSecretSecretRef() {
    return this.clientSecretSecretRef != null ? this.clientSecretSecretRef.build() : null;
  }
  
  public SecretKeySelector buildClientTokenSecretRef() {
    return this.clientTokenSecretRef != null ? this.clientTokenSecretRef.build() : null;
  }
  
  protected void copyInstance(ACMEIssuerDNS01ProviderAkamai instance) {
    instance = instance != null ? instance : new ACMEIssuerDNS01ProviderAkamai();
    if (instance != null) {
        this.withAccessTokenSecretRef(instance.getAccessTokenSecretRef());
        this.withClientSecretSecretRef(instance.getClientSecretSecretRef());
        this.withClientTokenSecretRef(instance.getClientTokenSecretRef());
        this.withServiceConsumerDomain(instance.getServiceConsumerDomain());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AccessTokenSecretRefNested<A> editAccessTokenSecretRef() {
    return this.withNewAccessTokenSecretRefLike(Optional.ofNullable(this.buildAccessTokenSecretRef()).orElse(null));
  }
  
  public ClientSecretSecretRefNested<A> editClientSecretSecretRef() {
    return this.withNewClientSecretSecretRefLike(Optional.ofNullable(this.buildClientSecretSecretRef()).orElse(null));
  }
  
  public ClientTokenSecretRefNested<A> editClientTokenSecretRef() {
    return this.withNewClientTokenSecretRefLike(Optional.ofNullable(this.buildClientTokenSecretRef()).orElse(null));
  }
  
  public AccessTokenSecretRefNested<A> editOrNewAccessTokenSecretRef() {
    return this.withNewAccessTokenSecretRefLike(Optional.ofNullable(this.buildAccessTokenSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public AccessTokenSecretRefNested<A> editOrNewAccessTokenSecretRefLike(SecretKeySelector item) {
    return this.withNewAccessTokenSecretRefLike(Optional.ofNullable(this.buildAccessTokenSecretRef()).orElse(item));
  }
  
  public ClientSecretSecretRefNested<A> editOrNewClientSecretSecretRef() {
    return this.withNewClientSecretSecretRefLike(Optional.ofNullable(this.buildClientSecretSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public ClientSecretSecretRefNested<A> editOrNewClientSecretSecretRefLike(SecretKeySelector item) {
    return this.withNewClientSecretSecretRefLike(Optional.ofNullable(this.buildClientSecretSecretRef()).orElse(item));
  }
  
  public ClientTokenSecretRefNested<A> editOrNewClientTokenSecretRef() {
    return this.withNewClientTokenSecretRefLike(Optional.ofNullable(this.buildClientTokenSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public ClientTokenSecretRefNested<A> editOrNewClientTokenSecretRefLike(SecretKeySelector item) {
    return this.withNewClientTokenSecretRefLike(Optional.ofNullable(this.buildClientTokenSecretRef()).orElse(item));
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
    ACMEIssuerDNS01ProviderAkamaiFluent that = (ACMEIssuerDNS01ProviderAkamaiFluent) o;
    if (!(Objects.equals(accessTokenSecretRef, that.accessTokenSecretRef))) {
      return false;
    }
    if (!(Objects.equals(clientSecretSecretRef, that.clientSecretSecretRef))) {
      return false;
    }
    if (!(Objects.equals(clientTokenSecretRef, that.clientTokenSecretRef))) {
      return false;
    }
    if (!(Objects.equals(serviceConsumerDomain, that.serviceConsumerDomain))) {
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
  
  public String getServiceConsumerDomain() {
    return this.serviceConsumerDomain;
  }
  
  public boolean hasAccessTokenSecretRef() {
    return this.accessTokenSecretRef != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClientSecretSecretRef() {
    return this.clientSecretSecretRef != null;
  }
  
  public boolean hasClientTokenSecretRef() {
    return this.clientTokenSecretRef != null;
  }
  
  public boolean hasServiceConsumerDomain() {
    return this.serviceConsumerDomain != null;
  }
  
  public int hashCode() {
    return Objects.hash(accessTokenSecretRef, clientSecretSecretRef, clientTokenSecretRef, serviceConsumerDomain, additionalProperties);
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
    if (!(accessTokenSecretRef == null)) {
        sb.append("accessTokenSecretRef:");
        sb.append(accessTokenSecretRef);
        sb.append(",");
    }
    if (!(clientSecretSecretRef == null)) {
        sb.append("clientSecretSecretRef:");
        sb.append(clientSecretSecretRef);
        sb.append(",");
    }
    if (!(clientTokenSecretRef == null)) {
        sb.append("clientTokenSecretRef:");
        sb.append(clientTokenSecretRef);
        sb.append(",");
    }
    if (!(serviceConsumerDomain == null)) {
        sb.append("serviceConsumerDomain:");
        sb.append(serviceConsumerDomain);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccessTokenSecretRef(SecretKeySelector accessTokenSecretRef) {
    this._visitables.remove("accessTokenSecretRef");
    if (accessTokenSecretRef != null) {
        this.accessTokenSecretRef = new SecretKeySelectorBuilder(accessTokenSecretRef);
        this._visitables.get("accessTokenSecretRef").add(this.accessTokenSecretRef);
    } else {
        this.accessTokenSecretRef = null;
        this._visitables.get("accessTokenSecretRef").remove(this.accessTokenSecretRef);
    }
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
  
  public A withClientSecretSecretRef(SecretKeySelector clientSecretSecretRef) {
    this._visitables.remove("clientSecretSecretRef");
    if (clientSecretSecretRef != null) {
        this.clientSecretSecretRef = new SecretKeySelectorBuilder(clientSecretSecretRef);
        this._visitables.get("clientSecretSecretRef").add(this.clientSecretSecretRef);
    } else {
        this.clientSecretSecretRef = null;
        this._visitables.get("clientSecretSecretRef").remove(this.clientSecretSecretRef);
    }
    return (A) this;
  }
  
  public A withClientTokenSecretRef(SecretKeySelector clientTokenSecretRef) {
    this._visitables.remove("clientTokenSecretRef");
    if (clientTokenSecretRef != null) {
        this.clientTokenSecretRef = new SecretKeySelectorBuilder(clientTokenSecretRef);
        this._visitables.get("clientTokenSecretRef").add(this.clientTokenSecretRef);
    } else {
        this.clientTokenSecretRef = null;
        this._visitables.get("clientTokenSecretRef").remove(this.clientTokenSecretRef);
    }
    return (A) this;
  }
  
  public AccessTokenSecretRefNested<A> withNewAccessTokenSecretRef() {
    return new AccessTokenSecretRefNested(null);
  }
  
  public A withNewAccessTokenSecretRef(String key,String name) {
    return (A) this.withAccessTokenSecretRef(new SecretKeySelector(key, name));
  }
  
  public AccessTokenSecretRefNested<A> withNewAccessTokenSecretRefLike(SecretKeySelector item) {
    return new AccessTokenSecretRefNested(item);
  }
  
  public ClientSecretSecretRefNested<A> withNewClientSecretSecretRef() {
    return new ClientSecretSecretRefNested(null);
  }
  
  public A withNewClientSecretSecretRef(String key,String name) {
    return (A) this.withClientSecretSecretRef(new SecretKeySelector(key, name));
  }
  
  public ClientSecretSecretRefNested<A> withNewClientSecretSecretRefLike(SecretKeySelector item) {
    return new ClientSecretSecretRefNested(item);
  }
  
  public ClientTokenSecretRefNested<A> withNewClientTokenSecretRef() {
    return new ClientTokenSecretRefNested(null);
  }
  
  public A withNewClientTokenSecretRef(String key,String name) {
    return (A) this.withClientTokenSecretRef(new SecretKeySelector(key, name));
  }
  
  public ClientTokenSecretRefNested<A> withNewClientTokenSecretRefLike(SecretKeySelector item) {
    return new ClientTokenSecretRefNested(item);
  }
  
  public A withServiceConsumerDomain(String serviceConsumerDomain) {
    this.serviceConsumerDomain = serviceConsumerDomain;
    return (A) this;
  }
  public class AccessTokenSecretRefNested<N> extends SecretKeySelectorFluent<AccessTokenSecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    AccessTokenSecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEIssuerDNS01ProviderAkamaiFluent.this.withAccessTokenSecretRef(builder.build());
    }
    
    public N endAccessTokenSecretRef() {
      return and();
    }
    
  }
  public class ClientSecretSecretRefNested<N> extends SecretKeySelectorFluent<ClientSecretSecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    ClientSecretSecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEIssuerDNS01ProviderAkamaiFluent.this.withClientSecretSecretRef(builder.build());
    }
    
    public N endClientSecretSecretRef() {
      return and();
    }
    
  }
  public class ClientTokenSecretRefNested<N> extends SecretKeySelectorFluent<ClientTokenSecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    ClientTokenSecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEIssuerDNS01ProviderAkamaiFluent.this.withClientTokenSecretRef(builder.build());
    }
    
    public N endClientTokenSecretRef() {
      return and();
    }
    
  }
}