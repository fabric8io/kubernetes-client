package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSpherePlatformNodeNetworkingSpecBuilder extends VSpherePlatformNodeNetworkingSpecFluent<VSpherePlatformNodeNetworkingSpecBuilder> implements VisitableBuilder<VSpherePlatformNodeNetworkingSpec,VSpherePlatformNodeNetworkingSpecBuilder>{

  VSpherePlatformNodeNetworkingSpecFluent<?> fluent;

  public VSpherePlatformNodeNetworkingSpecBuilder() {
    this(new VSpherePlatformNodeNetworkingSpec());
  }
  
  public VSpherePlatformNodeNetworkingSpecBuilder(VSpherePlatformNodeNetworkingSpecFluent<?> fluent) {
    this(fluent, new VSpherePlatformNodeNetworkingSpec());
  }
  
  public VSpherePlatformNodeNetworkingSpecBuilder(VSpherePlatformNodeNetworkingSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSpherePlatformNodeNetworkingSpecBuilder(VSpherePlatformNodeNetworkingSpecFluent<?> fluent,VSpherePlatformNodeNetworkingSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSpherePlatformNodeNetworkingSpec build() {
    VSpherePlatformNodeNetworkingSpec buildable = new VSpherePlatformNodeNetworkingSpec(fluent.getExcludeNetworkSubnetCidr(), fluent.getNetwork(), fluent.getNetworkSubnetCidr());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}