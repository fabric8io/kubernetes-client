package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentRollbackBuilder extends DeploymentRollbackFluent<DeploymentRollbackBuilder> implements VisitableBuilder<DeploymentRollback,DeploymentRollbackBuilder>{

  DeploymentRollbackFluent<?> fluent;

  public DeploymentRollbackBuilder() {
    this(new DeploymentRollback());
  }
  
  public DeploymentRollbackBuilder(DeploymentRollbackFluent<?> fluent) {
    this(fluent, new DeploymentRollback());
  }
  
  public DeploymentRollbackBuilder(DeploymentRollback instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentRollbackBuilder(DeploymentRollbackFluent<?> fluent,DeploymentRollback instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentRollback build() {
    DeploymentRollback buildable = new DeploymentRollback(fluent.getApiVersion(), fluent.getKind(), fluent.getName(), fluent.buildRollbackTo(), fluent.getUpdatedAnnotations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}