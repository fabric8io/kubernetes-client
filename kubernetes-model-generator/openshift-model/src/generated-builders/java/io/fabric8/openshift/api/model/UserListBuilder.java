package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserListBuilder extends UserListFluent<UserListBuilder> implements VisitableBuilder<UserList,UserListBuilder>{

  UserListFluent<?> fluent;

  public UserListBuilder() {
    this(new UserList());
  }
  
  public UserListBuilder(UserListFluent<?> fluent) {
    this(fluent, new UserList());
  }
  
  public UserListBuilder(UserList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserListBuilder(UserListFluent<?> fluent,UserList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserList build() {
    UserList buildable = new UserList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}