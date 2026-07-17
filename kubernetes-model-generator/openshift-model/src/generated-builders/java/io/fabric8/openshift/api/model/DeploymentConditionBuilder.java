package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentConditionBuilder extends DeploymentConditionFluent<DeploymentConditionBuilder> implements VisitableBuilder<DeploymentCondition,DeploymentConditionBuilder>{

  DeploymentConditionFluent<?> fluent;

  public DeploymentConditionBuilder() {
    this(new DeploymentCondition());
  }
  
  public DeploymentConditionBuilder(DeploymentConditionFluent<?> fluent) {
    this(fluent, new DeploymentCondition());
  }
  
  public DeploymentConditionBuilder(DeploymentCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentConditionBuilder(DeploymentConditionFluent<?> fluent,DeploymentCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentCondition build() {
    DeploymentCondition buildable = new DeploymentCondition(fluent.getLastTransitionTime(), fluent.getLastUpdateTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}