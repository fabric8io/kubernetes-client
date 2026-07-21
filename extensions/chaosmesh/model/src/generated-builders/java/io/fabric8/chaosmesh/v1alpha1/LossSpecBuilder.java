package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LossSpecBuilder extends LossSpecFluent<LossSpecBuilder> implements VisitableBuilder<LossSpec,LossSpecBuilder>{

  LossSpecFluent<?> fluent;

  public LossSpecBuilder() {
    this(new LossSpec());
  }
  
  public LossSpecBuilder(LossSpecFluent<?> fluent) {
    this(fluent, new LossSpec());
  }
  
  public LossSpecBuilder(LossSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LossSpecBuilder(LossSpecFluent<?> fluent,LossSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LossSpec build() {
    LossSpec buildable = new LossSpec(fluent.getCorrelation(), fluent.getLoss());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}