package io.fabric8.certmanager.api.model.v1;

import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorBuilder;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorFluent;
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
public class PKCS12KeystoreFluent<A extends io.fabric8.certmanager.api.model.v1.PKCS12KeystoreFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean create;
  private String password;
  private SecretKeySelectorBuilder passwordSecretRef;
  private String profile;

  public PKCS12KeystoreFluent() {
  }
  
  public PKCS12KeystoreFluent(PKCS12Keystore instance) {
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
  
  public SecretKeySelector buildPasswordSecretRef() {
    return this.passwordSecretRef != null ? this.passwordSecretRef.build() : null;
  }
  
  protected void copyInstance(PKCS12Keystore instance) {
    instance = instance != null ? instance : new PKCS12Keystore();
    if (instance != null) {
        this.withCreate(instance.getCreate());
        this.withPassword(instance.getPassword());
        this.withPasswordSecretRef(instance.getPasswordSecretRef());
        this.withProfile(instance.getProfile());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PasswordSecretRefNested<A> editOrNewPasswordSecretRef() {
    return this.withNewPasswordSecretRefLike(Optional.ofNullable(this.buildPasswordSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public PasswordSecretRefNested<A> editOrNewPasswordSecretRefLike(SecretKeySelector item) {
    return this.withNewPasswordSecretRefLike(Optional.ofNullable(this.buildPasswordSecretRef()).orElse(item));
  }
  
  public PasswordSecretRefNested<A> editPasswordSecretRef() {
    return this.withNewPasswordSecretRefLike(Optional.ofNullable(this.buildPasswordSecretRef()).orElse(null));
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
    PKCS12KeystoreFluent that = (PKCS12KeystoreFluent) o;
    if (!(Objects.equals(create, that.create))) {
      return false;
    }
    if (!(Objects.equals(password, that.password))) {
      return false;
    }
    if (!(Objects.equals(passwordSecretRef, that.passwordSecretRef))) {
      return false;
    }
    if (!(Objects.equals(profile, that.profile))) {
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
  
  public Boolean getCreate() {
    return this.create;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public String getProfile() {
    return this.profile;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCreate() {
    return this.create != null;
  }
  
  public boolean hasPassword() {
    return this.password != null;
  }
  
  public boolean hasPasswordSecretRef() {
    return this.passwordSecretRef != null;
  }
  
  public boolean hasProfile() {
    return this.profile != null;
  }
  
  public int hashCode() {
    return Objects.hash(create, password, passwordSecretRef, profile, additionalProperties);
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
    if (!(create == null)) {
        sb.append("create:");
        sb.append(create);
        sb.append(",");
    }
    if (!(password == null)) {
        sb.append("password:");
        sb.append(password);
        sb.append(",");
    }
    if (!(passwordSecretRef == null)) {
        sb.append("passwordSecretRef:");
        sb.append(passwordSecretRef);
        sb.append(",");
    }
    if (!(profile == null)) {
        sb.append("profile:");
        sb.append(profile);
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
  
  public A withCreate() {
    return withCreate(true);
  }
  
  public A withCreate(Boolean create) {
    this.create = create;
    return (A) this;
  }
  
  public PasswordSecretRefNested<A> withNewPasswordSecretRef() {
    return new PasswordSecretRefNested(null);
  }
  
  public A withNewPasswordSecretRef(String key,String name) {
    return (A) this.withPasswordSecretRef(new SecretKeySelector(key, name));
  }
  
  public PasswordSecretRefNested<A> withNewPasswordSecretRefLike(SecretKeySelector item) {
    return new PasswordSecretRefNested(item);
  }
  
  public A withPassword(String password) {
    this.password = password;
    return (A) this;
  }
  
  public A withPasswordSecretRef(SecretKeySelector passwordSecretRef) {
    this._visitables.remove("passwordSecretRef");
    if (passwordSecretRef != null) {
        this.passwordSecretRef = new SecretKeySelectorBuilder(passwordSecretRef);
        this._visitables.get("passwordSecretRef").add(this.passwordSecretRef);
    } else {
        this.passwordSecretRef = null;
        this._visitables.get("passwordSecretRef").remove(this.passwordSecretRef);
    }
    return (A) this;
  }
  
  public A withProfile(String profile) {
    this.profile = profile;
    return (A) this;
  }
  public class PasswordSecretRefNested<N> extends SecretKeySelectorFluent<PasswordSecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    PasswordSecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PKCS12KeystoreFluent.this.withPasswordSecretRef(builder.build());
    }
    
    public N endPasswordSecretRef() {
      return and();
    }
    
  }
}