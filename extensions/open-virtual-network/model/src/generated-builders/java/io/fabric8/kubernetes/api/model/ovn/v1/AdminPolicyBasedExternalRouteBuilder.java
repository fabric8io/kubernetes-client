package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdminPolicyBasedExternalRouteBuilder extends AdminPolicyBasedExternalRouteFluent<AdminPolicyBasedExternalRouteBuilder> implements VisitableBuilder<AdminPolicyBasedExternalRoute,AdminPolicyBasedExternalRouteBuilder>{

  AdminPolicyBasedExternalRouteFluent<?> fluent;

  public AdminPolicyBasedExternalRouteBuilder() {
    this(new AdminPolicyBasedExternalRoute());
  }
  
  public AdminPolicyBasedExternalRouteBuilder(AdminPolicyBasedExternalRouteFluent<?> fluent) {
    this(fluent, new AdminPolicyBasedExternalRoute());
  }
  
  public AdminPolicyBasedExternalRouteBuilder(AdminPolicyBasedExternalRoute instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdminPolicyBasedExternalRouteBuilder(AdminPolicyBasedExternalRouteFluent<?> fluent,AdminPolicyBasedExternalRoute instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdminPolicyBasedExternalRoute build() {
    AdminPolicyBasedExternalRoute buildable = new AdminPolicyBasedExternalRoute(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}