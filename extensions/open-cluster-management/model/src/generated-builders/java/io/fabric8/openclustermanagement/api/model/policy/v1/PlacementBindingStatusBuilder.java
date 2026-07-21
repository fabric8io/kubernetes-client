package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementBindingStatusBuilder extends PlacementBindingStatusFluent<PlacementBindingStatusBuilder> implements VisitableBuilder<PlacementBindingStatus,PlacementBindingStatusBuilder>{

  PlacementBindingStatusFluent<?> fluent;

  public PlacementBindingStatusBuilder() {
    this(new PlacementBindingStatus());
  }
  
  public PlacementBindingStatusBuilder(PlacementBindingStatusFluent<?> fluent) {
    this(fluent, new PlacementBindingStatus());
  }
  
  public PlacementBindingStatusBuilder(PlacementBindingStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementBindingStatusBuilder(PlacementBindingStatusFluent<?> fluent,PlacementBindingStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlacementBindingStatus build() {
    PlacementBindingStatus buildable = new PlacementBindingStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}