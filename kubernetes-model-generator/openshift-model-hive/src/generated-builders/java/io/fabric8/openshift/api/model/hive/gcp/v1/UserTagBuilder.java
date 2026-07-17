package io.fabric8.openshift.api.model.hive.gcp.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserTagBuilder extends UserTagFluent<UserTagBuilder> implements VisitableBuilder<UserTag,UserTagBuilder>{

  UserTagFluent<?> fluent;

  public UserTagBuilder() {
    this(new UserTag());
  }
  
  public UserTagBuilder(UserTagFluent<?> fluent) {
    this(fluent, new UserTag());
  }
  
  public UserTagBuilder(UserTag instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserTagBuilder(UserTagFluent<?> fluent,UserTag instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserTag build() {
    UserTag buildable = new UserTag(fluent.getKey(), fluent.getParentID(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}