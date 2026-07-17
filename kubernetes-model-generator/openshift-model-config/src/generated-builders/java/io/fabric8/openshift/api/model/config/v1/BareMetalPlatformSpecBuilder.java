package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BareMetalPlatformSpecBuilder extends BareMetalPlatformSpecFluent<BareMetalPlatformSpecBuilder> implements VisitableBuilder<BareMetalPlatformSpec,BareMetalPlatformSpecBuilder>{

  BareMetalPlatformSpecFluent<?> fluent;

  public BareMetalPlatformSpecBuilder() {
    this(new BareMetalPlatformSpec());
  }
  
  public BareMetalPlatformSpecBuilder(BareMetalPlatformSpecFluent<?> fluent) {
    this(fluent, new BareMetalPlatformSpec());
  }
  
  public BareMetalPlatformSpecBuilder(BareMetalPlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BareMetalPlatformSpecBuilder(BareMetalPlatformSpecFluent<?> fluent,BareMetalPlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BareMetalPlatformSpec build() {
    BareMetalPlatformSpec buildable = new BareMetalPlatformSpec(fluent.getApiServerInternalIPs(), fluent.getIngressIPs(), fluent.getMachineNetworks());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}