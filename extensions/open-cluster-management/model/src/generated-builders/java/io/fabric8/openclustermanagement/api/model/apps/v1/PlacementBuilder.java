package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementBuilder extends PlacementFluent<PlacementBuilder> implements VisitableBuilder<Placement,PlacementBuilder>{

  PlacementFluent<?> fluent;

  public PlacementBuilder() {
    this(new Placement());
  }
  
  public PlacementBuilder(PlacementFluent<?> fluent) {
    this(fluent, new Placement());
  }
  
  public PlacementBuilder(Placement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementBuilder(PlacementFluent<?> fluent,Placement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Placement build() {
    Placement buildable = new Placement(fluent.buildClusterSelector(), fluent.buildClusters(), fluent.getLocal(), fluent.buildPlacementRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}