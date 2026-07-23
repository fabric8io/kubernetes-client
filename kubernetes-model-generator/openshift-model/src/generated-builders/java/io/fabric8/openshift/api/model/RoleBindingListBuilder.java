package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RoleBindingListBuilder extends RoleBindingListFluent<RoleBindingListBuilder> implements VisitableBuilder<RoleBindingList,RoleBindingListBuilder>{

  RoleBindingListFluent<?> fluent;

  public RoleBindingListBuilder() {
    this(new RoleBindingList());
  }
  
  public RoleBindingListBuilder(RoleBindingListFluent<?> fluent) {
    this(fluent, new RoleBindingList());
  }
  
  public RoleBindingListBuilder(RoleBindingList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RoleBindingListBuilder(RoleBindingListFluent<?> fluent,RoleBindingList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RoleBindingList build() {
    RoleBindingList buildable = new RoleBindingList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}