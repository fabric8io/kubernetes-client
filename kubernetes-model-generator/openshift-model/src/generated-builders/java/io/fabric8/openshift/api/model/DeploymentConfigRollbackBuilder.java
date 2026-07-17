package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentConfigRollbackBuilder extends DeploymentConfigRollbackFluent<DeploymentConfigRollbackBuilder> implements VisitableBuilder<DeploymentConfigRollback,DeploymentConfigRollbackBuilder>{

  DeploymentConfigRollbackFluent<?> fluent;

  public DeploymentConfigRollbackBuilder() {
    this(new DeploymentConfigRollback());
  }
  
  public DeploymentConfigRollbackBuilder(DeploymentConfigRollbackFluent<?> fluent) {
    this(fluent, new DeploymentConfigRollback());
  }
  
  public DeploymentConfigRollbackBuilder(DeploymentConfigRollback instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentConfigRollbackBuilder(DeploymentConfigRollbackFluent<?> fluent,DeploymentConfigRollback instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentConfigRollback build() {
    DeploymentConfigRollback buildable = new DeploymentConfigRollback(fluent.getApiVersion(), fluent.getKind(), fluent.getName(), fluent.buildSpec(), fluent.getUpdatedAnnotations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}