package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserWorkloadMetricsCollectionSpecBuilder extends UserWorkloadMetricsCollectionSpecFluent<UserWorkloadMetricsCollectionSpecBuilder> implements VisitableBuilder<UserWorkloadMetricsCollectionSpec,UserWorkloadMetricsCollectionSpecBuilder>{

  UserWorkloadMetricsCollectionSpecFluent<?> fluent;

  public UserWorkloadMetricsCollectionSpecBuilder() {
    this(new UserWorkloadMetricsCollectionSpec());
  }
  
  public UserWorkloadMetricsCollectionSpecBuilder(UserWorkloadMetricsCollectionSpecFluent<?> fluent) {
    this(fluent, new UserWorkloadMetricsCollectionSpec());
  }
  
  public UserWorkloadMetricsCollectionSpecBuilder(UserWorkloadMetricsCollectionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserWorkloadMetricsCollectionSpecBuilder(UserWorkloadMetricsCollectionSpecFluent<?> fluent,UserWorkloadMetricsCollectionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserWorkloadMetricsCollectionSpec build() {
    UserWorkloadMetricsCollectionSpec buildable = new UserWorkloadMetricsCollectionSpec(fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}