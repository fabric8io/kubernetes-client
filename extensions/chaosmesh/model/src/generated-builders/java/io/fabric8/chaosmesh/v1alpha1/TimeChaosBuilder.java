package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TimeChaosBuilder extends TimeChaosFluent<TimeChaosBuilder> implements VisitableBuilder<TimeChaos,TimeChaosBuilder>{

  TimeChaosFluent<?> fluent;

  public TimeChaosBuilder() {
    this(new TimeChaos());
  }
  
  public TimeChaosBuilder(TimeChaosFluent<?> fluent) {
    this(fluent, new TimeChaos());
  }
  
  public TimeChaosBuilder(TimeChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TimeChaosBuilder(TimeChaosFluent<?> fluent,TimeChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TimeChaos build() {
    TimeChaos buildable = new TimeChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}