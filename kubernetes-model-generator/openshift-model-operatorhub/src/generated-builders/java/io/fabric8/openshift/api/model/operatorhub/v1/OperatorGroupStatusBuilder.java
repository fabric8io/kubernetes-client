package io.fabric8.openshift.api.model.operatorhub.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorGroupStatusBuilder extends OperatorGroupStatusFluent<OperatorGroupStatusBuilder> implements VisitableBuilder<OperatorGroupStatus,OperatorGroupStatusBuilder>{

  OperatorGroupStatusFluent<?> fluent;

  public OperatorGroupStatusBuilder() {
    this(new OperatorGroupStatus());
  }
  
  public OperatorGroupStatusBuilder(OperatorGroupStatusFluent<?> fluent) {
    this(fluent, new OperatorGroupStatus());
  }
  
  public OperatorGroupStatusBuilder(OperatorGroupStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorGroupStatusBuilder(OperatorGroupStatusFluent<?> fluent,OperatorGroupStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorGroupStatus build() {
    OperatorGroupStatus buildable = new OperatorGroupStatus(fluent.getConditions(), fluent.getLastUpdated(), fluent.getNamespaces(), fluent.buildServiceAccountRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}