package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementSpecBuilder extends PlacementSpecFluent<PlacementSpecBuilder> implements VisitableBuilder<PlacementSpec,PlacementSpecBuilder>{

  PlacementSpecFluent<?> fluent;

  public PlacementSpecBuilder() {
    this(new PlacementSpec());
  }
  
  public PlacementSpecBuilder(PlacementSpecFluent<?> fluent) {
    this(fluent, new PlacementSpec());
  }
  
  public PlacementSpecBuilder(PlacementSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementSpecBuilder(PlacementSpecFluent<?> fluent,PlacementSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlacementSpec build() {
    PlacementSpec buildable = new PlacementSpec(fluent.getClusterSets(), fluent.buildDecisionStrategy(), fluent.getNumberOfClusters(), fluent.buildPredicates(), fluent.buildPrioritizerPolicy(), fluent.getScoreRateLimit(), fluent.getSortBy(), fluent.buildSpreadPolicy(), fluent.buildTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}