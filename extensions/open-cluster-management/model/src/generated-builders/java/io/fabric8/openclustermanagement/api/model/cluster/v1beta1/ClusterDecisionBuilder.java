package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDecisionBuilder extends ClusterDecisionFluent<ClusterDecisionBuilder> implements VisitableBuilder<ClusterDecision,ClusterDecisionBuilder>{

  ClusterDecisionFluent<?> fluent;

  public ClusterDecisionBuilder() {
    this(new ClusterDecision());
  }
  
  public ClusterDecisionBuilder(ClusterDecisionFluent<?> fluent) {
    this(fluent, new ClusterDecision());
  }
  
  public ClusterDecisionBuilder(ClusterDecision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDecisionBuilder(ClusterDecisionFluent<?> fluent,ClusterDecision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDecision build() {
    ClusterDecision buildable = new ClusterDecision(fluent.getClusterName(), fluent.getReason(), fluent.getScore());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}