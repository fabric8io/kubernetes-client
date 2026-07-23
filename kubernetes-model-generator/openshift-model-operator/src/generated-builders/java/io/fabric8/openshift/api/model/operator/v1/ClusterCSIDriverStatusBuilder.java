package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterCSIDriverStatusBuilder extends ClusterCSIDriverStatusFluent<ClusterCSIDriverStatusBuilder> implements VisitableBuilder<ClusterCSIDriverStatus,ClusterCSIDriverStatusBuilder>{

  ClusterCSIDriverStatusFluent<?> fluent;

  public ClusterCSIDriverStatusBuilder() {
    this(new ClusterCSIDriverStatus());
  }
  
  public ClusterCSIDriverStatusBuilder(ClusterCSIDriverStatusFluent<?> fluent) {
    this(fluent, new ClusterCSIDriverStatus());
  }
  
  public ClusterCSIDriverStatusBuilder(ClusterCSIDriverStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterCSIDriverStatusBuilder(ClusterCSIDriverStatusFluent<?> fluent,ClusterCSIDriverStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterCSIDriverStatus build() {
    ClusterCSIDriverStatus buildable = new ClusterCSIDriverStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}