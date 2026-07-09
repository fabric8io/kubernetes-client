package io.fabric8.kubernetes.api.model.authentication;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserInfoBuilder extends UserInfoFluent<UserInfoBuilder> implements VisitableBuilder<UserInfo,UserInfoBuilder>{

  UserInfoFluent<?> fluent;

  public UserInfoBuilder() {
    this(new UserInfo());
  }
  
  public UserInfoBuilder(UserInfoFluent<?> fluent) {
    this(fluent, new UserInfo());
  }
  
  public UserInfoBuilder(UserInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserInfoBuilder(UserInfoFluent<?> fluent,UserInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserInfo build() {
    UserInfo buildable = new UserInfo(fluent.getExtra(), fluent.getGroups(), fluent.getUid(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}