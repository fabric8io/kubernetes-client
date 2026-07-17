package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RoleBindingRestrictionBuilder extends RoleBindingRestrictionFluent<RoleBindingRestrictionBuilder> implements VisitableBuilder<RoleBindingRestriction,RoleBindingRestrictionBuilder>{

  RoleBindingRestrictionFluent<?> fluent;

  public RoleBindingRestrictionBuilder() {
    this(new RoleBindingRestriction());
  }
  
  public RoleBindingRestrictionBuilder(RoleBindingRestrictionFluent<?> fluent) {
    this(fluent, new RoleBindingRestriction());
  }
  
  public RoleBindingRestrictionBuilder(RoleBindingRestriction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RoleBindingRestrictionBuilder(RoleBindingRestrictionFluent<?> fluent,RoleBindingRestriction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RoleBindingRestriction build() {
    RoleBindingRestriction buildable = new RoleBindingRestriction(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}