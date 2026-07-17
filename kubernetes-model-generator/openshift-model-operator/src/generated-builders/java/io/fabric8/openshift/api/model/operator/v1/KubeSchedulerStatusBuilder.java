package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeSchedulerStatusBuilder extends KubeSchedulerStatusFluent<KubeSchedulerStatusBuilder> implements VisitableBuilder<KubeSchedulerStatus,KubeSchedulerStatusBuilder>{

  KubeSchedulerStatusFluent<?> fluent;

  public KubeSchedulerStatusBuilder() {
    this(new KubeSchedulerStatus());
  }
  
  public KubeSchedulerStatusBuilder(KubeSchedulerStatusFluent<?> fluent) {
    this(fluent, new KubeSchedulerStatus());
  }
  
  public KubeSchedulerStatusBuilder(KubeSchedulerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeSchedulerStatusBuilder(KubeSchedulerStatusFluent<?> fluent,KubeSchedulerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeSchedulerStatus build() {
    KubeSchedulerStatus buildable = new KubeSchedulerStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getLatestAvailableRevisionReason(), fluent.buildNodeStatuses(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}