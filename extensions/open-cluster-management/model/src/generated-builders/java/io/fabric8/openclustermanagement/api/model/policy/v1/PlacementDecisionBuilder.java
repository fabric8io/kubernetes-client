package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementDecisionBuilder extends PlacementDecisionFluent<PlacementDecisionBuilder> implements VisitableBuilder<PlacementDecision,PlacementDecisionBuilder>{

  PlacementDecisionFluent<?> fluent;

  public PlacementDecisionBuilder() {
    this(new PlacementDecision());
  }
  
  public PlacementDecisionBuilder(PlacementDecisionFluent<?> fluent) {
    this(fluent, new PlacementDecision());
  }
  
  public PlacementDecisionBuilder(PlacementDecision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementDecisionBuilder(PlacementDecisionFluent<?> fluent,PlacementDecision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlacementDecision build() {
    PlacementDecision buildable = new PlacementDecision(fluent.getClusterName(), fluent.getClusterNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}