package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperationHistoryBuilder extends OperationHistoryFluent<OperationHistoryBuilder> implements VisitableBuilder<OperationHistory,OperationHistoryBuilder>{

  OperationHistoryFluent<?> fluent;

  public OperationHistoryBuilder() {
    this(new OperationHistory());
  }
  
  public OperationHistoryBuilder(OperationHistoryFluent<?> fluent) {
    this(fluent, new OperationHistory());
  }
  
  public OperationHistoryBuilder(OperationHistory instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperationHistoryBuilder(OperationHistoryFluent<?> fluent,OperationHistory instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperationHistory build() {
    OperationHistory buildable = new OperationHistory(fluent.buildDeprovision(), fluent.buildInspect(), fluent.buildProvision(), fluent.buildRegister());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}