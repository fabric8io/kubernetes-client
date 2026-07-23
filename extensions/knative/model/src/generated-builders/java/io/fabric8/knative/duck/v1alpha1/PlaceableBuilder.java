package io.fabric8.knative.duck.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlaceableBuilder extends PlaceableFluent<PlaceableBuilder> implements VisitableBuilder<Placeable,PlaceableBuilder>{

  PlaceableFluent<?> fluent;

  public PlaceableBuilder() {
    this(new Placeable());
  }
  
  public PlaceableBuilder(PlaceableFluent<?> fluent) {
    this(fluent, new Placeable());
  }
  
  public PlaceableBuilder(Placeable instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlaceableBuilder(PlaceableFluent<?> fluent,Placeable instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Placeable build() {
    Placeable buildable = new Placeable(fluent.getMaxAllowedVReplicas(), fluent.buildPlacements());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}