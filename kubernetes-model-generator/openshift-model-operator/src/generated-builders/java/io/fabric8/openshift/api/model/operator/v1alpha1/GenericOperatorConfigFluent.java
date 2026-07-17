package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.config.v1.HTTPServingInfo;
import io.fabric8.openshift.api.model.config.v1.LeaderElection;
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
public class GenericOperatorConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1alpha1.GenericOperatorConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private DelegatedAuthenticationBuilder authentication;
  private DelegatedAuthorizationBuilder authorization;
  private String kind;
  private LeaderElection leaderElection;
  private HTTPServingInfo servingInfo;

  public GenericOperatorConfigFluent() {
  }
  
  public GenericOperatorConfigFluent(GenericOperatorConfig instance) {
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
  
  public DelegatedAuthentication buildAuthentication() {
    return this.authentication != null ? this.authentication.build() : null;
  }
  
  public DelegatedAuthorization buildAuthorization() {
    return this.authorization != null ? this.authorization.build() : null;
  }
  
  protected void copyInstance(GenericOperatorConfig instance) {
    instance = instance != null ? instance : new GenericOperatorConfig();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withAuthentication(instance.getAuthentication());
        this.withAuthorization(instance.getAuthorization());
        this.withKind(instance.getKind());
        this.withLeaderElection(instance.getLeaderElection());
        this.withServingInfo(instance.getServingInfo());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthenticationNested<A> editAuthentication() {
    return this.withNewAuthenticationLike(Optional.ofNullable(this.buildAuthentication()).orElse(null));
  }
  
  public AuthorizationNested<A> editAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(null));
  }
  
  public AuthenticationNested<A> editOrNewAuthentication() {
    return this.withNewAuthenticationLike(Optional.ofNullable(this.buildAuthentication()).orElse(new DelegatedAuthenticationBuilder().build()));
  }
  
  public AuthenticationNested<A> editOrNewAuthenticationLike(DelegatedAuthentication item) {
    return this.withNewAuthenticationLike(Optional.ofNullable(this.buildAuthentication()).orElse(item));
  }
  
  public AuthorizationNested<A> editOrNewAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(new DelegatedAuthorizationBuilder().build()));
  }
  
  public AuthorizationNested<A> editOrNewAuthorizationLike(DelegatedAuthorization item) {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(item));
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
    GenericOperatorConfigFluent that = (GenericOperatorConfigFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(authentication, that.authentication))) {
      return false;
    }
    if (!(Objects.equals(authorization, that.authorization))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(leaderElection, that.leaderElection))) {
      return false;
    }
    if (!(Objects.equals(servingInfo, that.servingInfo))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public LeaderElection getLeaderElection() {
    return this.leaderElection;
  }
  
  public HTTPServingInfo getServingInfo() {
    return this.servingInfo;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasAuthentication() {
    return this.authentication != null;
  }
  
  public boolean hasAuthorization() {
    return this.authorization != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasLeaderElection() {
    return this.leaderElection != null;
  }
  
  public boolean hasServingInfo() {
    return this.servingInfo != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, authentication, authorization, kind, leaderElection, servingInfo, additionalProperties);
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
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(authentication == null)) {
        sb.append("authentication:");
        sb.append(authentication);
        sb.append(",");
    }
    if (!(authorization == null)) {
        sb.append("authorization:");
        sb.append(authorization);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(leaderElection == null)) {
        sb.append("leaderElection:");
        sb.append(leaderElection);
        sb.append(",");
    }
    if (!(servingInfo == null)) {
        sb.append("servingInfo:");
        sb.append(servingInfo);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withAuthentication(DelegatedAuthentication authentication) {
    this._visitables.remove("authentication");
    if (authentication != null) {
        this.authentication = new DelegatedAuthenticationBuilder(authentication);
        this._visitables.get("authentication").add(this.authentication);
    } else {
        this.authentication = null;
        this._visitables.get("authentication").remove(this.authentication);
    }
    return (A) this;
  }
  
  public A withAuthorization(DelegatedAuthorization authorization) {
    this._visitables.remove("authorization");
    if (authorization != null) {
        this.authorization = new DelegatedAuthorizationBuilder(authorization);
        this._visitables.get("authorization").add(this.authorization);
    } else {
        this.authorization = null;
        this._visitables.get("authorization").remove(this.authorization);
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withLeaderElection(LeaderElection leaderElection) {
    this.leaderElection = leaderElection;
    return (A) this;
  }
  
  public AuthenticationNested<A> withNewAuthentication() {
    return new AuthenticationNested(null);
  }
  
  public A withNewAuthentication(Boolean disabled) {
    return (A) this.withAuthentication(new DelegatedAuthentication(disabled));
  }
  
  public AuthenticationNested<A> withNewAuthenticationLike(DelegatedAuthentication item) {
    return new AuthenticationNested(item);
  }
  
  public AuthorizationNested<A> withNewAuthorization() {
    return new AuthorizationNested(null);
  }
  
  public A withNewAuthorization(Boolean disabled) {
    return (A) this.withAuthorization(new DelegatedAuthorization(disabled));
  }
  
  public AuthorizationNested<A> withNewAuthorizationLike(DelegatedAuthorization item) {
    return new AuthorizationNested(item);
  }
  
  public A withServingInfo(HTTPServingInfo servingInfo) {
    this.servingInfo = servingInfo;
    return (A) this;
  }
  public class AuthenticationNested<N> extends DelegatedAuthenticationFluent<AuthenticationNested<N>> implements Nested<N>{
  
    DelegatedAuthenticationBuilder builder;
  
    AuthenticationNested(DelegatedAuthentication item) {
      this.builder = new DelegatedAuthenticationBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericOperatorConfigFluent.this.withAuthentication(builder.build());
    }
    
    public N endAuthentication() {
      return and();
    }
    
  }
  public class AuthorizationNested<N> extends DelegatedAuthorizationFluent<AuthorizationNested<N>> implements Nested<N>{
  
    DelegatedAuthorizationBuilder builder;
  
    AuthorizationNested(DelegatedAuthorization item) {
      this.builder = new DelegatedAuthorizationBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericOperatorConfigFluent.this.withAuthorization(builder.build());
    }
    
    public N endAuthorization() {
      return and();
    }
    
  }
}