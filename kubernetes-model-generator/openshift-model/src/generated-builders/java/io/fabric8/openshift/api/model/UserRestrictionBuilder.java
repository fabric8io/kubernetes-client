package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserRestrictionBuilder extends UserRestrictionFluent<UserRestrictionBuilder> implements VisitableBuilder<UserRestriction,UserRestrictionBuilder>{

  UserRestrictionFluent<?> fluent;

  public UserRestrictionBuilder() {
    this(new UserRestriction());
  }
  
  public UserRestrictionBuilder(UserRestrictionFluent<?> fluent) {
    this(fluent, new UserRestriction());
  }
  
  public UserRestrictionBuilder(UserRestriction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserRestrictionBuilder(UserRestrictionFluent<?> fluent,UserRestriction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserRestriction build() {
    UserRestriction buildable = new UserRestriction(fluent.getGroups(), fluent.buildLabels(), fluent.getUsers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}