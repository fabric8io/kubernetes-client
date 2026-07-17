package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeControllerManagerStatusBuilder extends KubeControllerManagerStatusFluent<KubeControllerManagerStatusBuilder> implements VisitableBuilder<KubeControllerManagerStatus,KubeControllerManagerStatusBuilder>{

  KubeControllerManagerStatusFluent<?> fluent;

  public KubeControllerManagerStatusBuilder() {
    this(new KubeControllerManagerStatus());
  }
  
  public KubeControllerManagerStatusBuilder(KubeControllerManagerStatusFluent<?> fluent) {
    this(fluent, new KubeControllerManagerStatus());
  }
  
  public KubeControllerManagerStatusBuilder(KubeControllerManagerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeControllerManagerStatusBuilder(KubeControllerManagerStatusFluent<?> fluent,KubeControllerManagerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeControllerManagerStatus build() {
    KubeControllerManagerStatus buildable = new KubeControllerManagerStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getLatestAvailableRevisionReason(), fluent.buildNodeStatuses(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}