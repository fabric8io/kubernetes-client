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
public class GenericControllerConfigFluent<A extends io.fabric8.openshift.api.model.config.v1.GenericControllerConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DelegatedAuthenticationBuilder authentication;
  private DelegatedAuthorizationBuilder authorization;
  private LeaderElectionBuilder leaderElection;
  private HTTPServingInfoBuilder servingInfo;

  public GenericControllerConfigFluent() {
  }
  
  public GenericControllerConfigFluent(GenericControllerConfig instance) {
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
  
  public LeaderElection buildLeaderElection() {
    return this.leaderElection != null ? this.leaderElection.build() : null;
  }
  
  public HTTPServingInfo buildServingInfo() {
    return this.servingInfo != null ? this.servingInfo.build() : null;
  }
  
  protected void copyInstance(GenericControllerConfig instance) {
    instance = instance != null ? instance : new GenericControllerConfig();
    if (instance != null) {
        this.withAuthentication(instance.getAuthentication());
        this.withAuthorization(instance.getAuthorization());
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
  
  public LeaderElectionNested<A> editLeaderElection() {
    return this.withNewLeaderElectionLike(Optional.ofNullable(this.buildLeaderElection()).orElse(null));
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
  
  public LeaderElectionNested<A> editOrNewLeaderElection() {
    return this.withNewLeaderElectionLike(Optional.ofNullable(this.buildLeaderElection()).orElse(new LeaderElectionBuilder().build()));
  }
  
  public LeaderElectionNested<A> editOrNewLeaderElectionLike(LeaderElection item) {
    return this.withNewLeaderElectionLike(Optional.ofNullable(this.buildLeaderElection()).orElse(item));
  }
  
  public ServingInfoNested<A> editOrNewServingInfo() {
    return this.withNewServingInfoLike(Optional.ofNullable(this.buildServingInfo()).orElse(new HTTPServingInfoBuilder().build()));
  }
  
  public ServingInfoNested<A> editOrNewServingInfoLike(HTTPServingInfo item) {
    return this.withNewServingInfoLike(Optional.ofNullable(this.buildServingInfo()).orElse(item));
  }
  
  public ServingInfoNested<A> editServingInfo() {
    return this.withNewServingInfoLike(Optional.ofNullable(this.buildServingInfo()).orElse(null));
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
    GenericControllerConfigFluent that = (GenericControllerConfigFluent) o;
    if (!(Objects.equals(authentication, that.authentication))) {
      return false;
    }
    if (!(Objects.equals(authorization, that.authorization))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthentication() {
    return this.authentication != null;
  }
  
  public boolean hasAuthorization() {
    return this.authorization != null;
  }
  
  public boolean hasLeaderElection() {
    return this.leaderElection != null;
  }
  
  public boolean hasServingInfo() {
    return this.servingInfo != null;
  }
  
  public int hashCode() {
    return Objects.hash(authentication, authorization, leaderElection, servingInfo, additionalProperties);
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
  
  public A withLeaderElection(LeaderElection leaderElection) {
    this._visitables.remove("leaderElection");
    if (leaderElection != null) {
        this.leaderElection = new LeaderElectionBuilder(leaderElection);
        this._visitables.get("leaderElection").add(this.leaderElection);
    } else {
        this.leaderElection = null;
        this._visitables.get("leaderElection").remove(this.leaderElection);
    }
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
  
  public LeaderElectionNested<A> withNewLeaderElection() {
    return new LeaderElectionNested(null);
  }
  
  public LeaderElectionNested<A> withNewLeaderElectionLike(LeaderElection item) {
    return new LeaderElectionNested(item);
  }
  
  public ServingInfoNested<A> withNewServingInfo() {
    return new ServingInfoNested(null);
  }
  
  public ServingInfoNested<A> withNewServingInfoLike(HTTPServingInfo item) {
    return new ServingInfoNested(item);
  }
  
  public A withServingInfo(HTTPServingInfo servingInfo) {
    this._visitables.remove("servingInfo");
    if (servingInfo != null) {
        this.servingInfo = new HTTPServingInfoBuilder(servingInfo);
        this._visitables.get("servingInfo").add(this.servingInfo);
    } else {
        this.servingInfo = null;
        this._visitables.get("servingInfo").remove(this.servingInfo);
    }
    return (A) this;
  }
  public class AuthenticationNested<N> extends DelegatedAuthenticationFluent<AuthenticationNested<N>> implements Nested<N>{
  
    DelegatedAuthenticationBuilder builder;
  
    AuthenticationNested(DelegatedAuthentication item) {
      this.builder = new DelegatedAuthenticationBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericControllerConfigFluent.this.withAuthentication(builder.build());
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
      return (N) GenericControllerConfigFluent.this.withAuthorization(builder.build());
    }
    
    public N endAuthorization() {
      return and();
    }
    
  }
  public class LeaderElectionNested<N> extends LeaderElectionFluent<LeaderElectionNested<N>> implements Nested<N>{
  
    LeaderElectionBuilder builder;
  
    LeaderElectionNested(LeaderElection item) {
      this.builder = new LeaderElectionBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericControllerConfigFluent.this.withLeaderElection(builder.build());
    }
    
    public N endLeaderElection() {
      return and();
    }
    
  }
  public class ServingInfoNested<N> extends HTTPServingInfoFluent<ServingInfoNested<N>> implements Nested<N>{
  
    HTTPServingInfoBuilder builder;
  
    ServingInfoNested(HTTPServingInfo item) {
      this.builder = new HTTPServingInfoBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericControllerConfigFluent.this.withServingInfo(builder.build());
    }
    
    public N endServingInfo() {
      return and();
    }
    
  }
}