package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceBackendPortBuilder extends ServiceBackendPortFluent<ServiceBackendPortBuilder> implements VisitableBuilder<ServiceBackendPort,ServiceBackendPortBuilder>{

  ServiceBackendPortFluent<?> fluent;

  public ServiceBackendPortBuilder() {
    this(new ServiceBackendPort());
  }
  
  public ServiceBackendPortBuilder(ServiceBackendPortFluent<?> fluent) {
    this(fluent, new ServiceBackendPort());
  }
  
  public ServiceBackendPortBuilder(ServiceBackendPort instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceBackendPortBuilder(ServiceBackendPortFluent<?> fluent,ServiceBackendPort instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceBackendPort build() {
    ServiceBackendPort buildable = new ServiceBackendPort(fluent.getName(), fluent.getNumber());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}