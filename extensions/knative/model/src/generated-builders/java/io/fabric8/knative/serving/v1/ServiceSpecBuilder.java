package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceSpecBuilder extends ServiceSpecFluent<ServiceSpecBuilder> implements VisitableBuilder<ServiceSpec,ServiceSpecBuilder>{

  ServiceSpecFluent<?> fluent;

  public ServiceSpecBuilder() {
    this(new ServiceSpec());
  }
  
  public ServiceSpecBuilder(ServiceSpecFluent<?> fluent) {
    this(fluent, new ServiceSpec());
  }
  
  public ServiceSpecBuilder(ServiceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceSpecBuilder(ServiceSpecFluent<?> fluent,ServiceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceSpec build() {
    ServiceSpec buildable = new ServiceSpec(fluent.buildTemplate(), fluent.buildTraffic());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}