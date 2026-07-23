package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementDecisionStatusBuilder extends PlacementDecisionStatusFluent<PlacementDecisionStatusBuilder> implements VisitableBuilder<PlacementDecisionStatus,PlacementDecisionStatusBuilder>{

  PlacementDecisionStatusFluent<?> fluent;

  public PlacementDecisionStatusBuilder() {
    this(new PlacementDecisionStatus());
  }
  
  public PlacementDecisionStatusBuilder(PlacementDecisionStatusFluent<?> fluent) {
    this(fluent, new PlacementDecisionStatus());
  }
  
  public PlacementDecisionStatusBuilder(PlacementDecisionStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementDecisionStatusBuilder(PlacementDecisionStatusFluent<?> fluent,PlacementDecisionStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlacementDecisionStatus build() {
    PlacementDecisionStatus buildable = new PlacementDecisionStatus(fluent.buildDecisions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}