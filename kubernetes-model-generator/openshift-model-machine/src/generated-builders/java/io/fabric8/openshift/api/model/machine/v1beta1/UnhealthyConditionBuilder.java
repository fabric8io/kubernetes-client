package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UnhealthyConditionBuilder extends UnhealthyConditionFluent<UnhealthyConditionBuilder> implements VisitableBuilder<UnhealthyCondition,UnhealthyConditionBuilder>{

  UnhealthyConditionFluent<?> fluent;

  public UnhealthyConditionBuilder() {
    this(new UnhealthyCondition());
  }
  
  public UnhealthyConditionBuilder(UnhealthyConditionFluent<?> fluent) {
    this(fluent, new UnhealthyCondition());
  }
  
  public UnhealthyConditionBuilder(UnhealthyCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UnhealthyConditionBuilder(UnhealthyConditionFluent<?> fluent,UnhealthyCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UnhealthyCondition build() {
    UnhealthyCondition buildable = new UnhealthyCondition(fluent.getStatus(), fluent.getTimeout(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}