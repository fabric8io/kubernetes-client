package io.fabric8.knative.duck.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlaceableStatusBuilder extends PlaceableStatusFluent<PlaceableStatusBuilder> implements VisitableBuilder<PlaceableStatus,PlaceableStatusBuilder>{

  PlaceableStatusFluent<?> fluent;

  public PlaceableStatusBuilder() {
    this(new PlaceableStatus());
  }
  
  public PlaceableStatusBuilder(PlaceableStatusFluent<?> fluent) {
    this(fluent, new PlaceableStatus());
  }
  
  public PlaceableStatusBuilder(PlaceableStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlaceableStatusBuilder(PlaceableStatusFluent<?> fluent,PlaceableStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlaceableStatus build() {
    PlaceableStatus buildable = new PlaceableStatus(fluent.getMaxAllowedVReplicas(), fluent.buildPlacements());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}