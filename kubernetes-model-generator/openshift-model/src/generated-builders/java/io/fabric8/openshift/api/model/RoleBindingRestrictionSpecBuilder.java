package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RoleBindingRestrictionSpecBuilder extends RoleBindingRestrictionSpecFluent<RoleBindingRestrictionSpecBuilder> implements VisitableBuilder<RoleBindingRestrictionSpec,RoleBindingRestrictionSpecBuilder>{

  RoleBindingRestrictionSpecFluent<?> fluent;

  public RoleBindingRestrictionSpecBuilder() {
    this(new RoleBindingRestrictionSpec());
  }
  
  public RoleBindingRestrictionSpecBuilder(RoleBindingRestrictionSpecFluent<?> fluent) {
    this(fluent, new RoleBindingRestrictionSpec());
  }
  
  public RoleBindingRestrictionSpecBuilder(RoleBindingRestrictionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RoleBindingRestrictionSpecBuilder(RoleBindingRestrictionSpecFluent<?> fluent,RoleBindingRestrictionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RoleBindingRestrictionSpec build() {
    RoleBindingRestrictionSpec buildable = new RoleBindingRestrictionSpec(fluent.buildGrouprestriction(), fluent.buildServiceaccountrestriction(), fluent.buildUserrestriction());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}