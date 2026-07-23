package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CapabilitiesSpecBuilder extends CapabilitiesSpecFluent<CapabilitiesSpecBuilder> implements VisitableBuilder<CapabilitiesSpec,CapabilitiesSpecBuilder>{

  CapabilitiesSpecFluent<?> fluent;

  public CapabilitiesSpecBuilder() {
    this(new CapabilitiesSpec());
  }
  
  public CapabilitiesSpecBuilder(CapabilitiesSpecFluent<?> fluent) {
    this(fluent, new CapabilitiesSpec());
  }
  
  public CapabilitiesSpecBuilder(CapabilitiesSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CapabilitiesSpecBuilder(CapabilitiesSpecFluent<?> fluent,CapabilitiesSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CapabilitiesSpec build() {
    CapabilitiesSpec buildable = new CapabilitiesSpec(fluent.buildPlatform(), fluent.buildUserWorkloads());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}