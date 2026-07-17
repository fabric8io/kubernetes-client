package io.fabric8.openshift.api.model.operatorhub.v2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorConditionBuilder extends OperatorConditionFluent<OperatorConditionBuilder> implements VisitableBuilder<OperatorCondition,OperatorConditionBuilder>{

  OperatorConditionFluent<?> fluent;

  public OperatorConditionBuilder() {
    this(new OperatorCondition());
  }
  
  public OperatorConditionBuilder(OperatorConditionFluent<?> fluent) {
    this(fluent, new OperatorCondition());
  }
  
  public OperatorConditionBuilder(OperatorCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorConditionBuilder(OperatorConditionFluent<?> fluent,OperatorCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorCondition build() {
    OperatorCondition buildable = new OperatorCondition(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}