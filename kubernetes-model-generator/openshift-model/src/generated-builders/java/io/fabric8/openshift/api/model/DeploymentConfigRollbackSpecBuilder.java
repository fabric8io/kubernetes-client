package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentConfigRollbackSpecBuilder extends DeploymentConfigRollbackSpecFluent<DeploymentConfigRollbackSpecBuilder> implements VisitableBuilder<DeploymentConfigRollbackSpec,DeploymentConfigRollbackSpecBuilder>{

  DeploymentConfigRollbackSpecFluent<?> fluent;

  public DeploymentConfigRollbackSpecBuilder() {
    this(new DeploymentConfigRollbackSpec());
  }
  
  public DeploymentConfigRollbackSpecBuilder(DeploymentConfigRollbackSpecFluent<?> fluent) {
    this(fluent, new DeploymentConfigRollbackSpec());
  }
  
  public DeploymentConfigRollbackSpecBuilder(DeploymentConfigRollbackSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentConfigRollbackSpecBuilder(DeploymentConfigRollbackSpecFluent<?> fluent,DeploymentConfigRollbackSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentConfigRollbackSpec build() {
    DeploymentConfigRollbackSpec buildable = new DeploymentConfigRollbackSpec(fluent.buildFrom(), fluent.getIncludeReplicationMeta(), fluent.getIncludeStrategy(), fluent.getIncludeTemplate(), fluent.getIncludeTriggers(), fluent.getRevision());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}