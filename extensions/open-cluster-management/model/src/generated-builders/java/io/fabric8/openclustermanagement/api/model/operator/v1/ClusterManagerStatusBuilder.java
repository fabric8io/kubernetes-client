package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterManagerStatusBuilder extends ClusterManagerStatusFluent<ClusterManagerStatusBuilder> implements VisitableBuilder<ClusterManagerStatus,ClusterManagerStatusBuilder>{

  ClusterManagerStatusFluent<?> fluent;

  public ClusterManagerStatusBuilder() {
    this(new ClusterManagerStatus());
  }
  
  public ClusterManagerStatusBuilder(ClusterManagerStatusFluent<?> fluent) {
    this(fluent, new ClusterManagerStatus());
  }
  
  public ClusterManagerStatusBuilder(ClusterManagerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterManagerStatusBuilder(ClusterManagerStatusFluent<?> fluent,ClusterManagerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterManagerStatus build() {
    ClusterManagerStatus buildable = new ClusterManagerStatus(fluent.getConditions(), fluent.buildGenerations(), fluent.getObservedGeneration(), fluent.buildRelatedResources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}