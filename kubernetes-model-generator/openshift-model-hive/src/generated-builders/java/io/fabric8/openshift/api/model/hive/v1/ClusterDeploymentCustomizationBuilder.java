package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDeploymentCustomizationBuilder extends ClusterDeploymentCustomizationFluent<ClusterDeploymentCustomizationBuilder> implements VisitableBuilder<ClusterDeploymentCustomization,ClusterDeploymentCustomizationBuilder>{

  ClusterDeploymentCustomizationFluent<?> fluent;

  public ClusterDeploymentCustomizationBuilder() {
    this(new ClusterDeploymentCustomization());
  }
  
  public ClusterDeploymentCustomizationBuilder(ClusterDeploymentCustomizationFluent<?> fluent) {
    this(fluent, new ClusterDeploymentCustomization());
  }
  
  public ClusterDeploymentCustomizationBuilder(ClusterDeploymentCustomization instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDeploymentCustomizationBuilder(ClusterDeploymentCustomizationFluent<?> fluent,ClusterDeploymentCustomization instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDeploymentCustomization build() {
    ClusterDeploymentCustomization buildable = new ClusterDeploymentCustomization(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}