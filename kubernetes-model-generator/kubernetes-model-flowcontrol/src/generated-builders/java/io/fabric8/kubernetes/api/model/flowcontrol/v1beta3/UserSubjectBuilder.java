package io.fabric8.kubernetes.api.model.flowcontrol.v1beta3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserSubjectBuilder extends UserSubjectFluent<UserSubjectBuilder> implements VisitableBuilder<UserSubject,UserSubjectBuilder>{

  UserSubjectFluent<?> fluent;

  public UserSubjectBuilder() {
    this(new UserSubject());
  }
  
  public UserSubjectBuilder(UserSubjectFluent<?> fluent) {
    this(fluent, new UserSubject());
  }
  
  public UserSubjectBuilder(UserSubject instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserSubjectBuilder(UserSubjectFluent<?> fluent,UserSubject instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserSubject build() {
    UserSubject buildable = new UserSubject(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}