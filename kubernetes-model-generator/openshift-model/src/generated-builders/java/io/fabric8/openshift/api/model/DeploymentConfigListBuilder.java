package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentConfigListBuilder extends DeploymentConfigListFluent<DeploymentConfigListBuilder> implements VisitableBuilder<DeploymentConfigList,DeploymentConfigListBuilder>{

  DeploymentConfigListFluent<?> fluent;

  public DeploymentConfigListBuilder() {
    this(new DeploymentConfigList());
  }
  
  public DeploymentConfigListBuilder(DeploymentConfigListFluent<?> fluent) {
    this(fluent, new DeploymentConfigList());
  }
  
  public DeploymentConfigListBuilder(DeploymentConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentConfigListBuilder(DeploymentConfigListFluent<?> fluent,DeploymentConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentConfigList build() {
    DeploymentConfigList buildable = new DeploymentConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}