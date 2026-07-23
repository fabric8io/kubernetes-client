package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDeploymentCustomizationStatusBuilder extends ClusterDeploymentCustomizationStatusFluent<ClusterDeploymentCustomizationStatusBuilder> implements VisitableBuilder<ClusterDeploymentCustomizationStatus,ClusterDeploymentCustomizationStatusBuilder>{

  ClusterDeploymentCustomizationStatusFluent<?> fluent;

  public ClusterDeploymentCustomizationStatusBuilder() {
    this(new ClusterDeploymentCustomizationStatus());
  }
  
  public ClusterDeploymentCustomizationStatusBuilder(ClusterDeploymentCustomizationStatusFluent<?> fluent) {
    this(fluent, new ClusterDeploymentCustomizationStatus());
  }
  
  public ClusterDeploymentCustomizationStatusBuilder(ClusterDeploymentCustomizationStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDeploymentCustomizationStatusBuilder(ClusterDeploymentCustomizationStatusFluent<?> fluent,ClusterDeploymentCustomizationStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDeploymentCustomizationStatus build() {
    ClusterDeploymentCustomizationStatus buildable = new ClusterDeploymentCustomizationStatus(fluent.buildClusterDeploymentRef(), fluent.buildClusterPoolRef(), fluent.getConditions(), fluent.getLastAppliedConfiguration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}