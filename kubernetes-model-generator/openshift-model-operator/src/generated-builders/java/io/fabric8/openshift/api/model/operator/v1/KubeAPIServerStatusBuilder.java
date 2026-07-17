package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeAPIServerStatusBuilder extends KubeAPIServerStatusFluent<KubeAPIServerStatusBuilder> implements VisitableBuilder<KubeAPIServerStatus,KubeAPIServerStatusBuilder>{

  KubeAPIServerStatusFluent<?> fluent;

  public KubeAPIServerStatusBuilder() {
    this(new KubeAPIServerStatus());
  }
  
  public KubeAPIServerStatusBuilder(KubeAPIServerStatusFluent<?> fluent) {
    this(fluent, new KubeAPIServerStatus());
  }
  
  public KubeAPIServerStatusBuilder(KubeAPIServerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeAPIServerStatusBuilder(KubeAPIServerStatusFluent<?> fluent,KubeAPIServerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeAPIServerStatus build() {
    KubeAPIServerStatus buildable = new KubeAPIServerStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getLatestAvailableRevisionReason(), fluent.buildNodeStatuses(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.buildServiceAccountIssuers(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}