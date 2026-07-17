package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterProvisionSpecBuilder extends ClusterProvisionSpecFluent<ClusterProvisionSpecBuilder> implements VisitableBuilder<ClusterProvisionSpec,ClusterProvisionSpecBuilder>{

  ClusterProvisionSpecFluent<?> fluent;

  public ClusterProvisionSpecBuilder() {
    this(new ClusterProvisionSpec());
  }
  
  public ClusterProvisionSpecBuilder(ClusterProvisionSpecFluent<?> fluent) {
    this(fluent, new ClusterProvisionSpec());
  }
  
  public ClusterProvisionSpecBuilder(ClusterProvisionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterProvisionSpecBuilder(ClusterProvisionSpecFluent<?> fluent,ClusterProvisionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterProvisionSpec build() {
    ClusterProvisionSpec buildable = new ClusterProvisionSpec(fluent.buildAdminKubeconfigSecretRef(), fluent.buildAdminPasswordSecretRef(), fluent.getAttempt(), fluent.buildClusterDeploymentRef(), fluent.getClusterID(), fluent.getInfraID(), fluent.getInstallLog(), fluent.getMetadata(), fluent.getMetadataJSON(), fluent.getPodSpec(), fluent.getPrevClusterID(), fluent.getPrevInfraID(), fluent.getPrevProvisionName(), fluent.getStage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}