package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatefulSetStatusBuilder extends StatefulSetStatusFluent<StatefulSetStatusBuilder> implements VisitableBuilder<StatefulSetStatus,StatefulSetStatusBuilder>{

  StatefulSetStatusFluent<?> fluent;

  public StatefulSetStatusBuilder() {
    this(new StatefulSetStatus());
  }
  
  public StatefulSetStatusBuilder(StatefulSetStatusFluent<?> fluent) {
    this(fluent, new StatefulSetStatus());
  }
  
  public StatefulSetStatusBuilder(StatefulSetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatefulSetStatusBuilder(StatefulSetStatusFluent<?> fluent,StatefulSetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatefulSetStatus build() {
    StatefulSetStatus buildable = new StatefulSetStatus(fluent.getAvailableReplicas(), fluent.getCollisionCount(), fluent.buildConditions(), fluent.getCurrentReplicas(), fluent.getCurrentRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getReplicas(), fluent.getUpdateRevision(), fluent.getUpdatedReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}