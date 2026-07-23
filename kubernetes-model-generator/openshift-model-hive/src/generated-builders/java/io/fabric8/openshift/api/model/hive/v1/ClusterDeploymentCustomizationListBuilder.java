package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDeploymentCustomizationListBuilder extends ClusterDeploymentCustomizationListFluent<ClusterDeploymentCustomizationListBuilder> implements VisitableBuilder<ClusterDeploymentCustomizationList,ClusterDeploymentCustomizationListBuilder>{

  ClusterDeploymentCustomizationListFluent<?> fluent;

  public ClusterDeploymentCustomizationListBuilder() {
    this(new ClusterDeploymentCustomizationList());
  }
  
  public ClusterDeploymentCustomizationListBuilder(ClusterDeploymentCustomizationListFluent<?> fluent) {
    this(fluent, new ClusterDeploymentCustomizationList());
  }
  
  public ClusterDeploymentCustomizationListBuilder(ClusterDeploymentCustomizationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDeploymentCustomizationListBuilder(ClusterDeploymentCustomizationListFluent<?> fluent,ClusterDeploymentCustomizationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDeploymentCustomizationList build() {
    ClusterDeploymentCustomizationList buildable = new ClusterDeploymentCustomizationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}