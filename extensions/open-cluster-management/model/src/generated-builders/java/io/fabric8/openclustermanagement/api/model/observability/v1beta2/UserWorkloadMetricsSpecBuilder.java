package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserWorkloadMetricsSpecBuilder extends UserWorkloadMetricsSpecFluent<UserWorkloadMetricsSpecBuilder> implements VisitableBuilder<UserWorkloadMetricsSpec,UserWorkloadMetricsSpecBuilder>{

  UserWorkloadMetricsSpecFluent<?> fluent;

  public UserWorkloadMetricsSpecBuilder() {
    this(new UserWorkloadMetricsSpec());
  }
  
  public UserWorkloadMetricsSpecBuilder(UserWorkloadMetricsSpecFluent<?> fluent) {
    this(fluent, new UserWorkloadMetricsSpec());
  }
  
  public UserWorkloadMetricsSpecBuilder(UserWorkloadMetricsSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserWorkloadMetricsSpecBuilder(UserWorkloadMetricsSpecFluent<?> fluent,UserWorkloadMetricsSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserWorkloadMetricsSpec build() {
    UserWorkloadMetricsSpec buildable = new UserWorkloadMetricsSpec(fluent.buildCollection());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}