package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OverlappingRangeIPReservationSpecBuilder extends OverlappingRangeIPReservationSpecFluent<OverlappingRangeIPReservationSpecBuilder> implements VisitableBuilder<OverlappingRangeIPReservationSpec,OverlappingRangeIPReservationSpecBuilder>{

  OverlappingRangeIPReservationSpecFluent<?> fluent;

  public OverlappingRangeIPReservationSpecBuilder() {
    this(new OverlappingRangeIPReservationSpec());
  }
  
  public OverlappingRangeIPReservationSpecBuilder(OverlappingRangeIPReservationSpecFluent<?> fluent) {
    this(fluent, new OverlappingRangeIPReservationSpec());
  }
  
  public OverlappingRangeIPReservationSpecBuilder(OverlappingRangeIPReservationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OverlappingRangeIPReservationSpecBuilder(OverlappingRangeIPReservationSpecFluent<?> fluent,OverlappingRangeIPReservationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OverlappingRangeIPReservationSpec build() {
    OverlappingRangeIPReservationSpec buildable = new OverlappingRangeIPReservationSpec(fluent.getContainerid(), fluent.getIfname(), fluent.getPodref());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}