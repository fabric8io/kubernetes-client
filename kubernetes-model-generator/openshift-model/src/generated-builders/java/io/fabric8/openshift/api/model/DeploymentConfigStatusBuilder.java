package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentConfigStatusBuilder extends DeploymentConfigStatusFluent<DeploymentConfigStatusBuilder> implements VisitableBuilder<DeploymentConfigStatus,DeploymentConfigStatusBuilder>{

  DeploymentConfigStatusFluent<?> fluent;

  public DeploymentConfigStatusBuilder() {
    this(new DeploymentConfigStatus());
  }
  
  public DeploymentConfigStatusBuilder(DeploymentConfigStatusFluent<?> fluent) {
    this(fluent, new DeploymentConfigStatus());
  }
  
  public DeploymentConfigStatusBuilder(DeploymentConfigStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentConfigStatusBuilder(DeploymentConfigStatusFluent<?> fluent,DeploymentConfigStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentConfigStatus build() {
    DeploymentConfigStatus buildable = new DeploymentConfigStatus(fluent.getAvailableReplicas(), fluent.buildConditions(), fluent.buildDetails(), fluent.getLatestVersion(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getReplicas(), fluent.getUnavailableReplicas(), fluent.getUpdatedReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}