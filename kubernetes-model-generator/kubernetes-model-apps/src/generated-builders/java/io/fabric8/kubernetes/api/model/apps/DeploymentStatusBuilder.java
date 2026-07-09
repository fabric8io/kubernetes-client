package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentStatusBuilder extends DeploymentStatusFluent<DeploymentStatusBuilder> implements VisitableBuilder<DeploymentStatus,DeploymentStatusBuilder>{

  DeploymentStatusFluent<?> fluent;

  public DeploymentStatusBuilder() {
    this(new DeploymentStatus());
  }
  
  public DeploymentStatusBuilder(DeploymentStatusFluent<?> fluent) {
    this(fluent, new DeploymentStatus());
  }
  
  public DeploymentStatusBuilder(DeploymentStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentStatusBuilder(DeploymentStatusFluent<?> fluent,DeploymentStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentStatus build() {
    DeploymentStatus buildable = new DeploymentStatus(fluent.getAvailableReplicas(), fluent.getCollisionCount(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getReplicas(), fluent.getTerminatingReplicas(), fluent.getUnavailableReplicas(), fluent.getUpdatedReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}