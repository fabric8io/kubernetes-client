package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StressChaosStatusBuilder extends StressChaosStatusFluent<StressChaosStatusBuilder> implements VisitableBuilder<StressChaosStatus,StressChaosStatusBuilder>{

  StressChaosStatusFluent<?> fluent;

  public StressChaosStatusBuilder() {
    this(new StressChaosStatus());
  }
  
  public StressChaosStatusBuilder(StressChaosStatusFluent<?> fluent) {
    this(fluent, new StressChaosStatus());
  }
  
  public StressChaosStatusBuilder(StressChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StressChaosStatusBuilder(StressChaosStatusFluent<?> fluent,StressChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StressChaosStatus build() {
    StressChaosStatus buildable = new StressChaosStatus(fluent.buildConditions(), fluent.buildExperiment(), fluent.getInstances());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}