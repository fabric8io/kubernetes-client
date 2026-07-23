package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StressorBuilder extends StressorFluent<StressorBuilder> implements VisitableBuilder<Stressor,StressorBuilder>{

  StressorFluent<?> fluent;

  public StressorBuilder() {
    this(new Stressor());
  }
  
  public StressorBuilder(StressorFluent<?> fluent) {
    this(fluent, new Stressor());
  }
  
  public StressorBuilder(Stressor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StressorBuilder(StressorFluent<?> fluent,Stressor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Stressor build() {
    Stressor buildable = new Stressor(fluent.getWorkers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}