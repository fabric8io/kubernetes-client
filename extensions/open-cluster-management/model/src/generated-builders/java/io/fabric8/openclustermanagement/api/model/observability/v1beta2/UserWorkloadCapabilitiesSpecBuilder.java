package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserWorkloadCapabilitiesSpecBuilder extends UserWorkloadCapabilitiesSpecFluent<UserWorkloadCapabilitiesSpecBuilder> implements VisitableBuilder<UserWorkloadCapabilitiesSpec,UserWorkloadCapabilitiesSpecBuilder>{

  UserWorkloadCapabilitiesSpecFluent<?> fluent;

  public UserWorkloadCapabilitiesSpecBuilder() {
    this(new UserWorkloadCapabilitiesSpec());
  }
  
  public UserWorkloadCapabilitiesSpecBuilder(UserWorkloadCapabilitiesSpecFluent<?> fluent) {
    this(fluent, new UserWorkloadCapabilitiesSpec());
  }
  
  public UserWorkloadCapabilitiesSpecBuilder(UserWorkloadCapabilitiesSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserWorkloadCapabilitiesSpecBuilder(UserWorkloadCapabilitiesSpecFluent<?> fluent,UserWorkloadCapabilitiesSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserWorkloadCapabilitiesSpec build() {
    UserWorkloadCapabilitiesSpec buildable = new UserWorkloadCapabilitiesSpec(fluent.buildLogs(), fluent.buildMetrics(), fluent.buildTraces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}