package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GroupResourceBuilder extends GroupResourceFluent<GroupResourceBuilder> implements VisitableBuilder<GroupResource,GroupResourceBuilder>{

  GroupResourceFluent<?> fluent;

  public GroupResourceBuilder() {
    this(new GroupResource());
  }
  
  public GroupResourceBuilder(GroupResourceFluent<?> fluent) {
    this(fluent, new GroupResource());
  }
  
  public GroupResourceBuilder(GroupResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GroupResourceBuilder(GroupResourceFluent<?> fluent,GroupResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GroupResource build() {
    GroupResource buildable = new GroupResource(fluent.getGroup(), fluent.getResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}