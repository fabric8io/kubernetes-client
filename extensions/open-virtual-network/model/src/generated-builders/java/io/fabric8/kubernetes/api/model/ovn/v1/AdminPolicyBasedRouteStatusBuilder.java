package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdminPolicyBasedRouteStatusBuilder extends AdminPolicyBasedRouteStatusFluent<AdminPolicyBasedRouteStatusBuilder> implements VisitableBuilder<AdminPolicyBasedRouteStatus,AdminPolicyBasedRouteStatusBuilder>{

  AdminPolicyBasedRouteStatusFluent<?> fluent;

  public AdminPolicyBasedRouteStatusBuilder() {
    this(new AdminPolicyBasedRouteStatus());
  }
  
  public AdminPolicyBasedRouteStatusBuilder(AdminPolicyBasedRouteStatusFluent<?> fluent) {
    this(fluent, new AdminPolicyBasedRouteStatus());
  }
  
  public AdminPolicyBasedRouteStatusBuilder(AdminPolicyBasedRouteStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdminPolicyBasedRouteStatusBuilder(AdminPolicyBasedRouteStatusFluent<?> fluent,AdminPolicyBasedRouteStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdminPolicyBasedRouteStatus build() {
    AdminPolicyBasedRouteStatus buildable = new AdminPolicyBasedRouteStatus(fluent.getLastTransitionTime(), fluent.getMessages(), fluent.getStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}