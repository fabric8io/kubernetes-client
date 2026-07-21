package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceAccountRefBuilder extends ServiceAccountRefFluent<ServiceAccountRefBuilder> implements VisitableBuilder<ServiceAccountRef,ServiceAccountRefBuilder>{

  ServiceAccountRefFluent<?> fluent;

  public ServiceAccountRefBuilder() {
    this(new ServiceAccountRef());
  }
  
  public ServiceAccountRefBuilder(ServiceAccountRefFluent<?> fluent) {
    this(fluent, new ServiceAccountRef());
  }
  
  public ServiceAccountRefBuilder(ServiceAccountRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceAccountRefBuilder(ServiceAccountRefFluent<?> fluent,ServiceAccountRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceAccountRef build() {
    ServiceAccountRef buildable = new ServiceAccountRef(fluent.getAudiences(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}