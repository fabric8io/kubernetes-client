package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceBuilder extends ServiceFluent<ServiceBuilder> implements VisitableBuilder<Service,ServiceBuilder>{

  ServiceFluent<?> fluent;

  public ServiceBuilder() {
    this(new Service());
  }
  
  public ServiceBuilder(ServiceFluent<?> fluent) {
    this(fluent, new Service());
  }
  
  public ServiceBuilder(Service instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceBuilder(ServiceFluent<?> fluent,Service instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Service build() {
    Service buildable = new Service(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}