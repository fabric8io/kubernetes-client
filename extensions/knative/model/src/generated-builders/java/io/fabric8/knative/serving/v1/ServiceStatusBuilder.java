package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceStatusBuilder extends ServiceStatusFluent<ServiceStatusBuilder> implements VisitableBuilder<ServiceStatus,ServiceStatusBuilder>{

  ServiceStatusFluent<?> fluent;

  public ServiceStatusBuilder() {
    this(new ServiceStatus());
  }
  
  public ServiceStatusBuilder(ServiceStatusFluent<?> fluent) {
    this(fluent, new ServiceStatus());
  }
  
  public ServiceStatusBuilder(ServiceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceStatusBuilder(ServiceStatusFluent<?> fluent,ServiceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceStatus build() {
    ServiceStatus buildable = new ServiceStatus(fluent.buildAddress(), fluent.getAnnotations(), fluent.buildConditions(), fluent.getLatestCreatedRevisionName(), fluent.getLatestReadyRevisionName(), fluent.getObservedGeneration(), fluent.buildTraffic(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}