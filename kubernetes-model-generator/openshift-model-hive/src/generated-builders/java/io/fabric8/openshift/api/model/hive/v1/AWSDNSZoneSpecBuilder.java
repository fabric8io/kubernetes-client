package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSDNSZoneSpecBuilder extends AWSDNSZoneSpecFluent<AWSDNSZoneSpecBuilder> implements VisitableBuilder<AWSDNSZoneSpec,AWSDNSZoneSpecBuilder>{

  AWSDNSZoneSpecFluent<?> fluent;

  public AWSDNSZoneSpecBuilder() {
    this(new AWSDNSZoneSpec());
  }
  
  public AWSDNSZoneSpecBuilder(AWSDNSZoneSpecFluent<?> fluent) {
    this(fluent, new AWSDNSZoneSpec());
  }
  
  public AWSDNSZoneSpecBuilder(AWSDNSZoneSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSDNSZoneSpecBuilder(AWSDNSZoneSpecFluent<?> fluent,AWSDNSZoneSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSDNSZoneSpec build() {
    AWSDNSZoneSpec buildable = new AWSDNSZoneSpec(fluent.buildAdditionalTags(), fluent.buildCredentialsAssumeRole(), fluent.buildCredentialsSecretRef(), fluent.getRegion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}