package io.fabric8.knative.bindings.v1;

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
public class KafkaSASLSpecFluent<A extends io.fabric8.knative.bindings.v1.KafkaSASLSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean enable;
  private SecretValueFromSourceBuilder password;
  private SecretValueFromSourceBuilder roleARN;
  private SecretValueFromSourceBuilder tokenProvider;
  private SecretValueFromSourceBuilder type;
  private SecretValueFromSourceBuilder user;

  public KafkaSASLSpecFluent() {
  }
  
  public KafkaSASLSpecFluent(KafkaSASLSpec instance) {
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
  
  public SecretValueFromSource buildPassword() {
    return this.password != null ? this.password.build() : null;
  }
  
  public SecretValueFromSource buildRoleARN() {
    return this.roleARN != null ? this.roleARN.build() : null;
  }
  
  public SecretValueFromSource buildTokenProvider() {
    return this.tokenProvider != null ? this.tokenProvider.build() : null;
  }
  
  public SecretValueFromSource buildType() {
    return this.type != null ? this.type.build() : null;
  }
  
  public SecretValueFromSource buildUser() {
    return this.user != null ? this.user.build() : null;
  }
  
  protected void copyInstance(KafkaSASLSpec instance) {
    instance = instance != null ? instance : new KafkaSASLSpec();
    if (instance != null) {
        this.withEnable(instance.getEnable());
        this.withPassword(instance.getPassword());
        this.withRoleARN(instance.getRoleARN());
        this.withTokenProvider(instance.getTokenProvider());
        this.withType(instance.getType());
        this.withUser(instance.getUser());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PasswordNested<A> editOrNewPassword() {
    return this.withNewPasswordLike(Optional.ofNullable(this.buildPassword()).orElse(new SecretValueFromSourceBuilder().build()));
  }
  
  public PasswordNested<A> editOrNewPasswordLike(SecretValueFromSource item) {
    return this.withNewPasswordLike(Optional.ofNullable(this.buildPassword()).orElse(item));
  }
  
  public RoleARNNested<A> editOrNewRoleARN() {
    return this.withNewRoleARNLike(Optional.ofNullable(this.buildRoleARN()).orElse(new SecretValueFromSourceBuilder().build()));
  }
  
  public RoleARNNested<A> editOrNewRoleARNLike(SecretValueFromSource item) {
    return this.withNewRoleARNLike(Optional.ofNullable(this.buildRoleARN()).orElse(item));
  }
  
  public TokenProviderNested<A> editOrNewTokenProvider() {
    return this.withNewTokenProviderLike(Optional.ofNullable(this.buildTokenProvider()).orElse(new SecretValueFromSourceBuilder().build()));
  }
  
  public TokenProviderNested<A> editOrNewTokenProviderLike(SecretValueFromSource item) {
    return this.withNewTokenProviderLike(Optional.ofNullable(this.buildTokenProvider()).orElse(item));
  }
  
  public TypeNested<A> editOrNewType() {
    return this.withNewTypeLike(Optional.ofNullable(this.buildType()).orElse(new SecretValueFromSourceBuilder().build()));
  }
  
  public TypeNested<A> editOrNewTypeLike(SecretValueFromSource item) {
    return this.withNewTypeLike(Optional.ofNullable(this.buildType()).orElse(item));
  }
  
  public UserNested<A> editOrNewUser() {
    return this.withNewUserLike(Optional.ofNullable(this.buildUser()).orElse(new SecretValueFromSourceBuilder().build()));
  }
  
  public UserNested<A> editOrNewUserLike(SecretValueFromSource item) {
    return this.withNewUserLike(Optional.ofNullable(this.buildUser()).orElse(item));
  }
  
  public PasswordNested<A> editPassword() {
    return this.withNewPasswordLike(Optional.ofNullable(this.buildPassword()).orElse(null));
  }
  
  public RoleARNNested<A> editRoleARN() {
    return this.withNewRoleARNLike(Optional.ofNullable(this.buildRoleARN()).orElse(null));
  }
  
  public TokenProviderNested<A> editTokenProvider() {
    return this.withNewTokenProviderLike(Optional.ofNullable(this.buildTokenProvider()).orElse(null));
  }
  
  public TypeNested<A> editType() {
    return this.withNewTypeLike(Optional.ofNullable(this.buildType()).orElse(null));
  }
  
  public UserNested<A> editUser() {
    return this.withNewUserLike(Optional.ofNullable(this.buildUser()).orElse(null));
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
    KafkaSASLSpecFluent that = (KafkaSASLSpecFluent) o;
    if (!(Objects.equals(enable, that.enable))) {
      return false;
    }
    if (!(Objects.equals(password, that.password))) {
      return false;
    }
    if (!(Objects.equals(roleARN, that.roleARN))) {
      return false;
    }
    if (!(Objects.equals(tokenProvider, that.tokenProvider))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(user, that.user))) {
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
  
  public Boolean getEnable() {
    return this.enable;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEnable() {
    return this.enable != null;
  }
  
  public boolean hasPassword() {
    return this.password != null;
  }
  
  public boolean hasRoleARN() {
    return this.roleARN != null;
  }
  
  public boolean hasTokenProvider() {
    return this.tokenProvider != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasUser() {
    return this.user != null;
  }
  
  public int hashCode() {
    return Objects.hash(enable, password, roleARN, tokenProvider, type, user, additionalProperties);
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
    if (!(enable == null)) {
        sb.append("enable:");
        sb.append(enable);
        sb.append(",");
    }
    if (!(password == null)) {
        sb.append("password:");
        sb.append(password);
        sb.append(",");
    }
    if (!(roleARN == null)) {
        sb.append("roleARN:");
        sb.append(roleARN);
        sb.append(",");
    }
    if (!(tokenProvider == null)) {
        sb.append("tokenProvider:");
        sb.append(tokenProvider);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(user == null)) {
        sb.append("user:");
        sb.append(user);
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
  
  public A withEnable() {
    return withEnable(true);
  }
  
  public A withEnable(Boolean enable) {
    this.enable = enable;
    return (A) this;
  }
  
  public PasswordNested<A> withNewPassword() {
    return new PasswordNested(null);
  }
  
  public PasswordNested<A> withNewPasswordLike(SecretValueFromSource item) {
    return new PasswordNested(item);
  }
  
  public RoleARNNested<A> withNewRoleARN() {
    return new RoleARNNested(null);
  }
  
  public RoleARNNested<A> withNewRoleARNLike(SecretValueFromSource item) {
    return new RoleARNNested(item);
  }
  
  public TokenProviderNested<A> withNewTokenProvider() {
    return new TokenProviderNested(null);
  }
  
  public TokenProviderNested<A> withNewTokenProviderLike(SecretValueFromSource item) {
    return new TokenProviderNested(item);
  }
  
  public TypeNested<A> withNewType() {
    return new TypeNested(null);
  }
  
  public TypeNested<A> withNewTypeLike(SecretValueFromSource item) {
    return new TypeNested(item);
  }
  
  public UserNested<A> withNewUser() {
    return new UserNested(null);
  }
  
  public UserNested<A> withNewUserLike(SecretValueFromSource item) {
    return new UserNested(item);
  }
  
  public A withPassword(SecretValueFromSource password) {
    this._visitables.remove("password");
    if (password != null) {
        this.password = new SecretValueFromSourceBuilder(password);
        this._visitables.get("password").add(this.password);
    } else {
        this.password = null;
        this._visitables.get("password").remove(this.password);
    }
    return (A) this;
  }
  
  public A withRoleARN(SecretValueFromSource roleARN) {
    this._visitables.remove("roleARN");
    if (roleARN != null) {
        this.roleARN = new SecretValueFromSourceBuilder(roleARN);
        this._visitables.get("roleARN").add(this.roleARN);
    } else {
        this.roleARN = null;
        this._visitables.get("roleARN").remove(this.roleARN);
    }
    return (A) this;
  }
  
  public A withTokenProvider(SecretValueFromSource tokenProvider) {
    this._visitables.remove("tokenProvider");
    if (tokenProvider != null) {
        this.tokenProvider = new SecretValueFromSourceBuilder(tokenProvider);
        this._visitables.get("tokenProvider").add(this.tokenProvider);
    } else {
        this.tokenProvider = null;
        this._visitables.get("tokenProvider").remove(this.tokenProvider);
    }
    return (A) this;
  }
  
  public A withType(SecretValueFromSource type) {
    this._visitables.remove("type");
    if (type != null) {
        this.type = new SecretValueFromSourceBuilder(type);
        this._visitables.get("type").add(this.type);
    } else {
        this.type = null;
        this._visitables.get("type").remove(this.type);
    }
    return (A) this;
  }
  
  public A withUser(SecretValueFromSource user) {
    this._visitables.remove("user");
    if (user != null) {
        this.user = new SecretValueFromSourceBuilder(user);
        this._visitables.get("user").add(this.user);
    } else {
        this.user = null;
        this._visitables.get("user").remove(this.user);
    }
    return (A) this;
  }
  public class PasswordNested<N> extends SecretValueFromSourceFluent<PasswordNested<N>> implements Nested<N>{
  
    SecretValueFromSourceBuilder builder;
  
    PasswordNested(SecretValueFromSource item) {
      this.builder = new SecretValueFromSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaSASLSpecFluent.this.withPassword(builder.build());
    }
    
    public N endPassword() {
      return and();
    }
    
  }
  public class RoleARNNested<N> extends SecretValueFromSourceFluent<RoleARNNested<N>> implements Nested<N>{
  
    SecretValueFromSourceBuilder builder;
  
    RoleARNNested(SecretValueFromSource item) {
      this.builder = new SecretValueFromSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaSASLSpecFluent.this.withRoleARN(builder.build());
    }
    
    public N endRoleARN() {
      return and();
    }
    
  }
  public class TokenProviderNested<N> extends SecretValueFromSourceFluent<TokenProviderNested<N>> implements Nested<N>{
  
    SecretValueFromSourceBuilder builder;
  
    TokenProviderNested(SecretValueFromSource item) {
      this.builder = new SecretValueFromSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaSASLSpecFluent.this.withTokenProvider(builder.build());
    }
    
    public N endTokenProvider() {
      return and();
    }
    
  }
  public class TypeNested<N> extends SecretValueFromSourceFluent<TypeNested<N>> implements Nested<N>{
  
    SecretValueFromSourceBuilder builder;
  
    TypeNested(SecretValueFromSource item) {
      this.builder = new SecretValueFromSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaSASLSpecFluent.this.withType(builder.build());
    }
    
    public N endType() {
      return and();
    }
    
  }
  public class UserNested<N> extends SecretValueFromSourceFluent<UserNested<N>> implements Nested<N>{
  
    SecretValueFromSourceBuilder builder;
  
    UserNested(SecretValueFromSource item) {
      this.builder = new SecretValueFromSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) KafkaSASLSpecFluent.this.withUser(builder.build());
    }
    
    public N endUser() {
      return and();
    }
    
  }
}