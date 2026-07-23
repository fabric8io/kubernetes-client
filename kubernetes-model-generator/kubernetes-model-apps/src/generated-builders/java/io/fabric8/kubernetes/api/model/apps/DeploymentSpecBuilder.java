package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentSpecBuilder extends DeploymentSpecFluent<DeploymentSpecBuilder> implements VisitableBuilder<DeploymentSpec,DeploymentSpecBuilder>{

  DeploymentSpecFluent<?> fluent;

  public DeploymentSpecBuilder() {
    this(new DeploymentSpec());
  }
  
  public DeploymentSpecBuilder(DeploymentSpecFluent<?> fluent) {
    this(fluent, new DeploymentSpec());
  }
  
  public DeploymentSpecBuilder(DeploymentSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentSpecBuilder(DeploymentSpecFluent<?> fluent,DeploymentSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentSpec build() {
    DeploymentSpec buildable = new DeploymentSpec(fluent.getMinReadySeconds(), fluent.getPaused(), fluent.getProgressDeadlineSeconds(), fluent.getReplicas(), fluent.getRevisionHistoryLimit(), fluent.buildSelector(), fluent.buildStrategy(), fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}