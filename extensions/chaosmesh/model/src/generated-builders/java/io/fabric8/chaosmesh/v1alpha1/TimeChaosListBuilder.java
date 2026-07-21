package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TimeChaosListBuilder extends TimeChaosListFluent<TimeChaosListBuilder> implements VisitableBuilder<TimeChaosList,TimeChaosListBuilder>{

  TimeChaosListFluent<?> fluent;

  public TimeChaosListBuilder() {
    this(new TimeChaosList());
  }
  
  public TimeChaosListBuilder(TimeChaosListFluent<?> fluent) {
    this(fluent, new TimeChaosList());
  }
  
  public TimeChaosListBuilder(TimeChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TimeChaosListBuilder(TimeChaosListFluent<?> fluent,TimeChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TimeChaosList build() {
    TimeChaosList buildable = new TimeChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}