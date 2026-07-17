package io.fabric8.openshift.api.model.operator.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressRouterStatusConditionBuilder extends EgressRouterStatusConditionFluent<EgressRouterStatusConditionBuilder> implements VisitableBuilder<EgressRouterStatusCondition,EgressRouterStatusConditionBuilder>{

  EgressRouterStatusConditionFluent<?> fluent;

  public EgressRouterStatusConditionBuilder() {
    this(new EgressRouterStatusCondition());
  }
  
  public EgressRouterStatusConditionBuilder(EgressRouterStatusConditionFluent<?> fluent) {
    this(fluent, new EgressRouterStatusCondition());
  }
  
  public EgressRouterStatusConditionBuilder(EgressRouterStatusCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressRouterStatusConditionBuilder(EgressRouterStatusConditionFluent<?> fluent,EgressRouterStatusCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressRouterStatusCondition build() {
    EgressRouterStatusCondition buildable = new EgressRouterStatusCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}