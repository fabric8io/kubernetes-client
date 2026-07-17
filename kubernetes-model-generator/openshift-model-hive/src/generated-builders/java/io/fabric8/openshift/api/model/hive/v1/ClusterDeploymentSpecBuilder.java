package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDeploymentSpecBuilder extends ClusterDeploymentSpecFluent<ClusterDeploymentSpecBuilder> implements VisitableBuilder<ClusterDeploymentSpec,ClusterDeploymentSpecBuilder>{

  ClusterDeploymentSpecFluent<?> fluent;

  public ClusterDeploymentSpecBuilder() {
    this(new ClusterDeploymentSpec());
  }
  
  public ClusterDeploymentSpecBuilder(ClusterDeploymentSpecFluent<?> fluent) {
    this(fluent, new ClusterDeploymentSpec());
  }
  
  public ClusterDeploymentSpecBuilder(ClusterDeploymentSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDeploymentSpecBuilder(ClusterDeploymentSpecFluent<?> fluent,ClusterDeploymentSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDeploymentSpec build() {
    ClusterDeploymentSpec buildable = new ClusterDeploymentSpec(fluent.getBaseDomain(), fluent.buildBoundServiceAccountSigningKeySecretRef(), fluent.buildCertificateBundles(), fluent.buildClusterInstallRef(), fluent.buildClusterMetadata(), fluent.getClusterName(), fluent.buildClusterPoolRef(), fluent.buildControlPlaneConfig(), fluent.getHibernateAfter(), fluent.buildIngress(), fluent.getInstallAttemptsLimit(), fluent.getInstalled(), fluent.getManageDNS(), fluent.buildPlatform(), fluent.getPowerState(), fluent.getPreserveOnDelete(), fluent.buildProvisioning(), fluent.buildPullSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}