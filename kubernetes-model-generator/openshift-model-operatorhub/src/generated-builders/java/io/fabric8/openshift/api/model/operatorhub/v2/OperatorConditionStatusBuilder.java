package io.fabric8.openshift.api.model.operatorhub.v2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorConditionStatusBuilder extends OperatorConditionStatusFluent<OperatorConditionStatusBuilder> implements VisitableBuilder<OperatorConditionStatus,OperatorConditionStatusBuilder>{

  OperatorConditionStatusFluent<?> fluent;

  public OperatorConditionStatusBuilder() {
    this(new OperatorConditionStatus());
  }
  
  public OperatorConditionStatusBuilder(OperatorConditionStatusFluent<?> fluent) {
    this(fluent, new OperatorConditionStatus());
  }
  
  public OperatorConditionStatusBuilder(OperatorConditionStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorConditionStatusBuilder(OperatorConditionStatusFluent<?> fluent,OperatorConditionStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorConditionStatus build() {
    OperatorConditionStatus buildable = new OperatorConditionStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}