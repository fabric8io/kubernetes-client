package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StrategyDeploymentPermissionsBuilder extends StrategyDeploymentPermissionsFluent<StrategyDeploymentPermissionsBuilder> implements VisitableBuilder<StrategyDeploymentPermissions,StrategyDeploymentPermissionsBuilder>{

  StrategyDeploymentPermissionsFluent<?> fluent;

  public StrategyDeploymentPermissionsBuilder() {
    this(new StrategyDeploymentPermissions());
  }
  
  public StrategyDeploymentPermissionsBuilder(StrategyDeploymentPermissionsFluent<?> fluent) {
    this(fluent, new StrategyDeploymentPermissions());
  }
  
  public StrategyDeploymentPermissionsBuilder(StrategyDeploymentPermissions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StrategyDeploymentPermissionsBuilder(StrategyDeploymentPermissionsFluent<?> fluent,StrategyDeploymentPermissions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StrategyDeploymentPermissions build() {
    StrategyDeploymentPermissions buildable = new StrategyDeploymentPermissions(fluent.getRules(), fluent.getServiceAccountName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}