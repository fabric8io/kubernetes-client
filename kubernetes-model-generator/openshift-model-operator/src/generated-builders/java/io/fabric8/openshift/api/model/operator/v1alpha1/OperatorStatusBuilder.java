package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorStatusBuilder extends OperatorStatusFluent<OperatorStatusBuilder> implements VisitableBuilder<OperatorStatus,OperatorStatusBuilder>{

  OperatorStatusFluent<?> fluent;

  public OperatorStatusBuilder() {
    this(new OperatorStatus());
  }
  
  public OperatorStatusBuilder(OperatorStatusFluent<?> fluent) {
    this(fluent, new OperatorStatus());
  }
  
  public OperatorStatusBuilder(OperatorStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorStatusBuilder(OperatorStatusFluent<?> fluent,OperatorStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorStatus build() {
    OperatorStatus buildable = new OperatorStatus(fluent.buildConditions(), fluent.buildCurrentVersionAvailability(), fluent.getObservedGeneration(), fluent.getState(), fluent.buildTargetVersionAvailability(), fluent.getTaskSummary());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}