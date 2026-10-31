package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserWorkloadMetricsDefaultSpecBuilder extends UserWorkloadMetricsDefaultSpecFluent<UserWorkloadMetricsDefaultSpecBuilder> implements VisitableBuilder<UserWorkloadMetricsDefaultSpec,UserWorkloadMetricsDefaultSpecBuilder>{

  UserWorkloadMetricsDefaultSpecFluent<?> fluent;

  public UserWorkloadMetricsDefaultSpecBuilder() {
    this(new UserWorkloadMetricsDefaultSpec());
  }
  
  public UserWorkloadMetricsDefaultSpecBuilder(UserWorkloadMetricsDefaultSpecFluent<?> fluent) {
    this(fluent, new UserWorkloadMetricsDefaultSpec());
  }
  
  public UserWorkloadMetricsDefaultSpecBuilder(UserWorkloadMetricsDefaultSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserWorkloadMetricsDefaultSpecBuilder(UserWorkloadMetricsDefaultSpecFluent<?> fluent,UserWorkloadMetricsDefaultSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserWorkloadMetricsDefaultSpec build() {
    UserWorkloadMetricsDefaultSpec buildable = new UserWorkloadMetricsDefaultSpec(fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}