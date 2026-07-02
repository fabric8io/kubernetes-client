package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceAccountTokenProjectionBuilder extends ServiceAccountTokenProjectionFluent<ServiceAccountTokenProjectionBuilder> implements VisitableBuilder<ServiceAccountTokenProjection,ServiceAccountTokenProjectionBuilder>{

  ServiceAccountTokenProjectionFluent<?> fluent;

  public ServiceAccountTokenProjectionBuilder() {
    this(new ServiceAccountTokenProjection());
  }
  
  public ServiceAccountTokenProjectionBuilder(ServiceAccountTokenProjectionFluent<?> fluent) {
    this(fluent, new ServiceAccountTokenProjection());
  }
  
  public ServiceAccountTokenProjectionBuilder(ServiceAccountTokenProjection instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceAccountTokenProjectionBuilder(ServiceAccountTokenProjectionFluent<?> fluent,ServiceAccountTokenProjection instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceAccountTokenProjection build() {
    ServiceAccountTokenProjection buildable = new ServiceAccountTokenProjection(fluent.getAudience(), fluent.getExpirationSeconds(), fluent.getPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}