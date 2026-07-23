package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDeploymentBuilder extends ClusterDeploymentFluent<ClusterDeploymentBuilder> implements VisitableBuilder<ClusterDeployment,ClusterDeploymentBuilder>{

  ClusterDeploymentFluent<?> fluent;

  public ClusterDeploymentBuilder() {
    this(new ClusterDeployment());
  }
  
  public ClusterDeploymentBuilder(ClusterDeploymentFluent<?> fluent) {
    this(fluent, new ClusterDeployment());
  }
  
  public ClusterDeploymentBuilder(ClusterDeployment instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDeploymentBuilder(ClusterDeploymentFluent<?> fluent,ClusterDeployment instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDeployment build() {
    ClusterDeployment buildable = new ClusterDeployment(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}