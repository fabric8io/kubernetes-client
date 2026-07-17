package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentLogBuilder extends DeploymentLogFluent<DeploymentLogBuilder> implements VisitableBuilder<DeploymentLog,DeploymentLogBuilder>{

  DeploymentLogFluent<?> fluent;

  public DeploymentLogBuilder() {
    this(new DeploymentLog());
  }
  
  public DeploymentLogBuilder(DeploymentLogFluent<?> fluent) {
    this(fluent, new DeploymentLog());
  }
  
  public DeploymentLogBuilder(DeploymentLog instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentLogBuilder(DeploymentLogFluent<?> fluent,DeploymentLog instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentLog build() {
    DeploymentLog buildable = new DeploymentLog(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}