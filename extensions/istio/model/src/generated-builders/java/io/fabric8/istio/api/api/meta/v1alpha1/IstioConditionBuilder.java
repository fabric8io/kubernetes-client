package io.fabric8.istio.api.api.meta.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IstioConditionBuilder extends IstioConditionFluent<IstioConditionBuilder> implements VisitableBuilder<IstioCondition,IstioConditionBuilder>{

  IstioConditionFluent<?> fluent;

  public IstioConditionBuilder() {
    this(new IstioCondition());
  }
  
  public IstioConditionBuilder(IstioConditionFluent<?> fluent) {
    this(fluent, new IstioCondition());
  }
  
  public IstioConditionBuilder(IstioCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IstioConditionBuilder(IstioConditionFluent<?> fluent,IstioCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IstioCondition build() {
    IstioCondition buildable = new IstioCondition(fluent.getLastProbeTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getObservedGeneration(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}