package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClockSpecBuilder extends ClockSpecFluent<ClockSpecBuilder> implements VisitableBuilder<ClockSpec,ClockSpecBuilder>{

  ClockSpecFluent<?> fluent;

  public ClockSpecBuilder() {
    this(new ClockSpec());
  }
  
  public ClockSpecBuilder(ClockSpecFluent<?> fluent) {
    this(fluent, new ClockSpec());
  }
  
  public ClockSpecBuilder(ClockSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClockSpecBuilder(ClockSpecFluent<?> fluent,ClockSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClockSpec build() {
    ClockSpec buildable = new ClockSpec(fluent.getClockIdsSlice(), fluent.getPid(), fluent.getTimeOffset());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}