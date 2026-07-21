package io.fabric8.istio.api.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceEntryBuilder extends ServiceEntryFluent<ServiceEntryBuilder> implements VisitableBuilder<ServiceEntry,ServiceEntryBuilder>{

  ServiceEntryFluent<?> fluent;

  public ServiceEntryBuilder() {
    this(new ServiceEntry());
  }
  
  public ServiceEntryBuilder(ServiceEntryFluent<?> fluent) {
    this(fluent, new ServiceEntry());
  }
  
  public ServiceEntryBuilder(ServiceEntry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceEntryBuilder(ServiceEntryFluent<?> fluent,ServiceEntry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceEntry build() {
    ServiceEntry buildable = new ServiceEntry(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}