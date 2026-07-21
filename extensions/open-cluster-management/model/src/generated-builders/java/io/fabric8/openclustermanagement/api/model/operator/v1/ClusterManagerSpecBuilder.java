package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterManagerSpecBuilder extends ClusterManagerSpecFluent<ClusterManagerSpecBuilder> implements VisitableBuilder<ClusterManagerSpec,ClusterManagerSpecBuilder>{

  ClusterManagerSpecFluent<?> fluent;

  public ClusterManagerSpecBuilder() {
    this(new ClusterManagerSpec());
  }
  
  public ClusterManagerSpecBuilder(ClusterManagerSpecFluent<?> fluent) {
    this(fluent, new ClusterManagerSpec());
  }
  
  public ClusterManagerSpecBuilder(ClusterManagerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterManagerSpecBuilder(ClusterManagerSpecFluent<?> fluent,ClusterManagerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterManagerSpec build() {
    ClusterManagerSpec buildable = new ClusterManagerSpec(fluent.buildAddOnManagerConfiguration(), fluent.getAddOnManagerImagePullSpec(), fluent.buildDeployOption(), fluent.buildNodePlacement(), fluent.buildPlacementConfiguration(), fluent.getPlacementImagePullSpec(), fluent.buildRegistrationConfiguration(), fluent.getRegistrationImagePullSpec(), fluent.buildResourceRequirement(), fluent.buildServerConfiguration(), fluent.buildWorkConfiguration(), fluent.getWorkImagePullSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}