package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UsernamePrefixBuilder extends UsernamePrefixFluent<UsernamePrefixBuilder> implements VisitableBuilder<UsernamePrefix,UsernamePrefixBuilder>{

  UsernamePrefixFluent<?> fluent;

  public UsernamePrefixBuilder() {
    this(new UsernamePrefix());
  }
  
  public UsernamePrefixBuilder(UsernamePrefixFluent<?> fluent) {
    this(fluent, new UsernamePrefix());
  }
  
  public UsernamePrefixBuilder(UsernamePrefix instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UsernamePrefixBuilder(UsernamePrefixFluent<?> fluent,UsernamePrefix instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UsernamePrefix build() {
    UsernamePrefix buildable = new UsernamePrefix(fluent.getPrefixString());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}