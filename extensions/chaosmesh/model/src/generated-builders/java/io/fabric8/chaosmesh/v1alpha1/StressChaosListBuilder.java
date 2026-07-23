package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StressChaosListBuilder extends StressChaosListFluent<StressChaosListBuilder> implements VisitableBuilder<StressChaosList,StressChaosListBuilder>{

  StressChaosListFluent<?> fluent;

  public StressChaosListBuilder() {
    this(new StressChaosList());
  }
  
  public StressChaosListBuilder(StressChaosListFluent<?> fluent) {
    this(fluent, new StressChaosList());
  }
  
  public StressChaosListBuilder(StressChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StressChaosListBuilder(StressChaosListFluent<?> fluent,StressChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StressChaosList build() {
    StressChaosList buildable = new StressChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}