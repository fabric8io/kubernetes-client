package io.fabric8.openshift.api.model;

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
public class RoleBindingRestrictionSpecFluent<A extends io.fabric8.openshift.api.model.RoleBindingRestrictionSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private GroupRestrictionBuilder grouprestriction;
  private ServiceAccountRestrictionBuilder serviceaccountrestriction;
  private UserRestrictionBuilder userrestriction;

  public RoleBindingRestrictionSpecFluent() {
  }
  
  public RoleBindingRestrictionSpecFluent(RoleBindingRestrictionSpec instance) {
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
  
  public GroupRestriction buildGrouprestriction() {
    return this.grouprestriction != null ? this.grouprestriction.build() : null;
  }
  
  public ServiceAccountRestriction buildServiceaccountrestriction() {
    return this.serviceaccountrestriction != null ? this.serviceaccountrestriction.build() : null;
  }
  
  public UserRestriction buildUserrestriction() {
    return this.userrestriction != null ? this.userrestriction.build() : null;
  }
  
  protected void copyInstance(RoleBindingRestrictionSpec instance) {
    instance = instance != null ? instance : new RoleBindingRestrictionSpec();
    if (instance != null) {
        this.withGrouprestriction(instance.getGrouprestriction());
        this.withServiceaccountrestriction(instance.getServiceaccountrestriction());
        this.withUserrestriction(instance.getUserrestriction());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GrouprestrictionNested<A> editGrouprestriction() {
    return this.withNewGrouprestrictionLike(Optional.ofNullable(this.buildGrouprestriction()).orElse(null));
  }
  
  public GrouprestrictionNested<A> editOrNewGrouprestriction() {
    return this.withNewGrouprestrictionLike(Optional.ofNullable(this.buildGrouprestriction()).orElse(new GroupRestrictionBuilder().build()));
  }
  
  public GrouprestrictionNested<A> editOrNewGrouprestrictionLike(GroupRestriction item) {
    return this.withNewGrouprestrictionLike(Optional.ofNullable(this.buildGrouprestriction()).orElse(item));
  }
  
  public ServiceaccountrestrictionNested<A> editOrNewServiceaccountrestriction() {
    return this.withNewServiceaccountrestrictionLike(Optional.ofNullable(this.buildServiceaccountrestriction()).orElse(new ServiceAccountRestrictionBuilder().build()));
  }
  
  public ServiceaccountrestrictionNested<A> editOrNewServiceaccountrestrictionLike(ServiceAccountRestriction item) {
    return this.withNewServiceaccountrestrictionLike(Optional.ofNullable(this.buildServiceaccountrestriction()).orElse(item));
  }
  
  public UserrestrictionNested<A> editOrNewUserrestriction() {
    return this.withNewUserrestrictionLike(Optional.ofNullable(this.buildUserrestriction()).orElse(new UserRestrictionBuilder().build()));
  }
  
  public UserrestrictionNested<A> editOrNewUserrestrictionLike(UserRestriction item) {
    return this.withNewUserrestrictionLike(Optional.ofNullable(this.buildUserrestriction()).orElse(item));
  }
  
  public ServiceaccountrestrictionNested<A> editServiceaccountrestriction() {
    return this.withNewServiceaccountrestrictionLike(Optional.ofNullable(this.buildServiceaccountrestriction()).orElse(null));
  }
  
  public UserrestrictionNested<A> editUserrestriction() {
    return this.withNewUserrestrictionLike(Optional.ofNullable(this.buildUserrestriction()).orElse(null));
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
    RoleBindingRestrictionSpecFluent that = (RoleBindingRestrictionSpecFluent) o;
    if (!(Objects.equals(grouprestriction, that.grouprestriction))) {
      return false;
    }
    if (!(Objects.equals(serviceaccountrestriction, that.serviceaccountrestriction))) {
      return false;
    }
    if (!(Objects.equals(userrestriction, that.userrestriction))) {
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
  
  public boolean hasGrouprestriction() {
    return this.grouprestriction != null;
  }
  
  public boolean hasServiceaccountrestriction() {
    return this.serviceaccountrestriction != null;
  }
  
  public boolean hasUserrestriction() {
    return this.userrestriction != null;
  }
  
  public int hashCode() {
    return Objects.hash(grouprestriction, serviceaccountrestriction, userrestriction, additionalProperties);
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
    if (!(grouprestriction == null)) {
        sb.append("grouprestriction:");
        sb.append(grouprestriction);
        sb.append(",");
    }
    if (!(serviceaccountrestriction == null)) {
        sb.append("serviceaccountrestriction:");
        sb.append(serviceaccountrestriction);
        sb.append(",");
    }
    if (!(userrestriction == null)) {
        sb.append("userrestriction:");
        sb.append(userrestriction);
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
  
  public A withGrouprestriction(GroupRestriction grouprestriction) {
    this._visitables.remove("grouprestriction");
    if (grouprestriction != null) {
        this.grouprestriction = new GroupRestrictionBuilder(grouprestriction);
        this._visitables.get("grouprestriction").add(this.grouprestriction);
    } else {
        this.grouprestriction = null;
        this._visitables.get("grouprestriction").remove(this.grouprestriction);
    }
    return (A) this;
  }
  
  public GrouprestrictionNested<A> withNewGrouprestriction() {
    return new GrouprestrictionNested(null);
  }
  
  public GrouprestrictionNested<A> withNewGrouprestrictionLike(GroupRestriction item) {
    return new GrouprestrictionNested(item);
  }
  
  public ServiceaccountrestrictionNested<A> withNewServiceaccountrestriction() {
    return new ServiceaccountrestrictionNested(null);
  }
  
  public ServiceaccountrestrictionNested<A> withNewServiceaccountrestrictionLike(ServiceAccountRestriction item) {
    return new ServiceaccountrestrictionNested(item);
  }
  
  public UserrestrictionNested<A> withNewUserrestriction() {
    return new UserrestrictionNested(null);
  }
  
  public UserrestrictionNested<A> withNewUserrestrictionLike(UserRestriction item) {
    return new UserrestrictionNested(item);
  }
  
  public A withServiceaccountrestriction(ServiceAccountRestriction serviceaccountrestriction) {
    this._visitables.remove("serviceaccountrestriction");
    if (serviceaccountrestriction != null) {
        this.serviceaccountrestriction = new ServiceAccountRestrictionBuilder(serviceaccountrestriction);
        this._visitables.get("serviceaccountrestriction").add(this.serviceaccountrestriction);
    } else {
        this.serviceaccountrestriction = null;
        this._visitables.get("serviceaccountrestriction").remove(this.serviceaccountrestriction);
    }
    return (A) this;
  }
  
  public A withUserrestriction(UserRestriction userrestriction) {
    this._visitables.remove("userrestriction");
    if (userrestriction != null) {
        this.userrestriction = new UserRestrictionBuilder(userrestriction);
        this._visitables.get("userrestriction").add(this.userrestriction);
    } else {
        this.userrestriction = null;
        this._visitables.get("userrestriction").remove(this.userrestriction);
    }
    return (A) this;
  }
  public class GrouprestrictionNested<N> extends GroupRestrictionFluent<GrouprestrictionNested<N>> implements Nested<N>{
  
    GroupRestrictionBuilder builder;
  
    GrouprestrictionNested(GroupRestriction item) {
      this.builder = new GroupRestrictionBuilder(this, item);
    }
  
    public N and() {
      return (N) RoleBindingRestrictionSpecFluent.this.withGrouprestriction(builder.build());
    }
    
    public N endGrouprestriction() {
      return and();
    }
    
  }
  public class ServiceaccountrestrictionNested<N> extends ServiceAccountRestrictionFluent<ServiceaccountrestrictionNested<N>> implements Nested<N>{
  
    ServiceAccountRestrictionBuilder builder;
  
    ServiceaccountrestrictionNested(ServiceAccountRestriction item) {
      this.builder = new ServiceAccountRestrictionBuilder(this, item);
    }
  
    public N and() {
      return (N) RoleBindingRestrictionSpecFluent.this.withServiceaccountrestriction(builder.build());
    }
    
    public N endServiceaccountrestriction() {
      return and();
    }
    
  }
  public class UserrestrictionNested<N> extends UserRestrictionFluent<UserrestrictionNested<N>> implements Nested<N>{
  
    UserRestrictionBuilder builder;
  
    UserrestrictionNested(UserRestriction item) {
      this.builder = new UserRestrictionBuilder(this, item);
    }
  
    public N and() {
      return (N) RoleBindingRestrictionSpecFluent.this.withUserrestriction(builder.build());
    }
    
    public N endUserrestriction() {
      return and();
    }
    
  }
}