package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class TokenIssuerFluent<A extends io.fabric8.openshift.api.model.config.v1.TokenIssuerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> audiences = new ArrayList<String>();
  private ConfigMapNameReferenceBuilder issuerCertificateAuthority;
  private String issuerURL;

  public TokenIssuerFluent() {
  }
  
  public TokenIssuerFluent(TokenIssuer instance) {
    this.copyInstance(instance);
  }

  public A addAllToAudiences(Collection<String> items) {
    if (this.audiences == null) {
      this.audiences = new ArrayList();
    }
    for (String item : items) {
      this.audiences.add(item);
    }
    return (A) this;
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
  
  public A addToAudiences(String... items) {
    if (this.audiences == null) {
      this.audiences = new ArrayList();
    }
    for (String item : items) {
      this.audiences.add(item);
    }
    return (A) this;
  }
  
  public A addToAudiences(int index,String item) {
    if (this.audiences == null) {
      this.audiences = new ArrayList();
    }
    this.audiences.add(index, item);
    return (A) this;
  }
  
  public ConfigMapNameReference buildIssuerCertificateAuthority() {
    return this.issuerCertificateAuthority != null ? this.issuerCertificateAuthority.build() : null;
  }
  
  protected void copyInstance(TokenIssuer instance) {
    instance = instance != null ? instance : new TokenIssuer();
    if (instance != null) {
        this.withAudiences(instance.getAudiences());
        this.withIssuerCertificateAuthority(instance.getIssuerCertificateAuthority());
        this.withIssuerURL(instance.getIssuerURL());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IssuerCertificateAuthorityNested<A> editIssuerCertificateAuthority() {
    return this.withNewIssuerCertificateAuthorityLike(Optional.ofNullable(this.buildIssuerCertificateAuthority()).orElse(null));
  }
  
  public IssuerCertificateAuthorityNested<A> editOrNewIssuerCertificateAuthority() {
    return this.withNewIssuerCertificateAuthorityLike(Optional.ofNullable(this.buildIssuerCertificateAuthority()).orElse(new ConfigMapNameReferenceBuilder().build()));
  }
  
  public IssuerCertificateAuthorityNested<A> editOrNewIssuerCertificateAuthorityLike(ConfigMapNameReference item) {
    return this.withNewIssuerCertificateAuthorityLike(Optional.ofNullable(this.buildIssuerCertificateAuthority()).orElse(item));
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
    TokenIssuerFluent that = (TokenIssuerFluent) o;
    if (!(Objects.equals(audiences, that.audiences))) {
      return false;
    }
    if (!(Objects.equals(issuerCertificateAuthority, that.issuerCertificateAuthority))) {
      return false;
    }
    if (!(Objects.equals(issuerURL, that.issuerURL))) {
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
  
  public String getAudience(int index) {
    return this.audiences.get(index);
  }
  
  public List<String> getAudiences() {
    return this.audiences;
  }
  
  public String getFirstAudience() {
    return this.audiences.get(0);
  }
  
  public String getIssuerURL() {
    return this.issuerURL;
  }
  
  public String getLastAudience() {
    return this.audiences.get(audiences.size() - 1);
  }
  
  public String getMatchingAudience(Predicate<String> predicate) {
      for (String item : audiences) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAudiences() {
    return this.audiences != null && !(this.audiences.isEmpty());
  }
  
  public boolean hasIssuerCertificateAuthority() {
    return this.issuerCertificateAuthority != null;
  }
  
  public boolean hasIssuerURL() {
    return this.issuerURL != null;
  }
  
  public boolean hasMatchingAudience(Predicate<String> predicate) {
      for (String item : audiences) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(audiences, issuerCertificateAuthority, issuerURL, additionalProperties);
  }
  
  public A removeAllFromAudiences(Collection<String> items) {
    if (this.audiences == null) {
      return (A) this;
    }
    for (String item : items) {
      this.audiences.remove(item);
    }
    return (A) this;
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
  
  public A removeFromAudiences(String... items) {
    if (this.audiences == null) {
      return (A) this;
    }
    for (String item : items) {
      this.audiences.remove(item);
    }
    return (A) this;
  }
  
  public A setToAudiences(int index,String item) {
    if (this.audiences == null) {
      this.audiences = new ArrayList();
    }
    this.audiences.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(audiences == null) && !(audiences.isEmpty())) {
        sb.append("audiences:");
        sb.append(audiences);
        sb.append(",");
    }
    if (!(issuerCertificateAuthority == null)) {
        sb.append("issuerCertificateAuthority:");
        sb.append(issuerCertificateAuthority);
        sb.append(",");
    }
    if (!(issuerURL == null)) {
        sb.append("issuerURL:");
        sb.append(issuerURL);
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
  
  public A withAudiences(List<String> audiences) {
    if (audiences != null) {
        this.audiences = new ArrayList();
        for (String item : audiences) {
          this.addToAudiences(item);
        }
    } else {
      this.audiences = null;
    }
    return (A) this;
  }
  
  public A withAudiences(String... audiences) {
    if (this.audiences != null) {
        this.audiences.clear();
        _visitables.remove("audiences");
    }
    if (audiences != null) {
      for (String item : audiences) {
        this.addToAudiences(item);
      }
    }
    return (A) this;
  }
  
  public A withIssuerCertificateAuthority(ConfigMapNameReference issuerCertificateAuthority) {
    this._visitables.remove("issuerCertificateAuthority");
    if (issuerCertificateAuthority != null) {
        this.issuerCertificateAuthority = new ConfigMapNameReferenceBuilder(issuerCertificateAuthority);
        this._visitables.get("issuerCertificateAuthority").add(this.issuerCertificateAuthority);
    } else {
        this.issuerCertificateAuthority = null;
        this._visitables.get("issuerCertificateAuthority").remove(this.issuerCertificateAuthority);
    }
    return (A) this;
  }
  
  public A withIssuerURL(String issuerURL) {
    this.issuerURL = issuerURL;
    return (A) this;
  }
  
  public IssuerCertificateAuthorityNested<A> withNewIssuerCertificateAuthority() {
    return new IssuerCertificateAuthorityNested(null);
  }
  
  public A withNewIssuerCertificateAuthority(String name) {
    return (A) this.withIssuerCertificateAuthority(new ConfigMapNameReference(name));
  }
  
  public IssuerCertificateAuthorityNested<A> withNewIssuerCertificateAuthorityLike(ConfigMapNameReference item) {
    return new IssuerCertificateAuthorityNested(item);
  }
  public class IssuerCertificateAuthorityNested<N> extends ConfigMapNameReferenceFluent<IssuerCertificateAuthorityNested<N>> implements Nested<N>{
  
    ConfigMapNameReferenceBuilder builder;
  
    IssuerCertificateAuthorityNested(ConfigMapNameReference item) {
      this.builder = new ConfigMapNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) TokenIssuerFluent.this.withIssuerCertificateAuthority(builder.build());
    }
    
    public N endIssuerCertificateAuthority() {
      return and();
    }
    
  }
}