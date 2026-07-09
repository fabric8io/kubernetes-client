package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCIDRSpecBuilder extends ServiceCIDRSpecFluent<ServiceCIDRSpecBuilder> implements VisitableBuilder<ServiceCIDRSpec,ServiceCIDRSpecBuilder>{

  ServiceCIDRSpecFluent<?> fluent;

  public ServiceCIDRSpecBuilder() {
    this(new ServiceCIDRSpec());
  }
  
  public ServiceCIDRSpecBuilder(ServiceCIDRSpecFluent<?> fluent) {
    this(fluent, new ServiceCIDRSpec());
  }
  
  public ServiceCIDRSpecBuilder(ServiceCIDRSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCIDRSpecBuilder(ServiceCIDRSpecFluent<?> fluent,ServiceCIDRSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCIDRSpec build() {
    ServiceCIDRSpec buildable = new ServiceCIDRSpec(fluent.getCidrs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}