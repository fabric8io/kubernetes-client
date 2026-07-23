package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentConfigSpecBuilder extends DeploymentConfigSpecFluent<DeploymentConfigSpecBuilder> implements VisitableBuilder<DeploymentConfigSpec,DeploymentConfigSpecBuilder>{

  DeploymentConfigSpecFluent<?> fluent;

  public DeploymentConfigSpecBuilder() {
    this(new DeploymentConfigSpec());
  }
  
  public DeploymentConfigSpecBuilder(DeploymentConfigSpecFluent<?> fluent) {
    this(fluent, new DeploymentConfigSpec());
  }
  
  public DeploymentConfigSpecBuilder(DeploymentConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentConfigSpecBuilder(DeploymentConfigSpecFluent<?> fluent,DeploymentConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentConfigSpec build() {
    DeploymentConfigSpec buildable = new DeploymentConfigSpec(fluent.getMinReadySeconds(), fluent.getPaused(), fluent.getReplicas(), fluent.getRevisionHistoryLimit(), fluent.getSelector(), fluent.buildStrategy(), fluent.buildTemplate(), fluent.getTest(), fluent.buildTriggers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}