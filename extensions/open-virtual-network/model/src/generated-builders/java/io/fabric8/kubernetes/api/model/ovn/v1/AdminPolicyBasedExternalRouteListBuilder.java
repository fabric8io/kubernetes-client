package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdminPolicyBasedExternalRouteListBuilder extends AdminPolicyBasedExternalRouteListFluent<AdminPolicyBasedExternalRouteListBuilder> implements VisitableBuilder<AdminPolicyBasedExternalRouteList,AdminPolicyBasedExternalRouteListBuilder>{

  AdminPolicyBasedExternalRouteListFluent<?> fluent;

  public AdminPolicyBasedExternalRouteListBuilder() {
    this(new AdminPolicyBasedExternalRouteList());
  }
  
  public AdminPolicyBasedExternalRouteListBuilder(AdminPolicyBasedExternalRouteListFluent<?> fluent) {
    this(fluent, new AdminPolicyBasedExternalRouteList());
  }
  
  public AdminPolicyBasedExternalRouteListBuilder(AdminPolicyBasedExternalRouteList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdminPolicyBasedExternalRouteListBuilder(AdminPolicyBasedExternalRouteListFluent<?> fluent,AdminPolicyBasedExternalRouteList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdminPolicyBasedExternalRouteList build() {
    AdminPolicyBasedExternalRouteList buildable = new AdminPolicyBasedExternalRouteList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}