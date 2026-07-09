package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCIDRBuilder extends ServiceCIDRFluent<ServiceCIDRBuilder> implements VisitableBuilder<ServiceCIDR,ServiceCIDRBuilder>{

  ServiceCIDRFluent<?> fluent;

  public ServiceCIDRBuilder() {
    this(new ServiceCIDR());
  }
  
  public ServiceCIDRBuilder(ServiceCIDRFluent<?> fluent) {
    this(fluent, new ServiceCIDR());
  }
  
  public ServiceCIDRBuilder(ServiceCIDR instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCIDRBuilder(ServiceCIDRFluent<?> fluent,ServiceCIDR instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCIDR build() {
    ServiceCIDR buildable = new ServiceCIDR(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}