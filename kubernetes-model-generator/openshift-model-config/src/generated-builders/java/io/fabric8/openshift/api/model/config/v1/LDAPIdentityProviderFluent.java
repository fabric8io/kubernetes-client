package io.fabric8.openshift.api.model.config.v1;

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
public class LDAPIdentityProviderFluent<A extends io.fabric8.openshift.api.model.config.v1.LDAPIdentityProviderFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LDAPAttributeMappingBuilder attributes;
  private String bindDN;
  private SecretNameReferenceBuilder bindPassword;
  private ConfigMapNameReferenceBuilder ca;
  private Boolean insecure;
  private String url;

  public LDAPIdentityProviderFluent() {
  }
  
  public LDAPIdentityProviderFluent(LDAPIdentityProvider instance) {
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
  
  public LDAPAttributeMapping buildAttributes() {
    return this.attributes != null ? this.attributes.build() : null;
  }
  
  public SecretNameReference buildBindPassword() {
    return this.bindPassword != null ? this.bindPassword.build() : null;
  }
  
  public ConfigMapNameReference buildCa() {
    return this.ca != null ? this.ca.build() : null;
  }
  
  protected void copyInstance(LDAPIdentityProvider instance) {
    instance = instance != null ? instance : new LDAPIdentityProvider();
    if (instance != null) {
        this.withAttributes(instance.getAttributes());
        this.withBindDN(instance.getBindDN());
        this.withBindPassword(instance.getBindPassword());
        this.withCa(instance.getCa());
        this.withInsecure(instance.getInsecure());
        this.withUrl(instance.getUrl());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AttributesNested<A> editAttributes() {
    return this.withNewAttributesLike(Optional.ofNullable(this.buildAttributes()).orElse(null));
  }
  
  public BindPasswordNested<A> editBindPassword() {
    return this.withNewBindPasswordLike(Optional.ofNullable(this.buildBindPassword()).orElse(null));
  }
  
  public CaNested<A> editCa() {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(null));
  }
  
  public AttributesNested<A> editOrNewAttributes() {
    return this.withNewAttributesLike(Optional.ofNullable(this.buildAttributes()).orElse(new LDAPAttributeMappingBuilder().build()));
  }
  
  public AttributesNested<A> editOrNewAttributesLike(LDAPAttributeMapping item) {
    return this.withNewAttributesLike(Optional.ofNullable(this.buildAttributes()).orElse(item));
  }
  
  public BindPasswordNested<A> editOrNewBindPassword() {
    return this.withNewBindPasswordLike(Optional.ofNullable(this.buildBindPassword()).orElse(new SecretNameReferenceBuilder().build()));
  }
  
  public BindPasswordNested<A> editOrNewBindPasswordLike(SecretNameReference item) {
    return this.withNewBindPasswordLike(Optional.ofNullable(this.buildBindPassword()).orElse(item));
  }
  
  public CaNested<A> editOrNewCa() {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(new ConfigMapNameReferenceBuilder().build()));
  }
  
  public CaNested<A> editOrNewCaLike(ConfigMapNameReference item) {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(item));
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
    LDAPIdentityProviderFluent that = (LDAPIdentityProviderFluent) o;
    if (!(Objects.equals(attributes, that.attributes))) {
      return false;
    }
    if (!(Objects.equals(bindDN, that.bindDN))) {
      return false;
    }
    if (!(Objects.equals(bindPassword, that.bindPassword))) {
      return false;
    }
    if (!(Objects.equals(ca, that.ca))) {
      return false;
    }
    if (!(Objects.equals(insecure, that.insecure))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
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
  
  public String getBindDN() {
    return this.bindDN;
  }
  
  public Boolean getInsecure() {
    return this.insecure;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttributes() {
    return this.attributes != null;
  }
  
  public boolean hasBindDN() {
    return this.bindDN != null;
  }
  
  public boolean hasBindPassword() {
    return this.bindPassword != null;
  }
  
  public boolean hasCa() {
    return this.ca != null;
  }
  
  public boolean hasInsecure() {
    return this.insecure != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(attributes, bindDN, bindPassword, ca, insecure, url, additionalProperties);
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
    if (!(attributes == null)) {
        sb.append("attributes:");
        sb.append(attributes);
        sb.append(",");
    }
    if (!(bindDN == null)) {
        sb.append("bindDN:");
        sb.append(bindDN);
        sb.append(",");
    }
    if (!(bindPassword == null)) {
        sb.append("bindPassword:");
        sb.append(bindPassword);
        sb.append(",");
    }
    if (!(ca == null)) {
        sb.append("ca:");
        sb.append(ca);
        sb.append(",");
    }
    if (!(insecure == null)) {
        sb.append("insecure:");
        sb.append(insecure);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
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
  
  public A withAttributes(LDAPAttributeMapping attributes) {
    this._visitables.remove("attributes");
    if (attributes != null) {
        this.attributes = new LDAPAttributeMappingBuilder(attributes);
        this._visitables.get("attributes").add(this.attributes);
    } else {
        this.attributes = null;
        this._visitables.get("attributes").remove(this.attributes);
    }
    return (A) this;
  }
  
  public A withBindDN(String bindDN) {
    this.bindDN = bindDN;
    return (A) this;
  }
  
  public A withBindPassword(SecretNameReference bindPassword) {
    this._visitables.remove("bindPassword");
    if (bindPassword != null) {
        this.bindPassword = new SecretNameReferenceBuilder(bindPassword);
        this._visitables.get("bindPassword").add(this.bindPassword);
    } else {
        this.bindPassword = null;
        this._visitables.get("bindPassword").remove(this.bindPassword);
    }
    return (A) this;
  }
  
  public A withCa(ConfigMapNameReference ca) {
    this._visitables.remove("ca");
    if (ca != null) {
        this.ca = new ConfigMapNameReferenceBuilder(ca);
        this._visitables.get("ca").add(this.ca);
    } else {
        this.ca = null;
        this._visitables.get("ca").remove(this.ca);
    }
    return (A) this;
  }
  
  public A withInsecure() {
    return withInsecure(true);
  }
  
  public A withInsecure(Boolean insecure) {
    this.insecure = insecure;
    return (A) this;
  }
  
  public AttributesNested<A> withNewAttributes() {
    return new AttributesNested(null);
  }
  
  public AttributesNested<A> withNewAttributesLike(LDAPAttributeMapping item) {
    return new AttributesNested(item);
  }
  
  public BindPasswordNested<A> withNewBindPassword() {
    return new BindPasswordNested(null);
  }
  
  public A withNewBindPassword(String name) {
    return (A) this.withBindPassword(new SecretNameReference(name));
  }
  
  public BindPasswordNested<A> withNewBindPasswordLike(SecretNameReference item) {
    return new BindPasswordNested(item);
  }
  
  public CaNested<A> withNewCa() {
    return new CaNested(null);
  }
  
  public A withNewCa(String name) {
    return (A) this.withCa(new ConfigMapNameReference(name));
  }
  
  public CaNested<A> withNewCaLike(ConfigMapNameReference item) {
    return new CaNested(item);
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  public class AttributesNested<N> extends LDAPAttributeMappingFluent<AttributesNested<N>> implements Nested<N>{
  
    LDAPAttributeMappingBuilder builder;
  
    AttributesNested(LDAPAttributeMapping item) {
      this.builder = new LDAPAttributeMappingBuilder(this, item);
    }
  
    public N and() {
      return (N) LDAPIdentityProviderFluent.this.withAttributes(builder.build());
    }
    
    public N endAttributes() {
      return and();
    }
    
  }
  public class BindPasswordNested<N> extends SecretNameReferenceFluent<BindPasswordNested<N>> implements Nested<N>{
  
    SecretNameReferenceBuilder builder;
  
    BindPasswordNested(SecretNameReference item) {
      this.builder = new SecretNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) LDAPIdentityProviderFluent.this.withBindPassword(builder.build());
    }
    
    public N endBindPassword() {
      return and();
    }
    
  }
  public class CaNested<N> extends ConfigMapNameReferenceFluent<CaNested<N>> implements Nested<N>{
  
    ConfigMapNameReferenceBuilder builder;
  
    CaNested(ConfigMapNameReference item) {
      this.builder = new ConfigMapNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) LDAPIdentityProviderFluent.this.withCa(builder.build());
    }
    
    public N endCa() {
      return and();
    }
    
  }
}