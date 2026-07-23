package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OverlappingRangeIPReservationBuilder extends OverlappingRangeIPReservationFluent<OverlappingRangeIPReservationBuilder> implements VisitableBuilder<OverlappingRangeIPReservation,OverlappingRangeIPReservationBuilder>{

  OverlappingRangeIPReservationFluent<?> fluent;

  public OverlappingRangeIPReservationBuilder() {
    this(new OverlappingRangeIPReservation());
  }
  
  public OverlappingRangeIPReservationBuilder(OverlappingRangeIPReservationFluent<?> fluent) {
    this(fluent, new OverlappingRangeIPReservation());
  }
  
  public OverlappingRangeIPReservationBuilder(OverlappingRangeIPReservation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OverlappingRangeIPReservationBuilder(OverlappingRangeIPReservationFluent<?> fluent,OverlappingRangeIPReservation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OverlappingRangeIPReservation build() {
    OverlappingRangeIPReservation buildable = new OverlappingRangeIPReservation(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}