package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GroupVersionKindBuilder extends GroupVersionKindFluent<GroupVersionKindBuilder> implements VisitableBuilder<GroupVersionKind,GroupVersionKindBuilder>{

  GroupVersionKindFluent<?> fluent;

  public GroupVersionKindBuilder() {
    this(new GroupVersionKind());
  }
  
  public GroupVersionKindBuilder(GroupVersionKindFluent<?> fluent) {
    this(fluent, new GroupVersionKind());
  }
  
  public GroupVersionKindBuilder(GroupVersionKind instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GroupVersionKindBuilder(GroupVersionKindFluent<?> fluent,GroupVersionKind instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GroupVersionKind build() {
    GroupVersionKind buildable = new GroupVersionKind(fluent.getGroup(), fluent.getKind(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}