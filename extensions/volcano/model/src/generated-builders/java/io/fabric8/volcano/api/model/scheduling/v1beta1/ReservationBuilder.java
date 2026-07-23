package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReservationBuilder extends ReservationFluent<ReservationBuilder> implements VisitableBuilder<Reservation,ReservationBuilder>{

  ReservationFluent<?> fluent;

  public ReservationBuilder() {
    this(new Reservation());
  }
  
  public ReservationBuilder(ReservationFluent<?> fluent) {
    this(fluent, new Reservation());
  }
  
  public ReservationBuilder(Reservation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReservationBuilder(ReservationFluent<?> fluent,Reservation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Reservation build() {
    Reservation buildable = new Reservation(fluent.getNodes(), fluent.getResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}