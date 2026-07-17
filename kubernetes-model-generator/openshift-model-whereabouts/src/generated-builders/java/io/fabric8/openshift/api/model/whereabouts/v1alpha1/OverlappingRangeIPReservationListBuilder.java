package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OverlappingRangeIPReservationListBuilder extends OverlappingRangeIPReservationListFluent<OverlappingRangeIPReservationListBuilder> implements VisitableBuilder<OverlappingRangeIPReservationList,OverlappingRangeIPReservationListBuilder>{

  OverlappingRangeIPReservationListFluent<?> fluent;

  public OverlappingRangeIPReservationListBuilder() {
    this(new OverlappingRangeIPReservationList());
  }
  
  public OverlappingRangeIPReservationListBuilder(OverlappingRangeIPReservationListFluent<?> fluent) {
    this(fluent, new OverlappingRangeIPReservationList());
  }
  
  public OverlappingRangeIPReservationListBuilder(OverlappingRangeIPReservationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OverlappingRangeIPReservationListBuilder(OverlappingRangeIPReservationListFluent<?> fluent,OverlappingRangeIPReservationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OverlappingRangeIPReservationList build() {
    OverlappingRangeIPReservationList buildable = new OverlappingRangeIPReservationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}