package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GroupVersionResourceBuilder extends GroupVersionResourceFluent<GroupVersionResourceBuilder> implements VisitableBuilder<GroupVersionResource,GroupVersionResourceBuilder>{

  GroupVersionResourceFluent<?> fluent;

  public GroupVersionResourceBuilder() {
    this(new GroupVersionResource());
  }
  
  public GroupVersionResourceBuilder(GroupVersionResourceFluent<?> fluent) {
    this(fluent, new GroupVersionResource());
  }
  
  public GroupVersionResourceBuilder(GroupVersionResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GroupVersionResourceBuilder(GroupVersionResourceFluent<?> fluent,GroupVersionResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GroupVersionResource build() {
    GroupVersionResource buildable = new GroupVersionResource(fluent.getGroup(), fluent.getResource(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}