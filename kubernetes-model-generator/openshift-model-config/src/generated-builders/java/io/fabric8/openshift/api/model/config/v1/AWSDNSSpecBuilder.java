package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSDNSSpecBuilder extends AWSDNSSpecFluent<AWSDNSSpecBuilder> implements VisitableBuilder<AWSDNSSpec,AWSDNSSpecBuilder>{

  AWSDNSSpecFluent<?> fluent;

  public AWSDNSSpecBuilder() {
    this(new AWSDNSSpec());
  }
  
  public AWSDNSSpecBuilder(AWSDNSSpecFluent<?> fluent) {
    this(fluent, new AWSDNSSpec());
  }
  
  public AWSDNSSpecBuilder(AWSDNSSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSDNSSpecBuilder(AWSDNSSpecFluent<?> fluent,AWSDNSSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSDNSSpec build() {
    AWSDNSSpec buildable = new AWSDNSSpec(fluent.getPrivateZoneIAMRole());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}