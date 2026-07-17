package io.fabric8.openshift.api.model.operator.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorPKIStatusBuilder extends OperatorPKIStatusFluent<OperatorPKIStatusBuilder> implements VisitableBuilder<OperatorPKIStatus,OperatorPKIStatusBuilder>{

  OperatorPKIStatusFluent<?> fluent;

  public OperatorPKIStatusBuilder() {
    this(new OperatorPKIStatus());
  }
  
  public OperatorPKIStatusBuilder(OperatorPKIStatusFluent<?> fluent) {
    this(fluent, new OperatorPKIStatus());
  }
  
  public OperatorPKIStatusBuilder(OperatorPKIStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorPKIStatusBuilder(OperatorPKIStatusFluent<?> fluent,OperatorPKIStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorPKIStatus build() {
    OperatorPKIStatus buildable = new OperatorPKIStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}