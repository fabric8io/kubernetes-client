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
public class ACMEIssuerDNS01ProviderAcmeDNSFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderAcmeDNSFluent<A>> extends BaseFluent<A>{

  private SecretKeySelectorBuilder accountSecretRef;
  private Map<String,Object> additionalProperties;
  private String host;

  public ACMEIssuerDNS01ProviderAcmeDNSFluent() {
  }
  
  public ACMEIssuerDNS01ProviderAcmeDNSFluent(ACMEIssuerDNS01ProviderAcmeDNS instance) {
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
  
  public SecretKeySelector buildAccountSecretRef() {
    return this.accountSecretRef != null ? this.accountSecretRef.build() : null;
  }
  
  protected void copyInstance(ACMEIssuerDNS01ProviderAcmeDNS instance) {
    instance = instance != null ? instance : new ACMEIssuerDNS01ProviderAcmeDNS();
    if (instance != null) {
        this.withAccountSecretRef(instance.getAccountSecretRef());
        this.withHost(instance.getHost());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AccountSecretRefNested<A> editAccountSecretRef() {
    return this.withNewAccountSecretRefLike(Optional.ofNullable(this.buildAccountSecretRef()).orElse(null));
  }
  
  public AccountSecretRefNested<A> editOrNewAccountSecretRef() {
    return this.withNewAccountSecretRefLike(Optional.ofNullable(this.buildAccountSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public AccountSecretRefNested<A> editOrNewAccountSecretRefLike(SecretKeySelector item) {
    return this.withNewAccountSecretRefLike(Optional.ofNullable(this.buildAccountSecretRef()).orElse(item));
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
    ACMEIssuerDNS01ProviderAcmeDNSFluent that = (ACMEIssuerDNS01ProviderAcmeDNSFluent) o;
    if (!(Objects.equals(accountSecretRef, that.accountSecretRef))) {
      return false;
    }
    if (!(Objects.equals(host, that.host))) {
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
  
  public String getHost() {
    return this.host;
  }
  
  public boolean hasAccountSecretRef() {
    return this.accountSecretRef != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHost() {
    return this.host != null;
  }
  
  public int hashCode() {
    return Objects.hash(accountSecretRef, host, additionalProperties);
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
    if (!(accountSecretRef == null)) {
        sb.append("accountSecretRef:");
        sb.append(accountSecretRef);
        sb.append(",");
    }
    if (!(host == null)) {
        sb.append("host:");
        sb.append(host);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccountSecretRef(SecretKeySelector accountSecretRef) {
    this._visitables.remove("accountSecretRef");
    if (accountSecretRef != null) {
        this.accountSecretRef = new SecretKeySelectorBuilder(accountSecretRef);
        this._visitables.get("accountSecretRef").add(this.accountSecretRef);
    } else {
        this.accountSecretRef = null;
        this._visitables.get("accountSecretRef").remove(this.accountSecretRef);
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
  
  public A withHost(String host) {
    this.host = host;
    return (A) this;
  }
  
  public AccountSecretRefNested<A> withNewAccountSecretRef() {
    return new AccountSecretRefNested(null);
  }
  
  public A withNewAccountSecretRef(String key,String name) {
    return (A) this.withAccountSecretRef(new SecretKeySelector(key, name));
  }
  
  public AccountSecretRefNested<A> withNewAccountSecretRefLike(SecretKeySelector item) {
    return new AccountSecretRefNested(item);
  }
  public class AccountSecretRefNested<N> extends SecretKeySelectorFluent<AccountSecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    AccountSecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEIssuerDNS01ProviderAcmeDNSFluent.this.withAccountSecretRef(builder.build());
    }
    
    public N endAccountSecretRef() {
      return and();
    }
    
  }
}