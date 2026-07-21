package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceEntryStatusBuilder extends ServiceEntryStatusFluent<ServiceEntryStatusBuilder> implements VisitableBuilder<ServiceEntryStatus,ServiceEntryStatusBuilder>{

  ServiceEntryStatusFluent<?> fluent;

  public ServiceEntryStatusBuilder() {
    this(new ServiceEntryStatus());
  }
  
  public ServiceEntryStatusBuilder(ServiceEntryStatusFluent<?> fluent) {
    this(fluent, new ServiceEntryStatus());
  }
  
  public ServiceEntryStatusBuilder(ServiceEntryStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceEntryStatusBuilder(ServiceEntryStatusFluent<?> fluent,ServiceEntryStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceEntryStatus build() {
    ServiceEntryStatus buildable = new ServiceEntryStatus(fluent.buildAddresses(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.buildValidationMessages());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}