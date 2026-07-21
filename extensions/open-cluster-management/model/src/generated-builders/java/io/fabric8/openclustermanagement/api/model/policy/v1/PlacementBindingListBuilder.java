package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementBindingListBuilder extends PlacementBindingListFluent<PlacementBindingListBuilder> implements VisitableBuilder<PlacementBindingList,PlacementBindingListBuilder>{

  PlacementBindingListFluent<?> fluent;

  public PlacementBindingListBuilder() {
    this(new PlacementBindingList());
  }
  
  public PlacementBindingListBuilder(PlacementBindingListFluent<?> fluent) {
    this(fluent, new PlacementBindingList());
  }
  
  public PlacementBindingListBuilder(PlacementBindingList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementBindingListBuilder(PlacementBindingListFluent<?> fluent,PlacementBindingList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlacementBindingList build() {
    PlacementBindingList buildable = new PlacementBindingList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}