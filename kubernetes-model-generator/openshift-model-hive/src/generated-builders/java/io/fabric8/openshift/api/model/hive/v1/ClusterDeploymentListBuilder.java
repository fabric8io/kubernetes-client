package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDeploymentListBuilder extends ClusterDeploymentListFluent<ClusterDeploymentListBuilder> implements VisitableBuilder<ClusterDeploymentList,ClusterDeploymentListBuilder>{

  ClusterDeploymentListFluent<?> fluent;

  public ClusterDeploymentListBuilder() {
    this(new ClusterDeploymentList());
  }
  
  public ClusterDeploymentListBuilder(ClusterDeploymentListFluent<?> fluent) {
    this(fluent, new ClusterDeploymentList());
  }
  
  public ClusterDeploymentListBuilder(ClusterDeploymentList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDeploymentListBuilder(ClusterDeploymentListFluent<?> fluent,ClusterDeploymentList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDeploymentList build() {
    ClusterDeploymentList buildable = new ClusterDeploymentList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}