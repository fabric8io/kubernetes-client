package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserWorkloadTracesSpecBuilder extends UserWorkloadTracesSpecFluent<UserWorkloadTracesSpecBuilder> implements VisitableBuilder<UserWorkloadTracesSpec,UserWorkloadTracesSpecBuilder>{

  UserWorkloadTracesSpecFluent<?> fluent;

  public UserWorkloadTracesSpecBuilder() {
    this(new UserWorkloadTracesSpec());
  }
  
  public UserWorkloadTracesSpecBuilder(UserWorkloadTracesSpecFluent<?> fluent) {
    this(fluent, new UserWorkloadTracesSpec());
  }
  
  public UserWorkloadTracesSpecBuilder(UserWorkloadTracesSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserWorkloadTracesSpecBuilder(UserWorkloadTracesSpecFluent<?> fluent,UserWorkloadTracesSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserWorkloadTracesSpec build() {
    UserWorkloadTracesSpec buildable = new UserWorkloadTracesSpec(fluent.buildCollection());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}