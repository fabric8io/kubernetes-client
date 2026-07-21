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
public class ACMEIssuerDNS01ProviderDigitalOceanFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderDigitalOceanFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SecretKeySelectorBuilder tokenSecretRef;

  public ACMEIssuerDNS01ProviderDigitalOceanFluent() {
  }
  
  public ACMEIssuerDNS01ProviderDigitalOceanFluent(ACMEIssuerDNS01ProviderDigitalOcean instance) {
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
  
  public SecretKeySelector buildTokenSecretRef() {
    return this.tokenSecretRef != null ? this.tokenSecretRef.build() : null;
  }
  
  protected void copyInstance(ACMEIssuerDNS01ProviderDigitalOcean instance) {
    instance = instance != null ? instance : new ACMEIssuerDNS01ProviderDigitalOcean();
    if (instance != null) {
        this.withTokenSecretRef(instance.getTokenSecretRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TokenSecretRefNested<A> editOrNewTokenSecretRef() {
    return this.withNewTokenSecretRefLike(Optional.ofNullable(this.buildTokenSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public TokenSecretRefNested<A> editOrNewTokenSecretRefLike(SecretKeySelector item) {
    return this.withNewTokenSecretRefLike(Optional.ofNullable(this.buildTokenSecretRef()).orElse(item));
  }
  
  public TokenSecretRefNested<A> editTokenSecretRef() {
    return this.withNewTokenSecretRefLike(Optional.ofNullable(this.buildTokenSecretRef()).orElse(null));
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
    ACMEIssuerDNS01ProviderDigitalOceanFluent that = (ACMEIssuerDNS01ProviderDigitalOceanFluent) o;
    if (!(Objects.equals(tokenSecretRef, that.tokenSecretRef))) {
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
  
  public boolean hasTokenSecretRef() {
    return this.tokenSecretRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(tokenSecretRef, additionalProperties);
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
    if (!(tokenSecretRef == null)) {
        sb.append("tokenSecretRef:");
        sb.append(tokenSecretRef);
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
  
  public TokenSecretRefNested<A> withNewTokenSecretRef() {
    return new TokenSecretRefNested(null);
  }
  
  public A withNewTokenSecretRef(String key,String name) {
    return (A) this.withTokenSecretRef(new SecretKeySelector(key, name));
  }
  
  public TokenSecretRefNested<A> withNewTokenSecretRefLike(SecretKeySelector item) {
    return new TokenSecretRefNested(item);
  }
  
  public A withTokenSecretRef(SecretKeySelector tokenSecretRef) {
    this._visitables.remove("tokenSecretRef");
    if (tokenSecretRef != null) {
        this.tokenSecretRef = new SecretKeySelectorBuilder(tokenSecretRef);
        this._visitables.get("tokenSecretRef").add(this.tokenSecretRef);
    } else {
        this.tokenSecretRef = null;
        this._visitables.get("tokenSecretRef").remove(this.tokenSecretRef);
    }
    return (A) this;
  }
  public class TokenSecretRefNested<N> extends SecretKeySelectorFluent<TokenSecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    TokenSecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEIssuerDNS01ProviderDigitalOceanFluent.this.withTokenSecretRef(builder.build());
    }
    
    public N endTokenSecretRef() {
      return and();
    }
    
  }
}