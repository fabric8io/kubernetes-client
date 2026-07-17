package io.fabric8.openshift.api.model.operator.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressRouterStatusBuilder extends EgressRouterStatusFluent<EgressRouterStatusBuilder> implements VisitableBuilder<EgressRouterStatus,EgressRouterStatusBuilder>{

  EgressRouterStatusFluent<?> fluent;

  public EgressRouterStatusBuilder() {
    this(new EgressRouterStatus());
  }
  
  public EgressRouterStatusBuilder(EgressRouterStatusFluent<?> fluent) {
    this(fluent, new EgressRouterStatus());
  }
  
  public EgressRouterStatusBuilder(EgressRouterStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressRouterStatusBuilder(EgressRouterStatusFluent<?> fluent,EgressRouterStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressRouterStatus build() {
    EgressRouterStatus buildable = new EgressRouterStatus(fluent.buildConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}