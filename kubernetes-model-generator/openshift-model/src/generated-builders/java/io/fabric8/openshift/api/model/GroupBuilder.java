package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GroupBuilder extends GroupFluent<GroupBuilder> implements VisitableBuilder<Group,GroupBuilder>{

  GroupFluent<?> fluent;

  public GroupBuilder() {
    this(new Group());
  }
  
  public GroupBuilder(GroupFluent<?> fluent) {
    this(fluent, new Group());
  }
  
  public GroupBuilder(Group instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GroupBuilder(GroupFluent<?> fluent,Group instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Group build() {
    Group buildable = new Group(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.getUsers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}