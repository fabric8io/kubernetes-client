package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentListBuilder extends DeploymentListFluent<DeploymentListBuilder> implements VisitableBuilder<DeploymentList,DeploymentListBuilder>{

  DeploymentListFluent<?> fluent;

  public DeploymentListBuilder() {
    this(new DeploymentList());
  }
  
  public DeploymentListBuilder(DeploymentListFluent<?> fluent) {
    this(fluent, new DeploymentList());
  }
  
  public DeploymentListBuilder(DeploymentList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentListBuilder(DeploymentListFluent<?> fluent,DeploymentList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentList build() {
    DeploymentList buildable = new DeploymentList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}