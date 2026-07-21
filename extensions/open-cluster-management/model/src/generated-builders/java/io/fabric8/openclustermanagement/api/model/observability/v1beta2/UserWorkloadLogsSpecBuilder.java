package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserWorkloadLogsSpecBuilder extends UserWorkloadLogsSpecFluent<UserWorkloadLogsSpecBuilder> implements VisitableBuilder<UserWorkloadLogsSpec,UserWorkloadLogsSpecBuilder>{

  UserWorkloadLogsSpecFluent<?> fluent;

  public UserWorkloadLogsSpecBuilder() {
    this(new UserWorkloadLogsSpec());
  }
  
  public UserWorkloadLogsSpecBuilder(UserWorkloadLogsSpecFluent<?> fluent) {
    this(fluent, new UserWorkloadLogsSpec());
  }
  
  public UserWorkloadLogsSpecBuilder(UserWorkloadLogsSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserWorkloadLogsSpecBuilder(UserWorkloadLogsSpecFluent<?> fluent,UserWorkloadLogsSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserWorkloadLogsSpec build() {
    UserWorkloadLogsSpec buildable = new UserWorkloadLogsSpec(fluent.buildCollection());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}