package io.fabric8.kubernetes.api.model.flowcontrol.v1beta1;

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
public class SubjectFluent<A extends io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.SubjectFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private GroupSubjectBuilder group;
  private String kind;
  private ServiceAccountSubjectBuilder serviceAccount;
  private UserSubjectBuilder user;

  public SubjectFluent() {
  }
  
  public SubjectFluent(Subject instance) {
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
  
  public GroupSubject buildGroup() {
    return this.group != null ? this.group.build() : null;
  }
  
  public ServiceAccountSubject buildServiceAccount() {
    return this.serviceAccount != null ? this.serviceAccount.build() : null;
  }
  
  public UserSubject buildUser() {
    return this.user != null ? this.user.build() : null;
  }
  
  protected void copyInstance(Subject instance) {
    instance = instance != null ? instance : new Subject();
    if (instance != null) {
        this.withGroup(instance.getGroup());
        this.withKind(instance.getKind());
        this.withServiceAccount(instance.getServiceAccount());
        this.withUser(instance.getUser());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GroupNested<A> editGroup() {
    return this.withNewGroupLike(Optional.ofNullable(this.buildGroup()).orElse(null));
  }
  
  public GroupNested<A> editOrNewGroup() {
    return this.withNewGroupLike(Optional.ofNullable(this.buildGroup()).orElse(new GroupSubjectBuilder().build()));
  }
  
  public GroupNested<A> editOrNewGroupLike(GroupSubject item) {
    return this.withNewGroupLike(Optional.ofNullable(this.buildGroup()).orElse(item));
  }
  
  public ServiceAccountNested<A> editOrNewServiceAccount() {
    return this.withNewServiceAccountLike(Optional.ofNullable(this.buildServiceAccount()).orElse(new ServiceAccountSubjectBuilder().build()));
  }
  
  public ServiceAccountNested<A> editOrNewServiceAccountLike(ServiceAccountSubject item) {
    return this.withNewServiceAccountLike(Optional.ofNullable(this.buildServiceAccount()).orElse(item));
  }
  
  public UserNested<A> editOrNewUser() {
    return this.withNewUserLike(Optional.ofNullable(this.buildUser()).orElse(new UserSubjectBuilder().build()));
  }
  
  public UserNested<A> editOrNewUserLike(UserSubject item) {
    return this.withNewUserLike(Optional.ofNullable(this.buildUser()).orElse(item));
  }
  
  public ServiceAccountNested<A> editServiceAccount() {
    return this.withNewServiceAccountLike(Optional.ofNullable(this.buildServiceAccount()).orElse(null));
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
    SubjectFluent that = (SubjectFluent) o;
    if (!(Objects.equals(group, that.group))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(serviceAccount, that.serviceAccount))) {
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
  
  public String getKind() {
    return this.kind;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGroup() {
    return this.group != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasServiceAccount() {
    return this.serviceAccount != null;
  }
  
  public boolean hasUser() {
    return this.user != null;
  }
  
  public int hashCode() {
    return Objects.hash(group, kind, serviceAccount, user, additionalProperties);
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
    if (!(group == null)) {
        sb.append("group:");
        sb.append(group);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(serviceAccount == null)) {
        sb.append("serviceAccount:");
        sb.append(serviceAccount);
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
  
  public A withGroup(GroupSubject group) {
    this._visitables.remove("group");
    if (group != null) {
        this.group = new GroupSubjectBuilder(group);
        this._visitables.get("group").add(this.group);
    } else {
        this.group = null;
        this._visitables.get("group").remove(this.group);
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public GroupNested<A> withNewGroup() {
    return new GroupNested(null);
  }
  
  public A withNewGroup(String name) {
    return (A) this.withGroup(new GroupSubject(name));
  }
  
  public GroupNested<A> withNewGroupLike(GroupSubject item) {
    return new GroupNested(item);
  }
  
  public ServiceAccountNested<A> withNewServiceAccount() {
    return new ServiceAccountNested(null);
  }
  
  public A withNewServiceAccount(String name,String namespace) {
    return (A) this.withServiceAccount(new ServiceAccountSubject(name, namespace));
  }
  
  public ServiceAccountNested<A> withNewServiceAccountLike(ServiceAccountSubject item) {
    return new ServiceAccountNested(item);
  }
  
  public UserNested<A> withNewUser() {
    return new UserNested(null);
  }
  
  public A withNewUser(String name) {
    return (A) this.withUser(new UserSubject(name));
  }
  
  public UserNested<A> withNewUserLike(UserSubject item) {
    return new UserNested(item);
  }
  
  public A withServiceAccount(ServiceAccountSubject serviceAccount) {
    this._visitables.remove("serviceAccount");
    if (serviceAccount != null) {
        this.serviceAccount = new ServiceAccountSubjectBuilder(serviceAccount);
        this._visitables.get("serviceAccount").add(this.serviceAccount);
    } else {
        this.serviceAccount = null;
        this._visitables.get("serviceAccount").remove(this.serviceAccount);
    }
    return (A) this;
  }
  
  public A withUser(UserSubject user) {
    this._visitables.remove("user");
    if (user != null) {
        this.user = new UserSubjectBuilder(user);
        this._visitables.get("user").add(this.user);
    } else {
        this.user = null;
        this._visitables.get("user").remove(this.user);
    }
    return (A) this;
  }
  public class GroupNested<N> extends GroupSubjectFluent<GroupNested<N>> implements Nested<N>{
  
    GroupSubjectBuilder builder;
  
    GroupNested(GroupSubject item) {
      this.builder = new GroupSubjectBuilder(this, item);
    }
  
    public N and() {
      return (N) SubjectFluent.this.withGroup(builder.build());
    }
    
    public N endGroup() {
      return and();
    }
    
  }
  public class ServiceAccountNested<N> extends ServiceAccountSubjectFluent<ServiceAccountNested<N>> implements Nested<N>{
  
    ServiceAccountSubjectBuilder builder;
  
    ServiceAccountNested(ServiceAccountSubject item) {
      this.builder = new ServiceAccountSubjectBuilder(this, item);
    }
  
    public N and() {
      return (N) SubjectFluent.this.withServiceAccount(builder.build());
    }
    
    public N endServiceAccount() {
      return and();
    }
    
  }
  public class UserNested<N> extends UserSubjectFluent<UserNested<N>> implements Nested<N>{
  
    UserSubjectBuilder builder;
  
    UserNested(UserSubject item) {
      this.builder = new UserSubjectBuilder(this, item);
    }
  
    public N and() {
      return (N) SubjectFluent.this.withUser(builder.build());
    }
    
    public N endUser() {
      return and();
    }
    
  }
}