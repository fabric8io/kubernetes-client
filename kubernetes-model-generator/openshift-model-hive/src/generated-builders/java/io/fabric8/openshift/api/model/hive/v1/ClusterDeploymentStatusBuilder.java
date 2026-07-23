package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDeploymentStatusBuilder extends ClusterDeploymentStatusFluent<ClusterDeploymentStatusBuilder> implements VisitableBuilder<ClusterDeploymentStatus,ClusterDeploymentStatusBuilder>{

  ClusterDeploymentStatusFluent<?> fluent;

  public ClusterDeploymentStatusBuilder() {
    this(new ClusterDeploymentStatus());
  }
  
  public ClusterDeploymentStatusBuilder(ClusterDeploymentStatusFluent<?> fluent) {
    this(fluent, new ClusterDeploymentStatus());
  }
  
  public ClusterDeploymentStatusBuilder(ClusterDeploymentStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDeploymentStatusBuilder(ClusterDeploymentStatusFluent<?> fluent,ClusterDeploymentStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDeploymentStatus build() {
    ClusterDeploymentStatus buildable = new ClusterDeploymentStatus(fluent.getApiURL(), fluent.buildCertificateBundles(), fluent.getCliImage(), fluent.buildConditions(), fluent.getInstallRestarts(), fluent.getInstallStartedTimestamp(), fluent.getInstallVersion(), fluent.getInstalledTimestamp(), fluent.getInstallerImage(), fluent.buildPlatformStatus(), fluent.getPowerState(), fluent.buildProvisionRef(), fluent.getWebConsoleURL());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}