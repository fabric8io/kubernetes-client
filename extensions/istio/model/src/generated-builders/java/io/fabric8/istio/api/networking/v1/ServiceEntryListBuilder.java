package io.fabric8.istio.api.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceEntryListBuilder extends ServiceEntryListFluent<ServiceEntryListBuilder> implements VisitableBuilder<ServiceEntryList,ServiceEntryListBuilder>{

  ServiceEntryListFluent<?> fluent;

  public ServiceEntryListBuilder() {
    this(new ServiceEntryList());
  }
  
  public ServiceEntryListBuilder(ServiceEntryListFluent<?> fluent) {
    this(fluent, new ServiceEntryList());
  }
  
  public ServiceEntryListBuilder(ServiceEntryList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceEntryListBuilder(ServiceEntryListFluent<?> fluent,ServiceEntryList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceEntryList build() {
    ServiceEntryList buildable = new ServiceEntryList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}