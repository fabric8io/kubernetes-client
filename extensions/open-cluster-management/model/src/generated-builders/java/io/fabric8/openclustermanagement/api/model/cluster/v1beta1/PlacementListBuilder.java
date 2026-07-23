package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementListBuilder extends PlacementListFluent<PlacementListBuilder> implements VisitableBuilder<PlacementList,PlacementListBuilder>{

  PlacementListFluent<?> fluent;

  public PlacementListBuilder() {
    this(new PlacementList());
  }
  
  public PlacementListBuilder(PlacementListFluent<?> fluent) {
    this(fluent, new PlacementList());
  }
  
  public PlacementListBuilder(PlacementList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementListBuilder(PlacementListFluent<?> fluent,PlacementList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlacementList build() {
    PlacementList buildable = new PlacementList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}