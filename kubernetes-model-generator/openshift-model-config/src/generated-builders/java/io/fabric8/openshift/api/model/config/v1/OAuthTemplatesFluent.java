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
public class OAuthTemplatesFluent<A extends io.fabric8.openshift.api.model.config.v1.OAuthTemplatesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SecretNameReferenceBuilder error;
  private SecretNameReferenceBuilder login;
  private SecretNameReferenceBuilder providerSelection;

  public OAuthTemplatesFluent() {
  }
  
  public OAuthTemplatesFluent(OAuthTemplates instance) {
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
  
  public SecretNameReference buildError() {
    return this.error != null ? this.error.build() : null;
  }
  
  public SecretNameReference buildLogin() {
    return this.login != null ? this.login.build() : null;
  }
  
  public SecretNameReference buildProviderSelection() {
    return this.providerSelection != null ? this.providerSelection.build() : null;
  }
  
  protected void copyInstance(OAuthTemplates instance) {
    instance = instance != null ? instance : new OAuthTemplates();
    if (instance != null) {
        this.withError(instance.getError());
        this.withLogin(instance.getLogin());
        this.withProviderSelection(instance.getProviderSelection());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ErrorNested<A> editError() {
    return this.withNewErrorLike(Optional.ofNullable(this.buildError()).orElse(null));
  }
  
  public LoginNested<A> editLogin() {
    return this.withNewLoginLike(Optional.ofNullable(this.buildLogin()).orElse(null));
  }
  
  public ErrorNested<A> editOrNewError() {
    return this.withNewErrorLike(Optional.ofNullable(this.buildError()).orElse(new SecretNameReferenceBuilder().build()));
  }
  
  public ErrorNested<A> editOrNewErrorLike(SecretNameReference item) {
    return this.withNewErrorLike(Optional.ofNullable(this.buildError()).orElse(item));
  }
  
  public LoginNested<A> editOrNewLogin() {
    return this.withNewLoginLike(Optional.ofNullable(this.buildLogin()).orElse(new SecretNameReferenceBuilder().build()));
  }
  
  public LoginNested<A> editOrNewLoginLike(SecretNameReference item) {
    return this.withNewLoginLike(Optional.ofNullable(this.buildLogin()).orElse(item));
  }
  
  public ProviderSelectionNested<A> editOrNewProviderSelection() {
    return this.withNewProviderSelectionLike(Optional.ofNullable(this.buildProviderSelection()).orElse(new SecretNameReferenceBuilder().build()));
  }
  
  public ProviderSelectionNested<A> editOrNewProviderSelectionLike(SecretNameReference item) {
    return this.withNewProviderSelectionLike(Optional.ofNullable(this.buildProviderSelection()).orElse(item));
  }
  
  public ProviderSelectionNested<A> editProviderSelection() {
    return this.withNewProviderSelectionLike(Optional.ofNullable(this.buildProviderSelection()).orElse(null));
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
    OAuthTemplatesFluent that = (OAuthTemplatesFluent) o;
    if (!(Objects.equals(error, that.error))) {
      return false;
    }
    if (!(Objects.equals(login, that.login))) {
      return false;
    }
    if (!(Objects.equals(providerSelection, that.providerSelection))) {
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
  
  public boolean hasError() {
    return this.error != null;
  }
  
  public boolean hasLogin() {
    return this.login != null;
  }
  
  public boolean hasProviderSelection() {
    return this.providerSelection != null;
  }
  
  public int hashCode() {
    return Objects.hash(error, login, providerSelection, additionalProperties);
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
    if (!(error == null)) {
        sb.append("error:");
        sb.append(error);
        sb.append(",");
    }
    if (!(login == null)) {
        sb.append("login:");
        sb.append(login);
        sb.append(",");
    }
    if (!(providerSelection == null)) {
        sb.append("providerSelection:");
        sb.append(providerSelection);
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
  
  public A withError(SecretNameReference error) {
    this._visitables.remove("error");
    if (error != null) {
        this.error = new SecretNameReferenceBuilder(error);
        this._visitables.get("error").add(this.error);
    } else {
        this.error = null;
        this._visitables.get("error").remove(this.error);
    }
    return (A) this;
  }
  
  public A withLogin(SecretNameReference login) {
    this._visitables.remove("login");
    if (login != null) {
        this.login = new SecretNameReferenceBuilder(login);
        this._visitables.get("login").add(this.login);
    } else {
        this.login = null;
        this._visitables.get("login").remove(this.login);
    }
    return (A) this;
  }
  
  public ErrorNested<A> withNewError() {
    return new ErrorNested(null);
  }
  
  public A withNewError(String name) {
    return (A) this.withError(new SecretNameReference(name));
  }
  
  public ErrorNested<A> withNewErrorLike(SecretNameReference item) {
    return new ErrorNested(item);
  }
  
  public LoginNested<A> withNewLogin() {
    return new LoginNested(null);
  }
  
  public A withNewLogin(String name) {
    return (A) this.withLogin(new SecretNameReference(name));
  }
  
  public LoginNested<A> withNewLoginLike(SecretNameReference item) {
    return new LoginNested(item);
  }
  
  public ProviderSelectionNested<A> withNewProviderSelection() {
    return new ProviderSelectionNested(null);
  }
  
  public A withNewProviderSelection(String name) {
    return (A) this.withProviderSelection(new SecretNameReference(name));
  }
  
  public ProviderSelectionNested<A> withNewProviderSelectionLike(SecretNameReference item) {
    return new ProviderSelectionNested(item);
  }
  
  public A withProviderSelection(SecretNameReference providerSelection) {
    this._visitables.remove("providerSelection");
    if (providerSelection != null) {
        this.providerSelection = new SecretNameReferenceBuilder(providerSelection);
        this._visitables.get("providerSelection").add(this.providerSelection);
    } else {
        this.providerSelection = null;
        this._visitables.get("providerSelection").remove(this.providerSelection);
    }
    return (A) this;
  }
  public class ErrorNested<N> extends SecretNameReferenceFluent<ErrorNested<N>> implements Nested<N>{
  
    SecretNameReferenceBuilder builder;
  
    ErrorNested(SecretNameReference item) {
      this.builder = new SecretNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) OAuthTemplatesFluent.this.withError(builder.build());
    }
    
    public N endError() {
      return and();
    }
    
  }
  public class LoginNested<N> extends SecretNameReferenceFluent<LoginNested<N>> implements Nested<N>{
  
    SecretNameReferenceBuilder builder;
  
    LoginNested(SecretNameReference item) {
      this.builder = new SecretNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) OAuthTemplatesFluent.this.withLogin(builder.build());
    }
    
    public N endLogin() {
      return and();
    }
    
  }
  public class ProviderSelectionNested<N> extends SecretNameReferenceFluent<ProviderSelectionNested<N>> implements Nested<N>{
  
    SecretNameReferenceBuilder builder;
  
    ProviderSelectionNested(SecretNameReference item) {
      this.builder = new SecretNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) OAuthTemplatesFluent.this.withProviderSelection(builder.build());
    }
    
    public N endProviderSelection() {
      return and();
    }
    
  }
}