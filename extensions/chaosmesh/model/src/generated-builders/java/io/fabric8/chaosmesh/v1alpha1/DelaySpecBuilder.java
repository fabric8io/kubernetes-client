package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DelaySpecBuilder extends DelaySpecFluent<DelaySpecBuilder> implements VisitableBuilder<DelaySpec,DelaySpecBuilder>{

  DelaySpecFluent<?> fluent;

  public DelaySpecBuilder() {
    this(new DelaySpec());
  }
  
  public DelaySpecBuilder(DelaySpecFluent<?> fluent) {
    this(fluent, new DelaySpec());
  }
  
  public DelaySpecBuilder(DelaySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DelaySpecBuilder(DelaySpecFluent<?> fluent,DelaySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DelaySpec build() {
    DelaySpec buildable = new DelaySpec(fluent.getCorrelation(), fluent.getJitter(), fluent.getLatency(), fluent.buildReorder());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}