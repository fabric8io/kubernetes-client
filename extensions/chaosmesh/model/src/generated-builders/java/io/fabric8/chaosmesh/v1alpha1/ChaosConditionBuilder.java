package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChaosConditionBuilder extends ChaosConditionFluent<ChaosConditionBuilder> implements VisitableBuilder<ChaosCondition,ChaosConditionBuilder>{

  ChaosConditionFluent<?> fluent;

  public ChaosConditionBuilder() {
    this(new ChaosCondition());
  }
  
  public ChaosConditionBuilder(ChaosConditionFluent<?> fluent) {
    this(fluent, new ChaosCondition());
  }
  
  public ChaosConditionBuilder(ChaosCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChaosConditionBuilder(ChaosConditionFluent<?> fluent,ChaosCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChaosCondition build() {
    ChaosCondition buildable = new ChaosCondition(fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}