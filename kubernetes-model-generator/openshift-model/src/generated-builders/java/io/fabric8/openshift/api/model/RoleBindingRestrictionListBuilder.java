package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RoleBindingRestrictionListBuilder extends RoleBindingRestrictionListFluent<RoleBindingRestrictionListBuilder> implements VisitableBuilder<RoleBindingRestrictionList,RoleBindingRestrictionListBuilder>{

  RoleBindingRestrictionListFluent<?> fluent;

  public RoleBindingRestrictionListBuilder() {
    this(new RoleBindingRestrictionList());
  }
  
  public RoleBindingRestrictionListBuilder(RoleBindingRestrictionListFluent<?> fluent) {
    this(fluent, new RoleBindingRestrictionList());
  }
  
  public RoleBindingRestrictionListBuilder(RoleBindingRestrictionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RoleBindingRestrictionListBuilder(RoleBindingRestrictionListFluent<?> fluent,RoleBindingRestrictionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RoleBindingRestrictionList build() {
    RoleBindingRestrictionList buildable = new RoleBindingRestrictionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}