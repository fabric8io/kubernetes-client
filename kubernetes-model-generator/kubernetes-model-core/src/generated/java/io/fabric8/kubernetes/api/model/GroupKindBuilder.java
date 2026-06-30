package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GroupKindBuilder extends GroupKindFluent<GroupKindBuilder> implements VisitableBuilder<GroupKind,GroupKindBuilder>{

  GroupKindFluent<?> fluent;

  public GroupKindBuilder() {
    this(new GroupKind());
  }
  
  public GroupKindBuilder(GroupKindFluent<?> fluent) {
    this(fluent, new GroupKind());
  }
  
  public GroupKindBuilder(GroupKind instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GroupKindBuilder(GroupKindFluent<?> fluent,GroupKind instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GroupKind build() {
    GroupKind buildable = new GroupKind(fluent.getGroup(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}