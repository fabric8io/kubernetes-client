package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentCauseBuilder extends DeploymentCauseFluent<DeploymentCauseBuilder> implements VisitableBuilder<DeploymentCause,DeploymentCauseBuilder>{

  DeploymentCauseFluent<?> fluent;

  public DeploymentCauseBuilder() {
    this(new DeploymentCause());
  }
  
  public DeploymentCauseBuilder(DeploymentCauseFluent<?> fluent) {
    this(fluent, new DeploymentCause());
  }
  
  public DeploymentCauseBuilder(DeploymentCause instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentCauseBuilder(DeploymentCauseFluent<?> fluent,DeploymentCause instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentCause build() {
    DeploymentCause buildable = new DeploymentCause(fluent.buildImageTrigger(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}