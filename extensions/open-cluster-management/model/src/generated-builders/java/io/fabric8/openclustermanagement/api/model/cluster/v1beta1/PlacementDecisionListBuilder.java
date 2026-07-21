package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementDecisionListBuilder extends PlacementDecisionListFluent<PlacementDecisionListBuilder> implements VisitableBuilder<PlacementDecisionList,PlacementDecisionListBuilder>{

  PlacementDecisionListFluent<?> fluent;

  public PlacementDecisionListBuilder() {
    this(new PlacementDecisionList());
  }
  
  public PlacementDecisionListBuilder(PlacementDecisionListFluent<?> fluent) {
    this(fluent, new PlacementDecisionList());
  }
  
  public PlacementDecisionListBuilder(PlacementDecisionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementDecisionListBuilder(PlacementDecisionListFluent<?> fluent,PlacementDecisionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlacementDecisionList build() {
    PlacementDecisionList buildable = new PlacementDecisionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}