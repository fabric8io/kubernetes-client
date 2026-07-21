package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementStatusBuilder extends PlacementStatusFluent<PlacementStatusBuilder> implements VisitableBuilder<PlacementStatus,PlacementStatusBuilder>{

  PlacementStatusFluent<?> fluent;

  public PlacementStatusBuilder() {
    this(new PlacementStatus());
  }
  
  public PlacementStatusBuilder(PlacementStatusFluent<?> fluent) {
    this(fluent, new PlacementStatus());
  }
  
  public PlacementStatusBuilder(PlacementStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementStatusBuilder(PlacementStatusFluent<?> fluent,PlacementStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlacementStatus build() {
    PlacementStatus buildable = new PlacementStatus(fluent.getConditions(), fluent.buildDecisionGroups(), fluent.getLastScoreUpdateTime(), fluent.getNumberOfSelectedClusters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}