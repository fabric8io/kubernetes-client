package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TimeChaosSpecBuilder extends TimeChaosSpecFluent<TimeChaosSpecBuilder> implements VisitableBuilder<TimeChaosSpec,TimeChaosSpecBuilder>{

  TimeChaosSpecFluent<?> fluent;

  public TimeChaosSpecBuilder() {
    this(new TimeChaosSpec());
  }
  
  public TimeChaosSpecBuilder(TimeChaosSpecFluent<?> fluent) {
    this(fluent, new TimeChaosSpec());
  }
  
  public TimeChaosSpecBuilder(TimeChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TimeChaosSpecBuilder(TimeChaosSpecFluent<?> fluent,TimeChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TimeChaosSpec build() {
    TimeChaosSpec buildable = new TimeChaosSpec(fluent.getClockIds(), fluent.getContainerNames(), fluent.getDuration(), fluent.getMode(), fluent.getRemoteCluster(), fluent.buildSelector(), fluent.getTimeOffset(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}