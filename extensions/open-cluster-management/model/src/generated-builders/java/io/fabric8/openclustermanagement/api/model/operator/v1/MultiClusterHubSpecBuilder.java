package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MultiClusterHubSpecBuilder extends MultiClusterHubSpecFluent<MultiClusterHubSpecBuilder> implements VisitableBuilder<MultiClusterHubSpec,MultiClusterHubSpecBuilder>{

  MultiClusterHubSpecFluent<?> fluent;

  public MultiClusterHubSpecBuilder() {
    this(new MultiClusterHubSpec());
  }
  
  public MultiClusterHubSpecBuilder(MultiClusterHubSpecFluent<?> fluent) {
    this(fluent, new MultiClusterHubSpec());
  }
  
  public MultiClusterHubSpecBuilder(MultiClusterHubSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MultiClusterHubSpecBuilder(MultiClusterHubSpecFluent<?> fluent,MultiClusterHubSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MultiClusterHubSpec build() {
    MultiClusterHubSpec buildable = new MultiClusterHubSpec(fluent.getAvailabilityConfig(), fluent.getDisableHubSelfManagement(), fluent.getDisableUpdateClusterImageSets(), fluent.getImagePullSecret(), fluent.getLocalClusterName(), fluent.buildNetworkPolicies(), fluent.getNodeSelector(), fluent.buildOverrides(), fluent.getTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}