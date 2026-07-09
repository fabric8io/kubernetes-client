package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DaemonSetStatusBuilder extends DaemonSetStatusFluent<DaemonSetStatusBuilder> implements VisitableBuilder<DaemonSetStatus,DaemonSetStatusBuilder>{

  DaemonSetStatusFluent<?> fluent;

  public DaemonSetStatusBuilder() {
    this(new DaemonSetStatus());
  }
  
  public DaemonSetStatusBuilder(DaemonSetStatusFluent<?> fluent) {
    this(fluent, new DaemonSetStatus());
  }
  
  public DaemonSetStatusBuilder(DaemonSetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DaemonSetStatusBuilder(DaemonSetStatusFluent<?> fluent,DaemonSetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DaemonSetStatus build() {
    DaemonSetStatus buildable = new DaemonSetStatus(fluent.getCollisionCount(), fluent.buildConditions(), fluent.getCurrentNumberScheduled(), fluent.getDesiredNumberScheduled(), fluent.getNumberAvailable(), fluent.getNumberMisscheduled(), fluent.getNumberReady(), fluent.getNumberUnavailable(), fluent.getObservedGeneration(), fluent.getUpdatedNumberScheduled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}