package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceAccountIssuerStatusBuilder extends ServiceAccountIssuerStatusFluent<ServiceAccountIssuerStatusBuilder> implements VisitableBuilder<ServiceAccountIssuerStatus,ServiceAccountIssuerStatusBuilder>{

  ServiceAccountIssuerStatusFluent<?> fluent;

  public ServiceAccountIssuerStatusBuilder() {
    this(new ServiceAccountIssuerStatus());
  }
  
  public ServiceAccountIssuerStatusBuilder(ServiceAccountIssuerStatusFluent<?> fluent) {
    this(fluent, new ServiceAccountIssuerStatus());
  }
  
  public ServiceAccountIssuerStatusBuilder(ServiceAccountIssuerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceAccountIssuerStatusBuilder(ServiceAccountIssuerStatusFluent<?> fluent,ServiceAccountIssuerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceAccountIssuerStatus build() {
    ServiceAccountIssuerStatus buildable = new ServiceAccountIssuerStatus(fluent.getExpirationTime(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}