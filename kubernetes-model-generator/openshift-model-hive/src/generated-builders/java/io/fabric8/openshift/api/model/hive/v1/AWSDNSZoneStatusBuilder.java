package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSDNSZoneStatusBuilder extends AWSDNSZoneStatusFluent<AWSDNSZoneStatusBuilder> implements VisitableBuilder<AWSDNSZoneStatus,AWSDNSZoneStatusBuilder>{

  AWSDNSZoneStatusFluent<?> fluent;

  public AWSDNSZoneStatusBuilder() {
    this(new AWSDNSZoneStatus());
  }
  
  public AWSDNSZoneStatusBuilder(AWSDNSZoneStatusFluent<?> fluent) {
    this(fluent, new AWSDNSZoneStatus());
  }
  
  public AWSDNSZoneStatusBuilder(AWSDNSZoneStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSDNSZoneStatusBuilder(AWSDNSZoneStatusFluent<?> fluent,AWSDNSZoneStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSDNSZoneStatus build() {
    AWSDNSZoneStatus buildable = new AWSDNSZoneStatus(fluent.getZoneID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}