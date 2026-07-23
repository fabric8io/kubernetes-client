package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServicePortBuilder extends ServicePortFluent<ServicePortBuilder> implements VisitableBuilder<ServicePort,ServicePortBuilder>{

  ServicePortFluent<?> fluent;

  public ServicePortBuilder() {
    this(new ServicePort());
  }
  
  public ServicePortBuilder(ServicePortFluent<?> fluent) {
    this(fluent, new ServicePort());
  }
  
  public ServicePortBuilder(ServicePort instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServicePortBuilder(ServicePortFluent<?> fluent,ServicePort instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServicePort build() {
    ServicePort buildable = new ServicePort(fluent.getName(), fluent.getNumber(), fluent.getProtocol(), fluent.getTargetPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}