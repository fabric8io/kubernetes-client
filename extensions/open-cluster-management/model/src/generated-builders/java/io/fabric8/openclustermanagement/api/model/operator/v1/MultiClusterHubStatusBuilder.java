package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MultiClusterHubStatusBuilder extends MultiClusterHubStatusFluent<MultiClusterHubStatusBuilder> implements VisitableBuilder<MultiClusterHubStatus,MultiClusterHubStatusBuilder>{

  MultiClusterHubStatusFluent<?> fluent;

  public MultiClusterHubStatusBuilder() {
    this(new MultiClusterHubStatus());
  }
  
  public MultiClusterHubStatusBuilder(MultiClusterHubStatusFluent<?> fluent) {
    this(fluent, new MultiClusterHubStatus());
  }
  
  public MultiClusterHubStatusBuilder(MultiClusterHubStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MultiClusterHubStatusBuilder(MultiClusterHubStatusFluent<?> fluent,MultiClusterHubStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MultiClusterHubStatus build() {
    MultiClusterHubStatus buildable = new MultiClusterHubStatus(fluent.getComponents(), fluent.buildConditions(), fluent.getCurrentVersion(), fluent.getDesiredVersion(), fluent.getPhase());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}