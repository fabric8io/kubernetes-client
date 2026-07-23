package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentBuilder extends DeploymentFluent<DeploymentBuilder> implements VisitableBuilder<Deployment,DeploymentBuilder>{

  DeploymentFluent<?> fluent;

  public DeploymentBuilder() {
    this(new Deployment());
  }
  
  public DeploymentBuilder(DeploymentFluent<?> fluent) {
    this(fluent, new Deployment());
  }
  
  public DeploymentBuilder(Deployment instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentBuilder(DeploymentFluent<?> fluent,Deployment instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Deployment build() {
    Deployment buildable = new Deployment(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}