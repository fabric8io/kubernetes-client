package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RateSpecBuilder extends RateSpecFluent<RateSpecBuilder> implements VisitableBuilder<RateSpec,RateSpecBuilder>{

  RateSpecFluent<?> fluent;

  public RateSpecBuilder() {
    this(new RateSpec());
  }
  
  public RateSpecBuilder(RateSpecFluent<?> fluent) {
    this(fluent, new RateSpec());
  }
  
  public RateSpecBuilder(RateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RateSpecBuilder(RateSpecFluent<?> fluent,RateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RateSpec build() {
    RateSpec buildable = new RateSpec(fluent.getRate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}