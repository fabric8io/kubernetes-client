package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StaticPodOperatorStatusBuilder extends StaticPodOperatorStatusFluent<StaticPodOperatorStatusBuilder> implements VisitableBuilder<StaticPodOperatorStatus,StaticPodOperatorStatusBuilder>{

  StaticPodOperatorStatusFluent<?> fluent;

  public StaticPodOperatorStatusBuilder() {
    this(new StaticPodOperatorStatus());
  }
  
  public StaticPodOperatorStatusBuilder(StaticPodOperatorStatusFluent<?> fluent) {
    this(fluent, new StaticPodOperatorStatus());
  }
  
  public StaticPodOperatorStatusBuilder(StaticPodOperatorStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StaticPodOperatorStatusBuilder(StaticPodOperatorStatusFluent<?> fluent,StaticPodOperatorStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StaticPodOperatorStatus build() {
    StaticPodOperatorStatus buildable = new StaticPodOperatorStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getLatestAvailableRevisionReason(), fluent.buildNodeStatuses(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}