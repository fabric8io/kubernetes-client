package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSpherePlatformSpecBuilder extends VSpherePlatformSpecFluent<VSpherePlatformSpecBuilder> implements VisitableBuilder<VSpherePlatformSpec,VSpherePlatformSpecBuilder>{

  VSpherePlatformSpecFluent<?> fluent;

  public VSpherePlatformSpecBuilder() {
    this(new VSpherePlatformSpec());
  }
  
  public VSpherePlatformSpecBuilder(VSpherePlatformSpecFluent<?> fluent) {
    this(fluent, new VSpherePlatformSpec());
  }
  
  public VSpherePlatformSpecBuilder(VSpherePlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSpherePlatformSpecBuilder(VSpherePlatformSpecFluent<?> fluent,VSpherePlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSpherePlatformSpec build() {
    VSpherePlatformSpec buildable = new VSpherePlatformSpec(fluent.getApiServerInternalIPs(), fluent.buildFailureDomains(), fluent.getIngressIPs(), fluent.getMachineNetworks(), fluent.buildNodeNetworking(), fluent.buildVcenters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}