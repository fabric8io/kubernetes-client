package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDeploymentCustomizationSpecBuilder extends ClusterDeploymentCustomizationSpecFluent<ClusterDeploymentCustomizationSpecBuilder> implements VisitableBuilder<ClusterDeploymentCustomizationSpec,ClusterDeploymentCustomizationSpecBuilder>{

  ClusterDeploymentCustomizationSpecFluent<?> fluent;

  public ClusterDeploymentCustomizationSpecBuilder() {
    this(new ClusterDeploymentCustomizationSpec());
  }
  
  public ClusterDeploymentCustomizationSpecBuilder(ClusterDeploymentCustomizationSpecFluent<?> fluent) {
    this(fluent, new ClusterDeploymentCustomizationSpec());
  }
  
  public ClusterDeploymentCustomizationSpecBuilder(ClusterDeploymentCustomizationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDeploymentCustomizationSpecBuilder(ClusterDeploymentCustomizationSpecFluent<?> fluent,ClusterDeploymentCustomizationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDeploymentCustomizationSpec build() {
    ClusterDeploymentCustomizationSpec buildable = new ClusterDeploymentCustomizationSpec(fluent.buildInstallConfigPatches());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}