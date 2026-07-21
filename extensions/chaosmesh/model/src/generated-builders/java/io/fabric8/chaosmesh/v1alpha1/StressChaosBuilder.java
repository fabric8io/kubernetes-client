package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StressChaosBuilder extends StressChaosFluent<StressChaosBuilder> implements VisitableBuilder<StressChaos,StressChaosBuilder>{

  StressChaosFluent<?> fluent;

  public StressChaosBuilder() {
    this(new StressChaos());
  }
  
  public StressChaosBuilder(StressChaosFluent<?> fluent) {
    this(fluent, new StressChaos());
  }
  
  public StressChaosBuilder(StressChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StressChaosBuilder(StressChaosFluent<?> fluent,StressChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StressChaos build() {
    StressChaos buildable = new StressChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}