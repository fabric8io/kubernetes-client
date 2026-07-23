package io.fabric8.openshift.api.model.insights.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HealthCheckBuilder extends HealthCheckFluent<HealthCheckBuilder> implements VisitableBuilder<HealthCheck,HealthCheckBuilder>{

  HealthCheckFluent<?> fluent;

  public HealthCheckBuilder() {
    this(new HealthCheck());
  }
  
  public HealthCheckBuilder(HealthCheckFluent<?> fluent) {
    this(fluent, new HealthCheck());
  }
  
  public HealthCheckBuilder(HealthCheck instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HealthCheckBuilder(HealthCheckFluent<?> fluent,HealthCheck instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HealthCheck build() {
    HealthCheck buildable = new HealthCheck(fluent.getAdvisorURI(), fluent.getDescription(), fluent.getTotalRisk());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}