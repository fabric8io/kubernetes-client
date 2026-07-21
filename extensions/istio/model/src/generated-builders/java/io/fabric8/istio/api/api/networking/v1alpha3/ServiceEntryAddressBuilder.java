package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceEntryAddressBuilder extends ServiceEntryAddressFluent<ServiceEntryAddressBuilder> implements VisitableBuilder<ServiceEntryAddress,ServiceEntryAddressBuilder>{

  ServiceEntryAddressFluent<?> fluent;

  public ServiceEntryAddressBuilder() {
    this(new ServiceEntryAddress());
  }
  
  public ServiceEntryAddressBuilder(ServiceEntryAddressFluent<?> fluent) {
    this(fluent, new ServiceEntryAddress());
  }
  
  public ServiceEntryAddressBuilder(ServiceEntryAddress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceEntryAddressBuilder(ServiceEntryAddressFluent<?> fluent,ServiceEntryAddress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceEntryAddress build() {
    ServiceEntryAddress buildable = new ServiceEntryAddress(fluent.getHost(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}