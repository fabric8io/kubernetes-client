package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdminPolicyBasedExternalRouteSpecBuilder extends AdminPolicyBasedExternalRouteSpecFluent<AdminPolicyBasedExternalRouteSpecBuilder> implements VisitableBuilder<AdminPolicyBasedExternalRouteSpec,AdminPolicyBasedExternalRouteSpecBuilder>{

  AdminPolicyBasedExternalRouteSpecFluent<?> fluent;

  public AdminPolicyBasedExternalRouteSpecBuilder() {
    this(new AdminPolicyBasedExternalRouteSpec());
  }
  
  public AdminPolicyBasedExternalRouteSpecBuilder(AdminPolicyBasedExternalRouteSpecFluent<?> fluent) {
    this(fluent, new AdminPolicyBasedExternalRouteSpec());
  }
  
  public AdminPolicyBasedExternalRouteSpecBuilder(AdminPolicyBasedExternalRouteSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdminPolicyBasedExternalRouteSpecBuilder(AdminPolicyBasedExternalRouteSpecFluent<?> fluent,AdminPolicyBasedExternalRouteSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdminPolicyBasedExternalRouteSpec build() {
    AdminPolicyBasedExternalRouteSpec buildable = new AdminPolicyBasedExternalRouteSpec(fluent.buildFrom(), fluent.buildNextHops());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}