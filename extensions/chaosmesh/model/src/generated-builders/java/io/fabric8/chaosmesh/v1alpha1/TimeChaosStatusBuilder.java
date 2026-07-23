package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TimeChaosStatusBuilder extends TimeChaosStatusFluent<TimeChaosStatusBuilder> implements VisitableBuilder<TimeChaosStatus,TimeChaosStatusBuilder>{

  TimeChaosStatusFluent<?> fluent;

  public TimeChaosStatusBuilder() {
    this(new TimeChaosStatus());
  }
  
  public TimeChaosStatusBuilder(TimeChaosStatusFluent<?> fluent) {
    this(fluent, new TimeChaosStatus());
  }
  
  public TimeChaosStatusBuilder(TimeChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TimeChaosStatusBuilder(TimeChaosStatusFluent<?> fluent,TimeChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TimeChaosStatus build() {
    TimeChaosStatus buildable = new TimeChaosStatus(fluent.buildConditions(), fluent.buildExperiment());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}