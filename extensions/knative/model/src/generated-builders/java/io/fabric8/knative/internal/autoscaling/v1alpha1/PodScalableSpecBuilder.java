package io.fabric8.knative.internal.autoscaling.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodScalableSpecBuilder extends PodScalableSpecFluent<PodScalableSpecBuilder> implements VisitableBuilder<PodScalableSpec,PodScalableSpecBuilder>{

  PodScalableSpecFluent<?> fluent;

  public PodScalableSpecBuilder() {
    this(new PodScalableSpec());
  }
  
  public PodScalableSpecBuilder(PodScalableSpecFluent<?> fluent) {
    this(fluent, new PodScalableSpec());
  }
  
  public PodScalableSpecBuilder(PodScalableSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodScalableSpecBuilder(PodScalableSpecFluent<?> fluent,PodScalableSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodScalableSpec build() {
    PodScalableSpec buildable = new PodScalableSpec(fluent.getReplicas(), fluent.buildSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}