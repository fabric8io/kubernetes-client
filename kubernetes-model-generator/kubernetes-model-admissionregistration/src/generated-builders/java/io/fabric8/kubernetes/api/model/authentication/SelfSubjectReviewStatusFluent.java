package io.fabric8.kubernetes.api.model.authentication;

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
public class SelfSubjectReviewStatusFluent<A extends io.fabric8.kubernetes.api.model.authentication.SelfSubjectReviewStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private UserInfoBuilder userInfo;

  public SelfSubjectReviewStatusFluent() {
  }
  
  public SelfSubjectReviewStatusFluent(SelfSubjectReviewStatus instance) {
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
  
  public UserInfo buildUserInfo() {
    return this.userInfo != null ? this.userInfo.build() : null;
  }
  
  protected void copyInstance(SelfSubjectReviewStatus instance) {
    instance = instance != null ? instance : new SelfSubjectReviewStatus();
    if (instance != null) {
        this.withUserInfo(instance.getUserInfo());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public UserInfoNested<A> editOrNewUserInfo() {
    return this.withNewUserInfoLike(Optional.ofNullable(this.buildUserInfo()).orElse(new UserInfoBuilder().build()));
  }
  
  public UserInfoNested<A> editOrNewUserInfoLike(UserInfo item) {
    return this.withNewUserInfoLike(Optional.ofNullable(this.buildUserInfo()).orElse(item));
  }
  
  public UserInfoNested<A> editUserInfo() {
    return this.withNewUserInfoLike(Optional.ofNullable(this.buildUserInfo()).orElse(null));
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
    SelfSubjectReviewStatusFluent that = (SelfSubjectReviewStatusFluent) o;
    if (!(Objects.equals(userInfo, that.userInfo))) {
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
  
  public boolean hasUserInfo() {
    return this.userInfo != null;
  }
  
  public int hashCode() {
    return Objects.hash(userInfo, additionalProperties);
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
    if (!(userInfo == null)) {
        sb.append("userInfo:");
        sb.append(userInfo);
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
  
  public UserInfoNested<A> withNewUserInfo() {
    return new UserInfoNested(null);
  }
  
  public UserInfoNested<A> withNewUserInfoLike(UserInfo item) {
    return new UserInfoNested(item);
  }
  
  public A withUserInfo(UserInfo userInfo) {
    this._visitables.remove("userInfo");
    if (userInfo != null) {
        this.userInfo = new UserInfoBuilder(userInfo);
        this._visitables.get("userInfo").add(this.userInfo);
    } else {
        this.userInfo = null;
        this._visitables.get("userInfo").remove(this.userInfo);
    }
    return (A) this;
  }
  public class UserInfoNested<N> extends UserInfoFluent<UserInfoNested<N>> implements Nested<N>{
  
    UserInfoBuilder builder;
  
    UserInfoNested(UserInfo item) {
      this.builder = new UserInfoBuilder(this, item);
    }
  
    public N and() {
      return (N) SelfSubjectReviewStatusFluent.this.withUserInfo(builder.build());
    }
    
    public N endUserInfo() {
      return and();
    }
    
  }
}