package io.fabric8.openshift.api.model.operatorhub.v2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorConditionSpecBuilder extends OperatorConditionSpecFluent<OperatorConditionSpecBuilder> implements VisitableBuilder<OperatorConditionSpec,OperatorConditionSpecBuilder>{

  OperatorConditionSpecFluent<?> fluent;

  public OperatorConditionSpecBuilder() {
    this(new OperatorConditionSpec());
  }
  
  public OperatorConditionSpecBuilder(OperatorConditionSpecFluent<?> fluent) {
    this(fluent, new OperatorConditionSpec());
  }
  
  public OperatorConditionSpecBuilder(OperatorConditionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorConditionSpecBuilder(OperatorConditionSpecFluent<?> fluent,OperatorConditionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorConditionSpec build() {
    OperatorConditionSpec buildable = new OperatorConditionSpec(fluent.getConditions(), fluent.getDeployments(), fluent.getOverrides(), fluent.getServiceAccounts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}