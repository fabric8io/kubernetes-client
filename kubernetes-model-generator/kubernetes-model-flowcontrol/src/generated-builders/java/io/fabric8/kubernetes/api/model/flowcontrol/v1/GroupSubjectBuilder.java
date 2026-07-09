package io.fabric8.kubernetes.api.model.flowcontrol.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GroupSubjectBuilder extends GroupSubjectFluent<GroupSubjectBuilder> implements VisitableBuilder<GroupSubject,GroupSubjectBuilder>{

  GroupSubjectFluent<?> fluent;

  public GroupSubjectBuilder() {
    this(new GroupSubject());
  }
  
  public GroupSubjectBuilder(GroupSubjectFluent<?> fluent) {
    this(fluent, new GroupSubject());
  }
  
  public GroupSubjectBuilder(GroupSubject instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GroupSubjectBuilder(GroupSubjectFluent<?> fluent,GroupSubject instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GroupSubject build() {
    GroupSubject buildable = new GroupSubject(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}