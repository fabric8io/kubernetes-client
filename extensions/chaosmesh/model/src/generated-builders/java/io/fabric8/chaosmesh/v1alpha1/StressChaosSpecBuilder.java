package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StressChaosSpecBuilder extends StressChaosSpecFluent<StressChaosSpecBuilder> implements VisitableBuilder<StressChaosSpec,StressChaosSpecBuilder>{

  StressChaosSpecFluent<?> fluent;

  public StressChaosSpecBuilder() {
    this(new StressChaosSpec());
  }
  
  public StressChaosSpecBuilder(StressChaosSpecFluent<?> fluent) {
    this(fluent, new StressChaosSpec());
  }
  
  public StressChaosSpecBuilder(StressChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StressChaosSpecBuilder(StressChaosSpecFluent<?> fluent,StressChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StressChaosSpec build() {
    StressChaosSpec buildable = new StressChaosSpec(fluent.getContainerNames(), fluent.getDuration(), fluent.getMode(), fluent.getRemoteCluster(), fluent.buildSelector(), fluent.getStressngStressors(), fluent.buildStressors(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}