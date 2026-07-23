package io.fabric8.istio.api.api.meta.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IstioStatusBuilder extends IstioStatusFluent<IstioStatusBuilder> implements VisitableBuilder<IstioStatus,IstioStatusBuilder>{

  IstioStatusFluent<?> fluent;

  public IstioStatusBuilder() {
    this(new IstioStatus());
  }
  
  public IstioStatusBuilder(IstioStatusFluent<?> fluent) {
    this(fluent, new IstioStatus());
  }
  
  public IstioStatusBuilder(IstioStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IstioStatusBuilder(IstioStatusFluent<?> fluent,IstioStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IstioStatus build() {
    IstioStatus buildable = new IstioStatus(fluent.buildConditions(), fluent.getObservedGeneration(), fluent.buildValidationMessages());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}