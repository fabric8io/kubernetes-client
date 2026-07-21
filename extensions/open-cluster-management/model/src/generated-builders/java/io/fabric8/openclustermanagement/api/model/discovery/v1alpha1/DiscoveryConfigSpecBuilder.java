package io.fabric8.openclustermanagement.api.model.discovery.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiscoveryConfigSpecBuilder extends DiscoveryConfigSpecFluent<DiscoveryConfigSpecBuilder> implements VisitableBuilder<DiscoveryConfigSpec,DiscoveryConfigSpecBuilder>{

  DiscoveryConfigSpecFluent<?> fluent;

  public DiscoveryConfigSpecBuilder() {
    this(new DiscoveryConfigSpec());
  }
  
  public DiscoveryConfigSpecBuilder(DiscoveryConfigSpecFluent<?> fluent) {
    this(fluent, new DiscoveryConfigSpec());
  }
  
  public DiscoveryConfigSpecBuilder(DiscoveryConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiscoveryConfigSpecBuilder(DiscoveryConfigSpecFluent<?> fluent,DiscoveryConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiscoveryConfigSpec build() {
    DiscoveryConfigSpec buildable = new DiscoveryConfigSpec(fluent.getCredential(), fluent.buildFilters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}