package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GroupListBuilder extends GroupListFluent<GroupListBuilder> implements VisitableBuilder<GroupList,GroupListBuilder>{

  GroupListFluent<?> fluent;

  public GroupListBuilder() {
    this(new GroupList());
  }
  
  public GroupListBuilder(GroupListFluent<?> fluent) {
    this(fluent, new GroupList());
  }
  
  public GroupListBuilder(GroupList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GroupListBuilder(GroupListFluent<?> fluent,GroupList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GroupList build() {
    GroupList buildable = new GroupList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}