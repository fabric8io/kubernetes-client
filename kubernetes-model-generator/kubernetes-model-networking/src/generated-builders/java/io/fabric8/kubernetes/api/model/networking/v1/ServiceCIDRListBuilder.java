package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCIDRListBuilder extends ServiceCIDRListFluent<ServiceCIDRListBuilder> implements VisitableBuilder<ServiceCIDRList,ServiceCIDRListBuilder>{

  ServiceCIDRListFluent<?> fluent;

  public ServiceCIDRListBuilder() {
    this(new ServiceCIDRList());
  }
  
  public ServiceCIDRListBuilder(ServiceCIDRListFluent<?> fluent) {
    this(fluent, new ServiceCIDRList());
  }
  
  public ServiceCIDRListBuilder(ServiceCIDRList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCIDRListBuilder(ServiceCIDRListFluent<?> fluent,ServiceCIDRList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCIDRList build() {
    ServiceCIDRList buildable = new ServiceCIDRList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}