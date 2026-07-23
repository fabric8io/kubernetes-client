package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentCauseImageTriggerBuilder extends DeploymentCauseImageTriggerFluent<DeploymentCauseImageTriggerBuilder> implements VisitableBuilder<DeploymentCauseImageTrigger,DeploymentCauseImageTriggerBuilder>{

  DeploymentCauseImageTriggerFluent<?> fluent;

  public DeploymentCauseImageTriggerBuilder() {
    this(new DeploymentCauseImageTrigger());
  }
  
  public DeploymentCauseImageTriggerBuilder(DeploymentCauseImageTriggerFluent<?> fluent) {
    this(fluent, new DeploymentCauseImageTrigger());
  }
  
  public DeploymentCauseImageTriggerBuilder(DeploymentCauseImageTrigger instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentCauseImageTriggerBuilder(DeploymentCauseImageTriggerFluent<?> fluent,DeploymentCauseImageTrigger instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentCauseImageTrigger build() {
    DeploymentCauseImageTrigger buildable = new DeploymentCauseImageTrigger(fluent.buildFrom());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}