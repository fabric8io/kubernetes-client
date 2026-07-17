package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserBuilder extends UserFluent<UserBuilder> implements VisitableBuilder<User,UserBuilder>{

  UserFluent<?> fluent;

  public UserBuilder() {
    this(new User());
  }
  
  public UserBuilder(UserFluent<?> fluent) {
    this(fluent, new User());
  }
  
  public UserBuilder(User instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserBuilder(UserFluent<?> fluent,User instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public User build() {
    User buildable = new User(fluent.getApiVersion(), fluent.getFullName(), fluent.getGroups(), fluent.getIdentities(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}