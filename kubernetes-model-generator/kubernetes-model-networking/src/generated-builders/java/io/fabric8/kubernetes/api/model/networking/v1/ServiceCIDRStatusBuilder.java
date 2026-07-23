package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCIDRStatusBuilder extends ServiceCIDRStatusFluent<ServiceCIDRStatusBuilder> implements VisitableBuilder<ServiceCIDRStatus,ServiceCIDRStatusBuilder>{

  ServiceCIDRStatusFluent<?> fluent;

  public ServiceCIDRStatusBuilder() {
    this(new ServiceCIDRStatus());
  }
  
  public ServiceCIDRStatusBuilder(ServiceCIDRStatusFluent<?> fluent) {
    this(fluent, new ServiceCIDRStatus());
  }
  
  public ServiceCIDRStatusBuilder(ServiceCIDRStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCIDRStatusBuilder(ServiceCIDRStatusFluent<?> fluent,ServiceCIDRStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCIDRStatus build() {
    ServiceCIDRStatus buildable = new ServiceCIDRStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}